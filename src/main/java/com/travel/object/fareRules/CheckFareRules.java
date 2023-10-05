
package com.travel.object.fareRules;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.travel.object.flightresponse.FlightResult;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "flightResult",
    "adults",
    "child",
    "infants",
    "infantsWs",
    "currencyCode",
    "siteID"
})
public class CheckFareRules {

    @JsonProperty("flightResult")
    private FlightResult flightResult = null;
    @JsonProperty("adults")
    private Integer adults;
    @JsonProperty("child")
    private Integer child;
    @JsonProperty("infants")
    private Integer infants;
    @JsonProperty("infantsWs")
    private Integer infantsWs;
    @JsonProperty("currencyCode")
	private String currencyCode;
    @JsonProperty("siteID")
    private Integer siteID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("flightResult")
    public FlightResult getFlightResult() {
        return flightResult;
    }

    @JsonProperty("flightResult")
    public void setFlightResult(FlightResult flightResult) {
        this.flightResult = flightResult;
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

    @JsonProperty("siteID")
    public Integer getSiteID() {
        return siteID;
    }

    @JsonProperty("siteID")
    public void setSiteID(Integer siteID) {
        this.siteID = siteID;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

}
