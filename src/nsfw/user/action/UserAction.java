package nsfw.user.action;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import nsfw.role.service.RoleService;
import nsfw.user.entity.User;
import nsfw.user.entity.UserRole;
import nsfw.user.service.UserService;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import core.action.BaseAction;
import core.util.QueryHelper;

public class UserAction extends BaseAction {
	@Resource
	private UserService userService;
	@Resource
	private RoleService roleService;
	private List<User> userList;
	private User user;
	private File headImg;
	private String headImgContentType;
	private String headImgFileName;
	private File userExcel;
	private String userExcelContentType;
	private String userExcelFileName;
	private String[] userRoleIds;
	public String listUI(){
		QueryHelper queryHelper = new QueryHelper(User.class, "u");
		pageResult = userService.getObjects(queryHelper, pageSize, currentPage);
		return "listUI";
	}
	public String addUI(){
		ActionContext.getContext().getContextMap().put("roleList", roleService.getAll());
		return "addUI";
	}
	public String add(){
		try {
			if(headImg!=null){
				String path=ServletActionContext.getServletContext().getRealPath("upload/user");
				String fileName=UUID.randomUUID().toString().replace("-", "")+headImgFileName.substring(headImgFileName.lastIndexOf("."));
				FileUtils.copyFile(headImg, new File(path, fileName));
				user.setHeadImg("user/"+fileName);
			}
			userService.saveUserAndRole(user, userRoleIds);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	public String editUI(){
		user=userService.findById(user.getId());
		ActionContext.getContext().getContextMap().put("roleList", roleService.getAll());
		List<UserRole> userRoles=userService.getUserRoleByUserId(user.getId());
		userRoleIds=new String[userRoles.size()];
		for(int i=0;i<userRoles.size();i++){
			userRoleIds[i]=userRoles.get(i).getId().getRole().getRoleId();
		}
		return "editUI";
	}
	public String edit(){
		try {
			if(headImg!=null){
				String path=ServletActionContext.getServletContext().getRealPath("upload/user");
				String fileName=UUID.randomUUID().toString().replace("-", "")+headImgFileName.substring(headImgFileName.lastIndexOf("."));
				FileUtils.copyFile(headImg, new File(path, fileName));
				user.setHeadImg("user/"+fileName);
			}
			userService.updateUserAndRole(user,userRoleIds);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	public String delete(){
		userService.delete(user.getId());
		return "list";
	}
	public String deleteSelected(){
		if(selectedRow!=null){
		for(String id:selectedRow){
			userService.delete(id);
		}
		}
		return "list";
	}
	public void exportExcel(){
		try {
			userList=userService.getAll();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/x-execl");
			response.setHeader("Content-Disposition", "attachment;filename=" + new String("用户列表.xls".getBytes(), "ISO-8859-1"));
			ServletOutputStream outputStream = response.getOutputStream();
			userService.exportExcel(userList, outputStream);
			if(outputStream!=null){
				outputStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String importExcel(){
		if(userExcel!=null){
			if(userExcelFileName.matches("^.+\\.(?i)((xls)|(xlsx))$")){
		userService.importExcel(userExcel, userExcelFileName);
			}
		}
		return "list";
	}
	public void verifyAccount(){
		try {
			List<User> list=userService.findByIdAndAccount(user.getId(),user.getAccount());
			String flag="true";
			if(list!=null&&list.size()>0){
				flag="false";
			}
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html");
			ServletOutputStream outputStream = response.getOutputStream();
			outputStream.write(flag.getBytes());
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public File getHeadImg() {
		return headImg;
	}
	public void setHeadImg(File headImg) {
		this.headImg = headImg;
	}
	public String getHeadImgContentType() {
		return headImgContentType;
	}
	public void setHeadImgContentType(String headImgContentType) {
		this.headImgContentType = headImgContentType;
	}
	public String getHeadImgFileName() {
		return headImgFileName;
	}
	public void setHeadImgFileName(String headImgFileName) {
		this.headImgFileName = headImgFileName;
	}
	public File getUserExcel() {
		return userExcel;
	}
	public void setUserExcel(File userExcel) {
		this.userExcel = userExcel;
	}
	public String getUserExcelContentType() {
		return userExcelContentType;
	}
	public void setUserExcelContentType(String userExcelContentType) {
		this.userExcelContentType = userExcelContentType;
	}
	public String getUserExcelFileName() {
		return userExcelFileName;
	}
	public void setUserExcelFileName(String userExcelFileName) {
		this.userExcelFileName = userExcelFileName;
	}
	public String[] getUserRoleIds() {
		return userRoleIds;
	}
	public void setUserRoleIds(String[] userRoleIds) {
		this.userRoleIds = userRoleIds;
	}
	
	
}
