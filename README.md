# JCA Key Failure

## Usage

To run with full logging, you must first run `gradlew installDist` which will create a script with the agent in the appropriate place in the command line.

```
./gradlew installDist
cd build/install/jca-key-failure
./bin/jca-key-failure
```

## Output

```
FowdlETwB0U6O0Qbm7EAAA 15:48:46.650 [INFO ] c.t.j.JcaKeyFailure -  Starting Logback
FowdlETwB9mdHaINzdiAAA 15:48:46.825 [TRACE] j.s.KeyStore -  entering: java.security.KeyStore.getDefaultType() with arguments=[] from source KeyStore.java:992
FowdlETwB9ydHaINzdiAAA 15:48:46.830 [TRACE] j.s.KeyStore -  exiting: java.security.KeyStore.getDefaultType() with arguments=[] => (return_type=java.lang.String return_value=pkcs12) from source KeyStore.java:1000
FowdlETwB9ydHaINzdiAAB 15:48:46.831 [TRACE] j.s.KeyStore -  entering: java.security.KeyStore.getInstance(java.lang.String) with arguments=[pkcs12] from source KeyStore.java:866
FowdlETwB94dHaINzdiAAA 15:48:46.833 [TRACE] j.s.KeyStore -  exiting: java.security.KeyStore.getInstance(java.lang.String) with arguments=[pkcs12] => (return_type=java.security.KeyStore return_value=java.security.KeyStore@773bd77b) from source KeyStore.java:873
FowdlETwB94dHaINzdiAAB 15:48:46.834 [TRACE] j.s.KeyStore -  entering: java.security.KeyStore.load(java.security.KeyStore$LoadStoreParameter) with arguments=[null] from source KeyStore.java:1506
FowdlETwB96dHaINzdiAAA 15:48:46.835 [TRACE] j.s.KeyStore -  exiting: java.security.KeyStore.load(java.security.KeyStore$LoadStoreParameter) with arguments=[null] => (return_type=void return_value=null) from source KeyStore.java:1508
FowdlETwB99OjtEG5uxAAA 15:48:46.837 [TRACE] j.s.KeyStore -  entering: java.security.KeyStore.setKeyEntry(java.lang.String,java.security.Key,[C,[Ljava.security.cert.Certificate;) with arguments=[rsaentry, SunRsaSign RSA private CRT key, 2048 bits
  params: null
  modulus: 16203557191767681330138456275032636312287276928702455473879544494481012979891285979039125214611893351277113179328595672911137165278150446011234870145312938888175088357689624043146091805742383045363881036474627042866416723367160267799803785570079615560858457887732828794058892576945493476466971268912181212324220595529007302402827691286193810967756311528061387014450725632854083481439851097553928305248710325666503755617166024430516292319139997991589942552483158738400586506246946373501737220455516718464564114745313163912138064254478418347998196236453324251287039914924744910729363704240809993662855892176565439819417
  private exponent: 4321311207374697259382637880510557661567618691118933072500521517227507283863159686004025672535921265752496820853948077744493269065283938773278652675584472067496592677658410501336762326331162104870072062430436722084001884294539377154965447978910409704024964935254808454194749904021443382847700136381694359354227937509221409363537264418842985162361346649299682965291071732345638344443221649712100375247504751874160807041259766287796896521044526743574564618042110175258515272931418641175211982498606683047493686737655697867206943045618117445930452114437826000568551007874657482069726209706716152683624781607872934635353, [C@6d91790b, X509Certificate(serialNumber = 51635fd447296114, subject = CN=example.com)] from source KeyStore.java:1158
FowdlETwCDk6O0Qbm7EAAA 15:48:46.895 [TRACE] j.s.KeyStore -  exiting: java.security.KeyStore.setKeyEntry(java.lang.String,java.security.Key,[C,[Ljava.security.cert.Certificate;) with arguments=[rsaentry, SunRsaSign RSA private CRT key, 2048 bits
  params: null
  modulus: 16203557191767681330138456275032636312287276928702455473879544494481012979891285979039125214611893351277113179328595672911137165278150446011234870145312938888175088357689624043146091805742383045363881036474627042866416723367160267799803785570079615560858457887732828794058892576945493476466971268912181212324220595529007302402827691286193810967756311528061387014450725632854083481439851097553928305248710325666503755617166024430516292319139997991589942552483158738400586506246946373501737220455516718464564114745313163912138064254478418347998196236453324251287039914924744910729363704240809993662855892176565439819417
  private exponent: 4321311207374697259382637880510557661567618691118933072500521517227507283863159686004025672535921265752496820853948077744493269065283938773278652675584472067496592677658410501336762326331162104870072062430436722084001884294539377154965447978910409704024964935254808454194749904021443382847700136381694359354227937509221409363537264418842985162361346649299682965291071732345638344443221649712100375247504751874160807041259766287796896521044526743574564618042110175258515272931418641175211982498606683047493686737655697867206943045618117445930452114437826000568551007874657482069726209706716152683624781607872934635353, [C@6d91790b, X509Certificate(serialNumber = 51635fd447296114, subject = CN=example.com)] => (return_type=void return_value=null) from source KeyStore.java:1168
FowdlETwCDo6O0Qbm7EAAA 15:48:46.895 [TRACE] j.s.KeyStore -  entering: java.security.KeyStore.size() with arguments=[] from source KeyStore.java:1295
FowdlETwCDo6O0Qbm7EAAB 15:48:46.896 [TRACE] j.s.KeyStore -  exiting: java.security.KeyStore.size() with arguments=[] => (return_type=int return_value=1) from source KeyStore.java:1298
FowdlETwCDs6O0Qbm7EAAA 15:48:46.897 [TRACE] j.s.KeyStore -  entering: java.security.KeyStore.aliases() with arguments=[] from source KeyStore.java:1259
FowdlETwCDw6O0Qbm7EAAA 15:48:46.897 [TRACE] j.s.KeyStore -  exiting: java.security.KeyStore.aliases() with arguments=[] => (return_type=java.util.Enumeration return_value=java.util.Collections$3@f9b5552) from source KeyStore.java:1262
FowdlETwCD06O0Qbm7EAAA 15:48:46.898 [INFO ] c.t.j.JcaKeyFailure -  alias = rsaentry
FowdlETwCD06O0Qbm7EAAB 15:48:46.899 [TRACE] j.s.KeyStore -  entering: java.security.KeyStore.getKey(java.lang.String,[C) with arguments=[rsaentry, null] from source KeyStore.java:1047
FowdlETwCGI6O0Qbm7EAAA 15:48:46.936 [TRACE] j.s.KeyStore -  exiting: java.security.KeyStore.getKey(java.lang.String,[C) with arguments=[rsaentry, null] => (return_type=java.security.Key return_value=SunRsaSign RSA private CRT key, 2048 bits
  params: null
  modulus: 16203557191767681330138456275032636312287276928702455473879544494481012979891285979039125214611893351277113179328595672911137165278150446011234870145312938888175088357689624043146091805742383045363881036474627042866416723367160267799803785570079615560858457887732828794058892576945493476466971268912181212324220595529007302402827691286193810967756311528061387014450725632854083481439851097553928305248710325666503755617166024430516292319139997991589942552483158738400586506246946373501737220455516718464564114745313163912138064254478418347998196236453324251287039914924744910729363704240809993662855892176565439819417
  private exponent: 4321311207374697259382637880510557661567618691118933072500521517227507283863159686004025672535921265752496820853948077744493269065283938773278652675584472067496592677658410501336762326331162104870072062430436722084001884294539377154965447978910409704024964935254808454194749904021443382847700136381694359354227937509221409363537264418842985162361346649299682965291071732345638344443221649712100375247504751874160807041259766287796896521044526743574564618042110175258515272931418641175211982498606683047493686737655697867206943045618117445930452114437826000568551007874657482069726209706716152683624781607872934635353) from source KeyStore.java:1050
FowdlETwCGM6O0Qbm7EAAA 15:48:46.937 [TRACE] j.s.KeyStore -  entering: java.security.KeyStore.getEntry(java.lang.String,java.security.KeyStore$ProtectionParameter) with arguments=[rsaentry, java.security.KeyStore$PasswordProtection@6df7988f] from source KeyStore.java:1542
FowdlETwCI46O0Qbm7EAAA 15:48:46.980 [TRACE] j.s.KeyStore -  exiting: java.security.KeyStore.getEntry(java.lang.String,java.security.KeyStore$ProtectionParameter) with arguments=[rsaentry, java.security.KeyStore$PasswordProtection@6df7988f] => (return_type=java.security.KeyStore$Entry return_value=Private key entry and certificate chain with 1 elements:
[
[
  Version: V3
  Subject: CN=example.com
  Signature Algorithm: SHA256withRSA, OID = 1.2.840.113549.1.1.11

  Key:  Sun RSA public key, 2048 bits
  params: null
  modulus: 16203557191767681330138456275032636312287276928702455473879544494481012979891285979039125214611893351277113179328595672911137165278150446011234870145312938888175088357689624043146091805742383045363881036474627042866416723367160267799803785570079615560858457887732828794058892576945493476466971268912181212324220595529007302402827691286193810967756311528061387014450725632854083481439851097553928305248710325666503755617166024430516292319139997991589942552483158738400586506246946373501737220455516718464564114745313163912138064254478418347998196236453324251287039914924744910729363704240809993662855892176565439819417
  public exponent: 65537
  Validity: [From: Sat Jun 26 15:48:46 PDT 2021,
               To: Sun Jun 26 15:48:46 PDT 2022]
  Issuer: CN=example.com
  SerialNumber: [    51635fd4 47296114]

Certificate Extensions: 2
[1]: ObjectId: 2.5.29.19 Criticality=true
BasicConstraints:[
  CA:true
  PathLen:2
]

[2]: ObjectId: 2.5.29.15 Criticality=true
KeyUsage [
  Key_CertSign
]

]
  Algorithm: [SHA256withRSA]
  Signature:
0000: 1E C4 74 B5 3B 59 2E E0   2D C5 14 8D 18 6E 17 33  ..t.;Y..-....n.3
0010: 5D CC 77 53 6B 2F 15 FD   DF F7 98 3E 5C 7C AE 09  ].wSk/.....>\...
0020: 41 82 48 3C 26 90 40 59   9C C6 6F 0E CE 9C C4 A2  A.H<&.@Y..o.....
0030: D9 B6 01 8C B1 CC A7 23   F0 7C 1C 7C F2 EE D5 10  .......#........
0040: 43 02 B1 B9 B9 BE 72 86   29 DA 00 CB 7E BE 61 9F  C.....r.).....a.
0050: 15 67 01 B8 26 C2 96 A3   FE 5E C1 44 7F E7 87 0A  .g..&....^.D....
0060: 95 D4 2E 77 72 0F C6 43   98 2F 6C 65 B6 A2 64 47  ...wr..C./le..dG
0070: EB 2B 46 2F 34 53 9A 26   BC 66 07 67 06 AD 96 5D  .+F/4S.&.f.g...]
0080: AC 78 7B 32 0F B9 E5 63   6D 50 A6 1E AD DB 7F E1  .x.2...cmP......
0090: 21 37 42 62 42 2D 8F 1B   AF 8A 49 4C 40 9C DE FD  !7BbB-....IL@...
00A0: 05 74 84 12 69 4E 94 EB   EF 37 5B 81 BD A4 06 90  .t..iN...7[.....
00B0: CE 29 7F F3 F4 E6 C8 58   AA F9 F6 EB B3 97 10 94  .).....X........
00C0: E8 BB 5F A8 90 90 73 11   D8 C1 C8 C8 11 F1 E7 AC  .._...s.........
00D0: 95 1D E1 D3 74 B9 66 88   E2 13 92 90 80 3D 61 0A  ....t.f......=a.
00E0: 7E 50 A8 C9 BF EB 37 4C   92 EC B6 D2 19 53 AB 9B  .P....7L.....S..
00F0: 37 47 8A 50 60 53 04 AE   FA B8 24 24 36 25 01 61  7G.P`S....$$6%.a

]
) from source KeyStore.java:1548
FowdlETwCJA6O0Qbm7EAAA 15:48:46.981 [TRACE] j.s.KeyStore -  entering: java.security.KeyStore.store(java.io.OutputStream,[C) with arguments=[java.io.FileOutputStream@1c025cb, [C@6d91790b] from source KeyStore.java:1401
FowdlETwCL8dHaINzdiAAA 15:48:47.028 [TRACE] j.s.KeyStore -  exiting: java.security.KeyStore.store(java.io.OutputStream,[C) with arguments=[java.io.FileOutputStream@1c025cb, [C@6d91790b] => (return_type=void return_value=null) from source KeyStore.java:1405
FowdlETwCL8dHaINzdiAAB 15:48:47.029 [TRACE] j.s.KeyStore -  entering: java.security.KeyStore.getType() with arguments=[] from source KeyStore.java:1020
FowdlETwCMA6O0Qbm7EAAA 15:48:47.029 [TRACE] j.s.KeyStore -  exiting: java.security.KeyStore.getType() with arguments=[] => (return_type=java.lang.String return_value=pkcs12) from source KeyStore.java:1020
FowdlETwCMI6O0Qbm7EAAA 15:48:47.031 [TRACE] j.s.KeyStore -  entering: java.security.KeyStore.getDefaultType() with arguments=[] from source KeyStore.java:992
FowdlETwCMI6O0Qbm7EAAB 15:48:47.032 [TRACE] j.s.KeyStore -  exiting: java.security.KeyStore.getDefaultType() with arguments=[] => (return_type=java.lang.String return_value=pkcs12) from source KeyStore.java:1000
FowdlETwCMM6O0Qbm7EAAA 15:48:47.033 [TRACE] j.s.KeyStore -  entering: java.security.KeyStore.getInstance(java.lang.String) with arguments=[pkcs12] from source KeyStore.java:866
FowdlETwCMQ6O0Qbm7EAAA 15:48:47.033 [TRACE] j.s.KeyStore -  exiting: java.security.KeyStore.getInstance(java.lang.String) with arguments=[pkcs12] => (return_type=java.security.KeyStore return_value=java.security.KeyStore@9a7a808) from source KeyStore.java:873
FowdlETwCMU6O0Qbm7EAAA 15:48:47.035 [TRACE] j.s.KeyStore -  entering: java.security.KeyStore.load(java.io.InputStream,[C) with arguments=[sun.nio.ch.ChannelInputStream@72209d93, null] from source KeyStore.java:1472
FowdlETwCMY6O0Qbm7EAAA 15:48:47.036 [TRACE] j.s.KeyStore -  exiting: java.security.KeyStore.load(java.io.InputStream,[C) with arguments=[sun.nio.ch.ChannelInputStream@72209d93, null] => (return_type=void return_value=null) from source KeyStore.java:1474
FowdlETwCMc6O0Qbm7EAAA 15:48:47.037 [TRACE] j.s.KeyStore -  entering: java.security.KeyStore.aliases() with arguments=[] from source KeyStore.java:1259
FowdlETwCMc6O0Qbm7EAAB 15:48:47.037 [TRACE] j.s.KeyStore -  exiting: java.security.KeyStore.aliases() with arguments=[] => (return_type=java.util.Enumeration return_value=java.util.Collections$3@1ded7b14) from source KeyStore.java:1262
FowdlETwCMc6O0Qbm7EAAC 15:48:47.037 [INFO ] c.t.j.JcaKeyFailure -  alias = rsaentry
FowdlETwCMg6O0Qbm7EAAA 15:48:47.037 [TRACE] j.s.KeyStore -  entering: java.security.KeyStore.getKey(java.lang.String,[C) with arguments=[rsaentry, null] from source KeyStore.java:1047
FowdlETwCOk6O0Qbm7EAAA 15:48:47.071 [TRACE] j.s.KeyStore -  exiting: java.security.KeyStore.getKey(java.lang.String,[C) with arguments=[rsaentry, null] => (return_type=java.security.Key return_value=SunRsaSign RSA private CRT key, 2048 bits
  params: null
  modulus: 16203557191767681330138456275032636312287276928702455473879544494481012979891285979039125214611893351277113179328595672911137165278150446011234870145312938888175088357689624043146091805742383045363881036474627042866416723367160267799803785570079615560858457887732828794058892576945493476466971268912181212324220595529007302402827691286193810967756311528061387014450725632854083481439851097553928305248710325666503755617166024430516292319139997991589942552483158738400586506246946373501737220455516718464564114745313163912138064254478418347998196236453324251287039914924744910729363704240809993662855892176565439819417
  private exponent: 4321311207374697259382637880510557661567618691118933072500521517227507283863159686004025672535921265752496820853948077744493269065283938773278652675584472067496592677658410501336762326331162104870072062430436722084001884294539377154965447978910409704024964935254808454194749904021443382847700136381694359354227937509221409363537264418842985162361346649299682965291071732345638344443221649712100375247504751874160807041259766287796896521044526743574564618042110175258515272931418641175211982498606683047493686737655697867206943045618117445930452114437826000568551007874657482069726209706716152683624781607872934635353) from source KeyStore.java:1050
FowdlETwCOo6O0Qbm7EAAA 15:48:47.072 [TRACE] j.s.KeyStore -  entering: java.security.KeyStore.getEntry(java.lang.String,java.security.KeyStore$ProtectionParameter) with arguments=[rsaentry, java.security.KeyStore$PasswordProtection@6df7988f] from source KeyStore.java:1542
FowdlETwCQ46O0Qbm7EAAA 15:48:47.107 [ERROR] j.s.KeyStore -  throwing: java.security.KeyStore.getEntry(java.lang.String,java.security.KeyStore$ProtectionParameter) with arguments=[rsaentry, java.security.KeyStore$PasswordProtection@6df7988f]java.lang.NullPointerException: invalid null input
        at java.base/java.security.KeyStore$PrivateKeyEntry.<init>(KeyStore.java:532)
        at java.base/sun.security.pkcs12.PKCS12KeyStore.engineGetEntry(PKCS12KeyStore.java:1346)
        at java.base/sun.security.util.KeyStoreDelegator.engineGetEntry(KeyStoreDelegator.java:166)
        at java.base/java.security.KeyStore.getEntry(KeyStore.java:1548)
        at com.tersesystems.jcakeyfailure.JcaKeyFailure.testSystem(JcaKeyFailure.java:84)
        at com.tersesystems.jcakeyfailure.JcaKeyFailure.main(JcaKeyFailure.java:30)

FowdlETwCQ8dHaINzdiAAA 15:48:47.109 [ERROR] c.t.j.JcaKeyFailure -  Instance failed with exception!java.lang.NullPointerException: invalid null input
        at java.base/java.security.KeyStore$PrivateKeyEntry.<init>(KeyStore.java:532)
        at java.base/sun.security.pkcs12.PKCS12KeyStore.engineGetEntry(PKCS12KeyStore.java:1346)
        at java.base/sun.security.util.KeyStoreDelegator.engineGetEntry(KeyStoreDelegator.java:166)
        at java.base/java.security.KeyStore.getEntry(KeyStore.java:1548)
        at com.tersesystems.jcakeyfailure.JcaKeyFailure.testSystem(JcaKeyFailure.java:84)
        at com.tersesystems.jcakeyfailure.JcaKeyFailure.main(JcaKeyFailure.java:30)
```
