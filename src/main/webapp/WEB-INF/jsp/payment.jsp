<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html ng-app="flightPayment">
    <head>
        <title>Review Trip Details & Book</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href='https://fonts.googleapis.com/css?family=Chivo' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet'>
        <link rel="icon" href="/resources/images/favicon.png">
	<script src="/resources/scripts/jquery-1.11.1.min.js"></script>
	<script src="/resources/scripts/jquery.validate.min.js"></script>
	<script src="/resources/scripts/angular.min.js"></script>
	<script src="/resources/scripts/jquery.creditCardValidator.js"></script>
	<script src="/resources/scripts/fpayment.js?08092022"></script>
	<style>
	.has-error{border: 1px solid red !important;}
        .submit-details button
{
    color:#fff;
    background-color:#FF4500!important;
    height:50px; 
    width:100%;
    margin:15px 30%; 
    border:0;
    outline:0;
    font-size:18px;
    font-weight:550;
    border-radius:3px;
}

/*.bdform input.rkap { width:49%!important;}*/
.bdform input.rkap { width:50%!important;}
.bdform select.rkap2 { /*width:66%!important;*/}
.bdform input.rkap3{ /*width:29%!important;*/}
.bdform select.rkap4{ width:99%!important;}
		</style>
		<script>
function goBack() {
  window.history.back();
}
</script>
<link rel="stylesheet" href="/resources/css/payment.css?31_JAN2023" type="text/css">
    <jsp:include page="tag-manager-head.jsp" /></head>
    <body ng-controller="flightPaymentCntrl">
    <jsp:include page="tag-manager-body.jsp" />
        <!--Header Area Starts Here-->
        <div class="header-container">
            <div class="header">
                <div class="logo-fh">
                    <a href="/"><img src="/resources/images/logo.png"></a>
                </div>
                <div class="navbar-main">
                    <div class="expert-talk">
            <a href="tel:+1-800-404-0025"><span>Get Customer Support: </span><span> 1-800-404-0025</span></a>
            </div>

                </div>
                <div class="side-navbar-button" style="display: none;">
                    <button type="button" onclick="showsidenav()"><i class="fa fa-bars"></i></button>
                </div>
            </div>
        </div>
        <div class="side-navbar" id="sidenavbar">
            <li><button type="button" onclick="hidesidenav()"><i class="fa fa-close"></i></button></li>
           <!-- <li><a href="#">Sign In</a></li>
            <li><a href="#">Register</a></li>
            <li><a href="#">My Bookings</a></li>
            <li><a href="#">Customer Support</a></li>
            <li><a href="#">Track Credit/Refund</a></li>  -->
            <li><a href="/contactus">Contact Us</a></li>
        <li><a href="/terms-and-conditions">Terms & Conditions</a></li>
        <li><a href="/privacy-policy">Privacy Policy</a></li>
            <p>Copyright &copy;  2021 - 2022, Ebooktrip. All rights reserved</p>
        </div>
        <div class="screen-overlay" id="screenoverlay" onclick="hidesidenav();"></div>
        <div id="screenoverlay2" onclick="enginehide();"></div>
        <div class="backbtnrow mycontainer">
            <button type="button" onclick="goBack();" style="border-radius:3px"><i class="fa fa-long-arrow-left" aria-hidden="true"></i>&nbsp;&nbsp; Go Back</button>
        </div>
		<fmt:setLocale value="en_US" scope="session"/>
		<form:form method="POST" action="/flight/payment/confirm" modelAttribute="bookingRequest" novalidate="novalidate">
		<input type="hidden" id="sessionId" value="${bookingRequest.searchID}">
        <div class="ftpdetails mycontainer">
            <div class="ft-block">
				
				<c:if test="${bookingRequest.isPriceChange==true}">
				<div class="flight-details sa-item" style="background:#FFFFE0;border-style: solid;border-color: yellow;">
					<c:set var="totalPrice" value="${bookingRequest.flightResult.fare.grandTotal/(bookingRequest.adults+bookingRequest.child+bookingRequest.infants+bookingRequest.infantsWs)}" scope="request" />
					<div style="text-align:center;font-weight:500;margin:10px;">We're sorry! The fare you selected has been updated by the Airlines.</div>
					<div style="text-align:center;font-weight:500;margin:10px;">Sometimes this can happen when inventory changes quickly or airlines is updating its database.</div>
					<div style="text-align:center;font-weight:500;margin:10px;">The new price including all Taxes and Fees per passenger is <b style="color:#da2000;">$<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${totalPrice}" /></b>. Please continue with the </div>
					<div style="text-align:center;font-weight:500;margin:10px;">booking below or <a href="/">Click here</a> to find an alternative flight.</div>
				</div>
				</c:if>
				<div class="clearfix"></div>
				
                <div class="flight-details">
                    <div class="fdhead">
                        <!-- <i class="fa fa-plane"></i> --><img src="/resources/images/icons/Pplane.png" alt="Plane">&nbsp;&nbsp;Flight Details
                    </div>
                    <hr>
                    <div class="departure">
                        <div class="deprow">
                            <span>Departure</span>
                            <a href="javascript:void(window.open('/baggage-fees', 'Taxes and Fees', 'width=600,height=750,scrollbars=yes'));"><i class="fa fa-briefcase"></i>&nbspBaggage Fees</a>
                        </div>
						<c:forEach var="outbound" items="${bookingRequest.flightResult.outBound}">
                        <div class="flirow">
                            <div class="fdetails1"><img src="/resources/images/airline-logo/${outbound.airline}.png">&nbsp&nbsp<div><span class="fliname">${outbound.airlineName}</span><span class="flinum">Flight ${outbound.flightNo}</span></div></div>
                            <div class="tadetails">
                                <div class="a1d">
                                    <div><span class="sname">${outbound.fromAirport}</span><span class="fname"> ${outbound.froCityName},${outbound.fromAirportName}</span></div>
                                    <c:set var="depDate" value="${fn:replace(outbound.depDate,'T', ' ')}" />
									<fmt:parseDate value="${depDate}" var="dateObject" pattern="yyyy-MM-dd HH:mm:ss" />
									<div><span class="date"><fmt:formatDate value="${dateObject }" pattern="EEE, MMM dd" /></span>&nbsp<span class="time"> <fmt:formatDate value="${dateObject }" pattern="hh:mm a" /></span></div>
                                </div>
                                <i class="fa fa-long-arrow-right" style="font-size:30px;color:#17252A"></i>
                                <div class="a2d">
                                    <div><span class="sname">${outbound.toAirport}</span><span class="fname"> ${outbound.toCityName},${outbound.toAirportName}</span></div>
                                    <c:set var="reachDate" value="${fn:replace(outbound.reachDate,'T', ' ')}" />
					<fmt:parseDate value="${reachDate}" var="reachObject" pattern="yyyy-MM-dd HH:mm:ss" />
					<div><span class="date"><fmt:formatDate value="${reachObject }" pattern="EEE, MMM dd" /> </span>&nbsp<span class="time" ><fmt:formatDate value="${reachObject }" pattern="hh:mm a" /></span></div>
                                </div> 
                            </div>
                            <div class="cwdetails"><span class="wayd">Non Stop</span><span class="classd"><script>document.write(getCabin(<c:out value='${outbound.cabinClass}' />))</script></span></div>
                            <div class="fdetails2"><img src="/resources/images/airline-logo/${outbound.airline}.png">&nbsp&nbsp<div><span class="fliname">${outbound.airlineName}</span><span class="flinum">Flight ${outbound.flightNo}</span></div></div>
                        </div>
                        
                        <c:if test="${not empty outbound.layOverTime}">
                        	<c:if test="${outbound.layOverTime > 0 }">
                        		<h2 class="stop-divider"><span><i class="fa fa-clock-o"></i> <script>document.write(timeConvert(<c:out value='${outbound.layOverTime}' />))</script> layover in ${outbound.toCityName} (${outbound.toAirport})</span></h2>
                        	</c:if>
                        </c:if>
                        
                        </c:forEach>
                    </div>
                    
                    <c:if test="${not empty bookingRequest.flightResult.outEFT}">
                    	<div class="durarow">
                        	<span><i class="fa fa-clock-o"></i> Total Trip Time: <script>document.write(timeConvert(<c:out value='${bookingRequest.flightResult.outEFT}' />))</script></span>
                    	</div>
                    </c:if>
                    
                    <div class="return">
                        <div class="retrow">
				<c:if test="${searchRequest.tripType == 2}">
                            		<span>Return</span>
				</c:if>	
				<c:if test="${searchRequest.tripType == 3}">
                            		<span>Departure</span>
				</c:if>
                        </div>
			<c:forEach var="inbound" items="${bookingRequest.flightResult.inBound}">
                        <div class="flirow">
                            <div class="fdetails1"><img src="/resources/images/airline-logo/${inbound.airline}.png">&nbsp&nbsp<div><span class="fliname">${inbound.airlineName}</span><span class="flinum">Flight ${inbound.flightNo}</span></div></div>
                            <div class="tadetails">
                                <div class="a1d">
                                    <div><span class="sname">${inbound.fromAirport}</span><span class="fname"> ${inbound.froCityName},${inbound.fromAirportName}</span></div>
                                    <c:set var="depDate" value="${fn:replace(inbound.depDate,'T', ' ')}" />
									<fmt:parseDate value="${depDate}" var="dateObject" pattern="yyyy-MM-dd HH:mm:ss" />
                                    <div><span class="date"><fmt:formatDate value="${dateObject }" pattern="EEE, MMM dd" /></span>&nbsp<span class="time"> <fmt:formatDate value="${dateObject }" pattern="hh:mm a" /></span></div>
                                </div>
                                <i class="fa fa-long-arrow-right" style="font-size:30px;color:#17252A"></i>
                                <div class="a2d">
                                    <div><span class="sname">${inbound.toAirport}</span><span class="fname"> ${inbound.toCityName},${inbound.toAirportName}</span></div>
                                    <c:set var="reachDate" value="${fn:replace(inbound.reachDate,'T', ' ')}" />
									<fmt:parseDate value="${reachDate}" var="reachObject" pattern="yyyy-MM-dd HH:mm:ss" />
                                    <div><span class="date"><fmt:formatDate value="${reachObject }" pattern="EEE, MMM dd" /> </span>&nbsp<span class="time" ><fmt:formatDate value="${reachObject }" pattern="hh:mm a" /></span></div>
                                </div> 
                            </div>
                            <div class="cwdetails"><span class="wayd">Non Stop</span><span class="classd"><script>document.write(getCabin(<c:out value='${inbound.cabinClass}' />))</script></span></div>
                            <div class="fdetails2"><img src="/resources/images/airline-logo/${inbound.airline}.png">&nbsp&nbsp<div><span class="fliname">${inbound.airlineName}</span><span class="flinum">Flight ${inbound.flightNo}</span></div></div>
                        </div>
                        
                        <c:if test="${not empty inbound.layOverTime && inbound.layOverTime > 0}">
                        	<h2 class="stop-divider"><span><i class="fa fa-clock-o"></i> <script>document.write(timeConvert(<c:out value='${inbound.layOverTime}' />))</script> layover in ${inbound.toCityName} (${inbound.toAirport})</span></h2>
                        </c:if>
                        
                        </c:forEach>
                    </div>
                    
					<c:if test="${not empty bookingRequest.flightResult.inEFT}">
                    	<div class="durarow">
                        	<span><i class="fa fa-clock-o"></i> Total Trip Time: <script>document.write(timeConvert(<c:out value='${bookingRequest.flightResult.inEFT}' />))</script></span>
                    	</div>
					</c:if>
					
					<c:forEach var="outbound" items="${bookingRequest.flightResult.otherBound}">
					<div class="departure">
                        <div class="deprow">
                            <span>Departure</span>
                            <a href="javascript:void(window.open('/baggage-fees', 'Taxes and Fees', 'width=600,height=750,scrollbars=yes'));"><i class="fa fa-briefcase"></i>&nbspBaggage Fees</a>
                        </div>
						<c:forEach var="outbound" items="${outbound}">
                        <div class="flirow">
                            <div class="fdetails1"><img src="/resources/images/airline-logo/${outbound.airline}.png">&nbsp&nbsp<div><span class="fliname">${outbound.airlineName}</span><span class="flinum">Flight ${outbound.flightNo}</span></div></div>
                            <div class="tadetails">
                                <div class="a1d">
                                    <div><span class="sname">${outbound.fromAirport}</span><span class="fname"> ${outbound.froCityName},${outbound.fromAirportName}</span></div>
                                    <c:set var="depDate" value="${fn:replace(outbound.depDate,'T', ' ')}" />
									<fmt:parseDate value="${depDate}" var="dateObject" pattern="yyyy-MM-dd HH:mm:ss" />
									<div><span class="date"><fmt:formatDate value="${dateObject }" pattern="EEE, MMM dd" /></span>&nbsp<span class="time"> <fmt:formatDate value="${dateObject}" pattern="hh:mm a" /></span></div>
                                </div>
                                <i class="fa fa-long-arrow-right" style="font-size:30px;color:#17252A"></i>
                                <div class="a2d">
                                    <div><span class="sname">${outbound.toAirport}</span><span class="fname"> ${outbound.toCityName},${outbound.toAirportName}</span></div>
                                    <c:set var="reachDate" value="${fn:replace(outbound.reachDate,'T', ' ')}" />
									<fmt:parseDate value="${reachDate}" var="reachObject" pattern="yyyy-MM-dd HH:mm:ss" />
									<div><span class="date"><fmt:formatDate value="${reachObject }" pattern="dd, MMM yyyy" /> </span>&nbsp<span class="time" ><fmt:formatDate value="${reachObject }" pattern="hh:mm a" /></span></div>
                                </div> 
                            </div>
                            <div class="cwdetails"><span class="wayd">Non Stop</span><span class="classd"><script>document.write(getCabin(<c:out value='${outbound.cabinClass}' />))</script></span></div>
                            <div class="fdetails2"><img src="/resources/images/airline-logo/${outbound.airline}.png">&nbsp&nbsp<div><span class="fliname">${outbound.airlineName}</span><span class="flinum">Flight ${outbound.flightNo}</span></div></div>
                        </div>
                        <c:if test="${not empty outbound.layOverTime && outbound.layOverTime > 0 }">
                        <h2 class="stop-divider"><span><i class="fa fa-clock-o"></i> <script>document.write(timeConvert(<c:out value='${outbound.layOverTime}' />))</script> layover in ${outbound.toCityName} (${outbound.toAirport})</span></h2>
                        </c:if>
						
						<c:if test="${not empty outbound.eft}">
							<div class="durarow">
                        		<span><i class="fa fa-clock-o"></i> Total Trip Time: <script>document.write(timeConvert(<c:out value='${outbound.eft}' />))</script></span>
                    		</div>
						</c:if>
						
                        </c:forEach>
                    </div>
                    
					</c:forEach>
                </div>
                <div class="traveler-details">
                    <div class="tdhead">
                        <!-- <i class="fa fa-user"></i> --><img src="/resources/images/icons/Ppeople.png" alt="Travelers">&nbsp;&nbsp;Traveler Information
                    </div>
                    <hr>
