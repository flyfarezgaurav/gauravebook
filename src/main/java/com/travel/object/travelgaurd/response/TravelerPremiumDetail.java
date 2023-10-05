
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
    "benefitCode",
    "benefitName",
    "amounts",
    "isStandard"
})
@Generated("jsonschema2pojo")
public class TravelerPremiumDetail {

    @JsonProperty("benefitCode")
    private String benefitCode;
    @JsonProperty("benefitName")
    private String benefitName;
    @JsonProperty("amounts")
    private List<Amount__2> amounts = null;
    @JsonProperty("isStandard")
    private Boolean isStandard;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("benefitCode")
    public String getBenefitCode() {
        return benefitCode;
    }

    @JsonProperty("benefitCode")
    public void setBenefitCode(String benefitCode) {
        this.benefitCode = benefitCode;
    }

    @JsonProperty("benefitName")
    public String getBenefitName() {
        return benefitName;
    }

    @JsonProperty("benefitName")
    public void setBenefitName(String benefitName) {
        this.benefitName = benefitName;
    }

    @JsonProperty("amounts")
    public List<Amount__2> getAmounts() {
        return amounts;
    }

    @JsonProperty("amounts")
    public void setAmounts(List<Amount__2> amounts) {
        this.amounts = amounts;
    }

    @JsonProperty("isStandard")
    public Boolean getIsStandard() {
        return isStandard;
    }

    @JsonProperty("isStandard")
    public void setIsStandard(Boolean isStandard) {
        this.isStandard = isStandard;
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
