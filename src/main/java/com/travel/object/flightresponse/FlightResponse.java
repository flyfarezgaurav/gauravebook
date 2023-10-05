
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "flightResult",
    "airline",
    "airport",
    "responsStatus",
    "noOfResult",
    "minPrice",
    "maxPrice",
    "adults",
    "child",
    "infants",
    "infantsWs"
})
public class FlightResponse {

    @JsonProperty("flightResult")
    private List<FlightResult> flightResult = null;
    @JsonProperty("airline")
    private List<Airline> airline = null;
    @JsonProperty("airport")
    private List<Airport> airport = null;
    @JsonProperty("responsStatus")
    private ResponsStatus responsStatus;
    @JsonProperty("noOfResult")
    private Integer noOfResult;
    @JsonProperty("minPrice")
    private Double minPrice;
    @JsonProperty("maxPrice")
    private Double maxPrice;
    @JsonProperty("adults")
    private Integer adults;
    @JsonProperty("child")
    private Integer child;
    @JsonProperty("infants")
    private Integer infants;
    @JsonProperty("infantsWs")
    private Integer infantsWs;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("flightResult")
    public List<FlightResult> getFlightResult() {
        return flightResult;
    }

    @JsonProperty("flightResult")
    public void setFlightResult(List<FlightResult> flightResult) {
        this.flightResult = flightResult;
    }

    @JsonProperty("airline")
    public List<Airline> getAirline() {
        return airline;
    }

    @JsonProperty("airline")
    public void setAirline(List<Airline> airline) {
        this.airline = airline;
    }

    @JsonProperty("airport")
    public List<Airport> getAirport() {
        return airport;
    }

    @JsonProperty("airport")
    public void setAirport(List<Airport> airport) {
        this.airport = airport;
    }

    @JsonProperty("responsStatus")
    public ResponsStatus getResponsStatus() {
        return responsStatus;
    }

    @JsonProperty("responsStatus")
    public void setResponsStatus(ResponsStatus responsStatus) {
        this.responsStatus = responsStatus;
    }

    @JsonProperty("noOfResult")
    public Integer getNoOfResult() {
        return noOfResult;
    }

    @JsonProperty("noOfResult")
    public void setNoOfResult(Integer noOfResult) {
        this.noOfResult = noOfResult;
    }

    @JsonProperty("minPrice")
    public Double getMinPrice() {
        return minPrice;
    }

    @JsonProperty("minPrice")
    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    @JsonProperty("maxPrice")
    public Double getMaxPrice() {
        return maxPrice;
    }

    @JsonProperty("maxPrice")
    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    @JsonProperty("adults")
    public Integer getAdults() {
        return adults;
    }

    @JsonProperty("adults")
    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    @JsonProperty("child")
    public Integer getChild() {
        return child;
    }

    @JsonProperty("child")
    public void setChild(Integer child) {
        this.child = child;
    }

    @JsonProperty("infants")
    public Integer getInfants() {
        return infants;
    }

    @JsonProperty("infants")
    public void setInfants(Integer infants) {
        this.infants = infants;
    }

    @JsonProperty("infantsWs")
    public Integer getInfantsWs() {
        return infantsWs;
    }

    @JsonProperty("infantsWs")
    public void setInfantsWs(Integer infantsWs) {
        this.infantsWs = infantsWs;
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
