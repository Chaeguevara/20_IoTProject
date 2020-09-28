package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class get4 {
	public static void main(String[] args) throws Exception{
	String url = "jdbc:hive2://192.168.111.120:10000/default";
	String id = "root"; //만든 id
	String password = "111111"; 
	Class.forName("org.apache.hive.jdbc.HiveDriver");
	Connection con = DriverManager.getConnection(url,id,password);
	PreparedStatement pstmt = con.prepareStatement("SELECT * FROM seoul_sub");
	ResultSet rset = pstmt.executeQuery();
	
	//[{},{}]
	while (rset.next()){
		int s1 = rset.getInt(1);
		String s2 = rset.getString(2);
		String s3 = rset.getString(3);
		int s4 = rset.getInt(4);
		int s5 = rset.getInt(5);
		System.out.println(s1+" "+s2+" "+s3+" "+s4+" "+s5);
	}
	con.close();
	}
	
}