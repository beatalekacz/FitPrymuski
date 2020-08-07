package com.FitPrymuski.FP.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FitPrymuski.FP.data.Customer;

@Controller
public class HomeController {
	
	// main panel

	@GetMapping("/home")
	public String stronaDomowa() {
		return "index";
	}	
		
	@GetMapping("/index")
	public String stronaGlowna() {
		return "index";
	}
	
	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}
	
	@GetMapping("/programy")
	public String programy() {
		return "programy";
	}
	
	@GetMapping("/dlaczegomy")
	public String dlaczegomy() {
		return "dlaczegomy";
	}
	
	@GetMapping("/dowoz")
	public String dowoz() {
		return "dowoz";
	}
	
	@GetMapping("/eventy")
	public String organizacjaeventow() {
		return "eventy";
	}
	
}