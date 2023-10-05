
package com.travel.object.checkFareRulesResponse;

import java.util.HashMap;
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
    "productId",
    "name",
    "serviceId",
    "position",
    "showType"
})
@Generated("jsonschema2pojo")
public class Service {

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
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("productId")
    public Integer getProductId() {
        return productId;
    }

    @JsonProperty("productId")
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("serviceId")
    public Integer getServiceId() {
        return serviceId;
    }

    @JsonProperty("serviceId")
    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    @JsonProperty("position")
    public Integer getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(Integer position) {
        this.position = position;
    }

    @JsonProperty("showType")
    public String getShowType() {
        return showType;
    }

    @JsonProperty("showType")
    public void setShowType(String showType) {
        this.showType = showType;
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
