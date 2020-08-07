package com.FitPrymuski.FP.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dish {
	
	public String name;
	public String price;
	public String kcal;
	public String characteristics;
	public String category;
	public static List<Dish> dishList = new ArrayList<Dish>();

	static {

		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/FitPrymuski",
					"postgres", "");
			
			// hasło do wpisania

			Statement statement = connection.createStatement();

			ResultSet data = statement.executeQuery("Select * FROM dish;");

			while (data.next()) {

				String name = data.getString("name");
				String price = data.getString("price");
				String kcal = data.getString("kcal");
				String characteristics = data.getString("characteristics");
				String category = data.getString("category");
				

				new Dish(name, price, kcal, characteristics, category);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	public Dish(String name, String price, String kcal, String characteristics, String category) {
		
		this.name = name;
		this.price = price;
		this.kcal = kcal;
		this.characteristics = characteristics;
		this.category = category;

		dishList.add(this);
	}

	public Dish() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getKcal() {
		return kcal;
	}

	public void setKcal(String kcal) {
		this.kcal = kcal;
	}

	public String getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
		
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
