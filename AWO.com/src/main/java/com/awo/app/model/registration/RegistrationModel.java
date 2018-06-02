package com.awo.app.model.registration;

import java.io.Serializable;

import com.awo.app.domain.registration.Gender;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_DEFAULT)
public class RegistrationModel implements Serializable {

	private static final long serialVersionUID = -164331729043091013L;
	
	private int regId;

	private String firstName;

	private String middleName;

	private String lastName;

	private String dob;

	private String bloodGroup;

	private int age;

	private Gender gender;

	private String street;

	private String area;

	private String city;

	private String pincode;

	private Long phoneNumber;

	private String emailId;

	private String enterPassword;

	private String donatedBloodRecently;
	
	public void setRegId(int regId) {
		this.regId = regId;
	}
	public int getRegId() {
		return regId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDob() {
		return dob;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getEnterPassword() {
		return enterPassword;
	}

	public void setEnterPassword(String enterPassword) {
		this.enterPassword = enterPassword;
	}

	public String getDonatedBloodRecently() {
		return donatedBloodRecently;
	}

	public void setDonatedBloodRecently(String donatedBloodRecently) {
		this.donatedBloodRecently = donatedBloodRecently;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
