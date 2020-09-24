package com.sds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/DispatcherServlet", "/dispatcher" })
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DispatcherServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		path = path.substring(1, path.lastIndexOf("."));
		System.out.println("request:"+path);
		String next = "main.jsp";
		if(path.equals("main")) {
			next = "main.jsp";
		}else if(path.equals("login")) {
			next = "main.jsp";
			request.setAttribute("centerpage", "login");
		}else if(path.equals("register")) {
			next = "main.jsp";
			request.setAttribute("centerpage", "register");
		}else if(path.equals("loginimpl")) {
			next = "loginimpl";
		}else if(path.equals("registerimpl")) {
			next = "registerimpl";
		}
		RequestDispatcher rd = 
		request.getRequestDispatcher(next);
		rd.forward(request, response);

	}

}





