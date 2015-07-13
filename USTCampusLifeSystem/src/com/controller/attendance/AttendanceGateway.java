package com.controller.attendance;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AttendanceGateway
 */
@WebServlet("/AttendanceGateway")
public class AttendanceGateway extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GetEventDetails details = new GetEventDetails();
		RequestDispatcher rd;
		
		details.getEventDetails(request, response);
		
		if (request.getParameter("opt").equals("READ")) {
			rd = request.getRequestDispatcher("attendees-list.jsp");
			rd.forward(request, response);
		} else if (request.getParameter("opt").equals("ADD")) {
			rd = request.getRequestDispatcher("add-attendance.jsp");
			rd.forward(request, response);
		}
	}
}
