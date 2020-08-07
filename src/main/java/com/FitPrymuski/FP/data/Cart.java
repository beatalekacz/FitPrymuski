package com.FitPrymuski.FP.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	public String name;
	public String duration;
	public String message;
	public static List<Cart> cartList= new ArrayList<Cart>();
	

	static {

		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/FitPrymuski",
					"postgres", "");
			
			// hasło do wpisania

			Statement statement = connection.createStatement();

			ResultSet data = statement.executeQuery("Select * FROM cart;");

			while (data.next()) {

				String name = data.getString("name");
				String duration = data.getString("duration");
				String message = data.getString("message");
		
				

				new Cart(name, duration, message);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	public Cart(String name, String duration, String message) {
		
		this.name = name;
		this.duration = duration;
		this.message = message;
		

		cartList.add(this);
	}

	public Cart() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
