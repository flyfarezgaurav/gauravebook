
package com.travel.object.login;

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
    "user_id",
    "user_name",
    "user_email",
    "mobile",
    "parent_id",
    "brand_name",
    "deportment_id",
    "role_id",
    "roleName",
    "view_list",
    "user_company",
    "productType",
    "listBkg",
    "listBill",
    "listTkt"
})
public class Response {

    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("user_email")
    private String userEmail;
    @JsonProperty("mobile")
    private String mobile;
    @JsonProperty("parent_id")
    private String parentId;
    @JsonProperty("brand_name")
    private String brandName;
    @JsonProperty("deportment_id")
    private Integer deportmentId;
    @JsonProperty("role_id")
    private Integer roleId;
    @JsonProperty("roleName")
    private String roleName;
    @JsonProperty("view_list")
    private List<ViewList> viewList = null;
    @JsonProperty("user_company")
    private List<UserCompany> userCompany = null;
    @JsonProperty("productType")
    private Integer productType;
    @JsonProperty("listBkg")
    private List<Object> listBkg = null;
    @JsonProperty("listBill")
    private List<Object> listBill = null;
    @JsonProperty("listTkt")
    private List<Object> listTkt = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("user_id")
    public Integer getUserId() {
        return userId;
    }

    @JsonProperty("user_id")
    public void setUserId(Integer userId) {
        this.userId = userId;
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

    @JsonProperty("mobile")
    public String getMobile() {
        return mobile;
    }

    @JsonProperty("mobile")
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @JsonProperty("parent_id")
    public String getParentId() {
        return parentId;
    }

    @JsonProperty("parent_id")
    public void setParentId(String parentId) {
        this.parentId = parentId;
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

    @JsonProperty("role_id")
    public Integer getRoleId() {
        return roleId;
    }

    @JsonProperty("role_id")
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @JsonProperty("roleName")
    public String getRoleName() {
        return roleName;
    }

    @JsonProperty("roleName")
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @JsonProperty("view_list")
    public List<ViewList> getViewList() {
        return viewList;
    }

    @JsonProperty("view_list")
    public void setViewList(List<ViewList> viewList) {
        this.viewList = viewList;
    }

    @JsonProperty("user_company")
    public List<UserCompany> getUserCompany() {
        return userCompany;
    }

    @JsonProperty("user_company")
    public void setUserCompany(List<UserCompany> userCompany) {
        this.userCompany = userCompany;
    }

    @JsonProperty("productType")
    public Integer getProductType() {
        return productType;
    }

    @JsonProperty("productType")
    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    @JsonProperty("listBkg")
    public List<Object> getListBkg() {
        return listBkg;
    }

    @JsonProperty("listBkg")
    public void setListBkg(List<Object> listBkg) {
        this.listBkg = listBkg;
    }

    @JsonProperty("listBill")
    public List<Object> getListBill() {
        return listBill;
    }

    @JsonProperty("listBill")
    public void setListBill(List<Object> listBill) {
        this.listBill = listBill;
    }

    @JsonProperty("listTkt")
    public List<Object> getListTkt() {
        return listTkt;
    }

    @JsonProperty("listTkt")
    public void setListTkt(List<Object> listTkt) {
        this.listTkt = listTkt;
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
