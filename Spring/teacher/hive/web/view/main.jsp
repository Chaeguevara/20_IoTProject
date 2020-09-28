<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/series-label.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>


</head>
<body>
<h1>Main Page</h1>
<ul>
	<li><a href="shop.mc?id=id01&item=it01&price=30000">Pants(30000)</a></li>
	<li><a href="shop.mc?id=id01&item=it02&price=20000">Shirts(20000)</a></li>
	<li><a href="shop.mc?id=id01&item=it03&price=50000">Shoes(50000)</a></li>
	<li><a href="shop.mc?id=id01&item=it04&price=10000">T-Shirts(10000)</a></li>
</ul>
<h3><a href="chart1.mc">Chart1</a></h3>
<h3><a href="chart2.mc">Chart2</a></h3>
<h3><a href="chart3.mc">Chart3</a></h3>
	<c:choose>
		<c:when test="${centerpage == null }">
		   <jsp:include page="center.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
		   <jsp:include page="${centerpage}.jsp"></jsp:include>
		</c:otherwise>
	</c:choose>

</body>
</html>




