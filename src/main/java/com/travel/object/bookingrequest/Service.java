package com.travel.object.bookingrequest;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "productId", "name", "serviceId", "position", "showType", "iText" })
public class Service
{
    @JsonProperty("productId")
    private Integer productId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("serviceId")
    private Integer serviceId;
    @JsonProperty("position")
    private Integer position;
    @JsonProperty("showType")
    private String showType;
    @JsonProperty("iText")
    private String iText;
    @JsonIgnore
    private Map<String, Object> additionalProperties;
    
    public Service() {
        this.additionalProperties = new HashMap<String, Object>();
    }
    
    @JsonProperty("iText")
    public String getiText() {
        return this.iText;
    }
    
    @JsonProperty("iText")
    public void setiText(final String iText) {
        this.iText = iText;
    }
    
    @JsonProperty("productId")
    public Integer getProductId() {
        return this.productId;
    }
    
    @JsonProperty("productId")
    public void setProductId(final Integer productId) {
        this.productId = productId;
    }
    
    @JsonProperty("name")
    public String getName() {
        return this.name;
    }
    
    @JsonProperty("name")
    public void setName(final String name) {
        this.name = name;
    }
    
    @JsonProperty("serviceId")
    public Integer getServiceId() {
        return this.serviceId;
    }
    
    @JsonProperty("serviceId")
    public void setServiceId(final Integer serviceId) {
        this.serviceId = serviceId;
    }
    
    @JsonProperty("position")
    public Integer getPosition() {
        return this.position;
    }
    
    @JsonProperty("position")
    public void setPosition(final Integer position) {
        this.position = position;
    }
    
    @JsonProperty("showType")
    public String getShowType() {
        return this.showType;
    }
    
    @JsonProperty("showType")
    public void setShowType(final String showType) {
        this.showType = showType;
    }
    
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }
    
    @JsonAnySetter
    public void setAdditionalProperty(final String name, final Object value) {
        this.additionalProperties.put(name, value);
    }
}