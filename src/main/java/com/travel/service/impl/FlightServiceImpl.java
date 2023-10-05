package com.travel.service.impl;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.travel.bean.FlightSearch;
import com.travel.object.bookingrequest.BookingRequest;
import com.travel.object.deal.DealRequest;
import com.travel.object.deal.DealResponse;
import com.travel.object.fareRules.CheckFareRules;
import com.travel.object.flightresponse.OtherBound;
import com.travel.object.searchRequest.FlightRequest;
import com.travel.object.searchRequest.Segment;
import com.travel.object.travelgaurd.TGRequest;
import com.travel.object.travelgaurd.Traveler;
import com.travel.object.travelgaurd.response.TGResponse;
import com.travel.service.FlightService;
import com.travel.service.RestDataService;
import com.travel.utility.Utility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.bitwalker.useragentutils.UserAgent;

@Service
public class FlightServiceImpl implements FlightService{
	
	@Value("${siteName}")
	private String siteName;
	
	@Value("${siteId}")
	private int siteId;
	
	@Value("${currency}")
	private String currency;
	
	@Value("${apiUrl}")
	private String apiUrl;
	
	@Value("${flightAPiUrl}")
	private String flightAPiUrl;
	
	@Value("${password}")
	private String password;
	
	@Value("${flightMetaAPIUrl}")
	private String flightMetaAPIUrl;
	
	@Autowired
	RestDataService restService;
	
