
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
    "cardDetails",
    "rewardDetails",
    "billingFrequency"
})
@Generated("jsonschema2pojo")
public class PaymentDetail {

    @JsonProperty("cardDetails")
    private List<Object> cardDetails = null;
    @JsonProperty("rewardDetails")
    private List<Object> rewardDetails = null;
    @JsonProperty("billingFrequency")
    private Object billingFrequency;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("cardDetails")
    public List<Object> getCardDetails() {
        return cardDetails;
    }

    @JsonProperty("cardDetails")
    public void setCardDetails(List<Object> cardDetails) {
        this.cardDetails = cardDetails;
    }

    @JsonProperty("rewardDetails")
    public List<Object> getRewardDetails() {
        return rewardDetails;
    }

    @JsonProperty("rewardDetails")
    public void setRewardDetails(List<Object> rewardDetails) {
        this.rewardDetails = rewardDetails;
    }

    @JsonProperty("billingFrequency")
    public Object getBillingFrequency() {
        return billingFrequency;
    }

    @JsonProperty("billingFrequency")
    public void setBillingFrequency(Object billingFrequency) {
        this.billingFrequency = billingFrequency;
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
