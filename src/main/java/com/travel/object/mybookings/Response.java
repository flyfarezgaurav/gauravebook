
package com.travel.object.mybookings;

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
    "orderNum",
    "referenceNum",
    "bookingStatus",
    "billingStatus",
    "ticketStatus",
    "supplier",
    "sourceMedia",
    "totalAmount",
    "currency",
    "customerRegistrationId",
    "emailId",
    "tripType",
    "cabinClass",
    "froCity",
    "toCity",
    "bookingDate",
    "travelDate",
    "valiCarrier",
    "productType",
    "totalPass",
    "passFrstName",
    "PassLastName",
    "sessionId",
    "siteName",
    "invoiceNum",
    "fareDetail",
    "tfnNo",
    "bookingBy"
})
public class Response {

    @JsonProperty("orderNum")
    private String orderNum;
    @JsonProperty("referenceNum")
    private String referenceNum;
    @JsonProperty("bookingStatus")
    private String bookingStatus;
    @JsonProperty("billingStatus")
    private String billingStatus;
    @JsonProperty("ticketStatus")
    private String ticketStatus;
    @JsonProperty("supplier")
    private String supplier;
    @JsonProperty("sourceMedia")
    private String sourceMedia;
    @JsonProperty("totalAmount")
    private String totalAmount;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("customerRegistrationId")
    private String customerRegistrationId;
    @JsonProperty("emailId")
    private String emailId;
    @JsonProperty("tripType")
    private String tripType;
    @JsonProperty("cabinClass")
    private String cabinClass;
    @JsonProperty("froCity")
    private String froCity;
    @JsonProperty("toCity")
    private String toCity;
    @JsonProperty("bookingDate")
    private String bookingDate;
    @JsonProperty("travelDate")
    private String travelDate;
    @JsonProperty("valiCarrier")
    private String valiCarrier;
    @JsonProperty("productType")
    private String productType;
    @JsonProperty("totalPass")
    private String totalPass;
    @JsonProperty("passFrstName")
    private String passFrstName;
    @JsonProperty("PassLastName")
    private String passLastName;
    @JsonProperty("sessionId")
    private String sessionId;
    @JsonProperty("siteName")
    private String siteName;
    @JsonProperty("invoiceNum")
    private String invoiceNum;
    @JsonProperty("fareDetail")
    private List<FareDetail> fareDetail = null;
    @JsonProperty("tfnNo")
    private String tfnNo;
    @JsonProperty("bookingBy")
    private String bookingBy;
    private int daydiff;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("orderNum")
    public String getOrderNum() {
        return orderNum;
    }

    @JsonProperty("orderNum")
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    @JsonProperty("referenceNum")
    public String getReferenceNum() {
        return referenceNum;
    }

    @JsonProperty("referenceNum")
    public void setReferenceNum(String referenceNum) {
        this.referenceNum = referenceNum;
    }

    @JsonProperty("bookingStatus")
    public String getBookingStatus() {
        return bookingStatus;
    }

    @JsonProperty("bookingStatus")
    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    @JsonProperty("billingStatus")
    public String getBillingStatus() {
        return billingStatus;
    }

    @JsonProperty("billingStatus")
    public void setBillingStatus(String billingStatus) {
        this.billingStatus = billingStatus;
    }

    @JsonProperty("ticketStatus")
    public String getTicketStatus() {
        return ticketStatus;
    }

    @JsonProperty("ticketStatus")
    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    @JsonProperty("supplier")
    public String getSupplier() {
        return supplier;
    }

    @JsonProperty("supplier")
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @JsonProperty("sourceMedia")
    public String getSourceMedia() {
        return sourceMedia;
    }

    @JsonProperty("sourceMedia")
    public void setSourceMedia(String sourceMedia) {
        this.sourceMedia = sourceMedia;
    }

    @JsonProperty("totalAmount")
    public String getTotalAmount() {
        return totalAmount;
    }

    @JsonProperty("totalAmount")
    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("customerRegistrationId")
    public String getCustomerRegistrationId() {
        return customerRegistrationId;
    }

    @JsonProperty("customerRegistrationId")
    public void setCustomerRegistrationId(String customerRegistrationId) {
        this.customerRegistrationId = customerRegistrationId;
    }

    @JsonProperty("emailId")
    public String getEmailId() {
        return emailId;
    }

    @JsonProperty("emailId")
    public void setEmailId(String emailId) {
        this.emailId = emailId;
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

    @JsonProperty("bookingDate")
    public String getBookingDate() {
        return bookingDate;
    }

    @JsonProperty("bookingDate")
    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    @JsonProperty("travelDate")
    public String getTravelDate() {
        return travelDate;
    }

    @JsonProperty("travelDate")
    public void setTravelDate(String travelDate) {
        this.travelDate = travelDate;
    }

    @JsonProperty("valiCarrier")
    public String getValiCarrier() {
        return valiCarrier;
    }

    @JsonProperty("valiCarrier")
    public void setValiCarrier(String valiCarrier) {
        this.valiCarrier = valiCarrier;
    }

    @JsonProperty("productType")
    public String getProductType() {
        return productType;
    }

    @JsonProperty("productType")
    public void setProductType(String productType) {
        this.productType = productType;
    }

    @JsonProperty("totalPass")
    public String getTotalPass() {
        return totalPass;
    }

    @JsonProperty("totalPass")
    public void setTotalPass(String totalPass) {
        this.totalPass = totalPass;
    }

    @JsonProperty("passFrstName")
    public String getPassFrstName() {
        return passFrstName;
    }

    @JsonProperty("passFrstName")
    public void setPassFrstName(String passFrstName) {
        this.passFrstName = passFrstName;
    }

    @JsonProperty("PassLastName")
    public String getPassLastName() {
        return passLastName;
    }

    @JsonProperty("PassLastName")
    public void setPassLastName(String passLastName) {
        this.passLastName = passLastName;
    }

    @JsonProperty("sessionId")
    public String getSessionId() {
        return sessionId;
    }

    @JsonProperty("sessionId")
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @JsonProperty("siteName")
    public String getSiteName() {
        return siteName;
    }

    @JsonProperty("siteName")
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    @JsonProperty("invoiceNum")
    public String getInvoiceNum() {
        return invoiceNum;
    }

    @JsonProperty("invoiceNum")
    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    @JsonProperty("fareDetail")
    public List<FareDetail> getFareDetail() {
        return fareDetail;
    }

    @JsonProperty("fareDetail")
    public void setFareDetail(List<FareDetail> fareDetail) {
        this.fareDetail = fareDetail;
    }

    @JsonProperty("tfnNo")
    public String getTfnNo() {
        return tfnNo;
    }

    @JsonProperty("tfnNo")
    public void setTfnNo(String tfnNo) {
        this.tfnNo = tfnNo;
    }

    @JsonProperty("bookingBy")
    public String getBookingBy() {
        return bookingBy;
    }

    @JsonProperty("bookingBy")
    public void setBookingBy(String bookingBy) {
        this.bookingBy = bookingBy;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	public int getDaydiff() {
		return daydiff;
	}

	public void setDaydiff(int daydiff) {
		this.daydiff = daydiff;
	}

}
