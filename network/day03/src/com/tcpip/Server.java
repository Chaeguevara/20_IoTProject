package com.tcpip;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	int port;
	ServerSocket serverSocket;
	Socket socket;

	public Server() {
	}

	public Server(int port) {
		this.port = port;
	}

	class Receiver extends Thread {
		DataInputStream dis;
		Socket socket = null;

		public Receiver(Socket socket) {
			this.socket = socket;
			try {
				dis = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			while (dis != null) {
				String msg = "";
				try {
					msg = dis.readUTF(); // 메시지를 읽는다.
					if (msg.equals("q")) {
						System.out.println("Someone logged out"); //q를 눌렀을때 나가는 것.
						break;
					}
					System.out.println(msg);
				} catch (IOException e) {
					System.out.println("Someone logged out");// client를 꺼버린 경우 처리.
					break;
				}
			}
			if (dis != null) {
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public void startServer() throws IOException {
		System.out.println("TCP/IP Server Start....");
		try {
			serverSocket = new ServerSocket(port);
			while (true) {
				System.out.println("Ready Server ..");
				socket = serverSocket.accept();
				System.out.println("Connected..");
				// 소켓은 접속자마다 한개씩 필요하다.
				new Receiver(socket).start();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public static void main(String[] args) {

		Server server = new Server(7777);
		try {
			server.startServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
