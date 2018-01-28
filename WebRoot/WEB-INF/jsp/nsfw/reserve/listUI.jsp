<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>服务预约管理</title>
    <script type="text/javascript" src="${basePath}js/datepicker/WdatePicker.js"></script>
    <script type="text/javascript">
    function doSelectAll(){
		// jquery 1.6 前
		//$("input[name=selectedRow]").attr("checked", $("#selAll").is(":checked"));
		//prop jquery 1.6+建议使用
		$("input[name=selectedRow]").prop("checked", $("#selAll").is(":checked"));		
	}
    function doSearch(){
  	  document.forms[0].action="${basePath}nsfw/reserve_listUI.action";
  	  document.forms[0].submit();
    }
    function doDeal(reserveId){
    	document.forms[0].action="${basePath}nsfw/reserve_dealUI.action?reserve.reserveId="+reserveId;
    	document.forms[0].submit();
    }
    function doGoPage(currentPage){
		$("#currentPage").val(currentPage);
		document.forms[0].action="${basePath}nsfw/reserve_listUI.action";
		document.forms[0].submit();
	}
    </script>
</head>
<body class="rightBody">
<form name="form1" action="" method="post">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
                <div class="c_crumbs"><div><b></b><strong>服务预约管理</strong></div> </div>
                <div class="search_art">
                    <li>
                       	预约编号：<s:textfield name="reserve.reserveNumber" cssClass="s_text"  cssStyle="width:160px;"/>
                    </li>
                    <li>
                       	预约时间：<s:textfield id="startTime" name="startTime" cssClass="s_text"  cssStyle="width:160px;"
                       	 readonly="true" onfocus="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM--dd HH:mm'});"/>
                              - 
                             <s:textfield id="endTime" name="endTime" cssClass="s_text"  cssStyle="width:160px;"
                              readonly="true" onfocus="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM--dd HH:mm'});"/>
                    </li>
                    <li>
                       	状态：<s:select name="reserve.reserveState" list="#{'':'全部','1':'预约失败','2':'预约成功' }"/>
                    </li>
                    <li><input type="button" class="s_button" value="搜 索" onclick="doSearch()"/></li>
                    <li style="float:right;"></li>
                </div>

                <div class="t_list" style="margin:0px; border:0px none;">
                    <table width="100%" border="0">
                        <tr class="t_tit">
                            <td align="center">预约编号</td>
                            <td width="120" align="center">预约事项</td>
                            <td width="120" align="center">预约地点</td>
                            <td width="140" align="center">预约时间</td>
                            <td width="100" align="center">预约人姓名</td>
                            <td width="100" align="center">状态</td>
							<td width="100" align="center">操作</td>
                        </tr>
                       		<s:iterator value="pageResult.items">
                            <tr bgcolor="f8f8f8">
                                <td align="center"><s:property value="reserveNumber"/></td>
                                <td align="center"><s:property value="reserveItem.itemName"/></td>
                                <td align="center"><s:property value="reserveAddress"/></td>
                                <td align="center"><s:date name="reserveDate" format="yyyy-MM-dd HH:mm"/></td>
                                <td align="center"><s:property value="reservor"/></td>
								<td align="center"><s:property value="#RESERVE_STATE_MAP[reserveState]"/></td>
                                <td align="center">
                                	<s:if test="reserveState==0">
                                    <a href="javascript:doDeal('<s:property value='reserveId'/>')">处理</a>
                                    </s:if>
                                </td>
                            </tr>
                        	</s:iterator>
                    </table>
                </div>
            </div>

        <%@include file="/common/pagenavigator.jsp" %>
        </div>
    </div>
</form>

</body>
</html>