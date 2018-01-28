<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("basePath", request.getContextPath()+"/") ;
%>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>我要预约</title>
    <script type="text/javascript" src="${basePath}js/datepicker/WdatePicker.js"></script>
    <script type="text/javascript">
    	function doAdd(){
    		document.forms[0].action="${basePath }sys/home_reserveAdd.action";
    		document.forms[0].submit();
    		/* window.opener.parent.location.reload(true);
			window.close(); */
    	}
    </script>
</head>
<body>
<form id="form" name="form" action="" method="post" enctype="multipart/form-data">
    <div class="vp_d_1">
        <div style="width=1%;float:left;">&nbsp;&nbsp;&nbsp;&nbsp;</div>
        <div class="vp_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>工作主页</strong>&nbsp;-&nbsp;我要预约</div></div>
    <div class="tableH2">我要预约</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="250px">预约事项：</td>
            <td><s:select name="reserveItem.itemName" list="#itemNameList"></s:select></td>
        </tr>
        <tr>
            <td class="tdBg">预约时间：</td>
            <td><s:textfield name="strReserveDate" cssClass="s_text"  cssStyle="width:160px;" 
                       	readonly="true" onfocus="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM--dd HH:mm'});"/></td>
        </tr>
        <tr>
            <td class="tdBg">预约地点：</td>
            <td><s:textfield name="reserve.reserveAddress"></s:textfield></td>
        </tr>
        <tr>
            <td class="tdBg">预约说明：</td>
            <td><s:textfield name="reserve.reserveExplain"></s:textfield></td>
        </tr>
        <tr>
            <td class="tdBg">预约人：</td>
            <td><s:property value="#session.user.name"/></td>
        </tr>
       <s:hidden name="reserve.reservor" value="%{#session.user.name}"></s:hidden>
       <s:hidden name="reserve.reservorMobile" value="%{#session.user.mobile}"></s:hidden>
    </table>

    <div class="tc mt20">
        <input type="submit" class="btnB2" value="保存" onclick="doAdd()"/>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="window.close()" class="btnB2" value="关闭" />
    </div>
    </div></div>
    <div style="width=1%;float:left;">&nbsp;&nbsp;&nbsp;&nbsp;</div>
    </div>
</form>
</body>
</html>