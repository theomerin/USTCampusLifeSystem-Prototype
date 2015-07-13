package com.controller.events;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Types;

import com.datastructures.models.DatabaseInfo;
import com.datastructures.models.Event;

public class AddEventController {

	public AddEventController() {
		
	}
	
	public boolean addToDatabase(Event evt) {
		boolean status = false;
		int stat;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			DatabaseInfo info = new DatabaseInfo();
			Connection con = DriverManager.getConnection(info.getDatabasePath(), info.getUsername(), info.getPassword());

			PreparedStatement ps = con.prepareStatement("INSERT INTO event_info VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, evt.getEventID());
			ps.setString(2, evt.getEventName());
			ps.setString(3, evt.getEventTypeNo());
			ps.setString(4, evt.getEventHead());
			ps.setString(5, evt.getEventVenueNo());
			ps.setString(6, evt.getEventStartDate());
			ps.setString(7, evt.getEventEndDate());
			ps.setString(8, evt.getEventStartTime());
			ps.setString(9, evt.getEventEndTime());
			ps.setString(10, evt.getSaafNo());
			
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