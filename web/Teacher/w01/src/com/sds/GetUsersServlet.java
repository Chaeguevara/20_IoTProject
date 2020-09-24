package com.sds;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.UserDb;
import com.frame.Db;
import com.vo.User;

@WebServlet({ "/GetUsersServlet", "/getusers" })
public class GetUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Db<String, User> db;
    public GetUsersServlet() {
        super();
        db = new UserDb("127.0.0.1", "db", "db");
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<User> list = null;
		try {
			list = db.select();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out = response.getWriter();
		for(User u:list) {
			out.print("<h2>");
			out.print("<a href=''>"+u.getId()+"</a>");
			out.print(u.getName());
			out.print("</h2>");
		}
	}

}





