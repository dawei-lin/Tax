package test.entity;

/**
 * TLeader entity. @author MyEclipse Persistence Tools
 */

public class TLeader implements java.io.Serializable {

	// Fields

	private String empId;
	private TEmployee TEmployee;
	private String deptId;
	private String name;
	private String position;

	// Constructors

	/** default constructor */
	public TLeader() {
	}

	/** minimal constructor */
	public TLeader(TEmployee TEmployee, String name, String position) {
		this.TEmployee = TEmployee;
		this.name = name;
		this.position = position;
	}

	/** full constructor */
	public TLeader(TEmployee TEmployee, String deptId, String name,
			String position) {
		this.TEmployee = TEmployee;
		this.deptId = deptId;
		this.name = name;
		this.position = position;
	}

	// Property accessors

	public String getEmpId() {
		return this.empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public TEmployee getTEmployee() {
		return this.TEmployee;
	}

	public void setTEmployee(TEmployee TEmployee) {
		this.TEmployee = TEmployee;
	}

	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}