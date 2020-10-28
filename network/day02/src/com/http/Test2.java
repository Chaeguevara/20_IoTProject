package com.http;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Test2 {

	public static void main(String[] args) {
		String urlstr = "http://192.168.0.2/network/mp.mp3";
		URL url = null;
		URLConnection con = null;
		
		InputStream is = null;
		BufferedInputStream bis = null;
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			//connect network
			url = new URL(urlstr);
			con = url.openConnection();
			
			//get data
			is = con.getInputStream();
			bis = new BufferedInputStream(is,10240);
			
			//save file
			fos = new FileOutputStream("newmp.mp3");
			bos = new BufferedOutputStream(fos);
		
			int data = 0;
			//-1 till the end of data
			while((data = bis.read()) != -1) {
				bos.write(data);
				System.out.println(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//shut down connections(stream)
			if(bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
