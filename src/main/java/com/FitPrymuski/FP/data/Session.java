package com.FitPrymuski.FP.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Session {
	
	public String login;
	public String password;
	
	public static List<Session> sessionList = new ArrayList<Session>();

	static {

		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/FitPrymuski",
					"postgres", "");
			
			// hasło do wpisania

			Statement statement = connection.createStatement();

			ResultSet data = statement.executeQuery("Select * FROM session;");

			while (data.next()) {

				String login = data.getString("login");
				String password = data.getString("password");

				new Session (login, password);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	public Session() {
	}

	public Session (String login, String password) {
		
		this.login = login;
		this.password = password;
	

		sessionList.add(this);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
}
}