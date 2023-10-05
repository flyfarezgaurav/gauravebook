
package com.travel.object.travelgaurd.response;

import java.util.HashMap;
import java.util.List;
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
    "trips",
    "travelers",
    "productDetails",
    "exchangeRateDetails",
    "paymentDetail",
    "fulfillmentOption",
    "accountDetail",
    "quoteId"
})
@Generated("jsonschema2pojo")
public class PurchaseRequest {

    @JsonProperty("trips")
    private List<Trip> trips = null;
    @JsonProperty("travelers")
    private List<Traveler> travelers = null;
    @JsonProperty("productDetails")
    private List<ProductDetail> productDetails = null;
    @JsonProperty("exchangeRateDetails")
    private List<Object> exchangeRateDetails = null;
    @JsonProperty("paymentDetail")
    private PaymentDetail paymentDetail;
    @JsonProperty("fulfillmentOption")
    private String fulfillmentOption;
    @JsonProperty("accountDetail")
    private AccountDetail accountDetail;
    @JsonProperty("quoteId")
    private Integer quoteId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("trips")
    public List<Trip> getTrips() {
        return trips;
    }

    @JsonProperty("trips")
    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    @JsonProperty("travelers")
    public List<Traveler> getTravelers() {
        return travelers;
    }

    @JsonProperty("travelers")
    public void setTravelers(List<Traveler> travelers) {
        this.travelers = travelers;
    }

    @JsonProperty("productDetails")
    public List<ProductDetail> getProductDetails() {
        return productDetails;
    }

    @JsonProperty("productDetails")
    public void setProductDetails(List<ProductDetail> productDetails) {
        this.productDetails = productDetails;
    }

    @JsonProperty("exchangeRateDetails")
    public List<Object> getExchangeRateDetails() {
        return exchangeRateDetails;
    }

    @JsonProperty("exchangeRateDetails")
    public void setExchangeRateDetails(List<Object> exchangeRateDetails) {
        this.exchangeRateDetails = exchangeRateDetails;
    }

    @JsonProperty("paymentDetail")
    public PaymentDetail getPaymentDetail() {
        return paymentDetail;
    }

    @JsonProperty("paymentDetail")
    public void setPaymentDetail(PaymentDetail paymentDetail) {
        this.paymentDetail = paymentDetail;
    }

    @JsonProperty("fulfillmentOption")
    public String getFulfillmentOption() {
        return fulfillmentOption;
    }

    @JsonProperty("fulfillmentOption")
    public void setFulfillmentOption(String fulfillmentOption) {
        this.fulfillmentOption = fulfillmentOption;
    }

    @JsonProperty("accountDetail")
    public AccountDetail getAccountDetail() {
        return accountDetail;
    }

    @JsonProperty("accountDetail")
    public void setAccountDetail(AccountDetail accountDetail) {
        this.accountDetail = accountDetail;
    }

    @JsonProperty("quoteId")
    public Integer getQuoteId() {
        return quoteId;
    }

    @JsonProperty("quoteId")
    public void setQuoteId(Integer quoteId) {
        this.quoteId = quoteId;
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
