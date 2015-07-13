package com.datastructures.models;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Event implements Serializable {

	private String saafNo;
	private String eventID;
	private String eventName;
	private String eventTypeNo;
	private String eventHead;
	private String eventVenueNo;
	private String eventStartDate;
	private String eventEndDate;
	private String eventStartTime;
	private String eventEndTime;
	
	public Event() {
		// TODO Auto-generated constructor stub
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

	private void setEventID() {
		if (!this.eventHead.isEmpty() && !this.eventHead.equals(null) && !this.eventHead.equals("KERYGMA")) {
			this.eventID = generateEventID(this.eventHead);
		} else {
			this.eventID = null;
		}
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

	public String getEventHead() {
		return eventHead;
	}

	public void setEventHead(String eventHead) {
		this.eventHead = eventHead;
		setEventID();
	}

	public String getEventVenueNo() {
		return eventVenueNo;
	}

	public void setEventVenueNo(String eventVenueNo) {
		this.eventVenueNo = eventVenueNo;
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
	
	private String generateEventID(String studNo) {
		String current;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		current = dateFormat.format(cal.getTime());
		return current.substring(0, 10).replaceAll("/", "") + studNo.substring(2) + current.substring(11).replaceAll(":", "");
	}
}
