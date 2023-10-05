
package com.travel.object.HotelBookingRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.travel.object.bookingrequest.PaymentDetails;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "userSearchID",
    "userSessionID",
    "userIP",
    "BrowserDetails",
    "bookingID",
    "prodID",
    "transactionID", 
    "adults",
    "child",
    "passengerDetails",
    "updatedBookingAmount",
    "siteID",
    "sourceMedia",
    "currencyCode",
    "macpAmount",
    "tripMateAmount",
    "checkInDate",
    "checkOutDate",
    "room",
    "childOneAge1",
    "childOneAge2",
    "adultTwo",
    "childTwo",
    "childTwoAge1",
    "childTwoAge2",
    "totalNight",
    "tbohotel",
    "phoneNo",
    "mobileNo",
    "emailID",
    "emailID2",
    "paymentDetails"
})
public class HotelBookingRequest {

    @JsonProperty("userSearchID")
    private String userSearchID;
    @JsonProperty("userSessionID")
    private String userSessionID;
    @JsonProperty("userIP")
    private String userIP;
    @JsonProperty("BrowserDetails")
    private String browserDetails;
    @JsonProperty("bookingID")
    private Integer bookingID;
    @JsonProperty("prodID")
    private Integer prodID;
    @JsonProperty("transactionID")
    private Integer transactionID;
    @JsonProperty("adults")
    private Integer adults;
    @JsonProperty("child")
    private Integer child;
    @JsonProperty("passengerDetails")
    private List<PassengerDetail> passengerDetails = null;
    @JsonProperty("updatedBookingAmount")
    private Integer updatedBookingAmount;
    @JsonProperty("siteID")
    private Integer siteID;
    @JsonProperty("sourceMedia")
    private String sourceMedia;
    @JsonProperty("currencyCode")
    private String currencyCode;
    @JsonProperty("macpAmount")
    private Integer macpAmount;
    @JsonProperty("tripMateAmount")
    private Integer tripMateAmount;
    @JsonProperty("checkInDate")
    private String checkInDate;
    @JsonProperty("checkOutDate")
    private String checkOutDate;
    @JsonProperty("room")
    private Integer room;
    @JsonProperty("childOneAge1")
    private Integer childOneAge1;
    @JsonProperty("childOneAge2")
    private Integer childOneAge2;
    @JsonProperty("adultTwo")
    private Integer adultTwo;
    @JsonProperty("childTwo")
    private Integer childTwo;
    @JsonProperty("childTwoAge1")
    private Integer childTwoAge1;
    @JsonProperty("childTwoAge2")
    private Integer childTwoAge2;
    @JsonProperty("totalNight")
    private Integer totalNight;
    @JsonProperty("tbohotel")
    private Tbohotel tbohotel;
    
    @JsonProperty("phoneNo")
    private String phoneNo;
    @JsonProperty("mobileNo")
    private String mobileNo;
    @JsonProperty("emailID")
    private String emailID;
    @JsonProperty("emailID2")
    private String emailID2;
    @JsonProperty("paymentDetails")
    private PaymentDetails paymentDetails;
    @JsonProperty("Rooms")
    private List<Room> rooms = new ArrayList<Room>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("userSearchID")
    public String getUserSearchID() {
        return userSearchID;
    }

    @JsonProperty("userSearchID")
    public void setUserSearchID(String userSearchID) {
        this.userSearchID = userSearchID;
    }

    @JsonProperty("userSessionID")
    public String getUserSessionID() {
        return userSessionID;
    }

    @JsonProperty("userSessionID")
    public void setUserSessionID(String userSessionID) {
        this.userSessionID = userSessionID;
    }

    @JsonProperty("userIP")
    public String getUserIP() {
        return userIP;
    }

    @JsonProperty("userIP")
    public void setUserIP(String userIP) {
        this.userIP = userIP;
    }

    @JsonProperty("BrowserDetails")
    public String getBrowserDetails() {
        return browserDetails;
    }

    @JsonProperty("BrowserDetails")
    public void setBrowserDetails(String browserDetails) {
        this.browserDetails = browserDetails;
    }

    @JsonProperty("bookingID")
    public Integer getBookingID() {
        return bookingID;
    }

    @JsonProperty("bookingID")
    public void setBookingID(Integer bookingID) {
        this.bookingID = bookingID;
    }

    @JsonProperty("prodID")
    public Integer getProdID() {
        return prodID;
    }

    @JsonProperty("prodID")
    public void setProdID(Integer prodID) {
        this.prodID = prodID;
    }

    @JsonProperty("transactionID")
    public Integer getTransactionID() {
        return transactionID;
    }

    @JsonProperty("transactionID")
    public void setTransactionID(Integer transactionID) {
        this.transactionID = transactionID;
    }

    @JsonProperty("adults")
    public Integer getAdults() {
        return adults;
    }

