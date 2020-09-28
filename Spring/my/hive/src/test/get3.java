package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class get3 {
	public static void main(String[] args) throws Exception{
	String url = "jdbc:hive2://192.168.111.120:10000/default";
	String id = "root"; //만든 id
	String password = "111111"; 
	Class.forName("org.apache.hive.jdbc.HiveDriver");
	Connection con = DriverManager.getConnection(url,id,password);
	PreparedStatement pstmt = con.prepareStatement("SELECT * FROM hdi limit 10");
	ResultSet rset = pstmt.executeQuery();
	
	//[{name:Norway},{data:0.943 81.0 12.0 }]
	//어레이에 오브젝을 하나씩 만든다
	JSONArray ja = new JSONArray();
	while (rset.next()){
		JSONObject jo = new JSONObject();
		jo.put("name", rset.getString(2));
		JSONArray jo2 = new JSONArray();
		jo2.add(rset.getFloat(3));
		jo2.add(rset.getFloat(4));
		jo2.add(rset.getFloat(5));
		jo.put("data", jo2);
		ja.add(jo);
	}
	System.out.println(ja.toJSONString());
	con.close();
	}
	
}