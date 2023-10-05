package com.travel.controller;

import java.io.IOException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.bean.FlightSearch;
import com.travel.object.bookingrequest.AncillaryService;
import com.travel.object.bookingrequest.BookingRequest;
import com.travel.object.bookingrequest.PassengerDetail;
import com.travel.object.fareRules.CheckFareRules;
import com.travel.object.fareRules.FareRules;
import com.travel.object.flightresponse.Airline;
import com.travel.object.flightresponse.Airport;
import com.travel.object.flightresponse.Fare;
import com.travel.object.flightresponse.FlightResult;
import com.travel.object.flightresponse.InBound;
import com.travel.object.flightresponse.OtherBound;
import com.travel.object.flightresponse.OutBound;
import com.travel.object.searchRequest.FlightRequest;
import com.travel.object.searchRequest.Segment;
import com.travel.service.FlightService;
import com.travel.service.RestDataService;
import com.travel.utility.Utility;

import eu.bitwalker.useragentutils.UserAgent;

@Controller
@SessionAttributes({"bookingWrapper"})
public class FlightsMetaController {

	@Autowired
	FlightService flightService;

	@Autowired
	MailController mailService;

	@Autowired
	RestDataService restService;

	@Value("${flightAPiUrl}")
	private String flightAPiUrl;

	@Value("${currency}")
	private String currency;

	@Value("${password}")
	private String password;

	@Value("${siteName}")
	private String siteName;

	@Value("${siteId}")
	private int siteId;

