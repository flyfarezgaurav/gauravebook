
package com.travel.object;

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
    "ccInfoId", 
    "bookingId", 
    "cardNum",
    "expMonth",
    "expYear",
    "ccvNo",
    "paxFNname",
    "paxLName",
    "strAddres",
    "city",
    "country",
    "state",
    "zip",
    "phoneNo",
    "ccDate",
    "froDate",
    "toDate",
})
@Generated("jsonschema2pojo")
public class CcInfoRequest {

    @JsonProperty("ccInfoId")
    private Integer ccInfoId;
    @JsonProperty("bookingId")
    private String bookingId;
    @JsonProperty("cardNum")
    private String cardNum;
    @JsonProperty("expMonth")
    private String expMonth;
    @JsonProperty("expYear")
    private String expYear;
    @JsonProperty("ccvNo")
    private String ccvNo;
    @JsonProperty("paxFNname")
    private String paxFNname;
    @JsonProperty("paxLName")
    private String paxLName;
    @JsonProperty("strAddres")
    private String strAddres;
    @JsonProperty("city")
    private String city;
    @JsonProperty("country")
    private String country;
    @JsonProperty("state")
    private String state;
    @JsonProperty("zip")
    private String zip;
    @JsonProperty("phoneNo")
    private String phoneNo;
    @JsonProperty("ccDate")
    private String ccDate;
	@JsonProperty("froDate")
	private String froDate;
	@JsonProperty("toDate")
	private String toDate;
	
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("ccInfoId")
    public Integer getCcInfoId() {
        return ccInfoId;
    }

    @JsonProperty("ccInfoId")
    public void setCcInfoId(Integer ccInfoId) {
        this.ccInfoId = ccInfoId;
    }

    @JsonProperty("bookingId")
    public String getBookingId() {
        return bookingId;
    }

    @JsonProperty("bookingId")
    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    @JsonProperty("cardNum")
    public String getCardNum() {
        return cardNum;
    }

    @JsonProperty("cardNum")
    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    @JsonProperty("expMonth")
    public String getExpMonth() {
        return expMonth;
    }
    
    @JsonProperty("expMonth")
    public void setExpMonth(String expMonth) {
        this.expMonth = expMonth;
    }
    
    @JsonProperty("expYear")
    public String getExpYear() {
		return expYear;
	}

    @JsonProperty("expYear")
	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}
 
    @JsonProperty("ccvNo")
    public String getCcvNo() {
        return ccvNo;
    }

    @JsonProperty("ccvNo")
    public void setCcvNo(String ccvNo) {
        this.ccvNo = ccvNo;
    }

    @JsonProperty("paxFNname")
    public String getPaxFNname() {
        return paxFNname;
    }

    @JsonProperty("paxFNname")
    public void setPaxFNname(String paxFNname) {
        this.paxFNname = paxFNname;
    }

    @JsonProperty("paxLName")
    public String getPaxLName() {
        return paxLName;
    }

    @JsonProperty("paxLName")
    public void setPaxLName(String paxLName) {
        this.paxLName = paxLName;
    }

    @JsonProperty("strAddres")
    public String getStrAddres() {
        return strAddres;
    }

    @JsonProperty("strAddres")
    public void setStrAddres(String strAddres) {
        this.strAddres = strAddres;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("zip")
    public String getZip() {
        return zip;
    }

    @JsonProperty("zip")
    public void setZip(String zip) {
        this.zip = zip;
    }

    @JsonProperty("phoneNo")
    public String getPhoneNo() {
        return phoneNo;
    }

    @JsonProperty("phoneNo")
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @JsonProperty("ccDate")
    public String getCcDate() {
        return ccDate;
    }

    @JsonProperty("ccDate")
    public void setCcDate(String ccDate) {
        this.ccDate = ccDate;
    }
    
    @JsonProperty("froDate")
	public String getFroDate() {
		return froDate;
	}
    
	@JsonProperty("froDate")
	public void setFroDate(String froDate) {
		this.froDate = froDate;
	}
	
	@JsonProperty("toDate")
	public String getToDate() {
		return toDate;
	}
	
	@JsonProperty("toDate")
	public void setToDate(String toDate) {
		this.toDate = toDate;
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
