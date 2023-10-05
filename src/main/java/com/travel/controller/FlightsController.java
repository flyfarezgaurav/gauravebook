package com.travel.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.auth.AuthGatewayRequest;
import com.travel.auth.AuthPaymentEmail;
import com.travel.bean.Child;
import com.travel.bean.FlightSearch;
import com.travel.bean.HotelSearch;
import com.travel.bean.Room;
import com.travel.object.bookingrequest.AncillaryService;
import com.travel.object.bookingrequest.BookingRequest;
import com.travel.object.bookingrequest.PassengerDetail;
import com.travel.object.bookingrequest.ancillaryServices.AncillaryProduct;
import com.travel.object.bookingrequest.ancillaryServices.Services;
import com.travel.object.bookingresponse.BookingResponse;
import com.travel.object.checkFareRulesResponse.CheckFareRulesResponse;
import com.travel.object.checkFareRulesResponse.FareFamily;
import com.travel.object.email.EmailFormat;
import com.travel.object.fareRules.CheckFareRules;
import com.travel.object.flightresponse.Airline;
import com.travel.object.flightresponse.Airport;
import com.travel.object.flightresponse.FlightResponse;
import com.travel.object.flightresponse.FlightResult;
import com.travel.object.flightresponse.OtherBound;
import com.travel.object.liveresult.LiveResultResponse;
import com.travel.object.searchRequest.FlightRequest;
import com.travel.object.searchRequest.Segment;
import com.travel.object.travelgaurd.response.TGResponse;
import com.travel.service.FlightService;
import com.travel.service.RestDataService;
import com.travel.utility.Emails;
import com.travel.utility.Utility;

import eu.bitwalker.useragentutils.UserAgent;
import net.authorize.Environment;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.CreateTransactionRequest;
import net.authorize.api.contract.v1.CreateTransactionResponse;
import net.authorize.api.contract.v1.CreditCardType;
import net.authorize.api.contract.v1.CustomerAddressType;
import net.authorize.api.contract.v1.CustomerDataType;
import net.authorize.api.contract.v1.MerchantAuthenticationType;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.contract.v1.PaymentType;
import net.authorize.api.contract.v1.TransactionRequestType;
import net.authorize.api.contract.v1.TransactionResponse;
import net.authorize.api.contract.v1.TransactionTypeEnum;
import net.authorize.api.controller.CreateTransactionController;
import net.authorize.api.controller.base.ApiOperationBase;

@Controller
@SessionAttributes({"bookingWrapper"})
public class FlightsController {

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

	@GetMapping("/")
	public String welcomePage(@ModelAttribute FlightSearch flightSearch, @ModelAttribute HotelSearch hotelSearch, Model model,HttpServletRequest request){
		model.addAttribute("airlineList", Utility.getAirlines());
		request.getSession().setAttribute("currencySymbol", "$");
		request.getSession().setAttribute("currencyValue", Double.valueOf(1));
		List<Room> rooms = new ArrayList<Room>();	

		for (int i = 0; i < 5; i++) {

			Room room=new Room();

			List<Child> children=new ArrayList<Child>();
			for (int j = 0; j < 5; j++) {
				Child childs =new Child();
				childs.setRef(j);
				children.add(childs);

			}
			room.setChildren(children);
			rooms.add(room);
		}

		hotelSearch.setRooms(rooms);
		model.addAttribute("dealList", flightService.getDealList());

		/*
		try
		{
			File catalinaBase = new File(System.getProperty("catalina.base")).getAbsoluteFile();
			System.out.println("catalinaBase::"+catalinaBase.toString());
			File propertyFile = new File(catalinaBase, "webapps/ROOT/WEB-INF/route-list.xlsx");
			RouteListFileReader reader = new RouteListFileReader();
			reader.readFromExcelFile(propertyFile.getAbsolutePath());
		}catch(Exception e){
			e.printStackTrace();
		}
		 */

		return "index";
	}

	@GetMapping("/cheap-flights")
	public String cheapFlights(@ModelAttribute FlightSearch flightSearch,@ModelAttribute HotelSearch hotelSearch, Model model){
		model.addAttribute("airlineList", Utility.getAirlines());

		List<Room> rooms = new ArrayList<Room>();	

		for (int i = 0; i < 5; i++) {

			Room room=new Room(); 

			List<Child> children=new ArrayList<Child>();
			for (int j = 0; j < 5; j++) {
				Child childs =new Child();
				childs.setRef(j);
				children.add(childs);

			}
			room.setChildren(children);
			rooms.add(room);

		}

		hotelSearch.setRooms(rooms);

		return "index";
	}

