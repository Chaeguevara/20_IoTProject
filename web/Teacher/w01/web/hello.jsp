<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
Random r = new Random();
int num = r.nextInt(10)+1;

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>Hello Servlet</h1>
<h2>Number: <%=num %></h2>
</body>
</html>





