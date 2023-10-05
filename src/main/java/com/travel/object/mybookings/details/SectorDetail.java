
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
    "sectorDetailId",
    "bookingId",
    "airline",
    "opratingAirline",
    "fromDestination",
    "fromDateTime",
    "toDestination",
    "toDateTime",
    "flightNo",
    "aclass",
    "status",
    "fareBasis",
    "notValidBefor",
    "notValidAfter",
    "baggageAllownce",
    "airportTerminalFrom",
    "airportTerminalTo",
    "eft",
    "layOverTime",
    "equipmentType",
    "segId",
    "segRemarks",
    "tripId",
    "modifiedBy",
    "modifiedDate",
    "equipmentTypeDes",
    "techStops",
    "fareType",
    "cabinclass",
    "sectorStatus"
})
public class SectorDetail {

    @JsonProperty("sectorDetailId")
    private Integer sectorDetailId;
    @JsonProperty("bookingId")
    private Integer bookingId;
    @JsonProperty("airline")
    private Object airline;
    @JsonProperty("opratingAirline")
    private String opratingAirline;
    @JsonProperty("fromDestination")
    private String fromDestination;
    @JsonProperty("fromDateTime")
    private Date fromDateTime;
    @JsonProperty("toDestination")
    private String toDestination;
    @JsonProperty("toDateTime")
    private Date toDateTime;
    @JsonProperty("flightNo")
    private String flightNo;
    @JsonProperty("aclass")
    private String aclass;
    @JsonProperty("status")
    private String status;
    @JsonProperty("fareBasis")
    private Object fareBasis;
    @JsonProperty("notValidBefor")
    private String notValidBefor;
    @JsonProperty("notValidAfter")
    private String notValidAfter;
    @JsonProperty("baggageAllownce")
    private String baggageAllownce;
    @JsonProperty("airportTerminalFrom")
    private Object airportTerminalFrom;
    @JsonProperty("airportTerminalTo")
    private Object airportTerminalTo;
    @JsonProperty("eft")
    private Object eft;
    @JsonProperty("layOverTime")
    private Object layOverTime;
    @JsonProperty("equipmentType")
    private String equipmentType;
    @JsonProperty("segId")
    private Integer segId;
    @JsonProperty("segRemarks")
    private String segRemarks;
    @JsonProperty("tripId")
    private Integer tripId;
    @JsonProperty("modifiedBy")
    private String modifiedBy;
    @JsonProperty("modifiedDate")
    private Date modifiedDate;
    @JsonProperty("equipmentTypeDes")
    private Object equipmentTypeDes;
    @JsonProperty("techStops")
    private String techStops;
    @JsonProperty("fareType")
    private Object fareType;
    @JsonProperty("cabinclass")
    private String cabinclass;
    @JsonProperty("sectorStatus")
    private String sectorStatus;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("sectorDetailId")
    public Integer getSectorDetailId() {
        return sectorDetailId;
    }

    @JsonProperty("sectorDetailId")
    public void setSectorDetailId(Integer sectorDetailId) {
        this.sectorDetailId = sectorDetailId;
    }

    @JsonProperty("bookingId")
    public Integer getBookingId() {
        return bookingId;
    }

    @JsonProperty("bookingId")
    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    @JsonProperty("airline")
    public Object getAirline() {
        return airline;
    }

    @JsonProperty("airline")
    public void setAirline(Object airline) {
        this.airline = airline;
    }

    @JsonProperty("opratingAirline")
    public String getOpratingAirline() {
        return opratingAirline;
    }

    @JsonProperty("opratingAirline")
    public void setOpratingAirline(String opratingAirline) {
        this.opratingAirline = opratingAirline;
    }

    @JsonProperty("fromDestination")
    public String getFromDestination() {
        return fromDestination;
    }

    @JsonProperty("fromDestination")
    public void setFromDestination(String fromDestination) {
        this.fromDestination = fromDestination;
    }

    @JsonProperty("fromDateTime")
    public Date getFromDateTime() {
        return fromDateTime;
    }

    @JsonProperty("fromDateTime")
    public void setFromDateTime(Date fromDateTime) {
        this.fromDateTime = fromDateTime;
    }

    @JsonProperty("toDestination")
    public String getToDestination() {
        return toDestination;
    }

    @JsonProperty("toDestination")
    public void setToDestination(String toDestination) {
        this.toDestination = toDestination;
    }

    @JsonProperty("toDateTime")
    public Date getToDateTime() {
        return toDateTime;
    }

