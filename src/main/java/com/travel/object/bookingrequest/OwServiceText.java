
package com.travel.object.bookingrequest;

import java.util.HashMap;
import java.util.List;
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
    "mostPopular",
    "price",
    "serviceId",
    "conditionList"
})
@Generated("jsonschema2pojo")
public class OwServiceText {

    @JsonProperty("productId")
    private Integer productId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("mostPopular")
    private Boolean mostPopular;
    @JsonProperty("price")
    private Integer price;
    @JsonProperty("serviceId")
    private Integer serviceId;
    @JsonProperty("conditionList")
    private List<Condition> conditionList = null;
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

    @JsonProperty("mostPopular")
    public Boolean getMostPopular() {
        return mostPopular;
    }

    @JsonProperty("mostPopular")
    public void setMostPopular(Boolean mostPopular) {
        this.mostPopular = mostPopular;
    }

    @JsonProperty("price")
    public Integer getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Integer price) {
        this.price = price;
    }

    @JsonProperty("serviceId")
    public Integer getServiceId() {
        return serviceId;
    }

    @JsonProperty("serviceId")
    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    @JsonProperty("conditionList")
    public List<Condition> getConditionList() {
        return conditionList;
    }

    @JsonProperty("conditionList")
    public void setConditionList(List<Condition> conditionList) {
        this.conditionList = conditionList;
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
