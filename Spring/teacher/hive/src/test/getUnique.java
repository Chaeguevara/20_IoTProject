package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class getUnique {
	public static void main(String[] args) throws Exception{
	String url = "jdbc:hive2://192.168.111.120:10000/default";
	String id = "root"; //만든 id
	String password = "111111"; 
	Class.forName("org.apache.hive.jdbc.HiveDriver");
	Connection con = DriverManager.getConnection(url,id,password);
	PreparedStatement pstmt = con.prepareStatement("SELECT DISTINCT line as unique_line FROM seoul_sub");
	ResultSet rset = pstmt.executeQuery();
	
	//[{},{}]
	while (rset.next()){		
		String s1 = rset.getString(1);
		System.out.println(s1);
	}
	con.close();
	}
	
}