package com.travel.object.fareRules;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
	"name",
	"types",
	"text",
	"perPax",
	"isOptional"
})

public class RequiredParameter {
	@JsonProperty("name")
	private String name;
	@JsonProperty("types")
	private String types;
	@JsonProperty("text")
	private String text;
	@JsonProperty("perPax")
	private boolean perPax;
	@JsonProperty("isOptional")
	private boolean isOptional;
	
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}
	@JsonProperty("types")
	public String getTypes() {
		return types;
	}
	@JsonProperty("types")
	public void setTypes(String types) {
		this.types = types;
	}
	@JsonProperty("text")
	public String getText() {
		return text;
	}
	@JsonProperty("text")
	public void setText(String text) {
		this.text = text;
	}
	@JsonProperty("perPax")
	public boolean isPerPax() {
		return perPax;
	}
	@JsonProperty("perPax")
	public void setPerPax(boolean perPax) {
		this.perPax = perPax;
	}
	@JsonProperty("isOptional")
	public boolean isOptional() {
		return isOptional;
	}
	@JsonProperty("isOptional")
	public void setOptional(boolean isOptional) {
		this.isOptional = isOptional;
	}
		
		
}
