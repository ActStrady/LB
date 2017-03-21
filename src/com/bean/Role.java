package com.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {

	// Fields

	private Integer rid;
	private String rname;
	private Set rolePermissions = new HashSet(0);

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** minimal constructor */
	public Role(String rname) {
		this.rname = rname;
	}

	/** full constructor */
	public Role(String rname, Set rolePermissions) {
		this.rname = rname;
		this.rolePermissions = rolePermissions;
	}

	// Property accessors

	public Integer getRid() {
		return this.rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getRname() {
		return this.rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public Set getRolePermissions() {
		return this.rolePermissions;
	}

	public void setRolePermissions(Set rolePermissions) {
		this.rolePermissions = rolePermissions;
	}

}