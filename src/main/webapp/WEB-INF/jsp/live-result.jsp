<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html ng-app="FlightApp">
<head>
    <title>Flights Results</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Mukta:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet'>
    <link rel="icon" href="/resources/images/favicon.png">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		
    <style>
        .ee-navbar-items li:nth-child(1) a::after{transform:scaleX(1);}
    </style>
    <link rel="stylesheet" type="text/css" href="/resources/css/ani.css?v=1.0">
	<script src="/resources/scripts/jquery-1.11.1.min.js"></script>
		<script src="/resources/scripts/jquery-ui.js"></script>
		<script src="/resources/scripts/jquery.validate.min.js"></script>
		<script src="/resources/scripts/angular.min.js"></script>
		<script src="/resources/scripts/ng-infinite-scroll.min.js"></script>
     <link rel="stylesheet" href="/resources/css/result.css?hjjh">
<jsp:include page="tag-manager-head.jsp" /></head>
<body ng-controller="FlightCntrl">
<jsp:include page="tag-manager-body.jsp" />
    <!--Header Area Starts Here-->
    <div class="header">
        <div class="logo-fh">
            <a href="/"><img src="/resources/images/logo.png"></a>
        </div>
        <div class="navbar-main">
           <!--  <li><a href="#"><i class="fa fa-user-circle"></i> &nbsp;Sign In&nbsp;<i class="fa fa-angle-down"></i></a></li> -->
            <div class="expert-talk">
            <a href="tel:+1(800)404-0025"><span>Get Customer Support: </span><span> 1-800-404-0025</span></a>
            </div>
        </div>
        <div class="side-navbar-button">
            <button type="button" onclick="showsidenav()"><i class="fa fa-bars"></i></button>
        </div>
    </div>
    <div class="side-navbar" id="sidenavbar">
        <li><button type="button" onclick="hidesidenav()"><i class="fa fa-close"></i></button></li>
       <!-- <li><a href="#">Sign In</a></li>
        <li><a href="#">Register</a></li>
        <li><a href="#">My Bookings</a></li>
        <li><a href="#">Customer Support</a></li>
        <li><a href="#">Track Credit/Refund</a></li> -->
        <li><a href="/contactus">Contact Us</a></li>
        <li><a href="/terms-and-conditions">Terms & Conditions</a></li>
        <li><a href="/privacy-policy">Privacy Policy</a></li>
        <p>Copyright &copy;  2021 - 2022, Ebooktrip. All rights reserved</p>
    </div>
    <div class="screen-overlay" id="screenoverlay" onclick="hidesidenav();"></div>
    <div id="screenoverlay2" onclick="enginehide();"></div>
    <!--Header Ends Here-->
    <!--Engine Area Starts Here-->
	<input type="hidden" value="${flightRequest.searchID}" id="searchID">
	<input type="hidden" value='${bookingRes}' id="liveflightsResult">
   
   <input type="hidden" value="${bookingRequest.searchID}" id="liveSearchId">
	<input type="hidden" value='${bookingRequest.bookingID}' id="liveResultId">
	
    <div class="result-bg">
        
        <div class="result-filter-container">
            <!--Filters Start Here-->
            
            
            <!--Filters End Here-->
		    <div class="results">
                
                <div infinite-scroll="LoadMore()">
				<div class="result-container" ng-repeat="flight in filteredFlights = (flightsResponse.liveflightResult) | limitTo:numberOfResult">
                    <div class="super-saver-deal">
                        <b>Super Saver Fare!</b> Special Low Prices,full flight details available after you book.
                        <div class="deal-off">Deal! $65 off!</div>
                    </div>
                    <div class="result-blocks">
                        <div class="flight-info">
						
                            <div class="flight-info-row">
                                <div class="flight-info-airline">
                                    <img src="/resources/images/airline-logo/{{flight.outBound[0].airline}}.png"> <span>&nbsp;{{getAirlineName(flight.outBound[0].airline)}}</span>
                                </div>
                                <div class="flight-info-daydate">
                                    {{flight.outBound[0].depDate | date:'EEE, MMM dd'}}
									<br><span style="color: #008a04;" ng-if="compareDepartDates(flight.outBound[0].depDate | date:'MM/dd/yyyy')">Alternate Date</span>
                                </div>
                                <div class="flight-info-fromtodura" ng-init="outLength=flight.outBound.length">
                                    <div class="flight-info-from">
                                        <div class="from-time">{{flight.outBound[0].depDate | date:'hh:mm a'}}</div>
                                        <div class="from-city" title="{{getCityName(flight.outBound[0].fromAirport)}}">{{flight.outBound[0].froCityName}}</div>
                                    </div>
                                    <div class="flight-info-durastop">
                                        <div class="flight-duration">{{flight.outEFT | minToHour}}</div>
                                        <div class="flight-stop-graph">
                                            <div class="stop-dot" ng-if="outLength > 1">
                                                <div class="stop-tool">
                                                    <div class="stoplay-head">
                                                        <span>Stop {{outLength-1}}</span>
                                                        <span>Layover Time</span>
                                                    </div>
                                                    <div class="stoplay-val">
                                                        <span title="{{getCityName(flight.outBound[0].toAirport)}}">{{flight.outBound[0].toCityName}}</span>
                                                        <span>{{flight.outBound[0].layOverTime | minToHour}}</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="flight-stop" ng-if="outLength == 1">Non Stop</div>
										<div class="flight-stop" ng-if="outLength > 1">{{outLength-1}} Stop</div>
                                    </div>
                                    <div class="flight-info-to">
                                      <!--  <div class="plus-day">next day</div> -->
                                        <div class="to-time">{{flight.outBound[outLength-1].reachDate | date:'hh:mm a'}}</div>
                                        <div class="to-city" title="{{getCityName(flight.outBound[outLength-1].toAirport)}}">{{flight.outBound[outLength-1].toCityName}}</div>
                                    </div>
                                </div>
                            </div>
							<div class="flight-info-row" ng-if="flight.inBound.length > 0">
                                <div class="flight-info-airline">
                                    <img src="/resources/images/airline-logo/{{flight.inBound[0].airline}}.png"> <span>&nbsp;{{getAirlineName(flight.inBound[0].airline)}}</span>
                                </div>
                                <div class="flight-info-daydate">
                                    {{flight.inBound[0].depDate | date:'EEE, MMM dd'}}
									<br><span style="color: #008a04;" ng-if="compareReturnDates(flight.inBound[0].depDate | date:'MM/dd/yyyy')">Alternate Date</span>
                                </div>
                                <div class="flight-info-fromtodura" ng-init="inLength=flight.inBound.length">
                                    <div class="flight-info-from">
                                        <div class="from-time">{{flight.inBound[0].depDate | date:'hh:mm a'}}</div>
                                        <div class="from-city" title="{{getCityName(flight.inBound[0].fromAirport)}}">{{flight.inBound[0].froCityName}}</div>
                                    </div>
                                    <div class="flight-info-durastop">
                                        <div class="flight-duration">{{flight.inEFT | minToHour}}</div>
                                        <div class="flight-stop-graph">
                                            <div class="stop-dot" ng-if="inLength > 1">
                                                <div class="stop-tool">
                                                    <div class="stoplay-head">
                                                        <span>Stop {{inLength-1}}</span>
                                                        <span>Layover Time</span>
                                                    </div>
                                                    <div class="stoplay-val">
                                                        <span title="{{getCityName(flight.inBound[0].toAirport)}}">{{flight.inBound[0].toCityName}}</span>
                                                        <span>{{flight.inBound[0].layOverTime | minToHour}}</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="flight-stop" ng-if="inLength == 1">Non Stop</div>
										<div class="flight-stop" ng-if="inLength > 1">{{inLength-1}} Stop</div>
                                    </div>
                                    <div class="flight-info-to">
                                        <!--  <div class="plus-day">next day</div> -->
                                        <div class="to-time">{{flight.inBound[inLength-1].reachDate | date:'hh:mm a'}}</div>
                                        <div class="to-city" title="{{getCityName(flight.inBound[inLength-1].toAirport)}}">{{flight.inBound[inLength-1].toCityName}}</div>
                                    </div>
                                </div>
                            </div>
							<div ng-repeat="otherbound in flight.otherBound">
							<div class="flight-info-row">
                                <div class="flight-info-airline">
                                    <img src="/resources/images/airline-logo/{{otherbound[0].airline}}.png"> <span>&nbsp;{{getAirlineName(otherbound[0].airline)}}</span>
                                </div>
                                <div class="flight-info-daydate">
                                    {{otherbound[0].depDate | date:'EEE, MMM dd'}}
                                </div>
                                <div class="flight-info-fromtodura" ng-init="otherlen=otherbound.length">
                                    <div class="flight-info-from">
                                        <div class="from-time">{{otherbound[0].depDate | date:'hh:mm a'}}</div>
                                        <div class="from-city" title="{{getCityName(otherbound[0].fromAirport)}}">{{otherbound[0].froCityName}}</div>
                                    </div>
                                    <div class="flight-info-durastop" ng-init="totalEft=0">
										<div ng-repeat="otherEft in otherbound"><div ng-init="totalEft=totalEft+otherEft.eft">
                                        <div class="flight-duration" ng-if="$last">{{totalEft | minToHour}}</div>
										</div></div>
                                        <div class="flight-stop-graph">
                                            <div class="stop-dot" ng-if="otherlen > 1">
                                                <div class="stop-tool">
                                                    <div class="stoplay-head">
                                                        <span>Stop {{otherlen-1}}</span>
                                                        <span>Layover Time</span>
                                                    </div>
                                                    <div class="stoplay-val">
                                                        <span title="{{getCityName(otherbound[0].toAirport)}}">{{otherbound[0].toCityName}}</span>
                                                        <span>{{otherbound[0].layOverTime | minToHour}}</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="flight-stop" ng-if="otherlen == 1">Non Stop</div>
										<div class="flight-stop" ng-if="otherlen > 1">{{otherlen-1}} Stop</div>
                                    </div>
                                    <div class="flight-info-to">
                                        <!--  <div class="plus-day">next day</div> -->
                                        <div class="to-time">{{otherbound[otherlen-1].reachDate | date:'hh:mm a'}}</div>
                                        <div class="to-city" title="{{getCityName(otherbound[otherlen-1].toAirport)}}">{{otherbound[otherlen-1].toCityName}}</div>
                                    </div>
                                </div>
                            </div>
							</div>
							
                        </div>
                        <div class="vertical-line"></div>
                        <div class="flight-price-select">
                            <div><span ng-click="likeLink(flight.resultID,'x');" style="cursor:pointer;"><!-- {{flight.consId}} --><img ng-if=" 1 != flight.consId" style="height: 36px;" src="/resources/images/Like-white.png">
                            <img ng-if="1 == flight.consId" src="/resources/images/Like-red.png" style="height: 36px;"></span>
                            <div class="flight-price">{{(flight.fare.grandTotal) | currency:'$':2}}</div>
                            <div class="flight-ppp">Total Price (incl. taxes & fees)</div>
                            </div>
                            <button type="button" ng-click="paymentPage(flight.resultID);">Select <i class="fa fa-angle-right"></i></button>
                        </div>
                    </div>
                    <div class="flight-detail-button" style="display:flex;justify-content:space-between;align-items:center;" >
                        <div class="flight-detail-show" ng-click="showFlightDetails($index);">Flight Details <i class="fa fa-angle-down rotate-reset"></i></div>
                        <div style="display:flex;"><input type="text" class="comment-box" id="cmt-{{flight.resultID}}" value="{{flight.booking_token}}" placeholder="Comment ..."><button ng-click="likeLink(flight.resultID,'y');" style="cursor:pointer;" class="comment-btn">Send <i class="fa fa-paper-plane"></i></button></div>
                    </div>
                    <style>
			.comment-box
			{
			height: 30px;
    			border: 1px solid grey;
    			border-radius: 5px;
    			outline: 0;
    			padding-left: 10px;
    			width: 70%;
    			font-size: 16px;
			}
			.comment-btn
			{
			border: 0;
    			color: #ffffff;
    			outline: 0;
    			border-radius: 5px;
    			background-color: #ff4500;
    			height: 30px;
    			font-size: 14px;
    			margin:0 5px;
    			cursor: pointer;
			padding:0 15px;
			width:100px;
			}
			@media only screen and (max-width: 768px)
			{
			.header {position: static;}
			.flight-info {margin-top: 90px;}
			}
			.results 
			{
   			margin-right:0;
    			margin-left: 3%;
			}
		    </style>
                    <div class="flight-detail-container" id="flightdetailexpandcollaps_{{$index}}">
                        <div class="flight-detail" ng-repeat="outbound in flight.outBound">
                            <div class="flight-detail-head" ng-if="$index == 0">Depart</div>
                            <div class="flight-detail-row">
                                <div class="flight-detail-airline">
                                    <img src="/resources/images/airline-logo/{{outbound.airline}}.png">
                                    <div class="airline-name-fno">
                                        <div>{{getAirlineName(outbound.airline)}}</div>
                                        <div>Flight {{outbound.flightNo}} | Aircraft {{inbound.equipmentType}}</div>
                                    </div>
                                </div>
                                <div class="flight-detail-from-to">
                                    <div class="flight-detail-from">
                                        <div class="fdfrom-city">{{getCityName(outbound.froCityName)}},({{outbound.fromAirport}})</div>
                                        <div class="fdfrom-time">{{outbound.depDate | date:'hh:mm a'}}</div>
                                        <div class="fdfrom-daydate">{{outbound.depDate | date:'EEE, MMM dd'}}</div>
                                    </div>
                                    <div class="flight-detail-arrow">
                                        <div class="fdhr"></div>
                                        <div class="fdfi"><i class="fa fa-plane"></i></div>
                                    </div>
                                    <div class="flight-detail-to">
                                        <div class="fdfrom-city">{{getCityName(outbound.toCityName)}},({{outbound.toAirport}})</div>
                                        <div class="fdfrom-time">{{outbound.reachDate | date:'hh:mm a'}}</div>
                                        <div class="fdfrom-daydate">{{outbound.reachDate | date:'EEE, MMM dd'}}</div>
                                    </div>
                                </div>
                                <div class="flight-detail-cabin">
                                    <b>Cabin:</b> {{getCabinName(outbound.cabinClass)}}
                                </div>
                            </div>
                            <div class="flight-detail-duration">
                                <div>Flight Duration: {{outbound.eft | minToHour}}</div>
                            </div>
							<div class="stop-divider" ng-if="($index+1) != flight.outBound.length">
                            <div><span><i class="fa fa-clock-o"></i></span> <span> &nbsp; {{outbound.layOverTime | minToHour}} min layover in {{getCityName(outbound.toCityName)}} ({{outbound.toAirport}})</span></div>
							</div>
                        </div>
						<div class="stop-divider" ng-if="flight.inBound.length > 0">
                            <div></div>
                        </div>
                        <div class="flight-detail" ng-repeat="inbound in flight.inBound">
                            <div class="flight-detail-head" ng-if="$index == 0 && tripType == '2'">Return</div>
							<div class="flight-detail-head" ng-if="$index == 0 && tripType == '3'">Depart</div>
							<div class="flight-detail-row">
                                <div class="flight-detail-airline">
                                    <img src="/resources/images/airline-logo/{{inbound.airline}}.png">
                                    <div class="airline-name-fno">
                                        <div>{{getAirlineName(inbound.airline)}}</div>
                                        <div>Flight {{inbound.flightNo}} | Aircraft {{inbound.equipmentType}}</div>
                                    </div>
                                </div>
                                <div class="flight-detail-from-to">
                                    <div class="flight-detail-from">
                                        <div class="fdfrom-city">{{getCityName(inbound.froCityName)}},({{inbound.fromAirport}})</div>
                                        <div class="fdfrom-time">{{inbound.depDate | date:'hh:mm a'}}</div>
                                        <div class="fdfrom-daydate">{{inbound.depDate | date:'EEE, MMM dd'}}</div>
                                    </div>
                                    <div class="flight-detail-arrow">
                                        <div class="fdhr"></div>
                                        <div class="fdfi"><i class="fa fa-plane"></i></div>
                                    </div>
                                    <div class="flight-detail-to">
                                        <div class="fdfrom-city">{{getCityName(inbound.toCityName)}},({{inbound.toAirport}})</div>
                                        <div class="fdfrom-time">{{inbound.reachDate | date:'hh:mm a'}}</div>
                                        <div class="fdfrom-daydate">{{inbound.reachDate | date:'EEE, MMM dd'}}</div>
                                    </div>
                                </div>
                                <div class="flight-detail-cabin">
                                    <b>Cabin:</b> {{getCabinName(inbound.cabinClass)}}
                                </div>
                            </div>
                            <div class="flight-detail-duration">
                                <div>Flight Duration: {{inbound.eft | minToHour}}</div>
                            </div>
							<div class="stop-divider" ng-if="($index+1) != flight.inBound.length">
                            <div><span><i class="fa fa-clock-o"></i></span> <span> &nbsp; {{inbound.layOverTime | minToHour}} min layover in {{getCityName(inbound.toCityName)}} ({{inbound.toAirport}})</span></div>
							</div>
                        </div>
						
						<div ng-repeat="otherbound in flight.otherBound">
						<div class="stop-divider">
                            <div></div>
                        </div>
						<div class="flight-detail">
                            <div class="flight-detail-head">Depart</div>
							<div ng-repeat="inbound in otherbound">
                            <div class="flight-detail-row">
                                <div class="flight-detail-airline">
                                    <img src="/resources/images/airline-logo/{{inbound.airline}}.png">
                                    <div class="airline-name-fno">
                                        <div>{{getAirlineName(inbound.airline)}}</div>
                                        <div>Flight {{inbound.flightNo}} | Aircraft {{inbound.equipmentType}}</div>
                                    </div>
                                </div>
                                <div class="flight-detail-from-to">
                                    <div class="flight-detail-from">
                                        <div class="fdfrom-city">{{getCityName(inbound.froCityName)}},({{inbound.fromAirport}})</div>
                                        <div class="fdfrom-time">{{inbound.depDate | date:'hh:mm a'}}</div>
                                        <div class="fdfrom-daydate">{{inbound.depDate | date:'EEE, MMM dd'}}</div>
                                    </div>
                                    <div class="flight-detail-arrow">
                                        <div class="fdhr"></div>
                                        <div class="fdfi"><i class="fa fa-plane"></i></div>
                                    </div>
                                    <div class="flight-detail-to">
                                        <div class="fdfrom-city">{{getCityName(inbound.toCityName)}},({{inbound.toAirport}})</div>
                                        <div class="fdfrom-time">{{inbound.reachDate | date:'hh:mm a'}}</div>
                                        <div class="fdfrom-daydate">{{inbound.reachDate | date:'EEE, MMM dd'}}</div>
                                    </div>
                                </div>
                                <div class="flight-detail-cabin">
                                    <b>Cabin:</b> {{getCabinName(inbound.cabinClass)}}
                                </div>
                            </div>
                            <div class="flight-detail-duration">
                                <div>Flight Duration: {{inbound.eft | minToHour}}</div>
                            </div>
							<div class="stop-divider" ng-if="($index+1) != flight.inBound.length">
                            <div><span><i class="fa fa-clock-o"></i></span> <span> &nbsp; {{inbound.layOverTime | minToHour}} min layover in {{getCityName(inbound.toCityName)}} ({{inbound.toAirport}})</span></div>
							</div>
							</div>
                        </div>
						</div>
                        
                    </div>
					
				
                </div>
				</div>
				
				
            </div>
        </div>
		
    </div>
    <div class="footer2" ng-if="flightsResponse.liveflightResult.length > 0">
        <p style="text-align:center;margin:5px 0;">Copyright &copy;  2021 - 2022, Ebooktrip. All rights reserved</p>
    </div>
    <div class="footer-icons" ng-if="flightsResponse.liveflightResult.length > 0">
    </div>
</body>
<script src="/resources/scripts/live-result.js?0606"></script>
<script>
    $( "div" ).delegate( ".rate-col .hover-col", "click", function() {
        $(".rate-col").removeClass("active-col");
        $(this).parent().addClass("active-col");
    });
</script>
</html>