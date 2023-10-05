package com.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OtherURLController
{
	@GetMapping("/travel-protection")
	public String travelProtection(){
		return "travel-protection";	
	}
	
	@GetMapping("/price-drop-protection")
	public String priceDroplProtection(){
		return "price-drop-protection";	
	}
	
	@GetMapping("/travel-assist")
	public String travelAssist(){
		return "travel-assist";	
	}
}
