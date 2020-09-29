package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class getUnique2 {
	public static void main(String[] args) throws Exception{
	String url = "jdbc:hive2://192.168.111.130:10000/default";
	String id = "root"; //만든 id
	String password = "111111"; 
	Class.forName("org.apache.hive.jdbc.HiveDriver");
	Connection con = DriverManager.getConnection(url,id,password);
	PreparedStatement pstmt = con.prepareStatement("SELECT DISTINCT item as unique_line FROM book_click");
	ResultSet rset = pstmt.executeQuery();
	
	//[{},{}]
	try {
		while (rset.next()){		
			String s1 = rset.getString(1);
			System.out.println(s1);
			PreparedStatement pstmt1 = con.prepareStatement("SELECT act, COUNT(*) FROM book_click WHERE item LIKE" +"'" +s1+"'"+"GROUP BY act");
			ResultSet rset1 = pstmt1.executeQuery();
			while(rset1.next()) {
				String s2 = rset1.getString(1);
				String s3 = rset1.getString(2);
				System.out.println(s2 + s3);
			}
		}
					
			
	}catch(Exception e){
		throw e;
	}finally {
		con.close();
	}

	
	}

}