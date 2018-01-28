package test.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TPrivilege entity. @author MyEclipse Persistence Tools
 */

public class TPrivilege implements java.io.Serializable {

	// Fields

	private String privilegeId;
	private String name;
	private Set rolePrivis = new HashSet(0);

	// Constructors

	/** default constructor */
	public TPrivilege() {
	}

	/** minimal constructor */
	public TPrivilege(String name) {
		this.name = name;
	}

	/** full constructor */
	public TPrivilege(String name, Set rolePrivis) {
		this.name = name;
		this.rolePrivis = rolePrivis;
	}

	// Property accessors

	public String getPrivilegeId() {
		return this.privilegeId;
	}

	public void setPrivilegeId(String privilegeId) {
		this.privilegeId = privilegeId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getRolePrivis() {
		return this.rolePrivis;
	}

	public void setRolePrivis(Set rolePrivis) {
		this.rolePrivis = rolePrivis;
	}

}