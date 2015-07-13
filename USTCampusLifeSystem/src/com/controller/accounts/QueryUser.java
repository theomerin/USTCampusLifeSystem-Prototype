package com.controller.accounts;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.datastructures.models.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class queryUser
 */
@WebServlet("/QueryUser")
public class QueryUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
	    PrintWriter out = response.getWriter();
	    QueryUserController users = new QueryUserController();
	    List<UserDataQuery> userRecords = new ArrayList<UserDataQuery>();
	    
	    userRecords = users.queryUsers();
	    
	    UserJsonObject userJsonObject = new UserJsonObject();
	    
	    userJsonObject.setiTotalDisplayRecords(userRecords.size());
	    userJsonObject.setiTotalRecords(userRecords.size());
	    userJsonObject.setAaData(userRecords);
	    
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    String json = gson.toJson(userJsonObject);
	    out.print(json);
	}
}
