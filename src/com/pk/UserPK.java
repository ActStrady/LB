package com.pk;

import java.io.Serializable;

public class UserPK implements Serializable {
   
	private static final long serialVersionUID = 1L;
	private int uid;
    private int rid;
	public UserPK(){}
	
	public UserPK(int uid,int rid){
		this.rid=rid;
		this.uid=uid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rid;
		result = prime * result + uid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserPK other = (UserPK) obj;
		if (rid != other.rid)
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}
	
}
