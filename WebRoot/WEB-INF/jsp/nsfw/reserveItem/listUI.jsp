<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>预约服务管理</title>
    <script type="text/javascript">
    function doSelectAll(){
		// jquery 1.6 前
		//$("input[name=selectedRow]").attr("checked", $("#selAll").is(":checked"));
		//prop jquery 1.6+建议使用
		$("input[name=selectedRow]").prop("checked", $("#selAll").is(":checked"));		
	}
      function doAdd(){
    	  document.forms[0].action="${basePath}nsfw/reserveItem_addUI.action";
    	  document.forms[0].submit();
      }
      function doGoPage(currentPage){
    		$("#currentPage").val(currentPage);
    		document.forms[0].action="${basePath}nsfw/reserveItem_listUI.action";
    		document.forms[0].submit();
    	}
      function doDeleteAll(){
    		document.forms[0].action="${basePath}nsfw/reserveItem_deleteSelected.action";
    		document.forms[0].submit();
    	}
      function doSearch(){
    	  document.forms[0].action="${basePath}nsfw/reserveItem_listUI.action";
    	  document.forms[0].submit();
      }
      function editUI(itemId){
    	  document.forms[0].action="${basePath}nsfw/reserveItem_editUI.action?reserveItem.itemId="+itemId;
    	  document.forms[0].submit();
      }
      function deleted(itemId){
    	  document.forms[0].action="${basePath}nsfw/reserveItem_delete.action?reserveItem.itemId="+itemId;
    	  document.forms[0].submit();
      }
    </script>
</head>
<body class="rightBody">
<form name="form1" action="" method="post">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
                <div class="c_crumbs"><div><b></b><strong>预约事项</strong></div> </div>
                <div class="search_art">
                    <li>
                        事项编号：<s:textfield name="reserveItem.itemNumber" cssClass="s_text"  cssStyle="width:160px;"/>
                    </li>
					<li>
                        事项名称：<s:textfield name="reserveItem.itemName" cssClass="s_text" cssStyle="width:160px;"/>
                    </li>
					<li>
                        处理部门：<s:select name="reserveItem.dealDept" list="#{'':'全部','部门A':'部门A','部门B':'部门B'}"/>
                    </li>
                    <li><input type="button" class="s_button" value="搜 索" onclick="doSearch()"/></li>
                    <li style="float:right;">
                        <input type="button" value="新增" class="s_button" onclick="doAdd()"/>&nbsp;
                        <input type="button" value="删除" class="s_button" onclick="doDeleteAll()"/>&nbsp;
                    </li>
                </div>

                <div class="t_list" style="margin:0px; border:0px none;">
                    <table width="100%" border="0">
                    
                        <tr class="t_tit">
                            <td width="30" align="center"><input type="checkbox" id="selAll" onclick="doSelectAll()" /></td>
                            <td align="center">事项编号</td>
                            <td width="120" align="center">事项名称</td>
                            <td width="120" align="center">处理部门</td>
                            <td width="140" align="center">处理人</td>
                            <td width="80" align="center">状态</td>
                            <td width="120" align="center">操作</td>
                        </tr>
                       
                     		<s:iterator value="pageResult.items">
                            <tr bgcolor="f8f8f8">
                                <td align="center"><input type="checkbox" name="selectedRow" value="<s:property value='itemId'/>"/></td>
                                <td align="center"><s:property value="itemNumber"/></td>
                                <td align="center">
                                <s:property value="itemName"/>	
                                </td>
                                <td align="center"><s:property value="dealDept"/></td>
                                <td align="center"><s:property value="dealor"/></td>
                                <td align="center"><s:property value="#ITEM_STATE_MAP[state]"/></td>
                                <td align="center">
                                	
                          
                                    <a href="javascript:editUI('<s:property value='itemId'/>')">编辑</a>
                                    <a href="javascript:deleted('<s:property value='itemId'/>')">删除</a>
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