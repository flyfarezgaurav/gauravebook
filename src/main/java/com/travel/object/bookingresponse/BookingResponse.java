
package com.travel.object.bookingresponse;

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
    "bookingID",
    "PNR",
    "flightResut",
    "paymentDetails",
    "passengerDetails",
    "ispriceChange",
    "newPrice",
    "isCcv",
    "bookingStatus",
    "responseStatus",
    "IsTimeChanged",
    "isticketeRun",
    "isticketeRunRet"
})
public class BookingResponse {

    @JsonProperty("bookingID")
    private String bookingID;
    @JsonProperty("PNR")
    private String pNR;
    @JsonProperty("flightResut")
    private FlightResut flightResut;
    @JsonProperty("paymentDetails")
    private PaymentDetails paymentDetails;
    @JsonProperty("passengerDetails")
    private List<PassengerDetail> passengerDetails = null;
    @JsonProperty("ispriceChange")
    private Boolean ispriceChange;
    @JsonProperty("newPrice")
    private Double newPrice;
    @JsonProperty("isCcv")
    private Boolean isCcv;
    @JsonProperty("bookingStatus")
    private String bookingStatus;
    @JsonProperty("responseStatus")
    private ResponseStatus responseStatus;
    @JsonProperty("IsTimeChanged")
    private Boolean isTimeChanged;
    @JsonProperty("isticketeRun")
    private Integer isticketeRun;
    @JsonProperty("isticketeRunRet")
    private Integer isticketeRunRet;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("bookingID")
    public String getBookingID() {
        return bookingID;
    }

    @JsonProperty("bookingID")
    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    @JsonProperty("PNR")
    public String getPNR() {
        return pNR;
    }

    @JsonProperty("PNR")
    public void setPNR(String pNR) {
        this.pNR = pNR;
    }

    @JsonProperty("flightResut")
    public FlightResut getFlightResut() {
        return flightResut;
    }

    @JsonProperty("flightResut")
    public void setFlightResut(FlightResut flightResut) {
        this.flightResut = flightResut;
    }

    @JsonProperty("paymentDetails")
    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    @JsonProperty("paymentDetails")
    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    @JsonProperty("passengerDetails")
    public List<PassengerDetail> getPassengerDetails() {
        return passengerDetails;
    }

    @JsonProperty("passengerDetails")
    public void setPassengerDetails(List<PassengerDetail> passengerDetails) {
        this.passengerDetails = passengerDetails;
    }

    @JsonProperty("ispriceChange")
    public Boolean getIspriceChange() {
        return ispriceChange;
    }

    @JsonProperty("ispriceChange")
    public void setIspriceChange(Boolean ispriceChange) {
        this.ispriceChange = ispriceChange;
    }

    @JsonProperty("newPrice")
    public Double getNewPrice() {
        return newPrice;
    }

    @JsonProperty("newPrice")
    public void setNewPrice(Double newPrice) {
        this.newPrice = newPrice;
    }

    @JsonProperty("isCcv")
    public Boolean getIsCcv() {
        return isCcv;
    }

    @JsonProperty("isCcv")
    public void setIsCcv(Boolean isCcv) {
        this.isCcv = isCcv;
    }

    @JsonProperty("bookingStatus")
    public String getBookingStatus() {
        return bookingStatus;
    }

    @JsonProperty("bookingStatus")
    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    @JsonProperty("responseStatus")
    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    @JsonProperty("responseStatus")
    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    @JsonProperty("IsTimeChanged")
    public Boolean getIsTimeChanged() {
        return isTimeChanged;
    }

    @JsonProperty("IsTimeChanged")
    public void setIsTimeChanged(Boolean isTimeChanged) {
        this.isTimeChanged = isTimeChanged;
    }

    @JsonProperty("isticketeRun")
    public Integer getIsticketeRun() {
        return isticketeRun;
    }

    @JsonProperty("isticketeRun")
    public void setIsticketeRun(Integer isticketeRun) {
        this.isticketeRun = isticketeRun;
    }

    @JsonProperty("isticketeRunRet")
    public Integer getIsticketeRunRet() {
        return isticketeRunRet;
    }

    @JsonProperty("isticketeRunRet")
    public void setIsticketeRunRet(Integer isticketeRunRet) {
        this.isticketeRunRet = isticketeRunRet;
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
