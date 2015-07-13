package com.datastructures.models;

import java.io.Serializable;

public class UserDataQuery implements Serializable {

	private String studentNumber;
	private String name;
	private String birthday;
	private String cellNo;
	private String phoneNo;
	private String email;
	private String gender;
	private String college;
	private String role;
	private String attendanceControl;
	
	public UserDataQuery() {
		setAttendanceControl();
	}
	
	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean checkIfBlankAndNotNull(String value) {
		return (value.length() == 0 && !value.equals(null) && value.equals(""));
	}
	
	public void setAttendanceControl() {
		this.attendanceControl = "<button class=\"btn btn-primary btn-sm btn-block\" title=\"Attendance\"><span class=\"glyphicon glyphicon-map-marker\" aria-hidden=\"true\"></span></button>";
	}
	
	public String getAttendanceControl() {
		return attendanceControl;
	}
}
