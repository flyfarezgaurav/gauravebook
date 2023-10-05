
package com.travel.object.bookingrequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.travel.object.bookingrequest.AncillaryService;
import com.travel.object.bookingrequest.ancillaryServices.AncillaryProduct;
import com.travel.object.checkFareRulesResponse.FareFamily;
import com.travel.object.flightresponse.FlightResult;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "flightResult",
    "adults",
    "child",
    "infants",
    "infantsWs",
    "SearchID",
    "bookingID",
    "prodID",
    "departDate",
    "paymentDetails",
    "passengerDetails",
    "phoneNo",
    "mobileNo",
    "emailID",
    "siteID",
    "sourceMedia",
    "userIP",
    "device",
    "browser",
    "coupons",
    "couponsCode",
    "couponsAmt",
    "totalNight",
    "userSessionID",
    "CacheLocation",
    "returnDate",
    "currencyCode",
    "emailID1",
    "IsTimeChanged",
    "newPrice",
    "travelGuard",
    "travelGuardCost",
    "tcpCost",
    "ancillaryServices",
    "IsPriceChange",
    "IsSoldOut",
    "AncillaryProduct",
    "priceDropTaken",
    "priceDropAmount",
    "travelAssistTaken",
    "travelAssistAmount",
    "fareFamily",
    "upgradeTaken",
    "upgradeAmount"
})

public class BookingRequest {
	
    @JsonProperty("flightResult")
    private FlightResult flightResult;
    @JsonProperty("adults")
    private Integer adults;
    @JsonProperty("child")
    private Integer child;
    @JsonProperty("infants")
    private Integer infants;
    @JsonProperty("infantsWs")
    private Integer infantsWs;
    @JsonProperty("SearchID")
    private String searchID;
    @JsonProperty("bookingID")
    private String bookingID;
    @JsonProperty("prodID")
    private String prodID;
    @JsonProperty("departDate") 
    private String departDate;
    @JsonProperty("paymentDetails")
    private PaymentDetails paymentDetails;
    @JsonProperty("passengerDetails")
    private List<PassengerDetail> passengerDetails = null;
    @JsonProperty("phoneNo")
    private String phoneNo;
    @JsonProperty("mobileNo")
    private String mobileNo;
    @JsonProperty("emailID")
    private String emailID;
    @JsonProperty("siteID")
    private Integer siteID;
    @JsonProperty("sourceMedia")
    private String sourceMedia;
    @JsonProperty("userIP")
    private String userIP;
    @JsonProperty("device")
    private String device;
    @JsonProperty("browser")
    private String browser;
    @JsonProperty("coupons")
    private String coupons;
    @JsonProperty("couponsCode")
    private String couponsCode;
    @JsonProperty("couponsAmt")
    private Integer couponsAmt;
    @JsonProperty("totalNight")
    private Integer totalNight;
    @JsonProperty("userSessionID")
    private String userSessionID;
    @JsonProperty("CacheLocation")
    private String cacheLocation;
    @JsonProperty("returnDate")
    private String returnDate;
    @JsonProperty("currencyCode")
    private String currencyCode;
    @JsonProperty("emailID1")
    private String emailID1;
    @JsonProperty("IsTimeChanged")
    private Boolean isTimeChanged;
    @JsonProperty("newPrice")
    private Integer newPrice;
    private String bookingStatus;
    
    @JsonProperty("travelGuard")
    private String travelGuard;
    @JsonProperty("travelGuardCost")
    private Double travelGuardCost;
    
    @JsonProperty("tcptaken")
    private String tcptaken;
    @JsonProperty("tcpCost")
    private Double tcpCost;
    @JsonProperty("ancillaryServices")
    private List<AncillaryService> ancillaryServices = null;
    
    @JsonProperty("IsPriceChange")
    private Boolean isPriceChange=false;
    @JsonProperty("IsSoldOut")
    private Boolean isSoldOut=false;
    
    @JsonProperty("ancillaryProduct")
    private List<AncillaryProduct> ancillaryProduct = null;
    
