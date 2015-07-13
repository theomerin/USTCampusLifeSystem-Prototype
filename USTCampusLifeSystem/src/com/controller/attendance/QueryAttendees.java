package com.controller.attendance;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.datastructures.models.UserDataQuery;
import com.datastructures.models.UserJsonObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class QueryAttendees
 */
@WebServlet("/QueryAttendees")
public class QueryAttendees extends HttpServlet {
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
		response.setContentType("application/json");
	    PrintWriter out = response.getWriter();
		QueryAttendeesController attendee = new QueryAttendeesController();
		List<UserDataQuery> userRecords = new ArrayList<UserDataQuery>();
		HttpSession session=request.getSession(false);  
		
		userRecords = attendee.queryAttendees((String)session.getAttribute("event_id"));
		
		UserJsonObject userJsonObject = new UserJsonObject();
	    
	    userJsonObject.setiTotalDisplayRecords(userRecords.size());
	    userJsonObject.setiTotalRecords(userRecords.size());
	    userJsonObject.setAaData(userRecords);
	    
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    String json = gson.toJson(userJsonObject);
	    out.print(json);
	}
}
