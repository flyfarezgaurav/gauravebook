package com.travel.controller;

import java.io.IOException;
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
import com.travel.bean.ContactForm;
import com.travel.bean.FlightSearch;
import com.travel.bean.SubscribeForm;
import com.travel.object.SubscribeRequest;
import com.travel.object.blogs.BlogsRequest;
import com.travel.object.blogs.BlogsResponse;
import com.travel.object.deal.DealRequest;
import com.travel.object.deal.DealResponse;
import com.travel.object.email.EmailFormat;
import com.travel.object.newsletter.NewsletterRequest;
import com.travel.object.newsletter.NewsletterResponse;
//import com.travel.object.newsletter.NewsletterRequest;
import com.travel.object.pagerequest.PageRequest;
import com.travel.object.pageresponse.PageResponse;
import com.travel.object.pageresponse.Response;
import com.travel.object.review.ReviewRequest;
import com.travel.object.review.ReviewResponse;
import com.travel.service.RestDataService;
import com.travel.utility.Emails;
import com.travel.utility.SiteMap;
import com.travel.utility.SubscribeMail;
import com.travel.utility.Utility;

@Controller
public class PagesController {
	
	@Value("${pageApiUrl}")
	private String pageApiUrl;
	
	@Value("${apiUrl}")
	private String apiUrl;
	
	@Value("${siteName}")
	private String siteName;
	
	@Value("${siteId}")
	private int siteId;
	
	@Autowired
	private RestDataService restService;
	
	@Autowired
	MailController mailService;
	
	@GetMapping("/faqs")
	public String faqs(){
	return "faqs";	
	}
	
	@GetMapping("/contactus")
	public String contactus(@ModelAttribute ContactForm contactForm){
	return "contact-us";	
	}
		