<style type="text/css">
.tdform .tname { position:relative; }
.tdform .tname .error_text:nth-child(2) { position:absolute; bottom:-12px; left:0; font-size:12px; color:red; font-weight:normal; width:32%; }
.tdform .tname .error_text:last-child { position:absolute; bottom:-12px; right:0; font-size:12px; color:red; font-weight:normal; width:32%; }
.tdform .tgdob { position:relative; }
.tdform .tgdob > .error_text:nth-child(2) { position:absolute; bottom:3px; left:0; font-size:12px; color:red; font-weight:normal; width:32%; }
.tdform .tgdob > .dobform .dob { position:relative; }
.tdform .tgdob > .dobform .dob .error_text:nth-child(2) { position:absolute; bottom:-20px; left:0; font-size:12px; color:red; font-weight:normal; width:32%; }
.tdform .tgdob > .dobform .dob .error_text:nth-child(4) { position:absolute; bottom:-20px; left:34%; font-size:12px; color:red; font-weight:normal; width:32%; }
.tdform .tgdob > .dobform .dob .error_text:last-child { position:absolute; bottom:-20px; right:0; font-size:12px; color:red; font-weight:normal; width:32%; }
@media(max-width:768px){
    .tdform .tname .error_text:nth-child(2) { bottom:unset; top:44px; width:100%; }
    .tdform .tname .error_text:last-child { width:100%; bottom:-1px; }
    .tdform .tgdob > .error_text:nth-child(2) { bottom:unset; top:44px; width:100%; }
}
@media(max-width:370px){
    .tdform .tgdob > .dobform .dob .error_text:nth-child(2) { line-height:8px; }
    .tdform .tgdob > .dobform .dob .error_text:nth-child(4) { line-height:8px; }
    .tdform .tgdob > .dobform .dob .error_text:last-child { line-height:8px; }
}
</style>
					<c:forEach items="${bookingRequest.passengerDetails}" var="passenger" varStatus="indexed">
                    <div class="tdblock">
                        <div>
						<span><c:out value="${indexed.index+1}"/></span>. 
                     <span> <c:if test="${passenger.passengerType == 1}">
                                Adult
								 <form:hidden path="passengerDetails[${indexed.index}].passengerType" value="1"/>
								</c:if>
								 <c:if test="${passenger.passengerType == 2}">
                                Child
								 <form:hidden path="passengerDetails[${indexed.index}].passengerType" value="2"/>
								</c:if>
								 <c:if test="${passenger.passengerType == 3}">
                                Infant (on lap)
								 <form:hidden path="passengerDetails[${indexed.index}].passengerType" value="3"/>
								</c:if>
								 <c:if test="${passenger.passengerType == 4}">
                                Infant (on seat)
								 <form:hidden path="passengerDetails[${indexed.index}].passengerType" value="4"/>
								</c:if></span>
                                <select style="border-color:#e9e9e9;background:#e9e9e9;font-size:14px; padding:1px 5px;letter-spacing:1px;border-radius:4px;margin:0 0 0 10px;outline:none !important;">
                                    <option value="0">Select Title</option>
                                    <option value="1">Mr.</option>
                                    <option value="2">Mrs.</option>
                                    <option value="3">Miss.</option>
                                </select>
						</div>
                        <div class="tdform">
                        
                            <div class="tname">
                                	
				<form:input path="passengerDetails[${indexed.index}].firstName" id="passengerDetails${indexed.index}.firstName" placeholder="First Name" class="form-control textOnly inputfieldset spanishText"  />
									
				<form:input path="passengerDetails[${indexed.index}].middleName" id="passengerDetails${indexed.index}.middleName" placeholder="Middle Name" class="form-control textOnly spanishText"  />
								
                                <form:input path="passengerDetails[${indexed.index}].lastName" id="passengerDetails${indexed.index}.lastName" placeholder="Last Name" class="form-control textOnly inputfieldset spanishText"  />
                                
                            </div>
                            
                            <div class="tgdob">
                                
								<form:select path="passengerDetails[${indexed.index}].Gender" class="form-control gender inputfieldset gendersel">
                        			<c:forEach items="${gender}" var="curCategory" varStatus="loop">
                          				<form:option value="${loop.index}">${curCategory}</form:option>
                        			</c:forEach>
                      			</form:select>
                      			
                                <div class="dobform">
                                    <div>Date of Birth</div>
                                    <div class="dob">
                                    
                                        <form:select path="passengerDetails[${indexed.index}].dobDay" id="paxdob${indexed.index}" class="form-control select inputfieldset paxbod"  items="${days}" />
                                        
                      					<form:select  path="passengerDetails[${indexed.index}].dateOfMonth" class="form-control select inputfieldset paxbod" id="paxdom${indexed.index}">
                        					<c:forEach items="${month}" var="curCategory" varStatus="loop">
                          						<option value="${loop.index}">${curCategory}</option>
                        					</c:forEach>
                      					</form:select>
                    					
                                       	<c:if test="${passenger.passengerType == 1}">
                      						<form:select path="passengerDetails[${indexed.index}].dateOfYear" id="paxdoy${indexed.index}" class="form-control select inputfieldset paxbod" items="${year}" />
					                    </c:if>
					                    <c:if test="${passenger.passengerType == 2}">
					                      <form:select path="passengerDetails[${indexed.index}].dateOfYear" id="paxdoy${indexed.index}" class="form-control select inputfieldset paxbod" items="${chyear}" />
					                    </c:if>
					                    <c:if test="${passenger.passengerType == 3}">
					                      <form:select path="passengerDetails[${indexed.index}].dateOfYear" id="paxdoy${indexed.index}" class="form-control select inputfieldset paxbod"  items="${infyear}" />
					                    </c:if>
					                    <c:if test="${passenger.passengerType == 4}">
					                      <form:select path="passengerDetails[${indexed.index}].dateOfYear" id="paxdoy${indexed.index}" class="form-control select inputfieldset paxbod" items="${infyear}" />
					                    </c:if>
					                    
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
					</c:forEach>
                    
                </div>
                <div class="price-details" id="priceblock">
                    <div class="pdhead">
                        <!-- <i class="fa fa-money"></i> --><img src="/resources/images/icons/Pmoney.png" alt="Price">&nbsp;&nbsp;Price Details<span style="color: white;">${bookingRequest.flightResult.fare.markupID} </span>
                    </div>
                    <hr>
                    <div class="person-price">
                        <div class="tpp">
                            <span><span>${bookingRequest.adults}</span> Traveler(s): <span>Adult</span></span>
                            <span>$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.adults * (bookingRequest.flightResult.fare.adultFare+bookingRequest.flightResult.fare.adultTax+bookingRequest.flightResult.fare.adultMarkup)}" /></span>
                        </div>
                        <div class="fcp">
                            <span>Flight Charges per <span>Adult</span> Incl All Taxes & Fees</span>
                            <span>$<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.flightResult.fare.adultFare+bookingRequest.flightResult.fare.adultTax+bookingRequest.flightResult.fare.adultMarkup}" /></span>
                        </div>
                        <%-- <div class="tfp">
                            <span>Taxes & Fees per <span>adult</span></span>
                            <span>$<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.flightResult.fare.adultTax+bookingRequest.flightResult.fare.adultMarkup}" /></span>
                        </div> --%>
                    </div>
                    <hr>
		<c:if test="${bookingRequest.child > 0}">
                    <div class="person-price">
                        <div class="tpp">
                            <span><span>${bookingRequest.child}</span> Traveler(s): <span>Child</span></span>
                            <span>$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.child * (bookingRequest.flightResult.fare.childFare+bookingRequest.flightResult.fare.childTax+bookingRequest.flightResult.fare.childMarkup)}" /></span>
                        </div>
                        <div class="fcp">
                            <span>Flight Charges per <span>Child</span></span>
                            <span>$<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.flightResult.fare.childFare+bookingRequest.flightResult.fare.childTax+bookingRequest.flightResult.fare.childMarkup}" /></span>
                        </div>
                        <%-- <div class="tfp">
                            <span>Taxes & Fees per <span>Child</span> Incl All Taxes & Fees</span>
                            <span>$<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.flightResult.fare.childTax+bookingRequest.flightResult.fare.childMarkup}" /></span>
                        </div> --%>
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
                        <%-- <div class="tfp">
                            <span>Taxes & Fees per <span>Infant(lap)</span></span>
                            <span>$<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.flightResult.fare.infantTax+bookingRequest.flightResult.fare.infantMarkup}" /></span>
                        </div> --%>
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
                            <span>Flight Charges per <span>Infant(ws)</span></span>
                            <span>$<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.flightResult.fare.infantWsFare+bookingRequest.flightResult.fare.infantWsTax+bookingRequest.flightResult.fare.infantWsMarkup}" /></span>
                        </div>
                        <%-- <div class="tfp">
                            <span>Taxes & Fees per <span>Infant(ws)</span></span>
                            <span>$<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.flightResult.fare.infantWsTax+bookingRequest.flightResult.fare.infantWsMarkup}" /></span>
                        </div> --%>
                    </div>
					<hr>
					</c:if>
                    <div class="total-price">
                        <span>Total Price:</span><span>$<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.flightResult.fare.grandTotal}" /></span>
                    </div>
                    <p>NOTE: All Fares displayed are quoted in USD and inclusive of base fare, taxes and all fees. Additional baggage fees may apply as per the airline policies.</p>
                </div>
                <div class="payment-details">
                    <div class="paydhead"><!-- <i class="fa fa-credit-card"></i> --><img src="/resources/images/icons/Pcredit-card.png" alt="Payment mode">&nbsp;&nbsp;Payment Info</div>
                    <hr>
                    <div class="paydform">
					<div class="card-varients">
                            <div class="card-images">
                                <div><img src="/resources/images/ms.png"></div>
                                <div><img src="/resources/images/visa.png"></div>
                                <div><img src="/resources/images/diners.png"></div>
                                <div><img src="/resources/images/dis.png"></div>
                                <div><img src="/resources/images/ae.png"></div>
                            </div>
                        </div>