    @JsonProperty("tgProductCode")
    private String tgProductCode;
    @JsonProperty("tgProductName")
    private String tgProductName;
    @JsonProperty("tgPlanCode")
    private String tgPlanCode;
    
    @JsonProperty("priceDropTaken")
    private String priceDropTaken;
    @JsonProperty("priceDropAmount")
    private double priceDropAmount;
    
    @JsonProperty("travelAssistAmount")
    private double travelAssistAmount;
    @JsonProperty("travelAssistTaken")
    private String travelAssistTaken;
    
    @JsonProperty("fareFamily")
    private List<FareFamily> fareFamily = null;
    @JsonProperty("upgradeTaken")
    private String upgradeTaken;
    @JsonProperty("upgradeAmount")
    private double upgradeAmount;
    @JsonProperty("upgradePlan")
    private String upgradePlan;
     private String webcheckin;
    private double webcheckincost;
    private List<String> freeTextLines;
    String currencySymbol;
    double currencyValue;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
    public List<String> getFreeTextLines() {
        return freeTextLines;
    }

    public void setFreeTextLines(List<String> freeTextLines) {
        this.freeTextLines = freeTextLines;
    }
    
    @JsonProperty("upgradePlan")
    public String getUpgradePlan() {
		return upgradePlan;
	}

    @JsonProperty("upgradePlan")
	public void setUpgradePlan(String upgradePlan) {
		this.upgradePlan = upgradePlan;
	}

	@JsonProperty("upgradeTaken")
    public String getUpgradeTaken() {
		return upgradeTaken;
	}
    
    @JsonProperty("upgradeTaken")
	public void setUpgradeTaken(String upgradeTaken) {
		this.upgradeTaken = upgradeTaken;
	}
    
    @JsonProperty("upgradeAmount")
	public double getUpgradeAmount() {
		return upgradeAmount;
	}

    @JsonProperty("upgradeAmount")
	public void setUpgradeAmount(double upgradeAmount) {
		this.upgradeAmount = upgradeAmount;
	}
    
	@JsonProperty("fareFamily")
    public List<FareFamily> getFareFamily() {
        return fareFamily;
    }
    
    @JsonProperty("fareFamily")
    public void setFareFamily(List<FareFamily> fareFamily) {
        this.fareFamily = fareFamily;
    }
    
    @JsonProperty("travelAssistAmount")
    public double getTravelAssistAmount() {
		return travelAssistAmount;
	}

    @JsonProperty("travelAssistAmount")
	public void setTravelAssistAmount(double travelAssistAmount) {
		this.travelAssistAmount = travelAssistAmount;
	}

    @JsonProperty("travelAssistTaken")
	public String getTravelAssistTaken() {
		return travelAssistTaken;
	}

    @JsonProperty("travelAssistTaken")
	public void setTravelAssistTaken(String travelAssistTaken) {
		this.travelAssistTaken = travelAssistTaken;
	}

	@JsonProperty("priceDropTaken")
    public String getPriceDropTaken() {
		return priceDropTaken;
	}

    @JsonProperty("priceDropTaken")
	public void setPriceDropTaken(String priceDropTaken) {
		this.priceDropTaken = priceDropTaken;
	}

    @JsonProperty("priceDropAmount")
	public double getPriceDropAmount() {
		return priceDropAmount;
	}

    @JsonProperty("priceDropAmount")
	public void setPriceDropAmount(double priceDropAmount) {
		this.priceDropAmount = priceDropAmount;
	}

	@JsonProperty("ancillaryProduct")
    public List<AncillaryProduct> getAncillaryProduct() {
		return ancillaryProduct;
	}
    
    @JsonProperty("ancillaryProduct")
	public void setAncillaryProduct(List<AncillaryProduct> ancillaryProduct) {
		this.ancillaryProduct = ancillaryProduct;
	}

	@JsonProperty("tgProductCode")
	public String getTgProductCode() {
		return tgProductCode;
	}

    @JsonProperty("tgProductCode")
	public void setTgProductCode(String tgProductCode) {
		this.tgProductCode = tgProductCode;
	}

    @JsonProperty("tgProductName")
	public String getTgProductName() {
		return tgProductName;
	}

