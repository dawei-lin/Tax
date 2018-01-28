package login.action;

import java.util.List;

import javax.annotation.Resource;

import nsfw.user.entity.User;
import nsfw.user.entity.UserRole;
import nsfw.user.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	@Resource
	private UserService userService;
	private User user;
	public String toLoginUI(){
		return "toLoginUI";
	}
	public String login(){
		List<User> list = userService.findUserByAccountAndPass(user);
		if(list!=null&&list.size()>0){
		user=list.get(0);
		List<UserRole> userRoles= userService.getUserRoleByUserId(user.getId());
		user.setUserRoles(userRoles);
		ActionContext.getContext().getSession().put("user", user);
		return "home";
		}else{
			return "toLoginUI";
		}
	}
	public String logout(){
		ActionContext.getContext().getSession().remove("user");
		return "toLoginUI";
	}
	public String noPermissionUI(){
		return "noPermissionUI";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
