package com.hand;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(12345);
			Socket socket = server.accept();
			System.out.println("客户端已连上！");
			BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
			FileInputStream fis = new FileInputStream("target.pdf");
			BufferedInputStream bis = new BufferedInputStream(fis);
			int r;
			while ((r = bis.read()) != -1) {
				bos.write((byte) r);
			}
			bos.close();
			bis.close();
			fis.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