    @JsonProperty("toDateTime")
    public void setToDateTime(Date toDateTime) {
        this.toDateTime = toDateTime;
    }

    @JsonProperty("flightNo")
    public String getFlightNo() {
        return flightNo;
    }

    @JsonProperty("flightNo")
    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    @JsonProperty("aclass")
    public String getAclass() {
        return aclass;
    }

    @JsonProperty("aclass")
    public void setAclass(String aclass) {
        this.aclass = aclass;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("fareBasis")
    public Object getFareBasis() {
        return fareBasis;
    }

    @JsonProperty("fareBasis")
    public void setFareBasis(Object fareBasis) {
        this.fareBasis = fareBasis;
    }

    @JsonProperty("notValidBefor")
    public String getNotValidBefor() {
        return notValidBefor;
    }

    @JsonProperty("notValidBefor")
    public void setNotValidBefor(String notValidBefor) {
        this.notValidBefor = notValidBefor;
    }

    @JsonProperty("notValidAfter")
    public String getNotValidAfter() {
        return notValidAfter;
    }

    @JsonProperty("notValidAfter")
    public void setNotValidAfter(String notValidAfter) {
        this.notValidAfter = notValidAfter;
    }

    @JsonProperty("baggageAllownce")
    public String getBaggageAllownce() {
        return baggageAllownce;
    }

    @JsonProperty("baggageAllownce")
    public void setBaggageAllownce(String baggageAllownce) {
        this.baggageAllownce = baggageAllownce;
    }

    @JsonProperty("airportTerminalFrom")
    public Object getAirportTerminalFrom() {
        return airportTerminalFrom;
    }

    @JsonProperty("airportTerminalFrom")
    public void setAirportTerminalFrom(Object airportTerminalFrom) {
        this.airportTerminalFrom = airportTerminalFrom;
    }

    @JsonProperty("airportTerminalTo")
    public Object getAirportTerminalTo() {
        return airportTerminalTo;
    }

    @JsonProperty("airportTerminalTo")
    public void setAirportTerminalTo(Object airportTerminalTo) {
        this.airportTerminalTo = airportTerminalTo;
    }

    @JsonProperty("eft")
    public Object getEft() {
        return eft;
    }

    @JsonProperty("eft")
    public void setEft(Object eft) {
        this.eft = eft;
    }

    @JsonProperty("layOverTime")
    public Object getLayOverTime() {
        return layOverTime;
    }

    @JsonProperty("layOverTime")
    public void setLayOverTime(Object layOverTime) {
        this.layOverTime = layOverTime;
    }

    @JsonProperty("equipmentType")
    public String getEquipmentType() {
        return equipmentType;
    }

    @JsonProperty("equipmentType")
    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    @JsonProperty("segId")
    public Integer getSegId() {
        return segId;
    }

    @JsonProperty("segId")
    public void setSegId(Integer segId) {
        this.segId = segId;
    }

    @JsonProperty("segRemarks")
    public String getSegRemarks() {
        return segRemarks;
    }

    @JsonProperty("segRemarks")
    public void setSegRemarks(String segRemarks) {
        this.segRemarks = segRemarks;
    }

    @JsonProperty("tripId")
    public Integer getTripId() {
        return tripId;
    }

    @JsonProperty("tripId")
    public void setTripId(Integer tripId) {
        this.tripId = tripId;
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

    @JsonProperty("equipmentTypeDes")
    public Object getEquipmentTypeDes() {
        return equipmentTypeDes;
    }

    @JsonProperty("equipmentTypeDes")
    public void setEquipmentTypeDes(Object equipmentTypeDes) {
        this.equipmentTypeDes = equipmentTypeDes;
    }

    @JsonProperty("techStops")
    public String getTechStops() {
        return techStops;
    }

    @JsonProperty("techStops")
    public void setTechStops(String techStops) {
        this.techStops = techStops;
    }

    @JsonProperty("fareType")
    public Object getFareType() {
        return fareType;
    }

    @JsonProperty("fareType")
    public void setFareType(Object fareType) {
        this.fareType = fareType;
    }

    @JsonProperty("cabinclass")
    public String getCabinclass() {
        return cabinclass;
    }

    @JsonProperty("cabinclass")
    public void setCabinclass(String cabinclass) {
        this.cabinclass = cabinclass;
    }

    @JsonProperty("sectorStatus")
    public String getSectorStatus() {
        return sectorStatus;
    }

    @JsonProperty("sectorStatus")
    public void setSectorStatus(String sectorStatus) {
        this.sectorStatus = sectorStatus;
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
