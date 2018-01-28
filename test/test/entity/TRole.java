package test.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TRole entity. @author MyEclipse Persistence Tools
 */

public class TRole implements java.io.Serializable {

	// Fields

	private String roleId;
	private String name;
	private Set rolePrivis = new HashSet(0);
	private Set employeeRoles = new HashSet(0);

	// Constructors

	/** default constructor */
	public TRole() {
	}

	/** minimal constructor */
	public TRole(String name) {
		this.name = name;
	}

	/** full constructor */
	public TRole(String name, Set rolePrivis, Set employeeRoles) {
		this.name = name;
		this.rolePrivis = rolePrivis;
		this.employeeRoles = employeeRoles;
	}

	// Property accessors

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
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

	public Set getEmployeeRoles() {
		return this.employeeRoles;
	}

	public void setEmployeeRoles(Set employeeRoles) {
		this.employeeRoles = employeeRoles;
	}

}