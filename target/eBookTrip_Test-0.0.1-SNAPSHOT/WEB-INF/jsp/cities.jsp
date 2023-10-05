<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>${pageResponse.metaTitle}</title>
    <meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="${pageResponse.metaDesc}">
    <meta name="keyword" content="${pageResponse.metaKeyword}">
    <link rel="canonical" href="https://www.ebooktrip.com/city/cheap-flights-to-${pageResponse.url}-${pageResponse.pageValue}">
    <link rel="icon" href="/resources/images/favicon.png">
    <link rel="preload" fetchpriority="high" as="image" href="/resources/images/enginebg.webp" type="image/webp">
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700&display=swap" rel="preload" as="font" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css">
    <link rel="stylesheet" href="/resources/css/default.css?v=2.7">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.min.js" crossorigin="anonymous"></script>
    <script type="text/javascript" src="//widget.trustpilot.com/bootstrap/v5/tp.widget.bootstrap.min.js" async></script>

<jsp:include page="tag-manager-head.jsp" /></head>
<body><jsp:include page="tag-manager-body.jsp" />
    <!--Header Area Starts Here-->
    <jsp:include page="header.jsp" />
    <div class="screen-overlay" id="screenoverlay" onclick="hidesidenav()"></div>
    <!--Header Ends Here-->
    <!--Engine Area Starts Here-->
	<input type="hidden" id="pageUrl" value="${pageResponse.url}" />
    <div class="engine-bg city-page-engine-bg">
        <div class="bg-overlay">
            <p class="flighttodesti">Flights To <span class="flighttodestiname">${fn:replace(page,'-',' ')}</span> </p>
            <jsp:include page="engine.jsp" />
            <!--Sign Up Area-->
            <!-- <div class="signup-section">
                <div class="signup-head"><b>SIGN UP</b> and <b>SAVE UP TO </b>  $20 off our fees with a promo code!</div>
                <div class="signup-inputs">
                    <input type="text" id="newsEmail" placeholder="Get Ebooktrip.com Emails">
                    <button type="button" onclick="newsalertsubmit()">Sign Up</button>
                 </div>
				<span id="newsMsg"></span>
                <div class="signup-footer">
                   
                    <li><a href="/privacy-policy">Privacy Policy</a></li>
                </div>
            </div> -->
            <!--Sign Up End Here-->
        </div>
    </div>
    <!--Engine Area Ends Here-->
    <div class="ebook-trustpilot-widget-review">
        <div class="center-container">
            <!-- TrustBox widget - Carousel -->
            <div class="trustpilot-widget" data-locale="en-US" data-template-id="53aa8912dec7e10d38f59f36"
                data-businessunit-id="5df2617cf1595900015d13d1" data-style-height="140px"
                data-style-width="100%" data-theme="light" data-stars="4,5" data-review-languages="en">
                <a href="https://www.trustpilot.com/review/ebooktrip.com" target="_blank"
                    rel="noopener">Trustpilot</a>
            </div>
            <!-- End TrustBox widget -->
         </div>
    </div>
    <!-- <div class="ad-banner">
       <a href="#"><img src="/resources/images/banner.jpg?v1.1"></a>
    </div> -->
    <!--Deals Section Starts-->
	
