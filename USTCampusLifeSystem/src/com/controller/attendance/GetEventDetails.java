package com.controller.attendance;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetEventDetails {

	public void getEventDetails(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserEventVerification eventInfo = new UserEventVerification();
		RequestDispatcher rd;
		String date = "";
		String time = "";

		if (eventInfo.isEventOnDatabase(request.getParameter("eventID"))
				&& (!request.getParameter("eventID").equals(null) || !request
						.getParameter("eventID").isEmpty())) {
			HttpSession session = request.getSession();
			session.setAttribute("event_id", eventInfo.getEventData()
					.getEventID());
			session.setAttribute("event_name", eventInfo.getEventData()
					.getEventName());
			session.setAttribute("event_type", eventInfo.getEventData()
					.getEventTypeDesc());
			session.setAttribute("event_venue", eventInfo.getEventData()
					.getEventVenueDesc());

			if (isSameDay(eventInfo.getEventData().getEventStartDate(),
					eventInfo.getEventData().getEventEndDate())) {
				date = convertDate(eventInfo.getEventData().getEventStartDate());
				time = eventInfo.getEventData().getEventStartTime() + " - "
						+ eventInfo.getEventData().getEventEndTime();
			} else {
				date = convertDate(eventInfo.getEventData().getEventStartDate())
						+ " - "
						+ convertDate(eventInfo.getEventData()
								.getEventEndDate());
				time = eventInfo.getEventData().getEventStartTime()
						+ " ("
						+ convertDate(eventInfo.getEventData()
								.getEventStartDate())
						+ ") - "
						+ eventInfo.getEventData().getEventEndTime()
						+ " ("
						+ convertDate(eventInfo.getEventData()
								.getEventEndDate()) + ")";
			}

			session.setAttribute("event_date", date);
			session.setAttribute("event_time", time);

			rd = request.getRequestDispatcher("add-attendance.jsp");
			rd.include(request, response);
		}
	}

	private boolean isSameDay(String sDate, String eDate) {
		return sDate.equals(eDate);
	}

	private String convertDate(String date) {
		String[] dateF = date.split("-");
		String month = "";
		switch (dateF[1]) {
		case "01":
			month = "January";
			break;
		case "02":
			month = "February";
			break;
		case "03":
			month = "March";
			break;
		case "04":
			month = "April";
			break;
		case "05":
			month = "May";
			break;
		case "06":
			month = "June";
			break;
		case "07":
			month = "July";
			break;
		case "08":
			month = "August";
			break;
		case "09":
			month = "September";
			break;
		case "10":
			month = "October";
			break;
		case "11":
			month = "November";
			break;
		case "12":
			month = "December";
			break;
		}

		return month + " " + dateF[2] + ", " + dateF[0];
	}
}
