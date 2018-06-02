package com.awo.app.model.login;

import com.awo.app.domain.registration.Gender;

public class LoginModel {
	
	
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
	
	private String url;

	public int getRegId() {
		return regId;
	}

	public void setRegId(int regId) {
		this.regId = regId;
	}

	public String getFirstName() {
		return firstName;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	/*private int imgId;

	private String imgName;

	private String type;

	private String length;

	private byte[] pic;

	private String createdDate;

	private String modifiedDate;*/


}
