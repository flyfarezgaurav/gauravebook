
package com.travel.object.HotelDetailResponse;

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
    "tbohotelRoom",
    "tboRoomBedType",
    "tboRoomFacility",
    "tboRoomImages"
})
public class Response {

    @JsonProperty("tbohotelRoom")
    private List<TbohotelRoom> tbohotelRoom = null;
    @JsonProperty("tboRoomBedType")
    private List<TboRoomBedType> tboRoomBedType = null;
    @JsonProperty("tboRoomFacility")
    private List<TboRoomFacility> tboRoomFacility = null;
    @JsonProperty("tboRoomImages")
    private List<TboRoomImage> tboRoomImages = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("tbohotelRoom")
    public List<TbohotelRoom> getTbohotelRoom() {
        return tbohotelRoom;
    }

    @JsonProperty("tbohotelRoom")
    public void setTbohotelRoom(List<TbohotelRoom> tbohotelRoom) {
        this.tbohotelRoom = tbohotelRoom;
    }

    @JsonProperty("tboRoomBedType")
    public List<TboRoomBedType> getTboRoomBedType() {
        return tboRoomBedType;
    }

    @JsonProperty("tboRoomBedType")
    public void setTboRoomBedType(List<TboRoomBedType> tboRoomBedType) {
        this.tboRoomBedType = tboRoomBedType;
    }

    @JsonProperty("tboRoomFacility")
    public List<TboRoomFacility> getTboRoomFacility() {
        return tboRoomFacility;
    }

    @JsonProperty("tboRoomFacility")
    public void setTboRoomFacility(List<TboRoomFacility> tboRoomFacility) {
        this.tboRoomFacility = tboRoomFacility;
    }

    @JsonProperty("tboRoomImages")
    public List<TboRoomImage> getTboRoomImages() {
        return tboRoomImages;
    }

    @JsonProperty("tboRoomImages")
    public void setTboRoomImages(List<TboRoomImage> tboRoomImages) {
        this.tboRoomImages = tboRoomImages;
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
