# MSCore
僕が作った Spigot Plugin の前提プラグイン

## バージョン

| Spigot Version | MSCore Version |
| :------------: | :------------: |
| 1.10.2 ~       | 0.2            |

## 開発環境

Bintray: [https://bintray.com/masahirosaito-repo/Spigot-Plugin/MSCore](https://bintray.com/masahirosaito-repo/Spigot-Plugin/MSCore)

### Gradle

```gradle
maven {
        name = "exposed-repo"
        url = "https://dl.bintray.com/kotlin/exposed/"
    }
    maven {
        name = 'mscore-repo'
        url = 'https://masahirosaito-repo.bintray.com/Spigot-Plugin/'
    }
```

```gradle
compile 'com.MasahiroSaito.Spigot:MSCore:0.2'
```