package com.bean;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Resouce entity. @author MyEclipse Persistence Tools
 */

public class Resouce implements java.io.Serializable {

	// Fields

	private Integer resid;
	private String bname;
	private Date bdate;
	private Long price;
	private Set permissionResouces = new HashSet(0);

	// Constructors

	/** default constructor */
	public Resouce() {
	}

	/** minimal constructor */
	public Resouce(String bname, Date bdate, Long price) {
		this.bname = bname;
		this.bdate = bdate;
		this.price = price;
	}

	/** full constructor */
	public Resouce(String bname, Date bdate, Long price,
			Set permissionResouces) {
		this.bname = bname;
		this.bdate = bdate;
		this.price = price;
		this.permissionResouces = permissionResouces;
	}

	// Property accessors

	public Integer getResid() {
		return this.resid;
	}

	public void setResid(Integer resid) {
		this.resid = resid;
	}

	public String getBname() {
		return this.bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Date getBdate() {
		return this.bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	public Long getPrice() {
		return this.price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Set getPermissionResouces() {
		return this.permissionResouces;
	}

	public void setPermissionResouces(Set permissionResouces) {
		this.permissionResouces = permissionResouces;
	}

}