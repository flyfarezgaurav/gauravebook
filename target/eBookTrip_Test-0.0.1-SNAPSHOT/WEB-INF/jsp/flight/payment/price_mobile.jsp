<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<input type="hidden" id="grandTotal" value="${bookingRequest.flightResult.fare.grandTotal}" />
<input type="hidden" id="travelGuardCost" value="0.00" />
<input type="hidden" id="tgValue" value="0.00" />

<form:hidden path="travelGuard" id="tgOption" value="No"/>
<form:hidden path="priceDropAmount" id="priceDropAmount" value="0.00"/>
<form:hidden path="priceDropTaken" id="priceDropTaken" value="No"/>
<form:hidden path="travelAssistAmount" id="travelAssistAmount" value="0.00"/>
<form:hidden path="travelAssistTaken" id="travelAssistTaken" value="No"/>
<form:hidden path="upgradeAmount" id="upgradeAmount" value="0.00"/>
<form:hidden path="upgradeTaken" id="upgradeTaken" value="No"/>
<form:hidden path="upgradePlan" id="upgradePlan" value="Current"/>

<div class="price-details mobilePriceBox" id="priceblock">
                    <div class="pdhead">
                        <!-- <i class="fa fa-money"></i> --><img src="/resources/images/icons/Pmoney.png" alt="Price">&nbsp;&nbsp;Price Details
                    </div>
                    <hr>
                    <div class="person-price" id="mobilePriceBox">
                        <div class="tpp">
                            <span><span>${bookingRequest.adults}</span> Traveler(s): <span>Adult</span></span>
                            <span>${currencySymbol}<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.adults * (bookingRequest.flightResult.fare.adultFare+bookingRequest.flightResult.fare.adultTax+bookingRequest.flightResult.fare.adultMarkup)*currencyValue}" /></span>
                        </div>
                        <div class="fcp">
                            <span>Flight Charges per <span>Adult</span> Incl All Taxes & Fees</span>
                            <span>${currencySymbol}<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${(bookingRequest.flightResult.fare.adultFare+bookingRequest.flightResult.fare.adultTax+bookingRequest.flightResult.fare.adultMarkup)*currencyValue}" /></span>
                        </div>
                        
                    </div>
                    <hr>
					<c:if test="${bookingRequest.child > 0}">
                    <div class="person-price">
                        <div class="tpp">
                            <span><span>${bookingRequest.child}</span> Traveler(s): <span>Child</span></span>
                            <span>${currencySymbol}<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.child * (bookingRequest.flightResult.fare.childFare+bookingRequest.flightResult.fare.childTax+bookingRequest.flightResult.fare.childMarkup)*currencyValue}" /></span>
                        </div>
                        <div class="fcp">
                            <span>Flight Charges per <span>Child</span> Incl All Taxes & Fees</span>
                            <span>${currencySymbol}<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${(bookingRequest.flightResult.fare.childFare+bookingRequest.flightResult.fare.childTax+bookingRequest.flightResult.fare.childMarkup)*currencyValue}" /></span>
                        </div>
                        
                    </div>
                    <hr>
                    </c:if>
                    
                    <c:if test="${bookingRequest.infants > 0}">
                    <div class="person-price">
                        <div class="tpp">
                            <span><span>${bookingRequest.infants}</span> Traveler(s): <span>Infant(lap)</span></span>
                            <span>${currencySymbol}<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.infants * (bookingRequest.flightResult.fare.infantFare+bookingRequest.flightResult.fare.infantTax+bookingRequest.flightResult.fare.infantMarkup)*currencyValue}" /></span>
                        </div>
                        <div class="fcp">
                            <span>Flight Charges per <span>Infant(lap)</span> Incl All Taxes & Fees</span>
                            <span>${currencySymbol}<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${(bookingRequest.flightResult.fare.infantFare+bookingRequest.flightResult.fare.infantTax+bookingRequest.flightResult.fare.infantMarkup)*currencyValue}" /></span>
                        </div>
                        
                    </div>
                    <hr>
                    </c:if>
                    
                    <c:if test="${bookingRequest.infantsWs > 0}">
                    <div class="person-price">
                        <div class="tpp">
                            <span><span>${bookingRequest.infantsWs}</span> Traveler(s): <span>Infant(ws)</span></span>
                            <span>${currencySymbol}<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.infantsWs * (bookingRequest.flightResult.fare.infantWsFare+bookingRequest.flightResult.fare.infantWsTax+bookingRequest.flightResult.fare.infantWsMarkup)*currencyValue}" /></span>
                        </div>
                        <div class="fcp">
                            <span>Flight Charges per <span>Infant(ws)</span> Incl All Taxes & Fees</span>
                            <span>${currencySymbol}<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${(bookingRequest.flightResult.fare.infantWsFare+bookingRequest.flightResult.fare.infantWsTax+bookingRequest.flightResult.fare.infantWsMarkup)*currencyValue}" /></span>
                        </div>
                        
                    </div>
                    <hr>
                    </c:if>
                    
                    <div class="person-price">
						
						<div class="tpp" id="tgfareladder" style="display:none; position:relative;text-font:15px;">
                            <span> Travel Guard Insurance </span>
                            <span id="tg_price"></span>
                        </div>
                        
                        <div class="tpp" id="fareladder_pdp" style="display:none; position:relative;text-font:15px;">
                            <span> Price Drop Protection </span>
                            <span id="pdp_price"></span>
                        </div>
                        
                        <div class="tpp" id="fareladder_ta" style="display:none; position:relative;text-font:15px;">
                            <span> Travel Assist (<span id="planName"></span>)</span>
                            <span id="ta_price"></span>
                        </div>
                        
                        <div class="tpp" id="fareladder_up" style="display:none; position:relative;text-font:15px;">
                            <span id="upgradePlanName"></span>
                            <span id="up_price"></span>
                        </div>
						
						<div class="tpp" id="fareladder_web" style="display:none; position:relative;text-font:15px;">
                            <span>Web Check-in</span>
                            <span id="web_price"></span>
                        </div>
                        
                    </div>
                    
                    <div class="total-price">
                        <span>Total Price :</span>
                        <span id="total_price">${currencySymbol}<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.flightResult.fare.grandTotal*currencyValue}" /></span>
                    </div>
                    <p>NOTE: All Fares displayed are quoted in ${currencySymbol} and inclusive of base fare, taxes and all fees. Additional baggage fees may apply as per the airline policies.</p>
                </div>