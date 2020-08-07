package com.FitPrymuski.FP.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Message {
	
	public String name;
	public String mail;
	public String subject;
	public String message;
	public static List<Message> messageList= new ArrayList<Message>();

	static {

		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/FitPrymuski",
					"postgres", "");
			
			// hasło do wpisania

			Statement statement = connection.createStatement();

			ResultSet data = statement.executeQuery("Select * FROM message;");

			while (data.next()) {

				String name = data.getString("name");
				String mail = data.getString("mail");
				String subject = data.getString("subject");
				String message = data.getString("message");
		
				

				new Message(name, mail, subject, message);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	public Message(String name, String mail, String subject, String message) {
		
		this.name = name;
		this.mail = mail;
		this.subject = subject;
		this.message = message;
		

		messageList.add(this);
	}

	public Message() {
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
	
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
