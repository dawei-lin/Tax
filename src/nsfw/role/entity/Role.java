package nsfw.role.entity;

import java.io.Serializable;
import java.util.Set;

public class Role implements Serializable {
	private String roleId;
	private String name;
	private String state;
	private Set<RolePrivilege> privileges;
	
	public static String ROLE_STATE_VALID="1";
	public static String ROLE_STATE_INVALID="0";
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Set<RolePrivilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Set<RolePrivilege> privileges) {
		this.privileges = privileges;
	}
	public Role(String roleId, String name, String state,
			Set<RolePrivilege> privileges) {
		this.roleId = roleId;
		this.name = name;
		this.state = state;
		this.privileges = privileges;
	}
	public Role() {
	}
	public Role(String roleId) {
		this.roleId = roleId;
	}
	
}
