<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
*{
	margin:0;
	padding:0;
}
header{
	width:700px;
	height:150px;
	background:red;
	margin:0 auto;
}
header > h1 {
	margin:0 auto;
	width:200px;
}
header > ul {
	margin:0 auto;
	width:500px;
	list-style: none;
}
header > ul > li{
	float:left;
	margin:0 10px;
}
section{
	width:700px;
	height:600px;
	background:gray;
	margin:0 auto;
}
section > #center{
	width:500px;
	background:white;
	margin:0 auto;
	text-align: center;
}
footer{
	width:700px;
	height:30px;
	background:black;
	margin:0 auto;
}

</style>
</head>

<body>
<header>
	<h1>Main Page</h1>
	<ul>
		<li><a href="main.nhn">MAIN</a></li>
		<li><a href="login.nhn">LOGIN</a></li>
		<li><a href="register.nhn">REGISTER</a></li>
		<li><a href="selectall.nhn">SELECTALL</a></li>
	</ul>	
</header>
<section>
	<c:choose>
		<c:when test="${centerpage == null }">
		   <jsp:include page="center.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
		   <jsp:include page="${centerpage}.jsp"></jsp:include>
		</c:otherwise>
	</c:choose>
	
	
</section>
<footer></footer>
</body>
</html>






