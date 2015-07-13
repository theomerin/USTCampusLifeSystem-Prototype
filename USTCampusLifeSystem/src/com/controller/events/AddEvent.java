package com.controller.events;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.datastructures.models.Event;

/**
 * Servlet implementation class AddEvent
 */
@WebServlet("/AddEvent")
public class AddEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);  
		RequestDispatcher rd;
		if ((Boolean) session.getAttribute("isUserLoggedIn")) {
        	Event eventInfo = new Event();
        	AddEventController evtInfo = new AddEventController();
        	eventInfo.setEventHead((String)session.getAttribute("stud_no"));
        	if (!request.getParameter("saaf").isEmpty() && !request.getParameter("saaf").equals(null)) {
        		eventInfo.setSaafNo(request.getParameter("saaf"));
        	} else {
        		eventInfo.setSaafNo("-");
        	}
        	eventInfo.setEventName(request.getParameter("evtName"));
        	eventInfo.setEventTypeNo(request.getParameter("eventType"));
        	eventInfo.setEventVenueNo(request.getParameter("eventVenue"));
        	eventInfo.setEventStartDate(request.getParameter("startDate"));
        	eventInfo.setEventEndDate(request.getParameter("endDate"));
        	eventInfo.setEventStartTime(request.getParameter("startTime"));
        	eventInfo.setEventEndTime(request.getParameter("endTime"));
        	
        	if (evtInfo.addToDatabase(eventInfo)) {
        		rd = request.getRequestDispatcher("create-event-success.jsp");
    			request.setAttribute("firstName", (String) session.getAttribute("fname"));
    			request.setAttribute("eventName", eventInfo.getEventName());
    			rd.forward(request, response);
    		} else {
    			rd = request.getRequestDispatcher("create-event-fail.jsp");
    			rd.forward(request, response);
    		}
        }
	}

}
