package com.controller.validation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	private String username;
	private String currentPass;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		UserDaoController userDB = new UserDaoController();
		this.currentPass = (String) request.getSession().getAttribute("login_code");
		this.username = (String) request.getSession().getAttribute("stud_no");
		
		if (isSameAsCurrentPassword(request.getParameter("passwordCur"), request)) {
			if (userDB.changePasswordDB(this.username, this.currentPass, request.getParameter("password"))) {
				rd = request.getRequestDispatcher("change-password-success.jsp");
				request.setAttribute("firstName", (String) request.getSession().getAttribute("fname"));
				rd.forward(request, response);
			} else {
				rd = request.getRequestDispatcher("change-password-fail.jsp");
				rd.forward(request, response);
			}
		} else {
			rd = request.getRequestDispatcher("change-password-fail.jsp");
			rd.forward(request, response);
		}
	}
	
	public boolean isSameAsCurrentPassword(String input, HttpServletRequest request) {
		return (this.currentPass.equals(input));
 	}

	
	
}
