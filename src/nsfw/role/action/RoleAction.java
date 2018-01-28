package nsfw.role.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import nsfw.role.entity.Role;
import nsfw.role.entity.RolePrivilege;
import nsfw.role.entity.RolePrivilegeId;
import nsfw.role.service.RoleService;

import com.opensymphony.xwork2.ActionContext;

import core.action.BaseAction;
import core.constant.Constant;

public class RoleAction extends BaseAction{
	@Resource
	private RoleService roleService;
	private List<Role> roleList;
	private Role role;
	private String[] privilegeIds;
	public String listUI(){
		ActionContext.getContext().getContextMap().put("privilegeMap", Constant.privilegeMap);
		roleList=roleService.getAll();
		return "listUI";
	}
	public String addUI(){
		ActionContext.getContext().getContextMap().put("privilegeMap", Constant.privilegeMap);
		return "addUI";
	}
	public String add(){
		try {
			if(privilegeIds!=null){
				Set<RolePrivilege> privileges=new HashSet<RolePrivilege>();
				for(int i=0;i<privilegeIds.length;i++){
					privileges.add(new RolePrivilege(new RolePrivilegeId(role, privilegeIds[i])));
				}
			role.setPrivileges(privileges);
			}
			roleService.save(role);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	public String editUI(){
		ActionContext.getContext().getContextMap().put("privilegeMap", Constant.privilegeMap);
		role=roleService.findById(role.getRoleId());
		if(role.getPrivileges()!=null){
			privilegeIds=new String[role.getPrivileges().size()];
			int i=0;
			for(RolePrivilege rolePrivilege:role.getPrivileges()){
				privilegeIds[i++]=rolePrivilege.getId().getCode();
			}
		}
		return "editUI";
	}
	public String edit(){
		try {
			if(privilegeIds!=null){
				Set<RolePrivilege> privileges=new HashSet<RolePrivilege>();
				for(int i=0;i<privilegeIds.length;i++){
					privileges.add(new RolePrivilege(new RolePrivilegeId(role, privilegeIds[i])));
				}
			role.setPrivileges(privileges);
			}
			roleService.update(role);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	public String delete(){
		roleService.delete(role.getRoleId());
		return "list";
	}
	public String deleteSelected(){
		if(selectedRow!=null){
		for(String id:selectedRow){
			roleService.delete(id);
		}
		}
		return "list";
	}
	public List<Role> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String[] getPrivilegeIds() {
		return privilegeIds;
	}
	public void setPrivilegeIds(String[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}
	
	
}
