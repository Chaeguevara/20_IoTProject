package com.chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.msg.Msg;

public class Server {
	int port;
	
	HashMap<String, ObjectOutputStream> maps;
	
	ServerSocket serverSocket;
	
	public Server() {}
	public Server(int port) {
		this.port = port;
		maps = new HashMap<>(); // 해쉬맵을 이용해 받아온 채팅 값을 저장할 것임.
	}
	
	public void startServer() throws IOException {
		// 서버를 실행한다.
		serverSocket = new ServerSocket(port);
		System.out.println("Start Server...");
		//무한루프 + 클라이언트에서 들어온 정보 확인.
		//Flag를 이용해 멈추는 것도 고려해 볼 수 있음
		
		Runnable r = new Runnable() {

			@Override
			public void run() {
				while(true) {
				try {
					Socket socket = null;
					System.out.println("Ready Server ...");
					socket = serverSocket.accept();
					System.out.println("flow..");
					System.out.println(socket.getInetAddress());//클라이언트의 IP 주소
					makeOut(socket);// outputstream을 만들 socket 생성
					new Receiver(socket).start(); // 들어오는 사람마다 쓰레드 생성				
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
				
			}
			
		};
		new Thread(r).start();
		
	}
	
	public void makeOut(Socket socket) throws IOException {
		ObjectOutputStream oo;
		oo = new ObjectOutputStream(socket.getOutputStream());
		maps.put(socket.getInetAddress().toString(), oo);//해쉬맵에 저장.ip + outputstream
		System.out.println("접속자수:"+maps.size()); //map 크기를 통해 접속자수 구하기.
		
	}
	
	class Receiver extends Thread{
		//각 클라이언트 마다 각 쓰레드를 받음.
		Socket socket;
		ObjectInputStream oi;
		
		public Receiver(Socket socket) throws IOException {
			this.socket = socket;
			oi = new ObjectInputStream(this.socket.getInputStream());
		}

		@Override
		public void run() {
			while(oi !=null) {
				Msg msg = null;
				try {
					msg = (Msg) oi.readObject();
					if(msg.getMsg().equals("q")) {
						throw new Exception(); // 아래 구문을 작동시키기 위해 일부러 Exception 오류 냄.
					}else if(msg.getMsg().equals("1")) {
						//1을 받으면, 접속한 사람의 정보를 보내준다.
						//나의 IP주소를 찾아 그곳에 메세지를 보낸다.
						String ip =
						socket.getInetAddress().toString();
						ArrayList<String> ips = new ArrayList<>();
						ips.add(ip);
						msg.setIps(ips);
						
						Set<String> keys = maps.keySet(); // map에서 key만 꺼냄(ip주소들)
						HashMap<String,Msg> hm = new HashMap<>();
						//루프를 통해 hashmap의 key 값만 넣음 
						for(String k:keys) {
							hm.put(k, null);
						}
						// 1을 보낸 client
						// 서버의 접속자 ip들
						msg.setMaps(hm);
					}
					System.out.println(
							msg.getId()+msg.getMsg()
							);
					sendMsg(msg); // 한 사용자의 메세지를 모든 클라이언트에게 보낸다.
				} catch (Exception e) {
					e.printStackTrace();
					//클라이언트 문제다
					maps.remove(socket.getInetAddress().toString());
					System.out.println(socket.getInetAddress()+"..Exited");
					System.out.println("접속자수:"+maps.size());
					break;
				} 
			}
			try {
				if(oi!=null) {
					oi.close();
				}
				if(socket!=null) {
					socket.close();
				}
			}catch(Exception e) {
			}
		}// end run
		
		
	}
	public void sendMsg(Msg msg) {
		//Sender Thread 작동
		Sender sender = new Sender();
		sender.setMsg(msg);
		sender.start();
	}
	class Sender extends Thread{
		Msg msg;
		public void setMsg(Msg msg) {
			this.msg = msg;
		}
		@Override
		public void run() {
			Collection<ObjectOutputStream> cols =
					maps.values();
			Iterator<ObjectOutputStream> it=
					cols.iterator();
			//컬랙션 데이터를 루프
			while(it.hasNext()) {
				if(msg.getIps()!=null) {
					for(String ip:msg.getIps()) {
						try {
							maps.get(ip).writeObject(msg);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					break;							
				}
				try {
					it.next().writeObject(msg);
					System.out.println("broadcast");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Server server = new Server(5555);
		try {
			server.startServer();
		} catch (IOException e) {
			e.printStackTrace();
		}//서버 시작
	}

}
