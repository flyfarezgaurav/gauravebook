
package com.travel.object.bookingresponse;

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
    "passengerType",
    "firstName",
    "middleName",
    "lastName",
    "gender",
    "dobDay",
    "dateOfMonth",
    "dateOfYear"
})
public class PassengerDetail {

    @JsonProperty("passengerType")
    private Integer passengerType;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("middleName")
    private String middleName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("gender")
    private Integer gender;
    @JsonProperty("dobDay")
    private String dobDay;
    @JsonProperty("dateOfMonth")
    private String dateOfMonth;
    @JsonProperty("dateOfYear")
    private String dateOfYear;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("passengerType")
    public Integer getPassengerType() {
        return passengerType;
    }

    @JsonProperty("passengerType")
    public void setPassengerType(Integer passengerType) {
        this.passengerType = passengerType;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("middleName")
    public String getMiddleName() {
        return middleName;
    }

    @JsonProperty("middleName")
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("gender")
    public Integer getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @JsonProperty("dobDay")
    public String getDobDay() {
        return dobDay;
    }

    @JsonProperty("dobDay")
    public void setDobDay(String dobDay) {
        this.dobDay = dobDay;
    }

    @JsonProperty("dateOfMonth")
    public String getDateOfMonth() {
        return dateOfMonth;
    }

    @JsonProperty("dateOfMonth")
    public void setDateOfMonth(String dateOfMonth) {
        this.dateOfMonth = dateOfMonth;
    }

    @JsonProperty("dateOfYear")
    public String getDateOfYear() {
        return dateOfYear;
    }

    @JsonProperty("dateOfYear")
    public void setDateOfYear(String dateOfYear) {
        this.dateOfYear = dateOfYear;
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
