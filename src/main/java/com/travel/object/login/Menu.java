
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
    "menuId",
    "menuName",
    "menuImg",
    "subMenu"
})
public class Menu {

    @JsonProperty("menuId")
    private Integer menuId;
    @JsonProperty("menuName")
    private String menuName;
    @JsonProperty("menuImg")
    private String menuImg;
    @JsonProperty("subMenu")
    private List<SubMenu> subMenu = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("menuId")
    public Integer getMenuId() {
        return menuId;
    }

    @JsonProperty("menuId")
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    @JsonProperty("menuName")
    public String getMenuName() {
        return menuName;
    }

    @JsonProperty("menuName")
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @JsonProperty("menuImg")
    public String getMenuImg() {
        return menuImg;
    }

    @JsonProperty("menuImg")
    public void setMenuImg(String menuImg) {
        this.menuImg = menuImg;
    }

    @JsonProperty("subMenu")
    public List<SubMenu> getSubMenu() {
        return subMenu;
    }

    @JsonProperty("subMenu")
    public void setSubMenu(List<SubMenu> subMenu) {
        this.subMenu = subMenu;
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
