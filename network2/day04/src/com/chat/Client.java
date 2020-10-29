package com.chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import com.msg.Msg;

public class Client {
	
	int port;
	String address;
	String id;
	Socket socket;
	Sender sender; // 서버에 메세지 보내기 용
	
	public Client() {}
	public Client(String address, int port, String id) {
		this.address = address;
		this.port = port;
		this.id = id;
	}
	
	public void connect() throws IOException  {
		//소캣을 만듬
		try {
			socket = new Socket(address,port);
		} catch (Exception e) {
			while(true) {
				try {
					Thread.sleep(2000);
					socket = new Socket(address,port);
					break;
				}catch(Exception e1) {
					System.out.println("Retry...");
				}
				
			}
		}  // exception을 내부 처리 할 것임. 무한루프를 통해 계속 접속 시도

		System.out.println("Connected Server:"+address);
		sender = new Sender(socket); //쓰래드 객체의 틀만 만든 것.
		new Receiver(socket).start(); //리시버를 만든다.
	}
	
	public void sendMsg() {
		//스캐너에서 입력받아 보냄.
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Input msg");
			String ms = sc.nextLine();
			Msg msg = new Msg("192.168.0.2",id,ms,"192.168.31.1"); // 타겟 아이피를 설정한다.
			sender.setMsg(msg);
			new Thread(sender).start(); // 실제로 보낸다.
			if(ms.equals("q")) {
				break;
			}
		}
		sc.close();
		if(socket != null) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Bye...");
	}
	
	class Sender implements Runnable{
		//서버로 보냄, 틀이다
		Socket socket;
		ObjectOutputStream oo;
		Msg msg;
		public Sender(Socket socket) throws IOException {
			this.socket = socket;
			oo = new ObjectOutputStream(socket.getOutputStream());
		}
		public void setMsg(Msg msg) {
			this.msg = msg;
		}
		@Override
		public void run() {
			if(oo != null) {
				try {
					oo.writeObject(msg); // exception은 서버가 꺼져있을 확률이 큼
				} catch (IOException e) {
					//e.printStackTrace();
					try {
						if(socket!=null) {
							socket.close();
						}
					}catch(Exception e1) {
						e1.printStackTrace();
					}
					try {
						Thread.sleep(2000);
						connect();
					} catch (Exception e1) {
						e1.printStackTrace();
					}//다시 커넥트
				}
			}
		}	
	}
	
	class Receiver extends Thread{
		//서버에서 받음
		//소켓이 필요하다. 데이터를 받기 위해
		ObjectInputStream oi;
		public Receiver(Socket socket) throws IOException {
			oi = new ObjectInputStream(socket.getInputStream());
		}
		@Override
		public void run() {
			while(oi != null) {
				Msg msg = null;
				try {
					msg = (Msg) oi.readObject();
					System.out.println(msg.getId()+msg.getMsg());
				} catch (Exception e) {
					e.printStackTrace();
					break;
				} 
			} //end while
			try {
				if(oi!=null) {
					oi.close();
				}
				if(socket!=null) {
					socket.close();
				}
			}catch(Exception e) {
				
			}
		}
		
	}
	
	public static void main(String[] args) {
		Client client = new Client("192.168.0.2",5555,"[Chaeguevara]");
		try {
			client.connect();
			client.sendMsg();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
