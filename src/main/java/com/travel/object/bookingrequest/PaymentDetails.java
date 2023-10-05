
package com.travel.object.bookingrequest;

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
    "cardCode",
    "cardNumber",
    "cardHolderName",
    "expiryMonth",
    "expiryYear",
    "cvvNo",
    "country",
    "address1",
    "address2",
    "city",
    "state",
    "postalCode",
    "maskCardNumber"
})
public class PaymentDetails {

    @JsonProperty("cardCode")
    private String cardCode;
    @JsonProperty("cardNumber")
    private String cardNumber;
    @JsonProperty("cardHolderName")
    private String cardHolderName;
    @JsonProperty("expiryMonth")
    private String expiryMonth;
    @JsonProperty("expiryYear")
    private String expiryYear;
    @JsonProperty("cvvNo")
    private String cvvNo;
    @JsonProperty("country")
    private String country;
    @JsonProperty("address1")
    private String address1;
    @JsonProperty("address2")
    private String address2;
    @JsonProperty("city")
    private String city;
    @JsonProperty("state")
    private String state;
    @JsonProperty("postalCode")
    private String postalCode;
    @JsonProperty("maskCardNumber")
    private String maskCardNumber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("cardCode")
    public String getCardCode() {
        return cardCode;
    }

    @JsonProperty("cardCode")
    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    @JsonProperty("cardNumber")
    public String getCardNumber() {
        return cardNumber;
    }

    @JsonProperty("cardNumber")
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @JsonProperty("cardHolderName")
    public String getCardHolderName() {
        return cardHolderName;
    }

    @JsonProperty("cardHolderName")
    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    @JsonProperty("expiryMonth")
    public String getExpiryMonth() {
        return expiryMonth;
    }

    @JsonProperty("expiryMonth")
    public void setExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    @JsonProperty("expiryYear")
    public String getExpiryYear() {
        return expiryYear;
    }

    @JsonProperty("expiryYear")
    public void setExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }

    @JsonProperty("cvvNo")
    public String getCvvNo() {
        return cvvNo;
    }

    @JsonProperty("cvvNo")
    public void setCvvNo(String cvvNo) {
        this.cvvNo = cvvNo;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("address1")
    public String getAddress1() {
        return address1;
    }

    @JsonProperty("address1")
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @JsonProperty("address2")
    public String getAddress2() {
        return address2;
    }

    @JsonProperty("address2")
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("postalCode")
    public String getPostalCode() {
        return postalCode;
    }

    @JsonProperty("postalCode")
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @JsonProperty("maskCardNumber")
    public String getMaskCardNumber() {
        return maskCardNumber;
    }

    @JsonProperty("maskCardNumber")
    public void setMaskCardNumber(String maskCardNumber) {
        this.maskCardNumber = maskCardNumber;
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
