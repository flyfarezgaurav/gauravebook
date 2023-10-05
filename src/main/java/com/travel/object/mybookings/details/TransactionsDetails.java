
package com.travel.object.mybookings.details;

import java.util.Date;
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
    "bookingId",
    "trnsNo",
    "amount",
    "cardNo",
    "holderName",
    "expDate",
    "validFrom",
    "issueNo",
    "securityCode",
    "cardType",
    "country",
    "coutyState",
    "city",
    "postCode",
    "address",
    "cardCharges",
    "chargesType",
    "modifiedBy",
    "modifiedDate",
    "password"
})
public class TransactionsDetails {

    @JsonProperty("bookingId")
    private Object bookingId;
    @JsonProperty("trnsNo")
    private Object trnsNo;
    @JsonProperty("amount")
    private Object amount;
    @JsonProperty("cardNo")
    private Object cardNo;
    @JsonProperty("holderName")
    private Object holderName;
    @JsonProperty("expDate")
    private Object expDate;
    @JsonProperty("validFrom")
    private Object validFrom;
    @JsonProperty("issueNo")
    private Object issueNo;
    @JsonProperty("securityCode")
    private Object securityCode;
    @JsonProperty("cardType")
    private Object cardType;
    @JsonProperty("country")
    private Object country;
    @JsonProperty("coutyState")
    private Object coutyState;
    @JsonProperty("city")
    private Object city;
    @JsonProperty("postCode")
    private Object postCode;
    @JsonProperty("address")
    private Object address;
    @JsonProperty("cardCharges")
    private Object cardCharges;
    @JsonProperty("chargesType")
    private Object chargesType;
    @JsonProperty("modifiedBy")
    private Object modifiedBy;
    @JsonProperty("modifiedDate")
    private Date modifiedDate;
    @JsonProperty("password")
    private Object password;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("bookingId")
    public Object getBookingId() {
        return bookingId;
    }

    @JsonProperty("bookingId")
    public void setBookingId(Object bookingId) {
        this.bookingId = bookingId;
    }

    @JsonProperty("trnsNo")
    public Object getTrnsNo() {
        return trnsNo;
    }

    @JsonProperty("trnsNo")
    public void setTrnsNo(Object trnsNo) {
        this.trnsNo = trnsNo;
    }

    @JsonProperty("amount")
    public Object getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Object amount) {
        this.amount = amount;
    }

    @JsonProperty("cardNo")
    public Object getCardNo() {
        return cardNo;
    }

    @JsonProperty("cardNo")
    public void setCardNo(Object cardNo) {
        this.cardNo = cardNo;
    }

    @JsonProperty("holderName")
    public Object getHolderName() {
        return holderName;
    }

    @JsonProperty("holderName")
    public void setHolderName(Object holderName) {
        this.holderName = holderName;
    }

    @JsonProperty("expDate")
    public Object getExpDate() {
        return expDate;
    }

    @JsonProperty("expDate")
    public void setExpDate(Object expDate) {
        this.expDate = expDate;
    }

    @JsonProperty("validFrom")
    public Object getValidFrom() {
        return validFrom;
    }

    @JsonProperty("validFrom")
    public void setValidFrom(Object validFrom) {
        this.validFrom = validFrom;
    }

    @JsonProperty("issueNo")
    public Object getIssueNo() {
        return issueNo;
    }

    @JsonProperty("issueNo")
    public void setIssueNo(Object issueNo) {
        this.issueNo = issueNo;
    }

    @JsonProperty("securityCode")
    public Object getSecurityCode() {
        return securityCode;
    }

    @JsonProperty("securityCode")
    public void setSecurityCode(Object securityCode) {
        this.securityCode = securityCode;
    }

    @JsonProperty("cardType")
    public Object getCardType() {
        return cardType;
    }

    @JsonProperty("cardType")
    public void setCardType(Object cardType) {
        this.cardType = cardType;
    }

    @JsonProperty("country")
    public Object getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(Object country) {
        this.country = country;
    }

    @JsonProperty("coutyState")
    public Object getCoutyState() {
        return coutyState;
    }

    @JsonProperty("coutyState")
    public void setCoutyState(Object coutyState) {
        this.coutyState = coutyState;
    }

    @JsonProperty("city")
    public Object getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(Object city) {
        this.city = city;
    }

    @JsonProperty("postCode")
    public Object getPostCode() {
        return postCode;
    }

    @JsonProperty("postCode")
    public void setPostCode(Object postCode) {
        this.postCode = postCode;
    }

    @JsonProperty("address")
    public Object getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Object address) {
        this.address = address;
    }

    @JsonProperty("cardCharges")
    public Object getCardCharges() {
        return cardCharges;
    }

    @JsonProperty("cardCharges")
    public void setCardCharges(Object cardCharges) {
        this.cardCharges = cardCharges;
    }

    @JsonProperty("chargesType")
    public Object getChargesType() {
        return chargesType;
    }

    @JsonProperty("chargesType")
    public void setChargesType(Object chargesType) {
        this.chargesType = chargesType;
    }

    @JsonProperty("modifiedBy")
    public Object getModifiedBy() {
        return modifiedBy;
    }

    @JsonProperty("modifiedBy")
    public void setModifiedBy(Object modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @JsonProperty("modifiedDate")
    public Object getModifiedDate() {
        return modifiedDate;
    }

    @JsonProperty("modifiedDate")
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @JsonProperty("password")
    public Object getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(Object password) {
        this.password = password;
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
