package com.hive;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChartController {
	String url = "jdbc:hive2://192.168.111.130:10000/default";
	String userid = "root";
	String password = "111111";
	
	public ChartController() {
		try {
			Class.forName("org.apache.hive.jdbc.HiveDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/getdata2.mc")
	@ResponseBody
	public void getdata2(HttpServletResponse res) throws Exception {

		Connection con = null;
		JSONArray ja = new JSONArray();

		try {
			con = DriverManager.getConnection(url, userid, password);
			PreparedStatement pstmt = con.prepareStatement(
					"SELECT DISTINCT item as unique_line FROM book_click"
					);
			ResultSet rset = pstmt.executeQuery();
			
			// [] = json array
			// {} = json object
			// 1 json -> several json in a array
			while(rset.next()) {
				String s1 = rset.getString(1);
				JSONObject jo = new JSONObject();
				jo.put("name", s1);
				JSONArray ja2 =new JSONArray();
				PreparedStatement pstmt1 = con.prepareStatement("SELECT act, COUNT(*) FROM book_click WHERE item LIKE" +"'" +s1+"'"+"GROUP BY act");
				ResultSet rset1 = pstmt1.executeQuery();
				while(rset1.next()) {
					JSONObject jo1 = new JSONObject();
					jo1.put("name",rset1.getString(1));
					jo1.put("value",rset1.getInt(2));
					ja2.add(jo1);
				}
				jo.put("data",ja2);
				ja.add(jo);
				
			}
		}catch(Exception e) {
			throw e;
		}finally {
			con.close();

		}
        res.setCharacterEncoding("EUC-KR");
        res.setContentType("application/json");
        PrintWriter out = res.getWriter();
        out.print(ja.toJSONString());
        out.close();
	}
	
	
	@RequestMapping("/getdata1.mc")
	@ResponseBody
	public void getdata1(HttpServletResponse res) throws Exception {

		Connection con = null;
		JSONArray ja = new JSONArray();

		try {
			con = DriverManager.getConnection(url, userid, password);
			PreparedStatement pstmt = con.prepareStatement(
					"SELECT * FROM hdi limit 10"
					);
			ResultSet rset = pstmt.executeQuery();
			
			// [{name: 'Sweden',data:[0.904 81.0 11.0]},{}]
			while(rset.next()) {
				JSONObject jo = new JSONObject();
				jo.put("name", rset.getString(2));
				JSONArray jo2 = new JSONArray();
				jo2.add(rset.getFloat(3));
				jo2.add(rset.getFloat(4));
				jo2.add(rset.getFloat(5));
				jo.put("data", jo2);
				
				ja.add(jo);
			}
		}catch(Exception e) {
			throw e;
		}finally {
			con.close();

		}
        res.setCharacterEncoding("EUC-KR");
        res.setContentType("application/json");
        PrintWriter out = res.getWriter();
        out.print(ja.toJSONString());
        out.close();
	}
	
}



















