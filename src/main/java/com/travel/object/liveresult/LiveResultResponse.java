
package com.travel.object.liveresult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.travel.object.flightresponse.FlightResult;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "SearchID",
    "bookingID",
    "adults",
    "child",
    "infants",
    "infantsWs",
    "passengerDetails",
    "siteID",
    "sourceMedia",
    "couponsAmt",
    "userSessionID",
    "liveflightResult",
    "serviceCharge"
})
public class LiveResultResponse {

    @JsonProperty("SearchID")
    private String searchID;
    @JsonProperty("bookingID")
    private Integer bookingID;
    @JsonProperty("adults")
    private Integer adults;
    @JsonProperty("child")
    private Integer child;
    @JsonProperty("infants")
    private Integer infants;
    @JsonProperty("infantsWs")
    private Integer infantsWs;
    @JsonProperty("passengerDetails")
    private List<PassengerDetail> passengerDetails = null;
    @JsonProperty("siteID")
    private Integer siteID;
    @JsonProperty("sourceMedia")
    private String sourceMedia;
    @JsonProperty("couponsAmt")
    private Double couponsAmt;
    @JsonProperty("userSessionID")
    private String userSessionID;
    @JsonProperty("liveflightResult")
    private List<FlightResult> liveflightResult = null;
    @JsonProperty("serviceCharge")
    private Double serviceCharge;
    @JsonProperty("prodID")
    private String prodID;
    @JsonProperty("emailID")
    private String emailID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("SearchID")
    public String getSearchID() {
        return searchID;
    }

    @JsonProperty("SearchID")
    public void setSearchID(String searchID) {
        this.searchID = searchID;
    }

    @JsonProperty("bookingID")
    public Integer getBookingID() {
        return bookingID;
    }

    @JsonProperty("bookingID")
    public void setBookingID(Integer bookingID) {
        this.bookingID = bookingID;
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

    @JsonProperty("passengerDetails")
    public List<PassengerDetail> getPassengerDetails() {
        return passengerDetails;
    }

    @JsonProperty("passengerDetails")
    public void setPassengerDetails(List<PassengerDetail> passengerDetails) {
        this.passengerDetails = passengerDetails;
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

    @JsonProperty("couponsAmt")
    public Double getCouponsAmt() {
        return couponsAmt;
    }

    @JsonProperty("couponsAmt")
    public void setCouponsAmt(Double couponsAmt) {
        this.couponsAmt = couponsAmt;
    }

    @JsonProperty("userSessionID")
    public String getUserSessionID() {
        return userSessionID;
    }

    @JsonProperty("userSessionID")
    public void setUserSessionID(String userSessionID) {
        this.userSessionID = userSessionID;
    }

    @JsonProperty("liveflightResult")
    public List<FlightResult> getLiveflightResult() {
        return liveflightResult;
    }

    @JsonProperty("liveflightResult")
    public void setLiveflightResult(List<FlightResult> liveflightResult) {
        this.liveflightResult = liveflightResult;
    }

    @JsonProperty("serviceCharge")
    public Double getServiceCharge() {
        return serviceCharge;
    }

    @JsonProperty("serviceCharge")
    public void setServiceCharge(Double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	public String getProdID() {
		return prodID;
	}

	public void setProdID(String prodID) { 
		this.prodID = prodID;
	}
	@JsonProperty("emailID")
	public String getEmailID() {
		return emailID;
	}
	@JsonProperty("emailID")
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

}
