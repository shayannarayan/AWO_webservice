package com.awo.app.domain.login;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.awo.app.domain.registration.Registration;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Authentication implements Serializable{
	
	private static final long serialVersionUID = -7597310575920811369L;

	@Id
	private String authId;
	
	private String userName;
	
	@JsonIgnore
	private String password;
	
	private String hint;
	
//	@Temporal(TemporalType.TIMESTAMP)
	private Date recentLogin;
	
	@OneToOne(fetch=FetchType.EAGER,
	cascade=CascadeType.ALL)
	@JoinColumn(name="regId")
	@JsonBackReference
	private Registration registration;
	
	public Authentication() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Authentication(String authId, String userName, String password, String hint, Registration registration) {
		super();
		this.authId = authId;
		this.userName = userName;
		this.password = password;
		this.hint = hint;
		this.registration = registration;
	}

	public String getAuthId() {
		return authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getRecentLogin() {
		return recentLogin;
	}

	public void setRecentLogin(Date recentLogin) {
		this.recentLogin = recentLogin;
	}
	

}