	@PostMapping("/flight-listing/{searchId}")
	public String resultPage(@ModelAttribute FlightSearch flightSearch, @PathVariable String searchId, HttpServletRequest request, Model model){
		ObjectMapper mapper = new ObjectMapper();

		//System.out.println("Airline : " + flightSearch.getPageAirline());
		//System.out.println("getCabin : " + flightSearch.getCabin());

		FlightRequest flightReq = flightService.getFlightSearchRequest(flightSearch, request, searchId);
		try
		{
			System.out.println("Search Request:"+mapper.writeValueAsString(flightReq));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		//System.out.println(flightService.getFlightSearchResponse(flightReq));
		request.getSession().setAttribute("flightRequest", flightReq);
		request.getSession().setAttribute("flightSearch", flightSearch);
		model.addAttribute("airlineList", Utility.getAirlines());
		try {
			model.addAttribute("searchString", new ObjectMapper().writeValueAsString(flightSearch).replace("Int'l", "Intl"));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "result";
	}

	@GetMapping("/flight-listing/{searchId}")
	public String flightListing(@ModelAttribute FlightSearch flightSearch,@PathVariable String searchId, HttpServletRequest request, Model model){
		flightSearch = (FlightSearch) request.getSession().getAttribute("flightSearch");
		FlightRequest flightReq = (FlightRequest) request.getSession().getAttribute("flightRequest");
		model.addAttribute("airlineList", Utility.getAirlines());
		model.addAttribute("flightSearch", flightSearch);
		try {
			model.addAttribute("searchString", new ObjectMapper().writeValueAsString(flightSearch).replace("Int'l", "Intl"));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "result";
	}

	@GetMapping("/psi")
	public String flightResultDeppLink(@ModelAttribute FlightSearch flightSearch,HttpServletRequest request, @RequestParam("type") String type,@RequestParam("origin") String origin,@RequestParam("destination") String destination
			,@RequestParam("adults") int adults,@RequestParam("children") int children,@RequestParam("infants") int infants,@RequestParam("infantws") int infantws
			,@RequestParam("departure") String departure,@RequestParam("return") String retu,@RequestParam("cabin") String cabin,@RequestParam("utm_source") String utm_source,@RequestParam("utm_medium") String utm_medium,Model model){

		List<List<OtherBound>> otherBounds=new ArrayList<List<OtherBound>>();
		FlightRequest flightReq = flightService.getFlightDeepSearchRequest(request,type,origin,destination,destination, origin, otherBounds,adults,children,infants,infantws,departure,retu,cabin,utm_source,utm_medium);

		request.getSession().setAttribute("flightRequest", flightReq);
		model.addAttribute("airlineList", Utility.getAirlines());
		flightSearch.setOrigin(restService.getAirportList(origin).get(0));
		flightSearch.setDestination(restService.getAirportList(destination).get(0));
		flightSearch.setTripType("1");
		if(type.equalsIgnoreCase("RT")){
			flightSearch.setTripType("2");
		}
		flightSearch.setDepartDate(departure);
		flightSearch.setReturnDate(retu);
		flightSearch.setCabin(cabin);
		flightSearch.setAdult(adults);
		flightSearch.setChild(children);
		flightSearch.setInfant(infants);
		flightSearch.setInfantWs(infantws);
		try {
			model.addAttribute("searchString", new ObjectMapper().writeValueAsString(flightSearch).replace("Int'l", "Intl"));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "result";

	}

	@GetMapping("/psio")
	public String flightResultDeppLinkOW(@ModelAttribute FlightSearch flightSearch,HttpServletRequest request, @RequestParam("type") String type,@RequestParam("origin") String origin,@RequestParam("destination") String destination
			,@RequestParam("adults") int adults,@RequestParam("children") int children,@RequestParam("infants") int infants,@RequestParam("infantws") int infantws
			,@RequestParam("departure") String departure,@RequestParam("cabin") String cabin,@RequestParam("utm_source") String utm_source,@RequestParam("utm_medium") String utm_medium,Model model){

		List<List<OtherBound>> otherBounds=new ArrayList<List<OtherBound>>();

		//flightService.getFlightDeepSearchRequest(request,TripType,origin,destination,origin1,destination1, otherBounds, bookingRequest.getAdults(),bookingRequest.getChild(),bookingRequest.getInfants(),bookingRequest.getInfantsWs(),bookingRequest.getDepartDate(),bookingRequest.getReturnDate(),cabinId,"google",Refe);
		FlightRequest flightReq = flightService.getFlightDeepSearchRequest(request,type,origin,destination, destination, origin, otherBounds, adults,children,infants,infantws,departure,"",cabin,utm_source,utm_medium);

		request.getSession().setAttribute("flightRequest", flightReq);
		model.addAttribute("airlineList", Utility.getAirlines());
		flightSearch.setOrigin(restService.getAirportList(origin).get(0));
		flightSearch.setDestination(restService.getAirportList(destination).get(0));
		flightSearch.setTripType("1");
		if(type.equalsIgnoreCase("RT")){
			flightSearch.setTripType("2");
		}
		flightSearch.setDepartDate(departure);
		flightSearch.setReturnDate("");
		flightSearch.setCabin(cabin);
		flightSearch.setAdult(adults); 
		flightSearch.setChild(children);
		flightSearch.setInfant(infants);
		flightSearch.setInfantWs(infantws); 
		try {
			model.addAttribute("searchString", new ObjectMapper().writeValueAsString(flightSearch).replace("Int'l", "Intl"));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "result";

	}

	@GetMapping("/flight/livelink/{searchId}/{resultId}")
	public String paymentCustomerPage(@PathVariable String searchId,@PathVariable String resultId,@ModelAttribute BookingRequest bookingRequest,Model model,HttpServletRequest request){

		bookingRequest.setBookingID(resultId);
		bookingRequest.setSearchID(searchId);
		bookingRequest.setSourceMedia("flight");
		String apiUrls=flightAPiUrl+"/customerRequests?authcode="+password;
		System.out.println("apiUrls:"+apiUrls);
		RestTemplate restTemplate = new RestTemplate();
		String bookingRes= restTemplate.postForObject (apiUrls,bookingRequest,String.class);
		System.out.println("BookingRequest response : " + bookingRes);
		ObjectMapper mapper = new ObjectMapper();
		LiveResultResponse liveResponse = new LiveResultResponse();
		try{
			liveResponse = mapper.readValue(bookingRes, LiveResultResponse.class);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		request.getSession().setAttribute("liveResponse", liveResponse);
		model.addAttribute("bookingRequest", bookingRequest); 
		request.getSession().setAttribute("bookingRes", bookingRes);
		model.addAttribute("bookingRes", bookingRes);
		return "live-result";
	}

	@GetMapping("/flight/live/payment/{searchId}/{resultId}")
	public String paymentPageLive(@PathVariable String searchId,@PathVariable int resultId,@ModelAttribute BookingRequest bookingRequest,Model model,HttpServletRequest request){
		FlightRequest searchRequest = (FlightRequest) request.getSession().getAttribute("flightRequest");
		//FlightResponse flightResult=new FlightResponse();
		LiveResultResponse liveResponse = new LiveResultResponse();
		ObjectMapper mapper = new ObjectMapper();
		try 
		{	
			//if(request.getSession().getAttribute("sessionFlightResponse") == null){
			liveResponse =	(LiveResultResponse) request.getSession().getAttribute("liveResponse");
			System.out.println("liveResponse.getLiveflightResult() : " + liveResponse.getLiveflightResult().size());
			List<FlightResult> flightList = liveResponse.getLiveflightResult();
			/*for (int i = 0; i < liveResponse.getLiveflightResult().size(); i++) {
					FlightResult flight =new FlightResult();
					flight.setAirline(liveResponse.getLiveflightResult().get(i).getAirline());
					flight.setBookingToken(liveResponse.getLiveflightResult().get(i).getBookingToken());
					flight.setCabinClass(liveResponse.getLiveflightResult().get(i).getCabinClass());
					flight.setConsId(liveResponse.getLiveflightResult().get(i).getConsId());
					flight.setFare(liveResponse.getLiveflightResult().get(i).getFare());
					flight.setFareType(liveResponse.getLiveflightResult().get(i).getFareType());
					flight.setGdsType(liveResponse.getLiveflightResult().get(i).getGdsType());
					flight.setInBound(liveResponse.getLiveflightResult().get(i).getInBound());
					flight.setInEFT(liveResponse.getLiveflightResult().get(i).getInEFT());
					flight.setMaxSeat(liveResponse.getLiveflightResult().get(i).getMaxSeat());
					//flight.setOtherBound(liveResponse.getLiveflightResult().get(i).getOtherBound());
					flight.setOutBound(liveResponse.getLiveflightResult().get(i).getOutBound());
					flight.setOutEFT(liveResponse.getLiveflightResult().get(i).getOutEFT());
					flight.setResultID(liveResponse.getLiveflightResult().get(i).getResultID());
					flight.setValCarrier(liveResponse.getLiveflightResult().get(i).getValCarrier());
					flightList.add(flight);
				}*/
			//flightResult.setFlightResult(flightList);
			//}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		FlightResult selectedflight = new FlightResult();
		for (int i = 0; i < liveResponse.getLiveflightResult().size(); i++) {
			if(liveResponse.getLiveflightResult().get(i).getResultID() == resultId){
				selectedflight=liveResponse.getLiveflightResult().get(i);
			}
		}

		bookingRequest.setFlightResult(selectedflight);
		bookingRequest.setAdults(liveResponse.getAdults());
		bookingRequest.setChild(liveResponse.getChild());
		bookingRequest.setInfants(liveResponse.getInfants());
		bookingRequest.setInfantsWs(liveResponse.getInfantsWs());
		bookingRequest.setSearchID(liveResponse.getSearchID());
		bookingRequest.setSiteID(1);
		bookingRequest.setProdID("1");
		bookingRequest.setBookingID("0");
		bookingRequest.setUserSessionID(searchId);
		bookingRequest.setCurrencyCode(currency);
		bookingRequest.setBrowser(searchRequest.getBrowser());
		List<PassengerDetail> passengerDetails=new ArrayList<PassengerDetail>();
		int travelerNo=0;
		for (int i = 0; i < liveResponse.getAdults(); i++) {
			PassengerDetail paxDetail=new PassengerDetail();
			paxDetail.setPassengerType(1);
			passengerDetails.add(paxDetail);
			travelerNo++;
		}
		for (int i = 0; i < liveResponse.getChild(); i++) {
			PassengerDetail paxDetail=new PassengerDetail();
			paxDetail.setPassengerType(2);
			passengerDetails.add(paxDetail);
			travelerNo++;
		}
		for (int i = 0; i < liveResponse.getInfants(); i++) {
			PassengerDetail paxDetail=new PassengerDetail();
			paxDetail.setPassengerType(3);
			passengerDetails.add(paxDetail);
			travelerNo++;
		}
		for (int i = 0; i < liveResponse.getInfantsWs(); i++) {
			PassengerDetail paxDetail=new PassengerDetail();
			paxDetail.setPassengerType(4);
			passengerDetails.add(paxDetail);
			travelerNo++;
		}
		bookingRequest.setPassengerDetails(passengerDetails);
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
		/* for (int i = 0; i < longMonths.length-1; i++) {
		        String longMonth = longMonths[i];
		        cardMonth.add(longMonth);
		    }*/
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
		try {
			System.out.println(mapper.writeValueAsString(bookingRequest));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getSession().setAttribute("bookingRequest", bookingRequest);
		request.getSession().setAttribute("selectedflight", selectedflight);
		model.addAttribute("searchRequest", searchRequest);
		return "payment";
	}

	@RequestMapping(value = "/payment/flight_info/{searchId}/{resultId}", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView FlightPaymentPageOne(@PathVariable String searchId, @PathVariable String resultId, @ModelAttribute BookingRequest bookingRequest, Model model, HttpServletRequest request)
	{
		System.out.println("FlightPaymentPageOne Method Calling "+searchId+" && resultId :: "+resultId); 

		FlightRequest searchRequest = (FlightRequest) request.getSession().getAttribute("flightRequest");

		String currencySymbol = "$";
		double currencyValue = 1;
		try{
			currencySymbol = (String) request.getSession().getAttribute("currencySymbol");
			currencyValue = (double) request.getSession().getAttribute("currencyValue");
		}
		catch(Exception e){
			request.getSession().setAttribute("currencySymbol","$");
			request.getSession().setAttribute("currencyValue",1);
		}
		System.out.println("currencyValue >>> " + currencyValue);
		bookingRequest.setCurrencySymbol(currencySymbol);
		bookingRequest.setCurrencyValue(currencyValue);

		FlightResponse flightResult = new FlightResponse();
		FlightResult selectedflight = new FlightResult();
		ObjectMapper mapper = new ObjectMapper();

		if(searchId.equalsIgnoreCase("coremeta")){
			String deeplinkId=resultId.split("-")[0];
			String flightId=resultId.split("-")[1];
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

			System.out.println("Device::"+device);

			bookingRequest.setDevice(device);
			bookingRequest.setBrowser(userBrowserDetails);
			bookingRequest.setSearchID(deeplinkId);
			bookingRequest.setSourceMedia(searchId);
			bookingRequest.setCacheLocation(flightId);

			bookingRequest = flightService.getMetaBookingRequest(bookingRequest);
			bookingRequest.setCurrencyCode(currency);
			bookingRequest.setDevice(device);
			bookingRequest.setBrowser(userBrowserDetails);
			bookingRequest.setSearchID(deeplinkId);
			bookingRequest.setUserSessionID(deeplinkId);
			bookingRequest.setUserIP(request.getRemoteAddr());
			//bookingRequest.setSourceMedia(searchId);
			bookingRequest.setCacheLocation(flightId);
			bookingRequest.setProdID("1");
			bookingRequest.setBookingID("0");
			selectedflight=bookingRequest.getFlightResult();

			searchRequest.setAdults(bookingRequest.getAdults());
			searchRequest.setChild(bookingRequest.getChild());
			searchRequest.setInfants(bookingRequest.getInfants());
			searchRequest.setInfantsWs(bookingRequest.getInfantsWs());
			searchRequest.setSearchID(bookingRequest.getSearchID());
			searchRequest.setSiteId(bookingRequest.getSiteID());
			searchRequest.setSearchID(bookingRequest.getUserSessionID());

			List<Segment> segment = new ArrayList<Segment>();
			Segment departSegment = new Segment();

			departSegment.setOriginAirport(bookingRequest.getFlightResult().getOutBound().get(0).getFromAirport());
			departSegment.setDestinationAirport(bookingRequest.getFlightResult().getOutBound().get(bookingRequest.getFlightResult().getOutBound().size()-1).getToAirport());
			departSegment.setTravelDate(bookingRequest.getFlightResult().getOutBound().get(0).getDepDate().split("T")[0].toString());
			segment.add(departSegment);

			try {
				if(bookingRequest.getFlightResult().getInBound().size()>0){
					Segment returnSegment = new Segment();
					returnSegment.setOriginAirport(bookingRequest.getFlightResult().getInBound().get(0).getFromAirport());
					returnSegment.setDestinationAirport(bookingRequest.getFlightResult().getInBound().get(bookingRequest.getFlightResult().getInBound().size()-1).getToAirport());
					returnSegment.setTravelDate(bookingRequest.getFlightResult().getInBound().get(0).getDepDate().split("T")[0].toString());
					segment.add(returnSegment);
				}
			} catch (Exception e) {
			}

			searchRequest.setSegment(segment);
			request.getSession().setAttribute("flightRequest", searchRequest);

		}else{

			try 
			{
				flightResult = (FlightResponse) request.getSession().getAttribute("sessionFlightResponse");
				//System.out.println("FlightPaymentPageOne:: FlightResultStr : " + flightResult); 
				//flightResult = mapper.readValue(flightResultStr, FlightResult.class);
			} 
			catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			for (int i = 0; i < flightResult.getFlightResult().size(); i++) {
				if(flightResult.getFlightResult().get(i).getResultID() == Integer.parseInt(resultId)){
					selectedflight=flightResult.getFlightResult().get(i);
					bookingRequest.setCurrencySymbol(flightResult.getFlightResult().get(i).getCurrencyCode());
					bookingRequest.setCurrencyValue(1);
					request.getSession().setAttribute("currencySymbol",flightResult.getFlightResult().get(i).getCurrencyCode());
					request.getSession().setAttribute("currencyValue",1);
				}
			}

			List<Airline> airline  = flightResult.getAirline();
			List<Airport> airport = flightResult.getAirport();
			for (int i = 0; i < selectedflight.getOutBound().size(); i++) {
				for (int j = 0; j < airline.size(); j++) {
					if(selectedflight.getOutBound().get(i).getAirline().equalsIgnoreCase(airline.get(j).getCode())){
						selectedflight.getOutBound().get(i).setAirlineName(airline.get(j).getName());
					}
				}
				for (int j = 0; j < airport.size(); j++) {
					if(airport.get(j).getAirportCode().equalsIgnoreCase(selectedflight.getOutBound().get(i).getFromAirport())){
						selectedflight.getOutBound().get(i).setFromAirportName(airport.get(j).getAirportName());
						selectedflight.getOutBound().get(i).setFroCityName(airport.get(j).getCityName());
					}
					if(airport.get(j).getAirportCode().equalsIgnoreCase(selectedflight.getOutBound().get(i).getToAirport())){
						selectedflight.getOutBound().get(i).setToAirportName(airport.get(j).getAirportName());
						selectedflight.getOutBound().get(i).setToCityName(airport.get(j).getCityName());
					}
				}
			}
			if(selectedflight.getInBound() != null){
				for (int i = 0; i < selectedflight.getInBound().size(); i++) {
					for (int j = 0; j < airline.size(); j++) {
						if(selectedflight.getInBound().get(i).getAirline().equalsIgnoreCase(airline.get(j).getCode())){
							selectedflight.getInBound().get(i).setAirlineName(airline.get(j).getName());
						}
					}
					for (int j = 0; j < airport.size(); j++) {
						if(airport.get(j).getAirportCode().equalsIgnoreCase(selectedflight.getInBound().get(i).getFromAirport())){
							selectedflight.getInBound().get(i).setFromAirportName(airport.get(j).getAirportName());
							selectedflight.getInBound().get(i).setFroCityName(airport.get(j).getCityName());
						}
						if(airport.get(j).getAirportCode().equalsIgnoreCase(selectedflight.getInBound().get(i).getToAirport())){
							selectedflight.getInBound().get(i).setToAirportName(airport.get(j).getAirportName());
							selectedflight.getInBound().get(i).setToCityName(airport.get(j).getCityName());
						} 
					}
				}
			}

			selectedflight.setGdsType(2);

			CheckFareRules checkRules = new CheckFareRules();
			checkRules.setFlightResult(selectedflight);
			checkRules.setAdults(searchRequest.getAdults());
			checkRules.setChild(searchRequest.getChild());
			checkRules.setInfants(searchRequest.getInfants());
			checkRules.setInfantsWs(searchRequest.getInfantsWs());
			checkRules.setSiteID(searchRequest.getSiteId());
			checkRules.setCurrencyCode(searchRequest.getCurrencyCode());

			try 
			{
				// get Search Request object as a json string
				String jsonStr = mapper.writeValueAsString(checkRules);
				System.out.println("FlightPaymentPageOne::CheckRules JSON:: "+jsonStr);
			} catch (IOException e) {
				// TODO Auto-generated catch block 
				e.printStackTrace();
			}

			//String fareRules = "{\"flightChecked\":true,\"flightInvalid\":false,\"priceChange\":false,\"fare\":{\"adultFare\":63.26,\"childFare\":0.0,\"infantFare\":0.0,\"infantWsFare\":0.0,\"adultTax\":34.54,\"childTax\":0.0,\"infantTax\":0.0,\"infantWsTax\":0.0,\"adultMarkup\":14.67,\"childMarkup\":0.0,\"infantMarkup\":0.0,\"infantWsMarkup\":0.0,\"bagFees\":0.0,\"grandTotal\":112.47,\"totalMarkup\":14.67,\"grandOrgTotal\":97.8,\"baseFare\":63.26,\"totalTax\":49.21,\"tbo_baseFare\":0.0,\"tbo_totalTax\":0.0,\"markupType\":\"US\"},\"bagRecheckReq\":false,\"perPaxLuggageOptions\":false,\"gbptousd\":0.0,\"eurtousd\":0.0,\"eurtogbp\":0.0,\"responseStatus\":{\"status\":1,\"messege\":\"success\"},\"fareFamily\":[{\"totalPrice\":\"97.80\",\"familyNames\":[\"BASICECON\",\"BASICECON\"],\"classOfServices\":[\"E\",\"E\"],\"fareFamilyDescription\":[{\"rateCategory\":\"BASICECON\",\"description\":\"BASIC ECONOMY\",\"serviceInformation\":[{\"serviceName\":\"CARRY ON UP TO 45 LI 115 LCM\",\"serviceType\":\"INC\"},{\"serviceName\":\"LAST TO BOARD\",\"serviceType\":\"INC\"},{\"serviceName\":\"LIMITED OVERHEAD BIN SPACE\",\"serviceType\":\"INC\"},{\"serviceName\":\"SNACK\",\"serviceType\":\"INC\"},{\"serviceName\":\"INFLIGHT ENT\",\"serviceType\":\"INC\"},{\"serviceName\":\"FIRST BAG 23K 50LB 62LI 158LCM\",\"serviceType\":\"CHA\"},{\"serviceName\":\"SECOND BAG 23K50LB 62LI 158LCM\",\"serviceType\":\"CHA\"},{\"serviceName\":\"CANCELLATION TO ECREDIT\",\"serviceType\":\"CHA\"},{\"serviceName\":\"ALCOHOLIC DRINK\",\"serviceType\":\"CHA\"},{\"serviceName\":\"INTERNET ACCESS\",\"serviceType\":\"CHA\"},{\"serviceName\":\"UNACCOMPANIED MINOR\",\"serviceType\":\"CHA\"},{\"serviceName\":\"PRE RESERVED SEAT ASSIGNMENT\",\"serviceType\":\"NOF\"},{\"serviceName\":\"CHANGEABLE TICKET\",\"serviceType\":\"NOF\"},{\"serviceName\":\"REFUNDABLE TICKET\",\"serviceType\":\"NOF\"},{\"serviceName\":\"MILEAGE ACCRUAL\",\"serviceType\":\"NOF\"},{\"serviceName\":\"UPGRADE ELIGIBILITY\",\"serviceType\":\"NOF\"},{\"serviceName\":\"STANDBY\",\"serviceType\":\"NOF\"},{\"serviceName\":\"STANDARD BOARDING\",\"serviceType\":\"NOF\"},{\"serviceName\":\"PRIORITY BOARDING\",\"serviceType\":\"NOF\"},{\"serviceName\":\"PRIORITY CHECK IN\",\"serviceType\":\"NOF\"},{\"serviceName\":\"STATUS ACCRUAL\",\"serviceType\":\"NOF\"}]}]},{\"totalPrice\":\"157.79\",\"familyNames\":[\"MAINCABIN\",\"MAINCABIN\"],\"classOfServices\":[\"V\",\"V\"],\"fareFamilyDescription\":[{\"rateCategory\":\"MAINCABIN\",\"description\":\"MAIN CABIN\",\"serviceInformation\":[{\"serviceName\":\"PRE RESERVED SEAT ASSIGNMENT\",\"serviceType\":\"INC\"},{\"serviceName\":\"CARRY ON UP TO 45 LI 115 LCM\",\"serviceType\":\"INC\"},{\"serviceName\":\"CHANGEABLE TICKET\",\"serviceType\":\"INC\"},{\"serviceName\":\"MILEAGE ACCRUAL\",\"serviceType\":\"INC\"},{\"serviceName\":\"STANDARD SEAT\",\"serviceType\":\"INC\"},{\"serviceName\":\"STANDARD BOARDING\",\"serviceType\":\"INC\"},{\"serviceName\":\"STATUS ACCRUAL\",\"serviceType\":\"INC\"},{\"serviceName\":\"SNACK\",\"serviceType\":\"INC\"},{\"serviceName\":\"INFLIGHT ENT\",\"serviceType\":\"INC\"},{\"serviceName\":\"FIRST BAG 23K 50LB 62LI 158LCM\",\"serviceType\":\"CHA\"},{\"serviceName\":\"SECOND BAG 23K50LB 62LI 158LCM\",\"serviceType\":\"CHA\"},{\"serviceName\":\"UPGRADE ELIGIBILITY\",\"serviceType\":\"CHA\"},{\"serviceName\":\"STANDBY\",\"serviceType\":\"CHA\"},{\"serviceName\":\"PRIORITY BOARDING\",\"serviceType\":\"CHA\"},{\"serviceName\":\"ALCOHOLIC DRINK\",\"serviceType\":\"CHA\"},{\"serviceName\":\"INTERNET ACCESS\",\"serviceType\":\"CHA\"},{\"serviceName\":\"UNACCOMPANIED MINOR\",\"serviceType\":\"CHA\"},{\"serviceName\":\"REFUNDABLE TICKET\",\"serviceType\":\"NOF\"},{\"serviceName\":\"PRIORITY CHECK IN\",\"serviceType\":\"NOF\"}]}],\"priceDiffrence\":\"59.99\"},{\"totalPrice\":\"267.81\",\"familyNames\":[\"REFMAIN\",\"REFMAIN\"],\"classOfServices\":[\"X\",\"X\"],\"fareFamilyDescription\":[{\"rateCategory\":\"REFMAIN\",\"description\":\"REFUNDABLE MAIN CABIN\",\"serviceInformation\":[{\"serviceName\":\"PRE RESERVED SEAT ASSIGNMENT\",\"serviceType\":\"INC\"},{\"serviceName\":\"CARRY ON UP TO 45 LI 115 LCM\",\"serviceType\":\"INC\"},{\"serviceName\":\"CHANGEABLE TICKET\",\"serviceType\":\"INC\"},{\"serviceName\":\"REFUNDABLE TICKET\",\"serviceType\":\"INC\"},{\"serviceName\":\"MILEAGE ACCRUAL\",\"serviceType\":\"INC\"},{\"serviceName\":\"STANDARD SEAT\",\"serviceType\":\"INC\"},{\"serviceName\":\"STANDARD BOARDING\",\"serviceType\":\"INC\"},{\"serviceName\":\"STATUS ACCRUAL\",\"serviceType\":\"INC\"},{\"serviceName\":\"SNACK\",\"serviceType\":\"INC\"},{\"serviceName\":\"INFLIGHT ENT\",\"serviceType\":\"INC\"},{\"serviceName\":\"FIRST BAG 23K 50LB 62LI 158LCM\",\"serviceType\":\"CHA\"},{\"serviceName\":\"SECOND BAG 23K50LB 62LI 158LCM\",\"serviceType\":\"CHA\"},{\"serviceName\":\"UPGRADE ELIGIBILITY\",\"serviceType\":\"CHA\"},{\"serviceName\":\"STANDBY\",\"serviceType\":\"CHA\"},{\"serviceName\":\"PRIORITY BOARDING\",\"serviceType\":\"CHA\"},{\"serviceName\":\"ALCOHOLIC DRINK\",\"serviceType\":\"CHA\"},{\"serviceName\":\"INTERNET ACCESS\",\"serviceType\":\"CHA\"},{\"serviceName\":\"UNACCOMPANIED MINOR\",\"serviceType\":\"CHA\"},{\"serviceName\":\"PRIORITY CHECK IN\",\"serviceType\":\"NOF\"}]}],\"priceDiffrence\":\"170.01\"},{\"totalPrice\":\"777.80\",\"familyNames\":[\"MAINCABIN\",\"REFMAIN\"],\"classOfServices\":[\"V\",\"Y\"],\"fareFamilyDescription\":[{\"rateCategory\":\"MAINCABIN\",\"description\":\"MAIN CABIN\",\"serviceInformation\":[{\"serviceName\":\"PRE RESERVED SEAT ASSIGNMENT\",\"serviceType\":\"INC\"},{\"serviceName\":\"CARRY ON UP TO 45 LI 115 LCM\",\"serviceType\":\"INC\"},{\"serviceName\":\"CHANGEABLE TICKET\",\"serviceType\":\"INC\"},{\"serviceName\":\"MILEAGE ACCRUAL\",\"serviceType\":\"INC\"},{\"serviceName\":\"STANDARD SEAT\",\"serviceType\":\"INC\"},{\"serviceName\":\"STANDARD BOARDING\",\"serviceType\":\"INC\"},{\"serviceName\":\"STATUS ACCRUAL\",\"serviceType\":\"INC\"},{\"serviceName\":\"SNACK\",\"serviceType\":\"INC\"},{\"serviceName\":\"INFLIGHT ENT\",\"serviceType\":\"INC\"},{\"serviceName\":\"FIRST BAG 23K 50LB 62LI 158LCM\",\"serviceType\":\"CHA\"},{\"serviceName\":\"SECOND BAG 23K50LB 62LI 158LCM\",\"serviceType\":\"CHA\"},{\"serviceName\":\"UPGRADE ELIGIBILITY\",\"serviceType\":\"CHA\"},{\"serviceName\":\"STANDBY\",\"serviceType\":\"CHA\"},{\"serviceName\":\"PRIORITY BOARDING\",\"serviceType\":\"CHA\"},{\"serviceName\":\"ALCOHOLIC DRINK\",\"serviceType\":\"CHA\"},{\"serviceName\":\"INTERNET ACCESS\",\"serviceType\":\"CHA\"},{\"serviceName\":\"UNACCOMPANIED MINOR\",\"serviceType\":\"CHA\"},{\"serviceName\":\"REFUNDABLE TICKET\",\"serviceType\":\"NOF\"},{\"serviceName\":\"PRIORITY CHECK IN\",\"serviceType\":\"NOF\"}]}],\"priceDiffrence\":\"680.00\"},{\"totalPrice\":\"777.80\",\"familyNames\":[\"REFMAIN\",\"MAINCABIN\"],\"classOfServices\":[\"Y\",\"V\"],\"fareFamilyDescription\":[{\"rateCategory\":\"REFMAIN\",\"description\":\"REFUNDABLE MAIN CABIN\",\"serviceInformation\":[{\"serviceName\":\"PRE RESERVED SEAT ASSIGNMENT\",\"serviceType\":\"INC\"},{\"serviceName\":\"CARRY ON UP TO 45 LI 115 LCM\",\"serviceType\":\"INC\"},{\"serviceName\":\"CHANGEABLE TICKET\",\"serviceType\":\"INC\"},{\"serviceName\":\"REFUNDABLE TICKET\",\"serviceType\":\"INC\"},{\"serviceName\":\"MILEAGE ACCRUAL\",\"serviceType\":\"INC\"},{\"serviceName\":\"STANDARD SEAT\",\"serviceType\":\"INC\"},{\"serviceName\":\"STANDARD BOARDING\",\"serviceType\":\"INC\"},{\"serviceName\":\"STATUS ACCRUAL\",\"serviceType\":\"INC\"},{\"serviceName\":\"SNACK\",\"serviceType\":\"INC\"},{\"serviceName\":\"INFLIGHT ENT\",\"serviceType\":\"INC\"},{\"serviceName\":\"FIRST BAG 23K 50LB 62LI 158LCM\",\"serviceType\":\"CHA\"},{\"serviceName\":\"SECOND BAG 23K50LB 62LI 158LCM\",\"serviceType\":\"CHA\"},{\"serviceName\":\"UPGRADE ELIGIBILITY\",\"serviceType\":\"CHA\"},{\"serviceName\":\"STANDBY\",\"serviceType\":\"CHA\"},{\"serviceName\":\"PRIORITY BOARDING\",\"serviceType\":\"CHA\"},{\"serviceName\":\"ALCOHOLIC DRINK\",\"serviceType\":\"CHA\"},{\"serviceName\":\"INTERNET ACCESS\",\"serviceType\":\"CHA\"},{\"serviceName\":\"UNACCOMPANIED MINOR\",\"serviceType\":\"CHA\"},{\"serviceName\":\"PRIORITY CHECK IN\",\"serviceType\":\"NOF\"}]}],\"priceDiffrence\":\"680.00\"}],\"ancillaryServices\":[{\"id\":1,\"supplierCode\":\"TAG\",\"supplierApi\":\"API\",\"modelType\":\"YN\",\"priceTypeRoute\":\"T\",\"priceTypePax\":\"F\",\"fullName\":\"Travel Insurance Provided by Travel Guard\",\"shortName\":\"TAG\",\"fareLadderText\":\"Travel Insurance (TG)\",\"title\":\"Travel Insurance Provided by Travel Guard\",\"subTitle\":\"\",\"description\":\"<b>Are you prpared?</b><br/> A Travel Guard travel insurance planover your vaction investment, offset expenses from travel mishaps and provide you with emergency travel assistance.\",\"bttomDescription\":\"I acknowledge that I have read and understand the <a href='https://webservices.travelguard.com/Product/FileRetrieval.aspx?CountryCode=US&StateCode=AL&ProductCode=939502&PlanCode=NW&FileType=PROD_PLAN_GM' target='_blank'><strong>Policy of Insurance</strong></a> and <a href='https://www.travelguard.com/legal/disclaimer' target='_blank'><strong>Important Disclosures</strong></a>, and agree to the terms and conditions of the insurance coverage provided. Available only to residents of U.S. states and the District of Columbia.\",\"yesMessage\":\"YES, add travel insurance for up to $35.83 covering all passengers on this booking. (Available to U.S. Residents only).\",\"noMessage\":\"No, I do not want to insure my trip.\",\"bottomRightImg\":\"tag.png\",\"owServiceText\":[{\"productId\":1,\"name\":\"Deluxe Air Ticket Protection Plan (v2)\",\"mostPopular\":true,\"price\":35.83,\"serviceId\":1}],\"disclosureslink\":\"https://webservices.travelguard.com/Product/FileRetrieval.aspx?CountryCode=US&StateCode=AL&ProductCode=939502&PlanCode=NW&FileType=PROD_PLAN_GM\",\"disclosuresMessage\":\"Coverage is offered by TravelGuard Group, Inc.<b/>and limitations will apllay <a href='https://webservices.travelguard.com/Product/FileRetrieval.aspx?CountryCode=US&StateCode=AL&ProductCode=939502&PlanCode=NW&FileType=PROD_PLAN_GM'>click here</a> for important disclosure\",\"covidMessage\":\"Due to the World Health Organization (WHO) announcement declaring Coronavirus (COVID-19) a pandemic, please note that as of, at the latest, March 11, 2020, COVID-19 is a foreseen event and certain coverages will not apply.   Please go to www.travelguard.com/covid19notification for more details.\",\"covidLink\":\"https://www.travelguard.com/covid19notification\",\"faqLink\":\"https://www.travelguard.com/travel-news/coronavirus-advisory\"},{\"id\":1,\"supplierCode\":\"TAS\",\"supplierApi\":\"Internal\",\"modelType\":\"MC\",\"priceTypeRoute\":\"T\",\"priceTypePax\":\"F\",\"fullName\":\"Travel Assist\",\"shortName\":\"TAS\",\"fareLadderText\":\"Travel Assist\",\"title\":\"Travel Assist\",\"titleImgRight\":\"tas.png\",\"description\":\"Enhance your level of customer service that suit your needs! Don't let the stress of traveling take the fun out of your trip. Fly with enhanced peace of mind and upgrade your service level.\",\"bttomDescription\":\"\",\"services\":[{\"productId\":1,\"name\":\"Exchange & Refund Processing Fee\",\"serviceId\":1,\"position\":1,\"showType\":\"S\"},{\"productId\":1,\"name\":\"Schedule Change Handling\",\"serviceId\":1,\"position\":2,\"showType\":\"S\"},{\"productId\":1,\"name\":\"24 Hours Cancellation\",\"serviceId\":1,\"position\":3,\"showType\":\"S\"},{\"productId\":1,\"name\":\"Dedicated Customer Service, Jump Ahead the Phone Queue Mobile flight alerts Speedy Refunds\",\"serviceId\":1,\"position\":4,\"showType\":\"S\"}],\"owServiceText\":[{\"productId\":1,\"name\":\"Basic\",\"mostPopular\":false,\"price\":0.0,\"conditionList\":[{\"productId\":1,\"name\":\"$150\",\"serviceId\":1,\"position\":1,\"showType\":\"S\"},{\"productId\":1,\"name\":\"$50\",\"serviceId\":1,\"position\":2,\"showType\":\"S\"},{\"productId\":1,\"name\":\"$50\",\"serviceId\":1,\"position\":3,\"showType\":\"S\"},{\"productId\":1,\"name\":\"\",\"serviceId\":1,\"position\":4,\"showType\":\"S\"}],\"serviceId\":1},{\"productId\":1,\"name\":\"Standard\",\"mostPopular\":false,\"price\":29.95,\"conditionList\":[{\"productId\":1,\"name\":\"$50\",\"serviceId\":1,\"position\":1,\"showType\":\"S\"},{\"productId\":1,\"name\":\"$25\",\"serviceId\":1,\"position\":2,\"showType\":\"S\"},{\"productId\":1,\"name\":\"Check-Sign\",\"serviceId\":1,\"position\":3,\"showType\":\"S\"},{\"productId\":1,\"name\":\"Check-Sign\",\"serviceId\":1,\"position\":4,\"showType\":\"S\"}],\"serviceId\":1},{\"productId\":1,\"name\":\"Plus\",\"mostPopular\":false,\"price\":49.95,\"conditionList\":[{\"productId\":1,\"name\":\"Free\",\"serviceId\":1,\"position\":1,\"showType\":\"S\"},{\"productId\":1,\"name\":\"Free\",\"serviceId\":1,\"position\":2,\"showType\":\"S\"},{\"productId\":1,\"name\":\"Check-Sign\",\"serviceId\":1,\"position\":3,\"showType\":\"S\"},{\"productId\":1,\"serviceId\":1,\"position\":4,\"showType\":\"S\"}],\"serviceId\":1}],\"disclosureslink\":\"/link\",\"disclosuresMessage\":\"\"},{\"id\":1,\"supplierCode\":\"PDP\",\"supplierApi\":\"Internal\",\"modelType\":\"YN\",\"priceTypeRoute\":\"T\",\"priceTypePax\":\"F\",\"fullName\":\"Price Drop Protection\",\"shortName\":\"PDP\",\"fareLadderText\":\"Price Drop Protection\",\"title\":\"Price Drop Protection\",\"titleImgLeft\":\"pdp.png\",\"subTitle\":\"\",\"description\":\"Get the opportunity for money back with our Price Drop Protection.\",\"bttomDescription\":\"Learn More\",\"services\":[{\"productId\":1,\"name\":\"We'll automatically check for price drops for 24 hours after you book.\",\"serviceId\":1,\"position\":1,\"showType\":\"B\"},{\"productId\":1,\"name\":\"If price drop, we'll share those savings with you.\",\"serviceId\":1,\"position\":2,\"showType\":\"B\"}],\"yesMessage\":\"Add Product\",\"owServiceText\":[{\"productId\":1,\"name\":\"PDP\",\"mostPopular\":true,\"price\":5.45,\"serviceId\":1}]}]}";
			//String fareRules = "{\"ancillaryServices\": [{\"id\": 1,\"supplierCode\": \"TAG\",\"supplierApi\": \"API\",\"modelType\": \"YN\",\"priceTypeRoute\": \"T\",\"priceTypePax\": \"F\",\"fullName\": \"Travel Insurance Provided by Travel Guard\",\"shortName\": \"TAG\",\"fareLadderText\": \"Travel Insurance (TG)\",\"title\": \"Travel Insurance Provided by Travel Guard\",\"subTitle\": \"\",\"description\": \"<b>Are you prpared?</b><br/> A Travel Guard travel insurance planover your vaction investment, offset expenses from travel mishaps and provide you with emergency travel assistance.\",\"bttomDescription\": \"I have read and understand the Policy of Insurance and Important Disclosures, and agree to the terms and conditions of the insurance coverage provided. Offer is available only to residents of U.S States and District of Columbia\",\"yesMessage\": \"YES, add travel insurance for up to $13.25 covering all passengers on this booking. Available to US residents only.\",\"noMessage\": \"No, I do not want to insure my trip.\",\"bottomRightImg\": \"tag.png\",\"owServiceText\": [{\"productId\": 1,\"name\": \"Basic\",\"mostPopular\": true,\"price\": 34,\"serviceId\": 1}],\"disclosureslink\": \"https://webservices.travelguard.com/Product/FileRetrieval.aspx?CountryCode=US&StateCode=AL&ProductCode=939502&PlanCode=NW&FileType=PROD_PLAN_GM\",\"disclosuresMessage\": \"Coverage is offered by TravelGuard Group, Inc.<b/>and limitations will apllay <a href='https://webservices.travelguard.com/Product/FileRetrieval.aspx?CountryCode=US&StateCode=AL&ProductCode=939502&PlanCode=NW&FileType=PROD_PLAN_GM'>click here</a> for important disclosure\",\"covidMessage\": \"Covid wording:COVID-19 is a foreseen event and certain coverages will not apply. Please read the details here.\",\"covidLink\": \"https://www.travelguard.com/covid19notification\",\"faqLink\": \"https://www.travelguard.com/travel-news/coronavirus-advisory\"},{\"id\": 1,\"supplierCode\": \"TAS\",\"supplierApi\": \"Internal\",\"modelType\": \"MC\",\"priceTypeRoute\": \"T\",\"priceTypePax\": \"F\",\"fullName\": \"Travel Assist\",\"shortName\": \"TAS\",\"fareLadderText\": \"Travel Assist\",\"title\": \"Travel Assist\",\"titleImgRight\": \"tas.png\",\"subTitle\": \"Every passenger has different support needs - pick the package that suits your needs.\",\"description\": \"Every passenger has different support needs - pick the package that suits your needs.\",\"bttomDescription\": \"\",\"services\": [{\"productId\": 1,\"name\": \"Cancellation Fee\",\"serviceId\": 1,\"position\": 1,\"showType\": \"S\"},{\"productId\": 1,\"name\": \"Response Time\",\"serviceId\": 1,\"position\": 2,\"showType\": \"S\"},{\"productId\": 1,\"name\": \"Rescheduling Help\",\"serviceId\": 1,\"position\": 3,\"showType\": \"S\"}],\"owServiceText\": [{\"productId\": 1,\"name\": \"Basic\",\"mostPopular\": false,\"price\": 0,\"conditionList\": [{\"productId\": 1,\"name\": \"Fees apply\",\"serviceId\": 1,\"position\": 1,\"showType\": \"S\"},{\"productId\": 1,\"name\": \"Fees apply\",\"serviceId\": 1,\"position\": 2,\"showType\": \"S\"},{\"productId\": 1,\"name\": \"Fees apply\",\"serviceId\": 1,\"position\": 3,\"showType\": \"S\"}],\"serviceId\": 1},{\"productId\": 1,\"name\": \"Standard\",\"mostPopular\": false,\"price\": 0,\"conditionList\": [{\"productId\": 1,\"name\": \"Fees apply\",\"serviceId\": 1,\"position\": 1,\"showType\": \"S\"},{\"productId\": 1,\"name\": \"Fees apply\",\"serviceId\": 1,\"position\": 2,\"showType\": \"S\"},{\"productId\": 1,\"name\": \"Fees apply\",\"serviceId\": 1,\"position\": 3,\"showType\": \"S\"}],\"serviceId\": 1},{\"productId\": 1,\"name\": \"Standard\",\"mostPopular\": false,\"price\": 0,\"conditionList\": [{\"productId\": 1,\"name\": \"Fees apply\",\"serviceId\": 1,\"position\": 1,\"showType\": \"S\"},{\"productId\": 1,\"name\": \"Fees apply\",\"serviceId\": 1,\"position\": 2,\"showType\": \"S\"},{\"productId\": 1,\"name\": \"Fees apply\",\"serviceId\": 1,\"position\": 3,\"showType\": \"S\"}],\"serviceId\": 1}],\"disclosureslink\": \"/link\",\"disclosuresMessage\": \"\"}],\"bagRecheckReq\": false,\"eurtogbp\": 0,\"eurtousd\": 0,\"fare\": {\"adultFare\": 199.06,\"childFare\": 0,\"infantFare\": 0,\"infantWsFare\": 0,\"adultTax\": 44.13,\"childTax\": 0,\"infantTax\": 0,\"infantWsTax\": 0,\"adultMarkup\": 0.01,\"childMarkup\": 0,\"infantMarkup\": 0,\"infantWsMarkup\": 0,\"bagFees\": 0,\"grandTotal\": 243.2,\"totalMarkup\": 0.01,\"grandOrgTotal\": 243.19,\"baseFare\": 199.06,\"totalTax\": 44.14,\"tbo_baseFare\": 0,\"tbo_totalTax\": 0,\"markupType\": \"US\"},\"fareFamily\": [{\"familyNames\": [\"BASIC\",\"BASIC\"],\"classOfServices\": [\"B\",\"B\"],\"fareFamilyDescription\": [{\"rateCategory\": \"BASIC\",\"description\": \"BASIC ECONOMY\",\"serviceInformation\": [{\"serviceName\": \"PERSONAL ITEMUP TO 40 LI\",\"serviceType\": \"INC\"},{\"serviceName\": \"CARRY ON UP TO 45 LI 115 LCM\",\"serviceType\": \"INC\"},{\"serviceName\": \"SAME DAY STANDBY\",\"serviceType\": \"INC\"},{\"serviceName\": \"AADVANTAGE MILES\",\"serviceType\": \"INC\"},{\"serviceName\": \"IN FLIGHT ENTERTAINMENT\",\"serviceType\": \"INC\"},{\"serviceName\": \"STREAMING VIDEO\",\"serviceType\": \"INC\"},{\"serviceName\": \"FIRST CHECKED BAG\",\"serviceType\": \"CHA\"},{\"serviceName\": \"SECOND CHECKED BAG\",\"serviceType\": \"CHA\"},{\"serviceName\": \"THIRD CHECKED BAG\",\"serviceType\": \"CHA\"},{\"serviceName\": \"SAME DAY CHANGE\",\"serviceType\": \"CHA\"},{\"serviceName\": \"ADMIRALS CLUB\",\"serviceType\": \"CHA\"},{\"serviceName\": \"PREMIUM BEVERAGE\",\"serviceType\": \"CHA\"},{\"serviceName\": \"MEAL OR SNACK\",\"serviceType\": \"CHA\"},{\"serviceName\": \"WI FI\",\"serviceType\": \"CHA\"},{\"serviceName\": \"PRE RESERVED SEATS\",\"serviceType\": \"CHA\"},{\"serviceName\": \" PRIORITY BOARDING\",\"serviceType\": \"CHA\"},{\"serviceName\": \"CHANGEABLE TICKET\",\"serviceType\": \"NOF\"},{\"serviceName\": \"REFUNDABLE TICKET\",\"serviceType\": \"NOF\"},{\"serviceName\": \"PRIORITY CHECKIN\",\"serviceType\": \"NOF\"},{\"serviceName\": \"BASIC SEAT\",\"serviceType\": \"NOF\"},{\"serviceName\": \"STANDARD BOARDING\",\"serviceType\": \"NOF\"}]}]},{\"familyNames\": [\"MAIN\",\"MAIN\"],\"classOfServices\": [\"O\",\"O\"],\"fareFamilyDescription\": [{\"rateCategory\": \"MAIN\",\"description\": \"MAIN CABIN\",\"serviceInformation\": [{\"serviceName\": \"PERSONAL ITEMUP TO 40 LI\",\"serviceType\": \"INC\"},{\"serviceName\": \"CARRY ON UP TO 45 LI 115 LCM\",\"serviceType\": \"INC\"},{\"serviceName\": \"SAME DAY STANDBY\",\"serviceType\": \"INC\"},{\"serviceName\": \"CHANGEABLE TICKET\",\"serviceType\": \"INC\"},{\"serviceName\": \"AADVANTAGE MILES\",\"serviceType\": \"INC\"},{\"serviceName\": \"IN FLIGHT ENTERTAINMENT\",\"serviceType\": \"INC\"},{\"serviceName\": \"STREAMING VIDEO\",\"serviceType\": \"INC\"},{\"serviceName\": \"BASIC SEAT\",\"serviceType\": \"INC\"},{\"serviceName\": \"PRE RESERVED SEATS\",\"serviceType\": \"INC\"},{\"serviceName\": \"STANDARD BOARDING\",\"serviceType\": \"INC\"},{\"serviceName\": \"FIRST CHECKED BAG\",\"serviceType\": \"CHA\"},{\"serviceName\": \"SECOND CHECKED BAG\",\"serviceType\": \"CHA\"},{\"serviceName\": \"THIRD CHECKED BAG\",\"serviceType\": \"CHA\"},{\"serviceName\": \"SAME DAY CHANGE\",\"serviceType\": \"CHA\"},{\"serviceName\": \"PRIORITY CHECKIN\",\"serviceType\": \"CHA\"},{\"serviceName\": \"ADMIRALS CLUB\",\"serviceType\": \"CHA\"},{\"serviceName\": \"PREMIUM BEVERAGE\",\"serviceType\": \"CHA\"},{\"serviceName\": \"MEAL OR SNACK\",\"serviceType\": \"CHA\"},{\"serviceName\": \"WI FI\",\"serviceType\": \"CHA\"},{\"serviceName\": \"MAIN CABIN EXTRA\",\"serviceType\": \"CHA\"},{\"serviceName\": \"EXTRA LEG ROOM\",\"serviceType\": \"CHA\"},{\"serviceName\": \" PRIORITY BOARDING\",\"serviceType\": \"CHA\"},{\"serviceName\": \"REFUNDABLE TICKET\",\"serviceType\": \"NOF\"}]}]},{\"familyNames\": [\"MAIN\",\"MAINFL\"],\"classOfServices\": [\"O\",\"O\"],\"fareFamilyDescription\": [{\"rateCategory\": \"MAIN\",\"description\": \"MAIN CABIN\",\"serviceInformation\": [{\"serviceName\": \"PERSONAL ITEMUP TO 40 LI\",\"serviceType\": \"INC\"},{\"serviceName\": \"CARRY ON UP TO 45 LI 115 LCM\",\"serviceType\": \"INC\"},{\"serviceName\": \"SAME DAY STANDBY\",\"serviceType\": \"INC\"},{\"serviceName\": \"CHANGEABLE TICKET\",\"serviceType\": \"INC\"},{\"serviceName\": \"AADVANTAGE MILES\",\"serviceType\": \"INC\"},{\"serviceName\": \"IN FLIGHT ENTERTAINMENT\",\"serviceType\": \"INC\"},{\"serviceName\": \"STREAMING VIDEO\",\"serviceType\": \"INC\"},{\"serviceName\": \"BASIC SEAT\",\"serviceType\": \"INC\"},{\"serviceName\": \"PRE RESERVED SEATS\",\"serviceType\": \"INC\"},{\"serviceName\": \"STANDARD BOARDING\",\"serviceType\": \"INC\"},{\"serviceName\": \"FIRST CHECKED BAG\",\"serviceType\": \"CHA\"},{\"serviceName\": \"SECOND CHECKED BAG\",\"serviceType\": \"CHA\"},{\"serviceName\": \"THIRD CHECKED BAG\",\"serviceType\": \"CHA\"},{\"serviceName\": \"SAME DAY CHANGE\",\"serviceType\": \"CHA\"},{\"serviceName\": \"PRIORITY CHECKIN\",\"serviceType\": \"CHA\"},{\"serviceName\": \"ADMIRALS CLUB\",\"serviceType\": \"CHA\"},{\"serviceName\": \"PREMIUM BEVERAGE\",\"serviceType\": \"CHA\"},{\"serviceName\": \"MEAL OR SNACK\",\"serviceType\": \"CHA\"},{\"serviceName\": \"WI FI\",\"serviceType\": \"CHA\"},{\"serviceName\": \"MAIN CABIN EXTRA\",\"serviceType\": \"CHA\"},{\"serviceName\": \"EXTRA LEG ROOM\",\"serviceType\": \"CHA\"},{\"serviceName\": \" PRIORITY BOARDING\",\"serviceType\": \"CHA\"},{\"serviceName\": \"REFUNDABLE TICKET\",\"serviceType\": \"NOF\"}]}]},{\"familyNames\": [\"MAINFL\",\"MAIN\"],\"classOfServices\": [\"O\",\"O\"],\"fareFamilyDescription\": [{\"rateCategory\": \"MAINFL\",\"description\": \"MAIN CABIN FLEXIBLE\",\"serviceInformation\": [{\"serviceName\": \"PERSONAL ITEMUP TO 40 LI\",\"serviceType\": \"INC\"},{\"serviceName\": \"CARRY ON UP TO 45 LI 115 LCM\",\"serviceType\": \"INC\"},{\"serviceName\": \"SAME DAY STANDBY\",\"serviceType\": \"INC\"},{\"serviceName\": \"CHANGEABLE TICKET\",\"serviceType\": \"INC\"},{\"serviceName\": \"REFUNDABLE TICKET\",\"serviceType\": \"INC\"},{\"serviceName\": \"AADVANTAGE MILES\",\"serviceType\": \"INC\"},{\"serviceName\": \"IN FLIGHT ENTERTAINMENT\",\"serviceType\": \"INC\"},{\"serviceName\": \"STREAMING VIDEO\",\"serviceType\": \"INC\"},{\"serviceName\": \"BASIC SEAT\",\"serviceType\": \"INC\"},{\"serviceName\": \"PRE RESERVED SEATS\",\"serviceType\": \"INC\"},{\"serviceName\": \"STANDARD BOARDING\",\"serviceType\": \"INC\"},{\"serviceName\": \"FIRST CHECKED BAG\",\"serviceType\": \"CHA\"},{\"serviceName\": \"SECOND CHECKED BAG\",\"serviceType\": \"CHA\"},{\"serviceName\": \"THIRD CHECKED BAG\",\"serviceType\": \"CHA\"},{\"serviceName\": \"SAME DAY CHANGE\",\"serviceType\": \"CHA\"},{\"serviceName\": \"PRIORITY CHECKIN\",\"serviceType\": \"CHA\"},{\"serviceName\": \"ADMIRALS CLUB\",\"serviceType\": \"CHA\"},{\"serviceName\": \"PREMIUM BEVERAGE\",\"serviceType\": \"CHA\"},{\"serviceName\": \"MEAL OR SNACK\",\"serviceType\": \"CHA\"},{\"serviceName\": \"WI FI\",\"serviceType\": \"CHA\"},{\"serviceName\": \"MAIN CABIN EXTRA\",\"serviceType\": \"CHA\"},{\"serviceName\": \"EXTRA LEG ROOM\",\"serviceType\": \"CHA\"},{\"serviceName\": \" PRIORITY BOARDING\",\"serviceType\": \"CHA\"}]}]},{\"familyNames\": [\"MAINFL\",\"MAINFL\"],\"classOfServices\": [\"O\",\"O\"],\"fareFamilyDescription\": [{\"rateCategory\": \"MAINFL\",\"description\": \"MAIN CABIN FLEXIBLE\",\"serviceInformation\": [{\"serviceName\": \"PERSONAL ITEMUP TO 40 LI\",\"serviceType\": \"INC\"},{\"serviceName\": \"CARRY ON UP TO 45 LI 115 LCM\",\"serviceType\": \"INC\"},{\"serviceName\": \"SAME DAY STANDBY\",\"serviceType\": \"INC\"},{\"serviceName\": \"CHANGEABLE TICKET\",\"serviceType\": \"INC\"},{\"serviceName\": \"REFUNDABLE TICKET\",\"serviceType\": \"INC\"},{\"serviceName\": \"AADVANTAGE MILES\",\"serviceType\": \"INC\"},{\"serviceName\": \"IN FLIGHT ENTERTAINMENT\",\"serviceType\": \"INC\"},{\"serviceName\": \"STREAMING VIDEO\",\"serviceType\": \"INC\"},{\"serviceName\": \"BASIC SEAT\",\"serviceType\": \"INC\"},{\"serviceName\": \"PRE RESERVED SEATS\",\"serviceType\": \"INC\"},{\"serviceName\": \"STANDARD BOARDING\",\"serviceType\": \"INC\"},{\"serviceName\": \"FIRST CHECKED BAG\",\"serviceType\": \"CHA\"},{\"serviceName\": \"SECOND CHECKED BAG\",\"serviceType\": \"CHA\"},{\"serviceName\": \"THIRD CHECKED BAG\",\"serviceType\": \"CHA\"},{\"serviceName\": \"SAME DAY CHANGE\",\"serviceType\": \"CHA\"},{\"serviceName\": \"PRIORITY CHECKIN\",\"serviceType\": \"CHA\"},{\"serviceName\": \"ADMIRALS CLUB\",\"serviceType\": \"CHA\"},{\"serviceName\": \"PREMIUM BEVERAGE\",\"serviceType\": \"CHA\"},{\"serviceName\": \"MEAL OR SNACK\",\"serviceType\": \"CHA\"},{\"serviceName\": \"WI FI\",\"serviceType\": \"CHA\"},{\"serviceName\": \"MAIN CABIN EXTRA\",\"serviceType\": \"CHA\"},{\"serviceName\": \"EXTRA LEG ROOM\",\"serviceType\": \"CHA\"},{\"serviceName\": \" PRIORITY BOARDING\",\"serviceType\": \"CHA\"}]}]}],\"flightChecked\": true,\"flightInvalid\": false,\"gbptousd\": 0,\"perPaxLuggageOptions\": false,\"priceChange\": false,\"responseStatus\": {\"status\": 1,\"messege\": \"success\"}}";
			String fareRules= flightService.getFlightFareRules(checkRules);

			System.out.println("FlightPaymentPageOne::Direct Payment FareRules Response:: "+fareRules);

			bookingRequest.setFlightResult(selectedflight);
			bookingRequest.setAdults(searchRequest.getAdults());
			bookingRequest.setChild(searchRequest.getChild());
			bookingRequest.setInfants(searchRequest.getInfants());
			bookingRequest.setInfantsWs(searchRequest.getInfantsWs());
			bookingRequest.setSearchID(searchRequest.getSearchID());
			bookingRequest.setSiteID(searchRequest.getSiteId());
			bookingRequest.setProdID("1");
			bookingRequest.setBookingID("0");
			bookingRequest.setUserSessionID(searchId);
			bookingRequest.setCurrencyCode(currency);
			bookingRequest.setBrowser(searchRequest.getBrowser());
			bookingRequest.setTravelGuardCost(0.00);  // Set default 0.00
			//bookingRequest.setTcpCost(20.00);

			CheckFareRulesResponse checkRulesResponse = null;
			try 
			{
				checkRulesResponse = mapper.readValue(fareRules, CheckFareRulesResponse.class);
			} catch (IOException e) {
				e.printStackTrace();
			}

			String anclrStr = "";

			try
			{
				anclrStr = mapper.writeValueAsString(checkRulesResponse.getAncillaryServices());
			}catch(Exception e){}

			//System.out.println("FlightPaymentPageOne:: anclrStr"+anclrStr);

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

			String fareFamilyStr = "";
			List<FareFamily> fareFamilyList = null;
			try
			{
				fareFamilyStr = mapper.writeValueAsString(checkRulesResponse.getFareFamily());
			}catch(Exception e){}

			try
			{
				fareFamilyList = mapper.readValue(fareFamilyStr.toString(), new TypeReference<List<FareFamily>>(){});
			}catch (Exception e) {}

			try
			{
				System.out.println("FareFamilyList:: "+new ObjectMapper().writeValueAsString(fareFamilyList));
			}catch (Exception e) {}

			int familySize=0;
			try{
				familySize= fareFamilyList.size();
			}catch(Exception e){
				familySize=0;
			}

			List<FareFamily> fareFamilyListNew = new ArrayList<FareFamily>();
			FareFamily fareObject = new FareFamily();

			if(familySize>0){
				for (int f = 0; f < familySize; f++) {
					//System.out.println("############["+(f+1)+"] Start ##############");
					if(fareFamilyList.get(f).getFamilyNames().size()>1){
						if(fareFamilyList.get(f).getFamilyNames().get(0).equals(fareFamilyList.get(f).getFamilyNames().get(1))){

							System.out.println("["+(f+1)+"] Match Start ======>>"+fareFamilyList.get(f).getFamilyNames().get(0)+"======"+fareFamilyList.get(f).getFamilyNames().get(1));
							fareObject = fareFamilyList.get(f);
							//fareFamilyListNew = Arrays.asList(fareObject);
							fareFamilyListNew.add(fareObject);
							//System.out.println("############["+(f+1)+"] Match End ##############");
						}
					}else{
						System.out.println("["+(f+1)+"] Match Start ======>>"+fareFamilyList.get(f).getFamilyNames().get(0));
						fareObject = fareFamilyList.get(f);
						//fareFamilyListNew = Arrays.asList(fareObject);
						fareFamilyListNew.add(fareObject);
					}
					//System.out.println("############["+(f+1)+"] End ##############");
					bookingRequest.setFareFamily(fareFamilyListNew);
				}
			}

			try
			{
				System.out.println("FareFamilyListNew:: "+new ObjectMapper().writeValueAsString(bookingRequest.getFareFamily()));
			}catch (Exception e) {}

			//bookingRequest.setFareFamily(fareFamilyList);
			bookingRequest.setFreeTextLines(checkRulesResponse.getFreeTextLines());

			List<PassengerDetail> passengerDetails=new ArrayList<PassengerDetail>();
			int travelerNo=0;
			for (int i = 0; i < searchRequest.getAdults(); i++) {
				PassengerDetail paxDetail=new PassengerDetail();
				paxDetail.setPassengerType(1);
				passengerDetails.add(paxDetail);
				travelerNo++;
			}
			for (int i = 0; i < searchRequest.getChild(); i++) {
				PassengerDetail paxDetail=new PassengerDetail();
				paxDetail.setPassengerType(2);
				passengerDetails.add(paxDetail);
				travelerNo++;
			}
			for (int i = 0; i < searchRequest.getInfants(); i++) {
				PassengerDetail paxDetail=new PassengerDetail();
				paxDetail.setPassengerType(3);
				passengerDetails.add(paxDetail);
				travelerNo++;
			}
			for (int i = 0; i < searchRequest.getInfantsWs(); i++) {
				PassengerDetail paxDetail=new PassengerDetail();
				paxDetail.setPassengerType(4);
				passengerDetails.add(paxDetail);
				travelerNo++;
			}

			bookingRequest.setPassengerDetails(passengerDetails);

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
		/* for (int i = 0; i < longMonths.length-1; i++) {
		        String longMonth = longMonths[i];
		        cardMonth.add(longMonth);
		    }*/
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
			System.out.println(" FlightPaymentPageOne:: Direct Booking Request For Payment:: "+mapper.writeValueAsString(bookingRequest));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ModelAndView mv = new ModelAndView("/flight/payment/flight_info", "model", model);

		request.getSession().setAttribute("bookingRequest", bookingRequest);
		request.getSession().setAttribute("selectedflight", selectedflight);
		model.addAttribute("searchRequest", searchRequest);
		model.addAttribute("bookingRequest", bookingRequest);
		mv.addObject("bookingRequest", bookingRequest);
		//model.addAttribute("bookingWrapper", bookingRequest);
		mv.addObject("bookingWrapper", bookingRequest);

		return mv;
	}

	@RequestMapping(value = "/payment/billing/{searchId}/{resultId}", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView FlightPaymentPageTwo(@PathVariable String searchId, @PathVariable String resultId, @ModelAttribute("bookingWrapper") BookingRequest bookingRequest, Model model, HttpServletRequest request)
	{
		System.out.println(" FlightPaymentPageTwo Method Calling :: searchId"+searchId+" && resultId"+resultId);

		FlightResult selectedflight=(FlightResult) request.getSession().getAttribute("selectedflight");
		FlightRequest searchRequest = (FlightRequest) request.getSession().getAttribute("flightRequest");
		ObjectMapper mapper = new ObjectMapper();
		try 
		{
			System.out.println("FlightPaymentPageTwo::SearchRequest From Session:: "+mapper.writeValueAsString(searchRequest));
			System.out.println("FlightPaymentPageTwo::SelectedFlight From Session:: "+mapper.writeValueAsString(selectedflight));
			System.out.println("FlightPaymentPageTwo::Booking Request From Session:: "+mapper.writeValueAsString(bookingRequest));
		} 
		catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("FlightPaymentPageTwo:: searchRequest.getSearchID()::"+searchRequest.getSearchID());

		int fareFamilySize=0;
		try
		{
			fareFamilySize = bookingRequest.getFareFamily().size();
		}catch(Exception e){
			fareFamilySize=0;
		}

		System.out.println("FareFamilySize>>"+fareFamilySize);
		System.out.println("UpgradeTaken>>"+bookingRequest.getUpgradeTaken());
		System.out.println("UpgradeAmount>>"+bookingRequest.getUpgradeAmount());
		System.out.println("UpgradePlan>>"+bookingRequest.getUpgradePlan());

		List<FareFamily> fareFamily = new ArrayList<FareFamily>();
		if(fareFamilySize>0){
			for (int i = 0; i < fareFamilySize; i++) {
				System.out.println("Description:: "+bookingRequest.getFareFamily().get(i).getFareFamilyDescription().get(0).getDescription());
				if(bookingRequest.getFareFamily().get(i).getFareFamilyDescription().get(0).getDescription().contains(bookingRequest.getUpgradePlan())){
					System.out.println(" Contain >> "+bookingRequest.getUpgradePlan()); 
					fareFamily = Arrays.asList(bookingRequest.getFareFamily().get(i));
					selectedflight.setFareFamily(fareFamily); 
					break;
				}
			}
		}

		int ff=0;
		try {
			if(fareFamilySize>0){
				for (int i = 0; i < selectedflight.getOutBound().size(); i++) {
					System.out.println("Out ClassOfServices["+(i+1)+"]"+selectedflight.getFareFamily().get(0).getClassOfServices().get(ff).toString());
					selectedflight.getOutBound().get(i).setResDesignCode(selectedflight.getFareFamily().get(0).getClassOfServices().get(ff).toString());
					ff=ff+1;
				}

				for (int i = 0; i < selectedflight.getInBound().size(); i++) {
					System.out.println("In ClassOfServices["+(i+1)+"]"+selectedflight.getFareFamily().get(0).getClassOfServices().get(ff).toString());
					selectedflight.getInBound().get(i).setResDesignCode(selectedflight.getFareFamily().get(0).getClassOfServices().get(ff).toString());
					ff=ff+1;
				}
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			//e2.printStackTrace();
		}


		//bookingRequest.setFlightResult(selectedflight); Before 010042023
		// Now 010042023

		selectedflight = bookingRequest.getFlightResult();
		bookingRequest.setFlightResult(selectedflight);

		bookingRequest.setAdults(searchRequest.getAdults());
		bookingRequest.setChild(searchRequest.getChild());
		bookingRequest.setInfants(searchRequest.getInfants());
		bookingRequest.setInfantsWs(searchRequest.getInfantsWs());
		bookingRequest.setSearchID(searchRequest.getSearchID());
		bookingRequest.setSiteID(searchRequest.getSiteId());
		bookingRequest.setBookingID("0"); 
		bookingRequest.setUserSessionID(searchRequest.getSearchID());


		try 
		{
			//System.out.println("FlightPaymentPageTwo::SearchRequest From Session:: "+mapper.writeValueAsString(searchRequest));
			System.out.println("FlightPaymentPageTwo::SelectedFlight From Session 11111111 :: "+mapper.writeValueAsString(selectedflight));
			//System.out.println("FlightPaymentPageTwo::Booking Request From Session:: "+mapper.writeValueAsString(bookingRequest));
		} 
		catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<String> cardMonth = new ArrayList<String>(); 
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

		ArrayList<String> cardyear = new ArrayList<String>(); 
		int years = Calendar.getInstance().get(Calendar.YEAR);
		cardyear.add("Year");
		for (int i = years; i < (years+50); i++) {
			cardyear.add(String.valueOf(i));
		}

		HashMap<String, ArrayList<String>> models = new HashMap<String, ArrayList<String>>();  
		models.put("cardyear", cardyear); 
		models.put("cardMonth", cardMonth);
		models.put("cardtype", cardtype);
		model.mergeAttributes(models);

		try 
		{
			System.out.println("FlightPaymentPageTwo::Booking Request To Billing Page:: "+mapper.writeValueAsString(bookingRequest));
		} 
		catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/********* TG Work Start ***********/

		double insPrice = 0.00;
		try
		{
			TGResponse tgResponse = flightService.getTravelInsurance(bookingRequest, searchRequest);
			try
			{	
				if(tgResponse.getBaseResponse().getStatus()==1){

					insPrice = Double.valueOf(tgResponse.getResponse().get(0).getPurchaseRequest().getProductDetails().get(0).getAmounts().get(0).getAmountValues().get(0).getValue());
					bookingRequest.setTravelGuardCost(insPrice);
					bookingRequest.setTgProductCode(tgResponse.getResponse().get(0).getPurchaseRequest().getProductDetails().get(0).getProductCode());
					bookingRequest.setTgProductName(tgResponse.getResponse().get(0).getPurchaseRequest().getProductDetails().get(0).getProductName());
					bookingRequest.setTgPlanCode(tgResponse.getResponse().get(0).getPurchaseRequest().getProductDetails().get(0).getPlanCode());
				}
				else{
					insPrice = 0.00;
					bookingRequest.setTravelGuardCost(insPrice); 
					bookingRequest.setTgProductCode("");
					bookingRequest.setTgProductName("");
					bookingRequest.setTgPlanCode("");
				}
			}catch(Exception e){

			}
		}
		catch(Exception e){
			System.out.println(" Error In GetTravelInsurance Service "); 
			e.printStackTrace();
		}


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

		System.out.println("Device::"+device);

		ModelAndView mv = new ModelAndView("/flight/payment/flight_billing", "model", model);

		request.getSession().setAttribute("bookingRequest", bookingRequest);
		request.getSession().setAttribute("selectedflight", selectedflight);
		model.addAttribute("searchRequest", searchRequest);
		model.addAttribute("bookingRequest", bookingRequest);
		mv.addObject("bookingRequest", bookingRequest);
		mv.addObject("bookingWrapper", bookingRequest);
		model.addAttribute("device", device);

		return mv;
	}

	@SuppressWarnings("unchecked")
	@PostMapping("/flight/payment/confirm")
	public ModelAndView flightPaymentMid(@ModelAttribute("bookingWrapper") BookingRequest bookingRequest, HttpServletRequest request, Model model){

		System.out.println("<<<<<<<< FlightPaymentMid Calling >>>>>>>");

		ModelAndView mv = new ModelAndView("/flightmid", "model", model);

		FlightResult selectedflight=(FlightResult) request.getSession().getAttribute("selectedflight");
		FlightRequest searchRequest = (FlightRequest) request.getSession().getAttribute("flightRequest");
		ObjectMapper mapper = new ObjectMapper();

		Map<String, Object> modelMap = model.asMap();
		BookingRequest bookingWrapper = (BookingRequest) modelMap.get("bookingWrapper");
		try 
		{
			System.out.println("FlightPaymentMid::SearchRequest From Session:: "+mapper.writeValueAsString(searchRequest));
			System.out.println("FlightPaymentMid::SelectedFlight From Session:: "+mapper.writeValueAsString(selectedflight));
			System.out.println("FlightPaymentMid::Booking Request From Session:: "+mapper.writeValueAsString(bookingRequest));
			System.out.println("FlightPaymentMid::BookingWrapper Request From Session:: "+mapper.writeValueAsString(bookingWrapper));
		} 
		catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*selectedflight.setFareFamily(fareRulesObj.getFareFamily().get(fareRulesObj.getFareFamily().size()-1));

		int ff=0;

		 for (int i = 0; i < selectedflight.getOutBound().size(); i++) {
			 selectedflight.getOutBound().get(i).setResDesignCode(fareRulesObj.getFareFamily().get(fareRulesObj.getFareFamily().size()-1).getClassOfServices().get(ff).toString());
			 ff=ff+1;
		}
		 for (int i = 0; i < selectedflight.getInBound().size(); i++) {
			 selectedflight.getInBound().get(i).setResDesignCode(fareRulesObj.getFareFamily().get(fareRulesObj.getFareFamily().size()-1).getClassOfServices().get(ff).toString());
			 ff=ff+1;
		}*/

		int fareFamilySize=0;
		try
		{
			fareFamilySize = bookingRequest.getFareFamily().size();
		}catch(Exception e){
			fareFamilySize=0;
		}

		List<FareFamily> fareFamilyList = new ArrayList<FareFamily>();
		FareFamily familyObject = new FareFamily();
		if(fareFamilySize>0){
			for (int i = 0; i < fareFamilySize; i++) {
				if(bookingRequest.getFareFamily().get(i).getFareFamilyDescription().get(0).getDescription().contains(bookingRequest.getUpgradePlan())){
					System.out.println(" Contain >> "+bookingRequest.getUpgradePlan()); 
					//fareFamily = (List<FareFamily>) bookingRequest.getFareFamily().get(i);
					familyObject = bookingRequest.getFareFamily().get(i);
					fareFamilyList.add(familyObject);
					selectedflight.setFareFamily(fareFamilyList); 
				}
			}
		}

		bookingRequest.setFlightResult(selectedflight);
		bookingRequest.setAdults(searchRequest.getAdults());
		bookingRequest.setChild(searchRequest.getChild());
		bookingRequest.setInfants(searchRequest.getInfants());
		bookingRequest.setInfantsWs(searchRequest.getInfantsWs());
		bookingRequest.setSearchID(searchRequest.getSearchID());
		bookingRequest.setSiteID(searchRequest.getSiteId());
		bookingRequest.setBookingID("0"); 
		bookingRequest.setUserSessionID(searchRequest.getSearchID());

		try
		{
			System.out.println("TravelGuard Taken:: 11111111111111111 "+bookingRequest.getTravelGuard());
		}catch(Exception e){

		}
		request.getSession().setAttribute("bookingRequest", bookingRequest);
		model.addAttribute("bookingRequest", bookingRequest);
		mv.addObject("bookingRequest", bookingRequest);
		//model.addAttribute("bookingWrapper", bookingRequest);
		mv.addObject("bookingWrapper", bookingRequest);

		return mv;

	}

	@PostMapping("/flight/confirm/{sessionId}/{randomId}")
	public String flightConfirm(@ModelAttribute("bookingWrapper") BookingRequest bookingRequest, @PathVariable String sessionId, @PathVariable String randomId, HttpServletRequest request, Model model){

		System.out.println(" Confirmation To Book Calling..... "); 

		
		FlightRequest searchRequest = (FlightRequest) request.getSession().getAttribute("flightRequest");
		bookingRequest=(BookingRequest) request.getSession().getAttribute("bookingRequest");

		ObjectMapper mapper = new ObjectMapper();
		try 
		{
			System.out.println("FlightConfirm::Booking Request From Session::"+mapper.writeValueAsString(bookingRequest));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		String currencySymbol = "$";
		double currencyValue = 1;
		try{
			currencySymbol = (String) request.getSession().getAttribute("currencySymbol");
			currencyValue = (double) request.getSession().getAttribute("currencyValue");
		}
		catch(Exception e){
			request.getSession().setAttribute("currencySymbol","$");
			request.getSession().setAttribute("currencyValue",1);
		}
		System.out.println("currencyValue >>> " + currencyValue);
		bookingRequest.setCurrencySymbol(currencySymbol);
		bookingRequest.setCurrencyValue(currencyValue);  
		
		
		bookingRequest.setSourceMedia(searchRequest.getSource());
		bookingRequest.setCurrencyCode("USD");
		bookingRequest.setSiteID(searchRequest.getSiteId());

		for (int i = 0; i < bookingRequest.getPassengerDetails().size(); i++) {
			String dateOfBirth = bookingRequest.getPassengerDetails().get(i).getDateOfYear()+"-"+bookingRequest.getPassengerDetails().get(i).getDateOfMonth()+"-"+bookingRequest.getPassengerDetails().get(i).getDobDay();
			bookingRequest.getPassengerDetails().get(i).setDateOfBirth(dateOfBirth);
		}

		bookingRequest.setUserIP(searchRequest.getUserIP());
		bookingRequest.setDevice(searchRequest.getDevice());
		bookingRequest.setDepartDate(searchRequest.getSegment().get(0).getTravelDate());
		bookingRequest.getFlightResult().setGdsType(2);
		bookingRequest.getPaymentDetails().setState(bookingRequest.getPaymentDetails().getState().replace(",", "")); 
		//bookingRequest.getPaymentDetails().setCardNumber("4222222222222222");

		//System.out.println("StateCode::"+bookingRequest.getPaymentDetails().getState());
		//System.out.println("TravelGuardCost:: "+bookingRequest.getTravelGuardCost());
		//System.out.println("TravelGuard Taken:: ########## "+bookingRequest.getTravelGuard());

		if(bookingRequest.getTravelGuard().equalsIgnoreCase("Yes,Yes")){
			bookingRequest.setTravelGuard("Yes"); 
		}

		List<AncillaryProduct> ancillaryProductList = new ArrayList<AncillaryProduct>();

		if(bookingRequest.getTravelGuard().equalsIgnoreCase("Yes")){ 
			List<AncillaryService> anclrList = bookingRequest.getAncillaryServices();
			for (int i = 0; i < anclrList.size(); i++) {
				if(anclrList.get(i).getSupplierCode().contains("TAG"))
				{
					//bookingRequest.getTgProductName();
					//bookingRequest.getTgPlanCode();
					AncillaryProduct ancillariesObj = new AncillaryProduct();
					List<Services> serviceList = new ArrayList<Services>();
					ancillariesObj.setMostPopular(anclrList.get(i).getOwServiceText().get(0).getMostPopular());
					ancillariesObj.setFullName(anclrList.get(i).getFullName());
					ancillariesObj.setName("TAG");
					try {
						ancillariesObj.setPrice(bookingRequest.getTravelGuardCost());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						ancillariesObj.setPrice(0.0);
					}
					ancillariesObj.setProductId(Integer.parseInt(bookingRequest.getTgProductCode()));
					ancillariesObj.setSelectionType("Yes");
					ancillariesObj.setSupplierLookup("");
					ancillariesObj.setSupplierNumber("");
					ancillariesObj.setConditionList(serviceList);
					ancillaryProductList.add(ancillariesObj);
					bookingRequest.setAncillaryProduct(ancillaryProductList);
				}
			}
		}

		System.out.println("TravelAssistTaken"+bookingRequest.getTravelAssistTaken());
		if(bookingRequest.getTravelAssistTaken().equalsIgnoreCase("Yes")){
			List<AncillaryService> anclrList1 = bookingRequest.getAncillaryServices();
			for (int i = 0; i < anclrList1.size(); i++) {
				if(anclrList1.get(i).getSupplierCode().contains("TAS"))
				{
					AncillaryProduct ancillariesObj = new AncillaryProduct();
					List<Services> serviceList = new ArrayList<Services>();
					ancillariesObj.setMostPopular(anclrList1.get(i).getOwServiceText().get(0).getMostPopular());
					ancillariesObj.setFullName(anclrList1.get(i).getFullName());
					ancillariesObj.setName("TAS");
					ancillariesObj.setPrice(bookingRequest.getTravelAssistAmount());
					ancillariesObj.setProductId(anclrList1.get(i).getOwServiceText().get(0).getProductId());
					ancillariesObj.setSelectionType("Yes");
					ancillariesObj.setSupplierLookup("");
					ancillariesObj.setSupplierNumber("");
					ancillariesObj.setConditionList(serviceList);
					ancillaryProductList.add(ancillariesObj);
					bookingRequest.setAncillaryProduct(ancillaryProductList);
				}
			}
		}

		System.out.println("PriceDropTaken"+bookingRequest.getPriceDropTaken());
		if(bookingRequest.getPriceDropTaken().equalsIgnoreCase("Yes")){
			List<AncillaryService> anclrList2 = bookingRequest.getAncillaryServices();
			for (int i = 0; i < anclrList2.size(); i++) {
				if(anclrList2.get(i).getSupplierCode().contains("PDP"))
				{	
					AncillaryProduct ancillariesObj = new AncillaryProduct();
					List<Services> serviceList = new ArrayList<Services>();
					ancillariesObj.setMostPopular(anclrList2.get(i).getOwServiceText().get(0).getMostPopular());
					ancillariesObj.setFullName(anclrList2.get(i).getFullName());
					ancillariesObj.setName("PDP");
					ancillariesObj.setPrice(bookingRequest.getPriceDropAmount());
					ancillariesObj.setProductId(anclrList2.get(i).getOwServiceText().get(0).getProductId());
					ancillariesObj.setSelectionType("Yes");
					ancillariesObj.setSupplierLookup("");
					ancillariesObj.setSupplierNumber("");
					ancillariesObj.setConditionList(serviceList);
					ancillaryProductList.add(ancillariesObj);
					bookingRequest.setAncillaryProduct(ancillaryProductList);
				}
			}
		}

		System.out.println("UpgradeTaken"+bookingRequest.getUpgradeTaken());
		if(bookingRequest.getUpgradeTaken().equalsIgnoreCase("Yes")){
			AncillaryProduct ancillariesObj = new AncillaryProduct();
			List<Services> serviceList = new ArrayList<Services>();
			ancillariesObj.setMostPopular(true);
			ancillariesObj.setFullName(bookingRequest.getUpgradePlan());
			ancillariesObj.setName("UP");
			ancillariesObj.setPrice(bookingRequest.getUpgradeAmount());
			ancillariesObj.setProductId(0);
			ancillariesObj.setSelectionType("Yes");
			ancillariesObj.setSupplierLookup("");
			ancillariesObj.setSupplierNumber("");
			ancillariesObj.setConditionList(serviceList);
			ancillaryProductList.add(ancillariesObj);
			bookingRequest.setAncillaryProduct(ancillaryProductList);
		}

		try 
		{
			System.out.println("FlightConfirm::Booking Request Finally::" + mapper.writeValueAsString(bookingRequest));
		}
		catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}

		// card charge

		String apiUrls = flightAPiUrl+"/BookingProcess?authcode="+password;  
		RestTemplate restTemplate = new RestTemplate();
		String bookingRes = restTemplate.postForObject(apiUrls, bookingRequest, String.class);
		//String bookingRes="{\"bookingID\":\"EB2280\",\"PNR\":\"X\",\"flightResut\":{\"resultID\":4,\"valCarrier\":\"UA\",\"fareType\":\"RP\",\"gdsType\":2,\"cabinClass\":1,\"fare\":{\"adultFare\":53.959999999999994,\"childFare\":0.0,\"infantFare\":0.0,\"infantWsFare\":0.0,\"adultTax\":33.25,\"childTax\":0.0,\"infantTax\":0.0,\"infantWsTax\":0.0,\"adultMarkup\":50.0,\"childMarkup\":0.0,\"infantMarkup\":0.0,\"infantWsMarkup\":0.0,\"bagFees\":0.0,\"grandTotal\":137.20999999999998,\"markupID\":6,\"totalMarkup\":50.0,\"grandOrgTotal\":87.21,\"baseFare\":53.959999999999994,\"totalTax\":83.25,\"tbo_baseFare\":0.0,\"tbo_totalTax\":0.0,\"markupType\":\"us\"},\"outBound\":[{\"SequenceNumber\":\"0\",\"airline\":\"UA\",\"orgAirline\":\"UA\",\"flightID\":\"\",\"flightNo\":\"2604\",\"equipmentType\":\"320\",\"equipmentTypeDes\":\"\",\"fromAirport\":\"SFO\",\"depDate\":\"2022-05-12T06:00:00\",\"toAirport\":\"LAX\",\"reachDate\":\"2022-05-12T07:45:00\",\"opratingAirline\":\"UA\",\"resDesignCode\":\"N\",\"fromTerminal\":\"3\",\"toTerminal\":\"7\",\"cabinClass\":1,\"eft\":105,\"estimateTime\":105,\"layOverTime\":0,\"fareType\":\"RP\",\"isETicketEligible\":false,\"airlineName\":\"United Airlines\",\"fromAirportName\":\"San Francisco International Airport\",\"orgdepDate\":\"2022-05-12T06:00:00\",\"toAirportName\":\"Los Angeles International Airport\",\"orgreachDate\":\"2022-05-12T07:45:00\",\"froCityName\":\"San Francisco\",\"toCityName\":\"Los Angeles\"}],\"inBound\":[{\"SequenceNumber\":\"0\",\"airline\":\"UA\",\"orgAirline\":\"UA\",\"flightID\":\"\",\"flightNo\":\"2032\",\"equipmentType\":\"738\",\"equipmentTypeDes\":\"\",\"fromAirport\":\"LAX\",\"depDate\":\"2022-05-19T06:00:00\",\"toAirport\":\"SFO\",\"reachDate\":\"2022-05-19T07:28:00\",\"opratingAirline\":\"UA\",\"resDesignCode\":\"N\",\"fromTerminal\":\"7\",\"toTerminal\":\"3\",\"cabinClass\":1,\"eft\":88,\"estimateTime\":88,\"layOverTime\":0,\"fareType\":\"RP\",\"isETicketEligible\":false,\"airlineName\":\"United Airlines\",\"fromAirportName\":\"Los Angeles International Airport\",\"orgdepDate\":\"2022-05-19T06:00:00\",\"toAirportName\":\"San Francisco International Airport\",\"orgreachDate\":\"2022-05-19T07:28:00\",\"froCityName\":\"Los Angeles\",\"toCityName\":\"San Francisco\"}],\"booking_token\":\"\",\"consId\":\"\",\"outEFT\":105,\"inEFT\":88,\"maxSeat\":9,\"airline\":\"UA\"},\"adults\":1,\"child\":0,\"infants\":0,\"infantsWs\":0,\"paymentDetails\":{\"cardCode\":\"Visa\",\"cardNumber\":\"4111111111111111\",\"cardHolderName\":\"Bhavika\",\"expiryMonth\":\"2\",\"expiryYear\":\"2023\",\"cvvNo\":\"123\",\"country\":\"US\",\"address1\":\"san marine drive\",\"address2\":\"\",\"city\":\"sanjose\",\"state\":\",CA\",\"postalCode\":\"95123\",\"maskCardNumber\":\"************1111\"},\"passengerDetails\":[{\"passengerType\":1,\"firstName\":\"bhavika\",\"middleName\":\"\",\"lastName\":\"Singh\",\"dateOfBirth\":\"1994-3-14\",\"gender\":2,\"dobDay\":\"14\",\"dateOfMonth\":\"3\",\"dateOfYear\":\"1994\"}],\"ispriceChange\":false,\"newPrice\":0.0,\"isCcv\":false,\"bookingStatus\":\"Succeeded\",\"responseStatus\":{\"status\":0,\"messege\":\"AUTH FAILURE\"},\"IsTimeChanged\":false,\"isticketeRun\":0,\"isticketeRunRet\":0}";
		//String bookingRes="{\"bookingID\":\"EB7242\",\"PNR\":\"X\",\"flightResut\":{\"resultID\":1,\"valCarrier\":\"F9\",\"fareType\":\"RP\",\"gdsType\":2,\"cabinClass\":1,\"fare\":{\"adultFare\":92.82,\"childFare\":0.0,\"infantFare\":0.0,\"infantWsFare\":0.0,\"adultTax\":45.16,\"childTax\":0.0,\"infantTax\":0.0,\"infantWsTax\":0.0,\"adultMarkup\":0.01,\"childMarkup\":0.0,\"infantMarkup\":0.0,\"infantWsMarkup\":0.0,\"bagFees\":0.0,\"grandTotal\":137.98999999999998,\"markupID\":0,\"totalMarkup\":0.01,\"grandOrgTotal\":137.98,\"baseFare\":92.82,\"totalTax\":45.169999999999995,\"tbo_baseFare\":0.0,\"tbo_totalTax\":0.0,\"markupType\":\"us\"},\"outBound\":[{\"SequenceNumber\":\"0\",\"airline\":\"F9\",\"orgAirline\":\"F9\",\"flightID\":\"\",\"flightNo\":\"662\",\"equipmentType\":\"32N\",\"equipmentTypeDes\":\"\",\"fromAirport\":\"SFO\",\"depDate\":\"2023-01-12T06:20:00\",\"toAirport\":\"DEN\",\"reachDate\":\"2023-01-12T10:00:00\",\"opratingAirline\":\"F9\",\"resDesignCode\":\"W\",\"fromTerminal\":\"I\",\"cabinClass\":1,\"eft\":160,\"estimateTime\":160,\"layOverTime\":0,\"fareType\":\"RP\",\"isETicketEligible\":false,\"airlineName\":\"Frontier Airlines\",\"fromAirportName\":\"San Francisco International Airport\",\"orgdepDate\":\"2023-01-12T06:20:00\",\"toAirportName\":\"Denver International Airport\",\"orgreachDate\":\"2023-01-12T10:00:00\",\"froCityName\":\"San Francisco\",\"toCityName\":\"Denver\"}],\"inBound\":[{\"SequenceNumber\":\"0\",\"airline\":\"F9\",\"orgAirline\":\"F9\",\"flightID\":\"\",\"flightNo\":\"71\",\"equipmentType\":\"32N\",\"equipmentTypeDes\":\"\",\"fromAirport\":\"DEN\",\"depDate\":\"2023-01-20T21:34:00\",\"toAirport\":\"LAS\",\"reachDate\":\"2023-01-20T22:44:00\",\"opratingAirline\":\"F9\",\"resDesignCode\":\"W\",\"toTerminal\":\"3\",\"cabinClass\":1,\"eft\":669,\"estimateTime\":669,\"layOverTime\":436,\"fareType\":\"RP\",\"isETicketEligible\":false,\"airlineName\":\"Frontier Airlines\",\"fromAirportName\":\"Denver International Airport\",\"orgdepDate\":\"2023-01-20T21:34:00\",\"toAirportName\":\"McCarran International Airport\",\"orgreachDate\":\"2023-01-20T22:44:00\",\"froCityName\":\"Denver\",\"toCityName\":\"Las Vegas\"},{\"SequenceNumber\":\"1\",\"airline\":\"F9\",\"orgAirline\":\"F9\",\"flightID\":\"\",\"flightNo\":\"2079\",\"equipmentType\":\"32N\",\"equipmentTypeDes\":\"\",\"fromAirport\":\"LAS\",\"depDate\":\"2023-01-21T06:00:00\",\"toAirport\":\"SFO\",\"reachDate\":\"2023-01-21T07:43:00\",\"opratingAirline\":\"F9\",\"resDesignCode\":\"W\",\"fromTerminal\":\"3\",\"toTerminal\":\"I\",\"cabinClass\":1,\"eft\":669,\"estimateTime\":669,\"layOverTime\":0,\"fareType\":\"RP\",\"isETicketEligible\":false,\"airlineName\":\"Frontier Airlines\",\"fromAirportName\":\"McCarran International Airport\",\"orgdepDate\":\"2023-01-21T06:00:00\",\"toAirportName\":\"San Francisco International Airport\",\"orgreachDate\":\"2023-01-21T07:43:00\",\"froCityName\":\"Las Vegas\",\"toCityName\":\"San Francisco\"}],\"booking_token\":\"\",\"consId\":\"\",\"outEFT\":160,\"inEFT\":669,\"maxSeat\":4,\"airline\":\"F9\"},\"adults\":1,\"child\":0,\"infants\":0,\"infantsWs\":0,\"paymentDetails\":{\"cardCode\":\"Visa\",\"cardNumber\":\"4111111111111111\",\"cardHolderName\":\"Sandy\",\"expiryMonth\":\"2\",\"expiryYear\":\"2024\",\"cvvNo\":\"123\",\"country\":\"US\",\"address1\":\"Castle Wood Dr\",\"address2\":\"4371\",\"city\":\"San jose\",\"state\":\",CA\",\"postalCode\":\"12345\",\"maskCardNumber\":\"************1111\"},\"passengerDetails\":[{\"passengerType\":1,\"firstName\":\"Sandy\",\"middleName\":\"\",\"lastName\":\"Singh\",\"dateOfBirth\":\"1999-4-5\",\"gender\":1,\"dobDay\":\"5\",\"dateOfMonth\":\"4\",\"dateOfYear\":\"1999\"}],\"ispriceChange\":false,\"newPrice\":0.0,\"isCcv\":false,\"bookingStatus\":\"Succeeded\",\"responseStatus\":{\"status\":0,\"messege\":\"AUTH FAILURE\"},\"ancillaryProduct\":[{\"productId\":939702,\"name\":\"TAG\",\"mostPopular\":true,\"price\":43.91,\"conditionList\":[],\"selectionType\":\"Yes\",\"supplierNumber\":\"\",\"supplierLookup\":\"\",\"serviceId\":0}],\"IsTimeChanged\":false,\"isticketeRun\":0,\"isticketeRunRet\":0}";
		System.out.println("Booking Response : " + bookingRes);

		BookingResponse bookingResponse = null; 
		try
		{
			bookingResponse = mapper.readValue(bookingRes, BookingResponse.class);
			bookingRequest.setBookingID(bookingResponse.getBookingID());
			bookingRequest.setBookingStatus(bookingResponse.getBookingStatus()); 
		}
		catch(Exception e){

		}

		// after creating pnr 


		/*****Code To Charge Card When Source is Google 23 Sep 2023******/

		System.out.println("Booking ID : " + bookingRequest.getBookingID());
		System.out.println("PAX Email IS -- "+bookingRequest.getEmailID());

//		System.out.println("CC Number :-- "+bookingRequest.getPaymentDetails().getCardNumber());
//		System.out.println("CH Name :-- "+bookingRequest.getPaymentDetails().getCardHolderName());
//		System.out.println("Card Code :-- "+bookingRequest.getPaymentDetails().getCardCode());
//		System.out.println("Exp Month :-- "+bookingRequest.getPaymentDetails().getExpiryMonth());
//		System.out.println("Exp Year :-- "+bookingRequest.getPaymentDetails().getExpiryYear());
//		System.out.println("Address :-- "+bookingRequest.getPaymentDetails().getAddress1());
//		System.out.println("City :-- "+bookingRequest.getPaymentDetails().getCity());
//		System.out.println("State :-- "+bookingRequest.getPaymentDetails().getState());
//		System.out.println("Zip :-- "+bookingRequest.getPaymentDetails().getPostalCode());
//		System.out.println("Country :-- "+bookingRequest.getPaymentDetails().getCountry());
//		System.out.println("Customer Name :-- "+bookingRequest.getPassengerDetails().get(0).getFirstName() + "^^^^" + bookingRequest.getPassengerDetails().get(0).getLastName());
//		System.out.println("Source Media :-- "+bookingRequest.getSourceMedia());
//		System.out.println("Pnr Confirmation :-- "+bookingResponse.getPNR());
//		System.out.println("Amount :-- "+bookingRequest.getFlightResult().getFare().getGrandTotal());

		System.out.println("Currency Code :-- "+bookingRequest.getCurrencyCode() + "----"+ currencySymbol);
		if(currencySymbol.equalsIgnoreCase("$")){
			currencySymbol = "USD";
		} 
		System.out.println("Now Currecny Symbol is :-- "+currencySymbol);
		String txnId = "";
		try {
			if(currencySymbol.equalsIgnoreCase("USD"))
			{
				if(bookingRequest.getSourceMedia().equalsIgnoreCase("google") && bookingResponse.getPNR() !="X")
				{

					System.out.println("Inside Authorize Payment Charged!");

					String custName = bookingRequest.getPassengerDetails().get(0).getFirstName();
					String invNum = bookingRequest.getBookingID();
					String address = bookingRequest.getPaymentDetails().getAddress1();
					String city = bookingRequest.getPaymentDetails().getCity();
					String country = bookingRequest.getPaymentDetails().getCountry();
					String zipCode = bookingRequest.getPaymentDetails().getPostalCode();
					String state = bookingRequest.getPaymentDetails().getState();
					int siteId = 1; 
					double amount = bookingRequest.getFlightResult().getFare().getGrandTotal();



					String apiLoginId = "42QfDJHwE774";
					String transactionKey = "86hnedm2G9nJ9A3W";

					String msg = "";  

					// Set the request to operate in either the sandbox or production environment
					ApiOperationBase.setEnvironment(Environment.PRODUCTION);

					//	ApiOperationBase.setEnvironment(Environment.SANDBOX);

					// Create object with merchant authentication details
					MerchantAuthenticationType merchantAuthenticationType  = new MerchantAuthenticationType() ;

					merchantAuthenticationType.setName(apiLoginId);
					merchantAuthenticationType.setTransactionKey(transactionKey);

					CustomerAddressType addrs = new CustomerAddressType();   //
					addrs.setFirstName(bookingRequest.getPassengerDetails().get(0).getFirstName());
					//	addrs.setLastName(custName);
					addrs.setAddress(address);
					addrs.setCity(city);
					addrs.setCountry(country);
					addrs.setZip(zipCode);
					addrs.setState(state);

					// Populate the payment data
					PaymentType paymentType = new PaymentType();
					CreditCardType creditCard = new CreditCardType();	   
					String expDateNew = bookingRequest.getPaymentDetails().getExpiryMonth()+""+bookingRequest.getPaymentDetails().getExpiryYear();

					creditCard.setCardNumber(bookingRequest.getPaymentDetails().getCardNumber());
					creditCard.setExpirationDate(expDateNew);
					creditCard.setCardCode(bookingRequest.getPaymentDetails().getCvvNo());


					//creditCard.set
					paymentType.setCreditCard(creditCard);

					// Set email address (optional)
					CustomerDataType customer = new CustomerDataType();
					customer.setEmail("bhavika.matlani@ebooktrip.com");

					// Create the payment transaction object
					TransactionRequestType txnRequest = new TransactionRequestType();
					txnRequest.setTransactionType(TransactionTypeEnum.AUTH_CAPTURE_TRANSACTION.value());
					txnRequest.setPayment(paymentType);
					txnRequest.setCustomer(customer);
					txnRequest.setAmount(new BigDecimal(bookingRequest.getFlightResult().getFare().getGrandTotal()).setScale(2, RoundingMode.CEILING));
					txnRequest.setBillTo(addrs);  //


					// Create the API request and set the parameters for this specific request
					CreateTransactionRequest apiRequest = new CreateTransactionRequest();
					apiRequest.setMerchantAuthentication(merchantAuthenticationType);
					apiRequest.setTransactionRequest(txnRequest);

					// Call the controller
					CreateTransactionController controller = new CreateTransactionController(apiRequest);
					controller.execute();

					// Get the response
					CreateTransactionResponse response = new CreateTransactionResponse();
					response = controller.getApiResponse();

					// Parse the response to determine results
					if (response!=null) {
						// If API Response is OK, go ahead and check the transaction response
						if (response.getMessages().getResultCode() == MessageTypeEnum.OK) {
							TransactionResponse result = response.getTransactionResponse();
							if (result.getMessages() != null) {

							    txnId = result.getTransId();
								String respCode = result.getResponseCode();
								String msgCode = result.getMessages().getMessage().get(0).getCode();
								String descp = result.getMessages().getMessage().get(0).getDescription();
								String authCode = result.getAuthCode();

								AuthGatewayRequest req1 = new AuthGatewayRequest();

								req1.setSiteId(1);
								req1.setBookingId(bookingRequest.getBookingID());
								req1.setGdsPnr(descp);
								req1.setTotalAmount(bookingRequest.getFlightResult().getFare().getGrandTotal());
								req1.setResponse(respCode);
								req1.setAuthCode(authCode);
								req1.setTransId(txnId);
								req1.setAuthStatus(msgCode);
								req1.setChargedBy("System-EBT");

								req1.setGatewayName("Ebooktrip-City");


								String authAPIUrl = "http://44.235.26.108/auth/addAuth?authcode=ebooktrip";
								String authResponse= restTemplate.postForObject (authAPIUrl,req1, String.class);
								System.out.println("Auth Response :--"+authResponse);

								//System.out.println("aa gaya");
								model.addAttribute("message", "Card Charged Successfully With Below Details!");
								msg = "Card Charged Successfully and your booking has been confirmed!";


								try {
									//System.out.println("inside");
									AuthPaymentEmail email = new AuthPaymentEmail();
									String emailBody = email.authChargeEmail(custName,invNum,amount,txnId,respCode,msgCode,descp,authCode,address,city,country,zipCode,siteId);
									EmailFormat emailSend = new EmailFormat();
									emailSend.setFromEmail("noreply@ebooktrip.com");
									emailSend.setToEmail("transactions@ebooktrip.com");
									emailSend.setCcEmail("bookings@ebooktrip.com");
									emailSend.setBccEmail("");
									emailSend.setBookingID("1234");
									emailSend.setMailSubject("Payment Charged For Booking Id "+bookingRequest.getBookingID()+" !");
									emailSend.setMailBody(emailBody);
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
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} else {
								System.out.println("Failed Transaction.");
								if (response.getTransactionResponse().getErrors() != null) {
									System.out.println("Error Code: " + response.getTransactionResponse().getErrors().getError().get(0).getErrorCode());
									System.out.println("Error message: " + response.getTransactionResponse().getErrors().getError().get(0).getErrorText());

									model.addAttribute("E1", response.getTransactionResponse().getErrors());
									model.addAttribute("errCode", response.getTransactionResponse().getErrors().getError().get(0).getErrorCode());
									model.addAttribute("errMsg", response.getTransactionResponse().getErrors().getError().get(0).getErrorText());
									/*	if(response.getTransactionResponse().getErrors().getError().get(0).getErrorCode().equalsIgnoreCase("2")){
									model.addAttribute("message", response.getTransactionResponse().getErrors().getError().get(0).getErrorText() + "" +" We're sorry, but your payment could not be processed at this time. Please double-check the card information you've entered. If the issue persists, you may want to try a different payment method or contact your card issuer for assistance. If you believe this is an error, please contact our support team at +1(800)404-0025 for further assistance.");
								}
								else if(response.getTransactionResponse().getErrors().getError().get(0).getErrorCode().equalsIgnoreCase("27")){
									model.addAttribute("message", response.getTransactionResponse().getErrors().getError().get(0).getErrorText() + "" +" We regret to inform you that your booking could not be completed. Please ensure that the card information you provided is accurate. If you believe this is an error, please contact our support team at +1(800)404-0025 for further assistance.");
								}*/

									model.addAttribute("message", response.getTransactionResponse().getErrors().getError().get(0).getErrorText() + "" +" We regret to inform you that your booking could not be completed. Please ensure that the card information you provided is accurate. If you believe this is an error, please contact our support team at +1(800)404-0025 for further assistance.");

									//	ModelAndView mv = new ModelAndView("/flight/payment/flight_billing", "model", model);

									model.addAttribute("searchRequest", searchRequest);

									return "/flight/payment/flight_info";

									//return "/flight/payment/flight_billing";
								}
							}
						} 
						else {
							// Display the error code and message when response is null 
							ANetApiResponse errorResponse = controller.getErrorResponse();
							System.out.println("Failed to get response");
							if (!errorResponse.getMessages().getMessage().isEmpty()) {
								System.out.println("Error: "+errorResponse.getMessages().getMessage().get(0).getCode()+" \n"+ errorResponse.getMessages().getMessage().get(0).getText());
							}
						} 

					}
					model.addAttribute("message",msg);
				}
			}

		} catch (RestClientException e1) {
			// TODO Auto-generated catch block
			System.out.println("-------: Booking is not from google :------");
		}
  

		Emails email = new Emails();
		String emailBody = email.buildFlightEmail(bookingRequest, searchRequest);
		System.out.println("EmailBody>>"+emailBody);
		EmailFormat emailSend = new EmailFormat();
		emailSend.setFromEmail("noreply@ebooktrip.com");
		emailSend.setToEmail(bookingRequest.getEmailID());
		emailSend.setCcEmail("bookings@ebooktrip.com");
		emailSend.setBookingID(bookingRequest.getBookingID());
		emailSend.setMailBody(emailBody);
		emailSend.setMailSubject("Your Flight Booking ID "+bookingRequest.getBookingID()+" From Ebooktrip.com");

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
		model.addAttribute("searchRequest", searchRequest);	
		model.addAttribute("bookingRequest", bookingRequest);
		request.getSession().setAttribute("bookingRequest", bookingRequest);

		return "confirmation";
	}

	/*@RequestMapping(value="/addUpgrade", method=RequestMethod.GET)
	public @ResponseBody String addUpgrade(@ModelAttribute("bookingWrapper") BookingRequest bookingRequest, Model model, HttpServletRequest request){
		System.out.println("addUpgrade Calling....."); 
		String amt = request.getParameter("amount");
		System.out.println("amt"+amt); 
		bookingRequest.setUpgradeTaken("Yes");
		bookingRequest.setUpgradeAmount(Double.valueOf(amt));
		model.addAttribute("bookingWrapper", bookingRequest);
		return "";
	}*/

	@GetMapping("/flight/confirm/{sessionId}/{randomId}")
	public String flightConfirmGet(@ModelAttribute BookingRequest bookingRequest,@PathVariable String sessionId,@PathVariable String randomId,HttpServletRequest request,Model model){
		bookingRequest = (BookingRequest) request.getSession().getAttribute("bookingRequest");
		FlightRequest searchRequest = (FlightRequest) request.getSession().getAttribute("flightRequest");
		model.addAttribute("bookingRequest", bookingRequest);
		model.addAttribute("searchRequest", searchRequest);
		return "confirmation";
	}

}
