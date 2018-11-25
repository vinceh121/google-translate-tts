package me.vinceh121.gttts;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class GoogleTranslateTTS {
	private String encoding = "UTF-8", language, client = "tw-ob";

	public GoogleTranslateTTS(String language) {
		this.language = language;
	}

	public void saveToFile(String text, String file) throws IOException {
		saveToFile(text, new File(file));
	}

	public void saveToFile(String text, File file) throws IOException {
		byte[] data = getData(text);
		FileOutputStream out = new FileOutputStream(file);
		out.write(data);
		out.close();
	}

	public byte[] getData(String text) throws IOException {
		InputStream in = getStream(text);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int n;
		byte[] buffer = new byte[1024];
		while ((n = in.read(buffer)) > -1) {
			out.write(buffer, 0, n);
		}
		in.close();
		out.close();
		return out.toByteArray();
	}

	public InputStream getStream(String text) throws IOException {
		HttpsURLConnection con = (HttpsURLConnection) new URL("https://translate.google.com/translate_tts?ie="
				+ encoding + "&q=" + URLEncoder.encode(text, encoding) + "&tl=" + language + "&client=" + client)
						.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:25.0) Gecko/20100101 Firefox/25.0");
		con.setReadTimeout(5000);
		con.connect();
		return con.getInputStream();
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

}