    @JsonProperty("adults")
    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    @JsonProperty("child")
    public Integer getChild() {
        return child;
    }

    @JsonProperty("child")
    public void setChild(Integer child) {
        this.child = child;
    }

    @JsonProperty("passengerDetails")
    public List<PassengerDetail> getPassengerDetails() {
        return passengerDetails;
    }

    @JsonProperty("passengerDetails")
    public void setPassengerDetails(List<PassengerDetail> passengerDetails) {
        this.passengerDetails = passengerDetails;
    }

    @JsonProperty("updatedBookingAmount")
    public Integer getUpdatedBookingAmount() {
        return updatedBookingAmount;
    }

    @JsonProperty("updatedBookingAmount")
    public void setUpdatedBookingAmount(Integer updatedBookingAmount) {
        this.updatedBookingAmount = updatedBookingAmount;
    }

    @JsonProperty("siteID")
    public Integer getSiteID() {
        return siteID;
    }

    @JsonProperty("siteID")
    public void setSiteID(Integer siteID) {
        this.siteID = siteID;
    }

    @JsonProperty("sourceMedia")
    public String getSourceMedia() {
        return sourceMedia;
    }

    @JsonProperty("sourceMedia")
    public void setSourceMedia(String sourceMedia) {
        this.sourceMedia = sourceMedia;
    }

    @JsonProperty("currencyCode")
    public String getCurrencyCode() {
        return currencyCode;
    }

    @JsonProperty("currencyCode")
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @JsonProperty("macpAmount")
    public Integer getMacpAmount() {
        return macpAmount;
    }

    @JsonProperty("macpAmount")
    public void setMacpAmount(Integer macpAmount) {
        this.macpAmount = macpAmount;
    }

    @JsonProperty("tripMateAmount")
    public Integer getTripMateAmount() {
        return tripMateAmount;
    }

    @JsonProperty("tripMateAmount")
    public void setTripMateAmount(Integer tripMateAmount) {
        this.tripMateAmount = tripMateAmount;
    }

    @JsonProperty("checkInDate")
    public String getCheckInDate() {
        return checkInDate;
    }

    @JsonProperty("checkInDate")
    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    @JsonProperty("checkOutDate")
    public String getCheckOutDate() {
        return checkOutDate;
    }

    @JsonProperty("checkOutDate")
    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    @JsonProperty("room")
    public Integer getRoom() {
        return room;
    }

    @JsonProperty("room")
    public void setRoom(Integer room) {
        this.room = room;
    }

    @JsonProperty("childOneAge1")
    public Integer getChildOneAge1() {
        return childOneAge1;
    }

    @JsonProperty("childOneAge1")
    public void setChildOneAge1(Integer childOneAge1) {
        this.childOneAge1 = childOneAge1;
    }

    @JsonProperty("childOneAge2")
    public Integer getChildOneAge2() {
        return childOneAge2;
    }

    @JsonProperty("childOneAge2")
    public void setChildOneAge2(Integer childOneAge2) {
        this.childOneAge2 = childOneAge2;
    }

    @JsonProperty("adultTwo")
    public Integer getAdultTwo() {
        return adultTwo;
    }

    @JsonProperty("adultTwo")
    public void setAdultTwo(Integer adultTwo) {
        this.adultTwo = adultTwo;
    }

    @JsonProperty("childTwo")
    public Integer getChildTwo() {
        return childTwo;
    }

    @JsonProperty("childTwo")
    public void setChildTwo(Integer childTwo) {
        this.childTwo = childTwo;
    }

    @JsonProperty("childTwoAge1")
    public Integer getChildTwoAge1() {
        return childTwoAge1;
    }

    @JsonProperty("childTwoAge1")
    public void setChildTwoAge1(Integer childTwoAge1) {
        this.childTwoAge1 = childTwoAge1;
    }

    @JsonProperty("childTwoAge2")
    public Integer getChildTwoAge2() {
        return childTwoAge2;
    }

    @JsonProperty("childTwoAge2")
    public void setChildTwoAge2(Integer childTwoAge2) {
        this.childTwoAge2 = childTwoAge2;
    }

    @JsonProperty("totalNight")
    public Integer getTotalNight() {
        return totalNight;
    }

    @JsonProperty("totalNight")
    public void setTotalNight(Integer totalNight) {
        this.totalNight = totalNight;
    }

    @JsonProperty("tbohotel")
    public Tbohotel getTbohotel() {
        return tbohotel;
    }

    @JsonProperty("tbohotel")
    public void setTbohotel(Tbohotel tbohotel) {
        this.tbohotel = tbohotel;
    }

    
    public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getEmailID2() {
		return emailID2;
	}

	public void setEmailID2(String emailID2) {
		this.emailID2 = emailID2;
	}

	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	@JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
    

}
