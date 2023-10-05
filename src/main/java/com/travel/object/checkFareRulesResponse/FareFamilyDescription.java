
package com.travel.object.checkFareRulesResponse;

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
    "rateCategory",
    "description",
    "serviceInformation"
})

public class FareFamilyDescription {

    @JsonProperty("rateCategory")
    private String rateCategory;
    @JsonProperty("description")
    private String description;
    @JsonProperty("serviceInformation")
    private List<ServiceInformation> serviceInformation = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("rateCategory")
    public String getRateCategory() {
        return rateCategory;
    }

    @JsonProperty("rateCategory")
    public void setRateCategory(String rateCategory) {
        this.rateCategory = rateCategory;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("serviceInformation")
    public List<ServiceInformation> getServiceInformation() {
        return serviceInformation;
    }

    @JsonProperty("serviceInformation")
    public void setServiceInformation(List<ServiceInformation> serviceInformation) {
        this.serviceInformation = serviceInformation;
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
