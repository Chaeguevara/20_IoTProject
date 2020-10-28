package com.http;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client {

	public static void main(String[] args) {
		String urlstr = "http://192.168.0.2/network/login.jsp";
		URL url = null;
		HttpURLConnection con = null;
		String id = "qqq";
		String pwd = "abc";
		InputStream is = null;
		String result = null;
		
		try {
			url = new URL(urlstr+"?id="+id+"&pwd="+pwd);
			System.out.println(url);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.getInputStream();
			is = new BufferedInputStream(con.getInputStream());
			result = convertStr(is);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.disconnect();
		}
		
		Login(result);
	}
	
	public static void Login(String s) {
		String result = s.trim();
		if(result.equals("1")) {
			System.out.println("Login success");
			return;
		}
		if(result.equals("2")) {
			System.out.println("Login failed");
			return;
		}		
	}
	
	public static String convertStr(InputStream is) {
        String result = null;
        BufferedReader bi = null;
        StringBuilder sb = new StringBuilder();
        try{
            bi = new BufferedReader(
                    new InputStreamReader(is)
            );
            String temp = "";
            while((temp =bi.readLine()) != null){
                sb.append(temp);
            }
        }catch(Exception e){
            e.printStackTrace();
        } finally {
        	if (bi != null) {
        		try {
    				bi.close();
    			} catch (IOException e) {
    				e.printStackTrace();
    			}	
        	}
        	
        }
        
        return sb.toString();
	}

}
