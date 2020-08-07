package com.FitPrymuski.FP.data;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Diet {

	public String name;
	public String price;
	public String kcal;
	public String characteristics;
	public String dishes;
	public static List<Diet> dietList = new ArrayList<Diet>();

	static {

		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/FitPrymuski",
					"postgres", "");
			
			// hasło do wpisania

			Statement statement = connection.createStatement();

			ResultSet data = statement.executeQuery("Select * FROM diet;");

			while (data.next()) {

				String name = data.getString("name");
				String price = data.getString("price");
				String kcal = data.getString("kcal");
				String characteristics = data.getString("characteristics");
				String dishes = data.getString("dishes");
				

				new Diet(name, price, kcal, characteristics, dishes);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public Diet(String name, String price, String kcal, String characteristics, String dishes) {
		this.name = name;
		this.price = price;
		this.kcal = kcal;
		this.characteristics = characteristics;
		this.dishes = dishes;

	
		dietList.add(this);
	}

	public Diet() {
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
	
	public String getDishes() {
		return dishes;
	}

	public void setDishes(String dishes) {
		this.dishes = dishes;
	}

}
