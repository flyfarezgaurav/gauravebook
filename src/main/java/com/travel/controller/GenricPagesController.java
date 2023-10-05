package com.travel.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.bean.Child;
import com.travel.bean.ContactForm;
import com.travel.bean.FlightSearch;
import com.travel.bean.HotelSearch;
import com.travel.bean.MyBookings;
import com.travel.bean.Room;
import com.travel.object.blogs.BlogsRequest;
import com.travel.object.blogs.BlogsResponse;
import com.travel.object.email.EmailFormat;
import com.travel.object.login.Response;
import com.travel.object.mybookings.MyBookingRequest;
import com.travel.object.mybookings.MyBookingResponse;
import com.travel.object.mybookings.details.MyBookingDetailResponse;
import com.travel.object.newsletter.NewsletterRequest;
import com.travel.object.pagerequest.PageRequest;
import com.travel.object.pageresponse.PageResponse;
import com.travel.object.review.ReviewRequest;
import com.travel.object.review.ReviewResponse;
import com.travel.service.RestDataService;
import com.travel.utility.Emails;
import com.travel.utility.SiteMap;
import com.travel.utility.Utility;

@Controller
public class GenricPagesController {
	
	@Value("${pageApiUrl}")
	private String pageApiUrl;
	
	@Value("${apiUrl}")
	private String apiUrl;
	
	@Autowired
	private RestDataService restService;
	
	
	@GetMapping("/genric/{page}")
	public String Genric(@PathVariable("page") String page,@ModelAttribute FlightSearch flightSearch,@ModelAttribute HotelSearch hotelSearch,@ModelAttribute ReviewRequest reviewRequest,Model model){
		model.addAttribute("airlineList", Utility.getAirlines());
		PageRequest pageRequest = new PageRequest();
		PageResponse pageResponse = new PageResponse();
		RestTemplate rest = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		String code = page.substring(page.lastIndexOf("-")+1, page.length());
		String url = page.substring(0,page.lastIndexOf("-"));
		pageRequest.setPageType("Genric");
		pageRequest.setPageValue("");
		pageRequest.setSiteId("1"); 
		pageRequest.setUrl(page);
		try {
			System.out.println(mapper.writeValueAsString(pageRequest));
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String res = rest.postForObject(pageApiUrl+"/showcontent?authcode=ABCD26S20", pageRequest, String.class);
		System.out.println(res);
		try {
			pageResponse = mapper.readValue(res, PageResponse.class);
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
		if(pageResponse.getResponse().size() == 0){
			return "redirect:/";
		}
		model.addAttribute("pageResponse", pageResponse.getResponse().get(0));
		flightSearch.setPageAirline(code.toUpperCase());
		
		ReviewRequest reviewReq = new ReviewRequest();
		reviewReq.setSiteId("1");
		reviewReq.setReviewUrl(page);
		String reviewRes = rest.postForObject(pageApiUrl+"/reviewbyurl?authcode=ABCD26S20", reviewReq, String.class);
		System.out.println("reviewRes : " + reviewRes);
		ReviewResponse reviewResponse = new ReviewResponse();
		try {
			reviewResponse = mapper.readValue(reviewRes, ReviewResponse.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < reviewResponse.getResponse().size(); i++) {
			reviewResponse.getResponse().get(i).setReviewUrl(Utility.getDayHHMMDiff(reviewResponse.getResponse().get(i).getReviewDate(), new Date()));
		}
		model.addAttribute("reviewResponse", reviewResponse.getResponse());
		
		return "airlines";
	}
	
}
