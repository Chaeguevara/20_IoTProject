package com.sds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/LoginImplServlet", "/loginimpl" })
public class LoginImplServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginImplServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		//System.out.println(id+" "+pwd);
		if(id.equals("qq") && pwd.equals("11")) {
			request.setAttribute("loginid", id);
			request.setAttribute("centerpage", "loginok");
		}else {
			request.setAttribute("centerpage", "loginfail");
		}
		RequestDispatcher rd = 
		request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
		
	}

}




