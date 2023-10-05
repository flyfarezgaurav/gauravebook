
package com.travel.object.flightresponse;

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
    "airportCode",
    "airportName",
    "cityCode",
    "cityName",
    "countryCode",
    "countryName",
    "continent"
})
public class Airport {

    @JsonProperty("airportCode")
    private String airportCode;
    @JsonProperty("airportName")
    private String airportName;
    @JsonProperty("cityCode")
    private String cityCode;
    @JsonProperty("cityName")
    private String cityName;
    @JsonProperty("countryCode")
    private String countryCode;
    @JsonProperty("countryName")
    private String countryName;
    @JsonProperty("continent")
    private String continent;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("airportCode")
    public String getAirportCode() {
        return airportCode;
    }

    @JsonProperty("airportCode")
    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    @JsonProperty("airportName")
    public String getAirportName() {
        return airportName;
    }

    @JsonProperty("airportName")
    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    @JsonProperty("cityCode")
    public String getCityCode() {
        return cityCode;
    }

    @JsonProperty("cityCode")
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    @JsonProperty("cityName")
    public String getCityName() {
        return cityName;
    }

    @JsonProperty("cityName")
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @JsonProperty("countryCode")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("countryCode")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("countryName")
    public String getCountryName() {
        return countryName;
    }

    @JsonProperty("countryName")
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @JsonProperty("continent")
    public String getContinent() {
        return continent;
    }

    @JsonProperty("continent")
    public void setContinent(String continent) {
        this.continent = continent;
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
