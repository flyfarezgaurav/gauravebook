
package com.travel.object.travelgaurd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "totalPrice",
    "originAirport",
    "destinationAirport",
    "deptureDate",
    "reachDate",
    "country",
    "state",
    "travelers"
})

public class TGRequest {

    @JsonProperty("totalPrice")
    private double totalPrice;
    @JsonProperty("originAirport")
    private String originAirport;
    @JsonProperty("destinationAirport")
    private String destinationAirport;
    @JsonProperty("deptureDate")
    private String deptureDate;
    @JsonProperty("reachDate")
    private String reachDate;
    @JsonProperty("country")
    private String country;
    @JsonProperty("state")
    private String state;
    @JsonProperty("travelers")
    private List<Traveler> travelers = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("totalPrice")
    public double getTotalPrice() {
        return totalPrice;
    }

    @JsonProperty("totalPrice")
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @JsonProperty("originAirport")
    public String getOriginAirport() {
        return originAirport;
    }

    @JsonProperty("originAirport")
    public void setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
    }

    @JsonProperty("destinationAirport")
    public String getDestinationAirport() {
        return destinationAirport;
    }

    @JsonProperty("destinationAirport")
    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    @JsonProperty("deptureDate")
    public String getDeptureDate() {
        return deptureDate;
    }

    @JsonProperty("deptureDate")
    public void setDeptureDate(String deptureDate) {
        this.deptureDate = deptureDate;
    }

    @JsonProperty("reachDate")
    public String getReachDate() {
        return reachDate;
    }

    @JsonProperty("reachDate")
    public void setReachDate(String reachDate) {
        this.reachDate = reachDate;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("travelers")
    public List<Traveler> getTravelers() {
        return travelers;
    }

    @JsonProperty("travelers")
    public void setTravelers(List<Traveler> travelers) {
        this.travelers = travelers;
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