	@GetMapping("/api-google")
	public String googleLink(@ModelAttribute FlightSearch flightSearch,@ModelAttribute BookingRequest bookingRequest,HttpServletRequest request,Model model){


		request.getSession().setAttribute("currencySymbol", "$");
		request.getSession().setAttribute("currencyValue", Double.valueOf(1));
		bookingRequest.setCurrencySymbol("$");
		bookingRequest.setCurrencyValue(Double.valueOf(1));

		System.out.println("<<<<<< FlightsMetaController :: GoogleLink Calling..>>>>>>");

		try
		{
			StringBuffer url=request.getRequestURL();
			String query = request.getQueryString();
			if(StringUtils.hasText(query)){
				url.append('?').append(query);
			}
			System.out.println("FlightsMetaController :: Google Deeplink URL>>>>> "+url.toString());
		}
		catch(Exception e){

		}
		String Adult=request.getParameter("Adult");
		String Child=request.getParameter("Child"); 
		String Infant=request.getParameter("Infant");//Infant
		String InfantLap=request.getParameter("InfantLap");
		String PointOfSaleCountry=request.getParameter("PointOfSaleCountry");
		String UserCurrency=request.getParameter("UserCurrency");
		String grandTotal=request.getParameter("DisplayedPrice"); 
		String DisplayedPriceCurrency=request.getParameter("DisplayedPriceCurrency");
		String UserLanguage=request.getParameter("UserLanguage"); 
		String Refe=request.getParameter("ReferralId");
		String TripType=request.getParameter("TripType"); 
		String Slice1=request.getParameter("Slice1"); 
		bookingRequest.setCurrencyCode(UserCurrency);
		System.out.println("DisplayedPriceCurrency :::>>> " + DisplayedPriceCurrency);
		if(!DisplayedPriceCurrency.equalsIgnoreCase("USD")){
			System.out.println(restService.getCurrencyResponseMeta(request, DisplayedPriceCurrency,bookingRequest));
		}
		System.out.println("getCurrencySymbolkk " + bookingRequest.getCurrencySymbol());
		bookingRequest.setAdults(Integer.parseInt(Adult));
		try {
			bookingRequest.setChild(Integer.parseInt(Child));
		} catch (Exception e3) {
			bookingRequest.setChild(0);
		}
		try {
			bookingRequest.setInfants(Integer.parseInt(InfantLap));
		} catch (Exception e2) {
			bookingRequest.setInfants(0);
		}
		try {
			bookingRequest.setInfantsWs(Integer.parseInt(Infant));
		} catch (NumberFormatException e2) {
			bookingRequest.setInfantsWs(0);
		}
		bookingRequest.setSearchID(Refe);
		bookingRequest.setSiteID(1);
		bookingRequest.setProdID("1");
		bookingRequest.setBookingID("0");
		bookingRequest.setUserSessionID(Slice1);
		bookingRequest.setCurrencyCode(currency);
		bookingRequest.setSourceMedia("Meta");

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
		bookingRequest.setDevice(device);
		bookingRequest.setBrowser(userBrowserDetails);
		List<PassengerDetail> passengerDetails=new ArrayList<PassengerDetail>();
		int travelerNo=0;
		for (int i = 0; i < bookingRequest.getAdults(); i++) {
			PassengerDetail paxDetail=new PassengerDetail();
			paxDetail.setPassengerType(1);
			passengerDetails.add(paxDetail);
			travelerNo++;
		}
		for (int i = 0; i < bookingRequest.getChild(); i++) {
			PassengerDetail paxDetail=new PassengerDetail();
			paxDetail.setPassengerType(2);
			passengerDetails.add(paxDetail);
			travelerNo++;
		}
		for (int i = 0; i < bookingRequest.getInfants(); i++) {
			PassengerDetail paxDetail=new PassengerDetail();
			paxDetail.setPassengerType(3);
			passengerDetails.add(paxDetail);
			travelerNo++;
		}
		for (int i = 0; i < bookingRequest.getInfantsWs(); i++) {
			PassengerDetail paxDetail=new PassengerDetail();
			paxDetail.setPassengerType(4);
			passengerDetails.add(paxDetail);
			travelerNo++;
		}

		bookingRequest.setPassengerDetails(passengerDetails);
		FlightResult selectedflight=new FlightResult();
		String origin1="";
		String destination1="";
		String origin=request.getParameter("Origin1");

		bookingRequest.setDepartDate(Utility.googleDateformat(request.getParameter("DepartureDate1")));
		String cabinId=	request.getParameter("Cabin1"); 
		String destination="";
		List<OutBound> outBound=new ArrayList<OutBound>();
		String outArray[]=Slice1.split(",");
		for (int i = 0; i < outArray.length; i++) {
			String count=outArray[i];
			OutBound outRoute=new OutBound();
			String Cabin1=request.getParameter("Cabin".concat(count)); 
			outRoute.setCabinClass(Utility.getCabinId(Cabin1));
			String Carrier1=request.getParameter("Carrier".concat(count));
			outRoute.setAirline(Carrier1);
			outRoute.setOrgAirline(Carrier1);
			String DepartureDate1=request.getParameter("DepartureDate".concat(count));
			outRoute.setDepDate(DepartureDate1);
			String Origin1=request.getParameter("Origin".concat(count)); 
			outRoute.setFromAirport(Origin1);
			String Destination1=request.getParameter("Destination".concat(count));
			outRoute.setToAirport(Destination1);
			destination=Destination1;
			String BookingCode1=request.getParameter("BookingCode".concat(count)); 
			outRoute.setResDesignCode(BookingCode1);
			String FlightNumber1=request.getParameter("FlightNumber".concat(count));
			outRoute.setFlightNo(FlightNumber1);
			outBound.add(outRoute);

		}

		bookingRequest.setReturnDate("");
		selectedflight.setOutBound(outBound);
		if(TripType.equalsIgnoreCase("RoundTrip") || TripType.equalsIgnoreCase("OpenJaw") || TripType.equalsIgnoreCase("MultiCity")){
			List<InBound> inBound=new ArrayList<InBound>();
			String Slice2=request.getParameter("Slice2"); 
			String inArray[]=Slice2.split(",");
			for (int i = 0; i < inArray.length; i++) {
				String count=inArray[i];
				InBound inRoute=new InBound();
				String Cabin1=request.getParameter("Cabin".concat(count)); 
				inRoute.setCabinClass(Utility.getCabinId(Cabin1));
				String Carrier1=request.getParameter("Carrier".concat(count));
				inRoute.setAirline(Carrier1);
				inRoute.setOrgAirline(Carrier1);
				String DepartureDate1=request.getParameter("DepartureDate".concat(count));
				System.out.println("FlightsMetaController::Slice2:: DepartureDate"+count+" :: "+DepartureDate1);
				inRoute.setDepDate(DepartureDate1);
				String Origin1=request.getParameter("Origin".concat(count)); 
				if(i==0){
					origin1=Origin1;
				}
				inRoute.setFromAirport(Origin1);
				String Destination1=request.getParameter("Destination".concat(count));
				inRoute.setToAirport(Destination1);
				if(i==0){
					bookingRequest.setReturnDate(Utility.googleDateformat(DepartureDate1));//01/11/2022  2022-01-12

				}
				destination1=Destination1;
				String BookingCode1=request.getParameter("BookingCode".concat(count)); 
				inRoute.setResDesignCode(BookingCode1);
				String FlightNumber1=request.getParameter("FlightNumber".concat(count));
				inRoute.setFlightNo(FlightNumber1);
				inBound.add(inRoute);
			}
			selectedflight.setInBound(inBound);
		}

		List<List<OtherBound>> otherBounds=new ArrayList<List<OtherBound>>();

		try
		{
			List<OtherBound> otherBound = new ArrayList<OtherBound>();
			String Slice3=request.getParameter("Slice3"); 
			String inArray[]=Slice3.split(",");
			for (int i = 0; i < inArray.length; i++) {
				String count=inArray[i];
				OtherBound inRoute=new OtherBound();
				String Cabin1=request.getParameter("Cabin".concat(count)); 
				inRoute.setCabinClass(Utility.getCabinId(Cabin1));
				String Carrier1=request.getParameter("Carrier".concat(count));
				inRoute.setAirline(Carrier1);
				inRoute.setOrgAirline(Carrier1);

				String DepartureDate1=request.getParameter("DepartureDate".concat(count));
				System.out.println("FlightsMetaController::Slice3:: DepartureDate"+count+" :: "+DepartureDate1);
				inRoute.setDepDate(DepartureDate1);

				String Origin1=request.getParameter("Origin".concat(count)); 
				inRoute.setFromAirport(Origin1);
				String Destination1=request.getParameter("Destination".concat(count));
				inRoute.setToAirport(Destination1);
				String BookingCode1=request.getParameter("BookingCode".concat(count)); 
				inRoute.setResDesignCode(BookingCode1);
				String FlightNumber1=request.getParameter("FlightNumber".concat(count));
				inRoute.setFlightNo(FlightNumber1);
				otherBound.add(inRoute);
			}
			otherBounds.add(otherBound);

		}catch (Exception e) {
			// TODO: handle exception
		}

		try{
			for (int j = 4; j < 10; j++) {
				List<OtherBound> otherBound = new ArrayList<OtherBound>();
				String Slice3=request.getParameter("Slice"+j); 
				String inArray[]=Slice3.split(",");
				for (int i = 0; i < inArray.length; i++) {
					String count=inArray[i];
					OtherBound inRoute=new OtherBound();
					String Cabin1=request.getParameter("Cabin".concat(count)); 
					inRoute.setCabinClass(Utility.getCabinId(Cabin1));
					String Carrier1=request.getParameter("Carrier".concat(count));
					inRoute.setAirline(Carrier1);
					inRoute.setOrgAirline(Carrier1);
					String DepartureDate1=request.getParameter("DepartureDate".concat(count));

					System.out.println("FlightsMetaController::Slice4::11111:: "+DepartureDate1);

					inRoute.setDepDate(DepartureDate1);
					String Origin1=request.getParameter("Origin".concat(count)); 
					inRoute.setFromAirport(Origin1);
					String Destination1=request.getParameter("Destination".concat(count));
					inRoute.setToAirport(Destination1);
					String BookingCode1=request.getParameter("BookingCode".concat(count)); 
					inRoute.setResDesignCode(BookingCode1);
					String FlightNumber1=request.getParameter("FlightNumber".concat(count));
					inRoute.setFlightNo(FlightNumber1);
					otherBound.add(inRoute);
				}
				otherBounds.add(otherBound);
			}

		}catch (Exception e) {
			// TODO: handle exception
		}

		selectedflight.setOtherBound(otherBounds);
		Fare fare =new Fare();
		fare.setGrandTotal(Double.valueOf(grandTotal));
		fare.setGrandOrgTotal(Double.valueOf(grandTotal));
		fare.setBagFees(0.0);
		fare.setMarkupType("US");
		fare.setMarkupID(1);
		selectedflight.setResultID(1);
		selectedflight.setCabinClass(selectedflight.getOutBound().get(0).getCabinClass());
		selectedflight.setFare(fare);
		selectedflight.setGdsType(2);
		selectedflight.setValCarrier(selectedflight.getOutBound().get(0).getOrgAirline());
		selectedflight.setFareType("RP");
		selectedflight.setAirline(selectedflight.getOutBound().get(0).getOrgAirline());
		selectedflight.setMaxSeat(7);
		bookingRequest.setFlightResult(selectedflight);

		ObjectMapper mapper = new ObjectMapper();
		try 
		{
			System.out.println("FlightsMetaController::GoogleLink:: BookingRequest :: "+mapper.writeValueAsString(bookingRequest));
			/////System.out.println("GoogleLink::SelectedFlight:"+mapper.writeValueAsString(selectedflight));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		FlightRequest flightReq = flightService.getFlightDeepSearchRequest(request,TripType,origin,destination,origin1,destination1, otherBounds, bookingRequest.getAdults(),bookingRequest.getChild(),bookingRequest.getInfants(),bookingRequest.getInfantsWs(),bookingRequest.getDepartDate(),bookingRequest.getReturnDate(),cabinId,"google",Refe);

		request.getSession().setAttribute("flightRequest", flightReq);
		request.getSession().setAttribute("bookingRequest", bookingRequest);
		request.getSession().setAttribute("selectedflight", selectedflight);
		model.addAttribute("searchRequest", flightReq);

		return "midMetaPayment";

	}

	@PostMapping("/deep/link/{searchId}")
	public ModelAndView googlePaymentLink(@PathVariable String searchId,@ModelAttribute FlightSearch flightSearch,@ModelAttribute BookingRequest bookingRequest,HttpServletRequest request,Model model){

		System.out.println("<<<<<<<<<<< FlightsMetaController::GooglePaymentLink Calling..>>>>>>>>>>>>>");


		System.out.println("Here currency Code is :-- "+bookingRequest.getCurrencyCode());

		FlightResult selectedflight=(FlightResult) request.getSession().getAttribute("selectedflight");
		FlightRequest flightReq = (FlightRequest) request.getSession().getAttribute("flightRequest");
		bookingRequest = (BookingRequest) request.getSession().getAttribute("bookingRequest");
		ObjectMapper mapper = new ObjectMapper();
		CheckFareRules checkRules = new CheckFareRules();
		checkRules.setFlightResult(selectedflight);
		checkRules.setAdults(bookingRequest.getAdults());
		checkRules.setChild(bookingRequest.getChild());
		checkRules.setInfants(bookingRequest.getInfants());
		checkRules.setInfantsWs(bookingRequest.getInfantsWs());
		checkRules.setSiteID(bookingRequest.getSiteID());
		checkRules.setCurrencyCode(bookingRequest.getCurrencyCode());

		try
		{
			System.out.println("FlightsMetaController::CheckFareRules RQ:"+mapper.writeValueAsString(checkRules));
		} catch (IOException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}

		String fareRules= flightService.getFlightMetaCheck(checkRules);
		System.out.println("FlightsMetaController::CheckFareRules-RS:"+fareRules);

		FareRules fareRulesObj=null;
		try 
		{
			fareRulesObj =	mapper.readValue(fareRules, FareRules.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String anclrStr = "";
		bookingRequest.setCurrencyCode(fareRulesObj.getCurrencyCode());
		bookingRequest.setCurrencyValue(1);
		bookingRequest.setCurrencySymbol(fareRulesObj.getCurrencyCode());
		try
		{
			anclrStr = mapper.writeValueAsString(fareRulesObj.getAncillaryServices());
		}catch(Exception e){}

		System.out.println("FlightPaymentPageOne:: anclrStr"+anclrStr);

		List<AncillaryService> anclrList = null;
		try
		{
			anclrList = mapper.readValue(anclrStr.toString(), new TypeReference<List<AncillaryService>>(){});
		}catch (Exception e) {}

		try
		{
			System.out.println("anclrList:: "+new ObjectMapper().writeValueAsString(anclrList));
		}catch (Exception e) {}

		bookingRequest.setAncillaryServices(anclrList);

		if(fareRulesObj.isFlightInvalid() || !fareRulesObj.isFlightChecked()){

			System.out.println("<<<< Flight Sold Out Case >>>>>>");
			model.addAttribute("IsSoldOut", fareRulesObj.isFlightInvalid());
			bookingRequest.setIsSoldOut(true);
			model.addAttribute("airlineList", Utility.getAirlines());
			flightSearch.setOrigin(restService.getAirportList(flightReq.getSegment().get(0).getOriginAirport()).get(0));
			flightSearch.setDestination(restService.getAirportList(flightReq.getSegment().get(0).getDestinationAirport()).get(0));
			flightSearch.setTripType("1");
			if(flightReq.getTripType()==2){
				flightSearch.setTripType("2");
			}

			flightSearch.setDepartDate(bookingRequest.getDepartDate());
			flightSearch.setReturnDate(bookingRequest.getReturnDate());
			flightSearch.setCabin(Utility.getCabin(flightReq.getCabinType()));
			flightSearch.setAdult(bookingRequest.getAdults());
			flightSearch.setChild(bookingRequest.getChild());
			flightSearch.setInfant(bookingRequest.getInfants());
			flightSearch.setInfantWs(bookingRequest.getInfantsWs());
			try 
			{
				model.addAttribute("searchString", new ObjectMapper().writeValueAsString(flightSearch).replace("Int'l", "Intl"));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			ModelAndView mv = new ModelAndView("/result");

			return mv;
		}

		if(fareRulesObj.isPriceChange()){
			System.out.println("<<<< Flight IsPriceChange Case >>>>>>");
			bookingRequest.setIsPriceChange(true);
		}

		FlightResult selectedOrgflight=fareRulesObj.getFlightResult();

		List<Airline> airline  = fareRulesObj.getAirline();
		List<Airport> airport = fareRulesObj.getAirport();
		for (int i = 0; i < selectedOrgflight.getOutBound().size(); i++) {
			for (int j = 0; j < airline.size(); j++) {
				if(selectedOrgflight.getOutBound().get(i).getAirline().equalsIgnoreCase(airline.get(j).getCode())){
					selectedOrgflight.getOutBound().get(i).setAirlineName(airline.get(j).getName());
				}
			}
			for (int j = 0; j < airport.size(); j++) {
				if(airport.get(j).getAirportCode().equalsIgnoreCase(selectedOrgflight.getOutBound().get(i).getFromAirport())){
					selectedOrgflight.getOutBound().get(i).setFromAirportName(airport.get(j).getAirportName());
					selectedOrgflight.getOutBound().get(i).setFroCityName(airport.get(j).getCityName());
				}
				if(airport.get(j).getAirportCode().equalsIgnoreCase(selectedOrgflight.getOutBound().get(i).getToAirport())){
					selectedOrgflight.getOutBound().get(i).setToAirportName(airport.get(j).getAirportName());
					selectedOrgflight.getOutBound().get(i).setToCityName(airport.get(j).getCityName());
				}
			}
		}

		if(selectedOrgflight.getInBound() != null){
			for (int i = 0; i < selectedOrgflight.getInBound().size(); i++) {
				for (int j = 0; j < airline.size(); j++) {
					if(selectedOrgflight.getInBound().get(i).getAirline().equalsIgnoreCase(airline.get(j).getCode())){
						selectedOrgflight.getInBound().get(i).setAirlineName(airline.get(j).getName());
					}
				}
				for (int j = 0; j < airport.size(); j++) {
					if(airport.get(j).getAirportCode().equalsIgnoreCase(selectedOrgflight.getInBound().get(i).getFromAirport())){
						selectedOrgflight.getInBound().get(i).setFromAirportName(airport.get(j).getAirportName());
						selectedOrgflight.getInBound().get(i).setFroCityName(airport.get(j).getCityName());
					}
					if(airport.get(j).getAirportCode().equalsIgnoreCase(selectedOrgflight.getInBound().get(i).getToAirport())){
						selectedOrgflight.getInBound().get(i).setToAirportName(airport.get(j).getAirportName());
						selectedOrgflight.getInBound().get(i).setToCityName(airport.get(j).getCityName());
					} 
				}
			}
		}

		if(selectedOrgflight.getOtherBound() != null){
			for(int i = 0; i < selectedOrgflight.getOtherBound().size(); i++) {
				for(int j=0; j<selectedOrgflight.getOtherBound().get(i).size(); j++){

					for (int a = 0; a < airline.size(); a++) {
						if(selectedOrgflight.getOtherBound().get(i).get(j).getAirline().equalsIgnoreCase(airline.get(a).getCode())){
							selectedOrgflight.getOtherBound().get(i).get(j).setAirlineName(airline.get(a).getName());
						}
					}

					for (int a = 0; a < airport.size(); a++) {
						if(airport.get(a).getAirportCode().equalsIgnoreCase(selectedOrgflight.getOtherBound().get(i).get(j).getFromAirport())){
							selectedOrgflight.getOtherBound().get(i).get(j).setFromAirportName(airport.get(a).getAirportName());
							selectedOrgflight.getOtherBound().get(i).get(j).setFroCityName(airport.get(a).getCityName());
						}
						if(airport.get(a).getAirportCode().equalsIgnoreCase(selectedOrgflight.getOtherBound().get(i).get(j).getToAirport())){
							selectedOrgflight.getOtherBound().get(i).get(j).setToAirportName(airport.get(a).getAirportName());
							selectedOrgflight.getOtherBound().get(i).get(j).setToCityName(airport.get(a).getCityName());
						} 
					}
				}
			}
		}

		bookingRequest.setFlightResult(selectedOrgflight);

		ArrayList<String> title = new ArrayList<String>(); 
		title.add("Title"); 
		title.add("Mr"); 
		title.add("Mrs");  
		title.add("Miss"); 
		title.add("Dr"); 

		ArrayList<String> gender = new ArrayList<String>(); 
		gender.add("Select Gender");
		gender.add("Male"); 
		gender.add("Female"); 

		ArrayList<String> month = new ArrayList<String>(); 
		String[] shortMonths = new DateFormatSymbols().getShortMonths();
		month.add("Month");
		for (int i = 0; i < shortMonths.length-1; i++) {
			String shortMonth = shortMonths[i];
			month.add(shortMonth);
		}

		ArrayList<String> days = new ArrayList<String>();
		days.add("Day");
		for (int i = 1; i < 32; i++) {
			days.add(String.valueOf(i));
		}

		ArrayList<String> year = new ArrayList<String>(); 
		int years = Calendar.getInstance().get(Calendar.YEAR)-11;
		year.add("Year");
		for (int i = years; i > (years-100); i--) {
			year.add(String.valueOf(i));
		}

		ArrayList<String> childyear = new ArrayList<String>(); 
		int chyears = Calendar.getInstance().get(Calendar.YEAR)-2;
		childyear.add("Year");
		for (int i = chyears; i > (chyears-11); i--) {
			childyear.add(String.valueOf(i));
		}

		ArrayList<String> infyear = new ArrayList<String>(); 
		int infyears = Calendar.getInstance().get(Calendar.YEAR);
		infyear.add("Year");
		for (int i = infyears; i > (infyears-3); i--) {
			infyear.add(String.valueOf(i));
		}

		ArrayList<String> cardyear = new ArrayList<String>(); 
		years = Calendar.getInstance().get(Calendar.YEAR);
		cardyear.add("Year");
		for (int i = years; i < (years+50); i++) {
			cardyear.add(String.valueOf(i));
		}

		ArrayList<String> cardMonth = new ArrayList<String>(); 
		String[] longMonths = new DateFormatSymbols().getMonths();
		cardMonth.add("Month");
		cardMonth.add("Jan (01)");
		cardMonth.add("Feb (02)");
		cardMonth.add("Mar (03)");
		cardMonth.add("Apr (04)");
		cardMonth.add("May (05)");
		cardMonth.add("Jun (06)");
		cardMonth.add("Jul (07)");
		cardMonth.add("Aug (08)");
		cardMonth.add("Sep (09)");
		cardMonth.add("Oct (10)");
		cardMonth.add("Nov (11)");
		cardMonth.add("Dec (12)");

		ArrayList<String> cardtype = new ArrayList<String>(); 
		cardtype.add("Select a Card");
		cardtype.add("Visa");
		cardtype.add("Master Card");
		cardtype.add("American Express");
		cardtype.add("Diners Club");
		cardtype.add("Discover");
		cardtype.add("Carte Blanche");
		HashMap<String, ArrayList<String>> models = new HashMap<String, ArrayList<String>>();  
		models.put("title", title); 
		models.put("days", days); 
		models.put("month", month); 
		models.put("year", year); 
		models.put("chyear", childyear); 
		models.put("infyear", infyear); 
		models.put("cardyear", cardyear); 
		models.put("cardMonth", cardMonth);
		models.put("cardtype", cardtype);
		models.put("gender", gender);
		model.mergeAttributes(models);

		ModelAndView mv = new ModelAndView("/flight/payment/flight_info", "model", model);

		request.getSession().setAttribute("bookingRequest", bookingRequest);
		request.getSession().setAttribute("selectedflight", selectedflight);
		request.getSession().setAttribute("flightRequest", flightReq);
		model.addAttribute("searchRequest", flightReq);
		model.addAttribute("bookingRequest", bookingRequest);
		mv.addObject("bookingRequest", bookingRequest);
		mv.addObject("bookingWrapper", bookingRequest);

		return mv;

	}


	@GetMapping(value = { "/deeplink/result/{source}/{deeplinkId}", "/deeplink/result/{source}/{deeplinkId}/{flightId}" })
	public ModelAndView paymentMetaPage(@PathVariable String source, @PathVariable String deeplinkId, @PathVariable(value = "flightId", required = false) String flightId, @ModelAttribute BookingRequest bookingRequest, Model model,HttpServletRequest request)
	{
		
		System.out.println("source is :-- "+source);
		System.out.println("FlightsMetaController::PaymentMetaDeepLink :: /deeplink/result/"+source+"/"+deeplinkId+"/"+flightId);

		boolean normalFlag = false;
		boolean rtFlag = false;
		boolean owFlag = false;
		String[] deepVal= deeplinkId.split("-");
		try
		{
			if(flightId==null){
				System.out.println("1 Ow");
				owFlag = true;
				normalFlag = false;
			}
			else{
				System.out.println("2 RW");
				if(flightId.contains("-")){
					System.out.println("3 RW1");
					rtFlag = true;
					normalFlag = false;
				}else{
					normalFlag = true;
					rtFlag = false;
				}
			}
		}catch(Exception e){
			rtFlag = false;
			normalFlag = false;
		}

		ObjectMapper mapper = new ObjectMapper();
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

		bookingRequest.setDevice(device);
		bookingRequest.setBrowser(userBrowserDetails);

		if(normalFlag){
			bookingRequest.setSearchID(deeplinkId);		
			bookingRequest.setCacheLocation(flightId);	
			if(source.equalsIgnoreCase("jetrdr")){
				bookingRequest.setSourceMedia("jetrdr");
			}
			else if(source.equalsIgnoreCase("ladybug")){
				bookingRequest.setSourceMedia("ladybug");
			}
			else{
				bookingRequest.setSourceMedia("jetrdr");
			}
		}
		System.out.println("deepVal[0] :--"+deepVal[0]);
		System.out.println("deepVal[1] :--"+deepVal[1]);
		//System.out.println("deepVal[2] :--"+deepVal[2]);
		if(owFlag || rtFlag){
			System.out.println("in case of google:--- "+owFlag+"------"+rtFlag);
			bookingRequest.setSearchID(deepVal[0]+"-"+deepVal[1]);
			bookingRequest.setCacheLocation(deepVal[1]);
			bookingRequest.setSourceMedia("google");
		}
		
		String searchIDGog = null;
		if(source.equalsIgnoreCase("google")){

			try{
				searchIDGog = request.getParameter("marker");
			}catch(Exception e){
				searchIDGog = null;
			}

			System.out.println("Before SearchID[Google] :: "+searchIDGog);

			if(searchIDGog!=null){
				searchIDGog = searchIDGog;
			}else{
				searchIDGog = Utility.getAlphaNumericString(16);
			}

			System.out.println("After SearchID[Google] :: "+searchIDGog);
		}

		String searchID = null;
		if(source.equalsIgnoreCase("ladybug")){

			try{
				searchID = request.getParameter("marker");
			}catch(Exception e){
				searchID = null;
			}

			System.out.println("Before SearchID[Marker] :: "+searchID);

			if(searchID!=null){
				searchID = searchID;
			}else{
				searchID = Utility.getAlphaNumericString(16);
			}

			System.out.println("After SearchID[Marker] :: "+searchID);
		}

		String marker = null;
		if(source.equalsIgnoreCase("jetrdr")){

			try{
				marker = request.getParameter("marker");
			}catch(Exception e){
				marker = null;
			}

			System.out.println("Before SearchID[Marker] :: "+marker);

			if(marker!=null){
				marker = marker;
			}else{
				marker = Utility.getAlphaNumericString(16);
			}

			System.out.println("After SearchID[Marker] :: "+marker);
		}

		System.out.println("Here Currency is :-- "+currency);

		bookingRequest.setCurrencyCode(currency);
		if(source.equalsIgnoreCase("ladybug")){
			bookingRequest.setUserSessionID(searchID);
		}else{
			bookingRequest.setUserSessionID(marker);
		}
		bookingRequest.setUserIP(request.getRemoteAddr());
		bookingRequest.setProdID("1");
		bookingRequest.setBookingID("0");
		if(source.equalsIgnoreCase("ladybug")){
			bookingRequest.setSourceMedia("ladybug");
		}else if(source.equalsIgnoreCase("jetrdr")){
			bookingRequest.setSourceMedia("jetrdr");
		}else{
			bookingRequest.setSourceMedia("jetrdr");
		}

		bookingRequest = flightService.getMetaBookingRequest(bookingRequest);
		FlightResult selectedflight=bookingRequest.getFlightResult();

		if(rtFlag){
			String[] fltVal= flightId.split("-");
			BookingRequest bookingRequest1= new BookingRequest();
			bookingRequest1.setDevice(device);
			bookingRequest1.setBrowser(userBrowserDetails);
			bookingRequest1.setSearchID(fltVal[0]+"-"+fltVal[1]);
			bookingRequest1.setCacheLocation(fltVal[1]);
			bookingRequest1.setCurrencyCode(currency);
			bookingRequest1.setUserSessionID(searchIDGog);
			bookingRequest1.setUserIP(request.getRemoteAddr());
			bookingRequest1.setProdID("1");
			bookingRequest1.setBookingID("0");
			bookingRequest1.setSourceMedia("google");
			bookingRequest1 = flightService.getMetaBookingRequest(bookingRequest1); 

			String outboundString = "";
			try
			{
				outboundString = mapper.writeValueAsString(bookingRequest1.getFlightResult().getOutBound());
			}catch(Exception e){}

			List<InBound> inBoundList = null;
			try
			{
				inBoundList = mapper.readValue(outboundString.toString(), new TypeReference<List<InBound>>(){});
			}catch (Exception e) {}

			selectedflight.setInBound(inBoundList);

			double adultFare = selectedflight.getFare().getAdultFare()+bookingRequest1.getFlightResult().getFare().getAdultFare();
			double childFare = selectedflight.getFare().getChildFare()+bookingRequest1.getFlightResult().getFare().getChildFare();
			double infantFare = selectedflight.getFare().getInfantFare()+bookingRequest1.getFlightResult().getFare().getInfantFare();
			double infantWsFare = selectedflight.getFare().getInfantWsFare()+bookingRequest1.getFlightResult().getFare().getInfantWsFare();
			double adultTax = selectedflight.getFare().getAdultTax()+bookingRequest1.getFlightResult().getFare().getAdultTax();
			double childTax = selectedflight.getFare().getChildTax()+bookingRequest1.getFlightResult().getFare().getChildTax();
			double infantTax = selectedflight.getFare().getInfantTax()+bookingRequest1.getFlightResult().getFare().getInfantTax();
			double infantWsTax = selectedflight.getFare().getInfantWsTax()+bookingRequest1.getFlightResult().getFare().getInfantWsTax();
			double adultMarkup = selectedflight.getFare().getAdultMarkup()+bookingRequest1.getFlightResult().getFare().getAdultMarkup();
			double childMarkup = selectedflight.getFare().getChildMarkup()+bookingRequest1.getFlightResult().getFare().getChildMarkup();
			double infantMarkup = selectedflight.getFare().getInfantMarkup()+bookingRequest1.getFlightResult().getFare().getInfantMarkup();
			double infantWsMarkup = selectedflight.getFare().getInfantWsMarkup()+bookingRequest1.getFlightResult().getFare().getInfantWsMarkup();
			double grandTotal = selectedflight.getFare().getGrandTotal()+bookingRequest1.getFlightResult().getFare().getGrandTotal();
			double grandOrgTotal = selectedflight.getFare().getGrandOrgTotal()+bookingRequest1.getFlightResult().getFare().getGrandOrgTotal();
			double baseFare = selectedflight.getFare().getBaseFare()+bookingRequest1.getFlightResult().getFare().getBaseFare();
			double totalTax = selectedflight.getFare().getTotalTax()+bookingRequest1.getFlightResult().getFare().getTotalTax();
			double totalMarkup = selectedflight.getFare().getTotalMarkup()+bookingRequest1.getFlightResult().getFare().getTotalMarkup();

			selectedflight.getFare().setAdultFare(adultFare);
			selectedflight.getFare().setChildFare(childFare);
			selectedflight.getFare().setInfantFare(infantFare);
			selectedflight.getFare().setInfantWsFare(infantWsFare);
			selectedflight.getFare().setAdultTax(adultTax);
			selectedflight.getFare().setChildTax(childTax);
			selectedflight.getFare().setInfantTax(infantTax);
			selectedflight.getFare().setInfantWsTax(infantWsTax);
			selectedflight.getFare().setAdultMarkup(adultMarkup);
			selectedflight.getFare().setChildMarkup(childMarkup);
			selectedflight.getFare().setInfantMarkup(infantMarkup);
			selectedflight.getFare().setInfantWsMarkup(infantWsMarkup);
			selectedflight.getFare().setGrandTotal(grandTotal);
			selectedflight.getFare().setGrandOrgTotal(grandOrgTotal);
			selectedflight.getFare().setBaseFare(baseFare);
			selectedflight.getFare().setTotalTax(totalTax);
			selectedflight.getFare().setTotalMarkup(totalMarkup);

		}

		ArrayList<String> title = new ArrayList<String>(); 
		title.add("Title"); 
		title.add("Mr"); 
		title.add("Mrs");  
		title.add("Miss"); 
		title.add("Dr"); 

		ArrayList<String> gender = new ArrayList<String>(); 
		gender.add("Select Gender");
		gender.add("Male"); 
		gender.add("Female"); 

		ArrayList<String> month = new ArrayList<String>(); 
		String[] shortMonths = new DateFormatSymbols().getShortMonths();
		month.add("Month");
		for (int i = 0; i < shortMonths.length-1; i++) {
			String shortMonth = shortMonths[i];
			month.add(shortMonth);
		}

		ArrayList<String> days = new ArrayList<String>();
		days.add("Day");
		for (int i = 1; i < 32; i++) {
			days.add(String.valueOf(i));
		}

		ArrayList<String> year = new ArrayList<String>(); 
		int years = Calendar.getInstance().get(Calendar.YEAR)-11;
		year.add("Year");
		for (int i = years; i > (years-100); i--) {
			year.add(String.valueOf(i));
		}

		ArrayList<String> childyear = new ArrayList<String>(); 
		int chyears = Calendar.getInstance().get(Calendar.YEAR)-2;
		childyear.add("Year");
		for (int i = chyears; i > (chyears-11); i--) {
			childyear.add(String.valueOf(i));
		}

		ArrayList<String> infyear = new ArrayList<String>(); 
		int infyears = Calendar.getInstance().get(Calendar.YEAR);
		infyear.add("Year");
		for (int i = infyears; i > (infyears-3); i--) {
			infyear.add(String.valueOf(i));
		}

		ArrayList<String> cardyear = new ArrayList<String>(); 
		years = Calendar.getInstance().get(Calendar.YEAR);
		cardyear.add("Year");
		for (int i = years; i < (years+50); i++) {
			cardyear.add(String.valueOf(i));
		}
		ArrayList<String> cardMonth = new ArrayList<String>(); 
		String[] longMonths = new DateFormatSymbols().getMonths();
		cardMonth.add("Month");
		cardMonth.add("Jan (01)");
		cardMonth.add("Feb (02)");
		cardMonth.add("Mar (03)");
		cardMonth.add("Apr (04)");
		cardMonth.add("May (05)");
		cardMonth.add("Jun (06)");
		cardMonth.add("Jul (07)");
		cardMonth.add("Aug (08)");
		cardMonth.add("Sep (09)");
		cardMonth.add("Oct (10)");
		cardMonth.add("Nov (11)");
		cardMonth.add("Dec (12)");

		ArrayList<String> cardtype = new ArrayList<String>(); 
		cardtype.add("Select a Card");
		cardtype.add("Visa");
		cardtype.add("Master Card");
		cardtype.add("American Express");
		cardtype.add("Diners Club");
		cardtype.add("Discover");
		cardtype.add("Carte Blanche");
		HashMap<String, ArrayList<String>> models = new HashMap<String, ArrayList<String>>();  
		models.put("title", title); 
		models.put("days", days); 
		models.put("month", month); 
		models.put("year", year); 
		models.put("chyear", childyear); 
		models.put("infyear", infyear); 
		models.put("cardyear", cardyear); 
		models.put("cardMonth", cardMonth);
		models.put("cardtype", cardtype);
		models.put("gender", gender);
		model.mergeAttributes(models);

		try 
		{
			System.out.println("Meta Booking Request:"+mapper.writeValueAsString(bookingRequest));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		FlightRequest searchRequest = new FlightRequest();
		searchRequest.setAdults(bookingRequest.getAdults());
		searchRequest.setChild(bookingRequest.getChild());
		searchRequest.setInfants(bookingRequest.getInfants());
		searchRequest.setInfantsWs(bookingRequest.getInfantsWs());
		searchRequest.setSiteId(bookingRequest.getSiteID());
		if(source.equalsIgnoreCase("ladybug")){
			searchRequest.setSearchID(searchID);
		}else if(source.equalsIgnoreCase("google")){
			searchRequest.setSearchID(searchIDGog);
		}
			else{
			searchRequest.setSearchID(marker);
		}
		searchRequest.setTripType(1);
		searchRequest.setDevice(device);
		searchRequest.setBrowser(userBrowserDetails);
		searchRequest.setUserIP(bookingRequest.getUserIP());
		if(source.equalsIgnoreCase("ladybug"))
		{
			searchRequest.setSource("ladybug");
		}
		else if(source.equalsIgnoreCase("google"))
		{
			searchRequest.setSource("google");
		}
		else if(source.equalsIgnoreCase("jetrdr"))
		{
			searchRequest.setSource("jetrdr");
		}
		else 
		{
			searchRequest.setSource("jetrdr");
		}

		List<Segment> segment = new ArrayList<Segment>();
		Segment departSegment = new Segment();
		departSegment.setOriginAirport(bookingRequest.getFlightResult().getOutBound().get(0).getFromAirport());
		departSegment.setDestinationAirport(bookingRequest.getFlightResult().getOutBound().get(bookingRequest.getFlightResult().getOutBound().size()-1).getToAirport());
		departSegment.setTravelDate(Utility.googleDateformat(bookingRequest.getFlightResult().getOutBound().get(0).getDepDate().split("T")[0].toString()));
		segment.add(departSegment);

		try 
		{
			if(bookingRequest.getFlightResult().getInBound().size()>0){
				Segment returnSegment = new Segment();
				returnSegment.setOriginAirport(bookingRequest.getFlightResult().getInBound().get(0).getFromAirport());
				returnSegment.setDestinationAirport(bookingRequest.getFlightResult().getInBound().get(bookingRequest.getFlightResult().getInBound().size()-1).getToAirport());
				returnSegment.setTravelDate(Utility.googleDateformat(bookingRequest.getFlightResult().getInBound().get(0).getDepDate().split("T")[0].toString()));
				segment.add(returnSegment);
				searchRequest.setTripType(2);
			}
		} catch (Exception e) {
		}

		searchRequest.setSegment(segment);

		try 
		{
			System.out.println("Meta Search Request:"+mapper.writeValueAsString(searchRequest));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ModelAndView mv = new ModelAndView("/flight/payment/flight_info", "model", model);
		request.getSession().setAttribute("currencyValue", bookingRequest.getCurrencyValue());
		request.getSession().setAttribute("currencySymbol", bookingRequest.getCurrencySymbol());
		request.getSession().setAttribute("bookingRequest", bookingRequest);
		request.getSession().setAttribute("selectedflight", selectedflight);
		request.getSession().setAttribute("flightRequest", searchRequest);
		model.addAttribute("searchRequest", searchRequest);
		model.addAttribute("bookingRequest", bookingRequest);
		mv.addObject("bookingRequest", bookingRequest);
		mv.addObject("bookingWrapper", bookingRequest);

		return mv;
	}

	@RequestMapping(value = "/searchFlight", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView deepLinkMeta(@ModelAttribute FlightSearch flightSearch, HttpServletRequest request, Model model){
		ModelAndView mv = new ModelAndView("flightDeepLinkPage");

		String origin = "";
		String destination = "";
		String departDate = "";
		String returnDate = "";
		String tripTypeVal = "";
		String cabinClass = "Economy";
		String utm_source = "";
		String utm_medium = "";
		String utm_campaign = "";
		int adult = 0;
		int child = 0;

		try{
			origin = request.getParameter("fo");
		}catch(Exception e){
			origin= "";
		}

		try{
			destination = request.getParameter("fd");
		}catch(Exception e){
			destination= "";
		}

		try{
			departDate = request.getParameter("fodt");
		}catch(Exception e){
			departDate= "";
		}

		try{
			returnDate = request.getParameter("fddt");
		}catch(Exception e){
			returnDate= "";
		}

		try{
			tripTypeVal = request.getParameter("ft");
		}catch(Exception e){
			tripTypeVal= "";
		}

		try{
			utm_source = request.getParameter("utm_source");
		}catch(Exception e){
			utm_source= "";
		}

		try{
			utm_medium = request.getParameter("utm_medium");
		}catch(Exception e){
			utm_medium="";
		}

		try{
			utm_campaign = request.getParameter("utm_campaign");
		}catch(Exception e){
			utm_campaign="";
		}


		try{
			adult = Integer.parseInt(request.getParameter("a"));
		}catch(Exception e){
			adult= 0;
		}

		try{
			child = Integer.parseInt(request.getParameter("c"));
		}catch(Exception e){
			child= 0;
		}

		int totalAdults = 1;
		try
		{
			totalAdults = adult;
		}catch(Exception e){
			totalAdults = 1;
		}

		System.out.println(" Origin :: "+origin);
		System.out.println(" Destination :: "+destination);
		System.out.println(" DepartDate :: "+departDate);
		System.out.println(" ReturnDate :: "+returnDate);
		System.out.println(" TripTypeValue :: "+tripTypeVal);
		System.out.println(" CabinClass :: "+cabinClass);
		System.out.println(" Utm_source :: "+utm_source);
		System.out.println(" Utm_medium :: "+utm_medium);
		System.out.println(" Utm_campaign :: "+utm_campaign);
		System.out.println(" Adult :: "+adult);
		System.out.println(" Child :: "+child);
		System.out.println(" TotalAdults :: "+totalAdults);

		String tripType = "";
		if(tripTypeVal.equalsIgnoreCase("one_way")){
			tripType = "1";
		}
		else if(tripTypeVal.equalsIgnoreCase("round_trip")){
			tripType = "2";
		}

		flightSearch.setOrigin(restService.getAirportList(origin).get(0));
		flightSearch.setDestination(restService.getAirportList(destination).get(0));
		flightSearch.setDepartDate(ladybygDateformat(departDate));
		flightSearch.setReturnDate(ladybygDateformat(returnDate));
		flightSearch.setTripType(tripType);
		flightSearch.setAdult(totalAdults);
		flightSearch.setChild(child);
		flightSearch.setInfant(0);
		flightSearch.setInfantWs(0);
		flightSearch.setCabin(cabinClass);
		flightSearch.setAirline("");
		flightSearch.setPageAirline(""); 
		flightSearch.setOrigin2("");flightSearch.setOrigin3("");flightSearch.setOrigin4("");flightSearch.setOrigin5("");flightSearch.setOrigin6("");
		flightSearch.setDestination2("");flightSearch.setDestination3("");flightSearch.setDestination4("");flightSearch.setDestination5("");flightSearch.setDestination6("");
		flightSearch.setDepartDate2("");flightSearch.setDepartDate3("");flightSearch.setDepartDate4("");flightSearch.setDepartDate5("");flightSearch.setDepartDate6("");

		FlightRequest searchRequest = new FlightRequest();
		searchRequest.setAdults(adult);
		searchRequest.setChild(child);
		searchRequest.setInfants(0);
		searchRequest.setInfantsWs(0);
		searchRequest.setSearchID(Utility.getAlphaNumericString(15));
		searchRequest.setSiteId(siteId);
		searchRequest.setTripType(1);

		List<Segment> segment = new ArrayList<Segment>();
		Segment departSegment = new Segment();
		departSegment.setOriginAirport(origin);
		departSegment.setDestinationAirport(destination);
		departSegment.setTravelDate(ladybygDateformat(departDate));
		segment.add(departSegment);

		try 
		{
			if(Integer.parseInt(tripType)==2){
				Segment returnSegment = new Segment();
				returnSegment.setOriginAirport(destination);
				returnSegment.setDestinationAirport(origin);
				returnSegment.setTravelDate(ladybygDateformat(returnDate));
				segment.add(returnSegment);
				searchRequest.setTripType(2);
			}
		} catch (Exception e) {
		}

		searchRequest.setSegment(segment);

		String userBrowserDetails="userBrowserDetails";
		String device = "";
		try {
			UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
			userBrowserDetails=userAgent.getOperatingSystem()+"-"+userAgent.getBrowser()+"-"+userAgent.getBrowserVersion();
			device = userAgent.getOperatingSystem().getDeviceType().getName();
		} catch (Exception e1) {
			userBrowserDetails = request.getHeader("user-agent");
		}

		searchRequest.setUserIP(request.getRemoteAddr());
		searchRequest.setDevice(device);
		searchRequest.setSource(utm_source);
		searchRequest.setBrowser(userBrowserDetails); 
		searchRequest.setAirline("All");
		searchRequest.setCurrencyCode(currency);
		searchRequest.setFlexibleSearch(false);
		searchRequest.setIsNearBy(false);
		searchRequest.setLimit(200);
		searchRequest.setLocale("en");
		searchRequest.setMedia(siteName);
		searchRequest.setRID("");
		searchRequest.setSearchDirectFlight(false);
		searchRequest.setServerIP("");
		searchRequest.setSID("");
		searchRequest.setSiteId(siteId);
		searchRequest.setClient(siteId);
		searchRequest.setCabinType(Utility.getCabinId(cabinClass)); 

		try 
		{
			System.out.println(" FlightsMetaController :: SearchRequest After Making:: "+new ObjectMapper().writeValueAsString(searchRequest));
		} 
		catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getSession().setAttribute("flightSearch", flightSearch);
		request.getSession().setAttribute("flightRequest", searchRequest);

		return mv;
	}

	public static String ladybygDateformat(String orgDate){

		//System.out.println("getting Date Format"+orgDate);
		String fomateDate=""; //20230220
		String year = "";
		String month = "";
		String date = "";

		try
		{
			year = orgDate.substring(0, 4);
			month = orgDate.substring(4, 6);	
			date = orgDate.substring(6, 8);
			System.out.println("year"+year);
			System.out.println("month"+month);
			System.out.println("date"+date);
			fomateDate=month+"/"+date+"/"+year;
			System.out.println("sending to request"+fomateDate);
		}
		catch(Exception e){
			fomateDate = "";
		}

		return fomateDate;
	}

}
