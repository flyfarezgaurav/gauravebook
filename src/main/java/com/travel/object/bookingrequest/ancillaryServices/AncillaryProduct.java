package com.travel.object.bookingrequest.ancillaryServices;

import java.util.List;
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
	"selectionType",
	"supplierNumber",
	"supplierLookup",
	"fullName"
})

public class AncillaryProduct
{	
	@JsonProperty("productId")
	private int productId;
	@JsonProperty("name")
	private String name;
	@JsonProperty("supplierNumber")
	private String supplierNumber;
	@JsonProperty("supplierLookup")
	private String supplierLookup;
	@JsonProperty("mostPopular")
	private boolean mostPopular;
	@JsonProperty("price")
	private double price;
	@JsonProperty("conditionList")
	private List<Services> conditionList;
	@JsonProperty("selectionType")
	private String selectionType; //radio or select button 
	@JsonProperty("fullName")
	private String fullName;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isMostPopular() {
		return mostPopular;
	}
	public void setMostPopular(boolean mostPopular) {
		this.mostPopular = mostPopular;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public List<Services> getConditionList() {
		return conditionList;
	}
	public void setConditionList(List<Services> conditionList) {
		this.conditionList = conditionList;
	}
	public String getSelectionType() {
		return selectionType;
	}
	public void setSelectionType(String selectionType) {
		this.selectionType = selectionType;
	}
	public String getSupplierNumber() {
		return supplierNumber;
	}
	public void setSupplierNumber(String supplierNumber) {
		this.supplierNumber = supplierNumber;
	}
	@JsonProperty("supplierLookup")
	public String getSupplierLookup() {
		return supplierLookup;
	}
	@JsonProperty("supplierLookup")
	public void setSupplierLookup(String supplierLookup) {
		this.supplierLookup = supplierLookup;
	}
	
	
	
}
