package com.datastructures.models;

public class DatabaseInfo {

	private String databasePath;
	private String username;
	private String password;
	
	public DatabaseInfo() {
		this.databasePath = "jdbc:mysql://localhost:3306/ustcampuslife_onlinesys";
		this.username = "root";
		this.password = "root";
	}

	public String getDatabasePath() {
		return databasePath;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
