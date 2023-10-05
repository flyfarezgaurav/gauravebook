
package com.travel.object.pagerequest;

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
    "pageType",
    "pageValue",
    "siteId",
    "url"
})
public class PageRequest {

    @JsonProperty("pageType")
    private String pageType;
    @JsonProperty("pageValue")
    private String pageValue;
    @JsonProperty("siteId")
    private String siteId;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    @JsonProperty("siteId")
    public String getSiteId() {
        return siteId;
    }

    @JsonProperty("siteId")
    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
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
