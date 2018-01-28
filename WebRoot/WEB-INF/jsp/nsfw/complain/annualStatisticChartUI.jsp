<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	Calendar cal=Calendar.getInstance();
	int curYear=cal.get(Calendar.YEAR);
	request.setAttribute("curYear", curYear);
	List yearList=new ArrayList();
	for(int i=curYear;i>curYear-5;i--){
		yearList.add(i);
	}
	request.setAttribute("yearList", yearList);
%>

<!DOCTYPE HTML>
<html>
  <head>
    <%@include file="/common/header.jsp"%>
    <title>年度投诉统计图</title>
<script type="text/javascript" src="${basePath }js/fusioncharts/fusioncharts.js"></script>
<script type="text/javascript" src="${basePath }js/fusioncharts/themes/fusioncharts.theme.fint.js"></script>
<script type="text/javascript">
$(document).ready(doAnnualStatistic());
function doAnnualStatistic(){
	var year=$("#year option:selected").val();
	if(year==""||year==undefined){
		year="${curYear}";
	}
	$.ajax({
		url:"${basePath}nsfw/complain_getAnnualStatistic.action",
		data:{"year":year},
		type:"post",
		dataType:"json",
		success:function(data){
			if(data!=null&&data!=""&&data!=undefined){
				var revenueChart = new FusionCharts({
			        "type": "line",
			        "renderAt": "chartContainer",
			        "width": "500",
			        "height": "300",
			        "dataFormat": "json",
			        "dataSource":  {
			          "chart": {
			            "caption": "每月投诉统计表",
			            "xAxisName": "统  计  数",
			            "yAxisName": "月  份",
			            "theme": "fint"
			         },
			         "data": data.chartData
			      }

			  });
			revenueChart.render();
			}else{
				alert("获取统计失败");
			}
		},
		error:function(){
			alert("获取统计失败");
		}
	});
}
</script>
  </head>
  
  <body>
  	<br>
    <s:select id="year" list="%{#request.yearList}" onchange="doAnnualStatistic()"></s:select>
    <br>
    <div id="chartContainer"></div>
  </body>
</html>
