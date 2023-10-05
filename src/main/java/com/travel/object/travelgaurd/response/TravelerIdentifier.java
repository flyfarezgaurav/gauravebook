
package com.travel.object.travelgaurd.response;

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
    "travelerIdentifier",
    "insuredType"
})
@Generated("jsonschema2pojo")
public class TravelerIdentifier {

    @JsonProperty("travelerIdentifier")
    private String travelerIdentifier;
    @JsonProperty("insuredType")
    private String insuredType;
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

    @JsonProperty("insuredType")
    public String getInsuredType() {
        return insuredType;
    }

    @JsonProperty("insuredType")
    public void setInsuredType(String insuredType) {
        this.insuredType = insuredType;
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
