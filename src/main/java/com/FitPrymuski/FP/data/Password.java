package com.FitPrymuski.FP.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Password {
	
	public String mail;
	
	public static List<Password> passwordList= new ArrayList<Password>();

	static {

		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/FitPrymuski",
					"postgres", "");
			
			// hasło do wpisania

			Statement statement = connection.createStatement();

			ResultSet data = statement.executeQuery("Select * FROM password;");

			while (data.next()) {

				String mail = data.getString("mail");

				new Password (mail);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	public Password() {
	}

	public Password (String mail) {
		
		this.mail = mail;
	

		passwordList.add(this);
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}