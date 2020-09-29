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

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/highcharts-more.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>



</head>
<body>
<h1>Main Page</h1>


<table>
	<tr>
		<th>이미지</th>
		<th>이름</th>
		<th>저자</th>
	</tr>
	<tr>
		<th><a href="book.mc?id=id01&item=it01&act=img"><img src="view/assets/img/money.jpg" width="100"></a></th>
		<th><a href="book.mc?id=id01&item=it01&act=title">돈의 속성</a></th>
		<th><a href="book.mc?id=id01&item=it01&act=name">김승호 </a></th>
	</tr>
	<tr>
		<th><a href="book.mc?id=id01&item=it02&act=img"><img src="view/assets/img/meet.jpg" width="100"></a></th>
		<th><a href="book.mc?id=id01&item=it02&act=title">만남은 지겹고 이별은 지쳤다</a></th>
		<th><a href="book.mc?id=id01&item=it02&act=name">색과 체 </a></th>
	</tr>
	<tr>
		<th><a href="book.mc?id=id01&item=it03&act=img"><img src="view/assets/img/plan.jpg" width="100"></a></th>
		<th><a href="book.mc?id=id01&item=it03&act=title">슬기로운 방구석 플랜B</a></th>
		<th><a href="book.mc?id=id01&item=it03&act=name">박희진 </a></th>
	</tr>
</table>
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




