package com.hand;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class App {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://files.saas.hand-china.com/java/target.pdf");
			URLConnection conn = url.openConnection();
			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"UTF-8");
			BufferedReader br = new BufferedReader(isr);//从文件中读出来
//			BufferedInputStream input = new BufferedInputStream(is);
//			String line;
			int r;
			char c[] = new char[1];
			while ((r = br.read(c)) != 0) {
				System.out.print(c);
			}
			br.close();
			isr.close();
			is.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
