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
		maps = new HashMap<>(); // �ؽ����� �̿��� �޾ƿ� ä�� ���� ������ ����.
	}
	
	public void startServer() throws IOException {
		// ������ �����Ѵ�.
		serverSocket = new ServerSocket(port);
		System.out.println("Start Server...");
		//���ѷ��� + Ŭ���̾�Ʈ���� ���� ���� Ȯ��.
		//Flag�� �̿��� ���ߴ� �͵� ����� �� �� ����
		
		Runnable r = new Runnable() {

			@Override
			public void run() {
				while(true) {
				try {
					Socket socket = null;
					System.out.println("Ready Server ...");
					socket = serverSocket.accept();
					System.out.println("flow..");
					System.out.println(socket.getInetAddress());//Ŭ���̾�Ʈ�� IP �ּ�
					makeOut(socket);// outputstream�� ���� socket ����
					new Receiver(socket).start(); // ������ ������� ������ ����				
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
		maps.put(socket.getInetAddress().toString(), oo);//�ؽ��ʿ� ����.ip + outputstream
		System.out.println("�����ڼ�:"+maps.size()); //map ũ�⸦ ���� �����ڼ� ���ϱ�.
		
	}
	
	class Receiver extends Thread{
		//�� Ŭ���̾�Ʈ ���� �� �����带 ����.
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
						throw new Exception(); // �Ʒ� ������ �۵���Ű�� ���� �Ϻη� Exception ���� ��.
					}else if(msg.getMsg().equals("1")) {
						//1�� ������, ������ ����� ������ �����ش�.
						//���� IP�ּҸ� ã�� �װ��� �޼����� ������.
						String ip =
						socket.getInetAddress().toString();
						ArrayList<String> ips = new ArrayList<>();
						ips.add(ip);
						msg.setIps(ips);
						
						Set<String> keys = maps.keySet(); // map���� key�� ����(ip�ּҵ�)
						HashMap<String,Msg> hm = new HashMap<>();
						//������ ���� hashmap�� key ���� ���� 
						for(String k:keys) {
							hm.put(k, null);
						}
						// 1�� ���� client
						// ������ ������ ip��
						msg.setMaps(hm);
					}
					System.out.println(
							msg.getId()+msg.getMsg()
							);
					sendMsg(msg); // �� ������� �޼����� ��� Ŭ���̾�Ʈ���� ������.
				} catch (Exception e) {
					e.printStackTrace();
					//Ŭ���̾�Ʈ ������
					maps.remove(socket.getInetAddress().toString());
					System.out.println(socket.getInetAddress()+"..Exited");
					System.out.println("�����ڼ�:"+maps.size());
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
		//Sender Thread �۵�
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
			//�÷��� �����͸� ����
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
		}//���� ����
	}

}
