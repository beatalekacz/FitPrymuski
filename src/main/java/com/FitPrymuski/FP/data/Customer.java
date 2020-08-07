package com.FitPrymuski.FP.data;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Customer {

	public String login;
	public String name;
	public String surname;
	public String address;
	public String phone;
	public String mail;
	public String password;
	public static List<Customer> customerList = new ArrayList<Customer>();

	static {

		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/FitPrymuski",
					"postgres", "");
			
			// hasło do wpisania

			Statement statement = connection.createStatement();

			ResultSet data = statement.executeQuery("Select * FROM customer;");

			while (data.next()) {

				String login = data.getString("login");
				String name = data.getString("name");
				String surname = data.getString("surname");
				String address = data.getString("address");
				String phone = data.getString("phone");
				String mail = data.getString("mail");
				String password = data.getString("password");
				

				new Customer(login, name, surname, address, phone, mail, password);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public Customer() {
	}

	public Customer(String login, String name, String surname, String address, String phone, String mail, String password) {
		this.login = login;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phone = phone;
		this.mail = mail;
		this.password = password;
	
		customerList.add(this);
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
