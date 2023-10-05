
package com.travel.object.mybookings.details;

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
    "TransactionsDetails",
    "PassengerDetails",
    "siteID",
    "SectorDetail",
    "BookingsHistory",
    "bookingDetail",
    "invoiceNum",
    "BookingsNotes",
    "FareDetail",
    "TraveloesMail"
})
public class Response {

    @JsonProperty("TransactionsDetails")
    private TransactionsDetails transactionsDetails;
    @JsonProperty("PassengerDetails")
    private List<PassengerDetail> passengerDetails = null;
    @JsonProperty("siteID")
    private String siteID;
    @JsonProperty("SectorDetail")
    private List<SectorDetail> sectorDetail = null;
    @JsonProperty("BookingsHistory")
    private List<BookingsHistory> bookingsHistory = null;
    @JsonProperty("bookingDetail")
    private BookingDetail bookingDetail;
    @JsonProperty("invoiceNum")
    private String invoiceNum;
    @JsonProperty("BookingsNotes")
    private List<BookingsNote> bookingsNotes = null;
    @JsonProperty("FareDetail")
    private List<FareDetail> fareDetail = null;
    @JsonProperty("TraveloesMail")
    private List<Object> traveloesMail = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("TransactionsDetails")
    public TransactionsDetails getTransactionsDetails() {
        return transactionsDetails;
    }

    @JsonProperty("TransactionsDetails")
    public void setTransactionsDetails(TransactionsDetails transactionsDetails) {
        this.transactionsDetails = transactionsDetails;
    }

    @JsonProperty("PassengerDetails")
    public List<PassengerDetail> getPassengerDetails() {
        return passengerDetails;
    }

    @JsonProperty("PassengerDetails")
    public void setPassengerDetails(List<PassengerDetail> passengerDetails) {
        this.passengerDetails = passengerDetails;
    }

    @JsonProperty("siteID")
    public String getSiteID() {
        return siteID;
    }

    @JsonProperty("siteID")
    public void setSiteID(String siteID) {
        this.siteID = siteID;
    }

    @JsonProperty("SectorDetail")
    public List<SectorDetail> getSectorDetail() {
        return sectorDetail;
    }

    @JsonProperty("SectorDetail")
    public void setSectorDetail(List<SectorDetail> sectorDetail) {
        this.sectorDetail = sectorDetail;
    }

    @JsonProperty("BookingsHistory")
    public List<BookingsHistory> getBookingsHistory() {
        return bookingsHistory;
    }

    @JsonProperty("BookingsHistory")
    public void setBookingsHistory(List<BookingsHistory> bookingsHistory) {
        this.bookingsHistory = bookingsHistory;
    }

    @JsonProperty("bookingDetail")
    public BookingDetail getBookingDetail() {
        return bookingDetail;
    }

    @JsonProperty("bookingDetail")
    public void setBookingDetail(BookingDetail bookingDetail) {
        this.bookingDetail = bookingDetail;
    }

    @JsonProperty("invoiceNum")
    public String getInvoiceNum() {
        return invoiceNum;
    }

    @JsonProperty("invoiceNum")
    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    @JsonProperty("BookingsNotes")
    public List<BookingsNote> getBookingsNotes() {
        return bookingsNotes;
    }

    @JsonProperty("BookingsNotes")
    public void setBookingsNotes(List<BookingsNote> bookingsNotes) {
        this.bookingsNotes = bookingsNotes;
    }

    @JsonProperty("FareDetail")
    public List<FareDetail> getFareDetail() {
        return fareDetail;
    }

    @JsonProperty("FareDetail")
    public void setFareDetail(List<FareDetail> fareDetail) {
        this.fareDetail = fareDetail;
    }

    @JsonProperty("TraveloesMail")
    public List<Object> getTraveloesMail() {
        return traveloesMail;
    }

    @JsonProperty("TraveloesMail")
    public void setTraveloesMail(List<Object> traveloesMail) {
        this.traveloesMail = traveloesMail;
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
