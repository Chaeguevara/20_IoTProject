package d01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class mariatest {
	public static void main(String[] args) throws Exception{
	String url = "jdbc:hive2://192.168.111.120:10000/default";
	String id = "root"; //만든 id
	String password = "111111"; 
	Class.forName("org.apache.hive.jdbc.HiveDriver");
	Connection con = DriverManager.getConnection(url,id,password);
	PreparedStatement pstmt = con.prepareStatement("SELECT Year, avg(ArrDelay), avg(DepDelay) FROM airline_delay\r\n"
			+"WHERE delayYear=2006\r\n"+
			"GROUP BY Year\r\n");
	ResultSet rset = pstmt.executeQuery();
	while (rset.next()){
		String did = rset.getString(1);
		String name = rset.getString(2);
		System.out.println(did+" "+name);
	}
	con.close();
	}
	
}