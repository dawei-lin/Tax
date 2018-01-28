<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>预约服务管理</title>

    <script>
    $(document).ready(getDealors("<s:property value='reserveItem.dealDept'/>","<s:property value='reserveItem.dealor'/>"));
    function getDealors(dept,dealor){
    	var dealDept=$("#dealDept option:selected").val();
    	if(dealDept==null||dealDept==""||dealDept==undefined){
    		dealDept=dept;
    	}
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
    						if(dealor!=user.name){	
    							$("#dealor").append("<option value='"+user.name+"'>"+user.name+"</option>");
    						}else{
    							$("#dealor").append("<option value='"+user.name+"' selected='selected'>"+user.name+"</option>");
    						}
    					});
    				}else{
    					alert("获取人员失败1");
    				}
    			}else{
    				alert("获取人员失败2");
    			}	
    		},
    		error:function(){
    			alert("获取人员失败3");
    		}
    	});
    }
    </script>
</head>
<body class="rightBody">
<form id="form" name="form" action="${basePath}nsfw/reserveItem_edit.action" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>预约事项</strong>&nbsp;-&nbsp;修改事项</div></div>
    <div class="tableH2">修改事项</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="200px">事项编号：</td>
            <td><s:textfield name="reserveItem.itemNumber"/></td>
            <td class="tdBg" width="200px">事项名称：</td>
            <td><s:textfield name="reserveItem.itemName"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">处理部门：</td>
            <td colspan="3"><s:select id="dealDept" name="reserveItem.dealDept" list="#{'':'','部门A':'部门A','部门B':'部门B' }"  onchange="getDealors()"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">处理人：</td>
            <td colspan="3"><select id="dealor" name="reserveItem.dealor"></select></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">备注：</td>
            <td colspan="3"><s:radio name="reserveItem.state" list="#{'1':'有效','0':'无效'}"/></td>
        </tr>
        
    </table>
    <s:hidden name="reserveItem.itemId"/>
    <s:hidden name="strItemNumber"></s:hidden>
    <s:hidden name="strItemName"></s:hidden>
    <s:hidden name="strDealDept"></s:hidden>
    <div class="tc mt20">
        <input type="submit" class="btnB2" value="保存" />
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
    </div></div></div>
</form>
</body>
</html>