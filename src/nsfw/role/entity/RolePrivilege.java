package nsfw.role.entity;

import java.io.Serializable;

public class RolePrivilege implements Serializable{
	private RolePrivilegeId id;

	public RolePrivilegeId getId() {
		return id;
	}

	public void setId(RolePrivilegeId id) {
		this.id = id;
	}

	public RolePrivilege(RolePrivilegeId id) {
		super();
		this.id = id;
	}

	public RolePrivilege() {
	}
	
}
