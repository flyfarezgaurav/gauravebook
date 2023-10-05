
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
    "tripIdentifier",
    "initialDepositDate",
    "finalPaymentDate",
    "totalTripPrice",
    "bookingItems",
    "totalInsured",
    "totalInfants"
})
@Generated("jsonschema2pojo")
public class Trip {

    @JsonProperty("tripIdentifier")
    private String tripIdentifier;
    @JsonProperty("initialDepositDate")
    private String initialDepositDate;
    @JsonProperty("finalPaymentDate")
    private String finalPaymentDate;
    @JsonProperty("totalTripPrice")
    private List<TotalTripPrice> totalTripPrice = null;
    @JsonProperty("bookingItems")
    private List<BookingItem> bookingItems = null;
    @JsonProperty("totalInsured")
    private Integer totalInsured;
    @JsonProperty("totalInfants")
    private Integer totalInfants;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("tripIdentifier")
    public String getTripIdentifier() {
        return tripIdentifier;
    }

    @JsonProperty("tripIdentifier")
    public void setTripIdentifier(String tripIdentifier) {
        this.tripIdentifier = tripIdentifier;
    }

    @JsonProperty("initialDepositDate")
    public String getInitialDepositDate() {
        return initialDepositDate;
    }

    @JsonProperty("initialDepositDate")
    public void setInitialDepositDate(String initialDepositDate) {
        this.initialDepositDate = initialDepositDate;
    }

    @JsonProperty("finalPaymentDate")
    public String getFinalPaymentDate() {
        return finalPaymentDate;
    }

    @JsonProperty("finalPaymentDate")
    public void setFinalPaymentDate(String finalPaymentDate) {
        this.finalPaymentDate = finalPaymentDate;
    }

    @JsonProperty("totalTripPrice")
    public List<TotalTripPrice> getTotalTripPrice() {
        return totalTripPrice;
    }

    @JsonProperty("totalTripPrice")
    public void setTotalTripPrice(List<TotalTripPrice> totalTripPrice) {
        this.totalTripPrice = totalTripPrice;
    }

    @JsonProperty("bookingItems")
    public List<BookingItem> getBookingItems() {
        return bookingItems;
    }

    @JsonProperty("bookingItems")
    public void setBookingItems(List<BookingItem> bookingItems) {
        this.bookingItems = bookingItems;
    }

    @JsonProperty("totalInsured")
    public Integer getTotalInsured() {
        return totalInsured;
    }

    @JsonProperty("totalInsured")
    public void setTotalInsured(Integer totalInsured) {
        this.totalInsured = totalInsured;
    }

    @JsonProperty("totalInfants")
    public Integer getTotalInfants() {
        return totalInfants;
    }

    @JsonProperty("totalInfants")
    public void setTotalInfants(Integer totalInfants) {
        this.totalInfants = totalInfants;
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
