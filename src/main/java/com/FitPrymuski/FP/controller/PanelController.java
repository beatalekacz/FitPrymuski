package com.FitPrymuski.FP.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.FitPrymuski.FP.data.Customer;
import com.FitPrymuski.FP.data.Data;
import com.FitPrymuski.FP.data.Diet;
import com.FitPrymuski.FP.data.Dish;
import com.FitPrymuski.FP.data.EmployeeSession;
import com.FitPrymuski.FP.data.Message;
import com.FitPrymuski.FP.data.Cart;
import com.FitPrymuski.FP.data.Password;
import com.FitPrymuski.FP.data.Session;

@Controller
public class PanelController {

	// obsługuje mapowanie części PANEL KLIENT i PANEL ADMIN

	@GetMapping("/klienci")
	public String getKlienci(Model modelKlienta) {
		modelKlienta.addAttribute("customerList", Customer.customerList);
		return "klienci";
	}

	@GetMapping("/danie_lista")
	public String getDanieLista(Model modelDania) {
		modelDania.addAttribute("dishList", Dish.dishList);
		return "danie_lista";
	}

	@GetMapping("dieta_lista")
	public String getDietaLista(Model modelDiety) {
		modelDiety.addAttribute("dietList", Diet.dietList);
		return "dieta_lista";
	}

	@GetMapping("pracownik_zmianadanych")
	public String getZmianaDanych(Model modelZmiany) {
		modelZmiany.addAttribute("dataList", Data.dataList);
		return "pracownik_zmianadanych";
	}

	@GetMapping("pracownik_kontakt")
	public String getWiadomosc(Model modelWiadomosci) {
		modelWiadomosci.addAttribute("messageList", Message.messageList);
		return "pracownik_kontakt";
	}

	@GetMapping("klient_panel")
	public String getLogowanie(Model modelSesji) {
		modelSesji.addAttribute("sessionList", Session.sessionList);
		return "klient_panel";
	}

	@GetMapping("pracownik_haslo")
	public String getResetHasla(Model modelHasla) {
		modelHasla.addAttribute("passwordList", Password.passwordList);
		return "pracownik_haslo";
	}

	@GetMapping("klient_historia")
	public String getKoszyk(Model modelZamowienia) {
		modelZamowienia.addAttribute("cartList", Cart.cartList);
		return "klient_historia";
	}

	@GetMapping("pracownik_zamowienia")
	public String getHistoria(Model modelZamowienia) {
		modelZamowienia.addAttribute("cartList", Cart.cartList);
		return "pracownik_zamowienia";
	}

	@GetMapping("pracownik_panel")
	public String getLogowaniePracownika(Model modelSesjiPracownika) {
		modelSesjiPracownika.addAttribute("employeeSessionList", EmployeeSession.employeeSessionList);
		return "pracownik_panel";
	}

}
