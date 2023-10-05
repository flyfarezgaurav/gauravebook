
package com.travel.object.flightresponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.travel.object.checkFareRulesResponse.FareFamily;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "resultID",
    "valCarrier",
    "fareType",
    "gdsType",
    "cabinClass",
    "fare",
    "outBound",
    "inBound",
    "fareFamilyRef",
    "booking_token",
    "consId",
    "outEFT",
    "inEFT",
    "maxSeat",
    "airline",
    "otherBound",
    "fareFamily",
    "currencyCode"
})

public class FlightResult {
	@JsonProperty("currencyCode")
    private String currencyCode;
    @JsonProperty("resultID")
    private Integer resultID;
    @JsonProperty("valCarrier")
    private String valCarrier;
    @JsonProperty("fareType")
    private String fareType;
    @JsonProperty("gdsType")
    private Integer gdsType;
    @JsonProperty("cabinClass")
    private Integer cabinClass;
    @JsonProperty("fare")
    private Fare fare;
    @JsonProperty("outBound")
    private List<OutBound> outBound = null;
    @JsonProperty("inBound")
    private List<InBound> inBound = null;
    @JsonProperty("fareFamilyRef")
    private List<FareFamilyRef> fareFamilyRef = null;
    @JsonProperty("booking_token")
    private String bookingToken;
    @JsonProperty("consId")
    private String consId;
    @JsonProperty("outEFT")
    private Integer outEFT;
    @JsonProperty("inEFT")
    private Integer inEFT;
    @JsonProperty("maxSeat")
    private Integer maxSeat;
    @JsonProperty("airline")
    private String airline;
    @JsonProperty("otherBound")
    private List<List<OtherBound>> otherBound = null;
    @JsonProperty("fareFamily")
    private List<FareFamily> fareFamily = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
    @JsonProperty("fareFamily")
    public List<FareFamily> getFareFamily() {
        return fareFamily;
    }

    @JsonProperty("fareFamily")
    public void setFareFamily(List<FareFamily> fareFamily) {
        this.fareFamily = fareFamily;
    }
    
    @JsonProperty("resultID")
    public Integer getResultID() {
        return resultID;
    }

    @JsonProperty("resultID")
    public void setResultID(Integer resultID) {
        this.resultID = resultID;
    }

    @JsonProperty("valCarrier")
    public String getValCarrier() {
        return valCarrier;
    }

    @JsonProperty("valCarrier")
    public void setValCarrier(String valCarrier) {
        this.valCarrier = valCarrier;
    }

    @JsonProperty("fareType")
    public String getFareType() {
        return fareType;
    }

    @JsonProperty("fareType")
    public void setFareType(String fareType) {
        this.fareType = fareType;
    }

    @JsonProperty("gdsType")
    public Integer getGdsType() {
        return gdsType;
    }

    @JsonProperty("gdsType")
    public void setGdsType(Integer gdsType) {
        this.gdsType = gdsType;
    }

    @JsonProperty("cabinClass")
    public Integer getCabinClass() {
        return cabinClass;
    }

    @JsonProperty("cabinClass")
    public void setCabinClass(Integer cabinClass) {
        this.cabinClass = cabinClass;
    }

    @JsonProperty("fare")
    public Fare getFare() {
        return fare;
    }

    @JsonProperty("fare")
    public void setFare(Fare fare) {
        this.fare = fare;
    }

    @JsonProperty("outBound")
    public List<OutBound> getOutBound() {
        return outBound;
    }

    @JsonProperty("outBound")
    public void setOutBound(List<OutBound> outBound) {
        this.outBound = outBound;
    }

    @JsonProperty("inBound")
    public List<InBound> getInBound() {
        return inBound;
    }

    @JsonProperty("inBound")
    public void setInBound(List<InBound> inBound) {
        this.inBound = inBound;
    }

    @JsonProperty("booking_token")
    public String getBookingToken() {
        return bookingToken;
    }

    @JsonProperty("booking_token")
    public void setBookingToken(String bookingToken) {
        this.bookingToken = bookingToken;
    }

    @JsonProperty("consId")
    public String getConsId() {
        return consId;
    }

    @JsonProperty("consId")
    public void setConsId(String consId) {
        this.consId = consId;
    }

    @JsonProperty("outEFT")
    public Integer getOutEFT() {
        return outEFT;
    }

    @JsonProperty("outEFT")
    public void setOutEFT(Integer outEFT) {
        this.outEFT = outEFT;
    }

    @JsonProperty("inEFT")
    public Integer getInEFT() {
        return inEFT;
    }

    @JsonProperty("inEFT")
    public void setInEFT(Integer inEFT) {
        this.inEFT = inEFT;
    }

    @JsonProperty("maxSeat")
    public Integer getMaxSeat() {
        return maxSeat;
    }

    @JsonProperty("maxSeat")
    public void setMaxSeat(Integer maxSeat) {
        this.maxSeat = maxSeat;
    }

    @JsonProperty("airline")
    public String getAirline() {
        return airline;
    }

    @JsonProperty("airline")
    public void setAirline(String airline) {
        this.airline = airline;
    }

    @JsonProperty("otherBound")
    public List<List<OtherBound>> getOtherBound() {
        return otherBound;
    }

    @JsonProperty("otherBound")
    public void setOtherBound(List<List<OtherBound>> otherBound) {
        this.otherBound = otherBound;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    
	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public List<FareFamilyRef> getFareFamilyRef() {
		return fareFamilyRef;
	}

	public void setFareFamilyRef(List<FareFamilyRef> fareFamilyRef) {
		this.fareFamilyRef = fareFamilyRef;
	}

}
