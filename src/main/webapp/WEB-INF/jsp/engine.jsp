<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form:form modelAttribute="flightSearch" action="flight" method="POST">

   
        
<div class="engine">
                <div class="engine-selector">
                    <ul>
                        <li><a href="#"><i class="fa fa-plane"></i> &nbsp;&nbsp;FLIGHTS</a></li>
                    </ul>
                </div>
                <div class="flight-engine">
				<form:hidden path="tripType" value="2"/>
				<form:hidden path="pageAirline" />
                    <div class="trip-selector">
                        <label> ROUND TRIP<input type="radio" name="trip" checked="checked" onclick="tripselector();multicity1();";><span class="custom-radio"></span></label>
                        <label> ONE WAY<input type="radio" name="trip" id="oneway" onclick="tripselector();multicity1();";><span class="custom-radio"></span></label>
                        <label> Multi City<input type="radio" name="trip" id="multicity" onclick="tripselector();multicity1();"><span class="custom-radio"></span></label>
                    </div>
                    <div class="flight-search">
                        <div class="search-date">
                            <div class="defaultcity">
                                <div class="flightno" style="display:none;">Flight 1</div>
                                <div class="origra">
                                <i class="fa fa-times-circle" id="OremEmpIcon" onclick="delEmpVal('origin','FcityName','OremEmpIcon','txtFltOrigin')" style="display:none;"></i>
                                    <span>Origin</span>
                                <strong id="txtFltOrigin" style="display:none;"></strong>
                                <form:input  path="origin" class="search" placeholder="Enter Airport" />
                                <label class="bottom" for="origin" id="FcityName">&nbsp;</label>
                            </div>
                                <input type="button" id="swap" style="padding-left:0;">

                                <div class="origra rvksh">
                                <i class="fa fa-times-circle" id="DremEmpIcon" onclick="delEmpVal('destination','RcityName','DremEmpIcon','txtFltDestin')" style="display:none;"></i>
                                    <span>Destination</span>
                                <strong id="txtFltDestin" style="display:none;"></strong>
                                <form:input path="destination" class="search" placeholder="Enter Airport" />
                                <label class="bottom" for="destination" id="RcityName">&nbsp;</label>
                            </div>

                            <div class="origra ">
                                <p class="ashm"><img src="/resources/images/mips2.png" alt="mips2" style="width: 24px; height: 24px;"></p>
                                <span>Depart</span>

                                <form:input path="departDate" readonly="true" class="date" placeholder="Select" />
                                <!-- <span class="bottom pl23px">Date</span> -->
                            </div>
                            <input type="button" class="mips"  style="padding-left:0;">
                            <div class="origra  date rvksh rvksh2">
                                <p class="ashm"><img src="/resources/images/mips2.png" alt="mips2" style="width: 24px; height: 24px;"></p>
                                <span>Return</span>

                                <form:input path="returnDate" readonly="true" class="date" placeholder="Select" />
                                <!-- <span class="bottom pl23px">Date</span> -->
                            </div>

                            </div>
                            <div class="multicity" style="display:none;">
                                <div class="flightno">Flight 2</div>
                                <label class="originM">Origin</label>
                                <form:input path="origin2" class="msearch" placeholder="Enter Airport" />
                                <label class="destinationM">Destination</label>
                                <form:input path="destination2" name="from" class="msearch" placeholder="Enter Airport" />
                                <img src="/resources/images/mips.png" alt="calendar" class="Mcalendr">
                                <form:input path="departDate2" name="depart" class="mdate" readonly="true" placeholder="Depart" />
                            </div>
                            <div class="multicity" style="display:none;">
                                <div class="flightno"><span>Flight 3</span><button type="button" onclick="closeself()"><i class="fa fa-close"></i> Remove This</button></div>
                                <label class="originM">Origin</label>
                                <form:input path="origin3" class="msearch" placeholder="Enter Airport" />
                                <label class="destinationM">Destination</label>
                                <form:input path="destination3" class="msearch" placeholder="Enter Airport" />
                                <form:input path="departDate3" class="mdate" readonly="true" placeholder="Depart" />
                                <img src="/resources/images/mips.png" alt="calendar" class="Mcalendr">
                                <button type="button" class="cbtn" onclick="closeself()"><i class="fa fa-close"></i></button>
                            </div>
                            <div class="multicity" style="display:none;">
                                <div class="flightno"><span>Flight 4</span><button type="button" onclick="closeself()"><i class="fa fa-close"></i> Remove This</button></div>
                                <label class="originM">Origin</label>
                                <form:input path="origin4" class="msearch" placeholder="Enter Airport" />
                                <label class="destinationM">Destination</label>
                                <form:input path="destination4" class="msearch" placeholder="Enter Airport" />
                                <form:input path="departDate4" class="mdate" readonly="true" placeholder="Depart" />
                                <img src="/resources/images/mips.png" alt="calendar" class="Mcalendr">
                                <button type="button" class="cbtn" onclick="closeself()"><i class="fa fa-close"></i></button>
                            </div>
                            <div class="multicity" style="display:none;">
                                <div class="flightno"><span>Flight 5</span><button type="button" onclick="closeself()"><i class="fa fa-close"></i> Remove This</button></div>
                                <label class="originM">Origin</label>
                                <form:input path="origin5" class="msearch" placeholder="Enter Airport" />
                                <label class="destinationM">Destination</label>
                                <form:input path="destination5" class="msearch" placeholder="Enter Airport" />
                                <form:input path="departDate5" class="mdate" readonly="true" placeholder="Depart" />
                                <img src="/resources/images/mips.png" alt="calendar" class="Mcalendr">
                                <button type="button" class="cbtn" onclick="closeself()"><i class="fa fa-close"></i></button>
                            </div>
                            <div class="multicity" style="display:none;">
                                <div class="flightno"><span>Flight 6</span><button type="button" onclick="closeself()"><i class="fa fa-close"></i> Remove This</button></div>
                                <label class="originM">Origin</label>
                                <form:input path="origin6" class="msearch" placeholder="Enter Airport" />
                                <label class="destinationM">Destination</label>
                                <form:input path="destination6" class="msearch" placeholder="Enter Airport" />
                                <form:input path="departDate6" class="mdate" readonly="true" placeholder="Depart" />
                                <img src="/resources/images/mips.png" alt="calendar" class="Mcalendr">
                                <button type="button" class="cbtn" onclick="closeself()"><i class="fa fa-close"></i></button>
                            </div>
                        </div>
                        <div class="coach-button">
                            <input type="text" name="coach" class="coach coachi1" aria-label="coach" value="1 Traveller" onclick="travelercoach();" readonly>

                            <i class="fa fa-angle-down coachi1-drop-down"></i>
                            
                                <div class="coach-type rvksh">
                                    <form:select path="cabin" onchange="travelercount()" >
                                        <option>Economy</option>
                                        <option>PremiumEconomy</option>
                                        <option>Business</option>
                                        <option>First</option>
                                    </form:select>
                                </div>
                               




                            <button type="submit" id="sbtn">Search Flights</button>
                            <div class="traveler-coach-dropdown" id="tcd" style="visibility:hidden;">
                                <div class="travelers-container">
                                    <div class="traveler-type">
                                        <div><b>Adult</b></div>
                                        <div class="plus-minus-number">
                                            <button type="button" class="paxMinus" data-pax="adult" ><i class="fa fa-minus"></i></button>
                                            <form:input path="adult" readonly="true" class="pnumber" value="1" />
                                            <button type="button" class="paxPlus" data-pax="adult" ><i class="fa fa-plus"></i></button>
                                        </div>
                                    </div>
                                <!--    <div class="traveler-type">
                                        <div><b>Senior</b> (65+)</div>
                                        <div class="plus-minus-number">
                                            <button type="button" onclick="this.parentNode.querySelector('input').stepDown();travelercount();"><i class="fa fa-minus"></i></button>
                                            <input type="number" name="adult" class="pnumber"  min="0" max="9" value="0" readonly>
                                            <button type="button" onclick="this.parentNode.querySelector('input').stepUp();travelercount();"><i class="fa fa-plus"></i></button>
                                        </div>
                                    </div>
                                    <div class="traveler-type">
                                        <div><b>Youth</b> (16-25)</div>
                                        <div class="plus-minus-number">
                                            <button type="button" onclick="this.parentNode.querySelector('input').stepDown();travelercount();"><i class="fa fa-minus"></i></button>
                                            <input type="number" name="adult" class="pnumber" min="0" max="9" value="0" readonly>
                                            <button type="button" onclick="this.parentNode.querySelector('input').stepUp();travelercount();"><i class="fa fa-plus"></i></button>
                                        </div>
                                    </div> -->
                                    <div class="traveler-type">
                                        <div><b>Child</b> (2-15)</div>
                                        <div class="plus-minus-number">
                                            <button type="button" class="paxMinus" data-pax="child" ><i class="fa fa-minus"></i></button>
                                            <form:input path="child"  readonly="true" class="pnumber" value="0" />
                                            <button type="button" class="paxPlus" data-pax="child" ><i class="fa fa-plus"></i></button>
                                        </div>
                                    </div>
                                    <div class="traveler-type">
                                        <div><b>Seat Infant</b> (Under 2)</div>
                                        <div class="plus-minus-number">
                                            <button type="button" class="paxMinus" data-pax="infantws" ><i class="fa fa-minus"></i></button>
                                            <form:input path="infantWs"   readonly="true" class="pnumber" value="0" />
                                            <button type="button" class="paxPlus" data-pax="infantws" ><i class="fa fa-plus"></i></button>
                                        </div>
                                    </div>
                                    <div class="traveler-type">
                                        <div><b>Lap Infant</b> (Under 2)</div>
                                        <div class="plus-minus-number">
                                            <button type="button" class="paxMinus" data-pax="infant" ><i class="fa fa-minus"></i></button>
                                            <form:input path="infant" readonly="true" class="pnumber" value="0" />
                                            <button type="button" class="paxPlus" data-pax="infant" ><i class="fa fa-plus"></i></button>
                                        </div>
                                    </div>
                                </div>
                                <div class="class-done">
                                 
                                    <button type="button" onclick="tchide();">Done</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="airline-search" style="display: none;">
                        <input list="airlineslist" name="airline" class="airline" placeholder="Select Preffered Airline">
                        <datalist id="airlineslist">
						<c:forEach items="${airlineList}" var="airline">
                            <option value="${airline.value} (${airline.key})"></option>
                         </c:forEach>
                        </datalist>
                        <label> Direct Flights<form:checkbox path="directFlight" class="direct-flights" /><span class="custom-switch"></span></label>
                        
						
                    </div>
                    <div class="multibuttons">
                            <button type="button" id="addflight" onclick="addflight1()"><i class="fa fa-plus"></i> Add Flight</button>
                            <button type="button" id="clearall">Clear All</button>
                        </div>
                </div>

                <div class="bannerheding">
                    <div class="main">
                    <div class="mainarea">
                    
                    <p>Best Cheap Flight Tickets Easily Compare and 
                        Book <span style="text-shadow:1px 2px 2px #252525; color:#f8e122; font-size:40px; font-weight: 700;">All Airlines</span></p>
                    
                    </div>
                    </div>
                    </div>
                    
            </div>
</form:form>			