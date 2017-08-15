package com.exadatum.exam.portal.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="TB_LOGIN")
public class AuthenticatedUser implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private String userName;
	private String token;
	private boolean authenticated;
	public AuthenticatedUser(){
		
	}
	
	public AuthenticatedUser(String userId, String userName, String token,
			boolean authenticated) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.token = token;
		this.authenticated = authenticated;
	}
	@Id
	@Column(name="USER_ID",nullable=false)
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Column(name="USER_NAME")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name="TOKEN")
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Column(name="AUTHENTICATED")
	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}
	
	@Override
	public String toString() {
		return "AuthenticatedUser [userId=" + userId + ", userName=" + userName
				+ ", token=" + token + ", authenticated=" + authenticated
				+ "]";
	}
	
}
