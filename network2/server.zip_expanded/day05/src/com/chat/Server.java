package com.chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
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

	public Server() {

	}

	public Server(int port) {
		this.port = port;
		maps = new HashMap<>(); // Key媛� = Client Ip二쇱냼  , Value = Client OutputStream �젙蹂�
	}

	public void startServer() throws IOException {
		serverSocket = new ServerSocket(port);
		System.out.println("Start Server ...");
		
		// Thread �븞�뿉�꽌 吏꾪뻾�쓣 �븯�뒗 寃껋씠 醫뗫떎. 援녹씠 �븞�빐�룄 �봽濡쒓렇�옩�씠 �룎�븘媛�湲댄븳�떎.
		Runnable r = new Runnable() {
			@Override
			public void run() {
				while (true) {
					// try catch 濡� Exception�쓣 �옟�븘�빞 Server 利� while 臾몄씠 醫낅즺�릺吏� �븡�뒗�떎. (Server媛� 二쎌� �븡�뒗�떎)-------------------
					try {
						Socket socket = null;
						System.out.println("Ready Server...");
						socket = serverSocket.accept();
						// socket.getInetAddress() = client�쓽 ip �젙蹂� 異쒕젰
						System.out.println(socket.getInetAddress());
						makeOut(socket);

						new Receiver(socket).start();
					}catch(Exception e){
						// e.printStackTrace();
					}
				} // while end
			}
		}; // Runnable and
		new Thread(r).start();
	} // startServer end
	
		// 媛곴컖�쓽 client媛� �젒�냽�쓣 �뻽�쓣 �븣 媛곴컖 socket�씠 留뚮뱾�뼱吏�硫� socket�쓣 媛�吏�怨� OutputStream�쓣 留뚮뱾�뼱 hashmap�뿉 �떞�뒗 �뿭�븷
	public void makeOut(Socket socket) throws IOException {
		ObjectOutputStream oo;
		oo = new ObjectOutputStream(socket.getOutputStream());
		maps.put(socket.getInetAddress().toString(), oo);
		System.out.println("접속자 수: " + maps.size());
	} // makeOut end

	class Receiver extends Thread {
		Socket socket;
		ObjectInputStream oi;

		public Receiver(Socket socket) throws IOException {
			this.socket = socket;
			oi = new ObjectInputStream(socket.getInputStream());
		}

		@Override
		public void run() {
			while (oi != null) {
				Msg msg = null;
				try {
					msg = (Msg) oi.readObject();
					if(msg.getMsg().equals("q")) {
						throw new Exception();
					} else if(msg.getMsg().equals("1")) {
						// 1 �쓣 蹂대궦 (Client List瑜� �슂泥��븳) Client �쓽 IP �젙蹂�
						String ip = socket.getInetAddress().toString();
						ArrayList<String> ips = new ArrayList<>();
						ips.add(ip);
						msg.setIps(ips);
						// �쁽�옱 Hashmap �뿉 �뱾�뼱媛� �엳�뒗 Key (�궗�슜�옄 ip) 瑜� 爰쇰궦�떎.
						Set<String> keys = maps.keySet();
						HashMap<String, Msg> hm = new HashMap<>();
						for(String k: keys) {
							hm.put(k, null);
						}
						// hm �뿉�뒗 1�쓣 蹂대궦 client �젙蹂� / Server �젒�냽�옄 IP �젙蹂대뱾 �씠 �뱾�뼱媛� �엳�떎.
						msg.setMaps(hm);
						
					} else if(msg.getMsg().equals("2")){
						String urlstr = "http://127.0.0.1/tcpip/toServer.mc";
						URL url = null;
						HttpURLConnection con = null;
						while(true) {
							try {
								double lat = Math.random()*90 + 1;
								double lng = Math.random()*90 + 1;
								
								url = new URL(urlstr+"?lat="+lat+"&lng="+lng);
								con = (HttpURLConnection) url.openConnection();
								//wait 5 sec
								con.setReadTimeout(5000);
								con.setRequestMethod("POST");
								con.getInputStream();
							} catch (Exception e) {
								e.printStackTrace();
							} finally {
								con.disconnect();
							}
							
							try {
								Thread.sleep(5000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}// else if end
					System.out.println(msg.getId()+" : "+msg.getMsg());
					sendMsg(msg);
				} catch (Exception e) {
					// Exception �씠 �굹硫� client �� �뿰寃곗씠 �걡�뼱 議뚮떎�뒗 �쓽誘몄씠誘�濡� maps �뿉�꽌 �궘�젣 (鍮꾩젙�긽 醫낅즺)
					maps.remove(socket.getInetAddress().toString());
					System.out.println(socket.getInetAddress()+ ".. Exited");
					System.out.println("접속자수 : "+maps.size());
					break;
				}
				//System.out.println(msg.getId()+" : "+msg.getMsg()); �쐞�뿉 �꽔�뼱�룄 �맂�떎.
			} // end while
			// 諛섎뱶�떆 close 瑜� �떆耳쒖＜�뼱�빞 �븳�떎. --------------------------------------------
			try {
				if(oi != null) {
					oi.close();
				}
				if(socket != null) {
					socket.close();
				}
			} catch(Exception e) {
				
			}
		} // run end

	} // Receiver end
		// Receiver 硫붿떆吏�瑜� 諛쏆쑝硫� 洹� 硫붿꽭吏�瑜� 媛�吏�怨� Sender瑜� �샇異쒗븯�뒗 �뿭�븷

	public void sendMsg(Msg msg) {
		Sender sender = new Sender();
		sender.setMsg(msg);
		sender.start();
	}

	// �븳 Client媛� 蹂대궦 msg 利�, hashmap�뿉 �엳�뒗 �뜲�씠�꽣瑜� 媛�吏�怨� Client �뱾�뿉寃� �쟾�넚�쓣 �븿.
	class Sender extends Thread {
		Msg msg;
		public void setMsg(Msg msg) {
			this.msg = msg;
		}
		@Override
		public void run() {
			// Hashmap �뿉 �엳�뒗 媛� 爰쇰궡湲�
			Collection<ObjectOutputStream> cols = maps.values();
			Iterator<ObjectOutputStream> it = cols.iterator();
			while(it.hasNext()) {
				try {
				// 洹볦냽留� 蹂대궪�븣 null媛믨낵 怨듬갚�씪 寃쎌슦瑜� 媛숈씠 泥댄겕瑜� �빐�빞 �븳�떎. ---------------------- 洹볦냽留�
				//if (msg.getIp() != null || !msg.getIp().equals("")) {
				//	maps.get(msg.getIp()).writeObject(msg);
				//	break;
					// �듅�젙 �씤�썝�뱾�뿉寃� 洹볦냽留먯쓣 蹂대궪 �뻹 -------------------------------------
					if (msg.getIps() != null) {
						for(String ip :msg.getIps()) {
							maps.get(ip).writeObject(msg);	
						}					
						break;
					}
					
					//client �쟾泥댁뿉 硫붿떆吏� 蹂대궡湲� broadcast  
					it.next().writeObject(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} // run end
		
	} // class Sender end

	public static void main(String[] args) {
		Server server = new Server(5555);
		try {
			server.startServer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}