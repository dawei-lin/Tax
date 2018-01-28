<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>预约服务管理</title>

    <script>
    function getDealors(){
    	var dealDept=$("#dealDept option:selected").val();
    	$.ajax({
    		url:"${basePath}nsfw/reserveItem_getDealors.action",
    		data:{"dealDept":dealDept},
    		type:"post",
    		dataType:"json",
    		success:function(data){
    			if(data!=null&&data!=""&&data!=undefined){
    				if("success"==data.msg){
    					$("#dealor").empty();
    					$.each(data.userList,function(index,user){
    						$("#dealor").append("<option value='"+user.name+"'>"+user.name+"</option>");
    					});
    				}else{
    					alert("获取人员失败");
    				}
    			}else{
    				alert("获取人员失败");
    			}	
    		},
    		error:function(){
    			alert("获取人员失败");
    		}
    	});
    }
    </script>
</head>
<body class="rightBody">
<form id="form" name="form" action="${basePath}nsfw/reserveItem_add.action" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>预约事项</strong>&nbsp;-&nbsp;新增事项</div></div>
    <div class="tableH2">新增事项</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="200px">事项编号：</td>
            <td><s:textfield name="reserveItem.itemNumber"/></td>
            <td class="tdBg" width="200px">事项名称：</td>
            <td><s:textfield name="reserveItem.itemName"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">处理部门：</td>
            <td colspan="3"><s:select id="dealDept" name="reserveItem.dealDept" list="#{'':'','部门A':'部门A','部门B':'部门B' }" onchange="getDealors()"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">处理人：</td>
            <td colspan="3"><select id="dealor" name="reserveItem.dealor"></select></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">备注：</td>
            <td colspan="3"><s:radio name="reserveItem.state" list="#{ '1':'有效','0':'无效'}"/></td>
        </tr>
        <s:hidden name="strItemNumber"></s:hidden>
    	<s:hidden name="strItemName"></s:hidden>
    	<s:hidden name="strDealDept"></s:hidden>
    </table>

    <div class="tc mt20">
        <input type="submit" class="btnB2" value="保存" />
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
    </div></div></div>
</form>
</body>
</html>