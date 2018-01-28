<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>服务预约管理</title>
</head>
<body class="rightBody">
<form id="form" name="form" action="${basePath }nsfw/reserve_deal.action" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>服务预约管理</strong>&nbsp;-&nbsp;服务预约</div></div>
    <div class="tableH2">预约信息<span style="color:red;">(<s:property value="#RESERVE_STATE_MAP[reserve.reserveState]"/>)</span></div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
    	<tr><td colspan="2" align="center">预约信息</td></tr>
        <tr>
            <td class="tdBg" width="250px">预约编号：</td>
            <td><s:property value="reserve.reserveNumber"/></td>
        </tr>
        <tr>
            <td class="tdBg">预约事项编号：</td>
            <td><s:property value="reserve.reserveItem.itemNumber"/></td>
        </tr>
        <tr>
            <td class="tdBg">预约事项名称：</td>
            <td><s:property value="reserve.reserveItem.itemName"/></td>
        </tr>
        <tr>
            <td class="tdBg">预约处理部门：</td>
            <td>
            <s:property value="reserve.reserveItem.dealDept"/>
            </td>
        </tr>
		<tr>
            <td class="tdBg">预约处理人：</td>
            <td>
            <s:property value="reserve.reserveItem.dealor"/>            
            </td>
        </tr>
		<tr>
            <td class="tdBg">预约时间：</td>
            <td>
            <s:date name="reserve.reserveDate" format="yyyy-MM-dd HH:mm"/>            
            </td>
        </tr>
		<tr>
            <td class="tdBg">预约地点：</td>
            <td>
            <s:property value="reserve.reserveAddress"/>            
            </td>
        </tr>
		<tr>
            <td class="tdBg">预约说明：</td>
            <td>
            <s:property value="reserve.reserveExplain"/>           
            </td>
        </tr>
        <tr><td colspan="2" align="center">预约人信息</td></tr>
        <tr>
            <td class="tdBg">预约人姓名：</td>
            <td><s:property value="reserve.reservor"/></td>
        </tr>
        <tr>
            <td class="tdBg">预约人手机号：</td>
            <td><s:property value="reserve.reservorMobile"/></td>
        </tr>          
        
        <tr><td colspan="2" align="center">处理操作</td></tr>
        <tr>
            <td class="tdBg">回复部门：</td>
            <td>
            <s:property value="#session.user.dept"/>
            </td>
        </tr>
        <tr>
            <td class="tdBg">回复人：</td>
            <td>
            <s:property value="#session.user.name"/>
            
            </td>
        </tr>
		<tr>
            <td class="tdBg" width="200px">处理结果：</td>
            <td><s:radio name="reserve.reserveState" list="#{'2':'预约成功','1':'预约失败'}"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">回复内容：</td>
            <td><s:textarea name="reserve.replyContent" cols="90" rows="8" /></td>
        </tr>
    </table>
    <s:hidden name="reserve.reserveId"/>
    <s:hidden name="strReserveState"/>
    <s:hidden name="strReserveNumber"/>
    <s:hidden name="strStartTime"/>
    <s:hidden name="strEndTime"/>
    <div class="tc mt20">
        <input type="submit" class="btnB2" value="保存" />
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
    </div></div></div>
</form>
</body>
</html>