	@Override
	public FlightRequest getFlightSearchRequest(FlightSearch flightSearch, HttpServletRequest request, String searchId) {

		FlightRequest flightRequest =new FlightRequest();
		List<Segment> segment = new ArrayList<Segment>();
		Segment departSegment = new Segment();
		if(flightSearch.getOrigin().length() == 3){
			flightSearch.setOrigin(restService.getAirportList(flightSearch.getOrigin()).get(0));
		}
		if(flightSearch.getDestination().length() == 3){
			flightSearch.setDestination(restService.getAirportList(flightSearch.getDestination()).get(0));
		}
		departSegment.setOriginAirport(flightSearch.getOrigin().substring(0, flightSearch.getOrigin().indexOf("-")));
		departSegment.setDestinationAirport(flightSearch.getDestination().substring(0, flightSearch.getDestination().indexOf("-")));
		departSegment.setTravelDate(flightSearch.getDepartDate());
		segment.add(departSegment);
		if(flightSearch.getTripType().equalsIgnoreCase("2")){
			Segment returnSegment = new Segment();
			returnSegment.setOriginAirport(flightSearch.getDestination().substring(0, flightSearch.getDestination().indexOf("-")));
			returnSegment.setDestinationAirport(flightSearch.getOrigin().substring(0, flightSearch.getOrigin().indexOf("-")));
			returnSegment.setTravelDate(flightSearch.getReturnDate());
			segment.add(returnSegment);
		}
		else if(flightSearch.getTripType().equalsIgnoreCase("3")){
			
			Segment segment2 = new Segment();
			segment2.setOriginAirport(flightSearch.getOrigin2().substring(0, flightSearch.getOrigin2().indexOf("-")));
			segment2.setDestinationAirport(flightSearch.getDestination2().substring(0, flightSearch.getDestination2().indexOf("-")));
			segment2.setTravelDate(flightSearch.getDepartDate2());
			segment.add(segment2);
			if(flightSearch.getOrigin3() != null){
				Segment segment3 = new Segment();
				segment3.setOriginAirport(flightSearch.getOrigin3().substring(0, flightSearch.getOrigin3().indexOf("-")));
				segment3.setDestinationAirport(flightSearch.getDestination3().substring(0, flightSearch.getDestination3().indexOf("-")));
				segment3.setTravelDate(flightSearch.getDepartDate3());
				segment.add(segment3);
				//System.out.println("4: " +flightSearch.getOrigin4());
				if(flightSearch.getOrigin4() != null && flightSearch.getOrigin4() != ""){
					Segment segment4 = new Segment();
					segment4.setOriginAirport(flightSearch.getOrigin4().substring(0, flightSearch.getOrigin4().indexOf("-")));
					segment4.setDestinationAirport(flightSearch.getDestination4().substring(0, flightSearch.getDestination4().indexOf("-")));
					segment4.setTravelDate(flightSearch.getDepartDate4());
					segment.add(segment4);
					if(flightSearch.getOrigin5() != null && flightSearch.getOrigin5() != ""){
						Segment segment5 = new Segment();
						segment5.setOriginAirport(flightSearch.getOrigin5().substring(0, flightSearch.getOrigin5().indexOf("-")));
						segment5.setDestinationAirport(flightSearch.getDestination5().substring(0, flightSearch.getDestination5().indexOf("-")));
						segment5.setTravelDate(flightSearch.getDepartDate5());
						segment.add(segment5);
						if(flightSearch.getOrigin6() != null && flightSearch.getOrigin6() != ""){
							Segment segment6 = new Segment();
							segment6.setOriginAirport(flightSearch.getOrigin6().substring(0, flightSearch.getOrigin6().indexOf("-")));
							segment6.setDestinationAirport(flightSearch.getDestination6().substring(0, flightSearch.getDestination6().indexOf("-")));
							segment6.setTravelDate(flightSearch.getDepartDate6());
							segment.add(segment6);
						}
					}
				}
			}
		}
		
		flightRequest.setClient(siteId);
		flightRequest.setAdults(flightSearch.getAdult());
		flightRequest.setAirline("All");
		String userBrowserDetails="userBrowserDetails";
		String device = "";
		try 
		{
			UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
			userBrowserDetails=userAgent.getOperatingSystem()+"-"+userAgent.getBrowser()+"-"+userAgent.getBrowserVersion();
			device = userAgent.getOperatingSystem().getDeviceType().getName();
		} catch (Exception e1) {
			userBrowserDetails = request.getHeader("user-agent");
		}
		
		flightRequest.setBrowser(userBrowserDetails);
		flightRequest.setCabinType(Utility.getCabinId(flightSearch.getCabin()));
		flightRequest.setChild(flightSearch.getChild());
		flightRequest.setCurrencyCode(currency);
		flightRequest.setDevice(device);
		flightRequest.setFlexibleSearch(false);
		flightRequest.setInfants(flightSearch.getInfant());
		flightRequest.setInfantsWs(flightSearch.getInfantWs());
		flightRequest.setIsNearBy(false);
		flightRequest.setLimit(200);
		flightRequest.setLocale("en");
		flightRequest.setMedia(siteName);
		flightRequest.setRID("");
		flightRequest.setSearchDirectFlight(flightSearch.isDirectFlight());
		flightRequest.setSearchID(searchId);
		flightRequest.setSegment(segment);
		flightRequest.setServerIP("");
		flightRequest.setSID("");
		flightRequest.setSiteId(siteId);
		flightRequest.setSource("Online");
		flightRequest.setTripType(Integer.parseInt(flightSearch.getTripType()));
		flightRequest.setUserIP(request.getRemoteAddr());
		
		/*try
		{
			System.out.println(" FlightServiceImpl:: FlightSearchRequest :: "+new ObjectMapper().writeValueAsString(flightRequest));
		}
		catch(Exception e){}
		*/
		
		return flightRequest;
	
	}
	
	@Override
	public String getFlightSearchResponse(FlightRequest flightRequest) {
		RestTemplate rest = new RestTemplate();
		String res = rest.postForObject(flightAPiUrl+"/flightSearchs?authcode="+password, flightRequest, String.class);
		System.out.println(" FlightSearchResponse::"+res);
		return res; 
	}
	
