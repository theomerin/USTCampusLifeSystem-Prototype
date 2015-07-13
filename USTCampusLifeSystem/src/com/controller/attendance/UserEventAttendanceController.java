package com.controller.attendance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.datastructures.models.DatabaseInfo;
import com.datastructures.models.Event;

public class UserEventAttendanceController {

	public boolean addToDatabase(String eventID, String studNo) {
		boolean status = false;
		int stat;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			DatabaseInfo info = new DatabaseInfo();
			Connection con = DriverManager.getConnection(info.getDatabasePath(), info.getUsername(), info.getPassword());

			PreparedStatement ps = con.prepareStatement("INSERT INTO event_attendance VALUES (?, ?)");
			ps.setString(1, eventID);
			ps.setString(2, studNo);
			
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
