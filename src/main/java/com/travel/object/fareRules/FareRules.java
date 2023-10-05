
package com.travel.object.fareRules;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.travel.object.bookingresponse.ResponseStatus;
import com.travel.object.checkFareRulesResponse.AncillaryService;
import com.travel.object.fareRules.RequiredParameter;
import com.travel.object.flightresponse.Airline;
import com.travel.object.flightresponse.Airport;
import com.travel.object.flightresponse.FlightResult;

@JsonPropertyOrder({
	"flightChecked",
	"flightInvalid",
	"priceChange",
	"fare",
	"basketId",
	"flightId",
	"bagRecheckReq",
	"freeTextLines",
	"cardType",
	"luggage",
	"results",
	"outwardLuggageOptions",
	"returnLuggageOptions",
	"perPaxLuggageOptions",
	"nameLuggage",
	"requiredParameter",
	"gbptousd",
	"eurtousd",
	"eurtogbp",
	"responseStatus",
	"ancillaryServices",
	"currencyCode"
})
public class FareRules {
	
	@JsonProperty("flightChecked")
	private boolean flightChecked=true;
	@JsonProperty("flightInvalid")
	private boolean flightInvalid=false;
	@JsonProperty("priceChange")
	private boolean priceChange=false;
	@JsonProperty("fare")
	private Fare fare;
	@JsonProperty("basketId")
	private String basketId;
	@JsonProperty("basketStart")
	private String basketStart;
	@JsonProperty("flightId")
	private String flightId;
	@JsonProperty("ValidatingCarrier")
	private String validatingCarrier;
	@JsonProperty("resultsId")
	private List<String> resultsId=null;
	@JsonProperty("results")
	private List<String> results;
	@JsonProperty("bagRecheckReq")
	private boolean bagRecheckReq=false;
	@JsonProperty("freeTextLines")
	private List<String> freeTextLines = null;
	@JsonProperty("cardType")
	private List<String> cardType=null;
	@JsonProperty("requiredParameter")
	private List<RequiredParameter> requiredParameter=null; 
	private ResponseStatus responseStatus;
	@JsonProperty("airline")
	private List<Airline> airline = null;
	@JsonProperty("airport")
	private List<Airport> airport = null;
	@JsonProperty("flightResult")
	private FlightResult flightResult = null;
	@JsonProperty("ancillaryServices")
    private List<AncillaryService> ancillaryServices = null;
	@JsonProperty("currencyCode")
    private String currencyCode;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	@JsonProperty("ancillaryServices")
    public List<AncillaryService> getAncillaryServices() {
        return ancillaryServices;
    }

    @JsonProperty("ancillaryServices")
    public void setAncillaryServices(List<AncillaryService> ancillaryServices) {
        this.ancillaryServices = ancillaryServices;
    }
    
	@JsonProperty("freeTextLines")
	public List<String> getFreeTextLines() {
		return freeTextLines;
	}

	@JsonProperty("freeTextLines")
	public void setFreeTextLines(List<String> freeTextLines) {
		this.freeTextLines = freeTextLines;
	}

	@JsonProperty("responseStatus")
	public ResponseStatus getResponseStatus() {
		return responseStatus;
	}

	@JsonProperty("responseStatus")
	public void setResponseStatus(ResponseStatus responseStatus) {
		this.responseStatus = responseStatus;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public boolean isFlightChecked() {
		return flightChecked;
	}

	public void setFlightChecked(boolean flightChecked) {
		this.flightChecked = flightChecked;
	}

	public boolean isFlightInvalid() {
		return flightInvalid;
	}

	public void setFlightInvalid(boolean flightInvalid) {
		this.flightInvalid = flightInvalid;
	}

	public boolean isPriceChange() {
		return priceChange;
	}

	public void setPriceChange(boolean priceChange) {
		this.priceChange = priceChange;
	}



	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
	@JsonProperty("basketId")
	public String getBasketId() {
		return basketId;
	}
	@JsonProperty("basketId")
	public void setBasketId(String basketId) {
		this.basketId = basketId;
	}
	@JsonProperty("flightId")
	public String getFlightId() {
		return flightId;
	}
	@JsonProperty("flightId")
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public boolean isBagRecheckReq() {
		return bagRecheckReq;
	}

	public void setBagRecheckReq(boolean bagRecheckReq) {
		this.bagRecheckReq = bagRecheckReq;
	}
	@JsonProperty("ValidatingCarrier")
	public String getValidatingCarrier() {
		return validatingCarrier;
	}
	@JsonProperty("ValidatingCarrier")
	public void setValidatingCarrier(String validatingCarrier) {
		this.validatingCarrier = validatingCarrier;
	}
	@JsonProperty("resultsId")
	public List<String> getResultsId() {
		return resultsId;
	}
	@JsonProperty("resultsId")
	public void setResultsId(List<String> resultsId) {
		this.resultsId = resultsId;
	}

	public List<String> getCardType() {
		return cardType;
	}

	public void setCardType(List<String> cardType) {
		this.cardType = cardType;
	}

	@JsonProperty("requiredParameter")
	public List<RequiredParameter> getRequiredParameter() {
		return requiredParameter;
	}
	@JsonProperty("requiredParameter")
	public void setRequiredParameter(List<RequiredParameter> requiredParameter) {
		this.requiredParameter = requiredParameter;
	}

	public List<String> getResults() {
		return results;
	}

	public void setResults(List<String> results) {
		this.results = results;
	}

	@JsonProperty("basketStart")
	public String getBasketStart() {
		return basketStart;
	}
	@JsonProperty("basketStart")
	public void setBasketStart(String basketStart) {
		this.basketStart = basketStart;
	}

	@JsonProperty("airline")
	public List<Airline> getAirline() {
		return airline;
	}

	@JsonProperty("airline")
	public void setAirline(List<Airline> airline) {
		this.airline = airline;
	}

	@JsonProperty("airport")
	public List<Airport> getAirport() {
		return airport;
	}

	@JsonProperty("airport")
	public void setAirport(List<Airport> airport) {
		this.airport = airport;
	}
	@JsonProperty("fare")
	public Fare getFare() {
		return fare;
	}
	@JsonProperty("fare")
	public void setFare(Fare fare) {
		this.fare = fare;
	}
	@JsonProperty("flightResult")
	public FlightResult getFlightResult() {
		return flightResult;
	}

	@JsonProperty("flightResult")
	public void setFlightResult(FlightResult flightResult) {
		this.flightResult = flightResult;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
}
