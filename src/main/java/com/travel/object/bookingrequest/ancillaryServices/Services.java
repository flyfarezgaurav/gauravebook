package com.travel.object.bookingrequest.ancillaryServices;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"productId",
	"name",
	"mostPopular",
	"price",
	"conditionList",
	"selectionType"
})

public class Services {

	@JsonProperty("serviceId")
	private int serviceId;
	@JsonProperty("productId")
	private int productId;
	@JsonProperty("position")
	private int position;
	@JsonProperty("name")
	private String name;
	@JsonProperty("showType")
	private String showType; // Bullet or Service
	@JsonProperty("iText")
	private String iText;
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShowType() {
		return showType;
	}
	public void setShowType(String showType) {
		this.showType = showType;
	}
	public String getiText() {
		return iText;
	}
	public void setiText(String iText) {
		this.iText = iText;
	}
}
