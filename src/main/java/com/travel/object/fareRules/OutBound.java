
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
    "SequenceNumber",
    "airline",
    "flightNo",
    "equipmentType",
    "equipmentTypeDes",
    "fromAirport",
    "depDate",
    "toAirport",
    "reachDate",
    "opratingAirline",
    "resDesignCode",
    "fromTerminal",
    "toTerminal",
    "cabinClass",
    "eft",
    "layOverTime",
    "techStops",
    "fareType"
})
public class OutBound {

    @JsonProperty("SequenceNumber")
    private Integer sequenceNumber;
    @JsonProperty("airline")
    private String airline;
    @JsonProperty("flightNo")
    private String flightNo;
    @JsonProperty("equipmentType")
    private String equipmentType;
    @JsonProperty("equipmentTypeDes")
    private Object equipmentTypeDes;
    @JsonProperty("fromAirport")
    private String fromAirport;
    @JsonProperty("depDate")
    private String depDate;
    @JsonProperty("toAirport")
    private String toAirport;
    @JsonProperty("reachDate")
    private String reachDate;
    @JsonProperty("opratingAirline")
    private String opratingAirline;
    @JsonProperty("resDesignCode")
    private String resDesignCode;
    @JsonProperty("fromTerminal")
    private String fromTerminal;
    @JsonProperty("toTerminal")
    private String toTerminal;
    @JsonProperty("cabinClass")
    private Integer cabinClass;
    @JsonProperty("eft")
    private Integer eft;
    @JsonProperty("layOverTime")
    private Integer layOverTime;
    @JsonProperty("techStops")
    private Integer techStops;
    @JsonProperty("fareType")
    private String fareType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("SequenceNumber")
    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    @JsonProperty("SequenceNumber")
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    @JsonProperty("airline")
    public String getAirline() {
        return airline;
    }

    @JsonProperty("airline")
    public void setAirline(String airline) {
        this.airline = airline;
    }

    @JsonProperty("flightNo")
    public String getFlightNo() {
        return flightNo;
    }

    @JsonProperty("flightNo")
    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    @JsonProperty("equipmentType")
    public String getEquipmentType() {
        return equipmentType;
    }

    @JsonProperty("equipmentType")
    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    @JsonProperty("equipmentTypeDes")
    public Object getEquipmentTypeDes() {
        return equipmentTypeDes;
    }

    @JsonProperty("equipmentTypeDes")
    public void setEquipmentTypeDes(Object equipmentTypeDes) {
        this.equipmentTypeDes = equipmentTypeDes;
    }

    @JsonProperty("fromAirport")
    public String getFromAirport() {
        return fromAirport;
    }

    @JsonProperty("fromAirport")
    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    @JsonProperty("depDate")
    public String getDepDate() {
        return depDate;
    }

    @JsonProperty("depDate")
    public void setDepDate(String depDate) {
        this.depDate = depDate;
    }

    @JsonProperty("toAirport")
    public String getToAirport() {
        return toAirport;
    }

    @JsonProperty("toAirport")
    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }

    @JsonProperty("reachDate")
    public String getReachDate() {
        return reachDate;
    }

    @JsonProperty("reachDate")
    public void setReachDate(String reachDate) {
        this.reachDate = reachDate;
    }

    @JsonProperty("opratingAirline")
    public String getOpratingAirline() {
        return opratingAirline;
    }

    @JsonProperty("opratingAirline")
    public void setOpratingAirline(String opratingAirline) {
        this.opratingAirline = opratingAirline;
    }

    @JsonProperty("resDesignCode")
    public String getResDesignCode() {
        return resDesignCode;
    }

    @JsonProperty("resDesignCode")
    public void setResDesignCode(String resDesignCode) {
        this.resDesignCode = resDesignCode;
    }

    @JsonProperty("fromTerminal")
    public String getFromTerminal() {
        return fromTerminal;
    }

    @JsonProperty("fromTerminal")
    public void setFromTerminal(String fromTerminal) {
        this.fromTerminal = fromTerminal;
    }

    @JsonProperty("toTerminal")
    public String getToTerminal() {
        return toTerminal;
    }

    @JsonProperty("toTerminal")
    public void setToTerminal(String toTerminal) {
        this.toTerminal = toTerminal;
    }

    @JsonProperty("cabinClass")
    public Integer getCabinClass() {
        return cabinClass;
    }

    @JsonProperty("cabinClass")
    public void setCabinClass(Integer cabinClass) {
        this.cabinClass = cabinClass;
    }

    @JsonProperty("eft")
    public Integer getEft() {
        return eft;
    }

    @JsonProperty("eft")
    public void setEft(Integer eft) {
        this.eft = eft;
    }

    @JsonProperty("layOverTime")
    public Integer getLayOverTime() {
        return layOverTime;
    }

    @JsonProperty("layOverTime")
    public void setLayOverTime(Integer layOverTime) {
        this.layOverTime = layOverTime;
    }

    @JsonProperty("techStops")
    public Integer getTechStops() {
        return techStops;
    }

    @JsonProperty("techStops")
    public void setTechStops(Integer techStops) {
        this.techStops = techStops;
    }

    @JsonProperty("fareType")
    public String getFareType() {
        return fareType;
    }

    @JsonProperty("fareType")
    public void setFareType(String fareType) {
        this.fareType = fareType;
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
