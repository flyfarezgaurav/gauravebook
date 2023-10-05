
package com.travel.object.userregister;

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
    "login_id",
    "user_type",
    "user_name",
    "user_email",
    "password",
    "password_value",
    "user_profile_photo",
    "user_permanentCountryId",
    "mobile",
    "referuser_code",
    "login_status",
    "account_status",
    "user_profile_dob",
    "nationality",
    "brand_name",
    "deportment_id",
    "gender",
    "role_id",
    "viewaccess",
    "productType"
})
public class RegisterRequest {

    @JsonProperty("login_id")
    private String loginId;
    @JsonProperty("user_type")
    private Integer userType;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("user_email")
    private String userEmail;
    @JsonProperty("password")
    private String password;
    @JsonProperty("password_value")
    private String passwordValue;
    @JsonProperty("user_profile_photo")
    private String userProfilePhoto;
    @JsonProperty("user_permanentCountryId")
    private Integer userPermanentCountryId;
    @JsonProperty("mobile")
    private String mobile;
    @JsonProperty("referuser_code")
    private String referuserCode;
    @JsonProperty("login_status")
    private String loginStatus;
    @JsonProperty("account_status")
    private String accountStatus;
    @JsonProperty("user_profile_dob")
    private String userProfileDob;
    @JsonProperty("nationality")
    private String nationality;
    @JsonProperty("brand_name")
    private String brandName;
    @JsonProperty("deportment_id")
    private Integer deportmentId;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("role_id")
    private Integer roleId;
    @JsonProperty("viewaccess")
    private String viewaccess;
    @JsonProperty("productType")
    private Integer productType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("login_id")
    public String getLoginId() {
        return loginId;
    }

    @JsonProperty("login_id")
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    @JsonProperty("user_type")
    public Integer getUserType() {
        return userType;
    }

    @JsonProperty("user_type")
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @JsonProperty("user_name")
    public String getUserName() {
        return userName;
    }

    @JsonProperty("user_name")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonProperty("user_email")
    public String getUserEmail() {
        return userEmail;
    }

    @JsonProperty("user_email")
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

    @JsonProperty("password_value")
    public String getPasswordValue() {
        return passwordValue;
    }

    @JsonProperty("password_value")
    public void setPasswordValue(String passwordValue) {
        this.passwordValue = passwordValue;
    }

    @JsonProperty("user_profile_photo")
    public String getUserProfilePhoto() {
        return userProfilePhoto;
    }

    @JsonProperty("user_profile_photo")
    public void setUserProfilePhoto(String userProfilePhoto) {
        this.userProfilePhoto = userProfilePhoto;
    }

    @JsonProperty("user_permanentCountryId")
    public Integer getUserPermanentCountryId() {
        return userPermanentCountryId;
    }

    @JsonProperty("user_permanentCountryId")
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

    @JsonProperty("referuser_code")
    public String getReferuserCode() {
        return referuserCode;
    }

    @JsonProperty("referuser_code")
    public void setReferuserCode(String referuserCode) {
        this.referuserCode = referuserCode;
    }

    @JsonProperty("login_status")
    public String getLoginStatus() {
        return loginStatus;
    }

    @JsonProperty("login_status")
    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    @JsonProperty("account_status")
    public String getAccountStatus() {
        return accountStatus;
    }

    @JsonProperty("account_status")
    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    @JsonProperty("user_profile_dob")
    public String getUserProfileDob() {
        return userProfileDob;
    }

    @JsonProperty("user_profile_dob")
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

    @JsonProperty("brand_name")
    public String getBrandName() {
        return brandName;
    }

    @JsonProperty("brand_name")
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @JsonProperty("deportment_id")
    public Integer getDeportmentId() {
        return deportmentId;
    }

    @JsonProperty("deportment_id")
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

    @JsonProperty("role_id")
    public Integer getRoleId() {
        return roleId;
    }

    @JsonProperty("role_id")
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @JsonProperty("viewaccess")
    public String getViewaccess() {
        return viewaccess;
    }

    @JsonProperty("viewaccess")
    public void setViewaccess(String viewaccess) {
        this.viewaccess = viewaccess;
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
