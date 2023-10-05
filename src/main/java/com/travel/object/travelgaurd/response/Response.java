
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
    "transactionLog",
    "purchaseRequest",
    "quoteContent",
    "perTravelerPremiumDetails"
})
@Generated("jsonschema2pojo")
public class Response {

    @JsonProperty("transactionLog")
    private TransactionLog transactionLog;
    @JsonProperty("purchaseRequest")
    private PurchaseRequest purchaseRequest;
    @JsonProperty("quoteContent")
    private QuoteContent quoteContent;
    @JsonProperty("perTravelerPremiumDetails")
    private List<PerTravelerPremiumDetail> perTravelerPremiumDetails = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("transactionLog")
    public TransactionLog getTransactionLog() {
        return transactionLog;
    }

    @JsonProperty("transactionLog")
    public void setTransactionLog(TransactionLog transactionLog) {
        this.transactionLog = transactionLog;
    }

    @JsonProperty("purchaseRequest")
    public PurchaseRequest getPurchaseRequest() {
        return purchaseRequest;
    }

    @JsonProperty("purchaseRequest")
    public void setPurchaseRequest(PurchaseRequest purchaseRequest) {
        this.purchaseRequest = purchaseRequest;
    }

    @JsonProperty("quoteContent")
    public QuoteContent getQuoteContent() {
        return quoteContent;
    }

    @JsonProperty("quoteContent")
    public void setQuoteContent(QuoteContent quoteContent) {
        this.quoteContent = quoteContent;
    }

    @JsonProperty("perTravelerPremiumDetails")
    public List<PerTravelerPremiumDetail> getPerTravelerPremiumDetails() {
        return perTravelerPremiumDetails;
    }

    @JsonProperty("perTravelerPremiumDetails")
    public void setPerTravelerPremiumDetails(List<PerTravelerPremiumDetail> perTravelerPremiumDetails) {
        this.perTravelerPremiumDetails = perTravelerPremiumDetails;
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
