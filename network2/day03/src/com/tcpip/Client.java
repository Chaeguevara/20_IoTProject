package com.tcpip;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	int port;
	String address;
	
	Socket socket;
	
	public Client() {}
	public Client(String address,int port) {
		this.address = address;
		this.port = port;
		
	}
	public void connect() throws InterruptedException {
		try {
			socket = new Socket(address, port);
			System.out.println("Connected ...");
		} catch (Exception e) {
			while(true) {
				Thread.sleep(2000);
				try {
					
					socket = new Socket(address, port);
					System.out.println("Connected ...");
					break;
				} catch (Exception e1) {
					System.out.println("Retry ...");
				}
			}
		}
	}
	
	class Sender extends Thread{
		DataOutputStream dos;
		String msg;
		public Sender(String msg) {
			this.msg = msg;
			try {
				dos = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			if(dos != null) {
				try {
					dos.writeUTF(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	public void request() throws IOException {
		Scanner sc = new Scanner(System.in);
		try {
			while(true) {
				System.out.println("[Input Msg:]");
				String msg = sc.nextLine();
				if(msg.equals("q")) {
					new Sender("q").start();
					Thread.sleep(1000);
					System.out.println("Exit Client ..");
					break;
				}
				new Sender(msg).start();
			}
		}catch(Exception e) {
			
		}finally {
			sc.close();
			if(socket != null) {
				socket.close();
			}
		}
	}
	public static void main(String[] args) {
		Client client = new Client("192.168.0.36",7777);
		try {
			client.connect();
			client.request();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
