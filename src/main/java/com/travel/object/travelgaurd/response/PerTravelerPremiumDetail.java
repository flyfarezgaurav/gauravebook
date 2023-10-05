
package com.travel.object.travelgaurd.response;

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
    "travelerIdentifier",
    "travelerPremiumDetails"
})
@Generated("jsonschema2pojo")
public class PerTravelerPremiumDetail {

    @JsonProperty("travelerIdentifier")
    private String travelerIdentifier;
    @JsonProperty("travelerPremiumDetails")
    private List<TravelerPremiumDetail> travelerPremiumDetails = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("travelerIdentifier")
    public String getTravelerIdentifier() {
        return travelerIdentifier;
    }

    @JsonProperty("travelerIdentifier")
    public void setTravelerIdentifier(String travelerIdentifier) {
        this.travelerIdentifier = travelerIdentifier;
    }

    @JsonProperty("travelerPremiumDetails")
    public List<TravelerPremiumDetail> getTravelerPremiumDetails() {
        return travelerPremiumDetails;
    }

    @JsonProperty("travelerPremiumDetails")
    public void setTravelerPremiumDetails(List<TravelerPremiumDetail> travelerPremiumDetails) {
        this.travelerPremiumDetails = travelerPremiumDetails;
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