    @JsonProperty("tgProductName")
	public void setTgProductName(String tgProductName) {
		this.tgProductName = tgProductName;
	}

    @JsonProperty("tgPlanCode")
	public String getTgPlanCode() {
		return tgPlanCode;
	}

    @JsonProperty("tgPlanCode")
	public void setTgPlanCode(String tgPlanCode) {
		this.tgPlanCode = tgPlanCode;
	}

	@JsonProperty("IsPriceChange")
    public Boolean getIsPriceChange() {
		return isPriceChange;
	}

    @JsonProperty("IsPriceChange")
	public void setIsPriceChange(Boolean isPriceChange) {
		this.isPriceChange = isPriceChange;
	}

    @JsonProperty("IsSoldOut")
	public Boolean getIsSoldOut() {
		return isSoldOut;
	}

    @JsonProperty("IsSoldOut")
	public void setIsSoldOut(Boolean isSoldOut) {
		this.isSoldOut = isSoldOut;
	}

	@JsonProperty("ancillaryServices")
    public List<AncillaryService> getAncillaryServices() {
        return ancillaryServices;
    }
    
    @JsonProperty("ancillaryServices")
    public void setAncillaryServices(List<AncillaryService> ancillaryServices) {
        this.ancillaryServices = ancillaryServices;
    }
    
    @JsonProperty("tcptaken")
    public String getTcptaken() {
		return tcptaken;
	}
    @JsonProperty("tcptaken")
	public void setTcptaken(String tcptaken) {
		this.tcptaken = tcptaken;
	}
    @JsonProperty("tcpCost")
	public Double getTcpCost() {
		return tcpCost;
	}
    @JsonProperty("tcpCost")
	public void setTcpCost(Double tcpCost) {
		this.tcpCost = tcpCost;
	}

	@JsonProperty("travelGuardCost")
    public Double getTravelGuardCost() {
		return travelGuardCost;
	}
    
    @JsonProperty("travelGuardCost")
	public void setTravelGuardCost(Double travelGuardCost) {
		this.travelGuardCost = travelGuardCost;
	}

	@JsonProperty("travelGuard")
	public String getTravelGuard() {
		return travelGuard;
	}
    
    @JsonProperty("travelGuard")
	public void setTravelGuard(String travelGuard) {
		this.travelGuard = travelGuard;
	}

	@JsonProperty("flightResult")
    public FlightResult getFlightResult() {
        return flightResult;
    }

