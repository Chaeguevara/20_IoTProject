<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>


<script>
	function fetchdata() {
		$.ajax({
			url : 'statusToBrower.mc',
			type : 'post',
			success : function(response) {
				// Perform operation on the return value
				$('#iotStatus').html(response);
			}
		});
	}
	function fetchcmd() {
		$.ajax({
			url : 'itemToBrower.mc',
			type : 'post',
			success : function(response) {
				// Perform operation on the return value
				$('#lastScan').html("Last scanned : " + response);
			}
		});
	}
	$(document).ready(function() {
		$('#iot_s').click(function() {
			$.ajax({
				url : 'iotStart.mc',
				success : function(data) {
					alert('Send Complete...');
				}
			});
		});
		setInterval(fetchdata, 500);
		setInterval(fetchcmd, 500);
		$('#iot_t').click(function() {
			$.ajax({
				url : 'iotStop.mc',
				success : function(data) {
					alert('Send Complete...');
				}
			});
		});
		
		$('#phone').click(function() {
			$.ajax({
				url : 'phone.mc',
				success : function(data) {
					alert('Send Complete...');
				}
			});
		});
		
	});
</script>


</head>
<body>

	<h1>Main Page</h1>
	<h2>IoT장비 IP설정</h2>
	<form id="IoTsubmit" action="IoTsubmit.mc" method="post">
		<div>
			<input type="text" name="id" placeholder="/xxx.xxx.xxx.xxx">
		</div>
		<div>
			<input type="submit" value="IP등록">
		</div>
	</form>
	<h2 id="iotIP"></h2>
	<h2>
		<a id="iot_s" href="#">Start IoT(TCP/IP)</a>
	</h2>
	<h2>
		<a id="iot_t" href="#">Stop IoT(TCP/IP)</a>
	</h2>
	<h2>
		<a id="phone" href="#">Send Phone(FCM)</a>
	</h2>
	<h2>IoT Status</h2>
	<h3 id="iotStatus"></h3>
	<h3 id="lastScan"></h3>




</body>
</html>