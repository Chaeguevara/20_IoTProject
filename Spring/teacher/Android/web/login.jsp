<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	System.out.println("Test");
	System.out.println("date.jsp");
	if (id.equals("qqq") && pwd.equals("abc")) {
		out.print("1");
		System.out.println("ok");
	} else {
		out.print("0");
		System.out.println("fail");
	}
	
%>