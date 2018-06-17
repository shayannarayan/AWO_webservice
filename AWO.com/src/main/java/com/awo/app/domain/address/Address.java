package com.awo.app.domain.address;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.awo.app.domain.registration.Registration;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Address implements Serializable{ 
	
	
	private static final long serialVersionUID = -168211364685272390L;

	@Id
	private String addressId;
	
	private String street;
	
	private String area;
	
	private String city;
	
	private String state;
	
	private String pincode;
	
	private String phone;
	
	private String mobile;
	
	
	@Column(name="emailId", unique=true)	
	private String emailId;
	
	private String website;
	
	private String dateAndTime;
	
	private String modifiedDateAndTime;
	
	private boolean isActive;
	
	@ManyToOne
	@JoinColumn(name="regId")
	@JsonBackReference
	private Registration registration;

	public Address(String addressId, String street, String area, String city, String state, String pincode,
			String phone, String mobile, String emailId, String website, String dateAndTime, String modifiedDateAndTime,
			boolean isActive, Registration registration) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.phone = phone;
		this.mobile = mobile;
		this.emailId = emailId;
		this.website = website;
		this.dateAndTime = dateAndTime;
		this.modifiedDateAndTime = modifiedDateAndTime;
		this.isActive = isActive;
		this.registration = registration;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public String getModifiedDateAndTime() {
		return modifiedDateAndTime;
	}

	public void setModifiedDateAndTime(String modifiedDateAndTime) {
		this.modifiedDateAndTime = modifiedDateAndTime;
	}


	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/*public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}*/

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}
	
	
	

		}
