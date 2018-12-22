# google-translate-tts
Unofficial API to Google Translate's TTS service

## Usage

The following in a pretty easy example on how to directly save the MP3 audio file.
```java
GoogleTranslateTTS tts = new GoogleTranslateTTS("en-US");
tts.saveToFile("This is an example of the Google TTS wrapper.", "tts-out.mp3");
```

## Installation

If your project uses Maven, you can add the Jitpack repository...
```xml
<repository>
  <id>jitpack.io</id>
  <url>https://jitpack.io</url>
</repository>
```
...and then add the project dependency:
```xml
<dependency>
  <groupId>com.github.vinceh121</groupId>
  <artifactId>google-translate-tts</artifactId>
  <version>1.0.0</version>
</dependency>
```

And you're done!

## License
This API wrapper is released under the GNU GPL V3
