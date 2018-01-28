package test.entity;

/**
 * RolePriviId entity. @author MyEclipse Persistence Tools
 */

public class RolePriviId implements java.io.Serializable {

	// Fields

	private TRole TRole;
	private TPrivilege TPrivilege;

	// Constructors

	/** default constructor */
	public RolePriviId() {
	}

	/** full constructor */
	public RolePriviId(TRole TRole, TPrivilege TPrivilege) {
		this.TRole = TRole;
		this.TPrivilege = TPrivilege;
	}

	// Property accessors

	public TRole getTRole() {
		return this.TRole;
	}

	public void setTRole(TRole TRole) {
		this.TRole = TRole;
	}

	public TPrivilege getTPrivilege() {
		return this.TPrivilege;
	}

	public void setTPrivilege(TPrivilege TPrivilege) {
		this.TPrivilege = TPrivilege;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RolePriviId))
			return false;
		RolePriviId castOther = (RolePriviId) other;

		return ((this.getTRole() == castOther.getTRole()) || (this.getTRole() != null
				&& castOther.getTRole() != null && this.getTRole().equals(
				castOther.getTRole())))
				&& ((this.getTPrivilege() == castOther.getTPrivilege()) || (this
						.getTPrivilege() != null
						&& castOther.getTPrivilege() != null && this
						.getTPrivilege().equals(castOther.getTPrivilege())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTRole() == null ? 0 : this.getTRole().hashCode());
		result = 37
				* result
				+ (getTPrivilege() == null ? 0 : this.getTPrivilege()
						.hashCode());
		return result;
	}

}