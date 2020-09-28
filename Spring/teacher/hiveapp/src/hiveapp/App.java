package hiveapp;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class App {

	String url;

	public App() {
//		url = "http://127.0.0.1/hive/carstatus.mc";
	}

	public void getData() {
		for (int i = 1; i < 100; i++) {
			

			Random r = new Random();
			double speed = r.nextInt(200);

			CarStatus cstatus = new CarStatus("car01", speed, 24, 90, 1500);

			try {
				sendData(cstatus);
				System.out.println("Send Data ..." + speed);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void sendData(CarStatus cs) throws Exception {
		url = "http://192.168.111.120/hive/carstatus.mc";
		url += "?id="+cs.getId()+"&speed="+cs.getSpeed()+"&temp="+cs.getTemp()+
				"&oiltemp="+cs.getOiltemp()+"&rpm="+cs.getRpm();
		System.out.println(url);
		URL curl = new URL(url);
		HttpURLConnection con = (HttpURLConnection) curl.openConnection();
		try {
			con.getInputStream();
			con.setReadTimeout(5000);
			con.setRequestMethod("POST");
		}catch(Exception e) {
			//throw e;
		}finally {
			con.disconnect();
		}

	}

	public static void main(String[] args) {
		App app = new App();
		app.getData();
	}
}
