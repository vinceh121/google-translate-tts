import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import me.vinceh121.gttts.GoogleTranslateTTS;

public class TtsTest {
	GoogleTranslateTTS tts;
	private final String text = "Bonjour, ceci est un test de mon API de communication avec le TTS de Google Traduction";

	@Before
	public void setUp() {
		tts = new GoogleTranslateTTS("fr-FR");
	}

	@Test
	public void testData() throws IOException {
		System.out.println(new String(tts.getData(text)));
	}

	@Test
	public void testFile() throws IOException {
		tts.saveToFile(text, "test.mp3");
	}

}
