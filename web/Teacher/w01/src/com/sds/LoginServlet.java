package com.sds;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.UserDb;
import com.frame.Db;
import com.vo.User;

@WebServlet({ "/LoginServlet", "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Db<String,User> db;
    
	public LoginServlet() {
        super();
        db = new UserDb("127.0.0.1", "db", "db");
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// Login 처리
		// 1. ID, PWD를 받는다.
		// 2. ID 값이 있는지 확인 한다.
		// 3. ID 값이 존재 하면 PWD가 동일 한지 확인 한다.
		// 4. 정상이면 정상 페이지로 비정상이면 비정상 페이지로 이동 한다.
		
		User dbuser = null;
		String flag = "f";
		try {
			dbuser = db.select(id);
			if(dbuser.getPwd().equals(pwd)) {
				flag = "o";
			}else {
				flag = "f";
			}
		} catch (Exception e) {
			flag = "f";
			e.printStackTrace();
		}
		
		
		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out = response.getWriter();
		if(flag.equals("o")) {
			out.print(id+" 환영합니다.");	
		}else {
			out.print("ID 또는 PWD 가 틀렸습니다.");
		}
		
	}

}





