
package com.travel.object.blogs;

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
    "titleUrl",
    "siteId"
})
public class BlogsRequest {

    @JsonProperty("titleUrl")
    private String titleUrl;
    @JsonProperty("siteId")
    private String siteId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("titleUrl")
    public String getTitleUrl() {
        return titleUrl;
    }

    @JsonProperty("titleUrl")
    public void setTitleUrl(String titleUrl) {
        this.titleUrl = titleUrl;
    }

    @JsonProperty("siteId")
    public String getSiteId() {
        return siteId;
    }

    @JsonProperty("siteId")
    public void setSiteId(String siteId) {
        this.siteId = siteId;
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
