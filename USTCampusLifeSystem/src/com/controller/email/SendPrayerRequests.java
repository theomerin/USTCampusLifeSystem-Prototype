package com.controller.email;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendPrayerRequests
 */
@WebServlet("/SendPrayerRequests")
public class SendPrayerRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SendMailSSL mailer = new SendMailSSL();
		String name = "";
		String concern = "";
		String subject;
		String message = "";
		
		name = request.getParameter("name");
		concern = request.getParameter("concern");
		message = request.getParameter("prayer");
				
		if (name.equals("")) {
			name = "(Anonymous)";
		} else {
			name = "(" + name + ")";
		}
		
		subject = name + " My prayer request - " + concern;
		
		if (mailer.sendMail(subject, message)) {
			System.out.print("Prayer Sent");
		} else {
			System.out.print("Unsuccessful");
		}
	}

}