<div class="bdform PpayInfoForm">
  <!--  <form:select id="paymentDetails-cardCode" path="paymentDetails.cardCode" class="form-control cardtype" onchange="getcardValue(this,event);" items="${cardtype}" />  -->
  <div>
      <label>Enter Card Number</label>
      <form:hidden path="paymentDetails.cardCode" id="paymentDetails-cardCode" value="Visa" /> 
       <form:input id="paymentDetails_MaskCardNumber" path="paymentDetails.maskCardNumber" class="rkap form-control text-box numbersOnly numbersastseveOnly card-type" placeholder="Credit/Debit Card No." style="background-image:none;" maxlength="16" />
  </div>
    <div>
        <label>Enter Holder's Name</label>
        <form:hidden id="paymentDetails_CardNumber" path="paymentDetails.cardNumber" name="Payments.CardNumber" />
        <form:input id="paymentDetails_cardHolderName" path="paymentDetails.cardHolderName" class="rkap form-control textOnly" placeholder="Card Holder's Name"  />
    </div>
	
  
    <div class="expirydate">
        <label>Expiration Date</label>
         <form:select path="paymentDetails.expiryMonth" id="paymentDetails_ExpiryMonth"   class="rkap2 form-control">
    <c:forEach items="${cardMonth}" var="curExp" varStatus="loop">
      <option value="${loop.index}">${curExp}</option>
    </c:forEach>
  </form:select>
        <form:select id="paymentDetails_ExpiryYear" path="paymentDetails.expiryYear" items="${cardyear}" class="rkap2 form-control" />
        <form:password id="paymentDetails_CvvNo" path="paymentDetails.cvvNo" class="form-control rkap3 numbersOnly" placeholder="Card Verification No." maxlength="4" />
    </div>
   
