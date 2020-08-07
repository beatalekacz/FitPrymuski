package com.FitPrymuski.FP.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Data {
	
	public String name;
	public String mail;
	public String message;
	public static List<Data> dataList= new ArrayList<Data>();

	static {

		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/FitPrymuski",
					"postgres", "");
			
			// hasło do wpisania

			Statement statement = connection.createStatement();

			ResultSet data = statement.executeQuery("Select * FROM data;");

			while (data.next()) {

				String name = data.getString("name");
				String mail = data.getString("mail");
				String message = data.getString("message");
		
				

				new Data(name, mail, message);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	public Data(String name, String mail, String message) {
		
		this.name = name;
		this.mail = mail;
		this.message = message;
		

		dataList.add(this);
	}

	public Data() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
