package com.controller.attendance;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserEventAttendance
 */
@WebServlet("/UserEventAttendance")
public class UserEventAttendance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserEventVerification eventInfo = new UserEventVerification();
		UserEventAttendanceController attend = new UserEventAttendanceController();
		RequestDispatcher rd;
		
		if (eventInfo.isEventOnDatabase(request.getParameter("eventID")) && eventInfo.isUserOnDatabase(request.getParameter("studNo")) && !eventInfo.isInfoOnAttendanceDatabase(request.getParameter("eventID"), request.getParameter("studNo"))) {
			if(attend.addToDatabase(request.getParameter("eventID"), request.getParameter("studNo"))) {
				rd = request.getRequestDispatcher("add-attendance-success.jsp");
				request.setAttribute("firstName", eventInfo.getFirstName());
				request.setAttribute("event_id", eventInfo.getEventData().getEventID());
				rd.forward(request, response);
			} else {
				request.setAttribute("event_id", eventInfo.getEventData().getEventID());
				rd = request.getRequestDispatcher("add-attendance-fail.jsp");
				rd.forward(request, response);
			}
		} else {
			request.setAttribute("event_id", eventInfo.getEventData().getEventID());
			rd = request.getRequestDispatcher("add-attendance-fail.jsp");
			rd.forward(request, response);
		}
	}

}
