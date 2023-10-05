
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
    "cityId",
    "hotelId",
    "roomid",
    "roomname",
    "description",
    "minPrice"
})
public class TbohotelRoom {

    @JsonProperty("tboId")
    private Integer tboId;
    @JsonProperty("cityId")
    private Integer cityId;
    @JsonProperty("hotelId")
    private Integer hotelId;
    @JsonProperty("roomid")
    private Integer roomid;
    @JsonProperty("roomname")
    private String roomname;
    @JsonProperty("description")
    private String description;
    @JsonProperty("minPrice")
    private Double minPrice;
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

    @JsonProperty("cityId")
    public Integer getCityId() {
        return cityId;
    }

    @JsonProperty("cityId")
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
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

    @JsonProperty("roomname")
    public String getRoomname() {
        return roomname;
    }

    @JsonProperty("roomname")
    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }
    
    
    public Double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
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
