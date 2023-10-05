
package com.travel.object.farealert;

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
    "fareAlertId",
    "depCity",
    "arrCity",
    "depDate",
    "retDate",
    "currencyType",
    "totalAmount",
    "quoteAmount",
    "emailId",
    "phoneNum"
})
public class FareAlertRequest {

    @JsonProperty("fareAlertId")
    private Integer fareAlertId;
    @JsonProperty("depCity")
    private String depCity;
    @JsonProperty("arrCity")
    private String arrCity;
    @JsonProperty("depDate")
    private String depDate;
    @JsonProperty("retDate")
    private String retDate;
    @JsonProperty("currencyType")
    private String currencyType;
    @JsonProperty("totalAmount")
    private String totalAmount;
    @JsonProperty("quoteAmount")
    private String quoteAmount;
    @JsonProperty("emailId")
    private String emailId;
    @JsonProperty("phoneNum")
    private String phoneNum;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("fareAlertId")
    public Integer getFareAlertId() {
        return fareAlertId;
    }

    @JsonProperty("fareAlertId")
    public void setFareAlertId(Integer fareAlertId) {
        this.fareAlertId = fareAlertId;
    }

    @JsonProperty("depCity")
    public String getDepCity() {
        return depCity;
    }

    @JsonProperty("depCity")
    public void setDepCity(String depCity) {
        this.depCity = depCity;
    }

    @JsonProperty("arrCity")
    public String getArrCity() {
        return arrCity;
    }

    @JsonProperty("arrCity")
    public void setArrCity(String arrCity) {
        this.arrCity = arrCity;
    }

    @JsonProperty("depDate")
    public String getDepDate() {
        return depDate;
    }

    @JsonProperty("depDate")
    public void setDepDate(String depDate) {
        this.depDate = depDate;
    }

    @JsonProperty("retDate")
    public String getRetDate() {
        return retDate;
    }

    @JsonProperty("retDate")
    public void setRetDate(String retDate) {
        this.retDate = retDate;
    }

    @JsonProperty("currencyType")
    public String getCurrencyType() {
        return currencyType;
    }

    @JsonProperty("currencyType")
    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    @JsonProperty("totalAmount")
    public String getTotalAmount() {
        return totalAmount;
    }

    @JsonProperty("totalAmount")
    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    @JsonProperty("quoteAmount")
    public String getQuoteAmount() {
        return quoteAmount;
    }

    @JsonProperty("quoteAmount")
    public void setQuoteAmount(String quoteAmount) {
        this.quoteAmount = quoteAmount;
    }

    @JsonProperty("emailId")
    public String getEmailId() {
        return emailId;
    }

    @JsonProperty("emailId")
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @JsonProperty("phoneNum")
    public String getPhoneNum() {
        return phoneNum;
    }

    @JsonProperty("phoneNum")
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
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
