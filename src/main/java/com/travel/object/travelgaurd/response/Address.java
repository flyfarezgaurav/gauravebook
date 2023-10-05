
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
    "type",
    "isoStateOrProvince",
    "isoCountry"
})
@Generated("jsonschema2pojo")
public class Address {

    @JsonProperty("type")
    private String type;
    @JsonProperty("isoStateOrProvince")
    private String isoStateOrProvince;
    @JsonProperty("isoCountry")
    private String isoCountry;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("isoStateOrProvince")
    public String getIsoStateOrProvince() {
        return isoStateOrProvince;
    }

    @JsonProperty("isoStateOrProvince")
    public void setIsoStateOrProvince(String isoStateOrProvince) {
        this.isoStateOrProvince = isoStateOrProvince;
    }

    @JsonProperty("isoCountry")
    public String getIsoCountry() {
        return isoCountry;
    }

    @JsonProperty("isoCountry")
    public void setIsoCountry(String isoCountry) {
        this.isoCountry = isoCountry;
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
