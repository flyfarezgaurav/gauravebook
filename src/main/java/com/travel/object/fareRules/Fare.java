
package com.travel.object.fareRules;

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
    "adultFare",
    "childFare",
    "infantFare",
    "infantWsFare",
    "adultTax",
    "childTax",
    "infantTax",
    "infantWsTax",
    "adultMarkup",
    "childMarkup",
    "infantMarkup",
    "infantWsMarkup",
    "grandTotal",
    "markupID"
})
public class Fare {

    @JsonProperty("adultFare")
    private Double adultFare;
    @JsonProperty("childFare")
    private Double childFare;
    @JsonProperty("infantFare")
    private Double infantFare;
    @JsonProperty("infantWsFare")
    private Double infantWsFare;
    @JsonProperty("adultTax")
    private Double adultTax;
    @JsonProperty("childTax")
    private Double childTax;
    @JsonProperty("infantTax")
    private Double infantTax;
    @JsonProperty("infantWsTax")
    private Double infantWsTax;
    @JsonProperty("adultMarkup")
    private Double adultMarkup;
    @JsonProperty("childMarkup")
    private Double childMarkup;
    @JsonProperty("infantMarkup")
    private Double infantMarkup;
    @JsonProperty("infantWsMarkup")
    private Double infantWsMarkup;
    @JsonProperty("grandTotal")
    private Double grandTotal;
    @JsonProperty("markupID")
    private Integer markupID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("adultFare")
    public Double getAdultFare() {
        return adultFare;
    }

    @JsonProperty("adultFare")
    public void setAdultFare(Double adultFare) {
        this.adultFare = adultFare;
    }

    @JsonProperty("childFare")
    public Double getChildFare() {
        return childFare;
    }

    @JsonProperty("childFare")
    public void setChildFare(Double childFare) {
        this.childFare = childFare;
    }

    @JsonProperty("infantFare")
    public Double getInfantFare() {
        return infantFare;
    }

    @JsonProperty("infantFare")
    public void setInfantFare(Double infantFare) {
        this.infantFare = infantFare;
    }

    @JsonProperty("infantWsFare")
    public Double getInfantWsFare() {
        return infantWsFare;
    }

    @JsonProperty("infantWsFare")
    public void setInfantWsFare(Double infantWsFare) {
        this.infantWsFare = infantWsFare;
    }

    @JsonProperty("adultTax")
    public Double getAdultTax() {
        return adultTax;
    }

    @JsonProperty("adultTax")
    public void setAdultTax(Double adultTax) {
        this.adultTax = adultTax;
    }

    @JsonProperty("childTax")
    public Double getChildTax() {
        return childTax;
    }

    @JsonProperty("childTax")
    public void setChildTax(Double childTax) {
        this.childTax = childTax;
    }

    @JsonProperty("infantTax")
    public Double getInfantTax() {
        return infantTax;
    }

    @JsonProperty("infantTax")
    public void setInfantTax(Double infantTax) {
        this.infantTax = infantTax;
    }

    @JsonProperty("infantWsTax")
    public Double getInfantWsTax() {
        return infantWsTax;
    }

    @JsonProperty("infantWsTax")
    public void setInfantWsTax(Double infantWsTax) {
        this.infantWsTax = infantWsTax;
    }

    @JsonProperty("adultMarkup")
    public Double getAdultMarkup() {
        return adultMarkup;
    }

    @JsonProperty("adultMarkup")
    public void setAdultMarkup(Double adultMarkup) {
        this.adultMarkup = adultMarkup;
    }

    @JsonProperty("childMarkup")
    public Double getChildMarkup() {
        return childMarkup;
    }

    @JsonProperty("childMarkup")
    public void setChildMarkup(Double childMarkup) {
        this.childMarkup = childMarkup;
    }

    @JsonProperty("infantMarkup")
    public Double getInfantMarkup() {
        return infantMarkup;
    }

    @JsonProperty("infantMarkup")
    public void setInfantMarkup(Double infantMarkup) {
        this.infantMarkup = infantMarkup;
    }

    @JsonProperty("infantWsMarkup")
    public Double getInfantWsMarkup() {
        return infantWsMarkup;
    }

    @JsonProperty("infantWsMarkup")
    public void setInfantWsMarkup(Double infantWsMarkup) {
        this.infantWsMarkup = infantWsMarkup;
    }

    @JsonProperty("grandTotal")
    public Double getGrandTotal() {
        return grandTotal;
    }

    @JsonProperty("grandTotal")
    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }

    @JsonProperty("markupID")
    public Integer getMarkupID() {
        return markupID;
    }

    @JsonProperty("markupID")
    public void setMarkupID(Integer markupID) {
        this.markupID = markupID;
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
