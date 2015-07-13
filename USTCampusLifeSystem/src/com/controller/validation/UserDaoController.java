package com.controller.validation;

import java.sql.*;

import com.datastructures.models.*;

public class UserDaoController {
	private String userId;
	private String studentNo;
	private String password;
	private String role;
	private String fname;
	private String mname;
	private String lname;
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setStudNo(String studentNo) {
		this.studentNo = studentNo;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public void setFName(String fname) {
		this.fname = fname;
	}
	
	public void setMName(String mname) {
		if (!mname.equals(null)) {
			this.mname = mname;
		} else {
			this.mname = "";
		}
	}
	
	public void setLName(String lname) {
		this.lname = lname;
	}
	
	public String getUserId() {
		return this.userId;
	}
	
	public String getStudNo() {
		return this.studentNo;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getRole() {
		return this.role;
	}
	public String getFName() {
		return this.fname;
	}
	public String getMName() {
		return this.mname;
	}
	public String getLName() {
		return this.lname;
	}
	
	public boolean validate(String stud_no, String pass) {
		boolean status = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			DatabaseInfo info = new DatabaseInfo();
			Connection con = DriverManager.getConnection(info.getDatabasePath(), info.getUsername(), info.getPassword());

			PreparedStatement ps = con.prepareStatement("SELECT info.student_number, info.password, info.first_name, info.middle_name, info.last_name, info.role_id FROM user_info info WHERE BINARY info.student_number=? AND BINARY info.password=?");
			ps.setString(1, stud_no);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();
			status = rs.next();
			
			setStudNo(rs.getString("student_number"));
			setPassword(rs.getString("password"));
			setFName(rs.getString("first_name"));
			setMName(rs.getString("middle_name"));
			setLName(rs.getString("last_name"));
			setRole(rs.getString("role_id"));

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public boolean changePasswordDB(String username, String currentPassword, String newPassword) {
		boolean status = false;
		int stat;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			DatabaseInfo info = new DatabaseInfo();
			Connection con = DriverManager.getConnection(info.getDatabasePath(), info.getUsername(), info.getPassword());
			
			PreparedStatement ps = con.prepareStatement("UPDATE user_info SET password=? WHERE student_number=? AND password=?");
			ps.setString(1, newPassword);
			ps.setString(2, username);
			ps.setString(3, currentPassword);

			stat = ps.executeUpdate();
			if (stat == 1) {
				status = true;
			} else {
				status = false;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
}
