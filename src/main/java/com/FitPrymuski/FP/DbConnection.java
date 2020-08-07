package com.FitPrymuski.FP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class DbConnection {
	public static Connection connection;
	
	public static void initialize() {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/FitPrymuski",
					"postgres", "");
			// hasło do wpisania
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void insert(String table, HashMap<String, String> fields) {
		try {
			Statement statement = connection.createStatement();
			
			String keys = new String("");
			String vals = new String("");
			
			Iterator<Entry<String, String>> it = fields.entrySet().iterator();
			
			while (it.hasNext()) {
				Entry<String, String> entry = it.next();
				
				if (it.hasNext()) {
					keys = keys.concat(entry.getKey() + ",");
					vals = vals.concat("'" + entry.getValue() + "',");
				} else {
					keys = keys.concat(entry.getKey());
					vals = vals.concat("'" + entry.getValue() + "'");
				}
			}
			
			String temp = new String("INSERT INTO " + table + " (" + keys + ")" + " VALUES (" + vals + ");");
			System.out.println(temp);
			
			statement.execute(temp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