</div>
                </div></div>
                <div class="billing-details">
                    <div class="bdhead"><!-- <i class="fa fa-files-o"></i> --><img src="/resources/images/icons/Pinvoice.png" alt="Invoice">&nbsp;&nbsp;Billing Information <span class="headsubinfo"> (As per bank records Or credit card company)</span></div>
                    <hr>
                    <div class="bdform">
                        <form:input path="paymentDetails.address1" id="paymentDetails_address1" class="form-control addressOnly" placeholder="Address" />
                       <form:input path="paymentDetails.address2" id="paymentDetails_address2" class="form-control addressOnly" placeholder="Near by Address" />
                       <form:input path="paymentDetails.city" id="paymentDetails_city" class="form-control text-box textOnly" placeholder="City/ Town" />
                       <form:select path="paymentDetails.country" id="paymentDetails_Country" class="form-control" ng-options="opt.Name for opt in countryList track by opt.ID" ng-model="selectedCountry" >
                   
                  </form:select>
                         <div id="stateInp" ng-hide="IsHidden">
                    <form:input path="paymentDetails.state" id="paymentDetails_state1" class="form-control" placeholder="State/ Province"/>
                  </div>
                  <div id="stateSel" ng-hide="IsShow">
                    <form:select path="paymentDetails.state" id="paymentDetails_state2" class="rkap4 form-control" ng-options="opt.Name for opt in usState track by opt.ID" ng-model="selectedItem"> </form:select>
                  </div>
                        <form:input path="paymentDetails.postalCode" id="paymentDetails_postalCode" class="form-control text-box card_type col-xs-12" placeholder="Postal/Zip Code"/>
                    </div>
                </div>
                <div class="ccc-details">
                    <div class="cccdhead"><!-- <i class="fa fa-credit-card"></i> --><img src="/resources/images/icons/Pcredit-card.png" alt="Payment mode">&nbsp;&nbsp;Credit Card Contact Information</div>
                    <hr>
                    <div class="cccdform">
                        <form:input path="phoneNo" id="phoneNo" minlength="10"  maxlength="15" class="form-control numbersOnly" placeholder="Billing Phone"  />
                         <form:input path="mobileNo" id="mobileNo" minlength="10" maxlength="15" class="form-control numbersOnly" placeholder="Mobile Phone"  />
                        <form:input path="emailID" id="emailID" class="form-control" placeholder="Email"/>
                        <form:input path="emailID1" id="emailID1" class="form-control" placeholder="Retype Email"/>
                    </div>
                </div>
                <div class="pr-details">
                    <div class="prdhead"><!-- <i class="fa fa-shield"></i> --><img src="/resources/images/icons/Pinsurance.png" alt="Policies">&nbsp;&nbsp;Policies & Review</div>
                    <hr>
                    <div class="prdcontent">
                        <div class="i-button">
                            Please confirm that the <b>date(s)</b> and <b>time(s)</b> of flights and <b>name(s)</b> of travelers are accurate.
                            <br>
                            <b>Each traveler's name and date of birth must be exactly as shown on the passport or other government-issued photo ID to be used on this trip.</b>
                        </div>
                       <!-- <div class="traveler-name">
                            <div class="tn-item">Traveler 1: <b> &nbsp;N/A</b></div>
                            <div class="tn-item">Traveler 2: <b> &nbsp;N/A</b></div>
                            <div class="tn-item">Traveler 3: <b> &nbsp;N/A</b></div>
                        </div> -->
                        <div class="terms-policies">
                            Tickets are non-transferable and name changes are not permitted. Total price shown includes all applicable <a href="javascript:void(window.open('/taxes-fees', '_blank', 'width=600,height=750,scrollbars=yes'));">taxes & fees</a> and our service fees. 
                            Some airlines may charge additional baggage fees or other fees. Fares are not guaranteed until ticketed.
                                Tickets and our fees are non-refundable (see Fare Rules). Some taxes and government agency fees may be non-refundable. 
                                Date and routing changes will be subject to airline penalties and our fees. 
                        </div>
                        <div class="submit-details">
                            <label>
                                <input type="checkbox" name="agree" id="iagree">
                                <div class="cb">
                                    <div class="checkmark"></div>
                                    <p style="font-size: 14px;"> By clicking Book Now, I agree that I have read and accepted Ebooktrip.com <a class="tcshow">Terms and Conditions</a> and <a class="ppshow">Privacy Policy</a></p>
                                </div>
                            </label>
                            <button type="submit" onClick="confirmFlight();" id="candbb" disabled>Confirm & Book</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="ad-block">
                <div class="sa-item">
                    You may book in the next <b>20 minutes</b> as this page will then refresh.
                </div>
                <div class="sa-item">
                    <div class="sa-head">Secure SSL Booking</div>
                    <hr>
                    <div class="sa-row"><img src="/resources/images/mcafee.png"><span>Ebooktrip has passed McAfee SECURE's daily security scan</span></div>
                    <div class="sa-row"><img src="/resources/images/norton.png"><span>Your booking is SSL secured & encrypted by DigiCert</span></div>
                </div>
                <div class="sa-item">
                    <div class="sa-head">Book with <img src="/resources/images/logo.png"></div>
                    <hr>
                    <div class="sa-row"><i class="fa fa-check"></i><span> Travel Industry Award Winner</span></div>
                    <div class="sa-row"><i class="fa fa-check"></i><span> IATAN, ARC, ASTA Member</span></div>
                    <div class="sa-row"><i class="fa fa-check"></i><span> Travel Weekly Power List</span></div>
                </div>
            </div>
        </div>
        </form:form>
        <div class="terms-screen-overlay">
            <div class="terms-and-conditions">
                <div class="t-and-c-close"><h5>TERMS AND CONDITIONS</h5><i class="fa fa-close"></i></div>
                <div class="t-and-c-of">
                    <p>
                        These Terms and Conditions, together with any other written information we brought to your attention during the process of confirming your booking, 
                        apply to your booking Trading as Ebooktrip. Please read the Terms and Conditions carefully prior to utilising Ebooktrip website and making any bookings. 
                        You consent to the Terms and Conditions when you use the Site, without qualification. 
                        If you do not agree with any portion of the Terms and Conditions, you cannot utilise the website in any method or make a booking.
                    </p>
                    <p>
                        All communications concerning customer service or your booking needs to be sent to Ebooktrip, 4208, 198th st, SW, suite 203 Lynnwood, wa, 98036 or drop an email to:
                        <a href="mailto:support@ebooktrip.com">support@ebooktrip.com</a>
                    </p>
                    <h6>CONTRACT</h6>
                    <p>
                        When making your reservation we, as a representative, would organise it for you to come into an agreement with the principal(s) or other supplier(s) such as tour operator / airline / cruise firm / lodging firm etc. as mentioned on your receipt(s). We could reserve you a holiday deal, in which instance you would hold one agreement with the principal,
                        or we could reserve the services that make up your trip with various principals or suppliers, in which instance you would have different agreements with every one of them.
                    </p>
                    <p>
                        As a representative, we take no accountability for the actions or cuts of the principal(s) or supplier(s) or for the services offered by them. 
                        The principal�s(s�) or supplier�s(s�) Terms & Conditions would relate to your reservation and we suggest that you read them cautiously as they do hold significant details about your reservations. Kindly request for copies of these if you do not possess them.
                    </p>
                    <h6>BOOKING</h6>
                    <p>
                        Passengers must make sure that all the names and timings are accurate as per their passports and that the travel itinerary is correct. Changes might not be allowed after the tickets are provided and alterations may incur additional charges.
                    </p>
                    <p>
                        During a booking, all details will be read back to you and the respective details will be confirmed with the principal(s) or the supplier(s). On receipt of all travel documents please check whether the details such as names, dates and timings are accurate and advise us immediately if any revisions to be done. 
                        Also, please be noted that all the tickets supplied are non-refundable, non-changeable and non-transferable unless otherwise stated.
                    </p>
                    <p>The booking information that you provide to us will be passed on only to the relevant suppliers of your travel arrangements or other particular persons who are a part of the provision of your travel 
                        arrangements. Further, if required by any authorities, or as required by law, the information may be provided to public authorities such as customs or immigration. 
                        This applies to any sensitive information that you provide such as details of any disabilities, or dietary and religious requirements. Certain information may also be passed on to security 
                        or credit checking companies. If you are travelling to the United States, the US Customs and Border Protection will receive this information for the purposes of preventing and combating 
                        terrorism and other transnational serious crimes. If you travel outside the European Economic Area, controls on data protection may not be as strong as the legal requirements in this country. 
                        If we cannot pass this information to the relevant suppliers, whether in the EEA or not, we will be unable to provide your booking. In making this booking, you consent to this information 
                        being passed on to the relevant persons. Full details of our data protection policy are available upon request.
                    </p>
                    <p>Airfares are promised upon ticketing only. If there would be any problem with the payment, we would inform you as soon as possible via email and/or phone. Otherwise, we would send you the ticket within 48 hours of your booking with us.</p>
                    <p>The free baggage allowance offered to the passenger differs based on the route, class/cabin seating and as per the norms of the Individual airline. Airlines might charge an extra fee for checked-in baggage, additional baggage or other voluntary services. Please contact the airlines straight for the most current updates concerning the baggage payment, weight and sizes of the bags.
                    </p>
                    <p>Passengers need to be at the airport 3 hours prior to the departure as tickets could not be refunded or changed because of a no show at the airport.</p>
                    <p>Passengers are held accountable for all their travel documentation plus visas. Visas might be needed for the whole journey both for the destination and/or transit. Visas need to be acquired prior to the ticket been issued.</p>
                    <h6>PAYMENT</h6>
                    <p>Customers are required to pay an instalment or the whole amount at the time of booking. If only a part payment is made, the balance has to be paid on or before the stipulated due date. Failing to do so may result in cancellation of the booking by the principal(s) or supplier(s). This may involve cancellation fees set out in their Terms and Conditions. Unless otherwise mentioned in the booking
                        conditions or advised all the amount paid for the bookings will be held on behalf of the principal(s) or supplier(s) concerned.
                    </p>
                </div>
            </div>
        </div>
        <div class="policy-screen-overlay">
            <div class="privacy-and-policy">
                <div class="p-and-p-close"><h5>PRIVACY AND POLICY</h5><i class="fa fa-close"></i></div>
                <div class="p-and-p-of">
                    <p>
                        This Privacy Notice sets out how Ebooktrip, 
                        registered at 4208, 198th st, SW, suite 203 Lynnwood, wa, 98036 and its associated trading names, protects the privacy of your personal information.
                    </p>
                    <p>
                        We recognise and acknowledge the importance of your personal data and are committed to respecting your privacy and protecting your personal information.
                    </p>
                    <b>
                        1. What information do we collect and why?
                    </b>
                    <p>
                        We need to collect, use and disclose personal information to perform our duties as a travel agent, namely, making and managing travel bookings on behalf of our customers. During the course of our relationship we may collect the following:
                    </p>
                    <p>
                        a. <b>Personal and contact details</b>, such as title, full name, contact details (address, telephone and email address)
                    </p>
                    <p>
                        b. <b>Passport number</b>, date of birth and nationality - if required by the respective airline
                    </p>
                    <p>c. <b>Payment information:</b> card number, security number, expiration date and cardholder name</p>
                    <p>d. <b>Frequent flyer numbers</b>, car rental programme and hotel room preferences (if applicable)</p>
                    <p>e. <b>Dietary requirements and health issues</b> (if any) relevant to your travel arrangements or required by the relevant travel service provider(s) (e.g. accommodation or tour providers).</p>
                    <p>f. <b>Information provided</b> by filling forms on our website e.g. email address, where you heard about us and your travel preferences. This information will be used to keep you up to date with all our latest offers and products</p>
                    <p>g. <b>Call recordings</b> - calls may be recorded for the purposes of quality control and staff training</p>
                    <p>h. <b>Social media</b> - by interacting with the social media features on our website (Facebook, Twitter or Instagram) you will be bound by the privacy policies of the respective social media companies</p>
                    <p>i. <b>IP address and cookies</b> - When you access our website our servers may record data regarding your device and the network you are using to connect with us, including your IP address</p>
                </div>
            </div>
        </div>
        <!-- <div class="footer-container">
            <div class="footer2">
                <p style="text-align:center;margin:5px 0;">&copy 2020 All Rights Reserved Ebooktrip.com</p>
            </div>
            <div class="footer-icons">
            </div>            
        </div> -->
        <jsp:include page="footer2.jsp" />
        <div class="youpay">
            <div class="ypr">
                <span>You Pay</span>
                <a href="#priceblock">+ View Detail</a>
                <span>$<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.flightResult.fare.grandTotal}" /></span>
            </div>
        </div>
    </body>
   <script>
       $(".t-and-c-close i").click(function(){
           $(".terms-screen-overlay").hide();
       });
       $(".tcshow").click(function(){
           $(".terms-screen-overlay").css("display","flex");
       });
       $(".p-and-p-close i").click(function(){
           $(".policy-screen-overlay").hide();
       });
       $(".ppshow").click(function(){
           $(".policy-screen-overlay").css("display","flex");
       });
       $('#iagree').click(function(){
    	if($(this).is(':checked')){
           $('#candbb').attr("disabled", false);
           } 
        else{
        $('#candbb').attr("disabled", true);
           }
	});
   </script>
	<script>
		function timeConvert(n) {
			var num = n;
			var hours = (num / 60);
			var rhours = Math.floor(hours);
			var minutes = (hours - rhours) * 60;
			var rminutes = Math.round(minutes);
			return rhours + " h " + rminutes + " m";
		}
		
		function getCabin(id){
				var cabin = "Economy";
				if(id == 1){
					cabin = "Economy";
				}
				else if(id == 2){
					cabin = "Premium Economy";
				}
				else if(id == 3){
					cabin = "Business";
				}
				else if(id == 4){
					cabin = "First";
				}
				return cabin;
		}
setTimeout(function(){
    location.reload();
}, 1000 * 60 * 20)
		</script>
</html>