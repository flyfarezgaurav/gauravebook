
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
    "airline",
    "cabinClass",
    "tripType",
    "page",
    "currency",
    "siteId",
    "departDate",
    "countryName",
    "countryCode",
    "cityName"
})
@Generated("jsonschema2pojo")
public class DealRequest {

    @JsonProperty("froCity")
    private String froCity;
    @JsonProperty("toCity")
    private String toCity;
    @JsonProperty("airline")
    private String airline;
    @JsonProperty("cabinClass")
    private String cabinClass;
    @JsonProperty("tripType")
    private String tripType;
    @JsonProperty("page")
    private String page;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("siteId")
    private String siteId;
    @JsonProperty("departDate")
    private Object departDate;
    @JsonProperty("countryName")
    private String countryName;
    @JsonProperty("countryCode")
    private String countryCode;
    @JsonProperty("cityName")
    private Object cityName;
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

    @JsonProperty("airline")
    public String getAirline() {
        return airline;
    }

    @JsonProperty("airline")
    public void setAirline(String airline) {
        this.airline = airline;
    }

    @JsonProperty("cabinClass")
    public String getCabinClass() {
        return cabinClass;
    }

    @JsonProperty("cabinClass")
    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
    }

    @JsonProperty("tripType")
    public String getTripType() {
        return tripType;
    }

    @JsonProperty("tripType")
    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    @JsonProperty("page")
    public String getPage() {
        return page;
    }

    @JsonProperty("page")
    public void setPage(String page) {
        this.page = page;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("siteId")
    public String getSiteId() {
        return siteId;
    }

    @JsonProperty("siteId")
    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    @JsonProperty("departDate")
    public Object getDepartDate() {
        return departDate;
    }

    @JsonProperty("departDate")
    public void setDepartDate(Object departDate) {
        this.departDate = departDate;
    }

    @JsonProperty("countryName")
    public String getCountryName() {
        return countryName;
    }

    @JsonProperty("countryName")
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @JsonProperty("countryCode")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("countryCode")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("cityName")
    public Object getCityName() {
        return cityName;
    }

    @JsonProperty("cityName")
    public void setCityName(Object cityName) {
        this.cityName = cityName;
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
