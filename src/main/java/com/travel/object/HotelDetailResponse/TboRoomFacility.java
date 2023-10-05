
package com.travel.object.HotelDetailResponse;

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
    "tboId",
    "hotelId",
    "roomid",
    "faciltities",
    "faciltitiesid"
})
public class TboRoomFacility {

    @JsonProperty("tboId")
    private Integer tboId;
    @JsonProperty("hotelId")
    private Integer hotelId;
    @JsonProperty("roomid")
    private Integer roomid;
    @JsonProperty("faciltities")
    private String faciltities;
    @JsonProperty("faciltitiesid")
    private Integer faciltitiesid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("tboId")
    public Integer getTboId() {
        return tboId;
    }

    @JsonProperty("tboId")
    public void setTboId(Integer tboId) {
        this.tboId = tboId;
    }

    @JsonProperty("hotelId")
    public Integer getHotelId() {
        return hotelId;
    }

    @JsonProperty("hotelId")
    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    @JsonProperty("roomid")
    public Integer getRoomid() {
        return roomid;
    }

    @JsonProperty("roomid")
    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    @JsonProperty("faciltities")
    public String getFaciltities() {
        return faciltities;
    }

    @JsonProperty("faciltities")
    public void setFaciltities(String faciltities) {
        this.faciltities = faciltities;
    }

    @JsonProperty("faciltitiesid")
    public Integer getFaciltitiesid() {
        return faciltitiesid;
    }

    @JsonProperty("faciltitiesid")
    public void setFaciltitiesid(Integer faciltitiesid) {
        this.faciltitiesid = faciltitiesid;
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
