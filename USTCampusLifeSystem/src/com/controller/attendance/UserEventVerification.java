package com.controller.attendance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.datastructures.models.*;

public class UserEventVerification {	
	private EventDataQuery eventData;
	private User userData;
	
	public boolean isEventOnDatabase(String eventID) {
		eventData = new EventDataQuery();
		boolean status = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			DatabaseInfo info = new DatabaseInfo();
			Connection con = DriverManager.getConnection(info.getDatabasePath(), info.getUsername(), info.getPassword());

			PreparedStatement ps = con.prepareStatement("SELECT evt.event_id, evt.event_name, typ.type_desc, vne.venue_desc, evt.start_date, evt.end_date, evt.start_time, evt.end_time FROM event_info evt, event_venue vne, event_type typ WHERE evt.type_no=typ.type_id AND evt.venue_no=vne.venue_id AND evt.event_id=? ORDER BY evt.start_date, evt.start_time ASC");
			ps.setString(1, eventID);

			ResultSet rs = ps.executeQuery();
			status = rs.next();

			if (status) {
				eventData.setEventID(rs.getString("event_id"));
				eventData.setEventName(rs.getString("event_name"));
				eventData.setEventTypeDesc(rs.getString("type_desc"));
				eventData.setEventVenueDesc(rs.getString("venue_desc"));
				eventData.setEventStartDate(rs.getString("start_date"));
				eventData.setEventEndDate(rs.getString("end_date"));
				eventData.setEventStartTime(rs.getString("start_time"));
				eventData.setEventEndTime(rs.getString("end_time"));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public boolean isUserOnDatabase(String studNo) {
		userData = new User();
		boolean status = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			DatabaseInfo info = new DatabaseInfo();
			Connection con = DriverManager.getConnection(info.getDatabasePath(), info.getUsername(), info.getPassword());

			PreparedStatement ps = con.prepareStatement("SELECT * FROM user_info WHERE student_number=?");
			ps.setString(1, studNo);

			ResultSet rs = ps.executeQuery();
			status = rs.next();

			if (status) {
				userData.setFirstName(rs.getString("first_name"));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public boolean isInfoOnAttendanceDatabase(String eventID, String studNo) {
		userData = new User();
		boolean status = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			DatabaseInfo info = new DatabaseInfo();
			Connection con = DriverManager.getConnection(info.getDatabasePath(), info.getUsername(), info.getPassword());

			PreparedStatement ps = con.prepareStatement("SELECT * FROM event_attendance WHERE event_no=? AND user_no=?");
			ps.setString(1, eventID);
			ps.setString(2, studNo);

			ResultSet rs = ps.executeQuery();
			status = rs.next();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public EventDataQuery getEventData() {
		return eventData;
	}
	
	public String getFirstName() {
		return userData.getFirstName();
	}
}
