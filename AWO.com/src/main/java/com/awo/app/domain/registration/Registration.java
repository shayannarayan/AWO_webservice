package com.awo.app.domain.registration;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.awo.app.domain.image.Image;

@Entity
public class Registration implements Serializable {
	
	private static final long serialVersionUID = -285581429968804879L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int regId;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String dob;
	
	private String bloodGroup;
	
	private int age;	
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private String street;
	
	private String area;
	
	private String city;
	
	private String pincode;
	
	private Long phoneNumber;
	
	@Column(name="emailId", unique=true)
	private String emailId;
	
	private String enterPassword;
	
	private String donatedBloodRecently;
	
	

	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Registration(int regId, String firstName, String middleName, String lastName, String dob, String bloodGroup,
			int age, Gender gender, String street, String area, String city, String pincode, Long phoneNumber,
			String emailId, String enterPassword, String donatedBloodRecently) {
		super();
		this.regId = regId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dob = dob;
		this.bloodGroup = bloodGroup;
		this.age = age;
		this.gender = gender;
		this.street = street;
		this.area = area;
		this.city = city;
		this.pincode = pincode;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.enterPassword = enterPassword;
		this.donatedBloodRecently = donatedBloodRecently;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	
	
	
	

}
