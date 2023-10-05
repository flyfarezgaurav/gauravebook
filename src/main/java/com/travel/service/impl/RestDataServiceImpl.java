package com.travel.service.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.object.Location;
import com.travel.object.SubscribeRequest;
import com.travel.object.bookingrequest.BookingRequest;
import com.travel.object.currency.CurrencyRequest;
import com.travel.object.currency.CurrencyResponse;
import com.travel.object.farealert.FareAlertRequest;
import com.travel.service.RestDataService;

@Service
public class RestDataServiceImpl implements RestDataService{

	@Value("${flightAPiUrl}")
	String flightAPiUrl;
	
	@Value("${siteName}")
	private String siteName;
	
	@Value("${siteId}")
	private int siteId;
	
	@Value("${apiUrl}")
	String apiUrl;
	
	@Value("${password}")
	private String password;
	
	RestTemplate rest = new RestTemplate();
	ObjectMapper mapper = new ObjectMapper(); 
	
	@Override
	public List<String> getAirportList(String searchterm) {
		
		String url=flightAPiUrl+"/AirportList?authcode="+password.trim()+"&data="+searchterm;
		//System.out.println("RestDataServiceImpl:: "+url);
		String airporStr = rest.getForObject(url, String.class);
		List<String> airportList = new ArrayList<String>();
		try {
			Location[] locationList =  mapper.readValue(airporStr, Location[].class);
			//System.out.println("RestDataServiceImpl::locationList :: "+locationList.length);
			for (Location location : locationList) 
			{
				if (searchterm.equalsIgnoreCase(location.getAirportCode())) {
					airportList.add(location.getAirportCode()+"-"+location.getCityName()+", "+location.getAirportName()+"-"+location.getCountryCode());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return airportList;
	}
	
	@Override
	public void setNewsletterSubscription(String email) {
		System.out.println("email1111"+email);
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = format.format(d);
		SubscribeRequest reqObj=new SubscribeRequest();
		reqObj.setDate(dateString);
		reqObj.setEmailid(email);
		reqObj.setStatus("active");
		reqObj.setSiteId(siteId);
		reqObj.setUrl(siteName);
		
		String response = rest.postForObject(apiUrl+"/backend/subscribe?authcode=ebooktrip",reqObj,String.class);
		System.out.println("subscribe response"+response);
	}

	@Override
	public void setFareAlert(FareAlertRequest farealAlertRequest) {
	String res = 	rest.postForObject(apiUrl+"/fare-alert/addFareAlert?authcode=ebooktrip", farealAlertRequest, String.class);
	System.out.println(res);
		
	}
	
	@Override
	public String getCurrencyResponse(HttpServletRequest request,String country) {
		String currRes = rest.postForObject("http://44.224.170.152/currency/getAllCurrency?authcode=ebooktrip",new CurrencyRequest(), String.class);
		System.out.println("currRes >>> " + currRes);
		CurrencyResponse currencyResponse = new CurrencyResponse();
		try {
			currencyResponse = mapper.readValue(currRes, CurrencyResponse.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String currencySymbol = "$";
		String currencyValue = "1";
		if(country.equalsIgnoreCase("GB") || country.equalsIgnoreCase("GBP")){
			currencySymbol = "GBP";
			currencyValue = currencyResponse.getResponse().get(0).getUsdGbp();
		}
		else if(country.equalsIgnoreCase("CA") || country.equalsIgnoreCase("CAD")){
			currencySymbol = "CAD";
			currencyValue = currencyResponse.getResponse().get(0).getUsdCad();
		}
		else if(country.equalsIgnoreCase("MX") || country.equalsIgnoreCase("MXD")){
			currencySymbol = "MXN";
			currencyValue = currencyResponse.getResponse().get(0).getUsdMxn();
		}
		request.getSession().setAttribute("currencySymbol", currencySymbol);
		request.getSession().setAttribute("currencyValue", Double.valueOf(currencyValue));
		return currRes;
	}

	@Override
	public String getCurrencyResponseMeta(HttpServletRequest request, String country, BookingRequest bookingRequest) {
		String currRes = rest.postForObject("http://44.224.170.152/currency/getAllCurrency?authcode=ebooktrip",new CurrencyRequest(), String.class);
		System.out.println("currRes >>> " + currRes);
		CurrencyResponse currencyResponse = new CurrencyResponse();
		try {
			currencyResponse = mapper.readValue(currRes, CurrencyResponse.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String currencySymbol = "$";
		String currencyValue = "1";
		if(country.equalsIgnoreCase("GBP") || country.equalsIgnoreCase("GBP")){
			currencySymbol = "GBP";
			currencyValue = currencyResponse.getResponse().get(0).getUsdGbp();
			bookingRequest.setCurrencySymbol(currencySymbol);
			bookingRequest.setCurrencyValue(Double.valueOf(currencyValue));
		}
		else if(country.equalsIgnoreCase("CAD") || country.equalsIgnoreCase("CAD")){
			currencySymbol = "CAD";
			currencyValue = currencyResponse.getResponse().get(0).getUsdCad();
			bookingRequest.setCurrencySymbol(currencySymbol);
			bookingRequest.setCurrencyValue(Double.valueOf(currencyValue));
		}
		else if(country.equalsIgnoreCase("MXD") || country.equalsIgnoreCase("MXN")){
			currencySymbol = "MXN";
			currencyValue = currencyResponse.getResponse().get(0).getUsdMxn();
			bookingRequest.setCurrencySymbol(currencySymbol);
			bookingRequest.setCurrencyValue(Double.valueOf(currencyValue));
		}
		request.getSession().setAttribute("currencySymbol", currencySymbol);
		request.getSession().setAttribute("currencyValue", Double.valueOf(1));
		return currRes;
	}

}
