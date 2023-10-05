
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
    "factors",
    "isStandard",
    "bundle",
    "coverageType"
})
@Generated("jsonschema2pojo")
public class BenefitDetail {

    @JsonProperty("benefitCode")
    private String benefitCode;
    @JsonProperty("benefitName")
    private String benefitName;
    @JsonProperty("amounts")
    private List<Amount__1> amounts = null;
    @JsonProperty("factors")
    private List<Object> factors = null;
    @JsonProperty("isStandard")
    private Boolean isStandard;
    @JsonProperty("bundle")
    private Boolean bundle;
    @JsonProperty("coverageType")
    private Object coverageType;
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
    public List<Amount__1> getAmounts() {
        return amounts;
    }

    @JsonProperty("amounts")
    public void setAmounts(List<Amount__1> amounts) {
        this.amounts = amounts;
    }

    @JsonProperty("factors")
    public List<Object> getFactors() {
        return factors;
    }

    @JsonProperty("factors")
    public void setFactors(List<Object> factors) {
        this.factors = factors;
    }

    @JsonProperty("isStandard")
    public Boolean getIsStandard() {
        return isStandard;
    }

    @JsonProperty("isStandard")
    public void setIsStandard(Boolean isStandard) {
        this.isStandard = isStandard;
    }

    @JsonProperty("bundle")
    public Boolean getBundle() {
        return bundle;
    }

    @JsonProperty("bundle")
    public void setBundle(Boolean bundle) {
        this.bundle = bundle;
    }

    @JsonProperty("coverageType")
    public Object getCoverageType() {
        return coverageType;
    }

    @JsonProperty("coverageType")
    public void setCoverageType(Object coverageType) {
        this.coverageType = coverageType;
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
