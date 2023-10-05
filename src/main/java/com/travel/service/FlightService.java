package com.travel.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.travel.bean.FlightSearch;
import com.travel.object.bookingrequest.BookingRequest;
import com.travel.object.deal.DealResponse;
import com.travel.object.fareRules.CheckFareRules;
import com.travel.object.flightresponse.OtherBound;
import com.travel.object.searchRequest.FlightRequest;
import com.travel.object.travelgaurd.response.TGResponse;

public interface FlightService {
	
	public FlightRequest getFlightSearchRequest(FlightSearch flightsearch, HttpServletRequest request,String searchId);
	public String getFlightSearchResponse(FlightRequest flightRequest);
	public FlightRequest getFlightDeepSearchRequest(HttpServletRequest request,String type, String origin, String destination,String origin1, String destination2, List<List<OtherBound>> otherBounds,int adults, int children, int infants, int infantws, String departure, String retu, String cabin, String utm_source, String utm_medium);
	public String getLiveFlightSearchResponse(BookingRequest bookingRequest);
	public String getFlightFareRules(CheckFareRules checkFareRules);
	public String getFlightMetaCheck(CheckFareRules checkFareRules);
	public DealResponse getDealList();
	public BookingRequest getMetaBookingRequest(BookingRequest bookingRequest);
	public TGResponse getTravelInsurance(BookingRequest bookingRequest, FlightRequest searchRequest);
}
