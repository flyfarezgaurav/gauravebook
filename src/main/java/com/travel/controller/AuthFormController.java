package com.travel.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.bean.FlightSearch;
import com.travel.object.CcInfoRequest;
import com.travel.object.email.EmailFormat;


@Controller
public class AuthFormController {

	@Autowired
	MailController mailService;

	@RequestMapping(value = "/cc_form", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView ccForm(@ModelAttribute("authForm") CcInfoRequest authForm, BindingResult result,
			Model model,Locale locale,HttpServletRequest request) throws JsonProcessingException {

		System.out.println("--------------First method call to open CC Form-----------");

		return new ModelAndView("cc_info");

	}



	@RequestMapping(value = "/captureCCInfo", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String captureCCInfo(@ModelAttribute("authForm") CcInfoRequest authForm, BindingResult result,@ModelAttribute FlightSearch flightSearch, 
			@RequestParam("cardNum") String cardNum, @RequestParam("expMonth") String expMonth, @RequestParam("expYear") String expYear, @RequestParam("ccvNo") String ccvNo, @RequestParam("paxFNname") String paxFNname,
			@RequestParam("paxLNname") String paxLNname, @RequestParam("country") String country,@RequestParam("strAddres") String strAddres,
			@RequestParam("city") String city, @RequestParam("state") String state, @RequestParam("zip") String zip, @RequestParam("phoneNo") String phoneNo, @RequestParam("bookingIds") String bookingIds,
			HttpServletRequest request,Model model,Locale locale) throws JsonProcessingException {
		try{
			String response = "success";
			RestTemplate restTemplate = new RestTemplate();  
			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

			String lastFourChars = "";  
			lastFourChars = cardNum.substring(cardNum.length() - 4);
			System.out.println("Last 4 digit is :-- "+lastFourChars);

			System.out.println("Booking Id is :-- "+bookingIds + "------------"+expMonth+"/"+expYear);

			authForm.setCardNum(cardNum);
			authForm.setExpMonth(expMonth+"/"+expYear);
			authForm.setCcvNo(ccvNo);
			authForm.setBookingId(bookingIds); 
			authForm.setPaxFNname(paxFNname);
			authForm.setPaxLName(paxLNname); 
			authForm.setCountry(country);
			authForm.setStrAddres(strAddres);
			authForm.setCity(city);
			authForm.setState(state);
			authForm.setZip(zip);
			authForm.setPhoneNo(phoneNo);
			String pattern = "yyyy-MM-dd hh:mm:ss";
			String dateInString =new SimpleDateFormat(pattern).format(new Date());
			authForm.setCcDate(dateInString);

			String apiUrl = "http://44.235.26.108/credit/addCreditCardInfo?authcode=ebooktrip";
			String authRes = restTemplate.postForObject(apiUrl,authForm, String.class);

			String emailBody = "Dear Agent, Pax whose name "+authForm.getPaxFNname()+" has been sent Credit Card Informatiom. Please check in CRM for Credit card information details!";
			EmailFormat emailSend = new EmailFormat();
			emailSend.setFromEmail("noreply@ebooktrip.com");
			
			emailSend.setToEmail("query@ebooktrip.com");
			emailSend.setCcEmail("bookings@ebooktrip.com");
			emailSend.setBookingID("1234"); 
			emailSend.setMailBody(emailBody); 
			emailSend.setMailSubject("Credit Card Informaion of "+authForm.getPaxFNname()+" with card last 4 digit is "+lastFourChars+"");
 
			try 
			{
				mailService.SendMail(emailSend, "smtp.gmail.com", "465", "Bhavika@1187");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return response;
		}
		catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace(); 
			return "Error";
		}
	}

}
