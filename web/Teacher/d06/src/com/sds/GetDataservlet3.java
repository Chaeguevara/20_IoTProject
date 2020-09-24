package com.sds;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet({ "/GetDataservlet3", "/getdata3" })
public class GetDataservlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1.DB 에서 데이터를 가지고 온다.
		ArrayList<User> list = new ArrayList<>();
		list.add(new User("id01", "pwd01", "이말숙"));
		list.add(new User("id02", "pwd02", "김말숙"));
		list.add(new User("id03", "pwd03", "정말숙"));
		list.add(new User("id04", "pwd04", "장말숙"));
		list.add(new User("id05", "pwd05", "고말숙"));
		// 2. JSON으로 만든다.
//		JSONArray ja = new JSONArray();
//		JSONObject jo1 = new JSONObject();
//		jo1.put("id", "id01");
//		jo1.put("pwd", "pwd01");
//		jo1.put("name", "이말숙");
//		ja.add(jo1);
		
		JSONArray ja = new JSONArray();
		for(User u:list) {
			JSONObject obj = new JSONObject();
			obj.put("id", u.getId());
			obj.put("pwd", u.getPwd());
			obj.put("name", u.getName());
			ja.add(obj);
		}
		
		
		// 3. JSON 데이터를 Response 한다.
		response.setContentType("text/json;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.print(ja.toJSONString());
	}

}




