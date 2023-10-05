
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
    "accountCode",
    "organizationId",
    "accountId"
})
@Generated("jsonschema2pojo")
public class AccountDetail {

    @JsonProperty("accountCode")
    private String accountCode;
    @JsonProperty("organizationId")
    private Integer organizationId;
    @JsonProperty("accountId")
    private Integer accountId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("accountCode")
    public String getAccountCode() {
        return accountCode;
    }

    @JsonProperty("accountCode")
    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    @JsonProperty("organizationId")
    public Integer getOrganizationId() {
        return organizationId;
    }

    @JsonProperty("organizationId")
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    @JsonProperty("accountId")
    public Integer getAccountId() {
        return accountId;
    }

    @JsonProperty("accountId")
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
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
