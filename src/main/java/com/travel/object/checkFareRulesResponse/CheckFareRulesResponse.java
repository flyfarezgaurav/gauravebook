package com.travel.object.checkFareRulesResponse;

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
    "ancillaryServices",
    "bagRecheckReq",
    "eurtogbp",
    "eurtousd",
    "fare",
    "fareFamily",
    "flightChecked",
    "flightInvalid",
    "gbptousd",
    "perPaxLuggageOptions",
    "priceChange",
    "responseStatus",
    "freeTextLines"
})

public class CheckFareRulesResponse {

    @JsonProperty("ancillaryServices")
    private List<AncillaryService> ancillaryServices = null;
    @JsonProperty("bagRecheckReq")
    private Boolean bagRecheckReq;
    @JsonProperty("eurtogbp")
    private Integer eurtogbp;
    @JsonProperty("eurtousd")
    private Integer eurtousd;
    @JsonProperty("fare")
    private Fare fare;
    @JsonProperty("fareFamily")
    private List<FareFamily> fareFamily = null;
    @JsonProperty("flightChecked")
    private Boolean flightChecked;
    @JsonProperty("flightInvalid")
    private Boolean flightInvalid;
    @JsonProperty("gbptousd")
    private Integer gbptousd;
    @JsonProperty("perPaxLuggageOptions")
    private Boolean perPaxLuggageOptions;
    @JsonProperty("priceChange")
    private Boolean priceChange;
    @JsonProperty("responseStatus")
    private ResponseStatus responseStatus;
    @JsonProperty("freeTextLines")
    private List<String> freeTextLines;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
    @JsonProperty("freeTextLines")
    public List<String> getFreeTextLines() {
        return freeTextLines;
    }

    @JsonProperty("freeTextLines")
    public void setFreeTextLines(List<String> freeTextLines) {
        this.freeTextLines = freeTextLines;
    }
    
    @JsonProperty("ancillaryServices")
    public List<AncillaryService> getAncillaryServices() {
        return ancillaryServices;
    }

    @JsonProperty("ancillaryServices")
    public void setAncillaryServices(List<AncillaryService> ancillaryServices) {
        this.ancillaryServices = ancillaryServices;
    }

    @JsonProperty("bagRecheckReq")
    public Boolean getBagRecheckReq() {
        return bagRecheckReq;
    }

    @JsonProperty("bagRecheckReq")
    public void setBagRecheckReq(Boolean bagRecheckReq) {
        this.bagRecheckReq = bagRecheckReq;
    }

    @JsonProperty("eurtogbp")
    public Integer getEurtogbp() {
        return eurtogbp;
    }

    @JsonProperty("eurtogbp")
    public void setEurtogbp(Integer eurtogbp) {
        this.eurtogbp = eurtogbp;
    }

    @JsonProperty("eurtousd")
    public Integer getEurtousd() {
        return eurtousd;
    }

    @JsonProperty("eurtousd")
    public void setEurtousd(Integer eurtousd) {
        this.eurtousd = eurtousd;
    }

    @JsonProperty("fare")
    public Fare getFare() {
        return fare;
    }

    @JsonProperty("fare")
    public void setFare(Fare fare) {
        this.fare = fare;
    }

    @JsonProperty("fareFamily")
    public List<FareFamily> getFareFamily() {
        return fareFamily;
    }

    @JsonProperty("fareFamily")
    public void setFareFamily(List<FareFamily> fareFamily) {
        this.fareFamily = fareFamily;
    }
    
    @JsonProperty("flightChecked")
    public Boolean getFlightChecked() {
        return flightChecked;
    }

    @JsonProperty("flightChecked")
    public void setFlightChecked(Boolean flightChecked) {
        this.flightChecked = flightChecked;
    }

    @JsonProperty("flightInvalid")
    public Boolean getFlightInvalid() {
        return flightInvalid;
    }

    @JsonProperty("flightInvalid")
    public void setFlightInvalid(Boolean flightInvalid) {
        this.flightInvalid = flightInvalid;
    }

    @JsonProperty("gbptousd")
    public Integer getGbptousd() {
        return gbptousd;
    }

    @JsonProperty("gbptousd")
    public void setGbptousd(Integer gbptousd) {
        this.gbptousd = gbptousd;
    }

    @JsonProperty("perPaxLuggageOptions")
    public Boolean getPerPaxLuggageOptions() {
        return perPaxLuggageOptions;
    }

    @JsonProperty("perPaxLuggageOptions")
    public void setPerPaxLuggageOptions(Boolean perPaxLuggageOptions) {
        this.perPaxLuggageOptions = perPaxLuggageOptions;
    }

    @JsonProperty("priceChange")
    public Boolean getPriceChange() {
        return priceChange;
    }

    @JsonProperty("priceChange")
    public void setPriceChange(Boolean priceChange) {
        this.priceChange = priceChange;
    }

    @JsonProperty("responseStatus")
    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    @JsonProperty("responseStatus")
    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
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
