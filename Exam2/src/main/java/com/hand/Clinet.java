package com.hand;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Clinet {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1",12345);
			BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
			File file = new File("new_target.pdf");
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			int r;
			while ((r = bis.read()) != -1) {
				bos.write((byte) r);
			}
			bos.close();
			fos.close();
			bis.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
