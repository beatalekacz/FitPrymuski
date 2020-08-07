package com.FitPrymuski.FP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FPApplication {

	public static void main(String[] args) {
		SpringApplication.run(FPApplication.class, args);
		DbConnection.initialize();
}
}