	@Override
	public BookingRequest getMetaBookingRequest(BookingRequest bookingRequest) {
		
		RestTemplate rest = new RestTemplate();
		bookingRequest.setSiteID(siteId);
		bookingRequest.setCurrencyCode(currency);
		
		ObjectMapper mapper = new ObjectMapper();
		try
		{
			System.out.println("JetRadar :: BookingRequest:: "+mapper.writeValueAsString(bookingRequest));
		} 
		catch (JsonProcessingException e) {  
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("API URL :: "+flightMetaAPIUrl+"/metaBookingRequest?authcode="+password);
		String res = rest.postForObject(flightMetaAPIUrl+"/metaBookingRequest?authcode="+password, bookingRequest, String.class);
		System.out.println("FlightServiceImpl :: MetaBookingResponse:: "+res);
		
		try 
		{
			//ObjectMapper mapper = new ObjectMapper();
			bookingRequest =	mapper.readValue(res, BookingRequest.class);
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		System.out.println("Currency Code in getMetaBookingRequest FltImp :-- "+bookingRequest.getFlightResult().getCurrencyCode());
		bookingRequest.setCurrencySymbol(bookingRequest.getFlightResult().getCurrencyCode());
		if(bookingRequest.getFlightResult().getCurrencyCode().equalsIgnoreCase("USD")){
			bookingRequest.setCurrencySymbol("$");	
		}
		bookingRequest.setCurrencyValue(1);
		return bookingRequest;
		
	}
	
	@Override
	public FlightRequest getFlightDeepSearchRequest(HttpServletRequest request,String type, String origin, String destination,String origin1, String destination1, List<List<OtherBound>> otherBounds, int adults, int children, int infants, int infantws, String departure, String retu, String cabin, String utm_source, String utm_medium) {

		System.out.println("FlightServiceImpl :: getFlightDeepSearchRequest Caling.....");
		
		FlightRequest flightRequest =new FlightRequest();
		List<Segment> segment = new ArrayList<Segment>();
		Segment departSegment = new Segment();
		
		departSegment.setOriginAirport(origin);
		departSegment.setDestinationAirport(destination);
		departSegment.setTravelDate(departure);
		segment.add(departSegment);
		
		if(type.equalsIgnoreCase("RT") || type.equalsIgnoreCase("RoundTrip") || type.equalsIgnoreCase("OpenJaw") || type.equalsIgnoreCase("MultiCity")){
			Segment returnSegment = new Segment();
			returnSegment.setOriginAirport(origin1);
			returnSegment.setDestinationAirport(destination1);
			returnSegment.setTravelDate(retu);
			segment.add(returnSegment);
		}
		
		if(type.equalsIgnoreCase("MultiCity")){
		for (int i = 0; i < otherBounds.size(); i++) {
			String originMc="";
			String destinationMc="";
			String departureDate="";
			for (int j = 0; j < otherBounds.get(i).size(); j++) {
				if(j==0){
					originMc=otherBounds.get(i).get(j).getFromAirport();
					departureDate=otherBounds.get(i).get(j).getDepDate();
					//System.out.println("departureDate11111>>"+departureDate);
				}
				destinationMc=otherBounds.get(i).get(j).getToAirport();
			}
			Segment returnSegment = new Segment();
			returnSegment.setOriginAirport(originMc);
			returnSegment.setDestinationAirport(destinationMc);
		//	System.out.println("departureDate22222>>"+departureDate);
			returnSegment.setTravelDate(Utility.googleDateformat(departureDate));
			segment.add(returnSegment);
		}
		}
		
		try
		{
			System.out.println("FlightServiceImpl:: getFlightDeepSearchRequest :: Segment:: "+new ObjectMapper().writeValueAsString(segment));
		}
		catch(Exception e){}
		
		
		flightRequest.setClient(siteId);
		flightRequest.setAdults(adults);
		flightRequest.setAirline("All");
		String userBrowserDetails="userBrowserDetails";
		String device = "";
		try 
		{
			UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
			userBrowserDetails=userAgent.getOperatingSystem()+"-"+userAgent.getBrowser()+"-"+userAgent.getBrowserVersion();
			device = userAgent.getOperatingSystem().getDeviceType().getName();
		} catch (Exception e1) {
			userBrowserDetails = request.getHeader("user-agent");
		}
		
		flightRequest.setBrowser(userBrowserDetails);
		flightRequest.setCabinType(Utility.getCabinId(cabin));
		flightRequest.setChild(children);
		flightRequest.setCurrencyCode(currency);
		flightRequest.setDevice(device);
		flightRequest.setFlexibleSearch(false);
		flightRequest.setInfants(infants);
		flightRequest.setInfantsWs(infantws);
		flightRequest.setIsNearBy(false);
		flightRequest.setLimit(200);
		flightRequest.setLocale("en");
		flightRequest.setMedia("Google");
		flightRequest.setRID("");
		flightRequest.setSearchDirectFlight(false);
		flightRequest.setSearchID(Utility.getAlphaNumericString(16));
		flightRequest.setSegment(segment);
		flightRequest.setServerIP("");
		flightRequest.setSID("");
		flightRequest.setSiteId(siteId);
		flightRequest.setSource(utm_source);
		flightRequest.setMedia(utm_medium);
		flightRequest.setTripType(1);
		if(type.equalsIgnoreCase("RT")){
			flightRequest.setTripType(2);
		}
		if(type.equalsIgnoreCase("RoundTrip")){
			flightRequest.setTripType(2);
		}
		if(type.equalsIgnoreCase("OpenJaw")){
			flightRequest.setTripType(2);
		}
		if(type.equalsIgnoreCase("MultiCity")){
			flightRequest.setTripType(3);
		}
		flightRequest.setUserIP(request.getRemoteAddr());
		
		
		try
		{
			System.out.println("FlightServiceImpl:: getFlightDeepSearchRequest :: FlightSearchRequest:: "+new ObjectMapper().writeValueAsString(flightRequest));
		}
		catch(Exception e){}
		
		return flightRequest;
	
	}

	@Override
	public String getLiveFlightSearchResponse(BookingRequest bookingRequest) {
		// TODO Auto-generated method stub
		RestTemplate rest = new RestTemplate();
		String res = rest.postForObject(flightAPiUrl+"/customerRequests?authcode="+password, bookingRequest, String.class);
		return res; 
	}

	@Override
	public DealResponse getDealList() {
		RestTemplate rest = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		DealRequest dealRequest = new DealRequest();
		dealRequest.setAirline("");
		dealRequest.setCabinClass("Y");
		dealRequest.setCityName("");
		dealRequest.setCountryCode("US");
		dealRequest.setCountryName("US");
		dealRequest.setCurrency("USD");
		dealRequest.setDepartDate("");
		dealRequest.setFroCity("");
		dealRequest.setPage("");
		dealRequest.setToCity("");
		dealRequest.setTripType("2");
		dealRequest.setSiteId("1");
		System.out.println(apiUrl+"/travelsite/deals?authcode="+password);
		String dealResStr = rest.postForObject(apiUrl+"/travelsite/deals?authcode="+password, dealRequest, String.class);
		System.out.println("FlightServiceImpl :: DealResStr:: "+dealResStr);
		DealResponse dealResponse = null;
		try 
		{
			dealResponse =	mapper.readValue(dealResStr, DealResponse.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealResponse;
	}
	
	@Override
	public String getFlightFareRules(CheckFareRules checkFareRules) {
		RestTemplate rest = new RestTemplate();
		String fareRules = rest.postForObject(flightAPiUrl+"/GetFlightFareRule?authcode="+password, checkFareRules, String.class);
		return fareRules;
	}

	@Override
	public String getFlightMetaCheck(CheckFareRules checkFareRules) {
		RestTemplate rest = new RestTemplate();
		String fareRules = rest.postForObject(flightAPiUrl+"/GetFlightMetaCheck?authcode="+password, checkFareRules, String.class);
		return fareRules;
	}
	
	@Override
	public TGResponse getTravelInsurance(BookingRequest bookingRequest, FlightRequest searchRequest) {
		
		String originAirport = searchRequest.getSegment().get(0).getOriginAirport();
		String destinationAirport = searchRequest.getSegment().get(0).getDestinationAirport();
		String departDate = bookingRequest.getFlightResult().getOutBound().get(0).getDepDate().split("T")[0].toString();
		String returnDate = "";
		int outBoundSize = 0;
		try
		{
			outBoundSize = bookingRequest.getFlightResult().getOutBound().size();
		}catch(Exception e){
			outBoundSize=0;
		}
		int inBoundSize = 0;
		try
		{
			inBoundSize = bookingRequest.getFlightResult().getInBound().size();
		}catch(Exception e){
			inBoundSize=0;
		}
		
		if(inBoundSize==0){
			returnDate = bookingRequest.getFlightResult().getOutBound().get(outBoundSize-1).getReachDate().split("T")[0].toString();
		}
		
		if(inBoundSize>0){
			//returnDate = bookingRequest.getFlightResult().getInBound().get(0).getDepDate().split("T")[0].toString();
			returnDate = bookingRequest.getFlightResult().getInBound().get(inBoundSize-1).getReachDate().split("T")[0].toString();
		}
		
		String dateObj = bookingRequest.getPassengerDetails().get(0).getDobDay().length()>1 ? bookingRequest.getPassengerDetails().get(0).getDobDay():"0"+bookingRequest.getPassengerDetails().get(0).getDobDay();
		String monthObj = bookingRequest.getPassengerDetails().get(0).getDateOfMonth().length()>1 ? bookingRequest.getPassengerDetails().get(0).getDateOfMonth():"0"+bookingRequest.getPassengerDetails().get(0).getDateOfMonth();
		
		String country = bookingRequest.getPaymentDetails().getCountry();
		String state = bookingRequest.getPaymentDetails().getState().replaceAll(",","");
		String dateOfBirth = bookingRequest.getPassengerDetails().get(0).getDateOfYear()+"-"+monthObj+"-"+dateObj;
		String paxType = "";
		if(bookingRequest.getPassengerDetails().get(0).getPassengerType()==1){
			paxType = "Adult";
		}
		if(bookingRequest.getPassengerDetails().get(0).getPassengerType()==2){
			paxType = "Child";
		}
		if(bookingRequest.getPassengerDetails().get(0).getPassengerType()==3){
			paxType = "Inant";
		}
		
		NumberFormat nf= NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		double grandTotal = Double.valueOf(bookingRequest.getFlightResult().getFare().getGrandTotal());
		
		System.out.println("originAirport::"+originAirport);
		System.out.println("destinationAirport::"+destinationAirport);
		System.out.println("departDate::"+departDate);
		System.out.println("returnDate::"+returnDate);
		System.out.println("country::"+country);
		System.out.println("state::"+state);
		System.out.println("dateOfBirth::"+dateOfBirth);
		System.out.println("paxType::"+paxType); 
		System.out.println("grandTotal::"+grandTotal);
		
		TGRequest tgReq = new TGRequest();
		tgReq.setOriginAirport(originAirport);
		tgReq.setDestinationAirport(destinationAirport);
		tgReq.setDeptureDate(departDate);
		tgReq.setReachDate(returnDate);
		tgReq.setCountry(country);
		tgReq.setState(state);
		tgReq.setTotalPrice(grandTotal);
		
		List<Traveler> travelerList = new ArrayList<Traveler>();
		Traveler travelObj = new Traveler();
		travelObj.setPassengerType(paxType);
		travelObj.setBirthDate(dateOfBirth);
		travelerList.add(travelObj);
		tgReq.setTravelers(travelerList);
		
		try 
		{
			System.out.println(" FlightPaymentPageTwo:: TravelInsurance Request :: "+new ObjectMapper().writeValueAsString(tgReq));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String insURL = apiUrl+"/insuranceService/getQuote?authcode="+password; 
		System.out.println("insURL"+insURL); 
		String insRS = "";
		try
		{
			RestTemplate rest = new RestTemplate();
			insRS = rest.postForObject(insURL, tgReq, String.class);
			System.out.println("insRS::"+insRS);
		}
		catch(Exception e){
			System.out.println("TravelInsurance Response Not Comming"); 
		}
		TGResponse tgrsponse = null;
		try 
		{
			tgrsponse =	new ObjectMapper().readValue(insRS, TGResponse.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*double insPrice = 0.00;
		try{
			if(tgrsponse.getBaseResponse().getStatus()==1){
				
				insPrice = 0.00;
			}
			else{
				insPrice = 0.00;
			}
		}catch(Exception e){
			
		}*/
		
		return tgrsponse;
	}
	
}
