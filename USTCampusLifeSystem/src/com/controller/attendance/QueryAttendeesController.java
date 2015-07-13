package com.controller.attendance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.datastructures.models.DatabaseInfo;
import com.datastructures.models.UserDataQuery;

public class QueryAttendeesController {
	
	private UserDataQuery userData = new UserDataQuery();
	private List<UserDataQuery> usersList = new ArrayList<UserDataQuery>();
	
	public List<UserDataQuery> queryAttendees(String eventID) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			DatabaseInfo info = new DatabaseInfo();
			Connection con = DriverManager.getConnection(
					info.getDatabasePath(), info.getUsername(),
					info.getPassword());

			PreparedStatement ps = con
					.prepareStatement("SELECT usr.student_number, usr.first_name, usr.middle_name, usr.last_name, col.college_desc, rol.role_desc FROM user_info usr, college col, user_role rol, event_attendance att WHERE usr.college_no=col.college_id AND usr.role_id=rol.role_id AND usr.role_id<>'S' AND usr.student_number=att.user_no AND att.event_no=?");
			ps.setString(1, eventID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				userData = new UserDataQuery();
				userData.setStudentNumber(rs.getString("student_number"));
				if (!rs.getString("middle_name").equals(null)) {
					userData.setName(rs.getString("first_name") + " " + rs.getString("middle_name") + " " + rs.getString("last_name"));
				} else {
					userData.setName(rs.getString("first_name") + " " + rs.getString("last_name"));
				}
				userData.setCollege(rs.getString("college_desc"));
				userData.setRole(rs.getString("role_desc"));
				usersList.add(userData);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return usersList;
	}

}
