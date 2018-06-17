package com.awo.app.model.login;

import java.io.Serializable;
import java.util.Date;

import com.awo.app.domain.registration.Registration;

public class LoginModel implements Serializable{
	
	
	private static final long serialVersionUID = -6075608316008558657L;

	private String userName;
	
	private String password;
	
	private String hint;
	
//	private Date recentLogin;
	
	private String url;

	
	private Registration registration;
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
/*
	public Date getRecentLogin() {
		return recentLogin;
	}

	public void setRecentLogin(Date recentLogin) {
		this.recentLogin = recentLogin;
	}*/
	
	
	
	
	}
