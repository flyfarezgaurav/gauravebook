<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<script type="text/javascript" src="//widget.trustpilot.com/bootstrap/v5/tp.widget.bootstrap.min.js" async></script>
<input type="hidden" id="grandTotal" value="${bookingRequest.flightResult.fare.grandTotal}" />
<input type="hidden" id="travelGuardCost" value="0.00" />
<input type="hidden" id="tgValue" value="0.00" />

<form:hidden path="travelGuard" id="tgOption" value="No"/>
<form:hidden path="priceDropAmount" id="priceDropAmount" value="0.00"/>
<form:hidden path="priceDropTaken" id="priceDropTaken" value="No"/>

<form:hidden path="travelAssistAmount" id="travelAssistAmount" value="0.00"/>
<form:hidden path="travelAssistTaken" id="travelAssistTaken" value="No"/>

<form:hidden path="upgradeAmount" id="upgradeAmount" />
<form:hidden path="upgradeTaken" id="upgradeTaken" />
<form:hidden path="upgradePlan" id="upgradePlan" />

<div class="ad-block">
                
                <div class="sa-item">
                    <!-- You may book in the next <b>20 minutes</b> as this page will then refresh. -->
                    <div class="payment-trustpilotwidget">
                        <div class="trustpilot-widget" data-locale="en-US" data-template-id="53aa8807dec7e10d38f59f32" data-businessunit-id="5df2617cf1595900015d13d1" data-style-height="120px" data-style-width="100%" data-theme="light">
                            <a href="https://www.trustpilot.com/review/ebooktrip.com" target="_blank" rel="noopener">Trustpilot</a>
                        </div>
                    </div>
                </div>
                <div class="price-details desktopPriceBox" id="priceblock">
                    <div class="pdhead">
                        <!-- <i class="fa fa-money"></i> --><img src="/resources/images/icons/Pmoney.png" alt="Price">&nbsp;&nbsp;Price Details
                    </div>
                    <hr>
                    <div class="person-price" id="desktopPriceBox">
                        <div class="tpp">
                            <span><span>${bookingRequest.adults}</span> Traveler(s): <span>Adult</span></span>
                            <span>$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.adults * (bookingRequest.flightResult.fare.adultFare+bookingRequest.flightResult.fare.adultTax+bookingRequest.flightResult.fare.adultMarkup)}" /></span>
                        </div>
                        <div class="fcp">
                            <span>Flight Charges per <span>Adult</span> Incl All Taxes & Fees</span>
                            <span>$<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.flightResult.fare.adultFare+bookingRequest.flightResult.fare.adultTax+bookingRequest.flightResult.fare.adultMarkup}" /></span>
                        </div>
                    </div>
                    <hr>
					<c:if test="${bookingRequest.child > 0}">
                    <div class="person-price">
                        <div class="tpp">
                            <span><span>${bookingRequest.child}</span> Traveler(s): <span>Child</span></span>
                            <span>$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.child * (bookingRequest.flightResult.fare.childFare+bookingRequest.flightResult.fare.childTax+bookingRequest.flightResult.fare.childMarkup)}" /></span>
                        </div>
                        <div class="fcp">
                            <span>Flight Charges per <span>Child</span> Incl All Taxes & Fees</span>
                            <span>$<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.flightResult.fare.childFare+bookingRequest.flightResult.fare.childTax+bookingRequest.flightResult.fare.childMarkup}" /></span>
                        </div>
                      </div>
                    <hr>
                    </c:if>
                    
                    <c:if test="${bookingRequest.infants > 0}">
                    <div class="person-price">
                        <div class="tpp">
                            <span><span>${bookingRequest.infants}</span> Traveler(s): <span>Infant(lap)</span></span>
                            <span>$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.infants * (bookingRequest.flightResult.fare.infantFare+bookingRequest.flightResult.fare.infantTax+bookingRequest.flightResult.fare.infantMarkup)}" /></span>
                        </div>
                        <div class="fcp">
                            <span>Flight Charges per <span>Infant(lap)</span> Incl All Taxes & Fees</span>
                            <span>$<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.flightResult.fare.infantFare+bookingRequest.flightResult.fare.infantTax+bookingRequest.flightResult.fare.infantMarkup}" /></span>
                        </div>
                    </div>
                    <hr>
                    </c:if>
                    
                    <c:if test="${bookingRequest.infantsWs > 0}">
                    <div class="person-price">
                        <div class="tpp">
                            <span><span>${bookingRequest.infantsWs}</span> Traveler(s): <span>Infant(ws)</span></span>
                            <span>$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.infantsWs * (bookingRequest.flightResult.fare.infantWsFare+bookingRequest.flightResult.fare.infantWsTax+bookingRequest.flightResult.fare.infantWsMarkup)}" /></span>
                        </div>
                        <div class="fcp">
                            <span>Flight Charges per <span>Infant(ws)</span> Incl All Taxes & Fees</span>
                            <span>$<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.flightResult.fare.infantWsFare+bookingRequest.flightResult.fare.infantWsTax+bookingRequest.flightResult.fare.infantWsMarkup}" /></span>
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
                        
                    </div>
                    
                    <div class="total-price">
                        <span>Total Price :</span>
                        <span id="total_price">$<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.flightResult.fare.grandTotal}" /></span>
                    </div>
                    <p>NOTE: All Fares displayed are quoted in USD and inclusive of base fare, taxes and all fees. Additional baggage fees may apply as per the airline policies.</p>
                </div>
                
                <!-- <div class="sa-item">
                    <div class="sa-head">Secure SSL Booking</div>
                    <hr>
                    <div class="sa-row"><img src="/resources/images/mcafee.png"><span>Ebooktrip has passed McAfee SECURE's daily security scan</span></div>
                    <div class="sa-row"><img src="/resources/images/norton.png"><span>Your booking is SSL secured & encrypted by DigiCert</span></div>
                </div> -->
                <div class="sa-item">
                    <div class="sa-head">Book with <img src="/resources/images/logo.png"></div>
                    <hr>
                    <div class="sa-row"><i class="fa fa-check"></i><span> Travel Industry Award Winner</span></div>
                    <div class="sa-row"><i class="fa fa-check"></i><span> IATAN, ARC, ASTA Member</span></div>
                    <div class="sa-row"><i class="fa fa-check"></i><span> Travel Weekly Power List</span></div>
                </div>
            </div>
			