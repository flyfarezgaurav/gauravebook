package com.travel.controller;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
 
import com.travel.bean.FlightSearch;
import com.travel.object.CallQueryRequest;
import com.travel.object.email.EmailFormat;
import com.travel.utility.PopupEmail; 

@Controller
public class PopupController {

	@Value("${apiUrl}")
	private String apiUrl;

	@Value("${siteName}")
	private String siteName;

	@Value("${siteId}")
	private int siteId;

	@Autowired
	MailController mailService;


	@RequestMapping(value = "/faAlertRes", method = RequestMethod.POST)
	public @ResponseBody String fareAlertRes(@ModelAttribute FlightSearch flightSearch, @RequestParam("email") String email,@RequestParam("paxName") String paxName, @RequestParam("paxPhone") String paxPhone, @RequestParam("froCity") String froCity,
			@RequestParam("toCity") String toCity, @RequestParam("froDatePop") String froDatePop,@RequestParam("toDatePop") String toDatePop,
			@RequestParam("tripType") String tripType, @RequestParam("popOfferPrice") String popOfferPrice, @RequestParam("noOfPax") String noOfPax, 
			HttpServletRequest request,Model model) 
	{
		String response = "success";
		try{  
			System.out.println("Pax Name :-- "+paxName);
			System.out.println("No Of Pax :-- "+noOfPax);
			System.out.println("Pax phone :-- "+paxPhone); 
			System.out.println("popup email is -- "+email+"-------"+froCity+"--------"+toCity+"-------"+froDatePop+"--------"+toDatePop+"-----------"+tripType+"------------"+popOfferPrice);
			//if(SMTPMXLookup.isAddressValid(email)){
			//froCity = froCity.replaceAll("\\p{P}",""); 
			//	System.out.println("Fro City is :-- "+froCity);

			//	toCity = toCity.replaceAll("\\p{P}","");
			//	System.out.println("To City is :-- "+toCity);

			RestTemplate restTemplate = new RestTemplate(); 

			CallQueryRequest object = new CallQueryRequest(); 

			object.setFromCity(froCity);
			object.setToCity(toCity);
			object.setDepDate(froDatePop+ " 00:00:00");
			if(tripType.equalsIgnoreCase("roundTrip")){
				object.setRetDate(toDatePop+ " 23:59:59");
			}else{
				object.setRetDate(froDatePop+ " 23:59:59");
			}
			object.setTripType(tripType);
			object.setCabinClass(popOfferPrice);
			object.setNoPax(Integer.valueOf(noOfPax));
			object.setSourceMedia("ON/SK/FC");
			object.setPaxName(paxName);
			object.setPaxEmail(email);
			object.setPhnNo(paxPhone);
			object.setSiteId(1);
			object.setQueryStatus("Enquiry"); 
			object.setAssignTo("All");
			//object.setModifyDate(utility.convertStringToTimestamp(utility.getcurrentDate(),"MM/dd/yyyy hh:mm:ss"));
			String apiUrl = "http://44.235.26.108/calls/addQuerys?authcode=ebooktrip";
			String popRes = restTemplate.postForObject(apiUrl, object, String.class);

			System.out.println("popRes---"+popRes);
			

			PopupEmail email1 = new PopupEmail();
			String emailBody = email1.PopupEmail(froCity, toCity, froDatePop, toDatePop, tripType, email, paxName, paxPhone, popOfferPrice, noOfPax);
			EmailFormat emailSend = new EmailFormat();
			emailSend.setFromEmail("noreply@ebooktrip.com");
			//emailSend.setToEmail("ravikashgupta@gmail.com");
			//emailSend.setCcEmail("bookings@ebooktrip.com");
			emailSend.setToEmail("query@ebooktrip.com");
			emailSend.setCcEmail("bookings@ebooktrip.com");
			emailSend.setBookingID("1234");
			emailSend.setMailBody(emailBody); 
			emailSend.setMailSubject("Booking Query From Ebooktrip.com : "+paxName+" Whose Phn Number is "+paxPhone+"");

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
			model.addAttribute("flightSearch", flightSearch);
			return response;

		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			return "Error";
		}
	}



}
