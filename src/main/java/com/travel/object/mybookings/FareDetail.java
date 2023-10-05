
package com.travel.object.mybookings;

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
    "fareDetailId",
    "bookingId",
    "adultFare",
    "childFare",
    "infantFare",
    "infantWsFare",
    "adultTax",
    "childTax",
    "infantTax",
    "infantWs",
    "adultMarkup",
    "childMarkup",
    "infantMarkup",
    "infantWsMarkup",
    "bagFees",
    "baseFare",
    "totalTax",
    "agentMarkup",
    "couponsCode",
    "couponAmount",
    "markupId",
    "grandTotal",
    "serviceCharge"
})
public class FareDetail {

    @JsonProperty("fareDetailId")
    private Integer fareDetailId;
    @JsonProperty("bookingId")
    private Integer bookingId;
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
    @JsonProperty("infantWs")
    private Double infantWs;
    @JsonProperty("adultMarkup")
    private Double adultMarkup;
    @JsonProperty("childMarkup")
    private Double childMarkup;
    @JsonProperty("infantMarkup")
    private Double infantMarkup;
    @JsonProperty("infantWsMarkup")
    private Double infantWsMarkup;
    @JsonProperty("bagFees")
    private Double bagFees;
    @JsonProperty("baseFare")
    private Double baseFare;
    @JsonProperty("totalTax")
    private Double totalTax;
    @JsonProperty("agentMarkup")
    private Double agentMarkup;
    @JsonProperty("couponsCode")
    private Object couponsCode;
    @JsonProperty("couponAmount")
    private Double couponAmount;
    @JsonProperty("markupId")
    private Integer markupId;
    @JsonProperty("grandTotal")
    private Double grandTotal;
    @JsonProperty("serviceCharge")
    private Double serviceCharge;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("fareDetailId")
    public Integer getFareDetailId() {
        return fareDetailId;
    }

    @JsonProperty("fareDetailId")
    public void setFareDetailId(Integer fareDetailId) {
        this.fareDetailId = fareDetailId;
    }

    @JsonProperty("bookingId")
    public Integer getBookingId() {
        return bookingId;
    }

    @JsonProperty("bookingId")
    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

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

    @JsonProperty("infantWs")
    public Double getInfantWs() {
        return infantWs;
    }

    @JsonProperty("infantWs")
    public void setInfantWs(Double infantWs) {
        this.infantWs = infantWs;
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

    @JsonProperty("bagFees")
    public Double getBagFees() {
        return bagFees;
    }

    @JsonProperty("bagFees")
    public void setBagFees(Double bagFees) {
        this.bagFees = bagFees;
    }

    @JsonProperty("baseFare")
    public Double getBaseFare() {
        return baseFare;
    }

    @JsonProperty("baseFare")
    public void setBaseFare(Double baseFare) {
        this.baseFare = baseFare;
    }

    @JsonProperty("totalTax")
    public Double getTotalTax() {
        return totalTax;
    }

    @JsonProperty("totalTax")
    public void setTotalTax(Double totalTax) {
        this.totalTax = totalTax;
    }

    @JsonProperty("agentMarkup")
    public Double getAgentMarkup() {
        return agentMarkup;
    }

    @JsonProperty("agentMarkup")
    public void setAgentMarkup(Double agentMarkup) {
        this.agentMarkup = agentMarkup;
    }

    @JsonProperty("couponsCode")
    public Object getCouponsCode() {
        return couponsCode;
    }

    @JsonProperty("couponsCode")
    public void setCouponsCode(Object couponsCode) {
        this.couponsCode = couponsCode;
    }

    @JsonProperty("couponAmount")
    public Double getCouponAmount() {
        return couponAmount;
    }

    @JsonProperty("couponAmount")
    public void setCouponAmount(Double couponAmount) {
        this.couponAmount = couponAmount;
    }

    @JsonProperty("markupId")
    public Integer getMarkupId() {
        return markupId;
    }

    @JsonProperty("markupId")
    public void setMarkupId(Integer markupId) {
        this.markupId = markupId;
    }

    @JsonProperty("grandTotal")
    public Double getGrandTotal() {
        return grandTotal;
    }

    @JsonProperty("grandTotal")
    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }

    @JsonProperty("serviceCharge")
    public Double getServiceCharge() {
        return serviceCharge;
    }

    @JsonProperty("serviceCharge")
    public void setServiceCharge(Double serviceCharge) {
        this.serviceCharge = serviceCharge;
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