<style type="text/css">
.dealCitySec {
    display: grid; grid-template-columns: auto auto auto auto; gap: 20px;
}
.dealCitySec .dealBox { box-shadow: 0 0 5px #bbb2b2; border-radius: 6px; padding:15px; }
.dealCitySec .tFullSctn { display: grid; grid-template-columns: auto auto; }
.dealCitySec .tPartLft > div { font-size: 25px; font-weight: bold; color: #008a04; }
.dealCitySec .tPartLft > p { margin: 0; color: #646464; font-size: 13px; }
.dealCitySec .tPartLft sup { font-size:12px; }
.dealCitySec .tPartRht { color: #646464; }
.dealCitySec .tPartRht p { margin:0; }
.dealCitySec .dealProgress { display: flex; align-items: center; height: 30px; gap: 10px; margin-top:8px; }
.dealCitySec .dealProgress span { position: relative; width: 33.33%; display: inline-block; height: 6px; background: #008a04; border-radius: 4px; }
.dealCitySec .dealProgress span:nth-child(2) { background:#FF9800; }
.dealCitySec .dealProgress span:nth-child(3) { background:#FF5722; }
.dealCitySec .dealProgress span:nth-child(1):before { content:"\f0d7"; font-family:FontAwesome; color: #008a04; position: absolute; top: -15px; left: calc(50% - 4px); }
.dealCitySec .twoPice { display: flex; justify-content: space-evenly; color: #878787; font-size: 13px; margin: 4px 0 0; }
.dealCitySec .dealDetails { text-align: center; font-size: 12px; color: #878787; margin: 13px 0 0;display: flex; justify-content: center; align-items: center; }
.dealCitySec .dealDetails i { width: 20px; height: 20px; display: inline-flex;border: 1px solid #999999; border-radius: 20px; color: #afafaf; align-items: center; justify-content: center; margin: 0 0 0 5px; }
.cityDealsNewSec table { border-collapse: collapse; width: 100%; }
.cityDealsNewSec td, .cityDealsNewSec th { border: 1px solid #ddd !important; padding: 8px; }
.cityDealsNewSec td { height:70px; border-left:0 !important; border-right:0 !important }
.cityDealsNewSec tr:nth-child(even){background-color: #f2f2f2;}
.cityDealsNewSec tr:hover {background-color:#f2f2f2;}
.cityDealsNewSec th { padding-top: 12px !important; padding-bottom: 12px !important; text-align: left; background-color: #063d99; color: white; /*border: 1px solid #0b357c !important*/ border:0 !important }
.cityDealsNewSec th:last-child, .cityDealsNewSec td:last-child { text-align:right; }
.cityDealsNewSec td:last-child strong { font-size:30px; color:#063d99; cursor:pointer; font-weight:500; }
.cityDealsNewSec td:last-child strong sup { font-size: 12px; position: relative; top: -5px; }
.cityDealsNewSec thead { border:1px solid #063d99; }
.cityDealsNewSec tbody { border:1px solid #ddd }
@media(max-width: 767px){
    .dealCitySec { grid-template-columns: auto auto; }
}
@media(max-width:500px){
    .dealCitySec { grid-template-columns:auto; }
    .cityDealsNewSec th { font-size:12px }
    .cityDealsNewSec td { font-size:11px }
    .cityDealsNewSec td:last-child strong { font-size:20px }
    .cityDealsNewSec td:last-child strong sup { font-size: 10px; }
}
</style>
	<div class="aboutus static-content">
        <div class="ebook-whychoose-sec" style="">
            <h2 class="section-mainheading">Why <span class="bluecolor">Choose Us</span></h2>
            <div class="choose-cols">
                <div class="choose-box">
                    <div class="chooseimg">
                        <picture>
                            <source srcset="/resources/images/icons/choose-top-destination.webp" type="image/webp">
                            <img src="/resources/images/icons/choose-top-destination.png" alt="top-destination" width="5" height="5" loading="lazy" decoding="async">
                            </picture>
                    </div>
                    <p class="choose-heading">Top Destinations</p>
                    <p>Special Offers on over 2000+ Destinations</p>
                </div>

                <div class="choose-box">
                    <div class="chooseimg">
                        <picture>
                            <source srcset="/resources/images/icons/choose-easy-booking.webp" type="image/webp">
                            <img src="/resources/images/icons/choose-easy-booking.png" alt="easy-booking" width="5" height="5" loading="lazy" decoding="async">
                        </picture>
                    </div>
                    <p class="choose-heading">Easy Booking</p>
                    <p>One click booking</p>
                </div>

                <div class="choose-box">
                    <div class="chooseimg">
                        <picture>
                            <source srcset="/resources/images/icons/choose-customer-support.webp" type="image/webp">
                            <img src="/resources/images/icons/choose-customer-support.png" alt="easy-booking" width="5" height="5" loading="lazy" decoding="async">
                        </picture>    
                    </div>
                    <p class="choose-heading">Customer Support</p>
                    <p>We are available for our Customers round the clock 24/7</p>
                </div>

                <div class="choose-box">
                    <div class="chooseimg">
                        <picture>
                            <source srcset="/resources/images/icons/choose-secure-payment.webp" type="image/webp">
                            <img src="/resources/images/icons/choose-secure-payment.png" alt="choose-secure-payment" width="5" height="5" loading="lazy" decoding="async">
                        </picture>        
                    </div>
                    <p class="choose-heading">Secure Payment</p>
                    <p>The website has an SSL certificate to create a secure transactions</p>
                </div>
            </div>
        </div>

        <div class="nextTripDeals" style="">
            <h2>Found these great deals for your next trip</h2>
            <div class="dealCitySec">
                <div class="dealBox">
                    <div class="tFullSctn">
                        <div class="tPartLft">
                            <div>$286<sup>.06<span>*</span></sup></div>
                            <p>Round Trip</p>
                        </div>
                        <div class="tPartRht">
                            <p>
                                DXB <i class="fa fa-exchange"></i> DEL
                            </p>
                            <p>Nov 09 - Nov 14</p>
                        </div>
                    </div>
                    <div class="dealProgress">
                        <span></span>
                        <span></span>
                        <span></span>
                    </div>
                    <div class="twoPice">
                        <span>$351</span>
                        <span>$405</span>
                    </div>
                    <div class="dealDetails">
                        <span>How we calculate this</span><i class="fa fa-info" aria-hidden="true"></i>
                    </div>
                </div>
                <div class="dealBox">
                    <div class="tFullSctn">
                        <div class="tPartLft">
                            <div>$286<sup>.06<span>*</span></sup></div>
                            <p>Round Trip</p>
                        </div>
                        <div class="tPartRht">
                            <p>
                                DXB <i class="fa fa-exchange"></i> DEL
                            </p>
                            <p>Nov 09 - Nov 14</p>
                        </div>
                    </div>
                    <div class="dealProgress">
                        <span></span>
                        <span></span>
                        <span></span>
                    </div>
                    <div class="twoPice">
                        <span>$351</span>
                        <span>$405</span>
                    </div>
                    <div class="dealDetails">
                        <span>How we calculate this</span><i class="fa fa-info" aria-hidden="true"></i>
                    </div>
                </div>
                <div class="dealBox">
                    <div class="tFullSctn">
                        <div class="tPartLft">
                            <div>$286<sup>.06<span>*</span></sup></div>
                            <p>Round Trip</p>
                        </div>
                        <div class="tPartRht">
                            <p>
                                DXB <i class="fa fa-exchange"></i> DEL
                            </p>
                            <p>Nov 09 - Nov 14</p>
                        </div>
                    </div>
                    <div class="dealProgress">
                        <span></span>
                        <span></span>
                        <span></span>
                    </div>
                    <div class="twoPice">
                        <span>$351</span>
                        <span>$405</span>
                    </div>
                    <div class="dealDetails">
                        <span>How we calculate this</span><i class="fa fa-info" aria-hidden="true"></i>
                    </div>
                </div>
                <div class="dealBox">
                    <div class="tFullSctn">
                        <div class="tPartLft">
                            <div>$286<sup>.06<span>*</span></sup></div>
                            <p>Round Trip</p>
                        </div>
                        <div class="tPartRht">
                            <p>
                                DXB <i class="fa fa-exchange"></i> DEL
                            </p>
                            <p>Nov 09 - Nov 14</p>
                        </div>
                    </div>
                    <div class="dealProgress">
                        <span></span>
                        <span></span>
                        <span></span>
                    </div>
                    <div class="twoPice">
                        <span>$351</span>
                        <span>$405</span>
                    </div>
                    <div class="dealDetails">
                        <span>How we calculate this</span><i class="fa fa-info" aria-hidden="true"></i>
                    </div>
                </div>
            </div>
        </div>

        <div class="cityDealsNewSec" style="">
            <h2>Phoenix Flight Deals</h2>
            <!-- <div class="dealHeadng">
                
            </div> -->
            <div class="dealBody">
                <table>
                    <thead>
                        <tr>
                            <th>From</th>
                            <th>Depart</th>
                            <th>Return</th>
                            <th>Sample Fares*</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>SEA (Seattle)</td>
                            <td>Sep 16, 2023</td>
                            <td>Sep 19, 2023</td>
                            <td><strong>$94<sup>.99</sup></strong></td>
                        </tr>
                        <tr>
                            <td>PDX (Protland)</td>
                            <td>Sep 16, 2023</td>
                            <td>Sep 20, 2023</td>
                            <td><strong>$103<sup>.99</sup></strong></td>
                        </tr>
                        <tr>
                            <td>CHI (Chicago)</td>
                            <td>Oct 11, 2023</td>
                            <td>Oct 14, 2023</td>
                            <td><strong>$105<sup>.99</sup></strong></td>
                        </tr>
                        <tr>
                            <td>BOS (Boston)</td>
                            <td>Oct 13, 2023</td>
                            <td>Oct 17, 2023</td>
                            <td><strong>$116<sup>.99</sup></strong></td>
                        </tr>
                        <tr>
                            <td>PHL (Philadelphia)</td>
                            <td>Aug 29, 2023</td>
                            <td>Sep 2, 2023</td>
                            <td><strong>$124<sup>.99</sup></strong></td>
                        </tr>
                        <tr>
                            <td>ATL (Atlanta)</td>
                            <td>Aug 30, 2023</td>
                            <td>Sep 7, 2023</td>
                            <td><strong>$134<sup>.99</sup></strong></td>
                        </tr>
                        <tr>
                            <td>LAX (Los Angeles)</td>
                            <td>Aug 28, 2023</td>
                            <td>Aug 29, 2023</td>
                            <td><strong>$137<sup>.99</sup></strong></td>
                        </tr>
                        <tr>
                            <td>DTT (Detroit)</td>
                            <td>Sep 18, 2023</td>
                            <td>Sep 19, 2023</td>
                            <td><strong>$141<sup>.99</sup></strong></td>
                        </tr>
                        <tr>
                            <td>MSP (Minneapolis)</td>
                            <td>Oct 24, 2023</td>
                            <td>Nov 2, 2023</td>
                            <td><strong>$146<sup>.99</sup></strong></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>

        ${pageResponse.contentData}


    </div>

    <c:if test="${dealResponse.response.size() > 0}">
    <div class="best-deals city-flight">
        <div class="dealHeadScn">
            <p class="dealHeadScn-heading">Think Ahead and Plan Your Next Trip</p>
        </div>
        
        <div class="deals-section ">
            
            <!-- <hr> -->
            <div class="deal-blocks">
			
                <c:forEach var="deal" items="${dealResponse.response}" end="7">
			<fmt:parseDate value = "${deal.depDate}" var = "parsedDepDate" pattern = "yyyy-MM-dd" />
			<fmt:parseDate value = "${deal.retDate}" var = "parsedRetDate" pattern = "yyyy-MM-dd" />
			<fmt:formatDate pattern = "MM/dd/yyyy" value = "${parsedDepDate}" var="searchDepDate" />
			<fmt:formatDate pattern = "MM/dd/yyyy" value = "${parsedRetDate}" var="searchRetDate" />
                <div class="deal-item" onclick="dealclick('${deal.froCity}','${deal.toCity}','${searchDepDate}','${searchRetDate}');">
                    <img src="/resources/images/chicago.jpg" alt="deal-img" width="10" height="10">
                    <div class="deal-text">
                        <span class="cityname">${deal.toCityName}</span>
                        <span class="cityfromto">${deal.froCity} <i class="fa fa-arrows-h"></i> ${deal.toCity}</span>
						
                        <span class="datefromto"><fmt:formatDate pattern = "MMM dd" value = "${parsedDepDate}" /> &#8208; <fmt:formatDate pattern = "MMM dd" value = "${parsedRetDate}" /></span>
                        <div>
                            <span class="price">&#36;${deal.totalPrice}</span>
                            <button type="button">Search Now</button>
                        </div>
                    </div>
                </div>
             </c:forEach>
                
                
            </div>
        </div>
        
    </div>
		</c:if>
    
	<%--<div class="deals-customer-review">	
	        <jsp:include page="customer-review.jsp" />
    </div>	--%>
<style type="text/css">
.recentPostSec .blogRecent { display: grid; grid-template-columns: auto auto auto auto; gap: 15px; }
.recentPostSec .blogRecent img { max-width:100%; border-radius:10px 10px 0 0; height:140px }
.recentPostSec .blogRecent .blogBox { box-shadow: 0 0 10px gainsboro; border-radius: 10px; }
.recentPostSec .blogRecent .blogBox p { padding:0 15px; }
.recentPostSec .blogRecent .blogBox:hover { box-shadow:0 0 20px #afaeae; transition:all 0.3s; }
@media(max-width: 767px){
    .recentPostSec .blogRecent { grid-template-columns: auto auto; }
}
@media(max-width:500px){
    .recentPostSec .blogRecent { grid-template-columns:auto; }
}
</style>
    <div class="aboutus static-content">
        <div class="recentPostSec" style="">
            <h2>Recent Phoenix Posts</h2>
            <div class="blogRecent">
                <div class="blogBox">
                    <img src="/resources/images/blog/best-airline-discounts-for-us-students-sm.jpg" alt="best-airline-discounts-for-us-students-sm" />
                    <p>¡Tómatelo con Calma! Domina el "Slow Travel" Alrededor del Mundo</p>
                </div>
                <div class="blogBox">
                    <img src="/resources/images/blog/best-airline-discounts-for-us-students-sm.jpg" alt="best-airline-discounts-for-us-students-sm" />
                    <p>A Slice of Heaven — Where to Find the Best Cheesecake in New York City</p>
                </div>
                <div class="blogBox">
                    <img src="/resources/images/blog/best-airline-discounts-for-us-students-sm.jpg" alt="best-airline-discounts-for-us-students-sm" />
                    <p>Calling All History Buffs! Exploring the Legacy of the Buffalo Soldiers Across the U.S.</p>
                </div>
                <div class="blogBox">
                    <img src="/resources/images/blog/best-airline-discounts-for-us-students-sm.jpg" alt="best-airline-discounts-for-us-students-sm" />
                    <p>Tu Guía Definitiva para las Tendencias de Viaje Más Candentes del Verano</p>
                </div>
            </div>
        </div>
    </div>

	<!--Footer Starts-->
    <jsp:include page="footer.jsp" />
</body>
<script src="/resources/scripts/script.js?26_Aug-2023"></script>
</html>