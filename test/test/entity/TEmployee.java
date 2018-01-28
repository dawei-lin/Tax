package test.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TEmployee entity. @author MyEclipse Persistence Tools
 */

public class TEmployee implements java.io.Serializable {

	// Fields

	private String empId;
	private TDept TDept;
	private String name;
	private Set TLeaders = new HashSet(0);
	private Set employeeRoles = new HashSet(0);

	// Constructors

	/** default constructor */
	public TEmployee() {
	}

	/** minimal constructor */
	public TEmployee(String name) {
		this.name = name;
	}

	/** full constructor */
	public TEmployee(TDept TDept, String name, Set TLeaders, Set employeeRoles) {
		this.TDept = TDept;
		this.name = name;
		this.TLeaders = TLeaders;
		this.employeeRoles = employeeRoles;
	}

	// Property accessors

	public String getEmpId() {
		return this.empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public TDept getTDept() {
		return this.TDept;
	}

	public void setTDept(TDept TDept) {
		this.TDept = TDept;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getTLeaders() {
		return this.TLeaders;
	}

	public void setTLeaders(Set TLeaders) {
		this.TLeaders = TLeaders;
	}

	public Set getEmployeeRoles() {
		return this.employeeRoles;
	}

	public void setEmployeeRoles(Set employeeRoles) {
		this.employeeRoles = employeeRoles;
	}

}