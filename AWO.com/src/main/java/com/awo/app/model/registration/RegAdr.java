package com.awo.app.model.registration;

import java.io.Serializable;
import java.util.List;

import com.awo.app.domain.registration.Gender;
import com.awo.app.domain.registration.Role;
import com.awo.app.model.address.AddrModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class RegAdr implements Serializable {
	

	private static final long serialVersionUID = 4907217609184820192L;

	private String regId;

	private String firstName;

	private String middleName;

	private String lastName;

	private String dob;

	private String bloodGroup;

	private int age;

	private Gender gender;

	private Role role;
	
	private List<AddrModel> address;

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<AddrModel> getAddress() {
		return address;
	}

	public void setAddress(List<AddrModel> address) {
		this.address = address;
	}
	
	

}
