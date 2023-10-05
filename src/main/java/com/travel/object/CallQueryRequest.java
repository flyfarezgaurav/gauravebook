
package com.travel.object;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "queryId",
    "fromCity",
    "toCity",
    "depDate",
    "retDate",
    "tripType",
    "cabinClass",
    "noPax",
    "sourceMedia",
    "paxName",
    "paxEmail",
    "phnNo",
    "siteId",
    "queryStatus",
    "assignTo",
    "modifyDate",
    "queryFroDate",
    "queryToDate",
})
@Generated("jsonschema2pojo")
public class CallQueryRequest {

    @JsonProperty("queryId")
    private Integer queryId;
    @JsonProperty("fromCity")
    private String fromCity;
    @JsonProperty("toCity")
    private String toCity;
    @JsonProperty("depDate")
    private String depDate;
    @JsonProperty("retDate")
    private String retDate;
    @JsonProperty("tripType")
    private String tripType;
    @JsonProperty("cabinClass")
    private String cabinClass;
    @JsonProperty("noPax")
    private Integer noPax;
    @JsonProperty("sourceMedia")
    private String sourceMedia;
    @JsonProperty("paxName")
    private String paxName;
    @JsonProperty("paxEmail")
    private String paxEmail;
    @JsonProperty("phnNo")
    private String phnNo;
    @JsonProperty("siteId")
    private Integer siteId;
    @JsonProperty("queryStatus")
    private String queryStatus;
    @JsonProperty("assignTo")
    private String assignTo;
    @JsonProperty("modifyDate")
    private String modifyDate;
    
    @JsonProperty("queryFroDate")
    private String queryFroDate;
    @JsonProperty("queryToDate")
    private String queryToDate;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("queryId")
    public Integer getQueryId() {
        return queryId;
    }

    @JsonProperty("queryId")
    public void setQueryId(Integer queryId) {
        this.queryId = queryId;
    }

    @JsonProperty("fromCity")
    public String getFromCity() {
        return fromCity;
    }

    @JsonProperty("fromCity")
    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    @JsonProperty("toCity")
    public String getToCity() {
        return toCity;
    }

    @JsonProperty("toCity")
    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    @JsonProperty("depDate")
    public String getDepDate() {
        return depDate;
    }

    @JsonProperty("depDate")
    public void setDepDate(String depDate) {
        this.depDate = depDate;
    }

    @JsonProperty("retDate")
    public String getRetDate() {
        return retDate;
    }

    @JsonProperty("retDate")
    public void setRetDate(String retDate) {
        this.retDate = retDate;
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

    @JsonProperty("noPax")
    public Integer getNoPax() {
        return noPax;
    }

    @JsonProperty("noPax")
    public void setNoPax(Integer noPax) {
        this.noPax = noPax;
    }

    @JsonProperty("sourceMedia")
    public String getSourceMedia() {
        return sourceMedia;
    }

    @JsonProperty("sourceMedia")
    public void setSourceMedia(String sourceMedia) {
        this.sourceMedia = sourceMedia;
    }

    @JsonProperty("paxName")
    public String getPaxName() {
        return paxName;
    }

    @JsonProperty("paxName")
    public void setPaxName(String paxName) {
        this.paxName = paxName;
    }

    @JsonProperty("paxEmail")
    public String getPaxEmail() {
        return paxEmail;
    }

    @JsonProperty("paxEmail")
    public void setPaxEmail(String paxEmail) {
        this.paxEmail = paxEmail;
    }

    @JsonProperty("phnNo")
    public String getPhnNo() {
        return phnNo;
    }

    @JsonProperty("phnNo")
    public void setPhnNo(String phnNo) {
        this.phnNo = phnNo;
    }

    @JsonProperty("siteId")
    public Integer getSiteId() {
        return siteId;
    }

    @JsonProperty("siteId")
    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    @JsonProperty("queryStatus")
    public String getQueryStatus() {
        return queryStatus;
    }

    @JsonProperty("queryStatus")
    public void setQueryStatus(String queryStatus) {
        this.queryStatus = queryStatus;
    }

    @JsonProperty("assignTo")
    public String getAssignTo() {
        return assignTo;
    }

    @JsonProperty("assignTo")
    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo;
    }

    @JsonProperty("modifyDate")
    public String getModifyDate() {
        return modifyDate;
    }

    @JsonProperty("modifyDate")
    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }
    
    @JsonProperty("queryFroDate")
    public String getQueryFroDate() {
		return queryFroDate;
	}

    @JsonProperty("queryFroDate")
	public void setQueryFroDate(String queryFroDate) {
		this.queryFroDate = queryFroDate;
	}

    @JsonProperty("queryToDate")
	public String getQueryToDate() {
		return queryToDate;
	}

    @JsonProperty("queryToDate")
	public void setQueryToDate(String queryToDate) {
		this.queryToDate = queryToDate;
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
