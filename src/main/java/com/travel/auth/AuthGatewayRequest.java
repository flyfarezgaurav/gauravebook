package com.travel.auth;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authId",
    "siteId",
    "bookingId",
    "gdsPnr",
    "totalAmount",
    "response",
    "authCode",
    "transId",
    "authStatus",
    "chargeDate",
    "chargedBy",
    "gatewayName"
})
@Generated("jsonschema2pojo")
public class AuthGatewayRequest {

    @JsonProperty("authId")
    private Integer authId;
    @JsonProperty("siteId")
    private Integer siteId;
    @JsonProperty("bookingId")
    private String bookingId;
    @JsonProperty("gdsPnr")
    private String gdsPnr;
    @JsonProperty("totalAmount")
    private Double totalAmount;
    @JsonProperty("response")
    private String response;
    @JsonProperty("authCode")
    private String authCode;
    @JsonProperty("transId")
    private String transId;
    @JsonProperty("authStatus")
    private String authStatus;
    @JsonProperty("chargeDate")
    private String chargeDate;
    @JsonProperty("chargedBy")
    private String chargedBy;
    @JsonProperty("gatewayName")
    private String gatewayName;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("authId")
    public Integer getAuthId() {
        return authId;
    }

    @JsonProperty("authId")
    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    @JsonProperty("siteId")
    public Integer getSiteId() {
        return siteId;
    }

    @JsonProperty("siteId")
    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    @JsonProperty("bookingId")
    public String getBookingId() {
        return bookingId;
    }

    @JsonProperty("bookingId")
    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    @JsonProperty("gdsPnr")
    public String getGdsPnr() {
        return gdsPnr;
    }

    @JsonProperty("gdsPnr")
    public void setGdsPnr(String gdsPnr) {
        this.gdsPnr = gdsPnr;
    }

    @JsonProperty("totalAmount")
    public Double getTotalAmount() {
        return totalAmount;
    }

    @JsonProperty("totalAmount")
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @JsonProperty("response")
    public String getResponse() {
        return response;
    }

    @JsonProperty("response")
    public void setResponse(String response) {
        this.response = response;
    }

    @JsonProperty("authCode")
    public String getAuthCode() {
        return authCode;
    }

    @JsonProperty("authCode")
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    @JsonProperty("transId")
    public String getTransId() {
        return transId;
    }

    @JsonProperty("transId")
    public void setTransId(String transId) {
        this.transId = transId;
    }

    @JsonProperty("authStatus")
    public String getAuthStatus() {
        return authStatus;
    }

    @JsonProperty("authStatus")
    public void setAuthStatus(String authStatus) {
        this.authStatus = authStatus;
    }

    @JsonProperty("chargeDate")
    public String getChargeDate() {
        return chargeDate;
    }

    @JsonProperty("chargeDate")
    public void setChargeDate(String chargeDate) {
        this.chargeDate = chargeDate;
    }

    @JsonProperty("chargedBy")
    public String getChargedBy() {
        return chargedBy;
    }

    @JsonProperty("chargedBy")
    public void setChargedBy(String chargedBy) {
        this.chargedBy = chargedBy;
    }
    
    @JsonProperty("gatewayName")
	public String getGatewayName() {
		return gatewayName;
	}

    @JsonProperty("gatewayName")
	public void setGatewayName(String gatewayName) {
		this.gatewayName = gatewayName;
	}

	@JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
