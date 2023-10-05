package com.travel.service;

import com.travel.bean.HotelSearch;
import com.travel.object.searchRequest.HotelDetailRequest;


public interface HotelService {
	
	public String getHotelSearchResponse(HotelSearch hotelSearch);
	public String getHotelDetailResponse(HotelDetailRequest request);
}
