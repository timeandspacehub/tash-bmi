package com.timeandspacehub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BMIController {

	@GetMapping("/bmi")
	public String hello() {
		return "Welcome to BMI APP!";
	}
	
	@GetMapping("/bmi/USCS")
	public String CalculateBMI(@RequestParam int feet,
						@RequestParam int inches,
						@RequestParam double weightinPounds) {
		int totalInches = (feet * 12) + inches;
		double heightInMeters = totalInches * 0.0254;
		double weightInKg = weightinPounds *  0.453592;
		double bmi = weightInKg / (heightInMeters * heightInMeters);
		
		String category;
		if(bmi< 18.5) {
			category = "Underweight";
		} else if (bmi < 24.9) {
			category = "NormalWeight";
		} else if (bmi< 29.9) {
			category = "OverWeight";
		} else {
			category = "Obese";
		}
		
		return String.format("Your BMI is %.2f - %s", bmi, category);
		
	}


}
