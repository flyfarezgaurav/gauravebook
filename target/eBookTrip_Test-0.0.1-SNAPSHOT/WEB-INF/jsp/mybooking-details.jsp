<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


	

<div class="booking-screen-overlay">
            <div class="mycontainer booking">
	    <div class="p-and-p-close"><h5></h5><i class="fa fa-close"></i></div>
            <div class="booking-confirm">
                <img src="/resources/images/confirm.png">
                <div style="font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;">Your Booking is ${mybookingResponse.bookingDetail.bookingStatus}</div>
                <div>Your booking reference number is</div>
                <div>${mybookingResponse.bookingDetail.pnrConfirmation}</div>
            </div>
            <div class="flight-summary">
                <div class="fshead">
                    <i class="fa fa-plane"></i>&nbsp&nbspFlight Summary
                </div>
                <div class="dr-flights">
					<c:forEach var="sector" items="${mybookingResponse.sectorDetail}">
                    <div class="fdetails">
                        <div class="col1">
                            <div><img src="/resources/images/airline-logo/${sector.opratingAirline}.png"></div>
							
                            <div>${sector.fromDateTime}</div>
                            
							<div>${sector.fromDestination}</div>
                            
                        </div>
                        <div class="col2">
                            <div>Flight No: <span>${sector.flightNo}</span></div>
                            <div><i class="fa fa-long-arrow-right"></i></div>
                            <div>Non-Stop</div>
                        </div>
                        <div class="col3">
							<c:if test="${sector.cabinclass == '1'}">
                            <div>Class: <span>Economy</span></div>
							</c:if>
							<c:if test="${sector.cabinclass == '2'}">
                            <div>Class: <span>Premium Economy</span></div>
							</c:if>
							<c:if test="${sector.cabinclass == '3'}">
                            <div>Class: <span>Business</span></div>
							</c:if>
							<c:if test="${sector.cabinclass == '4'}">
                            <div>Class: <span>First</span></div>
							</c:if>
							<div>${sector.toDateTime}</div>
							<div>${sector.toDestination}</div>
                           
                        </div>
                    </div>
		<h2 class="stop-divider"></h2>
                   </c:forEach>
                </div>
                
            </div>
            <div class="traveler-details">
                <div class="tdhead">
                    <i class="fa fa-user"></i>&nbsp&nbspTraveler(s) Details
                </div>
                <table class="tdtable">
                    <tr>
                        <th>S.No</th>
                        <th>Name</th>
                        <th>Gender</th>
                        <th>DOB</th>
                    </tr>
					<c:forEach var="paxDetail" items="${mybookingResponse.passengerDetails}" varStatus="loop">
                    <tr>
                        <td>${loop.index+1}.</td>
                        <td>${paxDetail.paxFirstName} ${paxDetail.paxLastName}</td>
						<c:if test="${paxDetail.paxSex == '1'}">
                        <td>Male</td>
						</c:if>
						<c:if test="${paxDetail.paxSex == '2'}">
                        <td>Female</td>
						</c:if>
                        <td>${paxDetail.paxDob}</td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="contact-details">
                <div class="cdhead">
                    <i class="fa fa-phone"></i>&nbsp&nbspContact Details
                </div>
                <div class="cdtable">
                    <div>
                        <span>Billing Phone</span>
                        <span>${mybookingResponse.bookingDetail.mobileNo}</span>
                    </div>
                    <div>
                        <span>Alternate Phone</span>
                        <span>${mybookingResponse.bookingDetail.phoneNo}</span>
                    </div>
                    <div>
                        <span>Email</span>
                        <span>${mybookingResponse.bookingDetail.emailId}</span>
                    </div>
                </div>
            </div>
            <div class="price-details">
                <div class="pdhead">
                    <i class="fa fa-money"></i>&nbsp&nbspPrice Details
                </div>
                <div class="person-price">
                    <div class="tpp">
                        <span><span><c:out value="${mybookingResponse.bookingDetail.adult}" /></span> Traveler(s): <span>Adult</span></span>
                        <span>$ <fmt:formatNumber type="number" maxFractionDigits="2" value="${(mybookingResponse.fareDetail[0].adultFare+mybookingResponse.fareDetail[0].adultTax+mybookingResponse.fareDetail[0].adultMarkup) * mybookingResponse.bookingDetail.adult}"/> </span>
                    </div>
                    <div class="fcp">
                        <span>Flight Charges per <span>adult</span></span>
                        <span>$ <fmt:formatNumber type="number" maxFractionDigits="2" value="${mybookingResponse.fareDetail[0].adultFare}"/> </span>
                    </div>
                    <div class="tfp">
                        <span>Taxes & Fees per <span>adult</span></span>
                        <span>$ <fmt:formatNumber type="number" maxFractionDigits="2" value="${mybookingResponse.fareDetail[0].adultTax+mybookingResponse.fareDetail[0].adultMarkup}"/> </span>
                    </div>
                </div>
				<c:if test="${mybookingResponse.bookingDetail.child > 0}">
                <hr>
                <div class="person-price">
                    <div class="tpp">
                        <span><span><c:out value="${mybookingResponse.bookingDetail.child}" /></span> Traveler(s): <span>Child</span></span>
                        <span>$ ${(mybookingResponse.fareDetail[0].childFare+mybookingResponse.fareDetail[0].childTax+mybookingResponse.fareDetail[0].childMarkup) * mybookingResponse.bookingDetail.child}</span>
                    </div>
                    <div class="fcp">
                        <span>Flight Charges per <span>child</span></span>
                        <span>$ ${mybookingResponse.fareDetail[0].childFare}</span>
                    </div>
                    <div class="tfp">
                        <span>Taxes & Fees per <span>child</span></span>
                        <span>$ ${mybookingResponse.fareDetail[0].childTax+mybookingResponse.fareDetail[0].childMarkup}</span>
                    </div>
                </div>
				</c:if>
				<c:if test="${mybookingResponse.bookingDetail.infant > 0}">
                <hr>
                <div class="person-price">
                    <div class="tpp">
                        <span><span><c:out value="${mybookingResponse.bookingDetail.infant}" /></span> Traveler(s): <span>Infant</span></span>
                        <span>$ ${(mybookingResponse.fareDetail[0].infantFare+mybookingResponse.fareDetail[0].infantTax+mybookingResponse.fareDetail[0].infantMarkup) * mybookingResponse.bookingDetail.infant}</span>
                    </div>
                    <div class="fcp">
                        <span>Flight Charges per <span>Infant</span></span>
                        <span>$ ${mybookingResponse.fareDetail[0].infantFare}</span>
                    </div>
                    <div class="tfp">
                        <span>Taxes & Fees per <span>Infant</span></span>
                        <span>$ ${mybookingResponse.fareDetail[0].infantTax+mybookingResponse.fareDetail[0].infantMarkup}</span>
                    </div>
                </div>
				</c:if>
				<c:if test="${mybookingResponse.bookingDetail.infantWs > 0}">
                <hr>
                <div class="person-price">
                    <div class="tpp">
                        <span><span><c:out value="${mybookingResponse.bookingDetail.infantWs}" /></span> Traveler(s): <span>InfantWs</span></span>
                        <span>$ ${(mybookingResponse.fareDetail[0].infantWsFare+mybookingResponse.fareDetail[0].infantWsTax+mybookingResponse.fareDetail[0].infantWsMarkup) * mybookingResponse.bookingDetail.infantWs}</span>
                    </div>
                    <div class="fcp">
                        <span>Flight Charges per <span>InfantWs</span></span>
                        <span>$ ${mybookingResponse.fareDetail[0].infantWsFare}</span>
                    </div>
                    <div class="tfp">
                        <span>Taxes & Fees per <span>InfantWs</span></span>
                        <span>$ ${mybookingResponse.fareDetail[0].infantWsTax+mybookingResponse.fareDetail[0].infantWsMarkup}</span>
                    </div>
                </div>
				</c:if>
                <div class="total-price">
                    <span>Final Total:</span><span>$ ${mybookingResponse.fareDetail[0].grandTotal}</span>
                </div>
                <p>NOTE: All Fares displayed are quoted in USD and inclusive of base fare, taxes and all fees. Additional baggage fees may apply as per the airline policies.</p>
            </div>
            
        </div>
        </div>