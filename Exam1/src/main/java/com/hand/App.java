package com.hand;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://files.saas.hand-china.com/java/target.pdf");
			URLConnection conn = url.openConnection();
			InputStream is = conn.getInputStream();
			FileOutputStream fs = new FileOutputStream("target.pdf");
			BufferedInputStream input = new BufferedInputStream(is);
			BufferedOutputStream output = new BufferedOutputStream(fs);
			int r;
			while ((r = input.read()) != -1) {
				output.write((byte) r);
			}
			output.close();
			input.close();
			is.close();
			fs.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
