
package com.travel.object.currency;

import java.util.LinkedHashMap;
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
    "id",
    "usdRate",
    "usd_gbp",
    "usd_eur",
    "usd_cad",
    "usd_mxn",
    "usd_aud",
    "usd_inr",
    "modifiedOn"
})
@Generated("jsonschema2pojo")
public class Response {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("usdRate")
    private String usdRate;
    @JsonProperty("usd_gbp")
    private String usdGbp;
    @JsonProperty("usd_eur")
    private String usdEur;
    @JsonProperty("usd_cad")
    private String usdCad;
    @JsonProperty("usd_mxn")
    private String usdMxn;
    @JsonProperty("usd_aud")
    private String usdAud;
    @JsonProperty("usd_inr")
    private String usdInr;
    @JsonProperty("modifiedOn")
    private String modifiedOn;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("usdRate")
    public String getUsdRate() {
        return usdRate;
    }

    @JsonProperty("usdRate")
    public void setUsdRate(String usdRate) {
        this.usdRate = usdRate;
    }

    @JsonProperty("usd_gbp")
    public String getUsdGbp() {
        return usdGbp;
    }

    @JsonProperty("usd_gbp")
    public void setUsdGbp(String usdGbp) {
        this.usdGbp = usdGbp;
    }

    @JsonProperty("usd_eur")
    public String getUsdEur() {
        return usdEur;
    }

    @JsonProperty("usd_eur")
    public void setUsdEur(String usdEur) {
        this.usdEur = usdEur;
    }

    @JsonProperty("usd_cad")
    public String getUsdCad() {
        return usdCad;
    }

    @JsonProperty("usd_cad")
    public void setUsdCad(String usdCad) {
        this.usdCad = usdCad;
    }

    @JsonProperty("usd_mxn")
    public String getUsdMxn() {
        return usdMxn;
    }

    @JsonProperty("usd_mxn")
    public void setUsdMxn(String usdMxn) {
        this.usdMxn = usdMxn;
    }

    @JsonProperty("usd_aud")
    public String getUsdAud() {
        return usdAud;
    }

    @JsonProperty("usd_aud")
    public void setUsdAud(String usdAud) {
        this.usdAud = usdAud;
    }

    @JsonProperty("usd_inr")
    public String getUsdInr() {
        return usdInr;
    }

    @JsonProperty("usd_inr")
    public void setUsdInr(String usdInr) {
        this.usdInr = usdInr;
    }

    @JsonProperty("modifiedOn")
    public String getModifiedOn() {
        return modifiedOn;
    }

    @JsonProperty("modifiedOn")
    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
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
