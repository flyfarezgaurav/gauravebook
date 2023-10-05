
package com.travel.object.pageresponse;

import java.util.Date;
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
    "contentId",
    "pageType",
    "pageValue",
    "pageName",
    "metaTitle",
    "metaKeyword",
    "metaDesc",
    "otherMeta",
    "dealCode",
    "dealTitle",
    "contentTitle",
    "contentData", 
    "contentImage",
    "siteId",
    "status",
    "count",
    "url",
    "modifyBy",
    "modifyDate",
    "airportHub",
    "headQuarters",
    "popularRoutes",
    "popularDest",
    "travelTrends",
    "onboardService",
    "premierClass",
    "clubPremier",
    "cityairline",
    "routes",
    "airportList",
    "tfnNo",
    "tfnNo_pop"
})
public class Response {

    @JsonProperty("contentId")
    private Integer contentId;
    @JsonProperty("pageType")
    private String pageType;
    @JsonProperty("pageValue")
    private String pageValue;
    @JsonProperty("pageName")
    private String pageName;
    @JsonProperty("metaTitle")
    private String metaTitle;
    @JsonProperty("metaKeyword")
    private String metaKeyword;
    @JsonProperty("metaDesc")
    private String metaDesc;
    @JsonProperty("otherMeta")
    private String otherMeta;
    @JsonProperty("dealCode")
    private String dealCode;
    @JsonProperty("dealTitle")
    private String dealTitle;
    @JsonProperty("contentTitle")
    private String contentTitle;
    @JsonProperty("contentData")
    private String contentData;
    @JsonProperty("contentImage")
    private String contentImage;
    @JsonProperty("siteId")
    private String siteId;
    @JsonProperty("status")
    private String status;
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("url")
    private String url;
    @JsonProperty("modifyBy")
    private String modifyBy;
    @JsonProperty("modifyDate")
    private Date modifyDate;
    @JsonProperty("airportHub")
    private String airportHub;
    @JsonProperty("headQuarters")
    private String headQuarters;
    @JsonProperty("popularRoutes")
    private String popularRoutes;
    @JsonProperty("popularDest")
    private String popularDest;
    @JsonProperty("travelTrends")
    private String travelTrends;
    @JsonProperty("onboardService")
    private String onboardService;
    @JsonProperty("premierClass")
    private String premierClass;
    @JsonProperty("clubPremier")
    private String clubPremier;
    @JsonProperty("cityairline")
    private List<Object> cityairline = null;
    @JsonProperty("routes")
    private List<Object> routes = null;
    @JsonProperty("airportList")
    private List<Object> airportList = null;
    @JsonProperty("tfnNo")
    private String tfnNo;
    @JsonProperty("tfnNo_pop")
    private String tfnNo_pop;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("contentId")
    public Integer getContentId() {
        return contentId;
    }

    @JsonProperty("contentId")
    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    @JsonProperty("pageType")
    public String getPageType() {
        return pageType;
    }

    @JsonProperty("pageType")
    public void setPageType(String pageType) {
        this.pageType = pageType;
    }

    @JsonProperty("pageValue")
    public String getPageValue() {
        return pageValue;
    }

    @JsonProperty("pageValue")
    public void setPageValue(String pageValue) {
        this.pageValue = pageValue;
    }

    @JsonProperty("pageName")
    public String getPageName() {
        return pageName;
    }

    @JsonProperty("pageName")
    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    @JsonProperty("metaTitle")
    public String getMetaTitle() {
        return metaTitle;
    }

    @JsonProperty("metaTitle")
    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    @JsonProperty("metaKeyword")
    public String getMetaKeyword() {
        return metaKeyword;
    }

    @JsonProperty("metaKeyword")
    public void setMetaKeyword(String metaKeyword) {
        this.metaKeyword = metaKeyword;
    }

    @JsonProperty("metaDesc")
    public String getMetaDesc() {
        return metaDesc;
    }

    @JsonProperty("metaDesc")
    public void setMetaDesc(String metaDesc) {
        this.metaDesc = metaDesc;
    }

    @JsonProperty("otherMeta")
    public String getOtherMeta() {
        return otherMeta;
    }

    @JsonProperty("otherMeta")
    public void setOtherMeta(String otherMeta) {
        this.otherMeta = otherMeta;
    }

