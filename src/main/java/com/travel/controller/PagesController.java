
package com.travel.controller;

import com.travel.object.SubscribeRequest;
import java.text.SimpleDateFormat;
import com.travel.utility.SubscribeMail;
import com.travel.object.newsletter.NewsletterResponse;
import com.travel.object.newsletter.NewsletterRequest;
import com.travel.object.blogs.BlogsRequest;
import com.travel.object.blogs.BlogsResponse;
import java.util.List;
import java.util.ArrayList;
import com.travel.object.deal.DealResponse;
import com.travel.object.deal.DealRequest;
import java.util.Date;
import com.travel.object.review.Response;
import com.travel.object.review.ReviewResponse;
import java.io.IOException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;
import com.travel.object.pageresponse.PageResponse;
import com.travel.object.pagerequest.PageRequest;
import com.travel.utility.Utility;
import org.springframework.ui.Model;
import com.travel.object.review.ReviewRequest;
import com.travel.bean.FlightSearch;
import org.springframework.web.bind.annotation.PathVariable;
import com.travel.utility.SiteMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import com.travel.object.email.EmailFormat;
import com.travel.utility.Emails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.travel.bean.ContactForm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.travel.service.RestDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public class PagesController
{
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
    
    @GetMapping({ "/faqs" })
    public String faqs() {
        return "faqs";
    }
    
    @GetMapping({ "/contactus" })
    public String contactus(@ModelAttribute final ContactForm contactForm) {
        return "contact-us";
    }
    
    @PostMapping({ "/contactus/submit" })
    @ResponseBody
    public String contactusPost(@RequestBody final ContactForm contactForm) {
        final Emails email = new Emails();
        final String emailBody = email.buildContactEmail(contactForm);
        System.out.println(emailBody);
        final EmailFormat emailSend = new EmailFormat();
        emailSend.setBookingID("");
        emailSend.setFromEmail("noreply@ebooktrip.com");
        emailSend.setToEmail("bookings@ebooktrip.com");
        emailSend.setCcEmail("bookings@ebooktrip.com");
        emailSend.setMailBody(emailBody);
        emailSend.setMailSubject("Contact Us Query " + contactForm.getLastName());
        String status = "false";
        try {
            status = this.mailService.SendMail(emailSend, "smtp.gmail.com", "465", "Bhavika@1187");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    @GetMapping({ "/aboutus" })
    public String aboutus() {
        return "aboutus";
    }
    
    @GetMapping({ "/terms-and-conditions" })
    public String termsandconditions() {
        return "terms-conditions";
    }
    
    @GetMapping({ "/privacy-policy" })
    public String privacypolicy() {
        return "privacy-policy";
    }
    
    @GetMapping({ "/sitemap" })
    public String sitemap(final HttpServletRequest request) {
        final SiteMap tc = new SiteMap();
        tc.getSitemap(request);
        return "sitemap";
    }
    
    @GetMapping({ "/deals-destinations" })
    public String dealsdestinations() {
        return "deals-destinations";
    }
    
    @GetMapping({ "/checkin" })
    public String checkin() {
        return "checkin";
    }
    
    @GetMapping({ "/baggage-fees" })
    public String baggagefees() {
        return "baggage-fees";
    }
    
    @GetMapping({ "/newsletter" })
    public String newsletter() {
        return "newsletter";
    }
    
    @GetMapping({ "/our-service-fees" })
    public String ourservices() {
        return "our-service-fees";
    }
    
    @GetMapping({ "/taxes-fees" })
    public String taxesfees() {
        return "taxes-fees";
    }
    
    @GetMapping({ "/testimonials" })
    public String testimonials() {
        return "testimonials";
    }
    
    @GetMapping({ "/post-ticketing-fees" })
    public String postTktFees() {
        return "post-ticketing-fees";
    }
    
    @GetMapping({ "/flights/{page}" })
    public String airlines(@PathVariable("page") final String page, @ModelAttribute final FlightSearch flightSearch, @ModelAttribute final ReviewRequest reviewRequest, final Model model) {
        model.addAttribute("airlineList", (Object)Utility.getAirlines());
        System.out.println("PagesController::Airline::Page Value:: " + page);
        final PageRequest pageRequest = new PageRequest();
        PageResponse pageResponse = new PageResponse();
        final RestTemplate rest = new RestTemplate();
        final ObjectMapper mapper = new ObjectMapper();
        final String code = page.substring(page.lastIndexOf("-") + 1, page.length());
        final String url = page.substring(0, page.lastIndexOf("-"));
        pageRequest.setPageType("Airline");
        pageRequest.setPageValue(code.toLowerCase());
        pageRequest.setSiteId("1");
        pageRequest.setUrl(url);
        try {
            System.out.println("Airline PageRequest:: " + mapper.writeValueAsString((Object)pageRequest));
        }
        catch (JsonProcessingException e1) {
            e1.printStackTrace();
        }
        final String res = (String)rest.postForObject(String.valueOf(String.valueOf(this.pageApiUrl)) + "/showcontent?authcode=ebooktrip", (Object)pageRequest, (Class)String.class, new Object[0]);
        System.out.println("Airlines Content:: " + res);
        try {
            pageResponse = (PageResponse)mapper.readValue(res, (Class)PageResponse.class);
        }
        catch (JsonParseException e2) {
            e2.printStackTrace();
        }
        catch (JsonMappingException e3) {
            e3.printStackTrace();
        }
        catch (IOException e4) {
            e4.printStackTrace();
        }
        if (pageResponse.getResponse().size() == 0) {
            return "redirect:/";
        }
        model.addAttribute("pageResponse", pageResponse.getResponse().get(0));
        flightSearch.setPageAirline(code.toUpperCase());
        final ReviewRequest reviewReq = new ReviewRequest();
        reviewReq.setSiteId("1");
        reviewReq.setReviewUrl(page);
        final String reviewRes = (String)rest.postForObject(String.valueOf(String.valueOf(this.pageApiUrl)) + "/reviewbyurl?authcode=ebooktrip", (Object)reviewReq, (Class)String.class, new Object[0]);
        System.out.println("reviewRes : " + reviewRes);
        ReviewResponse reviewResponse = new ReviewResponse();
        try {
            reviewResponse = (ReviewResponse)mapper.readValue(reviewRes, (Class)ReviewResponse.class);
        }
        catch (IOException e5) {
            e5.printStackTrace();
        }
        for (int i = 0; i < reviewResponse.getResponse().size(); ++i) {
            reviewResponse.getResponse().get(i).setReviewUrl(Utility.getDayHHMMDiff(reviewResponse.getResponse().get(i).getReviewDate(), new Date()));
        }
        model.addAttribute("reviewResponse", (Object)reviewResponse.getResponse());
        final DealRequest dealRequest = new DealRequest();
        dealRequest.setAirline(code.toUpperCase());
        dealRequest.setCabinClass("Y");
        dealRequest.setCityName((Object)"");
        dealRequest.setCountryCode("US");
        dealRequest.setCountryName("US");
        dealRequest.setCurrency("USD");
        dealRequest.setDepartDate((Object)"");
        dealRequest.setFroCity("");
        dealRequest.setPage("");
        dealRequest.setToCity("");
        dealRequest.setTripType("2");
        dealRequest.setSiteId("1");
        final String dealResStr = (String)rest.postForObject(String.valueOf(String.valueOf(this.apiUrl)) + "/travelsite/deals?authcode=ebooktrip", (Object)dealRequest, (Class)String.class, new Object[0]);
        System.out.println("DealsRequest:: " + dealResStr);
        DealResponse dealResponse = null;
        try {
            dealResponse = (DealResponse)mapper.readValue(dealResStr, (Class)DealResponse.class);
        }
        catch (IOException e6) {
            e6.printStackTrace();
        }
        model.addAttribute("dealResponse", (Object)dealResponse);
        return "airlines";
    }
    
    @GetMapping({ "/city/cheap-flights-to-{page}" })
    public String cities(@PathVariable("page") final String page, @ModelAttribute final FlightSearch flightSearch, @ModelAttribute final ReviewRequest reviewRequest, final Model model) {
        model.addAttribute("airlineList", (Object)Utility.getAirlines());
        System.out.println("PagesController::City::PageVaue>>" + page);
        final String code = page.split("-")[1];
        final String pageName = page.split("-")[0];
        final PageRequest pageRequest = new PageRequest();
        PageResponse pageResponse = new PageResponse();
        final RestTemplate rest = new RestTemplate();
        final ObjectMapper mapper = new ObjectMapper();
        pageRequest.setPageType("City");
        pageRequest.setPageValue(code.toLowerCase());
        pageRequest.setSiteId("1");
        pageRequest.setUrl("");
        final String res = (String)rest.postForObject(String.valueOf(String.valueOf(this.pageApiUrl)) + "/showcontent?authcode=ebooktrip", (Object)pageRequest, (Class)String.class, new Object[0]);
        System.out.println("City Content:: " + res);
        try {
            pageResponse = (PageResponse)mapper.readValue(res, (Class)PageResponse.class);
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
        model.addAttribute("pageResponse", pageResponse.getResponse().get(0));
        model.addAttribute("page", (Object)pageName);
        flightSearch.setDestination((String)this.restService.getAirportList(code).get(0));
        final ReviewRequest reviewReq = new ReviewRequest();
        reviewReq.setSiteId("1");
        reviewReq.setReviewUrl(page);
        final String reviewRes = (String)rest.postForObject(String.valueOf(String.valueOf(this.pageApiUrl)) + "/reviewbyurl?authcode=ebooktrip", (Object)reviewReq, (Class)String.class, new Object[0]);
        System.out.println("reviewRes : " + reviewRes);
        ReviewResponse reviewResponse = new ReviewResponse();
        try {
            reviewResponse = (ReviewResponse)mapper.readValue(reviewRes, (Class)ReviewResponse.class);
        }
        catch (IOException e4) {
            e4.printStackTrace();
        }
        for (int i = 0; i < reviewResponse.getResponse().size(); ++i) {
            reviewResponse.getResponse().get(i).setReviewUrl(Utility.getDayHHMMDiff(reviewResponse.getResponse().get(i).getReviewDate(), new Date()));
        }
        model.addAttribute("reviewResponse", (Object)reviewResponse.getResponse());
        final DealRequest dealRequest = new DealRequest();
        dealRequest.setAirline("");
        dealRequest.setCabinClass("Y");
        dealRequest.setCityName((Object)"");
        dealRequest.setCountryCode("US");
        dealRequest.setCountryName("US");
        dealRequest.setCurrency("USD");
        dealRequest.setDepartDate((Object)"");
        dealRequest.setFroCity("");
        dealRequest.setPage("");
        dealRequest.setToCity(code.toUpperCase());
        dealRequest.setTripType("2");
        dealRequest.setSiteId("1");
        final String dealResStr = (String)rest.postForObject(String.valueOf(String.valueOf(this.apiUrl)) + "/travelsite/deals?authcode=ebooktrip", (Object)dealRequest, (Class)String.class, new Object[0]);
        System.out.println("DealResStr>>" + dealResStr);
        DealResponse dealResponse = null;
        try {
            dealResponse = (DealResponse)mapper.readValue(dealResStr, (Class)DealResponse.class);
        }
        catch (IOException e5) {
            e5.printStackTrace();
        }
        model.addAttribute("dealResponse", (Object)dealResponse);
        return "cities";
    }
    
    @GetMapping({ "/routes/cheap-flights-from-{page}" })
    public String citiesto(@PathVariable("page") final String page, @ModelAttribute final FlightSearch flightSearch, @ModelAttribute final ReviewRequest reviewRequest, final Model model) {
        model.addAttribute("airlineList", (Object)Utility.getAirlines());
        System.out.println("PagesController::Routes::Pagevalue>>" + page);
        final String code = page.split("-")[1];
        final String pageName = page.split("-")[0];
        System.out.println("code and page name is :---" + code + "-------" + pageName);
        final PageRequest pageRequest = new PageRequest();
        PageResponse pageResponse = new PageResponse();
        final RestTemplate rest = new RestTemplate();
        final ObjectMapper mapper = new ObjectMapper();
        pageRequest.setPageType("Genric");
        pageRequest.setPageValue(code.toLowerCase());
        pageRequest.setSiteId("1");
        pageRequest.setUrl(page);
        try {
            System.out.println(" Route==PageRequest:: " + mapper.writeValueAsString((Object)pageRequest));
        }
        catch (Exception ex) {}
        final String res = (String)rest.postForObject(String.valueOf(String.valueOf(this.pageApiUrl)) + "/showcontent?authcode=ebooktrip", (Object)pageRequest, (Class)String.class, new Object[0]);
        System.out.println("Route==PageResponse:: " + res);
        try {
            pageResponse = (PageResponse)mapper.readValue(res, (Class)PageResponse.class);
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
        if (pageResponse.getBaseResponse().getStatus() == 1) {
            System.out.println(" <<<<<<  Getting Status == 11  >>>>>>");
            model.addAttribute("pageResponse", pageResponse.getResponse().get(0));
            model.addAttribute("page", (Object)pageName);
            flightSearch.setDestination((String)this.restService.getAirportList(code).get(0));
            final ReviewRequest reviewReq = new ReviewRequest();
            reviewReq.setSiteId("1");
            reviewReq.setReviewUrl(page);
            final String reviewRes = (String)rest.postForObject(String.valueOf(String.valueOf(this.pageApiUrl)) + "/reviewbyurl?authcode=ebooktrip", (Object)reviewReq, (Class)String.class, new Object[0]);
            
            System.out.println("Review Response :: " + reviewRes);
            ReviewResponse reviewResponse = new ReviewResponse();
            try {
                reviewResponse = (ReviewResponse)mapper.readValue(reviewRes, (Class)ReviewResponse.class);
            }
            catch (IOException e4) {
                e4.printStackTrace();
            }
            for (int i = 0; i < reviewResponse.getResponse().size(); ++i) {
                reviewResponse.getResponse().get(i).setReviewUrl(Utility.getDayHHMMDiff(reviewResponse.getResponse().get(i).getReviewDate(), new Date()));
            }
            model.addAttribute("reviewResponse", (Object)reviewResponse.getResponse());
        }
        else {
            System.out.println(" <<<<<<  Getting Status == 00  >>>>>>");
            final List<com.travel.object.pageresponse.Response> response = new ArrayList<com.travel.object.pageresponse.Response>();
            pageResponse.setResponse((List)response);
            model.addAttribute("pageResponse", pageResponse.getResponse().get(0));
            model.addAttribute("page", (Object)pageName);
        }
        return "cities-to";
    }
    
    @GetMapping({ "/blogs" })
    public String blogs(final Model model) {
        System.out.println(" Blogs Method Calling.....");
        BlogsResponse blogresponse = new BlogsResponse();
        model.addAttribute("airlineList", (Object)Utility.getAirlines());
        final RestTemplate rest = new RestTemplate();
        final ObjectMapper mapper = new ObjectMapper();
        final BlogsRequest request = new BlogsRequest();
        request.setSiteId("1");
        String blogRS = (String)rest.postForObject(String.valueOf(String.valueOf(this.pageApiUrl)) + "/showblogdata?authcode=ebooktrip", (Object)request, (Class)String.class, new Object[0]);
        blogRS = this.Spanish_Repair(blogRS);
        System.out.println("blogRS>>" + blogRS);
        try {
            blogresponse = (BlogsResponse)mapper.readValue(blogRS, (Class)BlogsResponse.class);
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
        if (blogresponse.getResponse().size() == 0) {
            return "redirect:/";
        }
        model.addAttribute("blogResponse", (Object)blogresponse.getResponse());
        return "blogs";
    }
    
    @GetMapping({ "/blogs/{page}" })
    public String blogPages(@PathVariable final String page, final Model model) throws JsonProcessingException {
        System.out.println(" BlogPages method Calling ..... " + page);
        final BlogsRequest req1 = new BlogsRequest();
        final RestTemplate rest = new RestTemplate();
        final ObjectMapper mapper = new ObjectMapper();
        req1.setTitleUrl(page);
        req1.setSiteId("1");
        System.out.println("Blog Page Request is :-- " + mapper.writeValueAsString((Object)req1));
        final String blogPageURL = "http://44.235.26.108/content/blogdatabyid?authcode=ebooktrip";
        final String blogPageRS = (String)rest.postForObject("http://44.235.26.108/content/blogdatabyid?authcode=ebooktrip", (Object)req1, (Class)String.class, new Object[0]);
        System.out.println("Blog-Page Response :- " + blogPageRS);
        BlogsResponse blogRes = new BlogsResponse();
        try {
            blogRes = (BlogsResponse)mapper.readValue(blogPageRS.replaceAll("\ufffd", " ").toString(), (Class)BlogsResponse.class);
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
    
    @PostMapping({ "/review/submit" })
    @ResponseBody
    public String reviewsubmit(@RequestBody final ReviewRequest reviewRequest) {
        System.out.println(" reviewsubmit Method Calling.. ");
        System.out.println("UserName:" + reviewRequest.getUserName());
        final Date currDate = new Date();
        final RestTemplate rest = new RestTemplate();
        final ObjectMapper mapper = new ObjectMapper();
        reviewRequest.setSiteId("1");
        reviewRequest.setUserPhone("");
        reviewRequest.setReviewDate(currDate.toString());
        reviewRequest.setReviewStatus("Inactive");
        reviewRequest.setReviewRpyId("2");
        try {
            System.out.println("Review Submit Request :-- " + mapper.writeValueAsString((Object)reviewRequest));
        }
        catch (Exception ex) {}
        final String reviewRS = (String)rest.postForObject(String.valueOf(String.valueOf(this.pageApiUrl)) + "/addreview?authcode=ebooktrip", (Object)reviewRequest, (Class)String.class, new Object[0]);
        System.out.println(" ReviewSubmit Response:: " + reviewRS);
        return reviewRS;
    }
    
    @PostMapping({ "/newsletter/submit" })
    @ResponseBody
    public String newslettersubmit(@RequestBody final NewsletterRequest newsletterRequest) {
        final Date currDate = new Date();
        final RestTemplate rest = new RestTemplate();
        final ObjectMapper mapper = new ObjectMapper();
        newsletterRequest.setDate(currDate.toString());
        newsletterRequest.setSiteId(Integer.valueOf(1));
        newsletterRequest.setStatus("Active");
        newsletterRequest.setUrl("https://www.ebooktrip.com");
        newsletterRequest.setEmailId(newsletterRequest.getEmailId());
        try {
            System.out.println("NewsletterRequest:: " + mapper.writeValueAsString((Object)newsletterRequest));
        }
        catch (JsonProcessingException e1) {
            e1.printStackTrace();
        }
        final String newsletterURL = "http://44.235.26.108/subscribe/addNewsletter?authcode=ebooktrip";
        final String newsletterRS = (String)rest.postForObject("http://44.235.26.108/subscribe/addNewsletter?authcode=ebooktrip", (Object)newsletterRequest, (Class)String.class, new Object[0]);
        System.out.println("NewsletterRequest" + newsletterRS);
        NewsletterResponse subscribeObj = new NewsletterResponse();
        try {
            subscribeObj = (NewsletterResponse)mapper.readValue(newsletterRS, (Class)NewsletterResponse.class);
        }
        catch (JsonParseException e2) {
            e2.printStackTrace();
        }
        catch (JsonMappingException e3) {
            e3.printStackTrace();
        }
        catch (IOException e4) {
            e4.printStackTrace();
        }
        String status = "false";
        if (subscribeObj.getBaseResponse().getStatus() == 1) {
            final SubscribeMail email = new SubscribeMail();
            final String emailBody = email.buildSubscribeMail(newsletterRequest.getEmailId(), "newsletter");
            final EmailFormat emailSend = new EmailFormat();
            emailSend.setBookingID("");
            emailSend.setFromEmail("noreply@ebooktrip.com");
            emailSend.setToEmail("bookings@ebooktrip.com");
            emailSend.setCcEmail("");
            emailSend.setMailBody(emailBody);
            emailSend.setMailSubject("Registered Susccessfully From " + newsletterRequest.getEmailId());
            try {
                status = this.mailService.SendMail(emailSend, "smtp.gmail.com", "465", "Bhavika@1187");
            }
            catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        else {
            status = "false";
        }
        return status;
    }
    
    @PostMapping({ "/subscribesubmit/{emailId}" })
    @ResponseBody
    public String subscribesubmit(@PathVariable final String emailId) {
        System.out.println("Subscribe_email::" + emailId);
        final RestTemplate rest = new RestTemplate();
        final ObjectMapper mapper = new ObjectMapper();
        final Date d = new Date();
        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String dateString = format.format(d);
        final SubscribeRequest reqObj = new SubscribeRequest();
        reqObj.setDate(dateString);
        reqObj.setEmailid(emailId);
        reqObj.setStatus("Active");
        reqObj.setSiteId(Integer.valueOf(this.siteId));
        reqObj.setUrl("https://www.ebooktrip.com");
        try {
            System.out.println("NewsletterRequest:: " + mapper.writeValueAsString((Object)reqObj));
        }
        catch (JsonProcessingException e1) {
            e1.printStackTrace();
        }
        final String subscribeURL = "http://44.235.26.108/subscribe/addNewsletter?authcode=ebooktrip";
        final String subscribeRS = (String)rest.postForObject("http://44.235.26.108/subscribe/addNewsletter?authcode=ebooktrip", (Object)reqObj, (Class)String.class, new Object[0]);
        System.out.println("Subscribe Response:: " + subscribeRS);
        NewsletterResponse subscribeObj = new NewsletterResponse();
        try {
            subscribeObj = (NewsletterResponse)mapper.readValue(subscribeRS, (Class)NewsletterResponse.class);
        }
        catch (JsonParseException e2) {
            e2.printStackTrace();
        }
        catch (JsonMappingException e3) {
            e3.printStackTrace();
        }
        catch (IOException e4) {
            e4.printStackTrace();
        }
        String status = "false";
        if (subscribeObj.getBaseResponse().getStatus() == 1) {
            final SubscribeMail email = new SubscribeMail();
            final String emailBody = email.buildSubscribeMail(emailId, "subscribe");
            final EmailFormat emailSend = new EmailFormat();
            emailSend.setBookingID("");
            emailSend.setFromEmail("noreply@ebooktrip.com");
            emailSend.setToEmail("bookings@ebooktrip.com");
            emailSend.setCcEmail("bookings@ebooktrip.com");
            emailSend.setMailBody(emailBody);
            emailSend.setMailSubject("Subscribe Mail from " + emailId);
            try {
                status = this.mailService.SendMail(emailSend, "smtp.gmail.com", "465", "Bhavika@1187");
            }
            catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        else {
            status = "false";
        }
        return status;
    }
    
    public int getDayDiff(final String date1, final String date2) {
        final SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        float daysBetween = 0.0f;
        try {
            final Date dateBefore = myFormat.parse(date1);
            final Date dateAfter = myFormat.parse(date2);
            final long difference = dateAfter.getTime() - dateBefore.getTime();
            daysBetween = (float)(difference / 86400000L);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return (int)daysBetween;
    }
    
    public String Spanish_Repair(String sValue) {
        sValue = sValue.replace("&iquest;", "¿");
        sValue = sValue.replace("&aacute;", "\u00e1");
        sValue = sValue.replace("&uacute;", "\u00fa");
        sValue = sValue.replace("&eacute;", "\u00e9");
        sValue = sValue.replace("&oacute;", "\u00f3");
        sValue = sValue.replace("&oicute;", "\u00ed");
        sValue = sValue.replace("&ntilde;", "\u00f1");
        sValue = sValue.replace("&ntilde;", "\u00f1");
        sValue = sValue.replace("&nbsp;", " ");
        sValue = sValue.replace("&amp;", "&");
        sValue = sValue.replace("&#8239;", " ");
        sValue = sValue.replace("&rsquo;", "'");
        sValue = sValue.replace("&rsquo;", "'");
        sValue = sValue.replace("&iacute;", "í");
        sValue = sValue.replace("&#39;", "'");
       
        return sValue;
    }
}
