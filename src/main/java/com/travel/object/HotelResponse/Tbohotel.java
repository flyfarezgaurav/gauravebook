
package com.travel.object.HotelResponse;

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
    "hotelBrandId",
    "hotelName",
    "hotelCategoryId",
    "hotelCategoryName",
    "hotelAddress",
    "description",
    "phone",
    "latitude",
    "longitude",
    "city",
    "stateProv",
    "countryName",
    "countryCode",
    "postalCode",
    "facilities",
    "thumbnail",
    "fullImage",
    "hotelUrl",
    "attractions",
    "minPrice"
})
public class Tbohotel {

    @JsonProperty("tboId")
    private Integer tboId;
    @JsonProperty("cityId")
    private Integer cityId;
    @JsonProperty("hotelId")
    private Integer hotelId;
    @JsonProperty("hotelBrandId")
    private Integer hotelBrandId;
    @JsonProperty("hotelName")
    private String hotelName;
    @JsonProperty("hotelCategoryId")
    private String hotelCategoryId;
    @JsonProperty("hotelCategoryName")
    private String hotelCategoryName;
    @JsonProperty("hotelAddress")
    private String hotelAddress;
    @JsonProperty("description")
    private String description;
    @JsonProperty("phone")
    private Object phone;
    @JsonProperty("latitude")
    private String latitude;
    @JsonProperty("longitude")
    private String longitude;
    @JsonProperty("city")
    private String city;
    @JsonProperty("stateProv")
    private String stateProv;
    @JsonProperty("countryName")
    private String countryName;
    @JsonProperty("countryCode")
    private String countryCode;
    @JsonProperty("postalCode")
    private String postalCode;
    @JsonProperty("facilities")
    private String facilities;
    @JsonProperty("thumbnail")
    private String thumbnail;
    @JsonProperty("fullImage")
    private String fullImage;
    @JsonProperty("hotelUrl")
    private String hotelUrl;
    @JsonProperty("attractions")
    private String attractions;
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

    @JsonProperty("hotelBrandId")
    public Integer getHotelBrandId() {
        return hotelBrandId;
    }

    @JsonProperty("hotelBrandId")
    public void setHotelBrandId(Integer hotelBrandId) {
        this.hotelBrandId = hotelBrandId;
    }

    @JsonProperty("hotelName")
    public String getHotelName() {
        return hotelName;
    }

    @JsonProperty("hotelName")
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    @JsonProperty("hotelCategoryId")
    public String getHotelCategoryId() {
        return hotelCategoryId;
    }

    @JsonProperty("hotelCategoryId")
    public void setHotelCategoryId(String hotelCategoryId) {
        this.hotelCategoryId = hotelCategoryId;
    }

    @JsonProperty("hotelCategoryName")
    public String getHotelCategoryName() {
        return hotelCategoryName;
    }

    @JsonProperty("hotelCategoryName")
    public void setHotelCategoryName(String hotelCategoryName) {
        this.hotelCategoryName = hotelCategoryName;
    }

    @JsonProperty("hotelAddress")
    public String getHotelAddress() {
        return hotelAddress;
    }

    @JsonProperty("hotelAddress")
    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("phone")
    public Object getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(Object phone) {
        this.phone = phone;
    }

    @JsonProperty("latitude")
    public String getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("longitude")
    public String getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("stateProv")
    public String getStateProv() {
        return stateProv;
    }

    @JsonProperty("stateProv")
    public void setStateProv(String stateProv) {
        this.stateProv = stateProv;
    }

    @JsonProperty("countryName")
    public String getCountryName() {
        return countryName;
    }

    @JsonProperty("countryName")
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @JsonProperty("countryCode")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("countryCode")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("postalCode")
    public String getPostalCode() {
        return postalCode;
    }

    @JsonProperty("postalCode")
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @JsonProperty("facilities")
    public String getFacilities() {
        return facilities;
    }

    @JsonProperty("facilities")
    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    @JsonProperty("thumbnail")
    public String getThumbnail() {
        return thumbnail;
    }

    @JsonProperty("thumbnail")
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @JsonProperty("fullImage")
    public String getFullImage() {
        return fullImage;
    }

    @JsonProperty("fullImage")
    public void setFullImage(String fullImage) {
        this.fullImage = fullImage;
    }

    @JsonProperty("hotelUrl")
    public String getHotelUrl() {
        return hotelUrl;
    }

    @JsonProperty("hotelUrl")
    public void setHotelUrl(String hotelUrl) {
        this.hotelUrl = hotelUrl;
    }

    @JsonProperty("attractions")
    public String getAttractions() {
        return attractions;
    }

    @JsonProperty("attractions")
    public void setAttractions(String attractions) {
        this.attractions = attractions;
    }

    @JsonProperty("minPrice")
    public Double getMinPrice() {
        return minPrice;
    }

    @JsonProperty("minPrice")
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
