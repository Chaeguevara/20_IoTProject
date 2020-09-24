package com.sds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UserController;
import frame.Controller;
import vo.User;

@WebServlet({ "/RegisterImplServlet", "/registerimpl" })
public class RegisterImplServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Controller<String, User> controller;
	
    public RegisterImplServlet() {
        super();
        controller = new UserController();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		
		User user = new User(id, pwd, name);
		
		try {
			controller.register(user);
			request.setAttribute("registeruser", user);
			request.setAttribute("centerpage", "registerok");
		} catch (Exception e) {
			request.setAttribute("centerpage", "registerfail");
			e.printStackTrace();
		}
		
	
		RequestDispatcher rd = 
		request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}

}







