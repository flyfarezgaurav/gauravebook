package com.travel.object.flightresponse;

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
    "fareFamilyname",
    "fareFamilyCarrier"
})
public class FareFamilyRef {

	 @JsonProperty("fareFamilyname")
	    private String fareFamilyname;
	    @JsonProperty("fareFamilyCarrier")
	    private String fareFamilyCarrier;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

   
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    @JsonProperty("fareFamilyname")
	public String getFareFamilyname() {
		return fareFamilyname;
	}
    @JsonProperty("fareFamilyname")
	public void setFareFamilyname(String fareFamilyname) {
		this.fareFamilyname = fareFamilyname;
	}
    @JsonProperty("fareFamilyCarrier")
	public String getFareFamilyCarrier() {
		return fareFamilyCarrier;
	}
    @JsonProperty("fareFamilyCarrier")
	public void setFareFamilyCarrier(String fareFamilyCarrier) {
		this.fareFamilyCarrier = fareFamilyCarrier;
	}

}
