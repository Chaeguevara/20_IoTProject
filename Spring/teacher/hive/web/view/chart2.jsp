<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

function display(data){
	Highcharts.chart('container', {
	    chart: {
	        type: 'packedbubble',
	        height: '100%'
	    },
	    title: {
	        text: 'Carbon emissions around the world (2014)'
	    },
	    tooltip: {
	        useHTML: true,
	        pointFormat: '<b>{point.name}:</b> {point.value}명 /month'
	    },
	    plotOptions: {
	        packedbubble: {
	            minSize: '10%',
	            maxSize: '100%',
	            zMin: 0,
	            zMax: 200,
	            layoutAlgorithm: {
	                splitSeries: false,
	                gravitationalConstant: 0.02
	            },
	            dataLabels: {
	                enabled: true,
	                format: '{point.name}',
	                filter: {
	                    property: 'y',
	                    operator: '>',
	                    value: 250
	                },
	                style: {
	                    color: 'black',
	                    textOutline: 'none',
	                    fontWeight: 'normal'
	                }
	            }
	        }
	    },
	    series: data
	});
};

function getData() {
	$.ajax({
		url : 'getdata2.mc',
		success : function(data) {
			display(data);
		},
		error : function() {
		}
	});
	//display();
};

$(document).ready(function() {
	getData();
});
</script>
</head>
<h1>chart2</h1>
<div id="container"></div>
</html>