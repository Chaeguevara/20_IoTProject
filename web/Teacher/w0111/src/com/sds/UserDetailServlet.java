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

@WebServlet({ "/UserDetailServlet", "/userdetail" })
public class UserDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Controller<String, User> controller;
	
    public UserDetailServlet() {
        super();
        controller = new UserController();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		User dbuser = null;
		try {
			dbuser = controller.get(id);
			request.setAttribute("userdetail", dbuser);
			request.setAttribute("centerpage", "userdetail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = 
		request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}

}


