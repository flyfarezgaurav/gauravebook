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
		<script src="/resources/scripts/payment/traveller.js?30102022"></script>
		<script src="/resources/scripts/ancillaries.js?04022023"></script>
		<style>
		.has-error{border: 1px solid red !important;}
        .dob .has-error{border: 0 !important;}
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

.mobilePriceBox { display:none; }
@media(max-width: 767px){
    .mobilePriceBox { display: block; }
    .desktopPriceBox { display:none; }
}

.trvlProt .checkMark.checkMark_ { width: 60% }
.priceDrop>div .pricedropP { display: flex; align-items: center; flex-wrap:wrap; }
.priceDrop>div .pricedropP > div { width: 40%; display: inline-flex; justify-content: center; }
.trvlProt .checkMark.checkMark_ li { width:100%; }
.priceDrop>div .pricedropP > div span {     font-weight: bold; font-size: 18px; }
.proAddProd { align-items:center; width:100%; display:flex; justify-content:space-between; padding:10px 25px 20px; }
.proAddProd button { background:#063D99; color:white; box-shadow:none; outline:none; padding:8px 30px 8px; border:0; border-radius:4px; }
.proAddProd button:hover { background:#002a70 }
@media(max-width: 767px){
    .trvlProt .checkMark.checkMark_ { width: 100%; }
    .priceDrop>div .pricedropP > div { width:100%; justify-content:flex-start; padding:0 0 0 20px }
}

.trvlProt { display:flex; width: 100%; align-items: baseline; padding: 0 25px 0; }
.trvlProt>div { width: 100% }
.trvlProt>img {     position: relative; top: 15px; }
.trvlProt .cccdhead p { color: #999999; font-weight:normal; font-size:14px; margin-bottom:0; }
.trvlProt .checkMark { list-style-type: none;  display: flex; flex-wrap: wrap; padding: 0 0 0 20px; margin: 30px 0 0; }
.trvlProt .checkMark li { background: url(/resources/images/icons/check-mark.png) top left no-repeat; width:50%; position:relative; padding:0 0 0 30px; background-size:20px; margin:0 0 15px 0; }
.addtrvlProt { padding:0 25px 0; margin:0 0 20px 0; }
.addtrvlProt>div { display:flex; align-items:baseline; padding:12px 20px 12px; border-radius:4px; border:1px solid #d5d5d5; margin:15px 0 0; }
.addtrvlProt>div>input { width:18px; height:18px; position:relative; top:3px; }
.addtrvlProt>div>div { padding:0 0 0 12px; }
.addtrvlProt>div>div label, .addtrvlProt>div>div p { margin:0; }
@media(max-width: 767px){
    .trvlProt .checkMark { margin:25px 0 0; }
    .trvlProt .checkMark li { font-size: 14px; background-size:16px; padding: 0 0 0 20px; width: 100% }
}

.tdform .tname { position:relative; }
.tdform .tname > div.lableUpOnFocus { width:32%; margin:5px 0; }
/*.tdform .tname .error_text { position:absolute; bottom:-12px; left:0; font-size:12px; color:red; font-weight:normal; width:32%; }*/
.tdform .error_text { position:absolute; bottom:-16px; right:0; font-size:11px; color:red; font-weight:normal; width:100%; }
.tdform .tgdob { position:relative; }
.tdform .tgdob > .error_text { position:absolute; bottom:3px; left:0; font-size:12px; color:red; font-weight:normal; width:32%; }
.tdform .tgdob > .dobform .dob { position:relative; }
.tdform .tgdob > .dobform .dob .error_text { position:absolute; bottom:-20px; left:0; font-size:12px; color:red; font-weight:normal; width:32%; }
.tdform .tgdob > .dobform .dob .error_text { position:absolute; bottom:-20px; left:34%; font-size:12px; color:red; font-weight:normal; width:32%; }
.tdform .tgdob > .dobform .dob .error_text { position:absolute; bottom:-20px; right:0; font-size:12px; color:red; font-weight:normal; width:32%; }
.not_focus_input { position: absolute; width:100%; pointer-events: none; /*background:#103555; color:#fff;*/ font-weight:normal; font-size:11px; top: 0; left: 0; padding: 5px 5px 5px 10px; letter-spacing:0.5px; text-align: left;overflow: hidden; transition: all .5s; -webkit-transition: all .5s; }
.not_focus_input.apart_labl { color: #000!important; background: 0 0; pointer-events: none; top:8px; font-size: 13px; font-weight:normal; padding: 6px 0 6px 15px; transition: all .5s; -webkit-transition: all .5s; }
.bdform .not_focus_input.apart_labl { /*top:10px;*/ }
.lableUpOnFocus { position:relative; margin:15px 0 0; width:32% }
.traveler-details .lableUpOnFocus.T_title, .traveler-details .lableUpOnFocus.T_mname { width:calc(17% - 10px) }
.traveler-details .lableUpOnFocus.T_fname, .traveler-details .lableUpOnFocus.T_lname { width:calc(33% - 10px); margin-left:13.33px; }
.traveler-details .lableUpOnFocus.T_title select { margin:0; padding-top:20px; font-size:13px; font-weight:600; padding-left:5px; }
.traveler-details .lableUpOnFocus.T_mname { margin-left:13.33px; }
.traveler-details .lableUpOnFocus.T_gender { width:calc(17% - 10px) }
.errorImg { display:none; position:absolute; right:7px; top:14px; pointer-events:none }
select + .errorImg, .dobform .errorImg { right:18px; }
.T_gender .errorImg { right:18px; top:32px; }
.errorImg.active { display:block; }
.errorImg.active.error img:first-child, .errorImg.active.check img:last-child { display:none; }
.errorImg.active.error img:last-child, .errorImg.active.check img:first-child { display:block; }
@media(max-width:768px){
    .tdform .tname .error_text { bottom:unset; top:44px; width:100%; }
    .tdform .tname .error_text { width:100%; bottom:-1px; }
    .tdform .tgdob > .error_text { bottom:unset; top:44px; width:100%; }
    .lableUpOnFocus { width:48%; margin:20px 0 0; }
    .billing-details .lableUpOnFocus { margin:10px 0 0; }
    .gender { margin-top:0 !important; }
    .gender + .error_text, .lName + .error_text { bottom:-3px; }
    .traveler-details .lableUpOnFocus.T_title, .traveler-details .lableUpOnFocus.T_mname, .traveler-details .lableUpOnFocus.T_fname { width:calc(33.33% - 10px); }
    .traveler-details .lableUpOnFocus.T_mname, .traveler-details .lableUpOnFocus.T_fname { margin-left:15px; }
    .traveler-details .lableUpOnFocus.T_gender { width:calc(50% - 7.5px); margin-left:15px; }
    .traveler-details .lableUpOnFocus.T_lname { width:calc(50% - 7.5px); margin-left:0; }
}
@media(max-width:500px){
    .traveler-details .lableUpOnFocus.T_title, .traveler-details .lableUpOnFocus.T_fname, .traveler-details .lableUpOnFocus.T_mname { width:calc(50% - 7.5px); }
    .traveler-details .lableUpOnFocus.T_mname { margin-left:0; }
    .traveler-details .lableUpOnFocus.T_lname { margin-left:15px; }
    .traveler-details .lableUpOnFocus.T_gender { width:100%; margin-left:0; }
}
@media(max-width:370px){
    .tdform .tgdob > .dobform .dob .error_text { line-height:8px; }
    .tdform .tgdob > .dobform .dob .error_text { line-height:8px; }
    .tdform .tgdob > .dobform .dob .error_text { line-height:8px; }
}

</style>
		
		  
<script>
function goBack() {
  // window.history.back();
    var path = window.location.origin;

    var rndId = $('#sessionId').val();
    var url = path + "/flight-listing/" + rndId + "";

    var encodedUrl = decodeURIComponent(url);
    $(location).attr("href", encodedUrl);
}
</script>
<link rel="stylesheet" href="/resources/css/payment.css?2052023" type="text/css">
    <jsp:include page="../../tag-manager-head.jsp" />

<script>
gtag('event', view_item, {
'send_to': 'GF-902',
'value': '${bookingRequest.flightResult.fare.grandTotal}',
'currency': 'USD'
});
</script>
    

</head>
    <body ng-controller="flightPaymentCntrl">
    <jsp:include page="../../tag-manager-body.jsp" />
        <!--Header Area Starts Here-->
        <div class="header-container">
            <div class="header">
                <div class="logo-fh">
                    <a href="/"><img src="/resources/images/logo.png" alt="logo"></a>
                </div>
                <div class="navbar-main">
                    <div class="expert-talk">
                        <a href="tel:+1-800-404-0025"><span class="call-icon"><img src="/resources/images/customer-care-img.png" alt="phonek" width="5" height="5" loading="lazy" decoding="async"> </span><span class="topcall-text-sec"> 
                            <span class="topcall-text">Get Customer Support:</span>
                            +1-800-404-0025</span>
                        </a>
                     </div>

                </div>
                <div class="side-navbar-button" style="display: none;">
                    <button type="button" onclick="showsidenav()"><i class="fa fa-bars"></i></button>
                </div>
            </div>
        </div>
        <div class="side-navbar" id="sidenavbar">
            <li><button type="button" onclick="hidesidenav()"><i class="fa fa-close"></i></button></li>
            <li><a href="/contactus">Contact Us</a></li>
			<li><a href="/terms-and-conditions">Terms & Conditions</a></li>
			<li><a href="/privacy-policy">Privacy Policy</a></li>
            <p>Copyright &copy;  2021 - 2023, Ebooktrip. All rights reserved</p>
        </div>
        <div class="screen-overlay" id="screenoverlay" onclick="hidesidenav();"></div>
        <div id="screenoverlay2" onclick="enginehide();"></div>
        <div class="backbtnrow mycontainer">
            <button type="button" onclick="goBack();" style="border-radius:3px"><i class="fa fa-long-arrow-left" aria-hidden="true"></i>&nbsp;&nbsp; Go Back</button>
        </div>
		<fmt:setLocale value="en_US" scope="session"/>
		
		<form:form method="POST" action="/payment/billing/${bookingRequest.searchID}/${bookingRequest.flightResult.resultID}" id="bookingRequest" modelAttribute="bookingWrapper" novalidate="novalidate">
		<input type="hidden" id="sessionId" value="${bookingRequest.searchID}">
		<input type="hidden" id="resultID" value="${bookingRequest.flightResult.resultID}">
		
        <div class="ftpdetails mycontainer">
            <div class="ft-block">
				
				<c:if test="${bookingRequest.isPriceChange==true}">
				<div class="flight-details sa-item" style="background:#FFFFE0;border-style: solid;border-color: yellow;">
					<c:set var="totalPrice" value="${bookingRequest.flightResult.fare.grandTotal/(bookingRequest.adults+bookingRequest.child+bookingRequest.infants+bookingRequest.infantsWs)}" scope="request" />
							<div style="text-align:center;font-weight:500;margin:10px;">We're sorry! The fare you selected has been updated by the Airlines.</div>
							<div style="text-align:center;font-weight:500;margin:10px;">Sometimes this can happen when inventory changes quickly or airlines is updating its database.</div>
							<div style="text-align:center;font-weight:500;margin:10px;">The new price including all Taxes and Fees per passenger is <b style="color:#da2000;">$<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${totalPrice}" /></b>. 
								Please continue with the </div>
							<div style="text-align:center;font-weight:500;margin:10px;">booking below or <a href="/">Click here</a> to find an alternative flight.</div>
				</div>
				</c:if>
				<c:if test="${bookingRequest.getSourceMedia() == 'google'}">
				 <div class="flight-details sa-item" style="background:#FFFFE0;border-style: solid;border-color: yellow;">
							<div style="text-align:center;font-weight:500;margin:10px; color:red;">${message}</div>				
				</div>
               </c:if>
				<div class="clearfix"></div>
				
                <div class="flight-details bgblue">
                    <div class="fdhead">
                        <!-- <i class="fa fa-plane"></i> --><img src="/resources/images/icons/Pplane-white.png" alt="Plane">&nbsp;&nbsp;Flight Details
                    </div>
                  
                    <div class="departure">
                        <div class="deprow">
                            <span>Departure</span>
                            <a href="#"><i class="fa fa-briefcase"></i>&nbspBaggage Fees</a>
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
                            <div class="cwdetails">
                            	<span class="wayd">Non Stop</span>
                            	<span class="classd">
                            		<c:choose>
                            			<c:when test="${not empty bookingRequest.fareFamily}">${bookingRequest.fareFamily[0].fareFamilyDescription[0].description}</c:when>
                            			<c:otherwise><script>document.write(getCabin(<c:out value='${outbound.cabinClass}' />))</script></c:otherwise>
                            		</c:choose>
                            	</span>
                            	</div>
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
                            <div class="cwdetails">
                            	<span class="wayd">Non Stop</span>
                            	<span class="classd">
                            		<c:choose>
                            			<c:when test="${not empty bookingRequest.fareFamily}">${bookingRequest.fareFamily[0].fareFamilyDescription[0].description}</c:when>
                            			<c:otherwise><script>document.write(getCabin(<c:out value='${inbound.cabinClass}' />))</script></c:otherwise>
                            		</c:choose>
                            	</span>
                            </div>
                            <div class="fdetails2"><img src="/resources/images/airline-logo/${inbound.airline}.png">&nbsp&nbsp<div><span class="fliname">${inbound.airlineName}</span><span class="flinum">Flight ${inbound.flightNo}</span></div></div>
                        </div>
                        
                        <c:if test="${not empty inbound.layOverTime && inbound.layOverTime > 0}">
                        	<h2 class="stop-divider"><span><i class="fa fa-clock-o"></i> <script>document.write(timeConvert(<c:out value='${inbound.layOverTime}' />))</script> layover in ${inbound.toCityName} (${inbound.toAirport})</span></h2>
                        </c:if>
                        
                        </c:forEach>
                    </div>
                    
					
                    <c:if test="${bookingRequest.flightResult.inBound != null}">
                    	<div class="durarow">
                        	<span><i class="fa fa-clock-o"></i> Total Trip Time: <script>document.write(timeConvert(<c:out value='${bookingRequest.flightResult.inEFT}' />))</script></span>
                    	</div>
					</c:if>
					
					<c:forEach var="outbound" items="${bookingRequest.flightResult.otherBound}">
					<div class="departure">
                        <div class="deprow">
                            <span>Departure</span>
                            <a href="#"><i class="fa fa-briefcase"></i>&nbspBaggage Fees</a>
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
                            
                            <div class="cwdetails">
                            	<span class="wayd">Non Stop</span>
                            	<span class="classd">
                            		<c:choose>
                            			<c:when test="${not empty bookingRequest.fareFamily}">${bookingRequest.fareFamily[0].fareFamilyDescription[0].description}</c:when>
                            			<c:otherwise><script>document.write(getCabin(<c:out value='${outbound.cabinClass}' />))</script></c:otherwise>
                            		</c:choose>
                            	</span>
                            </div>
                            
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

		
		
                <div class="traveler-details bgblue">
                    <div class="tdhead">
                        <!-- <i class="fa fa-user"></i> --><img src="/resources/images/icons/Ppeople-white.png" alt="Ppeople-white">&nbsp;&nbsp;Traveler Information
                    </div>
             

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
                                <!-- <select style="border-color:#e9e9e9;background:#e9e9e9;font-size:14px; padding:1px 5px;letter-spacing:1px;border-radius:4px;margin:0 0 0 10px;outline:none !important;">
                                    <option value="0">Select Title</option>
                                    <option value="1">Mr.</option>
                                    <option value="2">Mrs.</option>
                                    <option value="3">Miss.</option>
                                </select> -->
						</div>
                        <div class="tdform">
                        
                            <!-- <div class="tname"> -->
                                <div class="lableUpOnFocus T_title">
                                    <label class="not_focus_input">Title<span class="astrick">*</span></label>
                                    <select id="id_T_title${indexed.index}" class="gender form-control focus_input" onchange="checkval(`id_T_title${indexed.index}`,'select','id')">
                                        <option value="0">Select</option>
                                        <option value="1">Mr.</option>
                                        <option value="2">Mrs.</option>
                                        <option value="3">Miss.</option>
                                    </select>
                                    <span class="errorImg">
                                        <img src="/resources/images/icons/tick.png" alt="tick">
                                        <img src="/resources/images/icons/warning.png" alt="warning">
                                    </span>
                                </div>
                                <div class="lableUpOnFocus T_fname">
                                    <label class="not_focus_input apart_labl">First Name<span class="astrick">*</span></label>
									<form:input path="passengerDetails[${indexed.index}].firstName" id="passengerDetails${indexed.index}.firstName" placeholder="" class="form-control textOnly inputfieldset focus_input id_T_fname${indexed.index}" onkeyup="checkval(`id_T_fname${indexed.index}`,'input','class')"  />
                                    <span class="errorImg">
                                        <img src="/resources/images/icons/tick.png" alt="tick">
                                        <img src="/resources/images/icons/warning.png" alt="warning">
                                    </span>
								</div>
                                <div class="lableUpOnFocus T_mname">
                                    <label class="not_focus_input apart_labl">Middle Name</label>
									<form:input path="passengerDetails[${indexed.index}].middleName" id="passengerDetails${indexed.index}.middleName" placeholder="" class="form-control textOnly focus_input"  />
								</div>
                                <div class="lableUpOnFocus T_lname">
                                    <label class="not_focus_input apart_labl">Last Name<span class="astrick">*</span></label>
                                	<form:input path="passengerDetails[${indexed.index}].lastName" id="passengerDetails${indexed.index}.lastName" placeholder="" class="form-control textOnly inputfieldset focus_input lName id_T_lname${indexed.index}" onkeyup="checkval(`id_T_lname${indexed.index}`,'input','class')"  />
                                    <span class="errorImg">
                                        <img src="/resources/images/icons/tick.png" alt="tick">
                                        <img src="/resources/images/icons/warning.png" alt="warning">
                                    </span>
                                </div>
                            <!-- </div> -->
                            
                            <!-- <div class="tgdob"> -->
                                <div class="lableUpOnFocus T_gender">
    								<form:select path="passengerDetails[${indexed.index}].Gender" class="form-control gender inputfieldset gendersel focus_input id_T_gender${indexed.index}" onchange="checkval(`id_T_gender${indexed.index}`,'select','class')">
                            			<c:forEach items="${gender}" var="curCategory" varStatus="loop">
                              				<form:option value="${loop.index}">${curCategory}</form:option>
                            			</c:forEach>
                          			</form:select>
                                    <span class="errorImg">
                                        <img src="/resources/images/icons/tick.png" alt="tick">
                                        <img src="/resources/images/icons/warning.png" alt="warning">
                                    </span>
                                </div>
                      			
                                <div class="dobform">
                                    <div>Date of Birth<span class="astrick">*</span></div>
                                    <div class="dob">
                                        <div class="">
                                        <form:select path="passengerDetails[${indexed.index}].dobDay" id="paxdob${indexed.index}" class="form-control select inputfieldset paxbod id_T_day${indexed.index}" onchange="checkval(`id_T_day${indexed.index}`,'select','class')" items="${days}" />
                                        <span class="errorImg">
                                            <img src="/resources/images/icons/tick.png" alt="tick">
                                            <img src="/resources/images/icons/warning.png" alt="warning">
                                        </span>
                                        </div>
                                        <div>
                      					<form:select  path="passengerDetails[${indexed.index}].dateOfMonth" class="form-control select inputfieldset paxbod id_T_month${indexed.index}" id="paxdom${indexed.index}" onchange="checkval(`id_T_month${indexed.index}`,'select','class')">
                        					<c:forEach items="${month}" var="curCategory" varStatus="loop">
                          						<option value="${loop.index}">${curCategory}</option>
                        					</c:forEach>
                      					</form:select>
                                        <span class="errorImg">
                                            <img src="/resources/images/icons/tick.png" alt="tick">
                                            <img src="/resources/images/icons/warning.png" alt="warning">
                                        </span>
                    					</div>
                                       	<c:if test="${passenger.passengerType == 1}">
                                        <div>
                      						<form:select path="passengerDetails[${indexed.index}].dateOfYear" id="paxdoy${indexed.index}" class="form-control select inputfieldset paxbod id_T_year${indexed.index}" items="${year}" onchange="checkval(`id_T_year${indexed.index}`,'select','class')" />
                                            <span class="errorImg">
                                                <img src="/resources/images/icons/tick.png" alt="tick">
                                                <img src="/resources/images/icons/warning.png" alt="warning">
                                            </span>
                                        </div>
					                    </c:if>
					                    <c:if test="${passenger.passengerType == 2}">
                                        <div>
					                      <form:select path="passengerDetails[${indexed.index}].dateOfYear" id="paxdoy${indexed.index}" class="form-control select inputfieldset paxbod id_T_childyear${indexed.index}" items="${chyear}" onchange="checkval(`id_T_childyear${indexed.index}`,'select','class')" />
                                            <span class="errorImg">
                                                <img src="/resources/images/icons/tick.png" alt="tick">
                                                <img src="/resources/images/icons/warning.png" alt="warning">
                                            </span>
                                        </div>
					                    </c:if>
					                    <c:if test="${passenger.passengerType == 3}">
                                        <div>
					                      <form:select path="passengerDetails[${indexed.index}].dateOfYear" id="paxdoy${indexed.index}" class="form-control select inputfieldset paxbod id_T_infyear${indexed.index}"  items="${infyear}" onchange="checkval(`id_T_infyear${indexed.index}`,'select','class')" />
                                              <span class="errorImg">
                                                <img src="/resources/images/icons/tick.png" alt="tick">
                                                <img src="/resources/images/icons/warning.png" alt="warning">
                                            </span>
                                        </div>
					                    </c:if>
					                    <c:if test="${passenger.passengerType == 4}">
                                        <div>
					                      <form:select path="passengerDetails[${indexed.index}].dateOfYear" id="paxdoy${indexed.index}" class="form-control select inputfieldset paxbod id_T_infyear_${indexed.index}" items="${infyear}" onchange="checkval(`id_T_infyear_${indexed.index}`,'select','class')" />
                                              <span class="errorImg">
                                                <img src="/resources/images/icons/tick.png" alt="tick">
                                                <img src="/resources/images/icons/warning.png" alt="warning">
                                            </span>
                                        </div>
					                    </c:if>
					                    
                                    </div>
                                </div>
                            <!-- </div> -->
                        </div>
                    </div>
					</c:forEach>
                    
                </div>
				
				<div class="billing-details bgblue">
                    <div class="bdhead"><img src="/resources/images/icons/Pinvoice-white.png" alt="Invoice">&nbsp;&nbsp;Billing Information <span class="headsubinfo"> </span></div>
                    
                    <div class="bdform">
                        <div class="lableUpOnFocus">
                            <label class="not_focus_input apart_labl">Address<span class="astrick">*</span></label>
                    	    <form:input path="paymentDetails.address1" id="paymentDetails_address1" class="form-control focus_input addressOnly" placeholder="" onkeyup="checkval(`paymentDetails_address1`,'input','id')" />
                            <span class="errorImg">
                                <img src="/resources/images/icons/tick.png" alt="tick">
                                <img src="/resources/images/icons/warning.png" alt="warning">
                            </span>
                        </div>
                        <div class="lableUpOnFocus">
                            <label class="not_focus_input apart_labl">Near by Address</label>
                           	<form:input path="paymentDetails.address2" id="paymentDetails_address2" class="form-control focus_input addressOnly" placeholder="" />
                        </div>
                        <div class="lableUpOnFocus">
                            <label class="not_focus_input apart_labl">City/ Town<span class="astrick">*</span></label>
                           	<form:input path="paymentDetails.city" id="paymentDetails_city" class="form-control text-box focus_input textOnly" placeholder="" onkeyup="checkval(`paymentDetails_city`,'input','id')" />
                            <span class="errorImg">
                                <img src="/resources/images/icons/tick.png" alt="tick">
                                <img src="/resources/images/icons/warning.png" alt="warning">
                            </span>
                        </div>
                        <div class="lableUpOnFocus">
                            <label class="not_focus_input apart_labl">Postal/Zip Code<span class="astrick">*</span></label>
                           	<form:input path="paymentDetails.postalCode" id="paymentDetails_postalCode" class="form-control focus_input text-box card_type col-xs-12" placeholder="" onkeyup="checkval(`paymentDetails_postalCode`,'input','id')"/>
                            <span class="errorImg">
                                <img src="/resources/images/icons/tick.png" alt="tick">
                                <img src="/resources/images/icons/warning.png" alt="warning">
                            </span>
                        </div>
                       	<div class="lableUpOnFocus">
                            <form:select path="paymentDetails.country" id="paymentDetails_Country" class="form-control focus_input" ng-options="opt.Name for opt in countryList track by opt.ID" ng-model="selectedCountry" onchange="checkval(`paymentDetails_Country`,'select','id')" >
                  		    </form:select>
                            <span class="errorImg">
                                <img src="/resources/images/icons/tick.png" alt="tick">
                                <img src="/resources/images/icons/warning.png" alt="warning">
                            </span>
                       	</div>
                       	<div id="stateInp" ng-hide="IsHidden" class="lableUpOnFocus">
                            <label class="not_focus_input apart_labl">State/ Province<span class="astrick">*</span></label>
                    		<form:input path="paymentDetails.state" id="paymentDetails_state1" class="form-control focus_input" placeholder="" onkeyup="checkval(`paymentDetails_state1`,'input','id')" />
                            <span class="errorImg">
                                <img src="/resources/images/icons/tick.png" alt="tick">
                                <img src="/resources/images/icons/warning.png" alt="warning">
                            </span>
                  		</div>
                  		<div id="stateSel" ng-hide="IsShow" class="lableUpOnFocus">
                    		<form:select path="paymentDetails.state" id="paymentDetails_state2" class="rkap4 focus_input form-control" ng-options="opt.Name for opt in usState track by opt.ID" ng-model="selectedItem" onchange="checkval(`paymentDetails_state2`,'select','id')"> </form:select>
                            <span class="errorImg">
                                <img src="/resources/images/icons/tick.png" alt="tick">
                                <img src="/resources/images/icons/warning.png" alt="warning">
                            </span>
                  		</div>
                    </div>
                </div>
                
				<!------ Ancillaries Include----->
				
				<%-- <jsp:include page="ancillaries.jsp" /> --%>
				
				<!------- Ancillaries Include ---->
				
				<!------ Price Drop Start----->
				
				<%-- <jsp:include page="price_drop.jsp" /> --%>
				
				<!------- Price Drop End ---->
      			
                <!------ Price Mobile Start ------>
                
                <c:if test="${searchRequest.device == 'Mobile'}">
                <jsp:include page="price_mobile.jsp" />
                </c:if>
				<!------- Price Mobile End ----------->
				
				<div class="submit-details">
                	<button type="submit" onClick="continueFlight('${bookingRequest.flightResult.resultID}');" id="candbb">Continue To Book</button>
                </div>
                
            </div>
			
            <!---- Price Desktop File Include Strat Here --->
			<c:if test="${searchRequest.device == 'Computer'}">
			 <jsp:include page="price_desktop.jsp" />
			</c:if>
			<!----- Price Desktop File Include End Here ------>
			
        </div>
        </form:form>
        
        
        
        <jsp:include page="../../footer2.jsp" />
        
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
       
       /* $('#iagree').click(function(){
    	if($(this).is(':checked')){
           $('#candbb').attr("disabled", false);
        } 
        else{
        	$('#candbb').attr("disabled", true);
        }
	}); */
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
$(document).ready(function () {
    $(".focus_input").each(function () {
        "" != $(this).val() && $(this).val().length > 3 ? $(this).parent().find(".not_focus_input").removeClass("apart_labl") : $(this).parent().find(".not_focus_input").addClass("apart_labl");
    }),
    $(".focus_input").on("focus keyup", function () {
        $(this).parent().find(".not_focus_input").removeClass("apart_labl");
    }),
    $(".focus_input").on("focusout", function () {
        if ("" != $(this).val() && $(this).val().length > 0) {
            $(this).parent().find(".not_focus_input").removeClass("apart_labl");
            var e = $(this).val();
            console.log("FocusOut: " + e.length), e.length < 1 && ($(this).val(""), $(this).parent().find(".not_focus_input").addClass("apart_labl"));
        } else $(this).parent().find(".not_focus_input").addClass("apart_labl");
    });
    // var loadVal = $("#passengerDetails0.firstName").val();
    // console.log('Hello----',loadVal)
    
});
jQuery(window).load(function () {
    //alert('page is loaded');

    setTimeout(function () {
        //alert('page is loaded and 1 minute has passed');   
        $(".focus_input").each(function () {
            "" != $(this).val() && $(this).val().length > 0 ? $(this).parent().find(".not_focus_input").removeClass("apart_labl") : $(this).parent().find(".not_focus_input").addClass("apart_labl");
        })
    }, 100);

});
function checkval(id,type,type2){
    //console.log(id,type)
    if(type == 'select'){
        if(type2 == 'id'){
            var selectV = $("#"+id).val();
            if(selectV != 0 && selectV != 'Day' && selectV != 'Year'){console.log(selectV)
                $("#"+id+' + .errorImg').addClass('active check').removeClass('error')
            }else{
                $("#"+id+' + .errorImg').addClass('active error').removeClass('check')
            }
        }
        if(type2 == 'class'){
            var selectV_ = $("."+id).val();
            if(selectV_ != 0 && selectV_ != 'Day' && selectV_ != 'Year'){console.log(selectV_,'select class check')
                $("."+id+' + .errorImg').addClass('active check').removeClass('error')
                $("."+id).parent().find('.errorImg').addClass('active check').removeClass('error')
            }else{console.log(selectV_,'select class error')
                $("."+id+' + .errorImg').addClass('active error').removeClass('check')
                $("."+id).parent().find('.errorImg').addClass('active error').removeClass('check')
            }
        }
    }
    if(type == 'input'){
        if(type2 == 'id'){
            var inputV = $("#"+id).val();
            if(inputV.length > 0){
                $("#"+id+' + .errorImg').addClass('active check').removeClass('error')
                $("#"+id).parent().find('.errorImg').addClass('active check').removeClass('error')
            }else{
                $("#"+id+' + .errorImg').addClass('active error').removeClass('check')
                $("#"+id).parent().find('.errorImg').addClass('active error').removeClass('check')
            }
        }
        if(type2 == 'class'){
            var inputV_ = $("."+id).val();
            if(inputV_.length > 0){
                $("."+id+' + .errorImg').addClass('active check').removeClass('error')
                $("."+id).parent().find('.errorImg').addClass('active check').removeClass('error')
            }else{
                $("."+id+' + .errorImg').addClass('active error').removeClass('check')
                $("."+id).parent().find('.errorImg').addClass('active error').removeClass('check')
            }
        }
    }
}
		</script>
</html>