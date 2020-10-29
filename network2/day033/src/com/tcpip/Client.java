package com.tcpip;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import com.msg.Msg;

public class Client {

	int port;
	String address;
	
	Socket socket;
	Sender sender;
	
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
		
		sender = new Sender(); // Sender를 생성한다.
	}
	
	class Sender implements Runnable{
		ObjectOutputStream dos;
		String msg;
		Msg mo;
		public void setMo(Msg mo) {
			this.mo = mo;
		}
		public Sender() {
			try {
				dos = new ObjectOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			if(dos != null) {
				try {
					dos.writeObject(mo);
				} catch (IOException e) {
					System.out.println("Server not available");
					System.exit(0);
				}
			}
		}
		
		
	}
	
	public void request() throws IOException {
		Scanner sc = new Scanner(System.in);
		try {
			Msg mo = null;
			while(true) {
				System.out.println("[Input Msg:]");
				String msg = sc.nextLine();
				// Utilize serialization
				mo = new Msg("192.168.31.1","Chaeguevara",msg.trim());
				sender.setMo(mo); //set 
				new Thread(sender).start(); //and send
				Thread.sleep(500);
				if(msg.equals("q")) {
					System.out.println("Exit Client ..");
					break;
				}
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
		Client client = new Client("192.168.0.2",7777);
		try {
			client.connect();
			client.request();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
