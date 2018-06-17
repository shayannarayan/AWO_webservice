package com.awo.app.domain.registration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.awo.app.domain.address.Address;
import com.awo.app.domain.login.Authentication;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Registration implements Serializable {
	
	private static final long serialVersionUID = -285581429968804879L;
	@Id
	private String regId;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String dob;
	
	private String bloodGroup;
	
	private int age;	
	
	private String ima_iba;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Enumerated(EnumType.STRING)
	private Role role;
	
	private boolean isActive;
	//@JsonIgnore
	@OneToMany(fetch=FetchType.EAGER,
			cascade=CascadeType.ALL, mappedBy="registration")
	private List<Address> address = new ArrayList<>();
	
//	@JsonIgnore
	@OneToOne(fetch=FetchType.EAGER,
	cascade=CascadeType.ALL, mappedBy="registration")
private Authentication authentication;
	
	
	/*@OneToOne(fetch=FetchType.EAGER,
			cascade=CascadeType.ALL, mappedBy="registration")
	private Image image;*/

	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Registration(String regId, String firstName, String middleName, String lastName, String dob, String bloodGroup,
			int age, Gender gender, Role role, boolean isActive, List<Address> address, String ima_iba, Authentication authentication) {
		super();
		this.regId = regId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dob = dob;
		this.bloodGroup = bloodGroup;
		this.age = age;
		this.gender = gender;
		this.role = role;
		this.isActive = isActive;
		this.address = address;
		this.ima_iba=ima_iba;
		this.authentication=authentication;
//		this.image = image;
	}

	

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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
/*	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}*/
	
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getIma_iba() {
		return ima_iba;
	}

	public void setIma_iba(String ima_iba) {
		this.ima_iba = ima_iba;
	}

	public Authentication getAuthentication() {
		return authentication;
	}
	@JsonIgnore
	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}
	
	
	}
