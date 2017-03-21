package com.bean;

/**
 * RolePermissionId entity. @author MyEclipse Persistence Tools
 */

public class RolePermissionId implements java.io.Serializable {

	// Fields

	private Role role;
	private Permission permission;

	// Constructors

	/** default constructor */
	public RolePermissionId() {
	}

	/** full constructor */
	public RolePermissionId(Role role, Permission permission) {
		this.role = role;
		this.permission = permission;
	}

	// Property accessors

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Permission getPermission() {
		return this.permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RolePermissionId))
			return false;
		RolePermissionId castOther = (RolePermissionId) other;

		return ((this.getRole() == castOther.getRole()) || (this.getRole() != null
				&& castOther.getRole() != null && this.getRole().equals(
				castOther.getRole())))
				&& ((this.getPermission() == castOther.getPermission()) || (this
						.getPermission() != null
						&& castOther.getPermission() != null && this
						.getPermission().equals(castOther.getPermission())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRole() == null ? 0 : this.getRole().hashCode());
		result = 37
				* result
				+ (getPermission() == null ? 0 : this.getPermission()
						.hashCode());
		return result;
	}

}