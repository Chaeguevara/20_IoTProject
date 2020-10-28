package com.tcpip2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.msg.Msg;

// Object Serialization...

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
		ObjectInputStream dis;
		Socket socket = null;

		public Receiver(Socket socket) {
			this.socket = socket;
			try {
				dis = new ObjectInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			while (dis != null) {
				Msg mo = null;
				try {
					mo = (Msg) dis.readObject(); // 오브젝트를 읽는다..
					if (mo.getMsg().equals("q")) {
						System.out.println(mo.getId()+"logged out"); //q를 눌렀을때 나가는 것.
						break;
					}
					System.out.println(
							"["+mo.getId()+"] "+mo.getMsg()); //id와 메세지 띄우기
				} catch (Exception e) {
					if(mo.getId()!=null) {
						System.out.println(mo.getId()+"logged out");// client를 꺼버린 경우 처리.
					}
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
