package nsfw.info.action;

import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import nsfw.info.entity.Info;
import nsfw.info.service.InfoService;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import core.action.BaseAction;
import core.page.PageResult;
import core.util.QueryHelper;

public class InfoAction extends BaseAction {
	@Resource
	private InfoService infoService;
	private Info info;
	private String strTitle;
	private PageResult pageResult;
	private int currentPage;
	private int pageSize;
	public String listUI(){
		try {
			ActionContext.getContext().getContextMap().put("type_map", Info.TYPE_MAP);
			QueryHelper queryHelper=new QueryHelper(Info.class,"i");
			if(info!=null){
				if(StringUtils.isNotBlank(info.getTitle())){
					info.setTitle(URLDecoder.decode(info.getTitle(), "utf-8"));
					queryHelper.addCondition("i.title like ?","%"+ info.getTitle()+"%");
				}
				queryHelper.addCondition("i.state=?", "1");
			}
			queryHelper.addOrderProperty("i.createTime", "DESC");
			pageResult=infoService.getObjects(queryHelper, pageSize, currentPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listUI";
	}
	public String addUI(){
		ActionContext.getContext().getContextMap().put("type_map", Info.TYPE_MAP);
		strTitle=info.getTitle();
		info=new Info();
		info.setCreateTime(new Timestamp(new Date().getTime()));
		return "addUI";
	}
	public String add(){
		try {
			infoService.save(info);
			info=null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	public String editUI(){
		ActionContext.getContext().getContextMap().put("type_map", Info.TYPE_MAP);
		if(info.getTitle()!=null){
			strTitle=info.getTitle();
		}
		info=infoService.findById(info.getInfoId());
		return "editUI";
	}
	public String edit(){
		try {
			infoService.update(info);
			info=null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	public String delete(){
		strTitle=info.getTitle();
		infoService.delete(info.getInfoId());
		return "list";
	}
	public String deleteSelected(){
		strTitle=info.getTitle();
		if(selectedRow!=null){
		for(String id:selectedRow){
			infoService.delete(id);
		}
		}
		return "list";
	}
	public void doPublic(){
		try {
			Info temp = infoService.findById(info.getInfoId());
			temp.setState(info.getState());
			infoService.update(temp);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html");
			ServletOutputStream outputStream = response.getOutputStream();
			outputStream.write("信息状态改变".getBytes("UTF-8"));
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	public String getStrTitle() {
		return strTitle;
	}
	public void setStrTitle(String strTitle) {
		this.strTitle = strTitle;
	}
	public PageResult getPageResult() {
		return pageResult;
	}
	public void setPageResult(PageResult pageResult) {
		this.pageResult = pageResult;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
