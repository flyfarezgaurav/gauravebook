
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
    "bedname",
    "bedid"
})
public class TboRoomBedType {

    @JsonProperty("tboId")
    private Integer tboId;
    @JsonProperty("hotelId")
    private Integer hotelId;
    @JsonProperty("roomid")
    private Integer roomid;
    @JsonProperty("bedname")
    private String bedname;
    @JsonProperty("bedid")
    private Integer bedid;
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

    @JsonProperty("bedname")
    public String getBedname() {
        return bedname;
    }

    @JsonProperty("bedname")
    public void setBedname(String bedname) {
        this.bedname = bedname;
    }

    @JsonProperty("bedid")
    public Integer getBedid() {
        return bedid;
    }

    @JsonProperty("bedid")
    public void setBedid(Integer bedid) {
        this.bedid = bedid;
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
