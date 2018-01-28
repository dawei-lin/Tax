package test.entity;

/**
 * EmployeeRole entity. @author MyEclipse Persistence Tools
 */

public class EmployeeRole implements java.io.Serializable {

	// Fields

	private EmployeeRoleId id;
	private String state;

	// Constructors

	/** default constructor */
	public EmployeeRole() {
	}

	/** full constructor */
	public EmployeeRole(EmployeeRoleId id, String state) {
		this.id = id;
		this.state = state;
	}

	// Property accessors

	public EmployeeRoleId getId() {
		return this.id;
	}

	public void setId(EmployeeRoleId id) {
		this.id = id;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}