	@PostMapping("/contactus/submit")
	public @ResponseBody String contactusPost(@RequestBody ContactForm contactForm){
			
		Emails email = new Emails();
		String emailBody = email.buildContactEmail(contactForm);
		System.out.println(emailBody);
		EmailFormat emailSend = new EmailFormat();
		emailSend.setBookingID("");
		emailSend.setFromEmail("noreply@ebooktrip.com");
		emailSend.setToEmail("query@ebooktrip.com");
		emailSend.setCcEmail("query@ebooktrip.com");
		//emailSend.setBccEmail("");
		emailSend.setMailBody(emailBody);
		emailSend.setMailSubject("Contact Us Query From Ebooktrip : "+contactForm.getLastName());
		
		String status = "false";
		
		try 
		{
			status = mailService.SendMail(emailSend, "smtp.gmail.com", "465", "Bhavika@1187");
			//status = mailService.SendMail(emailSend, "smtp.gmail.com", "465", "Kripa$786");
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return status;	
	}
	
	@GetMapping("/aboutus")
	public String aboutus(){
	return "aboutus";	
	}
	
	@GetMapping("/terms-and-conditions")
	public String termsandconditions(){
	return "terms-conditions";	
	}
	
	@GetMapping("/privacy-policy")
	public String privacypolicy(){
	return "privacy-policy";	
	}
	
	@GetMapping("/sitemap")
	public String sitemap(HttpServletRequest request){
		com.travel.utility.SiteMap tc = new SiteMap();
		tc.getSitemap(request);
		return "sitemap";	
	}
	
	@GetMapping("/deals-destinations")
	public String dealsdestinations(){
		return "deals-destinations";
	}
	
	@GetMapping("/checkin")
	public String checkin(){
	return "checkin";	
	}
	
	@GetMapping("/baggage-fees")
	public String baggagefees(){
	return "baggage-fees";	
	}
	
	@GetMapping("/newsletter")
	public String newsletter(){
	return "newsletter";	
	}
	
	@GetMapping("/our-service-fees")
	public String ourservices(){
	return "our-service-fees";	
	}
	
	@GetMapping("/taxes-fees")
	public String taxesfees(){
	return "taxes-fees";	
	}
	
	@GetMapping("/testimonials")
	public String testimonials(){
	return "testimonials";	
	}
    @GetMapping("/post-ticketing-fees")
    public String postTktFees() {
        return "post-ticketing-fees";
    }
    
	@GetMapping("/flights/{page}")
	public String airlines(@PathVariable("page") String page,@ModelAttribute FlightSearch flightSearch, @ModelAttribute ReviewRequest reviewRequest,Model model){
		model.addAttribute("airlineList", Utility.getAirlines());
		System.out.println("PagesController::Airline::Page Value:: "+page);
		PageRequest pageRequest = new PageRequest();
		PageResponse pageResponse = new PageResponse();
		RestTemplate rest = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		String code = page.substring(page.lastIndexOf("-")+1, page.length());
		String url = page.substring(0,page.lastIndexOf("-"));
		pageRequest.setPageType("Airline");
		pageRequest.setPageValue(code.toLowerCase());
		//pageRequest.setPageValue("as");
		pageRequest.setSiteId("1");
		pageRequest.setUrl(url);
		try 
		{
			System.out.println("Airline PageRequest:: "+mapper.writeValueAsString(pageRequest));
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String res = rest.postForObject(pageApiUrl+"/showcontent?authcode=ebooktrip", pageRequest, String.class);
		System.out.println("Airlines Content:: "+res);
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
		String reviewRes = rest.postForObject(pageApiUrl+"/reviewbyurl?authcode=ebooktrip", reviewReq, String.class);
		System.out.println("reviewRes : " + reviewRes);
		ReviewResponse reviewResponse = new ReviewResponse();
		try
		{
			reviewResponse = mapper.readValue(reviewRes, ReviewResponse.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < reviewResponse.getResponse().size(); i++) {
			reviewResponse.getResponse().get(i).setReviewUrl(Utility.getDayHHMMDiff(reviewResponse.getResponse().get(i).getReviewDate(), new Date()));
		}
		
		model.addAttribute("reviewResponse", reviewResponse.getResponse());
		
		DealRequest dealRequest = new DealRequest();
		dealRequest.setAirline(code.toUpperCase());
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
		
		String dealResStr = rest.postForObject(apiUrl+"/travelsite/deals?authcode=ebooktrip", dealRequest, String.class);
		System.out.println("DealsRequest:: "+dealResStr);
		DealResponse dealResponse = null; 
		try 
		{
			dealResponse =	mapper.readValue(dealResStr, DealResponse.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("dealResponse", dealResponse);
		
		
		return "airlines";
	}
	
	@GetMapping("/city/cheap-flights-to-{page}") 
	public String cities(@PathVariable("page") String page,@ModelAttribute FlightSearch flightSearch, @ModelAttribute ReviewRequest reviewRequest,Model model){
		model.addAttribute("airlineList", Utility.getAirlines());
		
		System.out.println("PagesController::City::PageVaue>>"+page);
		
		String code = page.split("-")[1];
		String pageName = page.split("-")[0];
		PageRequest pageRequest = new PageRequest();
		PageResponse pageResponse = new PageResponse();
		RestTemplate rest = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		pageRequest.setPageType("City");
		pageRequest.setPageValue(code.toLowerCase());
		pageRequest.setSiteId("1");
		pageRequest.setUrl("");
		String res = rest.postForObject(pageApiUrl+"/showcontent?authcode=ebooktrip", pageRequest, String.class);
		System.out.println("City Content:: "+res);
		try
		{
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
		
		model.addAttribute("pageResponse", pageResponse.getResponse().get(0));
		model.addAttribute("page", pageName);
		flightSearch.setDestination(restService.getAirportList(code).get(0));
		
		ReviewRequest reviewReq = new ReviewRequest();
		reviewReq.setSiteId("1");
		reviewReq.setReviewUrl(page);
		String reviewRes = rest.postForObject(pageApiUrl+"/reviewbyurl?authcode=ebooktrip", reviewReq, String.class);
		System.out.println("reviewRes : " + reviewRes);
		ReviewResponse reviewResponse = new ReviewResponse();
		
		try 
		{
			reviewResponse = mapper.readValue(reviewRes, ReviewResponse.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < reviewResponse.getResponse().size(); i++) {
			reviewResponse.getResponse().get(i).setReviewUrl(Utility.getDayHHMMDiff(reviewResponse.getResponse().get(i).getReviewDate(), new Date()));
		}
		model.addAttribute("reviewResponse", reviewResponse.getResponse());
		
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
		dealRequest.setToCity(code.toUpperCase());
		dealRequest.setTripType("2");
		dealRequest.setSiteId("1");
		String dealResStr = rest.postForObject(apiUrl+"/travelsite/deals?authcode=ebooktrip", dealRequest, String.class);
		System.out.println("DealResStr>>"+dealResStr);
		DealResponse dealResponse = null;
		try {
		dealResponse =	mapper.readValue(dealResStr, DealResponse.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("dealResponse", dealResponse);
		
		return "cities";
	}
	
	@GetMapping("/routes/cheap-flights-from-{page}")
    public String citiesto(@PathVariable("page") String page, @ModelAttribute FlightSearch flightSearch, @ModelAttribute ReviewRequest reviewRequest, Model model) {
        
		model.addAttribute("airlineList", Utility.getAirlines());
        
		System.out.println("PagesController::Routes::Pagevalue>>"+page);
        
        String code = page.split("-")[1];
        String pageName = page.split("-")[0];
        
        System.out.println("code and page name is :---" + code + "-------" + pageName);
        
        PageRequest pageRequest = new PageRequest();
        PageResponse pageResponse = new PageResponse();
        RestTemplate rest = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        pageRequest.setPageType("Genric");
        pageRequest.setPageValue(code.toLowerCase());
        pageRequest.setSiteId("1");
        pageRequest.setUrl(page);
        
        try
        {
        	System.out.println(" Route==PageRequest:: "+mapper.writeValueAsString(pageRequest));
        }
        catch(Exception e){
        	
        }
        final String res = rest.postForObject(pageApiUrl+"/showcontent?authcode=ebooktrip", pageRequest, String.class);
        System.out.println("Route==PageResponse:: "+res);
        try 
        {
            pageResponse = mapper.readValue(res, PageResponse.class);
        }
        catch (JsonParseException e) {
            e.printStackTrace();
        }
        catch (JsonMappingException e2) {
            e2.printStackTrace();
        }
        catch (IOException e3) {
            e3.printStackTrace();
        }
        
        if(pageResponse.getBaseResponse().getStatus()==1)
        {
        	System.out.println(" <<<<<<  Getting Status == 11  >>>>>>");
        	
        	model.addAttribute("pageResponse", pageResponse.getResponse().get(0));
            model.addAttribute("page", pageName);
            
            flightSearch.setDestination(restService.getAirportList(code).get(0));
            ReviewRequest reviewReq = new ReviewRequest();
            reviewReq.setSiteId("1");
            reviewReq.setReviewUrl(page);
            
            String reviewRes = rest.postForObject(pageApiUrl+"/reviewbyurl?authcode=ebooktrip", reviewReq, String.class);
            System.out.println("Review Response :: " + reviewRes);
            
            ReviewResponse reviewResponse = new ReviewResponse();
            try 
            {
                reviewResponse = mapper.readValue(reviewRes, ReviewResponse.class);
            }
            catch (IOException e4) {
                e4.printStackTrace();
            }
            
            for (int i = 0; i < reviewResponse.getResponse().size(); ++i) {
                reviewResponse.getResponse().get(i).setReviewUrl(Utility.getDayHHMMDiff(reviewResponse.getResponse().get(i).getReviewDate(), new Date()));
            }
            
            model.addAttribute("reviewResponse", reviewResponse.getResponse());
            
        }
        else{
        	System.out.println(" <<<<<<  Getting Status == 00  >>>>>>");
        	
        	List<Response> response= new ArrayList<Response>();
        	pageResponse.setResponse(response);
        	
        	model.addAttribute("pageResponse", pageResponse.getResponse().get(0));
        	model.addAttribute("page", pageName);
        }
        
        return "cities-to";
    }
	
	@GetMapping("/blogs")
	public String blogs(Model model){
		System.out.println(" Blogs Method Calling.....");
		BlogsResponse blogresponse = new BlogsResponse();
		model.addAttribute("airlineList", Utility.getAirlines());
		RestTemplate rest = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		BlogsRequest request = new BlogsRequest();
		request.setSiteId("1");
		
		String blogRS = rest.postForObject(pageApiUrl+"/showblogdata?authcode=ebooktrip", request, String.class);
		System.out.println("blogRS>>"+blogRS);
		try
		{
			blogresponse = mapper.readValue(blogRS, BlogsResponse.class);
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
		if(blogresponse.getResponse().size() == 0){
			return "redirect:/";
		}
		
		model.addAttribute("blogResponse", blogresponse.getResponse());
		return "blogs";
	}
	
	@GetMapping("/blogs/{page}")
    public String blogPages(@PathVariable String page, Model model) throws JsonProcessingException {
        System.out.println(" BlogPages method Calling ..... " + page);
        BlogsRequest req1 = new BlogsRequest();
        RestTemplate rest = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        req1.setTitleUrl(page);
        req1.setSiteId("1");
        
        //{"titleUrl":"delta-airlines-cancellation-policy","siteId":"1"}
        
        System.out.println("Blog Page Request is :-- " + mapper.writeValueAsString(req1));
        
        String blogPageURL = "http://54.203.229.83/content/blogdatabyid?authcode=ebooktrip";
        
        String blogPageRS = rest.postForObject(blogPageURL, req1, String.class);
        System.out.println("Blog-Page Response :- " + blogPageRS);
        
        BlogsResponse blogRes = new BlogsResponse();
        
        /*
        String blogDataRS = rest.postForObject(res, req1, String.class);
        System.out.println("blogDataRS>>"+blogDataRS);
        */
        
        try 
        {
            blogRes = mapper.readValue(blogPageRS.replaceAll("\ufffd", " ").toString(), BlogsResponse.class);
        }
        catch (JsonParseException e) {
            e.printStackTrace();
        }
        catch (JsonMappingException e2) {
            e2.printStackTrace();
        }
        catch (IOException e3) {
            e3.printStackTrace();
        }
       
        model.addAttribute("blogResponse", blogRes.getResponse().get(0));
        
        return "blog-detail";
    }
	
	@PostMapping("/review/submit") 
	public @ResponseBody String reviewsubmit(@RequestBody ReviewRequest reviewRequest){
		System.out.println(" reviewsubmit Method Calling.. ");
		System.out.println("UserName:"+reviewRequest.getUserName());
		
		Date currDate = new Date();
		RestTemplate rest = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		reviewRequest.setSiteId("1");
		reviewRequest.setUserPhone("");
		reviewRequest.setReviewDate(currDate.toString());
		reviewRequest.setReviewStatus("Inactive");
		//reviewRequest.setReviewUrl(reviewUrl);
		reviewRequest.setReviewRpyId("2");
		
		try
		{
			System.out.println("Review Submit Request :-- " + mapper.writeValueAsString(reviewRequest));
		}
		catch(Exception e){}
		
		String reviewRS = rest.postForObject(pageApiUrl+"/addreview?authcode=ebooktrip", reviewRequest, String.class);
		System.out.println(" ReviewSubmit Response:: "+reviewRS);
		
		return reviewRS;
		
	}
	
	@PostMapping("/newsletter/submit")
	public @ResponseBody String newslettersubmit(@RequestBody NewsletterRequest newsletterRequest){
		Date currDate = new Date();
		RestTemplate rest = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		newsletterRequest.setDate(currDate.toString());
		newsletterRequest.setSiteId(1);
		newsletterRequest.setStatus("Active");
		newsletterRequest.setUrl("https://www.ebooktrip.com");
		newsletterRequest.setEmailId(newsletterRequest.getEmailId()); 
		
		try 
		{
			System.out.println("NewsletterRequest:: "+mapper.writeValueAsString(newsletterRequest));
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String newsletterURL = "http://54.203.229.83/subscribe/addNewsletter?authcode=ebooktrip";
		String newsletterRS = rest.postForObject(newsletterURL, newsletterRequest, String.class);
		System.out.println("NewsletterRequest"+newsletterRS);
		
		NewsletterResponse subscribeObj = new NewsletterResponse();
		
		try 
        {
			subscribeObj = mapper.readValue(newsletterRS, NewsletterResponse.class);
        }
        catch (JsonParseException e) {
            e.printStackTrace();
        }
        catch (JsonMappingException e2) {
            e2.printStackTrace();
        }
        catch (IOException e3) {
            e3.printStackTrace();
        }
		
		String status = "false";
		
		if(subscribeObj.getBaseResponse().getStatus()==1){
			
			SubscribeMail email = new SubscribeMail();
			String emailBody = email.buildSubscribeMail(newsletterRequest.getEmailId(), "newsletter"); 
			//System.out.println(emailBody);
			EmailFormat emailSend = new EmailFormat();
			emailSend.setBookingID("");
			emailSend.setFromEmail("noreply@ebooktrip.com");
			emailSend.setToEmail("bookings@ebooktrip.com");
			emailSend.setCcEmail("");
			//emailSend.setBccEmail("");
			emailSend.setMailBody(emailBody);
			emailSend.setMailSubject("Registered Susccessfully From "+newsletterRequest.getEmailId());
			
			try 
			{
				status = mailService.SendMail(emailSend, "smtp.gmail.com", "465", "Bhavika@1187");
			} 
			catch (Exception e) {
				e.printStackTrace();
			} 
		}
		else{
			status="false";
		}
		
		return status;
	}
	
	/********* Write Code on 19-March-2022 **********/
	
	@PostMapping("/subscribesubmit/{emailId}")
	public @ResponseBody String subscribesubmit(@PathVariable String emailId){		
		System.out.println("Subscribe_email::"+emailId);
		
		RestTemplate rest = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = format.format(d);
		SubscribeRequest reqObj=new SubscribeRequest();
		reqObj.setDate(dateString);
		reqObj.setEmailid(emailId);
		reqObj.setStatus("Active");
		reqObj.setSiteId(siteId);
		reqObj.setUrl("https://www.ebooktrip.com");
		
		try 
		{
			System.out.println("NewsletterRequest:: "+mapper.writeValueAsString(reqObj));
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String subscribeURL = "http://54.203.229.83/subscribe/addNewsletter?authcode=ebooktrip";
		String subscribeRS = rest.postForObject(subscribeURL, reqObj, String.class);
		System.out.println("Subscribe Response:: "+subscribeRS);
		
		//{"baseResponse":{"status":1,"messege":"success"},"response":{"id":1,"url":"https://www.ebooktrip.com","date":1647751629000,"emailid":"manoj@gmail.com","status":"Active","siteId":1}}
		
		NewsletterResponse subscribeObj = new NewsletterResponse();
		
		try 
        {
			subscribeObj = mapper.readValue(subscribeRS, NewsletterResponse.class);
        }
        catch (JsonParseException e) {
            e.printStackTrace();
        }
        catch (JsonMappingException e2) {
            e2.printStackTrace();
        }
        catch (IOException e3) {
            e3.printStackTrace();
        }
		
		String status = "false";
		
		if(subscribeObj.getBaseResponse().getStatus()==1){
			
			SubscribeMail email = new SubscribeMail();
			String emailBody = email.buildSubscribeMail(emailId, "subscribe"); 
			//System.out.println(emailBody);
			EmailFormat emailSend = new EmailFormat();
			emailSend.setBookingID("");
			emailSend.setFromEmail("noreply@ebooktrip.com");
			emailSend.setToEmail("bookings@ebooktrip.com");
			emailSend.setCcEmail("bookings@ebooktrip.com");
			//emailSend.setBccEmail("");
			emailSend.setMailBody(emailBody);
			emailSend.setMailSubject("Subscribe Mail from "+emailId);
			
			try 
			{
				status = mailService.SendMail(emailSend, "smtp.gmail.com", "465", "Bhavika@1187");
			} 
			catch (Exception e) {
				e.printStackTrace();
			} 
		}
		else{
			status="false";
		}
		
		return status;
	}
	
	public int getDayDiff(String date1,String date2){
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		float daysBetween = 0;
		 try {
		       Date dateBefore = myFormat.parse(date1);
		       Date dateAfter = myFormat.parse(date2);
		       long difference = dateAfter.getTime() - dateBefore.getTime();
		       daysBetween = (difference / (1000*60*60*24));
	             
		 } catch (Exception e) {
		       e.printStackTrace();
		 }
		return (int) daysBetween;
	}

}
