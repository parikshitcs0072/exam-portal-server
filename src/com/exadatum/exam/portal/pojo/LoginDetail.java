package com.exadatum.exam.portal.pojo;

import java.io.Serializable;

public class LoginDetail implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private String password;
	public LoginDetail(){
		
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginDetail [userId=" + userId + ", password=" + password
				+ "]";
	}
	
	

}
