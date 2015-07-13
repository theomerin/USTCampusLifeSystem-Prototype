package com.datastructures.models;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EventDataQuery implements Serializable {

	private String saafNo;
	private String eventID;
	private String eventName;
	private String eventTypeNo;
	private String eventTypeDesc;
	private String eventHead;
	private String eventHeadName;
	private String eventVenueNo;
	private String eventVenueDesc;
	private String eventStartDate;
	private String eventEndDate;
	private String eventStartTime;
	private String eventEndTime;
	private String control;
	private String attendanceControl;
	private String status;
	
	public EventDataQuery() {
		setControl();
		setAttendanceControl();
	}

	public String getSaafNo() {
		return saafNo;
	}

	public void setSaafNo(String saafNo) {
		this.saafNo = saafNo;
	}

	public String getEventID() {
		return eventID;
	}

	public void setEventID(String eventID) {
		this.eventID = eventID;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventTypeNo() {
		return eventTypeNo;
	}

	public void setEventTypeNo(String eventTypeNo) {
		this.eventTypeNo = eventTypeNo;
	}

	public String getEventTypeDesc() {
		return eventTypeDesc;
	}

	public void setEventTypeDesc(String eventTypeDesc) {
		this.eventTypeDesc = eventTypeDesc;
	}

	public String getEventHead() {
		return eventHead;
	}

	public void setEventHead(String eventHead) {
		this.eventHead = eventHead;
	}

	public String getEventHeadName() {
		return eventHeadName;
	}

	public void setEventHeadName(String eventHeadName) {
		this.eventHeadName = eventHeadName;
	}

	public String getEventVenueNo() {
		return eventVenueNo;
	}

	public void setEventVenueNo(String eventVenueNo) {
		this.eventVenueNo = eventVenueNo;
	}

	public String getEventVenueDesc() {
		return eventVenueDesc;
	}

	public void setEventVenueDesc(String eventVenueDesc) {
		this.eventVenueDesc = eventVenueDesc;
	}

	public String getEventStartDate() {
		return eventStartDate;
	}

	public void setEventStartDate(String eventStartDate) {
		this.eventStartDate = eventStartDate;
	}

	public String getEventEndDate() {
		return eventEndDate;
	}

	public void setEventEndDate(String eventEndDate) {
		this.eventEndDate = eventEndDate;
	}

	public String getEventStartTime() {
		return eventStartTime;
	}

	public void setEventStartTime(String eventStartTime) {
		this.eventStartTime = eventStartTime;
	}

	public String getEventEndTime() {
		return eventEndTime;
	}

	public void setEventEndTime(String eventEndTime) {
		this.eventEndTime = eventEndTime;
	}

	public String getControl() {
		return control;
	}

	public void setControl() {
		this.control = "<a class=\"btn btn-success btn-sm\" href=\"#\" role=\"button\" title=\"Edit\"><span class=\"glyphicon glyphicon-pencil\" aria-hidden=\"true\"></span></a>&nbsp;<a class=\"btn btn-danger btn-sm\" href=\"#\" role=\"button\" title=\"Delete\"><span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span></a>";
	}

	public String getAttendanceControl() {
		return attendanceControl;
	}

	public void setAttendanceControl() {
		this.attendanceControl = "<button id=\"add\" class=\"btn btn-primary btn-sm\" title=\"Attendance\" type=\"submit\"><span class=\"glyphicon glyphicon-map-marker\" aria-hidden=\"true\"></span></button>&nbsp;<button id=\"read\" class=\"btn btn-success btn-sm\" title=\"List of Attendees\" type=\"submit\"><span class=\"glyphicon glyphicon-list\" aria-hidden=\"true\"></span></button>";
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus() {
		String current;
		String curDay;
		String curTime;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm aa");
		Calendar cal = Calendar.getInstance();
		current = dateFormat.format(cal.getTime());
		curDay = current.substring(0, 10);
		curTime = current.substring(11);
		
		if (curDay.compareToIgnoreCase(getEventStartDate()) < 0 || (curDay.compareToIgnoreCase(getEventStartDate()) == 0 && curTime.compareToIgnoreCase(getEventStartTime()) < 0)) {
			this.status = "Upcoming";
		} else if ((curDay.compareToIgnoreCase(getEventStartDate()) >= 0 && curTime.compareToIgnoreCase(getEventStartTime()) >= 0) && (curDay.compareToIgnoreCase(getEventEndDate()) <= 0 && curTime.compareToIgnoreCase(getEventEndTime()) <= 0)) {
			this.status = "On-going";
		} else {
			this.status = "Ended";;
		}
	}
}
