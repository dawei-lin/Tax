<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("basePath", request.getContextPath()+"/") ;
%>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>我要投诉</title>
  	<script type="text/javascript" charset="utf-8" src="${basePath }js/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${basePath }js/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="${basePath }js/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript">
	window.UEDITOR_HOME_URL = "${basePath }js/ueditor/";
	var ue = UE.getEditor('editor');
	function getCompName(){
		var dept=$("#compDept option:selected").val();
		if(dept!=""){
			$.ajax({
				"url":"${basePath }sys/home_getUserJson2.action",
				"data":{"dept":dept},
				"type":"post",
				"dataType":"json",
				"success":function(data){
					if(data!=""&&data!=null&&data!=undefined){
						if("success"==data.msg){
							var compName=$("#compName");
							compName.empty();
							$.each(data.userList,function(index,user){
								compName.append("<option value='"+user.name+"'>"+user.name+"</option>");
							});
						}else{
							alert("投诉信息出错");
						}
					}else{
						alert("投诉信息出错");
					}
				},
				"error":function(){
					alert("出错了");
				}
			});
		}else{
			$("#compName").empty();
		}
	}
	function doSubmit(){
		$.ajax({
			url:"${basePath}sys/home_complainAdd.action",
			data:$("#form").serialize(),
			type:"post",
			async:false,
			success:function(msg){
				if("success"==msg){
					window.opener.parent.location.reload(true);
					window.close();
				}else{
					alert("请求出错");
				}
			},
			error:function(){
				alert("出错了");
			}
		});
	}
	</script>
</head>
<body>
<form id="form" name="form" action="" method="post" enctype="multipart/form-data">
    <div class="vp_d_1">
        <div style="width:1%;float:left;">&nbsp;&nbsp;&nbsp;&nbsp;</div>
        <div class="vp_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>工作主页</strong>&nbsp;-&nbsp;我要投诉</div></div>
    <div class="tableH2">我要投诉</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="250px">投诉标题：</td>
            <td><s:textfield name="complain.toCompTitle"/></td>
        </tr>
        <tr>
            <td class="tdBg">被投诉人部门：</td>
            <td>
            <s:select id="compDept" name="complain.toCompDept" list="#{'':'请选择','部门A':'部门A','部门B':'部门B' }" onchange="getCompName()"></s:select>
            </td>
        </tr>
        <tr>
            <td class="tdBg">被投诉人姓名：</td>
            <td>
            <select id="compName" name="complain.toCompName"></select>
            </td>
        </tr>
        <tr>
            <td class="tdBg">投诉内容：</td>
            <td><s:textarea id="editor" name="complain.toCompContent" cssStyle="width:90%;height:160px;" /></td>
        </tr>
        <tr>
            <td class="tdBg">是否匿名投诉：</td>
            <td><s:radio name="complain.isNm" list="#{'false':'非匿名投诉','true':'匿名投诉' }" value="true"/></td>
        </tr>
       
    </table>

    <div class="tc mt20">
        <input type="button" class="btnB2" value="保存" onclick="doSubmit()"/>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:window.close()" class="btnB2" value="关闭" />
    </div>
    </div></div>
    <div style="width:1%;float:left;">&nbsp;&nbsp;&nbsp;&nbsp;</div>
    </div>
    <s:hidden name="complain.compName" value="%{#session.user.name}"></s:hidden>
    <s:hidden name="complain.compCompany" value="%{#session.user.dept}"></s:hidden>
    <s:hidden name="complain.compPhone" value="%{#session.user.mobile}"></s:hidden>
</form>
</body>
</html>