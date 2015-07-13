package com.controller.accounts;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.datastructures.models.*;
/**
 * Servlet implementation class addUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User userData = new User();
		AddUserController addToDB = new AddUserController();
		RequestDispatcher rd;
		
		userData.getUserData(
				request.getParameter("studNo"), 
				request.getParameter("password"), 
				request.getParameter("role"), 
				request.getParameter("firstName"), 
				request.getParameter("middleName"), 
				request.getParameter("lastName"), 
				request.getParameter("birthday"), 
				request.getParameter("cellNo"), 
				request.getParameter("phoneNo"), 
				request.getParameter("email"), 
				request.getParameter("collegeAff"),
				request.getParameter("gender"));
		
		if (addToDB.addToDatabase(userData)) {
			rd = request.getRequestDispatcher("registration-success.jsp");
			request.setAttribute("firstName", userData.getFirstName());
			rd.forward(request, response);
		} else {
			rd = request.getRequestDispatcher("registration-fail.jsp");
			rd.forward(request, response);
		}
	}

}
