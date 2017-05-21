![jcenter](https://img.shields.io/badge/_jcenter_-1.0.0-6688ff.png?style=flat) &#x2003; ![jcenter](https://img.shields.io/badge/_Tests_-4/4-green.png?style=flat) &#x2003; ![jcenter](https://img.shields.io/badge/_Coverage_-100%25-blue.png?style=flat)
# kotlin json
A kotlin library providing a nice syntax for creating json objects.

## Download ##

The maven artifacts are on [Bintray](https://bintray.com/programingjd/maven/info.jdavid.kotlin.json/view)
and [jcenter](https://bintray.com/search?query=info.jdavid.kotlin.json).

[Download](https://bintray.com/artifact/download/programingjd/maven/info/jdavid/kotlin/1.0.0/json-1.0.0.jar) the latest jar.

__Maven__

Include [those settings](https://bintray.com/repo/downloadMavenRepoSettingsFile/downloadSettings?repoPath=%2Fbintray%2Fjcenter)
 to be able to resolve jcenter artifacts.
```
<dependency>
  <groupId>info.jdavid.kotlin</groupId>
  <artifactId>json</artifactId>
  <version>1.0.0</version>
</dependency>  
```
__Gradle__

Add jcenter to the list of maven repositories.
```
repositories {
  jcenter()
}
```
```
dependencies {
  compile 'info.jdavid.kotlin:json:1.0.0'
}
```

## Usage ##

__kotlin__
```kotlin
import info.javid.kotlin.json

val json = json(
  "string" ("text"),
  "boolean" (null),
  "number" (1.5),
  "nested" (
    "a" (1, 2, 3)
  ),
  "empty" ()
)
```
__json__
```json
{
  "string": "text",
  "boolean": null,
  "number": 1.5,
  "nested": {
    "a": [ 1, 2, 3 ]
  },
  "empty": {}
}

```
