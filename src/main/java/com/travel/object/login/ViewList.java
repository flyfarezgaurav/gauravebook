
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
    "productId",
    "productName",
    "productImg",
    "Menu"
})
public class ViewList {

    @JsonProperty("productId")
    private Integer productId;
    @JsonProperty("productName")
    private String productName;
    @JsonProperty("productImg")
    private String productImg;
    @JsonProperty("Menu")
    private List<Menu> menu = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("productId")
    public Integer getProductId() {
        return productId;
    }

    @JsonProperty("productId")
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @JsonProperty("productName")
    public String getProductName() {
        return productName;
    }

    @JsonProperty("productName")
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @JsonProperty("productImg")
    public String getProductImg() {
        return productImg;
    }

    @JsonProperty("productImg")
    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    @JsonProperty("Menu")
    public List<Menu> getMenu() {
        return menu;
    }

    @JsonProperty("Menu")
    public void setMenu(List<Menu> menu) {
        this.menu = menu;
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
