
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
    "isoCurrencyCode",
    "amountValues"
})
@Generated("jsonschema2pojo")
public class Amount__1 {

    @JsonProperty("isoCurrencyCode")
    private String isoCurrencyCode;
    @JsonProperty("amountValues")
    private List<AmountValue__1> amountValues = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("isoCurrencyCode")
    public String getIsoCurrencyCode() {
        return isoCurrencyCode;
    }

    @JsonProperty("isoCurrencyCode")
    public void setIsoCurrencyCode(String isoCurrencyCode) {
        this.isoCurrencyCode = isoCurrencyCode;
    }

    @JsonProperty("amountValues")
    public List<AmountValue__1> getAmountValues() {
        return amountValues;
    }

    @JsonProperty("amountValues")
    public void setAmountValues(List<AmountValue__1> amountValues) {
        this.amountValues = amountValues;
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
