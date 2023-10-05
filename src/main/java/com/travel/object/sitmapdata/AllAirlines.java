
package com.travel.object.sitmapdata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "baseResponse",
    "response"
})
public class AllAirlines {

    @JsonProperty("baseResponse")
    private BaseResponse baseResponse;
    @JsonProperty("response")
    private List<Response> response = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("baseResponse")
    public BaseResponse getBaseResponse() {
        return baseResponse;
    }

    @JsonProperty("baseResponse")
    public void setBaseResponse(BaseResponse baseResponse) {
        this.baseResponse = baseResponse;
    }

    @JsonProperty("response")
    public List<Response> getResponse() {
        return response;
    }

    @JsonProperty("response")
    public void setResponse(List<Response> response) {
        this.response = response;
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
