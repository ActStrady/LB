package com.bean;

/**
 * RolePermission entity. @author MyEclipse Persistence Tools
 */

public class RolePermission implements java.io.Serializable {

	// Fields

	private RolePermissionId id;

	// Constructors

	/** default constructor */
	public RolePermission() {
	}

	/** full constructor */
	public RolePermission(RolePermissionId id) {
		this.id = id;
	}

	// Property accessors

	public RolePermissionId getId() {
		return this.id;
	}

	public void setId(RolePermissionId id) {
		this.id = id;
	}

}