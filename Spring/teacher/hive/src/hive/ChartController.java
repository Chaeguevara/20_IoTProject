package hive;

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

	String url = "jdbc:hive2://192.168.111.120:10000/default";
	String id = "root"; // 만든 id
	String password = "111111";

	// 한번만 선언되면 됨
	public ChartController() {
		try {
			Class.forName("org.apache.hive.jdbc.HiveDriver");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/getdata1.mc")
	@ResponseBody
	public void getdata1(HttpServletResponse res) throws Exception {
		Connection con = null;
		JSONArray ja = new JSONArray();
		try {
			con = DriverManager.getConnection(url, id, password);
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM hdi limit 10");
			ResultSet rset = pstmt.executeQuery();

			// [{name:Norway},{data:0.943 81.0 12.0 }]
			// 어레이에 오브젝을 하나씩 만든다
			while (rset.next()) {
				JSONObject jo = new JSONObject();
				jo.put("name", rset.getString(2));
				JSONArray jo2 = new JSONArray();
				jo2.add(rset.getFloat(3));
				jo2.add(rset.getFloat(4));
				jo2.add(rset.getFloat(5));
				jo.put("data", jo2);
				ja.add(jo);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			con.close();
		}
		res.setCharacterEncoding("EUC-KR");
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		out.print(ja.toJSONString());
		out.close();
	}
	
	@RequestMapping("/getdata2.mc")
	@ResponseBody
	public void getdata2(HttpServletResponse res) throws Exception {
		System.out.println("Chart2 requested");
		Connection con = null;
		JSONArray ja = new JSONArray();
		try {
			con = DriverManager.getConnection(url, id, password);
			PreparedStatement pstmt = con.prepareStatement("SELECT DISTINCT line as unique_line FROM seoul_sub");
			ResultSet rset = pstmt.executeQuery();

			// [{name:region},data[{name:country},{value:number}]]
			// json1,json2(json3,json4)
			// {} = JSONObject, [] = JSONArray
			// 이전 것에선 제이손 오브젝트에 
			//{name:00,data:[]}
			//
			//[{name:line,data:[{name:station,value:number}]},{},{}]
			// 어레이에 오브젝을 하나씩 만든다
			while (rset.next()) {
				String s1 = rset.getString(1);
				JSONObject jo = new JSONObject();
				jo.put("name", s1);
				PreparedStatement pstmt1 = con.prepareStatement("SELECT station_name, SUM(ride_count), SUM(leave_count) FROM seoul_sub WHERE line LIKE " +"'"+ s1 +"'"+ " GROUP BY station_name");
				ResultSet rset1 = pstmt1.executeQuery();
				JSONArray ja1 = new JSONArray();
				while(rset1.next()) {
					JSONObject jo1 = new JSONObject();
					String station_name = rset1.getString(1);
					int ride_count = rset1.getInt(2);
					jo1.put("name", station_name);
					jo1.put("value",ride_count);
					ja1.add(jo1);
					System.out.println("Chart2 Inner loop ok: "+ station_name);
				}
				jo.put("data", ja1);
				ja.add(jo);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			con.close();
		}
		res.setCharacterEncoding("EUC-KR");
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		out.print(ja.toJSONString());
		out.close();
	}
}
