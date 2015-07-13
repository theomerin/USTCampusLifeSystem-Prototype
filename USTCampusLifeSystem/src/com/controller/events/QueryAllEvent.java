package com.controller.events;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.accounts.QueryUserController;
import com.datastructures.models.EventDataQuery;
import com.datastructures.models.EventJsonObject;
import com.datastructures.models.UserDataQuery;
import com.datastructures.models.UserJsonObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class QueryEvent
 */
@WebServlet("/QueryAllEvent")
public class QueryAllEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
	    PrintWriter out = response.getWriter();
	    QueryEventController events = new QueryEventController();
	    List<EventDataQuery> eventRecords = new ArrayList<EventDataQuery>();
	    HttpSession session = request.getSession();  
	    
	    eventRecords = events.queryAllEvents();
	    
	    EventJsonObject eventJsonObject = new EventJsonObject();
	    
	    eventJsonObject.setiTotalDisplayRecords(eventRecords.size());
	    eventJsonObject.setiTotalRecords(eventRecords.size());
	    eventJsonObject.setAaData(eventRecords);
	    
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    String json = gson.toJson(eventJsonObject);
	    out.print(json);
	}

}
