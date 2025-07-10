package com.timeandspacehub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BMIController {

	@GetMapping("/bmi")
	public String hello() {
		return "Welcome to BMI APP!";
	}

}
