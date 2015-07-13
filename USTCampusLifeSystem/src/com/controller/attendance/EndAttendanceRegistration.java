package com.controller.attendance;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EndAttendanceRegistration
 */
@WebServlet("/EndAttendanceRegistration")
public class EndAttendanceRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session  = request.getSession();
		
		session.removeAttribute("event_id");  
		session.removeAttribute("event_name");
		session.removeAttribute("event_type");
		session.removeAttribute("event_venue");
		session.removeAttribute("event_date");
		session.removeAttribute("event_time");
		
		response.sendRedirect("home.jsp");  
	}

}
