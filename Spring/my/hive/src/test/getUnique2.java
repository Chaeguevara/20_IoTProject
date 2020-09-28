package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class getUnique2 {
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
		PreparedStatement pstmt1 = con.prepareStatement("SELECT station_name, SUM(ride_count), SUM(leave_count) FROM seoul_sub WHERE line LIKE " +"'"+ s1 +"'"+ " GROUP BY station_name");
		ResultSet rset1 = pstmt1.executeQuery();
		while(rset1.next()) {
			String station_name = rset1.getString(1);
			int sub1 = rset1.getInt(2);
			int sub2 = rset1.getInt(3);
			System.out.println(station_name + sub1 + sub2);
		}
		System.out.println(s1);
	}
	con.close();
	}
	
}