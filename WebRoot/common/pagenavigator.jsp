<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
 <div class="c_pate" style="margin-top: 5px;">
		<table width="100%" class="pageDown" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
				<td align="right">
                 	总共<s:property value="pageResult.totalCount"/>条记录，当前第 <s:property value="pageResult.currentPage"/> 页，共  <s:property value="pageResult.pageCount"/> 页 &nbsp;&nbsp;
                           <s:if test="pageResult.currentPage>1"> <a href="javascript:doGoPage(<s:property value='pageResult.currentPage-1'/>)">上一页</a></s:if>&nbsp;&nbsp;
                           <s:if test="pageResult.currentPage<pageResult.pageCount"><a href="javascript:doGoPage(<s:property value='pageResult.currentPage+1'/>)">下一页</a></s:if>
					到&nbsp;<input type="text" id="currentPage" name="currentPage" style="width: 30px;" onkeypress="if(event.keyCode == 13){doGoPage(this.value);}" min="1"
					max="" value="" /> &nbsp;&nbsp;
			    </td>
			</tr>
		</table>	
        </div>
