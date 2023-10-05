
package com.travel.object.searchRequest;

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
    "searchID",
    "client",
    "segment",
    "searchDirectFlight",
    "flexibleSearch",
    "tripType",
    "adults",
    "child",
    "infants",
    "infantsWs",
    "cabinType",
    "airline",
    "currencyCode",
    "siteId",
    "source",
    "media",
    "sID",
    "rID",
    "locale",
    "isNearBy",
    "limit",
    "page",
    "pageValue",
    "userIP",
    "serverIP",
    "device",
	"browser"
})
public class FlightRequest {
	
    @JsonProperty("searchID")
    private String searchID;
    @JsonProperty("client")
    private Integer client;
    @JsonProperty("segment")
    private List<Segment> segment = null;
    @JsonProperty("searchDirectFlight")
    private Boolean searchDirectFlight;
    @JsonProperty("flexibleSearch")
    private Boolean flexibleSearch;
    @JsonProperty("tripType")
    private Integer tripType;
    @JsonProperty("adults")
    private Integer adults;
    @JsonProperty("child")
    private Integer child;
    @JsonProperty("infants")
    private Integer infants;
    @JsonProperty("infantsWs")
    private Integer infantsWs;
    @JsonProperty("cabinType")
    private Integer cabinType;
    @JsonProperty("airline")
    private String airline;
    @JsonProperty("currencyCode")
    private String currencyCode;
    @JsonProperty("siteId")
    private Integer siteId;
    @JsonProperty("source")
    private String source;
    @JsonProperty("media")
    private String media;
    @JsonProperty("sID")
    private String sID;
    @JsonProperty("rID")
    private String rID;
    @JsonProperty("locale")
    private String locale;
    @JsonProperty("isNearBy")
    private Boolean isNearBy;
    @JsonProperty("limit")
    private Integer limit;
    @JsonProperty("page")
    private String page;
    @JsonProperty("pageValue")
    private String pageValue;
    @JsonProperty("userIP")
    private String userIP;
    @JsonProperty("serverIP")
    private String serverIP;
    @JsonProperty("device")
    private String device;
    @JsonProperty("browser")
	private String browser;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

   
	
    @JsonProperty("searchID")
    public String getSearchID() {
        return searchID;
    }

    @JsonProperty("searchID")
    public void setSearchID(String searchID) {
        this.searchID = searchID;
    }

    @JsonProperty("client")
    public Integer getClient() {
        return client;
    }

    @JsonProperty("client")
    public void setClient(Integer client) {
        this.client = client;
    }

    @JsonProperty("segment")
    public List<Segment> getSegment() {
        return segment;
    }

    @JsonProperty("segment")
    public void setSegment(List<Segment> segment) {
        this.segment = segment;
    }

    @JsonProperty("searchDirectFlight")
    public Boolean getSearchDirectFlight() {
        return searchDirectFlight;
    }

    @JsonProperty("searchDirectFlight")
    public void setSearchDirectFlight(Boolean searchDirectFlight) {
        this.searchDirectFlight = searchDirectFlight;
    }

    @JsonProperty("flexibleSearch")
    public Boolean getFlexibleSearch() {
        return flexibleSearch;
    }

    @JsonProperty("flexibleSearch")
    public void setFlexibleSearch(Boolean flexibleSearch) {
        this.flexibleSearch = flexibleSearch;
    }

    @JsonProperty("tripType")
    public Integer getTripType() {
        return tripType;
    }

    @JsonProperty("tripType")
    public void setTripType(Integer tripType) {
        this.tripType = tripType;
    }

    @JsonProperty("adults")
    public Integer getAdults() {
        return adults;
    }

    @JsonProperty("adults")
    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    @JsonProperty("child")
    public Integer getChild() {
        return child;
    }

    @JsonProperty("child")
    public void setChild(Integer child) {
        this.child = child;
    }

    @JsonProperty("infants")
    public Integer getInfants() {
        return infants;
    }

    @JsonProperty("infants")
    public void setInfants(Integer infants) {
        this.infants = infants;
    }

    @JsonProperty("infantsWs")
    public Integer getInfantsWs() {
        return infantsWs;
    }

    @JsonProperty("infantsWs")
    public void setInfantsWs(Integer infantsWs) {
        this.infantsWs = infantsWs;
    }

    @JsonProperty("cabinType")
    public Integer getCabinType() {
        return cabinType;
    }

    @JsonProperty("cabinType")
    public void setCabinType(Integer cabinType) {
        this.cabinType = cabinType;
    }

    @JsonProperty("airline")
    public String getAirline() {
        return airline;
    }

    @JsonProperty("airline")
    public void setAirline(String airline) {
        this.airline = airline;
    }

    @JsonProperty("currencyCode")
    public String getCurrencyCode() {
        return currencyCode;
    }

    @JsonProperty("currencyCode")
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @JsonProperty("siteId")
    public Integer getSiteId() {
        return siteId;
    }

    @JsonProperty("siteId")
    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("media")
    public String getMedia() {
        return media;
    }

    @JsonProperty("media")
    public void setMedia(String media) {
        this.media = media;
    }

    @JsonProperty("sID")
    public String getSID() {
        return sID;
    }

    @JsonProperty("sID")
    public void setSID(String sID) {
        this.sID = sID;
    }

    @JsonProperty("rID")
    public String getRID() {
        return rID;
    }

    @JsonProperty("rID")
    public void setRID(String rID) {
        this.rID = rID;
    }

    @JsonProperty("locale")
    public String getLocale() {
        return locale;
    }

    @JsonProperty("locale")
    public void setLocale(String locale) {
        this.locale = locale;
    }

    @JsonProperty("isNearBy")
    public Boolean getIsNearBy() {
        return isNearBy;
    }

    @JsonProperty("isNearBy")
    public void setIsNearBy(Boolean isNearBy) {
        this.isNearBy = isNearBy;
    }

    @JsonProperty("limit")
    public Integer getLimit() {
        return limit;
    }

    @JsonProperty("limit")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @JsonProperty("page")
    public String getPage() {
        return page;
    }

    @JsonProperty("page")
    public void setPage(String page) {
        this.page = page;
    }

    @JsonProperty("pageValue")
    public String getPageValue() {
        return pageValue;
    }

    @JsonProperty("pageValue")
    public void setPageValue(String pageValue) {
        this.pageValue = pageValue;
    }

    @JsonProperty("userIP")
    public String getUserIP() {
        return userIP;
    }

    @JsonProperty("userIP")
    public void setUserIP(String userIP) {
        this.userIP = userIP;
    }

    @JsonProperty("serverIP")
    public String getServerIP() {
        return serverIP;
    }

    @JsonProperty("serverIP")
    public void setServerIP(String serverIP) {
        this.serverIP = serverIP;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

}
