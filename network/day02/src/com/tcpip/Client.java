package com.tcpip;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	int port;
	String ip;

	Socket socket;

	public Client(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	public void connectServer() {
		try {
			System.out.println("Start Client");
			socket = new Socket(ip, port);
			System.out.println("Connected ...");
		} catch (Exception e) {
			while (true) {
				try {
					Thread.sleep(2000);
					socket = new Socket(ip, port);
					System.out.println("Connected ...");
					break;
				} catch (Exception e1) {
					System.out.println("Retry ...");
				}
			}
		}
	}

	public static void main(String[] args) {
		Client client = null;
		client = new Client("192.168.0.2", 9999);
		client.connectServer();

		System.out.println("End client");
	}

}
