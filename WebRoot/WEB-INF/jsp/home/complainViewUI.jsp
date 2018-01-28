<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("basePath", request.getContextPath()+"/") ;
%>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>投诉信息</title>
</head>
<body class="rightBody">
    <div class="vp_d_1">
    <div style="width:1%;float:left;">&nbsp;&nbsp;&nbsp;&nbsp;</div>
        <div class="vp_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>工作主页</strong>&nbsp;-&nbsp;投诉信息</div></div>
    <div class="tableH2">投诉详细信息<span style="color:red;"><s:property value="#complainStateMap[complain.compState]"/></span></div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
    	<tr><td colspan="2" align="center">投诉人信息</td></tr>
        <tr>
            <td class="tdBg" width="250px">是否匿名投诉：</td>
            <td><s:property value="complain.isNm?'匿名':'非匿名'"/></td>
        </tr>
        <tr>
            <td class="tdBg">投诉人单位：</td>
            <td><s:if test="!complain.isNm"><s:property value="complain.compCompany"/></s:if></td>
        </tr>
        <tr>
            <td class="tdBg">投诉人姓名：</td>
            <td><s:if test="!complain.isNm"><s:property value="complain.compName"/></s:if></td>
        </tr>
        <tr>
            <td class="tdBg">投诉人手机：</td>
            <td>
            <s:if test="!complain.isNm">
            <s:property value="complain.compPhone"/>
            </s:if>
            <s:elseif test="%{complain.compPhone.length()>0}">
            <s:property value="%{complain.compPhone.substring(0,3)+'****'+complain.compPhone.substring(7,11)}"/>
            </s:elseif>
            </td>
        </tr>
        <tr><td colspan="2" align="center">投诉信息</td></tr>
        <tr>
            <td class="tdBg">投诉时间：</td>
            <td><s:date name="complain.compDate" format="yyyy-MM-dd HH:mm"/></td>
        </tr>
        <tr>
            <td class="tdBg">被投诉部门：</td>
            <td><s:property value="complain.toCompDept"/></td>
        </tr>
        <tr>
            <td class="tdBg">被投诉人：</td>
            <td><s:property value="complain.toCompName"/></td>
        </tr>
        <tr>
            <td class="tdBg">投诉标题：</td>
            <td><s:property value="complain.toCompTitle"/></td>
        </tr>
        <tr>
            <td class="tdBg">投诉内容：</td>
            <td><s:property value="complain.toCompContent" escape="false"/></td>
        </tr>
        <tr><td colspan="2" align="center">受理信息</td></tr>
        <tr>
            <td colspan="2">
            		<s:iterator value="complain.complainReplies" status="vs">
            		<fieldset style="border: solid 1px #c0c0c0;margin-top:5px;"><legend style="color:green;font-weight:bold;">回复1&nbsp;</legend>
						<div style="width:100%; text-align:center;color:#ccc;maring-top:5px;">
						回复部门：<s:property value="replyDept"/>&nbsp;&nbsp;
						回复人：<s:property value="replyName"/>&nbsp;&nbsp;
						回复时间：<s:date name="replyDate" format="yyyy-MM-dd HH mm"/>
						</div>
						<div style="width:100%;maring-top:10px;font-size:13px;padding-left:5px;"><s:property value="replyContent"/></div>
					</fieldset>
            		</s:iterator>
            </td>
        </tr>
    </table>
    </div></div>
    <div style="width:1%;float:left;">&nbsp;&nbsp;&nbsp;&nbsp;</div>
    </div>
</body>
</html>