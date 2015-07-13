package com.controller.accounts;

import java.sql.*;

import com.datastructures.models.*;


public class AddUserController {

	public AddUserController() {
		
	}
	
	public boolean addToDatabase(User userInfo) {
		boolean status = false;
		int stat;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			DatabaseInfo info = new DatabaseInfo();
			Connection con = DriverManager.getConnection(info.getDatabasePath(), info.getUsername(), info.getPassword());

			PreparedStatement ps = con.prepareStatement("INSERT INTO user_info VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, userInfo.getStudentNumber());
			ps.setString(2, userInfo.getFirstName());
			if (userInfo.checkIfBlankAndNotNull(userInfo.getMiddleName())) {
				ps.setNull(3,Types.VARCHAR);
			} else {
				ps.setString(3, userInfo.getMiddleName());
			}
			ps.setString(4, userInfo.getLastName());
			ps.setString(5, userInfo.getBirthday());
			if (userInfo.checkIfBlankAndNotNull(userInfo.getCellNo())) {
				ps.setString(6,"-");
			} else {
				ps.setString(6, userInfo.getCellNo());
			}
			if (userInfo.checkIfBlankAndNotNull(userInfo.getPhoneNo())) {
				ps.setString(7,"-");
			} else {
				ps.setString(7, userInfo.getPhoneNo());
			}
			if (userInfo.checkIfBlankAndNotNull(userInfo.getEmail())) {
				ps.setString(8,"-");
			} else {
				ps.setString(8, userInfo.getEmail());
			}
			ps.setString(9, userInfo.getCollegeNo());
			ps.setString(10, userInfo.getGender());
			ps.setString(11, userInfo.getPassword());
			ps.setString(12, userInfo.getRole());

			stat = ps.executeUpdate();
			if (stat == 1) {
				status = true;
			} else {
				status = false;
			}
			
		} catch (Exception e) {
			System.out.println(e);
			status = false;
		}
		return status;
	}

}
