
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
    "imageurl",
    "imageid"
})
public class TboRoomImage {

    @JsonProperty("tboId")
    private Integer tboId;
    @JsonProperty("hotelId")
    private Integer hotelId;
    @JsonProperty("roomid")
    private Integer roomid;
    @JsonProperty("imageurl")
    private String imageurl;
    @JsonProperty("imageid")
    private String imageid;
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

    @JsonProperty("imageurl")
    public String getImageurl() {
        return imageurl;
    }

    @JsonProperty("imageurl")
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    @JsonProperty("imageid")
    public String getImageid() {
        return imageid;
    }

    @JsonProperty("imageid")
    public void setImageid(String imageid) {
        this.imageid = imageid;
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
