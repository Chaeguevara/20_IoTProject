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

@WebServlet({ "/GeoServlet", "/geo" })
public class GeoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		
		ArrayList<Geo> list = new ArrayList<>();
		JSONArray ja = new JSONArray();
		
		if(cmd.equals("0")) {
			for(Geo geo: list) {
				JSONObject jo = new JSONObject();
				jo.put("name", geo.getName());
				jo.put("lat", geo.getLat());
				jo.put("lng", geo.getLng());
				jo.put("url", geo.getUrl());
				ja.add(jo);
			}
		}else if(cmd.equals("1")) {
			
		}
		response.setContentType("text/json;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.print(ja.toJSONString());
		
	}

}








