
package com.travel.object.blogs;

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
    "id",
    "title",
    "titleUrl",
    "content",
    "description",
    "keywords",
    "posttime",
    "status",
    "heading",
    "imgUrl",
    "siteId",
    "categoryName",
    "blogdes2",
    "blogTagsName2",
    "extarTag"
})
public class Response {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("titleUrl")
    private String titleUrl;
    @JsonProperty("content")
    private String content;
    @JsonProperty("description")
    private String description;
    @JsonProperty("keywords")
    private String keywords;
    @JsonProperty("posttime")
    private Date posttime;
    @JsonProperty("status")
    private String status;
    @JsonProperty("heading")
    private String heading;
    @JsonProperty("imgUrl")
    private Object imgUrl;
    @JsonProperty("siteId")
    private Integer siteId;
    @JsonProperty("categoryName")
    private String categoryName;
    @JsonProperty("blogdes2")
    private String blogdes2;
    @JsonProperty("blogTagsName2")
    private String blogTagsName2;
    @JsonProperty("extarTag")
    private String extarTag;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("titleUrl")
    public String getTitleUrl() {
        return titleUrl;
    }

    @JsonProperty("titleUrl")
    public void setTitleUrl(String titleUrl) {
        this.titleUrl = titleUrl;
    }

    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("keywords")
    public String getKeywords() {
        return keywords;
    }

    @JsonProperty("keywords")
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @JsonProperty("posttime")
    public Date getPosttime() {
        return posttime;
    }

    @JsonProperty("posttime")
    public void setPosttime(Date posttime) {
        this.posttime = posttime;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("heading")
    public String getHeading() {
        return heading;
    }

    @JsonProperty("heading")
    public void setHeading(String heading) {
        this.heading = heading;
    }

    @JsonProperty("imgUrl")
    public Object getImgUrl() {
        return imgUrl;
    }

    @JsonProperty("imgUrl")
    public void setImgUrl(Object imgUrl) {
        this.imgUrl = imgUrl;
    }

    @JsonProperty("siteId")
    public Integer getSiteId() {
        return siteId;
    }

    @JsonProperty("siteId")
    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    @JsonProperty("categoryName")
    public String getCategoryName() {
        return categoryName;
    }

    @JsonProperty("categoryName")
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @JsonProperty("blogdes2")
    public String getBlogdes2() {
        return blogdes2;
    }

    @JsonProperty("blogdes2")
    public void setBlogdes2(String blogdes2) {
        this.blogdes2 = blogdes2;
    }

    @JsonProperty("blogTagsName2")
    public String getBlogTagsName2() {
        return blogTagsName2;
    }

    @JsonProperty("blogTagsName2")
    public void setBlogTagsName2(String blogTagsName2) {
        this.blogTagsName2 = blogTagsName2;
    }

    @JsonProperty("extarTag")
    public String getExtarTag() {
        return extarTag;
    }

    @JsonProperty("extarTag")
    public void setExtarTag(String extarTag) {
        this.extarTag = extarTag;
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
