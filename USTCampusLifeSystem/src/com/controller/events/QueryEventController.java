package com.controller.events;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.datastructures.models.*;

public class QueryEventController {

	private EventDataQuery eventData = new EventDataQuery();
	private List<EventDataQuery> eventsList = new ArrayList<EventDataQuery>();

	public QueryEventController() {

	}

	public List<EventDataQuery> queryOrganizedEvents(String studNo) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			DatabaseInfo info = new DatabaseInfo();
			Connection con = DriverManager.getConnection(
					info.getDatabasePath(), info.getUsername(),
					info.getPassword());

			PreparedStatement ps = con
					.prepareStatement("SELECT evt.event_id, evt.event_name, typ.type_desc, vne.venue_desc, evt.start_date, evt.end_date, evt.start_time, evt.end_time FROM event_info evt, event_venue vne, event_type typ WHERE evt.type_no=typ.type_id AND evt.venue_no=vne.venue_id AND evt.event_head=? ORDER BY evt.start_date, evt.start_time ASC");

			ps.setString(1, studNo);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				eventData = new EventDataQuery();
				eventData.setEventID(rs.getString("event_id"));
				eventData.setEventName(rs.getString("event_name"));
				eventData.setEventTypeDesc(rs.getString("type_desc"));
				eventData.setEventVenueDesc(rs.getString("venue_desc"));
				eventData.setEventStartDate(rs.getString("start_date"));
				eventData.setEventEndDate(rs.getString("end_date"));
				eventData.setEventStartTime(rs.getString("start_time"));
				eventData.setEventEndTime(rs.getString("end_time"));
				eventData.setStatus();
				eventsList.add(eventData);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return eventsList;
	}

	public List<EventDataQuery> queryAllEvents() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			DatabaseInfo info = new DatabaseInfo();
			Connection con = DriverManager.getConnection(
					info.getDatabasePath(), info.getUsername(),
					info.getPassword());

			PreparedStatement ps = con
					.prepareStatement("SELECT evt.event_id, evt.event_name, typ.type_desc, vne.venue_desc, evt.start_date, evt.end_date, evt.start_time, evt.end_time FROM event_info evt, event_venue vne, event_type typ WHERE evt.type_no=typ.type_id AND evt.venue_no=vne.venue_id ORDER BY evt.start_date, evt.start_time ASC");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				eventData = new EventDataQuery();
				eventData.setEventID(rs.getString("event_id"));
				eventData.setEventName(rs.getString("event_name"));
				eventData.setEventTypeDesc(rs.getString("type_desc"));
				eventData.setEventVenueDesc(rs.getString("venue_desc"));
				eventData.setEventStartDate(rs.getString("start_date"));
				eventData.setEventEndDate(rs.getString("end_date"));
				eventData.setEventStartTime(rs.getString("start_time"));
				eventData.setEventEndTime(rs.getString("end_time"));
				eventData.setStatus();
				eventsList.add(eventData);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return eventsList;
	}
}
