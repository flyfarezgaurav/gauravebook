
package com.travel.object.login;

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
    "viewId",
    "viewName",
    "viewUrl"
})
public class SubMenu {

    @JsonProperty("viewId")
    private Integer viewId;
    @JsonProperty("viewName")
    private String viewName;
    @JsonProperty("viewUrl")
    private String viewUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("viewId")
    public Integer getViewId() {
        return viewId;
    }

    @JsonProperty("viewId")
    public void setViewId(Integer viewId) {
        this.viewId = viewId;
    }

    @JsonProperty("viewName")
    public String getViewName() {
        return viewName;
    }

    @JsonProperty("viewName")
    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    @JsonProperty("viewUrl")
    public String getViewUrl() {
        return viewUrl;
    }

    @JsonProperty("viewUrl")
    public void setViewUrl(String viewUrl) {
        this.viewUrl = viewUrl;
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
