package com.tersesystems.jcakeyfailure;

import com.tersesystems.securitybuilder.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.security.interfaces.DSAPrivateKey;
import java.time.Duration;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class JcaKeyFailure {

    public static void main(String[] args) throws Exception {
        JcaKeyFailure instance = new JcaKeyFailure();
        System.out.println(instance.testSystem());
    }

  public Key testSystem() throws Exception {
      // Set our keystore as the system keystore.
      final char[] password = "".toCharArray();
      final KeyStore keyStore = generateStore(password);
      require(keyStore.size() == 2);
      printAliases(keyStore);
      final Path tempPath = Files.createTempFile(null, null);
      keyStore.store(new FileOutputStream(tempPath.toFile()), password);

      // Now that we've written out the keystore to the filesystem, we can set
      // some system properties and read it in as the default keystore :-)
      final Properties properties = new Properties();
      properties.setProperty("javax.net.ssl.keyStore", tempPath.toAbsolutePath().toString());
      properties.setProperty("javax.net.ssl.keyStoreType", keyStore.getType());
      properties.setProperty("javax.net.ssl.keyStorePassword", new String(password));
      System.setProperties(properties);
      // Check this got set correctly...
      require(System.getProperty("javax.net.ssl.keyStore").equals(tempPath.toAbsolutePath().toString()));

      /// Now that we have the properties set
      final KeyStore systemKeyStore = getKeyStore();
      printAliases(systemKeyStore);

      // This works fine...
      final Key rsakey = systemKeyStore.getKey("rsaentry", null);

      // This dies with "invalid null input"
      //      Exception in thread "main" java.lang.NullPointerException: invalid null input
      //      at java.base/java.security.KeyStore$PrivateKeyEntry.<init>(KeyStore.java:532)
      //      at java.base/sun.security.pkcs12.PKCS12KeyStore.engineGetEntry(PKCS12KeyStore.java:1346)
      //      at java.base/sun.security.util.KeyStoreDelegator.engineGetEntry(KeyStoreDelegator.java:166)
      //      at java.base/java.security.KeyStore.getEntry(KeyStore.java:1548)
      //      at com.tersesystems.jcakeyfailure.JcaKeyFailure.testSystem(JcaKeyFailure.java:54)
      //      at com.tersesystems.jcakeyfailure.JcaKeyFailure.main(JcaKeyFailure.java:26)
      final KeyStore.ProtectionParameter passwordParam = new KeyStore.PasswordProtection("".toCharArray());
      final KeyStore.Entry rsaentry = systemKeyStore.getEntry("rsaentry", passwordParam);
      require(rsaentry != null);
      return rsakey;
  }

    private void require(boolean b) {
        if (!b) {
            throw new IllegalStateException();
        }
    }

    private void printAliases(KeyStore keyStore1) throws KeyStoreException {
        final Enumeration<String> aliases = keyStore1.aliases();
        while (aliases.hasMoreElements()) {
            String s = aliases.nextElement();
            System.out.println(s);
        }
    }

    public static KeyStore getKeyStore() throws Exception {
        final String NONE = "NONE";

        final Map<String, String> props = new HashMap<>();
        AccessController.doPrivileged(
                (PrivilegedExceptionAction<Object>)
                        () -> {
                            props.put("getKeyStore", System.getProperty("javax.net.ssl.keyStore", ""));
                            props.put(
                                    "keyStoreType",
                                    System.getProperty("javax.net.ssl.keyStoreType", KeyStore.getDefaultType()));
                            props.put(
                                    "keyStoreProvider", System.getProperty("javax.net.ssl.keyStoreProvider", ""));
                            props.put("keyStorePasswd", System.getProperty("javax.net.ssl.keyStorePassword", ""));
                            return null;
                        });

        final String defaultKeyStore = props.get("getKeyStore");
        final String defaultKeyStoreType = props.get("keyStoreType");
        final String defaultKeyStoreProvider = props.get("keyStoreProvider");

        InputStream fs = null;
        KeyStore ks = null;
        char[] passwd = null;
        try {
            if (defaultKeyStore.length() != 0 && !NONE.equals(defaultKeyStore)) {
                FileSystem fileSystem = FileSystems.getDefault();
                fs =
                        AccessController.doPrivileged(
                                (PrivilegedExceptionAction<InputStream>)
                                        () -> Files.newInputStream(fileSystem.getPath(defaultKeyStore)));
            }

            final String defaultKeyStorePassword = props.get("keyStorePasswd");
            if (defaultKeyStorePassword.length() != 0) {
                passwd = defaultKeyStorePassword.toCharArray();
            }

            /* Try to initialize key store. */
            if ((defaultKeyStoreType.length()) != 0) {
                if (defaultKeyStoreProvider.length() == 0) {
                    ks = KeyStore.getInstance(defaultKeyStoreType);
                } else {
                    ks = KeyStore.getInstance(defaultKeyStoreType, defaultKeyStoreProvider);
                }

                // if defaultKeyStore is NONE, fs will be null
                ks.load(fs, passwd);
            }

            return (ks == null) ? KeyStoreBuilder.empty() : ks;
        } finally {
            if (fs != null) {
                fs.close();
                fs = null;
            }
        }
    }

    private KeyStore generateStore(final char[] password)
            throws GeneralSecurityException, IOException {
        final RSAKeyPair rsaKeyPair = (KeyPairCreator.creator().withRSA().withKeySize(2048).create());
        final DSAKeyPair dsaKeyPair = (KeyPairCreator.creator().withDSA().withKeySize(1024).create());

        final X509Certificate rsaCertificate =
                X509CertificateCreator.creator()
                        .withSHA256withRSA()
                        .withDuration(Duration.ofDays(365))
                        .withRootCA("CN=example.com", rsaKeyPair, 2)
                        .create();

        final X509Certificate dsaCertificate =
                X509CertificateCreator.creator()
                        .<DSAPrivateKey>withSignatureAlgorithm("SHA256withDSA")
                        .withDuration(Duration.ofDays(365))
                        .withRootCA("CN=example.com", dsaKeyPair, 2)
                        .create();

        final KeyStore pkcs12 = KeyStore.getInstance(KeyStore.getDefaultType());
        pkcs12.load(null);

        pkcs12.setKeyEntry(
                "rsaentry", rsaKeyPair.getPrivate(), password, new Certificate[] {rsaCertificate});
        pkcs12.setKeyEntry(
                "dsaentry", dsaKeyPair.getPrivate(), password, new Certificate[] {dsaCertificate});

        return pkcs12;
    }
}
