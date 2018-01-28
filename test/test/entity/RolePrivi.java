package test.entity;

/**
 * RolePrivi entity. @author MyEclipse Persistence Tools
 */

public class RolePrivi implements java.io.Serializable {

	// Fields

	private RolePriviId id;

	// Constructors

	/** default constructor */
	public RolePrivi() {
	}

	/** full constructor */
	public RolePrivi(RolePriviId id) {
		this.id = id;
	}

	// Property accessors

	public RolePriviId getId() {
		return this.id;
	}

	public void setId(RolePriviId id) {
		this.id = id;
	}

}