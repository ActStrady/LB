package com.bean;

/**
 * PermissionResouce entity. @author MyEclipse Persistence Tools
 */

public class PermissionResouce implements java.io.Serializable {

	// Fields

	private Integer pid;
	private Permission permission;
	private Resouce resouce;

	// Constructors

	/** default constructor */
	public PermissionResouce() {
	}

	/** full constructor */
	public PermissionResouce(Permission permission, Resouce resouce) {
		this.permission = permission;
		this.resouce = resouce;
	}

	// Property accessors

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Permission getPermission() {
		return this.permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public Resouce getResouce() {
		return this.resouce;
	}

	public void setResouce(Resouce resouce) {
		this.resouce = resouce;
	}

}