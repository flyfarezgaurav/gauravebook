package com.travel.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.bean.FlightSearch;
import com.travel.object.searchRequest.FlightRequest;
import com.travel.object.searchRequest.Segment;
import com.travel.service.RestDataService;
import com.travel.utility.Utility;

import eu.bitwalker.useragentutils.UserAgent;

@Controller
public class MetaController {

	@Autowired
	RestDataService restService;

	@Value("${siteName}")
	private String siteName;
	@Value("${siteId}")
	private int siteId;
	@Value("${currency}")
	private String currency;


	@GetMapping("/rest/search/flights/")
	public String getMetaResult(HttpServletRequest request,@ModelAttribute final FlightSearch flightSearch,Model model){
		String froCity = request.getParameter("from");
		String toCity = request.getParameter("to");
		String departDate = request.getParameter("date1");
		String returnDate = "";
		try{
			returnDate = request.getParameter("date2");
		}
		catch(Exception e){
			returnDate = "";
		}
		String adults = request.getParameter("adults");
		String children = request.getParameter("children");
		String infants = request.getParameter("infants");
		String infantsws = request.getParameter("infantsws");
		String cabin = request.getParameter("cabin");
		String partner = request.getParameter("partner");
		//		String password = request.getParameter("password");

		System.out.println("Partner is :--- "+partner);
		FlightRequest flightReq = new FlightRequest();
		flightReq.setTripType(1);
		flightSearch.setTripType("1");
		List<Segment> segment = new ArrayList<Segment>();

		Segment seg1 = new Segment();
		seg1.setDestinationAirport(toCity);
		seg1.setOriginAirport(froCity);
		seg1.setTravelDate(departDate);
		segment.add(seg1);
		if(returnDate != null && returnDate != ""){
			Segment seg2 = new Segment();
			seg2.setDestinationAirport(froCity);
			seg2.setOriginAirport(toCity);
			seg2.setTravelDate(returnDate);
			segment.add(seg2);
			flightReq.setTripType(2);
			flightSearch.setTripType("2");

		}
		String searchID = froCity+"-"+toCity+"-"+departDate.replaceAll("/", "-")+"-"+new Date().getTime();
		flightReq.setSegment(segment);
		flightReq.setAdults(Integer.parseInt(adults));
		flightReq.setCabinType(Integer.parseInt(cabin));
		flightReq.setChild(Integer.parseInt(children)); 
		flightReq.setClient(Integer.valueOf(this.siteId));
		flightReq.setCurrencyCode("USD");

		flightReq.setInfants(Integer.parseInt(infants));
		flightReq.setSearchID(searchID);
		flightReq.setInfantsWs(Integer.parseInt(infantsws));
		flightReq.setAirline("All");
		String userBrowserDetails = "userBrowserDetails";
		String device = "";
		try {
			final UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
			userBrowserDetails = userAgent.getOperatingSystem() + "-" + userAgent.getBrowser() + "-" + userAgent.getBrowserVersion();
			device = userAgent.getOperatingSystem().getDeviceType().getName();
		}
		catch (Exception e1) {
			userBrowserDetails = request.getHeader("user-agent");
		}
		flightReq.setBrowser(userBrowserDetails);
		flightReq.setDevice(device);
		flightReq.setFlexibleSearch(Boolean.valueOf(false));
		flightReq.setIsNearBy(Boolean.valueOf(false));
		flightReq.setLimit(Integer.valueOf(100));
		flightReq.setLocale("en");
		flightReq.setMedia(this.siteName);
		flightReq.setRID("");
		flightReq.setSearchDirectFlight(Boolean.valueOf(false));
		flightReq.setServerIP("");
		flightReq.setSID("");
		flightReq.setSiteId(Integer.valueOf(this.siteId));
		flightReq.setSource(partner);
		flightReq.setUserIP(request.getRemoteAddr());

		request.getSession().setAttribute("flightRequest", (Object)flightReq);
		request.getSession().setAttribute("flightSearch", (Object)flightSearch);
		model.addAttribute("airlineList", (Object)Utility.getAirlines());
		try {
			model.addAttribute("searchString", (Object)new ObjectMapper().writeValueAsString((Object)flightSearch).replace("Int'l", "Intl"));
		}
		catch (JsonProcessingException e) {
			e.printStackTrace(); 
		}
		String cabinClass = "";
		if(cabin.equalsIgnoreCase("1")){
			cabinClass = "Economy"; 
		}
		else if(cabin.equalsIgnoreCase("2")){
			cabinClass = "PremiumEconomy";
		}
		else if(cabin.equalsIgnoreCase("3")){
			cabinClass = "Business"; 
		}
		else if(cabin.equalsIgnoreCase("4")){
			cabinClass = "First";
		}
		flightSearch.setAdult(Integer.parseInt(adults));
		flightSearch.setChild(Integer.parseInt(children));
		flightSearch.setCabin(cabinClass);
		flightSearch.setInfant(Integer.parseInt(infants));
		flightSearch.setInfantWs(Integer.parseInt(infantsws));
		flightSearch.setOrigin(restService.getAirportList(froCity).get(0));
		flightSearch.setDestination(restService.getAirportList(toCity).get(0));
		flightSearch.setDepartDate(departDate);
		flightSearch.setReturnDate(returnDate);

		model.addAttribute("partner", partner);
		
		return "result";
	}

}
