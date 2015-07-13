package com.controller.accounts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.datastructures.models.*;

public class QueryUserController {

	private UserDataQuery userData = new UserDataQuery();
	private List<UserDataQuery> usersList = new ArrayList<UserDataQuery>();

	public QueryUserController() {

	}

	public List<UserDataQuery> queryUsers() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			DatabaseInfo info = new DatabaseInfo();
			Connection con = DriverManager.getConnection(
					info.getDatabasePath(), info.getUsername(),
					info.getPassword());

			PreparedStatement ps = con
					.prepareStatement("SELECT usr.student_number, usr.first_name, usr.middle_name, usr.last_name, usr.birthday, usr.cell_num, usr.phone_num, usr.email, col.college_desc, usr.gender, rol.role_desc FROM user_info usr, college col, user_role rol WHERE usr.college_no=col.college_id AND usr.role_id=rol.role_id AND usr.role_id<>'S'");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				userData = new UserDataQuery();
				userData.setStudentNumber(rs.getString("student_number"));
				if (!rs.getString("middle_name").equals(null)) {
					userData.setName(rs.getString("first_name") + " " + rs.getString("middle_name") + " " + rs.getString("last_name"));
				} else {
					userData.setName(rs.getString("first_name") + " " + rs.getString("last_name"));
				}
				userData.setBirthday(rs.getString("birthday"));
				if (!rs.getString("cell_num").equals(null)) {
					userData.setCellNo(rs.getString("cell_num"));
				} else {
					userData.setCellNo("-");
				}
				if (!rs.getString("phone_num").equals(null)) {
					userData.setPhoneNo(rs.getString("phone_num"));
				} else {
					userData.setPhoneNo("-");
				}
				if (!rs.getString("email").equals(null)) {
					userData.setEmail(rs.getString("email"));
				} else {
					userData.setEmail("-");
				}
				userData.setCollege(rs.getString("college_desc"));
				if (rs.getString("gender").equals("M")) {
					userData.setGender("Male");
				} else if (rs.getString("gender").equals("F")) {
					userData.setGender("Female");
				}
				userData.setRole(rs.getString("role_desc"));
				usersList.add(userData);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return usersList;
	}

}
