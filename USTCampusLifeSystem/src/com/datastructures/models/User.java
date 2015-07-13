package com.datastructures.models;

import java.io.Serializable;

public class User implements Serializable {

	private String studentNumber;
	private String password;
	private String role;
	private String firstName;
	private String middleName;
	private String lastName;
	private String birthday;
	private String cellNo;
	private String phoneNo;
	private String email;
	private String collegeNo;
	private String gender;
	private String college;
	
	public User() {
	}
	
	public User(String studentNumber, String password, String role,
			String firstName, String middleName, String lastName,
			String birthday, String cellNo, String phoneNo, String email,
			String collegeNo, String gender) {
		super();
		this.studentNumber = studentNumber;
		this.password = password;
		this.role = role;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.cellNo = cellNo;
		this.phoneNo = phoneNo;
		this.email = email;
		this.collegeNo = collegeNo;
		this.gender = gender;
	}
	
	public void getUserData(String studentNumber, String password, String role,
			String firstName, String middleName, String lastName,
			String birthday, String cellNo, String phoneNo, String email,
			String collegeNo, String gender) {
		this.studentNumber = studentNumber;
		this.password = password;
		this.role = role;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.cellNo = cellNo;
		this.phoneNo = phoneNo;
		this.email = email;
		this.collegeNo = collegeNo;
		this.gender = gender;
	}
	
	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCellNo() {
		return cellNo;
	}

	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCollegeNo() {
		return collegeNo;
	}

	public void setCollegeNo(String collegeNo) {
		this.collegeNo = collegeNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public boolean checkIfBlankAndNotNull(String value) {
		return (value.length() == 0 && !value.equals(null) && value.equals(""));
	}
}
