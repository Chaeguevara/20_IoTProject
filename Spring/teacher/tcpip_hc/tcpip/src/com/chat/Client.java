package com.chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.msg.Msg;

public class Client {

	int port;
	String address;
	String id;
	Socket socket;
	
	Sender sender;
	
	public Client() {
		
	}
	public Client(String adress, int port, String id) {
		this.address = adress;
		this.port = port;
		this.id = id;
	}
	
	public void connect() throws IOException {
		try {
			socket = new Socket(address, port);
		} catch (Exception e) {
			
			while(true) {
				try {
					Thread.sleep(200);
					socket = new Socket(address, port);
					break;
				} catch(Exception e2) {
					System.out.println("Retry...");
				}
			} // while end
		} 
		
		System.out.println("Connected Server : "+address);
		sender = new Sender(socket);
		// Server에서 보낸 데이터 받기 위해 receiver 실행 
		// new Receiver(socket).start();
	} // connect end
	
	// web App에서 데이터를 받고 cmd 를 보낸다 ============================================= 
	public void sendTarget(String ip, String cmd) {
		ArrayList<String> ips = new ArrayList<String>();
		ips.add(ip);
		Msg msg = new Msg(id,cmd);
		sender.setMsg(msg);
		new Thread(sender).start();
	}
	

	// Scanner로 Input 값 받기
	public void sendMsg() {
		Scanner sc = new Scanner(System.in);
		if (socket != null) {
		while(true) {
			System.out.println("Input Msg");
			String ms = sc.nextLine();
			// 1을 보내면 서버에서는 Client 리스트를 보낸다. ------------------------------------특정 규칙을 정해야 한다.
			Msg msg = null;
			if(ms.equals("1")) {
				msg = new Msg(id,ms);
			}else {
				// 특정 인원들에게 귓속말을 보낼때 Msg.java 수정했음--------------------------------------------
				// ArrayList로 귓속말 보낼 IP 주소를 넣어 Server에 보내면 해당 IP 들에게 Server에서 메시지 전송
				ArrayList<String> ips = new ArrayList<>();
				ips.add("/192.168.0.24");
				ips.add("/192.168.0.15");
				ips.add("/192.168.0.92");
				ips.add("/192.168.0.69");
//				msg = new Msg(ips,id,ms);
				msg = new Msg(null,id,ms);
			}
			// 귓속말 하기 위한 Ip 정보 추가 전송 Server에서 Ip를 읽으면 앞에 / 가 자동으로 붙기 때문에 그 형식을 맞추기 위해 / 추가
	//		Msg msg = new Msg("/192.168.0.24",id,ms);
			
			sender.setMsg(msg);
			new Thread(sender).start();
			
			if(ms.equals("q")) {
				break;
			}
		  }
		}
		sc.close();
		// 반드시 종료 ----------------------
		if(socket != null) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Bye...");
	} // sendMsg end
	
	// Runnable 이용해야한다.
	class Sender implements Runnable{
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
					oo.writeObject(msg);
				} catch (IOException e) {
					// 이때 Exception 은 Server 가 죽어있을 확률이 크다.
					//	e.printStackTrace();
					try {						
						if(socket != null) {
							socket.close();
						}

					}catch(Exception e1) {
						e1.printStackTrace();
					}
					// Server와 재 연결 시도 ---------------------------
					try {
						Thread.sleep(2000);
						connect();
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}
			}
		} // run end
	} // class Sender end
	
	// Server에서 보낸 메시지 InputStream으로 받기
	class Receiver extends Thread{
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
					// 1을 입력 했을 때 Client list 받기 ----------------------
					if(msg.getMaps() != null) {
						HashMap<String,Msg> hm = msg.getMaps();
						Set<String> keys =  hm.keySet();
						for(String k : keys) {
							System.out.println(k);
						}
						continue; // 계속 받아야 하기 때문에 아래를 건너 뛰고 다시 실행
					}
					System.out.println(msg.getId()+" : "+msg.getMsg());
				} catch (Exception e) {
					e.printStackTrace();
					break;
				}
			} // while end
			try {
				if(oi != null) {
					oi.close();
				}
				if (socket != null) {
					socket.close();
				}
			} catch(Exception e) {
				
			}
		} // run end
	} // class Receiver end
	
	public static void main(String[] args) {
		Client client = new Client("192.168.1.107",5555,"[Seo]");
		try {
			client.connect();
			client.sendMsg();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}