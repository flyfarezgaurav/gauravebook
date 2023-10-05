
package com.travel.object.searchRequest;

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
    "originAirport",
    "destinationAirport",
    "travelDate"
})
public class Segment {

    @JsonProperty("originAirport")
    private String originAirport;
    @JsonProperty("destinationAirport")
    private String destinationAirport;
    @JsonProperty("travelDate")
    private String travelDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("originAirport")
    public String getOriginAirport() {
        return originAirport;
    }

    @JsonProperty("originAirport")
    public void setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
    }

    @JsonProperty("destinationAirport")
    public String getDestinationAirport() {
        return destinationAirport;
    }

    @JsonProperty("destinationAirport")
    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    @JsonProperty("travelDate")
    public String getTravelDate() {
        return travelDate;
    }

    @JsonProperty("travelDate")
    public void setTravelDate(String travelDate) {
        this.travelDate = travelDate;
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
