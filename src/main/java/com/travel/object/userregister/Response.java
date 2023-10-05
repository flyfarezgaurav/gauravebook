
package com.travel.object.userregister;

import java.util.Date;
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
    "userId",
    "loginid",
    "userRegistrationId",
    "userType",
    "registrationDate",
    "userName",
    "userEmail",
    "password",
    "passwordValue",
    "userProfilePhoto",
    "userPermanentCountryId",
    "mobile",
    "referuserCode",
    "parentId",
    "loginStatus",
    "accountStatus",
    "userProfileDob",
    "nationality",
    "brandName",
    "deportmentId",
    "gender",
    "productType"
})
public class Response {

    @JsonProperty("userId")
    private Integer userId;
    @JsonProperty("loginid")
    private String loginid;
    @JsonProperty("userRegistrationId")
    private String userRegistrationId;
    @JsonProperty("userType")
    private Integer userType;
    @JsonProperty("registrationDate")
    private Date registrationDate;
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("userEmail")
    private String userEmail;
    @JsonProperty("password")
    private String password;
    @JsonProperty("passwordValue")
    private String passwordValue;
    @JsonProperty("userProfilePhoto")
    private String userProfilePhoto;
    @JsonProperty("userPermanentCountryId")
    private Integer userPermanentCountryId;
    @JsonProperty("mobile")
    private String mobile;
    @JsonProperty("referuserCode")
    private String referuserCode;
    @JsonProperty("parentId")
    private String parentId;
    @JsonProperty("loginStatus")
    private String loginStatus;
    @JsonProperty("accountStatus")
    private String accountStatus;
    @JsonProperty("userProfileDob")
    private String userProfileDob;
    @JsonProperty("nationality")
    private String nationality;
    @JsonProperty("brandName")
    private String brandName;
    @JsonProperty("deportmentId")
    private Integer deportmentId;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("productType")
    private Integer productType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("userId")
    public Integer getUserId() {
        return userId;
    }

    @JsonProperty("userId")
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @JsonProperty("loginid")
    public String getLoginid() {
        return loginid;
    }

    @JsonProperty("loginid")
    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    @JsonProperty("userRegistrationId")
    public String getUserRegistrationId() {
        return userRegistrationId;
    }

    @JsonProperty("userRegistrationId")
    public void setUserRegistrationId(String userRegistrationId) {
        this.userRegistrationId = userRegistrationId;
    }

    @JsonProperty("userType")
    public Integer getUserType() {
        return userType;
    }

    @JsonProperty("userType")
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @JsonProperty("registrationDate")
    public Date getRegistrationDate() {
        return registrationDate;
    }

    @JsonProperty("registrationDate")
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @JsonProperty("userName")
    public String getUserName() {
        return userName;
    }

    @JsonProperty("userName")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonProperty("userEmail")
    public String getUserEmail() {
        return userEmail;
    }

    @JsonProperty("userEmail")
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("passwordValue")
    public String getPasswordValue() {
        return passwordValue;
    }

    @JsonProperty("passwordValue")
    public void setPasswordValue(String passwordValue) {
        this.passwordValue = passwordValue;
    }

    @JsonProperty("userProfilePhoto")
    public String getUserProfilePhoto() {
        return userProfilePhoto;
    }

    @JsonProperty("userProfilePhoto")
    public void setUserProfilePhoto(String userProfilePhoto) {
        this.userProfilePhoto = userProfilePhoto;
    }

    @JsonProperty("userPermanentCountryId")
    public Integer getUserPermanentCountryId() {
        return userPermanentCountryId;
    }

    @JsonProperty("userPermanentCountryId")
    public void setUserPermanentCountryId(Integer userPermanentCountryId) {
        this.userPermanentCountryId = userPermanentCountryId;
    }

    @JsonProperty("mobile")
    public String getMobile() {
        return mobile;
    }

    @JsonProperty("mobile")
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @JsonProperty("referuserCode")
    public String getReferuserCode() {
        return referuserCode;
    }

    @JsonProperty("referuserCode")
    public void setReferuserCode(String referuserCode) {
        this.referuserCode = referuserCode;
    }

    @JsonProperty("parentId")
    public String getParentId() {
        return parentId;
    }

    @JsonProperty("parentId")
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @JsonProperty("loginStatus")
    public String getLoginStatus() {
        return loginStatus;
    }

    @JsonProperty("loginStatus")
    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    @JsonProperty("accountStatus")
    public String getAccountStatus() {
        return accountStatus;
    }

    @JsonProperty("accountStatus")
    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    @JsonProperty("userProfileDob")
    public String getUserProfileDob() {
        return userProfileDob;
    }

    @JsonProperty("userProfileDob")
    public void setUserProfileDob(String userProfileDob) {
        this.userProfileDob = userProfileDob;
    }

    @JsonProperty("nationality")
    public String getNationality() {
        return nationality;
    }

    @JsonProperty("nationality")
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @JsonProperty("brandName")
    public String getBrandName() {
        return brandName;
    }

    @JsonProperty("brandName")
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @JsonProperty("deportmentId")
    public Integer getDeportmentId() {
        return deportmentId;
    }

    @JsonProperty("deportmentId")
    public void setDeportmentId(Integer deportmentId) {
        this.deportmentId = deportmentId;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("productType")
    public Integer getProductType() {
        return productType;
    }

    @JsonProperty("productType")
    public void setProductType(Integer productType) {
        this.productType = productType;
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
