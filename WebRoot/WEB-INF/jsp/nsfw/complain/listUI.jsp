<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <script type="text/javascript" src="${basePath}js/datepicker/WdatePicker.js"></script>
    <title>投诉受理管理</title>
    <script type="text/javascript">
    function doSearch(){
  		document.forms[0].action = "${basePath}nsfw/complain_listUI.action";
  		document.forms[0].submit();
  	}
    function doDeal(compId){
  		document.forms[0].action = "${basePath}nsfw/complain_dealUI.action?complain.compId="+compId;
  		document.forms[0].submit();
  	}
    function doGoPage(currentPage){
  		$("#currentPage").val(currentPage);
  		document.forms[0].action="${basePath}nsfw/complain_listUI.action";
  		document.forms[0].submit();
  	}
    function doAnnualStatistic(){
    	document.forms[0].action="${basePath}nsfw/complain_annualStatisticChartUI.action";
  		document.forms[0].submit();
    }
    </script>
</head>
<body class="rightBody">
<form name="form1" action="" method="post">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
                <div class="c_crumbs"><div><b></b><strong>投诉受理管理</strong></div> </div>
                <div class="search_art">
                    <li>
                       	投诉标题：<s:textfield name="complain.toCompTitle" cssClass="s_text"  cssStyle="width:160px;"/>
                    </li>
                    <li>
                       	投诉时间：<s:textfield id="startTime" name="startTime" cssClass="s_text"  cssStyle="width:160px;" 
                       	readonly="true" onfocus="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM--dd HH:mm'});"/>
                              - 
                             <s:textfield id="endTime" name="endTime" cssClass="s_text"  cssStyle="width:160px;"
                              readonly="true" onfocus="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd HH:mm'});"/>
                    </li>
                    <li>
                       	状态：<s:select name="complain.compState" list="#complainStateMap" headerKey="" headerValue="全部"/>
                    </li>
                    <li><input type="button" class="s_button" value="搜 索" onclick="doSearch()"/></li>
                    <li style="float:right;">
                    	<input type="button" value="统计" class="s_button" onclick="doAnnualStatistic()"/>&nbsp;
                    </li>

                </div>

                <div class="t_list" style="margin:0px; border:0px none;">
                    <table width="100%" border="0">
                        <tr class="t_tit">
                            <td align="center">投诉标题</td>
                            <td width="120" align="center">被投诉部门</td>
                            <td width="120" align="center">被投诉人</td>
                            <td width="140" align="center">投诉时间</td>
                            <td width="100" align="center">受理状态</td>
                            <td width="100" align="center">操作</td>
                        </tr>
                       <s:iterator value="pageResult.items" status="st">
                            <tr <s:if test="#st.odd"> bgcolor="f8f8f8" </s:if> >
                                <td align="center"><s:property value="toCompTitle"/></td>
                                <td align="center"><s:property value="toCompDept"/></td>
                                <td align="center"><s:property value="toCompName"/></td>
                                <td align="center"><s:date name="compDate" format="yyyy-MM-dd HH:mm"/></td>
                                <td align="center"><s:property value="#complainStateMap[compState]"/></td>
                                <td align="center">
                                	<s:if test="compState!=2">
                                    <a href="javascript:doDeal('<s:property value='compId'/>')">受理</a>
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