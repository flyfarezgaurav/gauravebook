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
    "totalPrice",
    "familyNames",
    "classOfServices",
    "fareFamilyDescription",
    "priceDiffrence"
})

public class FareFamily {

    @JsonProperty("totalPrice")
    private String totalPrice;
    @JsonProperty("familyNames")
    private List<String> familyNames = null;
    @JsonProperty("classOfServices")
    private List<String> classOfServices = null;
    @JsonProperty("fareFamilyDescription")
    private List<FareFamilyDescription> fareFamilyDescription = null;
    @JsonProperty("priceDiffrence")
    private String priceDiffrence;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("totalPrice")
    public String getTotalPrice() {
        return totalPrice;
    }

    @JsonProperty("totalPrice")
    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    @JsonProperty("familyNames")
    public List<String> getFamilyNames() {
        return familyNames;
    }

    @JsonProperty("familyNames")
    public void setFamilyNames(List<String> familyNames) {
        this.familyNames = familyNames;
    }

    @JsonProperty("classOfServices")
    public List<String> getClassOfServices() {
        return classOfServices;
    }

    @JsonProperty("classOfServices")
    public void setClassOfServices(List<String> classOfServices) {
        this.classOfServices = classOfServices;
    }

    @JsonProperty("fareFamilyDescription")
    public List<FareFamilyDescription> getFareFamilyDescription() {
        return fareFamilyDescription;
    }

    @JsonProperty("fareFamilyDescription")
    public void setFareFamilyDescription(List<FareFamilyDescription> fareFamilyDescription) {
        this.fareFamilyDescription = fareFamilyDescription;
    }

    @JsonProperty("priceDiffrence")
    public String getPriceDiffrence() {
        return priceDiffrence;
    }

    @JsonProperty("priceDiffrence")
    public void setPriceDiffrence(String priceDiffrence) {
        this.priceDiffrence = priceDiffrence;
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
