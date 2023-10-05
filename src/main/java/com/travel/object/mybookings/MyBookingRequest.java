
package com.travel.object.mybookings;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "siteId",
    "bookingType",
    "productType",
    "bookingId",
    "checkTkt",
    "emailId",
    "mobile",
    "referenceNum"
})
public class MyBookingRequest {

    @JsonProperty("siteId")
    private String siteId;
    @JsonProperty("bookingType")
    private String bookingType;
    @JsonProperty("productType")
    private String productType;
    @JsonProperty("bookingId")
    private String bookingId;
    @JsonProperty("checkTkt")
    private Boolean checkTkt;
    @JsonProperty("emailId")
    private String emailId;
    @JsonProperty("mobile")
    private String mobile;
    @JsonProperty("referenceNum")
    private String referenceNum;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("siteId")
    public String getSiteId() {
        return siteId;
    }

    @JsonProperty("siteId")
    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    @JsonProperty("bookingType")
    public String getBookingType() {
        return bookingType;
    }

    @JsonProperty("bookingType")
    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    @JsonProperty("productType")
    public String getProductType() {
        return productType;
    }

    @JsonProperty("productType")
    public void setProductType(String productType) {
        this.productType = productType;
    }

    @JsonProperty("bookingId")
    public String getBookingId() {
        return bookingId;
    }

    @JsonProperty("bookingId")
    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    @JsonProperty("checkTkt")
    public Boolean getCheckTkt() {
        return checkTkt;
    }

    @JsonProperty("checkTkt")
    public void setCheckTkt(Boolean checkTkt) {
        this.checkTkt = checkTkt;
    }

    @JsonProperty("emailId")
    public String getEmailId() {
        return emailId;
    }

    @JsonProperty("emailId")
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @JsonProperty("mobile")
    public String getMobile() {
        return mobile;
    }

    @JsonProperty("mobile")
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @JsonProperty("referenceNum")
    public String getReferenceNum() {
        return referenceNum;
    }

    @JsonProperty("referenceNum")
    public void setReferenceNum(String referenceNum) {
        this.referenceNum = referenceNum;
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
