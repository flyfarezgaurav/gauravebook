
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
    "productCode",
    "productName",
    "planCode",
    "planDescription",
    "purchaseDateTime",
    "amounts",
    "referenceNumbers",
    "factors",
    "benefitDetails",
    "tripIdentifiers",
    "travelerIdentifiers",
    "customElements",
    "fromPS"
})
@Generated("jsonschema2pojo")
public class ProductDetail {

    @JsonProperty("productCode")
    private String productCode;
    @JsonProperty("productName")
    private String productName;
    @JsonProperty("planCode")
    private String planCode;
    @JsonProperty("planDescription")
    private String planDescription;
    @JsonProperty("purchaseDateTime")
    private String purchaseDateTime;
    @JsonProperty("amounts")
    private List<Amount> amounts = null;
    @JsonProperty("referenceNumbers")
    private List<Object> referenceNumbers = null;
    @JsonProperty("factors")
    private List<Object> factors = null;
    @JsonProperty("benefitDetails")
    private List<BenefitDetail> benefitDetails = null;
    @JsonProperty("tripIdentifiers")
    private List<TripIdentifier> tripIdentifiers = null;
    @JsonProperty("travelerIdentifiers")
    private List<TravelerIdentifier> travelerIdentifiers = null;
    @JsonProperty("customElements")
    private List<Object> customElements = null;
    @JsonProperty("fromPS")
    private Boolean fromPS;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("productCode")
    public String getProductCode() {
        return productCode;
    }

    @JsonProperty("productCode")
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @JsonProperty("productName")
    public String getProductName() {
        return productName;
    }

    @JsonProperty("productName")
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @JsonProperty("planCode")
    public String getPlanCode() {
        return planCode;
    }

    @JsonProperty("planCode")
    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    @JsonProperty("planDescription")
    public String getPlanDescription() {
        return planDescription;
    }

    @JsonProperty("planDescription")
    public void setPlanDescription(String planDescription) {
        this.planDescription = planDescription;
    }

    @JsonProperty("purchaseDateTime")
    public String getPurchaseDateTime() {
        return purchaseDateTime;
    }

    @JsonProperty("purchaseDateTime")
    public void setPurchaseDateTime(String purchaseDateTime) {
        this.purchaseDateTime = purchaseDateTime;
    }

    @JsonProperty("amounts")
    public List<Amount> getAmounts() {
        return amounts;
    }

    @JsonProperty("amounts")
    public void setAmounts(List<Amount> amounts) {
        this.amounts = amounts;
    }

    @JsonProperty("referenceNumbers")
    public List<Object> getReferenceNumbers() {
        return referenceNumbers;
    }

    @JsonProperty("referenceNumbers")
    public void setReferenceNumbers(List<Object> referenceNumbers) {
        this.referenceNumbers = referenceNumbers;
    }

    @JsonProperty("factors")
    public List<Object> getFactors() {
        return factors;
    }

    @JsonProperty("factors")
    public void setFactors(List<Object> factors) {
        this.factors = factors;
    }

    @JsonProperty("benefitDetails")
    public List<BenefitDetail> getBenefitDetails() {
        return benefitDetails;
    }

    @JsonProperty("benefitDetails")
    public void setBenefitDetails(List<BenefitDetail> benefitDetails) {
        this.benefitDetails = benefitDetails;
    }

    @JsonProperty("tripIdentifiers")
    public List<TripIdentifier> getTripIdentifiers() {
        return tripIdentifiers;
    }

    @JsonProperty("tripIdentifiers")
    public void setTripIdentifiers(List<TripIdentifier> tripIdentifiers) {
        this.tripIdentifiers = tripIdentifiers;
    }

    @JsonProperty("travelerIdentifiers")
    public List<TravelerIdentifier> getTravelerIdentifiers() {
        return travelerIdentifiers;
    }

    @JsonProperty("travelerIdentifiers")
    public void setTravelerIdentifiers(List<TravelerIdentifier> travelerIdentifiers) {
        this.travelerIdentifiers = travelerIdentifiers;
    }

    @JsonProperty("customElements")
    public List<Object> getCustomElements() {
        return customElements;
    }

    @JsonProperty("customElements")
    public void setCustomElements(List<Object> customElements) {
        this.customElements = customElements;
    }

    @JsonProperty("fromPS")
    public Boolean getFromPS() {
        return fromPS;
    }

    @JsonProperty("fromPS")
    public void setFromPS(Boolean fromPS) {
        this.fromPS = fromPS;
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
