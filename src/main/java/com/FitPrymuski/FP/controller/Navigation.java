package com.FitPrymuski.FP.controller;

import java.sql.Statement;
import java.util.HashMap;
import java.util.Map.Entry;
import java.sql.Connection;
import java.sql.DriverManager;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.FitPrymuski.FP.DbConnection;
import com.FitPrymuski.FP.data.Cart;
import com.FitPrymuski.FP.data.Customer;
import com.FitPrymuski.FP.data.Data;
import com.FitPrymuski.FP.data.Diet;
import com.FitPrymuski.FP.data.Dish;
import com.FitPrymuski.FP.data.EmployeeSession;
import com.FitPrymuski.FP.data.Message;
import com.FitPrymuski.FP.data.Password;
import com.FitPrymuski.FP.data.Session;

@Controller
public class Navigation {
	
	// modele i atrybuty, dodawanie do bazy

	
	//rejestracja klienta

	@GetMapping("/rejestracja")
	public String toRejestracja(Model modelKlienta) {
		modelKlienta.addAttribute("account", new Customer());
		return "rejestracja";
	}

	@PostMapping("/rejestracja")
	public String getRejestracja(@ModelAttribute Customer customer) {

		if (!customer.getName().equals("") && !customer.getSurname().equals("") && !customer.getLogin().equals("")&& !customer.getMail().equals("")&& !customer.getPassword().equals("")&& !customer.getAddress().equals("")&& !customer.getPhone().equals("")) {
			Customer.customerList.add(customer);
			
			System.out.println(customer.getName() + ", " + customer.getLogin() + ", " + customer.getSurname() + ", " + customer.getMail() + ", " + customer.getPassword() + ", " + customer.getAddress() + ", " + customer.getPhone());

			System.out.println(Customer.customerList);
			
			HashMap<String, String> data = new HashMap<>();
			data.put("Login", customer.login);
			data.put("Name", customer.name);
			data.put("Surname", customer.surname);
			data.put("Phone", customer.phone);
			data.put("Address", customer.address);
			data.put("Mail", customer.mail);
			data.put("Password", customer.password);
			
			DbConnection.insert("customer", data);

			return "redirect:/zaloguj";
		}

		return "errorPage";
	}

	// dodawanie dania
	
	@GetMapping("/danie_dodaj")
	public String toDanie(Model modelDania) {
		modelDania.addAttribute("dishmodel", new Dish());
		return "danie_dodaj";
	}
	
	@PostMapping("/danie_dodaj")
	public String getDanie(@ModelAttribute Dish dish) {

		if (!dish.getName().equals("") && !dish.getPrice().equals("") && !dish.getKcal().equals("")&& !dish.getCharacteristics().equals("")&& !dish.getCategory().equals("")) {
			Dish.dishList.add(dish);
			
			System.out.println(dish.getName() + ", " + dish.getPrice() + ", " + dish.getKcal() + ", " + dish.getCharacteristics() + ", " + dish.getCategory());

			System.out.println(Dish.dishList);
			
			HashMap<String, String> data = new HashMap<>();
			data.put("name", dish.name);
			data.put("price", dish.price);
			data.put("kcal", dish.kcal);
			data.put("characteristics", dish.characteristics);
			data.put("category", dish.category);
			
			
			DbConnection.insert("dish", data);

			return "redirect:/danie_lista";
		}

		return "errorPage";
	}
	
	// dodawanie diety
	
	@GetMapping("/dieta_dodaj")
	public String toDieta(Model modelDiety) {
		modelDiety.addAttribute("dietmodel", new Diet());
		return "dieta_dodaj";
	}
	
	@PostMapping("/dieta_dodaj")
	public String getDieta(@ModelAttribute Diet diet) {

		if (!diet.getName().equals("") && !diet.getPrice().equals("") && !diet.getKcal().equals("")&& !diet.getCharacteristics().equals("")&& !diet.getDishes().equals("")) {
			Diet.dietList.add(diet);
			
			System.out.println(diet.getName() + ", " + diet.getPrice() + ", " + diet.getKcal() + ", " + diet.getCharacteristics() + ", " + diet.getDishes());

			System.out.println(Diet.dietList);
			
			HashMap<String, String> data = new HashMap<>();
			data.put("name", diet.name);
			data.put("price", diet.price);
			data.put("kcal", diet.kcal);
			data.put("characteristics", diet.characteristics);
			data.put("dishes", diet.dishes);
			
			
			DbConnection.insert("diet", data);

			return "redirect:/dieta_lista";
		}

		return "errorPage";
	}
	
	
	// formularz zmiany danych
	
	
	@GetMapping("/klient_zmianadanych")
	public String toZmiana(Model modelZmiany) {
		modelZmiany.addAttribute("change", new Data());
		return "klient_zmianadanych";
	}

