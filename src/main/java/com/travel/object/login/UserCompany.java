
package com.travel.object.login;

import java.util.Date;
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
    "id",
    "compName",
    "compAddress",
    "compPhone",
    "compLogo",
    "compEmail",
    "compStatus",
    "compCreatedAt"
})
public class UserCompany {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("compName")
    private String compName;
    @JsonProperty("compAddress")
    private String compAddress;
    @JsonProperty("compPhone")
    private String compPhone;
    @JsonProperty("compLogo")
    private String compLogo;
    @JsonProperty("compEmail")
    private String compEmail;
    @JsonProperty("compStatus")
    private String compStatus;
    @JsonProperty("compCreatedAt")
    private Date compCreatedAt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("compName")
    public String getCompName() {
        return compName;
    }

    @JsonProperty("compName")
    public void setCompName(String compName) {
        this.compName = compName;
    }

    @JsonProperty("compAddress")
    public String getCompAddress() {
        return compAddress;
    }

    @JsonProperty("compAddress")
    public void setCompAddress(String compAddress) {
        this.compAddress = compAddress;
    }

    @JsonProperty("compPhone")
    public String getCompPhone() {
        return compPhone;
    }

    @JsonProperty("compPhone")
    public void setCompPhone(String compPhone) {
        this.compPhone = compPhone;
    }

    @JsonProperty("compLogo")
    public String getCompLogo() {
        return compLogo;
    }

    @JsonProperty("compLogo")
    public void setCompLogo(String compLogo) {
        this.compLogo = compLogo;
    }

    @JsonProperty("compEmail")
    public String getCompEmail() {
        return compEmail;
    }

    @JsonProperty("compEmail")
    public void setCompEmail(String compEmail) {
        this.compEmail = compEmail;
    }

    @JsonProperty("compStatus")
    public String getCompStatus() {
        return compStatus;
    }

    @JsonProperty("compStatus")
    public void setCompStatus(String compStatus) {
        this.compStatus = compStatus;
    }

    @JsonProperty("compCreatedAt")
    public Date getCompCreatedAt() {
        return compCreatedAt;
    }

    @JsonProperty("compCreatedAt")
    public void setCompCreatedAt(Date compCreatedAt) {
        this.compCreatedAt = compCreatedAt;
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
