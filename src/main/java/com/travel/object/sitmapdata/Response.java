
package com.travel.object.sitmapdata;

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
    "contentId",
    "pageType",
    "pageValue",
    "pageName",
    "siteId",
    "status",
    "url",
    "airportList"
})
public class Response {

    @JsonProperty("contentId")
    private Integer contentId;
    @JsonProperty("pageType")
    private String pageType;
    @JsonProperty("pageValue")
    private String pageValue;
    @JsonProperty("pageName")
    private String pageName;
    @JsonProperty("siteId")
    private String siteId;
    @JsonProperty("status")
    private String status;
    @JsonProperty("url")
    private String url;
    @JsonProperty("airportList")
    private List<Object> airportList = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("contentId")
    public Integer getContentId() {
        return contentId;
    }

    @JsonProperty("contentId")
    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    @JsonProperty("pageType")
    public String getPageType() {
        return pageType;
    }

    @JsonProperty("pageType")
    public void setPageType(String pageType) {
        this.pageType = pageType;
    }

    @JsonProperty("pageValue")
    public String getPageValue() {
        return pageValue;
    }

    @JsonProperty("pageValue")
    public void setPageValue(String pageValue) {
        this.pageValue = pageValue;
    }

    @JsonProperty("pageName")
    public String getPageName() {
        return pageName;
    }

    @JsonProperty("pageName")
    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    @JsonProperty("siteId")
    public String getSiteId() {
        return siteId;
    }

    @JsonProperty("siteId")
    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("airportList")
    public List<Object> getAirportList() {
        return airportList;
    }

    @JsonProperty("airportList")
    public void setAirportList(List<Object> airportList) {
        this.airportList = airportList;
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