    @JsonProperty("dealCode")
    public String getDealCode() {
        return dealCode;
    }

    @JsonProperty("dealCode")
    public void setDealCode(String dealCode) {
        this.dealCode = dealCode;
    }

    @JsonProperty("dealTitle")
    public String getDealTitle() {
        return dealTitle;
    }

    @JsonProperty("dealTitle")
    public void setDealTitle(String dealTitle) {
        this.dealTitle = dealTitle;
    }

    @JsonProperty("contentTitle")
    public String getContentTitle() {
        return contentTitle;
    }

    @JsonProperty("contentTitle")
    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    @JsonProperty("contentData")
    public String getContentData() {
        return contentData;
    }

    @JsonProperty("contentData")
    public void setContentData(String contentData) {
        this.contentData = contentData;
    }

    @JsonProperty("contentImage")
    public String getContentImage() {
        return contentImage;
    }

    @JsonProperty("contentImage")
    public void setContentImage(String contentImage) {
        this.contentImage = contentImage;
    }

    @JsonProperty("siteId")
    public String getSiteId() {
        return siteId;
    }

    @JsonProperty("siteId")
    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("modifyBy")
    public String getModifyBy() {
        return modifyBy;
    }

    @JsonProperty("modifyBy")
    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    @JsonProperty("modifyDate")
    public Date getModifyDate() {
        return modifyDate;
    }

    @JsonProperty("modifyDate")
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @JsonProperty("airportHub")
    public String getAirportHub() {
        return airportHub;
    }

    @JsonProperty("airportHub")
    public void setAirportHub(String airportHub) {
        this.airportHub = airportHub;
    }

    @JsonProperty("headQuarters")
    public String getHeadQuarters() {
        return headQuarters;
    }

    @JsonProperty("headQuarters")
    public void setHeadQuarters(String headQuarters) {
        this.headQuarters = headQuarters;
    }

    @JsonProperty("popularRoutes")
    public String getPopularRoutes() {
        return popularRoutes;
    }

    @JsonProperty("popularRoutes")
    public void setPopularRoutes(String popularRoutes) {
        this.popularRoutes = popularRoutes;
    }

    @JsonProperty("popularDest")
    public String getPopularDest() {
        return popularDest;
    }

    @JsonProperty("popularDest")
    public void setPopularDest(String popularDest) {
        this.popularDest = popularDest;
    }

    @JsonProperty("travelTrends")
    public String getTravelTrends() {
        return travelTrends;
    }

    @JsonProperty("travelTrends")
    public void setTravelTrends(String travelTrends) {
        this.travelTrends = travelTrends;
    }

    @JsonProperty("onboardService")
    public String getOnboardService() {
        return onboardService;
    }

    @JsonProperty("onboardService")
    public void setOnboardService(String onboardService) {
        this.onboardService = onboardService;
    }

    @JsonProperty("premierClass")
    public String getPremierClass() {
        return premierClass;
    }

    @JsonProperty("premierClass")
    public void setPremierClass(String premierClass) {
        this.premierClass = premierClass;
    }

    @JsonProperty("clubPremier")
    public String getClubPremier() {
        return clubPremier;
    }

    @JsonProperty("clubPremier")
    public void setClubPremier(String clubPremier) {
        this.clubPremier = clubPremier;
    }

    @JsonProperty("cityairline")
    public List<Object> getCityairline() {
        return cityairline;
    }

    @JsonProperty("cityairline")
    public void setCityairline(List<Object> cityairline) {
        this.cityairline = cityairline;
    }

    @JsonProperty("routes")
    public List<Object> getRoutes() {
        return routes;
    }

    @JsonProperty("routes")
    public void setRoutes(List<Object> routes) {
        this.routes = routes;
    }

    @JsonProperty("airportList")
    public List<Object> getAirportList() {
        return airportList;
    }

    @JsonProperty("airportList")
    public void setAirportList(List<Object> airportList) {
        this.airportList = airportList;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	public String getTfnNo() {
		return tfnNo;
	}

	public void setTfnNo(String tfnNo) {
		this.tfnNo = tfnNo;
	}

	public String getTfnNo_pop() {
		return tfnNo_pop;
	}

	public void setTfnNo_pop(String tfnNo_pop) {
		this.tfnNo_pop = tfnNo_pop;
	}
    

}