    @JsonProperty("flightResult")
    public void setFlightResult(FlightResult flightResult) {
        this.flightResult = flightResult;
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

    @JsonProperty("infants")
    public Integer getInfants() {
        return infants;
    }

    @JsonProperty("infants")
    public void setInfants(Integer infants) {
        this.infants = infants;
    }

    @JsonProperty("infantsWs")
    public Integer getInfantsWs() {
        return infantsWs;
    }

    @JsonProperty("infantsWs")
    public void setInfantsWs(Integer infantsWs) {
        this.infantsWs = infantsWs;
    }

    @JsonProperty("SearchID")
    public String getSearchID() {
        return searchID;
    }

    @JsonProperty("SearchID")
    public void setSearchID(String searchID) {
        this.searchID = searchID;
    }

    @JsonProperty("bookingID")
    public String getBookingID() {
        return bookingID;
    }

    @JsonProperty("bookingID")
    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    @JsonProperty("prodID")
    public String getProdID() {
        return prodID;
    }

    @JsonProperty("prodID")
    public void setProdID(String prodID) {
        this.prodID = prodID;
    }

    @JsonProperty("departDate")
    public String getDepartDate() {
        return departDate;
    }

    @JsonProperty("departDate")
    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    @JsonProperty("paymentDetails")
    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    @JsonProperty("paymentDetails")
    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    @JsonProperty("passengerDetails")
    public List<PassengerDetail> getPassengerDetails() {
        return passengerDetails;
    }

    @JsonProperty("passengerDetails")
    public void setPassengerDetails(List<PassengerDetail> passengerDetails) {
        this.passengerDetails = passengerDetails;
    }

    @JsonProperty("phoneNo")
    public String getPhoneNo() {
        return phoneNo;
    }

    @JsonProperty("phoneNo")
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @JsonProperty("mobileNo")
    public String getMobileNo() {
        return mobileNo;
    }

    @JsonProperty("mobileNo")
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @JsonProperty("emailID")
    public String getEmailID() {
        return emailID;
    }

    @JsonProperty("emailID")
    public void setEmailID(String emailID) {
        this.emailID = emailID;
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

    @JsonProperty("userIP")
    public String getUserIP() {
        return userIP;
    }

    @JsonProperty("userIP")
    public void setUserIP(String userIP) {
        this.userIP = userIP;
    }

    @JsonProperty("device")
    public String getDevice() {
        return device;
    }

    @JsonProperty("device")
    public void setDevice(String device) {
        this.device = device;
    }

    @JsonProperty("browser")
    public String getBrowser() {
        return browser;
    }

    @JsonProperty("browser")
    public void setBrowser(String browser) {
        this.browser = browser;
    }

    @JsonProperty("coupons")
    public String getCoupons() {
        return coupons;
    }

    @JsonProperty("coupons")
    public void setCoupons(String coupons) {
        this.coupons = coupons;
    }

    @JsonProperty("couponsCode")
    public String getCouponsCode() {
        return couponsCode;
    }

    @JsonProperty("couponsCode")
    public void setCouponsCode(String couponsCode) {
        this.couponsCode = couponsCode;
    }

    @JsonProperty("couponsAmt")
    public Integer getCouponsAmt() {
        return couponsAmt;
    }

    @JsonProperty("couponsAmt")
    public void setCouponsAmt(Integer couponsAmt) {
        this.couponsAmt = couponsAmt;
    }

    @JsonProperty("totalNight")
    public Integer getTotalNight() {
        return totalNight;
    }

    @JsonProperty("totalNight")
    public void setTotalNight(Integer totalNight) {
        this.totalNight = totalNight;
    }

    @JsonProperty("userSessionID")
    public String getUserSessionID() {
        return userSessionID;
    }

    @JsonProperty("userSessionID")
    public void setUserSessionID(String userSessionID) {
        this.userSessionID = userSessionID;
    }

    @JsonProperty("CacheLocation")
    public String getCacheLocation() {
        return cacheLocation;
    }

    @JsonProperty("CacheLocation")
    public void setCacheLocation(String cacheLocation) {
        this.cacheLocation = cacheLocation;
    }

    @JsonProperty("returnDate")
    public String getReturnDate() {
        return returnDate;
    }

    @JsonProperty("returnDate")
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @JsonProperty("currencyCode")
    public String getCurrencyCode() {
        return currencyCode;
    }

    @JsonProperty("currencyCode")
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @JsonProperty("emailID1")
    public String getEmailID1() {
        return emailID1;
    }

    @JsonProperty("emailID1")
    public void setEmailID1(String emailID1) {
        this.emailID1 = emailID1;
    }

    @JsonProperty("IsTimeChanged")
    public Boolean getIsTimeChanged() {
        return isTimeChanged;
    }

    @JsonProperty("IsTimeChanged")
    public void setIsTimeChanged(Boolean isTimeChanged) {
        this.isTimeChanged = isTimeChanged;
    }

    @JsonProperty("newPrice")
    public Integer getNewPrice() {
        return newPrice;
    }

    @JsonProperty("newPrice")
    public void setNewPrice(Integer newPrice) {
        this.newPrice = newPrice;
    }

    	
    public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	
	
	public String getWebcheckin() {
		return webcheckin;
	}

	public void setWebcheckin(String webcheckin) {
		this.webcheckin = webcheckin;
	}

	public double getWebcheckincost() {
		return webcheckincost;
	}

	public void setWebcheckincost(double webcheckincost) {
		this.webcheckincost = webcheckincost;
	}

	@JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	public String getCurrencySymbol() {
		return currencySymbol;
	}

	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}

	public double getCurrencyValue() {
		return currencyValue;
	}

	public void setCurrencyValue(double currencyValue) {
		this.currencyValue = currencyValue;
	}

    
}
