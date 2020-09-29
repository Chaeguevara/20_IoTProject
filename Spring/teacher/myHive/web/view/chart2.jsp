<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
#center{
	width:800px;
	height:500px;
	border:2px solid red;
}
.highcharts-figure, .highcharts-data-table table {
    min-width: 320px; 
    max-width: 800px;
    margin: 1em auto;
}

.highcharts-data-table table {
	font-family: Verdana, sans-serif;
	border-collapse: collapse;
	border: 1px solid #EBEBEB;
	margin: 10px auto;
	text-align: center;
	width: 100%;
	max-width: 500px;
}
.highcharts-data-table caption {
    padding: 1em 0;
    font-size: 1.2em;
    color: #555;
}
.highcharts-data-table th {
	font-weight: 600;
    padding: 0.5em;
}
.highcharts-data-table td, .highcharts-data-table th, .highcharts-data-table caption {
    padding: 0.5em;
}
.highcharts-data-table thead tr, .highcharts-data-table tr:nth-child(even) {
    background: #f8f8f8;
}
.highcharts-data-table tr:hover {
    background: #f1f7ff;
}


</style>

<script>
function display(data){
	Highcharts.chart('container', {
	    chart: {
	        type: 'packedbubble',
	        height: '100%'
	    },
	    title: {
	        text: '커버 이미지 / 제목 / 저자이름 클릭 로그 데이터 시각화'
	    },
	    tooltip: {
	        useHTML: true,
	        pointFormat: '<b>{point.name}클릭 횟수:</b> {point.value}'
	    },
	    plotOptions: {
	        packedbubble: {
	            minSize: '20%',
	            maxSize: '100%',
	            zMin: 0,
	            zMax: 1000,
	            layoutAlgorithm: {
	                gravitationalConstant: 0.05,
	                splitSeries: true,
	                seriesInteraction: false,
	                dragBetweenSeries: true,
	                parentNodeLimit: true
	            },
	            dataLabels: {
	                enabled: true,
	                format: '{point.name}',
	                filter: {
	                    property: 'y',
	                    operator: '>',
	                    value: 15
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

function getData(){
	$.ajax({
		url:'getdata2.mc',
		success:function(data){
			display(data);
		},
		error:function(){}
	});
};

$(document).ready(function(){
	getData();
});
</script>

<h1>Chart2</h1>
<div id="container">

</div>