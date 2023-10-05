package com.travel.object.bookingrequest.ancillaryServices;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"statusCode",
	"error",
	"message",
	"id",
	"family",
	"subscription"
})

public class AncillaryServices {

    @JsonProperty("statusCode")
    private Integer statusCode;
    @JsonProperty("error")
    private String error;
    @JsonProperty("message")
    private String message;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("supplierCode")
    private String supplierCode;
    @JsonProperty("supplierApi")
    private String supplierApi;
    @JsonProperty("modelType")
    private String modelType;//Multiple Choice or YesNo
    @JsonProperty("priceTypeRoute")
    private String priceTypeRoute;// OW or RT
    @JsonProperty("priceTypePax")
    private String priceTypePax;// Per/Total
    @JsonProperty("fullName")
    private String fullName;
    @JsonProperty("shortName")
    private String shortName;
    @JsonProperty("fareLadderText")
    private String fareLadderText;
 
    @JsonProperty("title")
    private String title;
    @JsonProperty("titleImgLeft")
    private String titleImgLeft;
    @JsonProperty("titleImgRight")
    private String titleImgRight;
    @JsonProperty("subTitle")
    private String subTitle;
    @JsonProperty("description")
    private String description;
    @JsonProperty("bttomDescription")
    private String bttomDescription;
 
    
    //YesNo Model
    @JsonProperty("services")
    private List<Services> services; //Column (as service) or normal bullet points(yes or no Model)
    @JsonProperty("yesMessage")
    private String yesMessage;
    @JsonProperty("noMessage")
    private String noMessage;
    @JsonProperty("yesMessageImg")
    private String yesMessageImg;
    @JsonProperty("noMessageImg")
    private String noMessageImg;
    @JsonProperty("topRightImg")
    private String topRightImg;
    @JsonProperty("bottomRightImg")
    private String bottomRightImg;
    
    
    //Multiple Choice
    @JsonProperty("multiModelType")
    private String multiModelType; //Column or dropDown

    @JsonProperty("owServiceText")
    private List<AncillaryProduct> owServiceText;
    
    
    @JsonProperty("rtServiceText")
    private List<AncillaryProduct> rtServiceText;
    
    @JsonProperty("disclosureslink")
    private String disclosureslink;
    @JsonProperty("disclosuresMessage")
    private String disclosuresMessage;
    @JsonProperty("covidMessage")
    private String covidMessage;
    @JsonProperty("covidLink")
    private String covidLink;
    @JsonProperty("faqLink")
    private String faqLink;
    @JsonProperty("extraMessage")
    private String extraMessage;
    
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSupplierCode() {
		return supplierCode;
	}
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	public String getSupplierApi() {
		return supplierApi;
	}
	public void setSupplierApi(String supplierApi) {
		this.supplierApi = supplierApi;
	}
	public String getModelType() {
		return modelType;
	}
	public void setModelType(String modelType) {
		this.modelType = modelType;
	}
	public String getPriceTypeRoute() {
		return priceTypeRoute;
	}
	public void setPriceTypeRoute(String priceTypeRoute) {
		this.priceTypeRoute = priceTypeRoute;
	}
	public String getPriceTypePax() {
		return priceTypePax;
	}
	public void setPriceTypePax(String priceTypePax) {
		this.priceTypePax = priceTypePax;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getFareLadderText() {
		return fareLadderText;
	}
	public void setFareLadderText(String fareLadderText) {
		this.fareLadderText = fareLadderText;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitleImgLeft() {
		return titleImgLeft;
	}
	public void setTitleImgLeft(String titleImgLeft) {
		this.titleImgLeft = titleImgLeft;
	}
	public String getTitleImgRight() {
		return titleImgRight;
	}
	public void setTitleImgRight(String titleImgRight) {
		this.titleImgRight = titleImgRight;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBttomDescription() {
		return bttomDescription;
	}
	public void setBttomDescription(String bttomDescription) {
		this.bttomDescription = bttomDescription;
	}
	public List<Services> getServices() {
		return services;
	}
	public void setServices(List<Services> services) {
		this.services = services;
	}
	public String getYesMessage() {
		return yesMessage;
	}
	public void setYesMessage(String yesMessage) {
		this.yesMessage = yesMessage;
	}
	public String getNoMessage() {
		return noMessage;
	}
	public void setNoMessage(String noMessage) {
		this.noMessage = noMessage;
	}
	public String getYesMessageImg() {
		return yesMessageImg;
	}
	public void setYesMessageImg(String yesMessageImg) {
		this.yesMessageImg = yesMessageImg;
	}
	public String getNoMessageImg() {
		return noMessageImg;
	}
	public void setNoMessageImg(String noMessageImg) {
		this.noMessageImg = noMessageImg;
	}
	public String getTopRightImg() {
		return topRightImg;
	}
	public void setTopRightImg(String topRightImg) {
		this.topRightImg = topRightImg;
	}
	public String getBottomRightImg() {
		return bottomRightImg;
	}
	public void setBottomRightImg(String bottomRightImg) {
		this.bottomRightImg = bottomRightImg;
	}
	public String getMultiModelType() {
		return multiModelType;
	}
	public void setMultiModelType(String multiModelType) {
		this.multiModelType = multiModelType;
	}
	public List<AncillaryProduct> getOwServiceText() {
		return owServiceText;
	}
	public void setOwServiceText(List<AncillaryProduct> owServiceText) {
		this.owServiceText = owServiceText;
	}
	public List<AncillaryProduct> getRtServiceText() {
		return rtServiceText;
	}
	public void setRtServiceText(List<AncillaryProduct> rtServiceText) {
		this.rtServiceText = rtServiceText;
	}
	public String getDisclosureslink() {
		return disclosureslink;
	}
	public void setDisclosureslink(String disclosureslink) {
		this.disclosureslink = disclosureslink;
	}
	public String getDisclosuresMessage() {
		return disclosuresMessage;
	}
	public void setDisclosuresMessage(String disclosuresMessage) {
		this.disclosuresMessage = disclosuresMessage;
	}
	public String getCovidMessage() {
		return covidMessage;
	}
	public void setCovidMessage(String covidMessage) {
		this.covidMessage = covidMessage;
	}
	public String getCovidLink() {
		return covidLink;
	}
	public void setCovidLink(String covidLink) {
		this.covidLink = covidLink;
	}
	public String getFaqLink() {
		return faqLink;
	}
	public void setFaqLink(String faqLink) {
		this.faqLink = faqLink;
	}
	public String getExtraMessage() {
		return extraMessage;
	}
	public void setExtraMessage(String extraMessage) {
		this.extraMessage = extraMessage;
	}
    
    
    
}