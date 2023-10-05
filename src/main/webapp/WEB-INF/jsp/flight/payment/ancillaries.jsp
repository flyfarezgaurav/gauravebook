<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<style type="text/css">
.trvlInsuranceSecn.trvlProt, .trvlInsuranceSecn.trvlProt .cccdhead { padding:0; }
.trvlInsuranceSecn.addtrvlProt { padding:0 20px; }
.trvlInsuranceSecn.cccdhead { padding:0 20px; font-size:14px; }
.trvlInsuranceSecn.trvlProt .cccdhead div { background:#001871; color:white; padding:15px 80px 15px 20px; position:relative; }
.trvlInsuranceSecn.trvlProt .cccdhead div span { position:absolute; right:0; top:0; width:80px; height:100%; overflow:hidden; }
.trvlInsuranceSecn.trvlProt .cccdhead div .aigLogo { width:240px; position:absolute; top:-62px; right:-80px; }
.trvlInsuranceSecn.trvlProt .cccdhead div .trvlGuardLogo { height:50px; position:relative; left:-15px; top:-3px; }
.trvlInsuranceSecn.trvlProt .cccdhead > p { padding:20px; font-size:14px; color:#5c5c5c }
.trvlInsuranceSecn.trvlProt .cccdhead > p b { color:#1352de; margin:0 0 10px 0; display:block; }
.trvlInsuranceSecn.trvlProt .cccdhead > p br { display:none }
.trvlInsuranceSecn.addtrvlProt .yesInsur { background:#bed2ff; color:#484848; position:relative }
.trvlInsuranceSecn.addtrvlProt .yesInsur a { color:#598cff; }
.ftpdetails > .ft-block > .billing-details:nth-child(2) { padding:0 0px 10px;  }
.ftpdetails > .ft-block > .billing-details:nth-child(2) > div { background:white }
.ftpdetails > .ft-block > .billing-details:nth-child(2) .trvlInsuranceSecn.cccdhead { display:flex; flex-wrap:wrap; align-items:center; }
.ftpdetails > .ft-block > .billing-details:nth-child(2) .trvlInsuranceSecn.cccdhead p { margin-bottom:0; padding-bottom:1rem; width:calc(100% - 300px); }
.mobTermsDiv { display:none }
.detailCntnt_popup { display:none; position:absolute; top:0; right:-30%; z-index:1; width:250px; background:white; border-radius:5px; padding:10px 12px; font-size:12px; color:#919192; box-shadow:0 0 6px #00000033; flex-wrap:wrap; }
.detailCntnt_popup.active { display:flex }
.trvlAssistUl > li > img { height:16px; cursor:pointer; position:absolute; right:8px; top:calc(50% - 8px); }
.detailCntnt_popup div span { margin-bottom:5px; display:block; position:relative; padding-left:18px; padding-right:10px; }
.detailCntnt_popup div span img { height:13px; position:absolute; left:0; top:4px; }
.detailCntnt_popup > p { margin:0; }
.trvlAssistUl > li { position:relative; }
.detailCntnt_popup:after, .detailCntnt_popup:before { content:""; position:absolute; border-left:10px solid transparent; border-right:10px solid transparent; top:-10px; left:54%; border-bottom:10px solid #ccc; }
.detailCntnt_popup:after { border-bottom:11px solid #fff; z-index:1; }
.detailCntnt_popup > img { position:absolute; top:5px; right:5px; height:12px; opacity:0.4; cursor:pointer; z-index:1; transition:all 0.5s; -webkit-transition:all 0.5s; }
.detailCntnt_popup > img:hover { opacity:1; transition:all 0.5s; -webkit-transition:all 0.5s; }
.travel-assist-tnc {color: #000; border-radius: 3px; font-size: 13px; text-decoration: underline;} */


.refundable-booking-price ul.checkMark.checkMark_ {width: 75%; padding-bottom: 12px;}
.refundable-booking-price .checkMark.checkMark_ li {width: 50%; font-size: 13px;}
.refundable-booking-price .pricedropP .web-checking-details {display: flex; justify-content: space-between; padding-right: 30px; align-items: center; margin: 12px 0;}
.refundable-booking-price .pricedropP .protection-price-display span.price-display-text {font-weight: bold; font-size: 18px; color: #063d99;}
.price-display-text span {display: block; font-size: 12px; color: #383737; font-weight: normal;}
.protection-price-display .proAddProd {padding-right: 0;}
.refundable-booking-price .protection-price-display {text-align: right;}
.addRemButSec button#addwebcheck{color: #fff; background: #db2405;border: 1px solid #db2405; padding: 8px 15px 8px;}
.addRemButSec button#removewebcheck{color: #fff; background: #db2405;border: 1px solid #db2405; padding: 8px 15px 8px;}

.proaddnonte {padding: 0 20px; font-size: 13px; color: #5b5b5b;}
.proaddnonte p {border: 1px solid #b1c8ef; padding: 6px 8px; border-radius: 5px;}
.proaddnonte p span {font-weight: 500; color: #1f5bc1;}
.proaddnonte p a {color: #005dba !important;} 

 @media(max-width:767px){
  .refundable-booking-price .pricedropP .web-checking-details{display: block; margin-bottom: 5px;}
  .refundable-booking-price ul.checkMark.checkMark_{width:100%; padding-bottom: 7px;}
  .refundable-booking-price .protection-price-display {text-align: left; margin-top: 10px; padding-left: 20px; display: flex; justify-content: space-between;}
  .refundable-booking-price .checkMark.checkMark_ li {width: 100%; font-size: 13px;}
  .protection-price-display .proAddProd {padding-right: 0; width: auto;  padding-top: 0;}
} 

@media(max-width:600px){
    .mobTermsDiv { display:block; }
    .ftpdetails > .ft-block > .billing-details:nth-child(2) .trvlInsuranceSecn.cccdhead p { width:100%; }
    .ftpdetails > .ft-block > .billing-details:nth-child(2) .trvlInsuranceSecn.cccdhead span { margin-bottom:10px; }
}
@media(max-width: 500px){
    .trvlInsuranceSecn.trvlProt .cccdhead div { font-size:16px; padding:15px }
}
</style>
<c:set var = "wCondition" scope = "session" value = "0"/>
 <c:forEach items="${bookingRequest.ancillaryServices}" var="anclleries" varStatus="indexed">
   <c:choose >
          <c:when test="${bookingWrapper.paymentDetails.state==',WA' || bookingWrapper.paymentDetails.state==',HI' || bookingWrapper.paymentDetails.state==',NY'}">
          <c:set var = "wCondition" scope = "session" value = "1"/>
          </c:when>
    </c:choose>
 </c:forEach>
 
 <c:if test = "${wCondition==1}">
         <!-- HIDE THE BANNER -->
    </c:if>
	
    
    <c:forEach items="${bookingRequest.ancillaryServices}" var="anclleries" varStatus="indexed">
  <c:if test = "${wCondition==0}">
    <c:if test="${anclleries.supplierCode=='TAG'}">
    <div class="billing-details" style="display:none;">
        <div>
    <div>
    <div class="trvlProt trvlInsuranceSecn">
        <!-- <img src="/resources/images/icons/shield.png" alt="Protection"> -->
        <div>
            <div class="cccdhead">
                <div>${anclleries.fullName} <!-- <img src="/resources/images/icons/trvlGuardLogo.svg" class="trvlGuardLogo" alt="Travel Guard"> --> 
                    <span><img src="/resources/images/icons/AIG_logo.svg" class="aigLogo" alt="AIG logo"></span></div>
                <p>${anclleries.description}</p>
            </div>
            <!-- <div>
                <ul class="checkMark">
                    <li>Missed connection</li>
                    <li>Hospitalization</li>
                    <li>Sickness</li>
                    <li>Mishandled bags</li>
                    <li>Priority concierge service</li>
                </ul>
            </div> -->
        </div>
    </div>
    <div class="addtrvlProt trvlInsuranceSecn">
        <div class="yesInsur">
            <form:radiobutton path="travelGuard" id="travelGuardYes" value="Yes" onclick="setTG('Add',${bookingRequest.travelGuardCost})" />
            <div>
                <!-- <label><strong>Yes, I want to insure my trip </strong></label> -->
                <label><strong>Yes, include travel insurance for </strong>
                    <span>${currencySymbol}</span><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.travelGuardCost*currencyValue}" /> <span class="smalTxt">(Available only to residents of U.S. states and the District of Columbia.)</span>
                </label>
                <p>I acknowledge that I have read and understand the <a href="https://webservices.travelguard.com/Product/FileRetrieval.aspx?CountryCode=US&StateCode=AL&ProductCode=939502&PlanCode=NW&FileType=PROD_PLAN_GM" target="_blank"><strong>Policy of Insurance</strong></a> and <a href="https://www.travelguard.com/legal/disclaimer" target="_blank"><strong>Important Disclosures</strong></a>, and agree to the terms and conditions of the insurance coverage provided.</p>
                <!-- <p><span>$</span>${bookingRequest.travelGuardCost} / person</p> -->
            </div>
        </div>
        <div class="noInsur">
            <form:radiobutton path="travelGuard" id="travelGuardNo" value="No" onclick="setTG('Remove',0.0)" />
            <div>
                <p>${anclleries.noMessage}</p>
            </div>
        </div>
        
    </div>
    <div class="cccdhead trvlInsuranceSecn">
        <!--<p>${anclleries.bttomDescription} <a href="javascript:;" data-toggle="modal" data-target="#travelInsurancePopup">Click here for full disclaimer.</a></p>-->
        <p>Coverage is offered by Travel Guard Group, Inc., and limitations will apply, <a href="https://www.travelguard.com/legal/disclaimer" target="_blank">click here </a>for important disclosures. </p>
        <span>
            <img src="/resources/images/payment-img/AIG.png" alt="Image" class="img-responsive aigLogo">
            <img src="/resources/images/payment-img/travelguard-logo.svg" alt="Image" class="img-responsive trvlGLogo">
        </span>
    </div>
    </div>
</div>
    </div> 
    </c:if>
    </c:if>
           
    <c:if test="${anclleries.supplierCode=='PDP'}">
<div class="billing-details">
        <div>
            <div class="trvlProt priceDrop bgblue">
                
                <div>
                  <div class="cccdhead"> <img src="/resources/images/icons/shield-white.png" alt="Protection"> ${anclleries.fullName}
                  </div>

                    <div class="pricedropP">
                      <p>${anclleries.description}</p>
                        <ul class="checkMark checkMark_">
                            <c:forEach items="${anclleries.services}" var="services" varStatus="indexNo">
                                <li>${services.name}</li>
                            </c:forEach>
                        </ul>
                        <div class="protection-price-display">
                            <span>${currencySymbol}<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="14.99" />
                            
                              <span class="per-person-text">per person</span>
                            </span>
                            <%-- <input type="hidden" id="priceDropAmount" value="${anclleries.owServiceText[0].price}" /> --%>

                            <span class="addRemButSec">
                              <button type="button" id="addPdp" onClick="flightProduct('Add', '14.99');">
                                <i class="fa fa-check" aria-hidden="true"></i> <span>Add Product</span>
                              </button>
                              <button type="button" id="removePdp" onClick="flightProduct('Remove','0.00');" style="display:none;">
                                <i class="fa fa-trash-o" aria-hidden="true"></i><span>Remove Product</span>
                              </button>
                           </span>

                        </div>
                    </div>
                </div>
            </div>
            <!-- <div class="proAddProd">
                <a class="proAddProd-learnmorebtn" href="javascript:;" data-toggle="modal" data-target="#priceDropProtectionPopup">Learn More</a>
                <span class="addRemButSec">
                    <button type="button" id="addPdp" onClick="flightProduct('Add', '14.99');">
                      <i class="fa fa-check" aria-hidden="true"></i> <span>Add Product</span>
                    </button>
                    <button type="button" id="removePdp" onClick="flightProduct('Remove','0.00');" style="display:none;">
                      <i class="fa fa-trash-o" aria-hidden="true"></i><span>Remove Product</span>
                    </button>
                </span>
            </div> -->

            <div class="proaddnonte">
              <p><span><i class="fa fa-info-circle" aria-hidden="true"></i> Note : </span> You never know when the airline will make a promotion announcement and provide a better deal on your
                flight. Get the opportunity for money back with our Price Drop Protection. <a href="javascript:;" data-toggle="modal" data-target="#priceDropProtectionPopup">Learn More</a></p>
            </div>
        </div>
  </div>

<form:hidden path="webcheckincost"  value="0.00" />
<form:hidden path="webcheckin"  value="No"/>
  <div class="billing-details">
    <div>
        <div class="trvlProt refundable-booking-price bgblue">
            <div>
              <div class="cccdhead"> <img src="/resources/images/icons/web-checking-white.png" alt="Protection"> Web Check-in
              </div>

                <div class="pricedropP">
                  <p>Reasons you might need web check-in</p>
                    <div class="web-checking-details">                    
                      <ul class="checkMark checkMark_">
                        <li>We'll complete the process of flight check-in on time.</li>
                        <li>Prior to reaching the airport, you will obtain an assigned seat.</li>
                        <li>Enter directly without visiting the kiosk/check-in counter</li>
                        <li>Do not need to pay a fee for printing the boarding pass.</li>
                    </ul>
                    <div class="protection-price-display">
                        <span class="price-display-text">${currencySymbol}<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${9.99}" />
                          <span>per person/each way</span>
                        </span>
                       

                        <div class="proAddProd">
                            <span class="addRemButSec">
                              <button type="button" onclick="setWebcheck('Add','9.99')"  id="addwebcheck">
							    <i class="fa fa-check" aria-hidden="true"></i> <span>Add Product</span>
                              </button>
                              <button type="button" onclick="setWebcheck('Remove',0.0)" id="removewebcheck" style="display:none;">
							    <i class="fa fa-trash-o" aria-hidden="true"></i><span>Remove Product</span>
                              </button>
                          </span>
                       </div>
                    </div>
                  </div>
                </div>
                <div class="proaddnonte">
                  <p><span><i class="fa fa-info-circle" aria-hidden="true"></i> Note : </span> Enjoy the trip. Make unforgettable memories. On the registered email, you will get your boarding pass. Bring a printout of the boarding pass at the airport. For any further queries related to seat and baggage, Contact us at <a href="tel:+1-800-404-0025">+1-800-404-0025</a></p>
                </div>
            </div>
        </div>
        <!-- <div class="proAddProd">
            <a class="proAddProd-learnmorebtn" href="javascript:;" data-toggle="modal" data-target="#priceDropProtectionPopup">Learn More</a>
            <span class="addRemButSec">
                <button type="button" id="addPdp" onClick="flightProduct('Add', '14.99');">
                  <i class="fa fa-check" aria-hidden="true"></i> <span>Add Product</span>
                </button>
                <button type="button" id="removePdp" onClick="flightProduct('Remove','0.00');" style="display:none;">
                  <i class="fa fa-trash-o" aria-hidden="true"></i><span>Remove Product</span>
                </button>
            </span>
        </div> -->
    </div>
</div>
  
        </c:if>


       
      
       

        
        <c:if test="${anclleries.supplierCode=='TAS'}">
<div class="billing-details">
        <div>
            <div class="trvlExpSec trvlAsistSec">
                    <div class="trvlProt priceDrop bgblue">
                        <img src="/resources/images/icons/travel-assist-white.png" alt="Protections">
                        <div>
                            <div class="cccdhead"><img src="/resources/images/icons/travel-assist-white.png" alt="Protections">${anclleries.fullName}
                                
                                <!-- <p><a href="javascript:;">Learn More</a></p> -->
                            </div>
                        </div>
                    </div>
                    <div class="proAddProd_Section">
                      <p class="travel-assist-description">${anclleries.description}</p>
                        <div class="proAddProd">
                          
                        <div class="itemsHeadng">
                            <ul class="trvlAssistUl">
                                <li><strong>Services</strong></li>
                                 <c:forEach items="${anclleries.services}" var="servicetas" varStatus="indextas">
                                    <li class="liClass_${indextas.index}">
                                        ${servicetas.name}
                                        <img src="/resources/images/icons/info-icon.png" alt="info" onclick="detailIconFun(`detailCntnt_${indextas.index}`,`liClass_${indextas.index}`)">
                                        <div class="detailCntnt_popup" id="detailCntnt_${indextas.index}">
                                            <img src="/resources/images/icons/close.png" alt="check" onclick="detailIconCloseFun(`detailCntnt_${indextas.index}`)">
                                            <!--<div>
                                                <span><img src="/resources/images/icons/check-mark.png" alt="check"> We've got you covered for things, such as flight cancelation, rescheduling, or name changes of passenger.</span>
                                                <span><img src="/resources/images/icons/check-mark.png" alt="check"> You won't incur any additional agency fees at any point, even after 24 hours of booking.</span>
                                            </div>
                                            <p>(Note: Additional fare differences and airline penalties may still apply.)</p>-->

					    <div><span><img src="/resources/images/icons/check-mark.png" alt="check">${servicetas.iText}</span></div>

                                        </div>
                                    </li>
                                </c:forEach>
                                <li><a class="travel-assist-tnc" href="javascript:;" data-toggle="modal" data-target="#travelAssistPopup">*terms and conditions</a></li>
                                
                                <%-- <li></li>
                                <li>Exchange & Refund Processing Fee</li>
                                <li>Schedule Change Handling</li>
                                <li>24 Hours Cancellation</li>
                                <li>Dedicated customers service, jump ahead of the phone queue.</li>
                                <li>Mobile flight alerts (booking confirmation, schedule changes etc)</li>
                                <li>Speedy Refund</li>
                                <li>*terms and conditions</li> --%>
                            </ul>
                        </div>
                        
                        <c:forEach items="${anclleries.owServiceText}" var="serviceText" varStatus="indextas">
                        <div class="itemss ${serviceText.name=='Standard' ? 'active' : ''}">
                            <c:if test="${serviceText.name=='Standard'}"><div class="sowOnActive">Most Popular</div></c:if>
                            <div class="itemssHead">
                                <img src="/resources/images/icons/basic-plan_${indextas.index}.png">
                                <span>${serviceText.name}</span>
                                <label>
                                    <input type="radio" class="${serviceText.name}" onclick="javascript:addTravelAssist('${serviceText.name}', ${serviceText.price});" name="protectionPlan">
                                    <c:if test="${serviceText.name=='Standard'}"></c:if>
                                    <c:if test="${serviceText.name!='Standard'}"></c:if>
                                </label>
                            </div>
                            <div class="itemssBody">
                                <ul>
                                    <c:forEach items="${serviceText.conditionList}" var="conditionList" varStatus="indextas">
                                        <li>
                                            <c:choose>
                                                <c:when test="${conditionList.name=='Check-Sign' || conditionList.name=='No Fees'}"><img style="opacity:0.6;height:24px" src="/resources/images/icons/check.png" alt="Image"></c:when>
                                                <c:otherwise>
                                                    ${conditionList.name}
                                                </c:otherwise>
                                            </c:choose>
                                        </li>
                                    </c:forEach> 
                                    
                                </ul>
                                <div>
                                    <a onclick="javascript:addTravelAssist('${serviceText.name}', ${serviceText.price});" style="cursor:pointer;">
                                    ${currencySymbol}<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${serviceText.price}" /></a>
                                </div>
                            </div>
                        </div>
                        
                        <%-- <div class="itemss active">
                            <div class="sowOnActive">Most Popular</div>
                            <div class="itemssHead">${serviceText.name}</div>
                            <div class="itemssBody">
                                <ul>
                                    <li>$50</li>
                                    <li>$25</li>
                                    <li><img style="opacity:0.6;height:24px" src="/resources/images/icons/check.png" alt="Image"></li>
                                    <li><img style="opacity:0.6;height:24px" src="/resources/images/icons/check.png" alt="Image"></li>
                                    <li></li>
                                    <li></li>
                                </ul>
                                <div>
                                    <a href="javascript:;" onclick="addTA('Plus', '29.00');">$29.00</a>
                                </div>
                            </div>
                        </div> --%>
                        
                        <%-- 
                        <div class="itemss">
                            <div class="itemssHead">${serviceText.name}</div>
                            <div class="itemssBody">
                                <ul>
                                    <li>Free</li>
                                    <li>Free</li>
                                    <li><img style="opacity:0.6;height:24px" src="/resources/images/icons/check.png" alt="Image"></li>
                                    <li><img style="opacity:0.6;height:24px" src="/resources/images/icons/check.png" alt="Image"></li>
                                    <li><img style="opacity:0.6;height:24px" src="/resources/images/icons/check.png" alt="Image"></li>
                                    <li><img style="opacity:0.6;height:24px" src="/resources/images/icons/check.png" alt="Image"></li>
                                </ul>
                                <div>
                                    <a href="javascript:;" onclick="addTA('Plus', '$49.00');">$49.00</a>
                                </div>
                            </div>
                        </div> --%>
                        </c:forEach>
                        <div class="col-12 mobTermsDiv"><a href="javascript:;" data-toggle="modal" data-target="#travelAssistPopup">*terms and conditions</a></div>
                    </div>
                    
                    <div class="proaddnonte">
                      <p><span><i class="fa fa-info-circle" aria-hidden="true"></i> Note : </span> All Fares displayed are quoted in ${currencySymbol} and inclusive of base fare, taxes and other services.</p>
                    </div>

                    </div>
                </div>
</div>        
</div>
                </c:if>
                
    
</c:forEach>

<style type="text/css">
.logoColor { color:white; letter-spacing:2px; font-weight:bold; font-size:24px; height:auto; padding-top:0; padding-bottom:0; }
.p-tb-5 { padding:5px 0 }
.banner { display:flex; width:100%; /*margin:61px 0 0;*/ padding:30px 0 50px }
.banner img { opacity:0.6 }
.banner .banDFlex { display:flex; flex-wrap:wrap; align-items:center; padding:0; color: #f5f2f2;}
.banner .banDFlex h1 {font-size: 28px;}
.banner .banDFlex p { font-size:15px; letter-spacing:1px; line-height:1.6; }
.navSection { background:white }
.trvlGLogo { height:30px }
.aigLogo { height:35px }
.twoLogo { display:flex; justify-content:flex-end; align-items:center; }
.img-responsive { max-width:100% }
#travelInsurancePopup button.close, #travelAssistPopup button.close, #priceDropProtectionPopup button.close { position:absolute; right:6px; top:4px; z-index: 9; width:30px; height:30px; background:white; opacity:1; display:flex; align-items:center; justify-content:center; border-radius:0 6px 6px 0; }
#travelInsurancePopup button.close span, #travelAssistPopup button.close span, #priceDropProtectionPopup button.close span { position:relative; top:-2px }
@media(max-width:991px){
    .modal-dialog { max-width:90%; margin-right:0; margin-left:5% }
    #travelInsurancePopup .container { max-width:100% }
    .banner .banDFlex .col-sm-7 { flex:0 0 100%; max-width:100%; }
    .banner .banDFlex .col-sm-5 { display:none }
    .bodyContentSec .allCenter .col-sm-6 { flex:0 0 100%; max-width:100%; }
}
@media(max-width: 767px){
  .navbar-header .navbar-toggle { border-color:grey; margin-bottom:0; margin-top:15px; }
  .navbar-header .navbar-toggle span { background:darkgrey; }
}
@media(max-width:580px){
    .modal-content .logoT { max-width:90% }
    .trvlGLogo { height:15px; }
    .aigLogo { height:18px; }
    #travelInsurancePopup button.close, #travelAssistPopup button.close, #priceDropProtectionPopup button.close { top:10px; }
}
@media (min-width: 992px){
    .modal-lg { max-width:950px; }
}
@media (min-width: 1199px){
    .modal-lg { max-width:1150px; }
}
</style>
<div class="modal fade" id="travelInsurancePopup" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <section class="">
            <div class="">
              <div class="col-12 banDFlex">
                <div class="row">
                    <div class="col-sm-4 col-12">
                      <img src="/resources/images/payment-img/logo.png" class="img-responsive logoT" alt="Logo" />
                    </div>
                    <div class="col-sm-8 col-12 twoLogo">
                        <img src="/resources/images/payment-img/travelguard-logo.svg" alt="Image" class="img-responsive trvlGLogo" />
                        <img src="/resources/images/payment-img/AIG.png" alt="Image" class="img-responsive aigLogo" />
                    </div>
                </div>
              </div>
            </div>
        </section>
      <section class="banner bg-primary">
      <div class="container">
        <div class="row">
          <div class="col-12 banDFlex">
            <div class="col-sm-7 col-12">
              <h1><strong>Travel Protection Plan</strong></h1>
              <p>Nobody is informed of unforeseeable events that could occur at any time. So, whether you're travelling to see family, unwind, or see new cultures, you should always be ready to handle unforeseen circumstances.</p>
            </div>
            <div class="col-sm-5 col-12"><img src="/resources/images/payment-img/auxiliary-hero.svg" alt="Image" class="img-responsive"></div>
          </div>
        </div>
      </div>
    </section>
<style type="text/css">
.bodyContentSec, .bodyContentSec_ { padding:10px 0 30px; }
.bodyContentSec { background:linear-gradient(360deg, #F5F7F9 0%, #FFFFFF 87.14%) }
.bodyContentSec h2, .bodyContentSec_ h2 { font-size:24px; margin-top:30px; }
.bodyContentSec p, .bodyContentSec_ p { line-height:1.7; font-size:15px; letter-spacing:0.5px; color:#7c7c7c; }
.bodyContentSec ul, .bodyContentSec_ ul { letter-spacing:0.5px; font-size:16px; padding:0 0 0 25px; line-height:1.7; margin:20px 0 20px; }
.pd-0 { padding:0 }
.allCenter { display:flex; flex-wrap:wrap; justify-content:center; }
.alignCenter { align-items:center; }
.secton_1 > div:last-child > div { margin:50px 0 0; }
.secton_1 > div:last-child p { margin-bottom:25px }
@media(max-width:991px){
    .aboutUsPop { text-align:center; margin-top:20px !important }
    .aboutUsPop img { max-width:25% }
    .aboutUsPop + div { margin-top:20px !important }
}
</style>
    <section class="bodyContentSec">
      <div class="container">
        <div class="row">
          <div class="col-12 secton_1">
            <div class="col-12 text-center pd-0">
              <h2><strong>What is a Travel Protection Plan?</strong></h2>
              <div class="col-12 allCenter"><p class="col-sm-6 col-12">The best choice to take into account to steer clear of any challenges prohibiting you from travelling safely and seeing new areas!</p></div>
            </div>
            <div class="col-12 pd-0 allCenter alignCenter">
              <div class="col-sm-6 col-12 aboutUsPop">
                <img src="/resources/images/payment-img/About.svg" alt="Image" class="img-responsive">
              </div>
              <div class="col-sm-6 col-12">
                <p>The extra service option known as Travel Protection Plan is presented to customers when they book a ticket.</p>
                <p>Numerous favourable solutions that enable you to pay for unforeseen damages are implied by the Plan. As a result, it could become valuable in the event that your vacation is affected by unforeseen events like mishandled luggage, trip cancellation, or airline disruption.</p>
                <p>In addition, it provides you with advance concierge services and promotional offers for your upcoming flight, all with the goal of exceeding your expectations and responding to your requests as quickly as possible.</p>
              </div>
            </div>
          </div>
<style type="text/css">
.secton_2 { padding:70px 0 0 }
.secton_2 .tHead { margin-bottom:50px; }
.secton_2 .tbody { display:flex; flex-wrap:wrap;  }
.secton_2 .tbody > div { display:flex; }
.secton_2 .tbody > div > div { padding:28px 32px; line-height:24px; margin-bottom:24px; background:#FFFFFF; box-shadow:0px 16px 32px rgb(26 49 71 / 7%); border-radius:8px; display:flex; align-items:flex-start; }
.secton_2 .tbody > div:first-child > div { background:transparent; box-shadow:none }
.secton_2 .tbody h3 { margin-top:0; font-weight:bold; font-size:21px; }
.secton_2 .tbody img { margin-right:25px }
.secton_2 .tbody p { margin-bottom:0 }
@media(max-width:991px){
    .secton_2 { padding:10px 0 0; }
}
</style>
          <div class="col-12 secton_2">
            <div class="col-12 text-center tHead pd-0">
              <h2><strong>Travel Protection as a unique cost-effective solution</strong></h2>
              <div class="allCenter col-12"><p class="col-sm-6 col-12">Here is a quick rundown of what you get when you purchase the Plan:</p></div>
            </div>
            <div class="col-12 tbody">
              <div class="col-sm-6 col-12">
                <div>
                  <p>With the help of our Travel Protection Plan, you can take advantage of the most adaptable refund alternatives, lucrative special offers, and top-notch customer service—everything you require for a wonderful vacation!</p>
                </div>
              </div>
              <div class="col-sm-6 col-12">
                <div>
                  <img src="/resources/images/payment-img/solution-icon-1.svg" alt="Image" class="img-responsive" />
                  <div>
                    <h3>Aid with mishandled baggage</h3>
                    <p>If your airport-checked baggage has been misplaced or lost, contact assistance right once.</p>
                  </div>
                </div>
              </div>
              <div class="col-sm-6 col-12">
                <div><img src="/resources/images/payment-img/solution-icon-2.svg" alt="Image" class="img-responsive" />
                  <div>
                    <h3>Options for refunds</h3>
                    <p>In the event of a last-minute flight cancellation or health issues, receive compensation.</p>
                  </div>
                </div>
              </div>
              <div class="col-sm-6 col-12">
                <div><img src="/resources/images/payment-img/solution-icon-3.svg" alt="Image" class="img-responsive" />
                  <div>
                    <h3>Unbiased trade</h3>
                    <p>If you miss a flight or a connection, you can exchange your tickets without cost.</p>
                  </div>
                </div>
              </div>
              <div class="col-sm-6 col-12">
                <div><img src="/resources/images/payment-img/solution-icon-4.svg" alt="Image" class="img-responsive" />
                  <div>
                    <h3>Savings on your upcoming flight</h3>
                    <p>Within a year after the date of issuance, get a $25.00 discount on your subsequent purchase from us.</p>
                  </div>
                </div>
              </div>
              <div class="col-sm-6 col-12">
                <div><img src="/resources/images/payment-img/solution-icon-5.svg" alt="Image" class="img-responsive" />
                  <div>
                    <h3>Upscale concierge services</h3>
                    <p>Taking care of any requirements you may have, including booking special meals and seats and identifying the most advantageous alternate flying alternatives.</p>
                  </div>
                </div>
              </div>
            </div>
          </div>

          
        </div>
      </div>
    </section>
<style type="text/css">
.secton_1New {  }
.secton_1.secton_1New > div:last-child p { margin-bottom:10px }
.secton_1New .tnbody > div > div { position: absolute; top: 0; left: 0; width: 100%; }
.secton_1New .tnbody > div { padding-top:70px; }
.secton_1New .tnbody > div > div { position:absolute; top:0; left:0; width:100%; border-bottom:1px solid gainsboro; }
.secton_1New .tnbody > div > div span { position:absolute; top:-30px; left:calc(50% - 30px); width:60px; height:60px; background:#399E65; color:white; font-size:18px; font-weight:600; border-radius:100px; display:flex; align-items:center; justify-content:center; }
.secton_1New .tnbody p { font-size:17px; color:#686868; }
.secton_1New .tbhead { margin-bottom:30px }
</style>
    <section class="bodyContentSec_">
      <div class="container">
        <div class="row">
          <div class="col-12">
            <div class="col-12 secton_1 secton_1New">
              <div class="col-12 text-center pd-0 tbhead">
                <h2><strong>The way it works</strong></h2>
                <p class="col-12">Follow these two simple steps to acquire and use our Travel Protection Plan.</p>
              </div>
              <div class="col-12 pd-0 tnbody allCenter">
                <div class="col-sm-6 col-12 text-center">
                  <div><span>1</span></div>
                  <p>Add the Travel Protection Plan to your order. </p>
                  <p>This extra option is available at the time of booking.</p>
                </div>
                <div class="col-sm-6 col-12 text-center">
                  <div><span>2</span></div>
                  <p>Start taking advantage of the Plan.</p>
                  <p>Once it's purchased, you get access to all its perks!</p>
                </div>
              </div>
            </div>
<style type="text/css">
.secton_3 { margin:100px 0 0; padding:0 }
.secton_3 .tnbody { display:flex; flex-wrap:wrap; }
.secton_3 .tnbody > div { display:flex; }
.secton_3 .tnbody > div h3 { margin-top:0; font-weight:bold; font-size:18px; line-height:24px }
.secton_3 .tnbody > div h2 { margin-top:0; line-height:1.5; font-weight:bold; }
.secton_3 .tnbody > div > div { background:#FFFFFF; box-shadow:0px 16px 32px rgb(26 49 71 / 7%); border-radius:8px; padding:28px 32px; }
.secton_3 .tnbody > div:first-child > div { background:transparent; box-shadow:none; padding-bottom:0; }
.secton_3 .tnbody p { font-size:14px; line-height:22px; margin-bottom:0 }
.secton_3 .tnbody img { margin-bottom:15px }
@media(max-width: 991px){
    .secton_3 { margin:20px 0 0; }
    .secton_3 .mobilRespons .col-sm-3 { flex:0 0 100%; max-width:100%; margin-bottom:10px; }
    .secton_3 .tnbody > div > div { padding:15px; }
}
</style>
            <div class="col-12 secton_3">
              <div class="col-12 pd-0 tnbody mobilRespons">
                <div class="col-sm-3 col-12">
                  <div>
                    <h2>Why we recommend you purchase Travel Protection Plan</h2>
                    <p>The plan doesn't add to the list of expenses with little to no benefit. By providing you with additional security at every stage of your journey, it can protect you.</p>
                  </div>
                </div>
                <div class="col-sm-3 col-12">
                  <div>
                    <img src="/resources/images/payment-img/recommend-icon.svg" alt="Image" class="img-responsive" />
                    <h3>Preventing you from unexpected costs</h3>
                    <p>We'll try our best to protect you from unforeseen charges incurred before or during your trip when you purchase the Travel Protection Plan. You'll have the opportunity to make some savings in this manner.</p>
                  </div>
                </div>
                <div class="col-sm-3 col-12">
                  <div>
                    <img src="/resources/images/payment-img/recommend-icon.svg" alt="Image" class="img-responsive" />
                    <h3>Protecting your travel investments</h3>
                    <p>Your travel investments are better protected with the aid of a travel protection plan in cases like flight cancellation and interruption, hospitalization and medical bills, lost or delayed luggage, and more. </p>
                  </div>
                </div>
                <div class="col-sm-3 col-12">
                  <div>
                    <img src="/resources/images/payment-img/recommend-icon.svg" alt="Image" class="img-responsive" />
                    <h3>Offering you additional bonuses</h3>
                    <p>Additionally, it gives you other benefits like a premium concierge service that will provide you with superior support and a discount on your subsequent travel!</p>
                  </div>
                </div>
              </div>
            </div>
<style type="text/css">
.secton_4 { margin:100px 0 0; padding:0 }
.secton_4 p { margin-bottom:25px }
@media(max-width:991px){
    .cntrFourSec .col-sm-7 { flex:0 0 80%; max-width:80%; }
    .cntrFourSec .col-sm-5 { flex:0 0 20%; max-width:20%; }
}
</style>
            <div class="col-12 secton_4">
              <div class="col-12 pd-0 tnbody allCenter alignCenter cntrFourSec">
                <div class="col-sm-7 col-12 pd-0">
                  <div>
                    <h2><strong>How should it be used?</strong></h2>
                    <p>Depending on the choice selected, the procedure changes. A minimum of 24 hours prior to the scheduled departure of the flight, however, is required for each request to be made to our Support Team.</p>
                    <p>Utilize the Contact us form, send an email to customercare@ovago.com, or give our Customer Care staff a call whenever you need to submit your requests along with the necessary paperwork and proofs.</p>
                    <p>Please review our Travel Protection Plan policy to become familiar with the specific requirements for each scenario and to learn the most recent Plan modifications.</p>
                  </div>
                </div>
                <div class="col-sm-5 col-12">
                  <div>
                    <img src="/resources/images/payment-img/how-to-use.svg" alt="Image" class="img-responsive">
                  </div>
                </div>
              </div>
            </div>
            
          </div>
        </div>
      </div>
    </section>
<style type="text/css">
.bodyContentSec_2 { background:#F5F7F9 }
.bodyContentSec_2 ul { padding:0; line-height:normal; font-size:15px; }
.bodyContentSec_2 ul li { list-style-type:none; position:relative; padding-left:35px; padding-top:10px; padding-bottom:10px; }
.bodyContentSec_2 ul li:before { content:''; background-image:url(https://ovago.com/travel/wp-content/uploads/2021/11/check.svg); min-width:24px; height:100%; background-position:center; display:block; margin-right:8px; background-repeat:no-repeat; position:absolute; left:0; top:0; }
.bodyContentSec_2 .row > div { padding:0; display:flex; flex-wrap:wrap; align-items:center; }
@media(max-width:991px){
    .planCoverSecn .col-sm-5 { flex:0 0 20%; max-width:20%; }
    .planCoverSecn .col-sm-7 { flex:0 0 80%; max-width:80%; }
}
</style>
    <section class="bodyContentSec_ bodyContentSec_2">
      <div class="container">
        <div class="row">
          <div class="col-12 planCoverSecn">
            <div class="col-12 col-sm-5">
              <img src="/resources/images/payment-img/plan.svg" alt="Image" class="img-responsive">
            </div>
            <div class="col-12 col-sm-7">
              <h2>What does the Travel Protection Plan cover?</h2>
              <p>You should be aware that the Travel Protection Plan is not insurance. However, if you can't go on a vacation that you've already booked, it can safeguard you and get you paid. The Plan is only applicable to unanticipated circumstances that could impact your flight travel. The following circumstances are on the list of those covered by the travel protection plan:</p>
              <ul>
                <li>Delayed flight</li>
                <li>Trip cancellation because of unforeseeable events* or an airline going out of business</li>
                <li>Due to a known medical condition, unable to fly (hospitalization or sickness)</li>
                <li>Misplaced or diverted luggage</li>
              </ul>
              <p>Unforeseen events can be either natural calamities like hurricanes, earthquakes, floods, thunderstorms, cyclones, volcanic eruptions, blizzards, high winds, too much precipitation, wildfires, or man-made events like civil unrest, political instability, quarantines, maintenance issues with aircraft, and security concerns. Anytime the Travel Protection Plan's list of events that are covered can be changed.</p>
            </div>
          </div>
        </div>
      </div>
    </section>
<style type="text/css">
.bodyContentSec_3 ul { list-style-type:none }
.bodyContentSec_3 ul li { position:relative; padding:25px 0 20px; border-bottom:1px solid gainsboro }
.bodyContentSec_3 ul li img { position:absolute; right:0; top:calc(50% - 12px); }
.bodyContentSec_3 .row > div { display:flex; flex-wrap:wrap; align-items:center; }
</style>
<style type="text/css">
.bodyContentSec_4 { padding:15px; min-height:360px; background-size:cover; background-position:50% 50%; background-repeat:no-repeat; background-image:url(image/travel.png); display:flex; flex-wrap:wrap; align-items:center; }
.bodyContentSec_4 h2 { color:white; font-size:30px; line-height:1.5; font-weight:bold; }
.bodyContentSec_4 p { color:white; margin-bottom:20px; }
.bodyContentSec_4 a { width:147px; height:40px; display:flex; align-items:center; justify-content:center; color:#ffffff; text-decoration:none; border-radius:4px; background:#DB4483; font-style:normal; font-weight:500; font-size:13px; transition:all 0.5s; }
.bodyContentSec_4 a:hover { background-color:#5346A3; }
</style>
<style type="text/css">
.bodyContentSec_5 { padding:80px 0; background: linear-gradient(180deg, #5346A3 0%, #42358C 100%); color:white; }
.bodyContentSec_5 .row .col-sm-4 { padding-right:40px }
.bodyContentSec_5 .row .col-sm-8 { border-left:8px solid #DB4483; padding-left:40px }
.bodyContentSec_5 p { color:white; }
.bodyContentSec_5 h2 { margin-top:0; }
.bodyContentSec_5 .row .col-sm-4 ul { list-style-type:none; /*display:flex; flex-wrap:wrap;*/ padding:0; }
.bodyContentSec_5 .row .col-sm-4 ul li { margin-bottom:25px; }
.bodyContentSec_5 .row .col-sm-4 ul li a { color:white; display:flex; align-items:center; }
.bodyContentSec_5 .row .col-sm-4 ul li a img { margin-right:8px }
@media(max-width: 767px){
  .bodyContentSec_3 ul { padding:0; }
  .bodyContentSec, .bodyContentSec_ { padding: 20px 0 30px; }
  .secton_2 { padding:0 }
  .secton_2 .tHead { margin-bottom:0 }
  .secton_2 .tbody > div > div { padding:15px; flex-wrap:wrap; }
  .secton_2 .tbody > div > div > div { margin-top:20px; }
  .secton_3 { margin: 20px 0 0; }
  .secton_3 .tnbody > div > div { padding:15px }
  .secton_3 .tnbody > div { margin-bottom:15px }
  .secton_4 { margin:20px 0 0 }
}
@media(max-width:991px){
    .secton_4 { margin:20px 0 0; padding:0 15px; }
}
</style>
    <section class="bodyContentSec_ bodyContentSec_5">
      <div class="container">
        <div class="row">
          <div class="col-12 col-sm-4">
            <!-- <h2>Do you need more information?</h2>
            <p>If you’re still looking for additional information or in case you need emergency travel assistance, please contact us right away!</p> -->
            <ul>
              <li>
                <a href="tel:+1-800-826-5248">
                  Toll Free Number: +1-800-826-5248
                </a>
              </li>
              <li>
                <!-- <a href="javaScript:;"> -->
                Travel Guard<br>
                3300 Business Park Drive<br>
                Stevens Point, WI 54482
                <!-- </a> -->
              </li>
              <li>
                <a href="https://www.travelguard.com/help-center/contact-us">Contact Us</a>
              </li>
            </ul>
          </div>
          <div class="col-12 col-sm-8">
            <h2>Terms and Condition</h2>
            <p>You, as a traveler, are provided with insurance benefits while traveling with us. Any travel related insurance benefits would be availed at Travel Guard ( https://www.aig.com/travel-guard ). <strong>We, Ebooktrip, are not responsible for any insurance related claim</strong>. If you have any questions about your current coverage, call your insurer or insurance agent or broker. Coverage is offered by Travel Guard Group, Inc (Travel Guard). California lic. no. 0B93606, 3300 Business Park Drive, Stevens Point, WI 54482, www.travelguard.com. CA DOI toll free number: 800-826-5248</p>
          </div>
        </div>
      </div>
    </section>
    </div>
  </div>
</div>
<div class="modal fade" id="travelAssistPopup" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <section class="">
            <div class="">
              <div class="col-12 banDFlex">
                <div class="row">
                    <div class="col-sm-4 col-12">
                      <img src="/resources/images/payment-img/logo.png" class="img-responsive logoT" alt="Logo" />
                    </div>
                </div>
              </div>
            </div>
        </section>
      <section class="banner bg-primary">
      <div class="container">
        <div class="row">
          <div class="col-12 banDFlex">
            <div class="col-sm-7 col-12">
              <h1><strong>Travel Assist</strong></h1>
              <p>Travel Assist is a revolutionary new product that provides travelers with the assistance they need to make their trips go as smoothly as possible. This includes everything from booking flights and hotels, to providing personalized recommendations for activities and attractions. With Travel Assist, users can easily plan and book their entire trip in minutes, without having to worry about the hassle of researching, planning and organizing each step of their journey. It can be used by WhatsApp, Voice calling, Massage text, Email, App or the website.</p>
            </div>
            <div class="col-sm-5 col-12"><img src="/resources/images/payment-img/auxiliary-hero.svg" alt="Image" class="img-responsive"></div>
          </div>
        </div>
      </div>
    </section>
    <section class="bodyContentSec">
      <div class="container">
        <div class="row">
          <div class="col-12 secton_1">
            <div class="col-12 text-center pd-0">
              <h2><strong>How travel assist is beneficial for the passengers?</strong></h2>
              <div class="allCenter col-12"><p class="col-sm-6 col-12">Travel assist is a great way to make any journey easier and more enjoyable. It can help you plan, book, and manage your trip from start to finish.</p></div>
            </div>
            <div class="col-12 pd-0 allCenter alignCenter">
              <div class="col-sm-6 col-12 aboutUsPop">
                <img src="/resources/images/payment-img/Image-brt.svg" alt="Image" class="img-responsive">
              </div>
              <div class="col-sm-6 col-12">
                <ul>
                  <li>Also with the help of travel assist, you can save time and money by booking the best deals for flights, hotels, car rentals, activities and more. </li>
                  <li>You can also get personalized recommendations on where to go and what to do during your trip. Travel assist also provides assistance with visa applications and other paperwork so that you don't have to worry about it yourself.</li>
                  <li>It can be quite daunting to plan a trip as there are so many factors to consider like accommodation, food, transportation and sightseeing. This is where travel assist comes in.</li>
                  <li>Travel assist is an online platform that helps travelers plan their trips with ease. It offers personalized recommendations based on your preferences and budget.</li>
                  <li>It also provides detailed information about the places you are visiting so that you can make the most out of your trip.</li>
                </ul>
                <p>With travel assist, you don't have to worry about missing out on any attractions or activities as it will provide all the necessary information in one place.</p>
              </div>
            </div>
          </div> 
        </div>
      </div>
    </section>
    <style type="text/css">
      footer { background:#242424; padding:20px 0; text-align:center; color:grey; }
    </style>
    <footer>
      <div class="container">
        <div class="row">
          <div class="col-12 text-center">
            &copy; Copyright by Ebooktrip 2023
          </div>
        </div>
      </div>
    </footer>
    </div>
  </div>
</div>
<div class="modal fade" id="priceDropProtectionPopup" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <section class="">
            <div class="">
              <div class="col-12 banDFlex">
                <div class="row">
                    <div class="col-sm-4 col-12">
                      <img src="/resources/images/payment-img/logo.png" class="img-responsive logoT" alt="Logo" />
                    </div>
                </div>
              </div>
            </div>
        </section>
      <section class="banner bg-primary">
      <div class="container">
        <div class="row">
          <div class="col-12 banDFlex">
            <div class="col-sm-7 col-12">
              <h1><strong>Price Drop Protection</strong></h1>
              <p>Finding a ticket for an impending flight is frequently a guessing game. You never know when the airline will make a promotion announcement and provide a better deal on your flight. Price Drop Protection was created specifically to cover these scenarios.</p>
            </div>
            <div class="col-sm-5 col-12"><img src="/resources/images/payment-img/auxiliary-hero.svg" alt="Image" class="img-responsive"></div>
          </div>
        </div>
      </div>
    </section>
    <section class="bodyContentSec">
      <div class="container">
        <div class="row">
          <div class="col-12 secton_1">
            <div class="col-12 text-center pd-0">
              <h2><strong>Why is it worth adding to my booking?</strong></h2>
              <div class="allCenter col-12"><p class="col-sm-6 col-12">You can purchase Price Drop Protection as an add-on service to your ticket, giving you the chance to save money in the event that the cost of your specific flight decreased.</p></div>
            </div>
            <div class="col-12 pd-0 allCenter alignCenter">
              <div class="col-sm-6 col-12 aboutUsPop">
                <img src="/resources/images/payment-img/Image-brt.svg" alt="Image" class="img-responsive">
              </div>
              <div class="col-sm-6 col-12">
                <p>Did you get the best deal on your ticket? What if prices on your journey are lower? In the event that you have even a slight qualm regarding the purchased airfare, this choice may prove to be quite helpful for you.</p>
                <p>Additionally, it spares you from worrying about any changes in the price of the purchased airfare within 24 hours of the booking's completion because we promise to notify you automatically of any changes in price.</p>
              </div>
            </div>
          </div> 
<style type="text/css">
.secton_5 { margin:100px 0 0 }
.secton_5 > div { background:#F5F7F9; border-radius:8px; }
</style>
          <div class="col-12 secton_5">
            <div class="col-12 allCenter alignCenter">
              <div class="col-sm-6 col-12">
                <h2>How you might benefit from It?</h2>
                <p>50% of the money saved is the Price Drop Protection portion.</p>
                <p>This share will be converted right away into a flight coupon that can be applied to your upcoming flight reservations with us.</p>
              </div>
              <div class="col-sm-6 col-12">
                <img src="/resources/images/payment-img/bi.svg" alt="Image" class="img-responsive" />
              </div>
            </div>
          </div>
<style type="text/css">
.secton_6 { margin:100px 0 0 }
.secton_6 .sct6Div { display:flex; width:100%; flex-wrap:wrap; justify-content:space-between; }
.secton_6 .sct6Div > div { width:32%; border:1px solid #E0E3EB; border-radius:8px; padding:32px; }
.secton_6 .sct6Div h4 { margin-top:20px; }
.secton_6 .sct6Div p { margin-bottom:0 !important; }
@media(max-width: 767px){
  .secton_6 .sct6Div > div { width:100%; }
}
</style>
          <div class="col-12 secton_1 secton_6">
            <div class="col-12 text-center pd-0">
              <h2><strong>The way it works</strong></h2>
              <div class="allCenter col-12"><p class="col-sm-6 col-12">Check out the actual work of the Price Drop Protection.</p></div>
            </div>
            <div class="sct6Div">
              <div class="">
                <div>
                  <img src="/resources/images/payment-img/st-1.svg" alt="Image" class="img-responsive" />
                  <h4><strong>WE SEARCH</strong></h4>
                  <p>Within 24 hours of booking, we conduct a search for the same flight numbers and departure dates to check for price changes for your precise route.</p>
                </div>
              </div>
              <div class="">
                <div>
                  <img src="/resources/images/payment-img/st-2.svg" alt="Image" class="img-responsive" />
                  <h4><strong>PRICE DROPS</strong></h4>
                  <p>If a lower price is discovered, we will rebook your flight and provide a new ticket with the same itinerary but a different booking number.</p>
                </div>
              </div>
              <div class="">
                <div>
                  <img src="/resources/images/payment-img/st-3.svg" alt="Image" class="img-responsive" />
                  <h4><strong>YOU SAVE</strong></h4>
                  <p>You'll receive a flight coupon for use on your upcoming reservation with us as a way of receiving the savings.</p>
                </div>
              </div>
            </div>
          </div>
<style type="text/css">
.secton_7 { margin:100px 0 0 }
</style>
          <div class="col-12 secton_1 secton_7">
            <div class="row">
              <div class="col-sm-6 col-12">
                <img src="/resources/images/payment-img/asc.svg" alt="Image" class="img-responsive">
              </div>
              <div class="col-sm-6 col-12">
                <h2>What else you should know?</h2>
                <p>The Price Drop Protection is a non-refundable option that could not be offered by all airlines or itineraries, and it doesn't ensure that you'll save any money because everything is based on the availability of lower prices.</p>
                <p>You should be informed that the airfare will remain as first booked if we are unable to detect any price changes, as there are instances where no price cuts occur within 24 hours of the booking being made.</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <style type="text/css">
      footer { background:#242424; padding:20px 0; text-align:center; color:grey; }
    </style>
    <footer>
      <div class="container">
        <div class="row">
          <div class="col-12 text-center">
            &copy; Copyright by Ebooktrip 2023
          </div>
        </div>
      </div>
    </footer>
    </div>
  </div>
</div>
<script>
$(document).ready(function(){
    var a = $(".proAddProd .itemss.active .itemssHead input").prop("checked");
    $(".proAddProd .itemss.active .itemssHead input").prop("checked", true);
    console.log(a)
})
function detailIconFun(id,cls){
    var clheight = $("."+cls).height();
    $("#"+id).toggleClass('active').css("top", clheight)
}
function detailIconCloseFun(id){
    $("#"+id).toggleClass('active')
}
</script>