
package com.travel.object.flightresponse;

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
    "orgAirline",
    "flightID",
    "flightNo",
    "equipmentType",
    "equipmentTypeDes",
    "fromAirport",
    "depDate",
    "toAirport",
    "reachDate",
    "opratingAirline",
    "resDesignCode",
    "toTerminal",
    "cabinClass",
    "eft",
    "estimateTime",
    "layOverTime",
    "fareType",
    "isETicketEligible",
    "airlineName",
    "orgdepDate",
    "orgreachDate",
    "fromTerminal"
})
public class InBound {

    @JsonProperty("SequenceNumber")
    private String sequenceNumber;
    @JsonProperty("airline")
    private String airline;
    @JsonProperty("orgAirline")
    private String orgAirline;
    @JsonProperty("flightID")
    private String flightID;
    @JsonProperty("flightNo")
    private String flightNo;
    @JsonProperty("equipmentType")
    private String equipmentType;
    @JsonProperty("equipmentTypeDes")
    private String equipmentTypeDes;
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
    @JsonProperty("toTerminal")
    private String toTerminal;
    @JsonProperty("cabinClass")
    private Integer cabinClass;
    @JsonProperty("eft")
    private Integer eft;
    @JsonProperty("estimateTime")
    private Integer estimateTime;
    @JsonProperty("layOverTime")
    private Integer layOverTime;
    @JsonProperty("fareType")
    private String fareType;
    @JsonProperty("isETicketEligible")
    private Boolean isETicketEligible;
    @JsonProperty("airlineName")
    private String airlineName;
    @JsonProperty("orgdepDate")
    private String orgdepDate;
    @JsonProperty("orgreachDate")
    private String orgreachDate;
    @JsonProperty("fromTerminal")
    private String fromTerminal;
    private String fromAirportName;
    private String toAirportName;
    private String froCityName;
    private String toCityName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("SequenceNumber")
    public String getSequenceNumber() {
        return sequenceNumber;
    }

    @JsonProperty("SequenceNumber")
    public void setSequenceNumber(String sequenceNumber) {
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

    @JsonProperty("orgAirline")
    public String getOrgAirline() {
        return orgAirline;
    }

    @JsonProperty("orgAirline")
    public void setOrgAirline(String orgAirline) {
        this.orgAirline = orgAirline;
    }

    @JsonProperty("flightID")
    public String getFlightID() {
        return flightID;
    }

    @JsonProperty("flightID")
    public void setFlightID(String flightID) {
        this.flightID = flightID;
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
    public String getEquipmentTypeDes() {
        return equipmentTypeDes;
    }

    @JsonProperty("equipmentTypeDes")
    public void setEquipmentTypeDes(String equipmentTypeDes) {
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

    @JsonProperty("estimateTime")
    public Integer getEstimateTime() {
        return estimateTime;
    }

    @JsonProperty("estimateTime")
    public void setEstimateTime(Integer estimateTime) {
        this.estimateTime = estimateTime;
    }

    @JsonProperty("layOverTime")
    public Integer getLayOverTime() {
        return layOverTime;
    }

    @JsonProperty("layOverTime")
    public void setLayOverTime(Integer layOverTime) {
        this.layOverTime = layOverTime;
    }

    @JsonProperty("fareType")
    public String getFareType() {
        return fareType;
    }

    @JsonProperty("fareType")
    public void setFareType(String fareType) {
        this.fareType = fareType;
    }

    @JsonProperty("isETicketEligible")
    public Boolean getIsETicketEligible() {
        return isETicketEligible;
    }

    @JsonProperty("isETicketEligible")
    public void setIsETicketEligible(Boolean isETicketEligible) {
        this.isETicketEligible = isETicketEligible;
    }

    @JsonProperty("airlineName")
    public String getAirlineName() {
        return airlineName;
    }

    @JsonProperty("airlineName")
    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    @JsonProperty("orgdepDate")
    public String getOrgdepDate() {
        return orgdepDate;
    }

    @JsonProperty("orgdepDate")
    public void setOrgdepDate(String orgdepDate) {
        this.orgdepDate = orgdepDate;
    }

    @JsonProperty("orgreachDate")
    public String getOrgreachDate() {
        return orgreachDate;
    }

    @JsonProperty("orgreachDate")
    public void setOrgreachDate(String orgreachDate) {
        this.orgreachDate = orgreachDate;
    }

    @JsonProperty("fromTerminal")
    public String getFromTerminal() {
        return fromTerminal;
    }

    @JsonProperty("fromTerminal")
    public void setFromTerminal(String fromTerminal) {
        this.fromTerminal = fromTerminal;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	public String getFromAirportName() {
		return fromAirportName;
	}

	public void setFromAirportName(String fromAirportName) {
		this.fromAirportName = fromAirportName;
	}

	public String getToAirportName() {
		return toAirportName;
	}

	public void setToAirportName(String toAirportName) {
		this.toAirportName = toAirportName;
	}

	public String getFroCityName() {
		return froCityName;
	}

	public void setFroCityName(String froCityName) {
		this.froCityName = froCityName;
	}

	public String getToCityName() {
		return toCityName;
	}

	public void setToCityName(String toCityName) {
		this.toCityName = toCityName;
	}
    

}
