package com.travel.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.travel.object.bookingrequest.BookingRequest;

@Controller
@SessionAttributes({"bookingWrapper"})
public class PaymentController
{	
	@RequestMapping(value="/addUpgrade", method=RequestMethod.GET)
	public @ResponseBody String addUpgrade(@ModelAttribute("bookingWrapper") BookingRequest bookingRequest, Model model, HttpServletRequest request){
		System.out.println("addUpgrade Calling....."); 
		String amt = request.getParameter("amount");
		System.out.println("amt"+amt); 
		bookingRequest.setUpgradeTaken("Yes");
		bookingRequest.setUpgradeAmount(Double.valueOf(amt));
		model.addAttribute("bookingWrapper", bookingRequest);
		return "";
	}
	
}
