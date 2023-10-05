
package com.travel.object.deal;

import java.util.HashMap;
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
    "froCity",
    "toCity",
    "froCityName",
    "toCityName",
    "depDate",
    "retDate",
    "airline",
    "tripType",
    "cabinClass",
    "totalPrice"
})
@Generated("jsonschema2pojo")
public class Response {

    @JsonProperty("froCity")
    private String froCity;
    @JsonProperty("toCity")
    private String toCity;
    @JsonProperty("froCityName")
    private String froCityName;
    @JsonProperty("toCityName")
    private String toCityName;
    @JsonProperty("depDate")
    private String depDate;
    @JsonProperty("retDate")
    private String retDate;
    @JsonProperty("airline")
    private String airline;
    @JsonProperty("tripType")
    private String tripType;
    @JsonProperty("cabinClass")
    private String cabinClass;
    @JsonProperty("totalPrice")
    private String totalPrice;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("froCity")
    public String getFroCity() {
        return froCity;
    }

    @JsonProperty("froCity")
    public void setFroCity(String froCity) {
        this.froCity = froCity;
    }

    @JsonProperty("toCity")
    public String getToCity() {
        return toCity;
    }

    @JsonProperty("toCity")
    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    @JsonProperty("froCityName")
    public String getFroCityName() {
        return froCityName;
    }

    @JsonProperty("froCityName")
    public void setFroCityName(String froCityName) {
        this.froCityName = froCityName;
    }

    @JsonProperty("toCityName")
    public String getToCityName() {
        return toCityName;
    }

    @JsonProperty("toCityName")
    public void setToCityName(String toCityName) {
        this.toCityName = toCityName;
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

    @JsonProperty("airline")
    public String getAirline() {
        return airline;
    }

    @JsonProperty("airline")
    public void setAirline(String airline) {
        this.airline = airline;
    }

    @JsonProperty("tripType")
    public String getTripType() {
        return tripType;
    }

    @JsonProperty("tripType")
    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    @JsonProperty("cabinClass")
    public String getCabinClass() {
        return cabinClass;
    }

    @JsonProperty("cabinClass")
    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
    }

    @JsonProperty("totalPrice")
    public String getTotalPrice() {
        return totalPrice;
    }

    @JsonProperty("totalPrice")
    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
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