	@PostMapping("/klient_zmianadanych")
	public String getZmiana(@ModelAttribute Data data) {

		if (!data.getName().equals("") && !data.getMail().equals("")&& !data.getMessage().equals("")) {
			Data.dataList.add(data);
			
			System.out.println(data.getName() + ", " + data.getMail() + ", " + data.getMessage());

			System.out.println(Data.dataList);
			
			HashMap<String, String> datachange = new HashMap<>();
			datachange.put("name", data.name);
			datachange.put("mail", data.mail);
			datachange.put("message", data.message);
			
			DbConnection.insert("data", datachange);

			return "redirect:/";
		}

		return "errorPage";
	}
	
	// formularz kontaktowy
	
	@GetMapping("/kontakt")
	public String toKontakt(Model modelWiadomosci) {
		modelWiadomosci.addAttribute("contact", new Message());
		return "kontakt";
	}

	@PostMapping("/kontakt")
	public String getKontakt(@ModelAttribute Message message) {

		if (!message.getName().equals("") && !message.getMail().equals("") && !message.getSubject().equals("") && !message.getMessage().equals("")) {
			Message.messageList.add(message);
			
			System.out.println(message.getName() + ", " + message.getMail() + ", " + message.getSubject() + ", " + message.getMessage());

			System.out.println(Data.dataList);
			
			HashMap<String, String> data = new HashMap<>();
			data.put("name", message.name);
			data.put("mail", message.mail);
			data.put("subject", message.subject);
			data.put("message", message.message);
			
			DbConnection.insert("message", data);

			return "redirect:/";
		}

		return "errorPage";
	}
	
	
	// sesja logowania klienta
	
	@GetMapping("/zaloguj")
	public String toZaloguj(Model modelSesji) {
		modelSesji.addAttribute("log", new Session());
		return "zaloguj";
	}

	@PostMapping("/zaloguj")
	public String getZaloguj(@ModelAttribute Session session) {

		if (!session.getLogin().equals("") && !session.getPassword().equals("")) {
			Session.sessionList.add(session);
			
			System.out.println(session.getLogin() + ", " + session.getPassword());

			System.out.println(Session.sessionList);
			
			HashMap<String, String> data = new HashMap<>();
			data.put("login", session.login);
			data.put("password", session.password);
			
			DbConnection.insert("session", data);

			return "redirect:/klient_panel";
		}

		return "errorPage";
	}
	
	// reset hasła
	
		@GetMapping("/haslo")
		public String toHaslo(Model modelHasla) {
			modelHasla.addAttribute("reset", new Password());
			return "haslo";
		}

		@PostMapping("/haslo")
		public String getHaslo(@ModelAttribute Password password) {

			if (!password.getMail().equals("")) {
				Password.passwordList.add(password);
				
				System.out.println(password.getMail());

				System.out.println(Password.passwordList);
				
				HashMap<String, String> data = new HashMap<>();
				data.put("mail", password.mail);
				
				DbConnection.insert("password", data);

				return "redirect:/zaloguj";
			}

			return "errorPage";
		}
	
		// zamówienie 
		
		@GetMapping("/klient_zamowienie")
		public String toZamowienie(Model modelZamowienia) {
			modelZamowienia.addAttribute("order", new Cart());
			return "klient_zamowienie";
		}

		@PostMapping("/klient_zamowienie")
		public String getZamowienie(@ModelAttribute Cart cart) {

			if (!cart.getName().equals("") && !cart.getDuration().equals("") && !cart.getMessage().equals("")) {
				Cart.cartList.add(cart);
				
				System.out.println(cart.getName() + ", " + cart.getDuration() + ", " + cart.getMessage());

				System.out.println(Cart.cartList);
				
				HashMap<String, String> data = new HashMap<>();
				data.put("name", cart.name);
				data.put("duration", cart.duration);
				data.put("message", cart.message);
				
				DbConnection.insert("cart", data);

				return "redirect:/klient_historia";
			}

			return "errorPage";
		}
		
		// sesja logowania pracownika
		
		@GetMapping("/zaloguj_pracownik")
		public String toZalogujPracownika(Model modelSesjiPracownika) {
			modelSesjiPracownika.addAttribute("employeelog", new EmployeeSession());
			return "zaloguj_pracownik";
		}

		@PostMapping("/zaloguj_pracownik")
		public String getZalogujPracownika(@ModelAttribute EmployeeSession employeeSession) {

			if (!employeeSession.getLogin().equals("") && !employeeSession.getPassword().equals("")) {
				EmployeeSession.employeeSessionList.add(employeeSession);
				
				System.out.println(employeeSession.getLogin() + ", " + employeeSession.getPassword());

				System.out.println(EmployeeSession.employeeSessionList);
				
				HashMap<String, String> data = new HashMap<>();
				data.put("login", employeeSession.login);
				data.put("password", employeeSession.password);
				
				DbConnection.insert("employeeSession", data);

				return "redirect:/pracownik_panel";
			}

			return "errorPage";
		}
		
}
