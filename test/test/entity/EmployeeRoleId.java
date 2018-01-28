package test.entity;

/**
 * EmployeeRoleId entity. @author MyEclipse Persistence Tools
 */

public class EmployeeRoleId implements java.io.Serializable {

	// Fields

	private TEmployee TEmployee;
	private TRole TRole;

	// Constructors

	/** default constructor */
	public EmployeeRoleId() {
	}

	/** full constructor */
	public EmployeeRoleId(TEmployee TEmployee, TRole TRole) {
		this.TEmployee = TEmployee;
		this.TRole = TRole;
	}

	// Property accessors

	public TEmployee getTEmployee() {
		return this.TEmployee;
	}

	public void setTEmployee(TEmployee TEmployee) {
		this.TEmployee = TEmployee;
	}

	public TRole getTRole() {
		return this.TRole;
	}

	public void setTRole(TRole TRole) {
		this.TRole = TRole;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EmployeeRoleId))
			return false;
		EmployeeRoleId castOther = (EmployeeRoleId) other;

		return ((this.getTEmployee() == castOther.getTEmployee()) || (this
				.getTEmployee() != null && castOther.getTEmployee() != null && this
				.getTEmployee().equals(castOther.getTEmployee())))
				&& ((this.getTRole() == castOther.getTRole()) || (this
						.getTRole() != null && castOther.getTRole() != null && this
						.getTRole().equals(castOther.getTRole())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTEmployee() == null ? 0 : this.getTEmployee().hashCode());
		result = 37 * result
				+ (getTRole() == null ? 0 : this.getTRole().hashCode());
		return result;
	}

}