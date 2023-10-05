package com.travel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.travel.object.bookingrequest.BookingRequest;
import com.travel.object.farealert.FareAlertRequest;
import com.travel.object.flightresponse.FlightResponse;
import com.travel.object.liveresult.LiveResultResponse;
import com.travel.object.searchRequest.FlightRequest;
import com.travel.service.FlightService;
import com.travel.service.RestDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class RestDataController {
 
	@Autowired
	private RestDataService restService;
	
	@Autowired
	private FlightService flightService;
	
	  @GetMapping("/getAirprotList/{searchterm}")
	public List<String> GetAirprotList(@PathVariable String searchterm){
		return restService.getAirportList(searchterm);
		
	}
	  @GetMapping("/getLiveFlightResponse/{searchId}/{resultId}")
		public String liveResult(@PathVariable String searchId,@PathVariable String resultId,HttpServletRequest request){
			BookingRequest bookingRequest=new BookingRequest();
		//	System.out.println("searchId:"+searchId);
		//	System.out.println("resultId:"+resultId);
		bookingRequest.setBookingID(resultId);
		bookingRequest.setSearchID(searchId);
		bookingRequest.setSourceMedia("flight");
		String bookingRes=flightService.getLiveFlightSearchResponse(bookingRequest);
		//System.out.println("BookingRequest response again : " + bookingRes);
		ObjectMapper mapper = new ObjectMapper();
		LiveResultResponse liveResponse = new LiveResultResponse();
		try{
			liveResponse = mapper.readValue(bookingRes, LiveResultResponse.class);
		}
		catch(Exception e){
		e.printStackTrace();
		}
		request.getSession().setAttribute("liveResponse", liveResponse);
		request.getSession().setAttribute("bookingRequest", bookingRequest); 
		request.getSession().setAttribute("bookingRes", bookingRes);
		return bookingRes;
		}
	  
	  @GetMapping("/getFlightResponse")
	  public String flightResponse(HttpServletRequest request) throws JsonProcessingException{
		  FlightRequest flightRequest = (FlightRequest) request.getSession().getAttribute("flightRequest");
		  String res = flightService.getFlightSearchResponse(flightRequest);
		  //System.out.println("res : " + res);
		  ObjectMapper mapper  = new ObjectMapper();
		  try {
			request.getSession().setAttribute("sessionFlightResponse", mapper.readValue(res, FlightResponse.class));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//  System.out.println(res);
		return res;
		  
	  }
	  
	  @PostMapping("/newslettersubmit/{emailId}")
	  public void newsletter(@PathVariable String emailId){
		  System.out.println(emailId);
		  restService.setNewsletterSubscription(emailId);
	  }
	  
	  @PostMapping("/farealert/submit")
	  public String farealertsubmit(@RequestBody FareAlertRequest fareAlertRequest){
		  restService.setFareAlert(fareAlertRequest);
		return null;
		  
	  }
	  
	  @GetMapping("/getCurrencyResponse/{destCountry}")
	  public String getCurrencyResponse(HttpServletRequest request,@PathVariable String destCountry){
		return restService.getCurrencyResponse(request,destCountry);
		  
	  }
 }
