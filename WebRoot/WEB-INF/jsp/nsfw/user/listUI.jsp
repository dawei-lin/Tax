﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<%@include file="/common/header.jsp"%>
    <title>用户管理</title>
    <script type="text/javascript">
      	//全选、全反选
		function doSelectAll(){
			// jquery 1.6 前
			//$("input[name=selectedRow]").attr("checked", $("#selAll").is(":checked"));
			//prop jquery 1.6+建议使用
			$("input[name=selectedRow]").prop("checked", $("#selAll").is(":checked"));		
		}
      	function doAdd(){
      		document.forms[0].action = "${basePath}nsfw/user_addUI.action";
      		document.forms[0].submit();
      	}
      	function doEdit(id){
      		document.forms[0].action="${basePath}nsfw/user_editUI.action?user.id="+id;
      		document.forms[0].submit();
      	}
      	function doDelete(id){
      		document.forms[0].action="${basePath}nsfw/user_delete.action?user.id="+id;
      		document.forms[0].submit();
      	}
      	function doDeleteAll(){
      		document.forms[0].action="${basePath}nsfw/user_deleteSelected.action";
      		document.forms[0].submit();
      	}
      	function doExportExcel(){
      		window.open("${basePath}nsfw/user_exportExcel.action");
      	}
      	function doImportExcel(){
      		document.forms[0].action="${basePath}nsfw/user_importExcel.action";
      		document.forms[0].submit();
      	}
      	function doGoPage(currentPage){
      		$("#currentPage").val(currentPage);
      		document.forms[0].action="${basePath}nsfw/user_listUI.action";
      		document.forms[0].submit();
      	}
    </script>
</head>
<body class="rightBody">
<form name="form1" action="" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
                <div class="c_crumbs"><div><b></b><strong>用户管理</strong></div> </div>
                <div class="search_art">
                    <li>
                        用户名：<s:textfield name="user.name" cssClass="s_text" id="userName"  cssStyle="width:160px;"/>
                    </li>
                    <li><input type="button" class="s_button" value="搜 索" onclick="doSearch()"/></li>
                    <li style="float:right;">
                        <input type="button" value="新增" class="s_button" onclick="doAdd()"/>&nbsp;
                        <input type="button" value="删除" class="s_button" onclick="doDeleteAll()"/>&nbsp;
                        <input type="button" value="导出" class="s_button" onclick="doExportExcel()"/>&nbsp;
                    	<input name="userExcel" type="file"/>
                        <input type="button" value="导入" class="s_button" onclick="doImportExcel()"/>&nbsp;

                    </li>
                </div>

                <div class="t_list" style="margin:0px; border:0px none;">
                    <table width="100%" border="0">
                        <tr class="t_tit">
                            <td width="30" align="center"><input type="checkbox" id="selAll" onclick="doSelectAll()" /></td>
                            <td width="140" align="center">用户名</td>
                            <td width="140" align="center">帐号</td>
                            <td width="160" align="center">所属部门</td>
                            <td width="80" align="center">性别</td>
                            <td align="center">电子邮箱</td>
                            <td width="100" align="center">操作</td>
                        </tr>
                        <s:iterator value="pageResult.items" status="vs">
                            <tr bgcolor="f8f8f8">
                                <td align="center"><input type="checkbox" name="selectedRow" value="<s:property value='id'/>"/></td>
                                <td align="center"><s:property value="name"/></td>
                                <td align="center"><s:property value="account"/></td>
                                <td align="center"><s:property value="dept"/></td>
                                <td align="center"><s:property value="gender?'男':'女'"/></td>
                                <td align="center"><s:property value="email"/></td>
                                <td align="center">
                                    <a href="javascript:doEdit('<s:property value='id'/>')">编辑</a>
                                    <a href="javascript:doDelete('<s:property value='id'/>')">删除</a>
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