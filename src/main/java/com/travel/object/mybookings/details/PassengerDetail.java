
package com.travel.object.mybookings.details;

import java.util.Date;
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
    "passengerDetailId",
    "bookingId",
    "title",
    "paxFirstName",
    "paxMiddleName",
    "paxLastName",
    "frequentFlyerNo",
    "passportNo",
    "nationality",
    "expiryDate",
    "issueDate",
    "placeOfIssue",
    "placeOfBirth",
    "paxDob",
    "paxType",
    "paxSex",
    "modifiedBy",
    "modifiedDate",
    "pax_ticket",
    "seatNo",
    "extraLuggage"
})
public class PassengerDetail {

    @JsonProperty("passengerDetailId")
    private Integer passengerDetailId;
    @JsonProperty("bookingId")
    private Integer bookingId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("paxFirstName")
    private String paxFirstName;
    @JsonProperty("paxMiddleName")
    private Object paxMiddleName;
    @JsonProperty("paxLastName")
    private String paxLastName;
    @JsonProperty("frequentFlyerNo")
    private String frequentFlyerNo;
    @JsonProperty("passportNo")
    private Object passportNo;
    @JsonProperty("nationality")
    private Object nationality;
    @JsonProperty("expiryDate")
    private Object expiryDate;
    @JsonProperty("issueDate")
    private Object issueDate;
    @JsonProperty("placeOfIssue")
    private String placeOfIssue;
    @JsonProperty("placeOfBirth")
    private String placeOfBirth;
    @JsonProperty("paxDob")
    private Date paxDob;
    @JsonProperty("paxType")
    private Integer paxType;
    @JsonProperty("paxSex")
    private Integer paxSex;
    @JsonProperty("modifiedBy")
    private String modifiedBy;
    @JsonProperty("modifiedDate")
    private Date modifiedDate;
    @JsonProperty("pax_ticket")
    private Object paxTicket;
    @JsonProperty("seatNo")
    private Object seatNo;
    @JsonProperty("extraLuggage")
    private Object extraLuggage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("passengerDetailId")
    public Integer getPassengerDetailId() {
        return passengerDetailId;
    }

    @JsonProperty("passengerDetailId")
    public void setPassengerDetailId(Integer passengerDetailId) {
        this.passengerDetailId = passengerDetailId;
    }

    @JsonProperty("bookingId")
    public Integer getBookingId() {
        return bookingId;
    }

    @JsonProperty("bookingId")
    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("paxFirstName")
    public String getPaxFirstName() {
        return paxFirstName;
    }

    @JsonProperty("paxFirstName")
    public void setPaxFirstName(String paxFirstName) {
        this.paxFirstName = paxFirstName;
    }

    @JsonProperty("paxMiddleName")
    public Object getPaxMiddleName() {
        return paxMiddleName;
    }

    @JsonProperty("paxMiddleName")
    public void setPaxMiddleName(Object paxMiddleName) {
        this.paxMiddleName = paxMiddleName;
    }

    @JsonProperty("paxLastName")
    public String getPaxLastName() {
        return paxLastName;
    }

    @JsonProperty("paxLastName")
    public void setPaxLastName(String paxLastName) {
        this.paxLastName = paxLastName;
    }

    @JsonProperty("frequentFlyerNo")
    public String getFrequentFlyerNo() {
        return frequentFlyerNo;
    }

    @JsonProperty("frequentFlyerNo")
    public void setFrequentFlyerNo(String frequentFlyerNo) {
        this.frequentFlyerNo = frequentFlyerNo;
    }

    @JsonProperty("passportNo")
    public Object getPassportNo() {
        return passportNo;
    }

    @JsonProperty("passportNo")
    public void setPassportNo(Object passportNo) {
        this.passportNo = passportNo;
    }

    @JsonProperty("nationality")
    public Object getNationality() {
        return nationality;
    }

    @JsonProperty("nationality")
    public void setNationality(Object nationality) {
        this.nationality = nationality;
    }

    @JsonProperty("expiryDate")
    public Object getExpiryDate() {
        return expiryDate;
    }

    @JsonProperty("expiryDate")
    public void setExpiryDate(Object expiryDate) {
        this.expiryDate = expiryDate;
    }

    @JsonProperty("issueDate")
    public Object getIssueDate() {
        return issueDate;
    }

    @JsonProperty("issueDate")
    public void setIssueDate(Object issueDate) {
        this.issueDate = issueDate;
    }

    @JsonProperty("placeOfIssue")
    public String getPlaceOfIssue() {
        return placeOfIssue;
    }

    @JsonProperty("placeOfIssue")
    public void setPlaceOfIssue(String placeOfIssue) {
        this.placeOfIssue = placeOfIssue;
    }

    @JsonProperty("placeOfBirth")
    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    @JsonProperty("placeOfBirth")
    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    @JsonProperty("paxDob")
    public Date getPaxDob() {
        return paxDob;
    }

    @JsonProperty("paxDob")
    public void setPaxDob(Date paxDob) {
        this.paxDob = paxDob;
    }

    @JsonProperty("paxType")
    public Integer getPaxType() {
        return paxType;
    }

    @JsonProperty("paxType")
    public void setPaxType(Integer paxType) {
        this.paxType = paxType;
    }

    @JsonProperty("paxSex")
    public Integer getPaxSex() {
        return paxSex;
    }

    @JsonProperty("paxSex")
    public void setPaxSex(Integer paxSex) {
        this.paxSex = paxSex;
    }

    @JsonProperty("modifiedBy")
    public String getModifiedBy() {
        return modifiedBy;
    }

    @JsonProperty("modifiedBy")
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @JsonProperty("modifiedDate")
    public Date getModifiedDate() {
        return modifiedDate;
    }

    @JsonProperty("modifiedDate")
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @JsonProperty("pax_ticket")
    public Object getPaxTicket() {
        return paxTicket;
    }

    @JsonProperty("pax_ticket")
    public void setPaxTicket(Object paxTicket) {
        this.paxTicket = paxTicket;
    }

    @JsonProperty("seatNo")
    public Object getSeatNo() {
        return seatNo;
    }

    @JsonProperty("seatNo")
    public void setSeatNo(Object seatNo) {
        this.seatNo = seatNo;
    }

    @JsonProperty("extraLuggage")
    public Object getExtraLuggage() {
        return extraLuggage;
    }

    @JsonProperty("extraLuggage")
    public void setExtraLuggage(Object extraLuggage) {
        this.extraLuggage = extraLuggage;
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
