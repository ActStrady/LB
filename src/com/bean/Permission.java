package com.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Permission entity. @author MyEclipse Persistence Tools
 */

public class Permission implements java.io.Serializable {

	// Fields

	private Integer pid;
	private String pname;
	private Set rolePermissions = new HashSet(0);
	private Set permissionResouces = new HashSet(0);

	// Constructors

	/** default constructor */
	public Permission() {
	}

	/** minimal constructor */
	public Permission(String pname) {
		this.pname = pname;
	}

	/** full constructor */
	public Permission(String pname, Set rolePermissions, Set permissionResouces) {
		this.pname = pname;
		this.rolePermissions = rolePermissions;
		this.permissionResouces = permissionResouces;
	}

	// Property accessors

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Set getRolePermissions() {
		return this.rolePermissions;
	}

	public void setRolePermissions(Set rolePermissions) {
		this.rolePermissions = rolePermissions;
	}

	public Set getPermissionResouces() {
		return this.permissionResouces;
	}

	public void setPermissionResouces(Set permissionResouces) {
		this.permissionResouces = permissionResouces;
	}

}