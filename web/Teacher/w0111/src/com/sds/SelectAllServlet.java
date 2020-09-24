package com.sds;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UserController;
import frame.Controller;
import vo.User;

@WebServlet({ "/SelectAllServlet", "/selectall" })
public class SelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Controller<String, User> controller;
	
    public SelectAllServlet() {
        super();
        controller = new UserController();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Database에서 데이터를 가지고 온다.
		ArrayList<User> list = null;
		try {
			list = controller.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 2. 가지고 온 데이터를 request 에 셋팅 한다.
		// 3. main 페이지로 이동한다.
		// 4. centerpage 를 셋팅한다.
		request.setAttribute("userlist", list);
		request.setAttribute("centerpage", "selectall");
		RequestDispatcher rd = 
		request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
		
	}

}






