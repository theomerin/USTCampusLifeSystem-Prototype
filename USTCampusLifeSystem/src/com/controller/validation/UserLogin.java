package com.controller.validation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studNo = request.getParameter("studentNumber");
		String pass = request.getParameter("password");
		UserDaoController loginDao = new UserDaoController();
		RequestDispatcher rd;
		
		if (loginDao.validate(studNo, pass)) {
	        switch (loginDao.getRole()) {
	        	case "S":
	        	case "L":
	        	case "M":
	        	case "A":
	    			HttpSession session = request.getSession();  
	    	        session.setAttribute("stud_no", loginDao.getStudNo());
	    	        session.setAttribute("login_code", loginDao.getPassword());
	    	        session.setAttribute("fname", loginDao.getFName());
	    	        session.setAttribute("lname", loginDao.getLName());
	    	        session.setAttribute("role", loginDao.getRole());
	        		session.setAttribute("isUserLoggedIn", true);
	        		rd = request.getRequestDispatcher("home.jsp");
	    			rd.forward(request, response);
	    			break;
	    		default:
	    			request.setAttribute("INVALID","NO_AUTHORIZATION") ;
	    			rd = request.getRequestDispatcher("login.jsp");
	    			rd.forward(request, response);
	        }
		} else {
			request.setAttribute("INVALID","INVALID_CREDENTIALS") ;
			rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
