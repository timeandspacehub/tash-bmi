package com.timeandspacehub.service;

import org.springframework.stereotype.Service;

@Service
public class BMIService {

	public double getMetrics(double kilogramInput, double meterInput) {
		return kilogramInput / (meterInput * meterInput);
	}

	public String getCategory(double bmi) {
		if (bmi < 18.5)
			return "Underweight";
		if (bmi < 24.9)
			return "Normal weight";
		if (bmi < 29.9)
			return "Overweight";
		return "Obese";
	}
}
