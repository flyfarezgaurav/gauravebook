
package com.travel.object.HotelBookingRequest;

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
    "travelerNo",
    "passengerType"
})
public class PassengerDetail {

    @JsonProperty("travelerNo")
    private Integer travelerNo;
    @JsonProperty("passengerType")
    private Integer passengerType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("travelerNo")
    public Integer getTravelerNo() {
        return travelerNo;
    }

    @JsonProperty("travelerNo")
    public void setTravelerNo(Integer travelerNo) {
        this.travelerNo = travelerNo;
    }

    @JsonProperty("passengerType")
    public Integer getPassengerType() {
        return passengerType;
    }

    @JsonProperty("passengerType")
    public void setPassengerType(Integer passengerType) {
        this.passengerType = passengerType;
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
