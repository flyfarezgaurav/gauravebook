
package com.travel.object.review;

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
    "reviewId",
    "userName",
    "userEmail",
    "userPhone",
    "reviewMessage",
    "reviewDate",
    "reviewRating",
    "reviewRpyId",
    "reviewStatus",
    "siteId",
    "reviewUrl"
})
public class Response {

    @JsonProperty("reviewId")
    private Integer reviewId;
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("userEmail")
    private String userEmail;
    @JsonProperty("userPhone")
    private String userPhone;
    @JsonProperty("reviewMessage")
    private String reviewMessage;
    @JsonProperty("reviewDate")
    private Date reviewDate;
    @JsonProperty("reviewRating")
    private String reviewRating;
    @JsonProperty("reviewRpyId")
    private String reviewRpyId;
    @JsonProperty("reviewStatus")
    private String reviewStatus;
    @JsonProperty("siteId")
    private Integer siteId;
    @JsonProperty("reviewUrl")
    private String reviewUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("reviewId")
    public Integer getReviewId() {
        return reviewId;
    }

    @JsonProperty("reviewId")
    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
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

    @JsonProperty("userPhone")
    public String getUserPhone() {
        return userPhone;
    }

    @JsonProperty("userPhone")
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @JsonProperty("reviewMessage")
    public String getReviewMessage() {
        return reviewMessage;
    }

    @JsonProperty("reviewMessage")
    public void setReviewMessage(String reviewMessage) {
        this.reviewMessage = reviewMessage;
    }

    @JsonProperty("reviewDate")
    public Date getReviewDate() {
        return reviewDate;
    }

    @JsonProperty("reviewDate")
    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    @JsonProperty("reviewRating")
    public String getReviewRating() {
        return reviewRating;
    }

    @JsonProperty("reviewRating")
    public void setReviewRating(String reviewRating) {
        this.reviewRating = reviewRating;
    }

    @JsonProperty("reviewRpyId")
    public String getReviewRpyId() {
        return reviewRpyId;
    }

    @JsonProperty("reviewRpyId")
    public void setReviewRpyId(String reviewRpyId) {
        this.reviewRpyId = reviewRpyId;
    }

    @JsonProperty("reviewStatus")
    public String getReviewStatus() {
        return reviewStatus;
    }

    @JsonProperty("reviewStatus")
    public void setReviewStatus(String reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    @JsonProperty("siteId")
    public Integer getSiteId() {
        return siteId;
    }

    @JsonProperty("siteId")
    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    @JsonProperty("reviewUrl")
    public String getReviewUrl() {
        return reviewUrl;
    }

    @JsonProperty("reviewUrl")
    public void setReviewUrl(String reviewUrl) {
        this.reviewUrl = reviewUrl;
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
