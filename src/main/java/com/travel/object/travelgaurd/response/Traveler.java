
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
    "travelerIdentifier",
    "passengerType",
    "deductible",
    "medicalScore",
    "travelerTripPrice",
    "addresses"
})
@Generated("jsonschema2pojo")
public class Traveler {

    @JsonProperty("travelerIdentifier")
    private String travelerIdentifier;
    @JsonProperty("passengerType")
    private String passengerType;
    @JsonProperty("deductible")
    private Integer deductible;
    @JsonProperty("medicalScore")
    private Double medicalScore;
    @JsonProperty("travelerTripPrice")
    private List<TravelerTripPrice> travelerTripPrice = null;
    @JsonProperty("addresses")
    private List<Address> addresses = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("travelerIdentifier")
    public String getTravelerIdentifier() {
        return travelerIdentifier;
    }

    @JsonProperty("travelerIdentifier")
    public void setTravelerIdentifier(String travelerIdentifier) {
        this.travelerIdentifier = travelerIdentifier;
    }

    @JsonProperty("passengerType")
    public String getPassengerType() {
        return passengerType;
    }

    @JsonProperty("passengerType")
    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }

    @JsonProperty("deductible")
    public Integer getDeductible() {
        return deductible;
    }

    @JsonProperty("deductible")
    public void setDeductible(Integer deductible) {
        this.deductible = deductible;
    }

    @JsonProperty("medicalScore")
    public Double getMedicalScore() {
        return medicalScore;
    }

    @JsonProperty("medicalScore")
    public void setMedicalScore(Double medicalScore) {
        this.medicalScore = medicalScore;
    }

    @JsonProperty("travelerTripPrice")
    public List<TravelerTripPrice> getTravelerTripPrice() {
        return travelerTripPrice;
    }

    @JsonProperty("travelerTripPrice")
    public void setTravelerTripPrice(List<TravelerTripPrice> travelerTripPrice) {
        this.travelerTripPrice = travelerTripPrice;
    }

    @JsonProperty("addresses")
    public List<Address> getAddresses() {
        return addresses;
    }

    @JsonProperty("addresses")
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
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
