<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>${pageResponse.metaTitle}</title>
	<meta name="description" content="${pageResponse.metaDesc}">
  <meta name="keyword" content="${pageResponse.metaKeyword}">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Mukta:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/resources/font-awesome/css/font-awesome.min.css">
    <link rel="icon" href="/resources/images/favicon.png">
    <script src="/resources/scripts/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="/resources/scripts/jquery-1.11.1.min.js"></script>
    <script src="/resources/scripts/jquery-ui.js"></script>
    <script src="/resources/scripts/jquery.validate.min.js"></script>
    <link rel="stylesheet" href="/resources/css/default.css?v=2.7">
    <style>
        .ee-navbar-items li:nth-child(1) a::after{transform:scaleX(1);}
      .engine-bg{   
     background-image: url('/resources/images/${fn:toLowerCase(pageResponse.pageType)}/${pageResponse.pageValue}.jpg'), url('/resources/images/enginebg.jpg');
     background-repeat:no-repeat;
     
    
}
    </style>    
<jsp:include page="tag-manager-head.jsp" /></head>
<body><jsp:include page="tag-manager-body.jsp" />
    <!--Header Area Starts Here-->
    <jsp:include page="header.jsp" />
    <div class="screen-overlay" id="screenoverlay" onclick="hidesidenav()"></div>
    <!--Header Ends Here-->
    <!--Engine Area Starts Here-->
	<input type="hidden" id="pageUrl" value="${pageResponse.url}" />
    <div class="engine-bg">
        <div class="bg-overlay">
            <div class="engine-embedded-navbar">
                <div class="ee-navbar-items">
                    <li><a href="#"><span>Flights</span></a></li>
                    <!-- <li><a href="#"><span>More</span></a></li>  -->
                </div>
            </div>
            <h1><span style="text-transform:capitalize;">${pageResponse.pageName}</span> Reservations</h1>
            <br>
            <jsp:include page="engine.jsp" />
            <!--Sign Up Area-->
            <div class="signup-section">
                <div class="signup-head"><b>SIGN UP</b> and <b>SAVE UP TO </b>  $20 off our fees with a promo code!</div>
                <div class="signup-inputs">
                    <input type="text" id="newsEmail" placeholder="Get Ebooktrip.com Emails">
                    <button type="button" onclick="newsalertsubmit()">Sign Up</button>
                </div>
				<span id="newsMsg"></span>
                <div class="signup-footer">
                   
                    <li><a href="/privacy-policy">Privacy Policy</a></li>
                </div>
            </div>
            <!--Sign Up End Here-->
        </div>
    </div>
    <!--Engine Area Ends Here-->
    <div class="ad-banner">
       <a href="#"><img src="/resources/images/banner.jpg?v1.1"></a>
    </div>
    <!--Deals Section Starts-->
	<c:if test="${dealResponse.response.size() > 0}">
    <div class="best-deals">
        <h2>Think Ahead and Plan Your Next Trip</h2>
        <div class="deals-section">
            <h3>Deals</h3>
            <hr>
            <div class="deal-blocks">
			
                <c:forEach var="deal" items="${dealResponse.response}" end="7">
			<fmt:parseDate value = "${deal.depDate}" var = "parsedDepDate" pattern = "yyyy-MM-dd" />
			<fmt:parseDate value = "${deal.retDate}" var = "parsedRetDate" pattern = "yyyy-MM-dd" />
			<fmt:formatDate pattern = "MM/dd/yyyy" value = "${parsedDepDate}" var="searchDepDate" />
			<fmt:formatDate pattern = "MM/dd/yyyy" value = "${parsedRetDate}" var="searchRetDate" />
                <div class="deal-item" onclick="dealclick('${deal.froCity}','${deal.toCity}','${searchDepDate}','${searchRetDate}');">
                    <img src="/resources/images/dubai.jpg">
                    <div class="deal-text">
                        <span class="cityname">${deal.toCityName}</span>
                        <span class="price">&#36;${deal.totalPrice}</span>
                        <span class="cityfromto">${deal.froCity} <i class="fa fa-arrows-h"></i> ${deal.toCity}</span>
						
                        <span class="datefromto"><fmt:formatDate pattern = "MMM dd" value = "${parsedDepDate}" /> &#8208; <fmt:formatDate pattern = "MMM dd" value = "${parsedRetDate}" /></span>
                        <button type="button">Search Now</button>
                    </div>
                </div>
             </c:forEach>
                
                
            </div>
        </div>
        
    </div> 
	</c:if>
    <!--About Airline Section Starts-->
    <div class="about-airline-city">
        <div class="about-topic">
            <div class="topic-head">
                Useful Insights about ${pageResponse.pageName}
            </div>
            <div class="topic-content">
                <div class="alternate-rows">
                    <div class="table-row">
                        <div class="table-cell">Hub Airports:</div>
                        <div class="table-cell">${pageResponse.airportHub}</div>
                    </div>
                    <div class="table-row">
                        <div class="table-cell">Head Quarter:</div>
                        <div class="table-cell">${pageResponse.headQuarters}</div>
                    </div>
                    <div class="table-row">
                        <div class="table-cell">Popular Route:</div>
                        <div class="table-cell"><a href="#">${pageResponse.popularRoutes}</a></div>
                    </div>
                    <div class="table-row">
                        <div class="table-cell">Popular Destinations:</div>
                        <div class="table-cell"><a href="#">${pageResponse.popularDest}</a></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="about-topic">
            <div class="topic-head">
                ${pageResponse.pageName} Travel Trends
            </div>
            <div class="topic-content">
				${pageResponse.travelTrends}
                <!--<li><strong>14%</strong> of Aeromexico passengers were over the age of <strong>60.</strong></li>
                <li><strong>10%</strong> of Aeromexico passengers traveled with kids under <strong>14.</strong></li>
                <li><strong>28%</strong> of Aeromexico passengers were millennials.</li>
                <li><strong>48%</strong> of Aeromexico passengers were female.</li>
                <li><strong>Mexico City</strong> was the most popular destination for Aeromexico passengers.</li>
                <li><strong>Mexico City International Airport</strong> was the most popular airport for Aeromexico travelers.</li>  -->
            </div>
        </div>
    </div>
    <div class="about-tab-container">
        <div class="about-tab">
            <div class="tabs-container">
                
                <div class="tab-item  active-tab">
                    Onboard Service
                </div>
                <div class="tab-item">
                    Premier Class
                </div>
                <div class="tab-item">
                    Club Premier
                </div>
            </div>
            
            <div class="tab-content">
                ${pageResponse.onboardService}
            </div>
            <div class="tab-content" style="display:none;">
                ${pageResponse.premierClass}
            </div>
            <div class="tab-content" style="display:none;">
                ${pageResponse.clubPremier}
            </div>
        </div>
    </div>
    <div class="about-airline-city">
        <div class="about-topic">
            <div class="topic-head">
               
            </div>
            <div class="topic-content">
                ${pageResponse.contentData}
            </div>
        </div>
    <!--    <div class="related-links">
            <div class="rl-item" style="width:100%">
                <div class="topic-head">
                    Airports Where Aeromexico Fly
                </div>
                <div class="rl-content">
                    <li><a href="#">Mexico City International Airport Flights</a></li>
                    <li><a href="#">Don Miguel Hidalgo Y Costilla International Airport Flights</a></li>
                    <li><a href="#">Hartsfield Jackson Atlanta International Airport Flights</a></li>
                    <li><a href="#">Los Angeles International Airport Flights</a></li>
                    <li><a href="#">Chicago O'hare International Airport Flights</a></li>
                    <li><a href="#">Cancun International Airport Flights</a></li>
                    <li><a href="#">John F Kennedy International Airport Flights</a></li>
                </div>
            </div>
            <div class="rl-item">
                <div class="topic-head">
                    Aeromexico Routes
                </div>
                <div class="rl-content">
                    <li><a href="#">Tijuana to Mexico City (TIJ to MEX)</a></li>
                    <li><a href="#">Atlanta to Mexico City (ATL to MEX)</a></li>
                    <li><a href="#">Mexico City to Chicago (MEX to CHI)</a></li>
                    <li><a href="#">Mexico City to Atlanta (MEX to ATL)</a></li>
                    <li><a href="#">Los Angeles to Mexico City (LAX to MEX)</a></li>
                </div>
            </div>
            <div class="rl-item">
                <div class="topic-head">
                    Aeromexico Destinations
                </div>
                <div class="rl-content">
                    <li><a href="#">Flights to Tijuana</a></li>
                    <li><a href="#">Flights to Mexico City</a></li>
                    <li><a href="#">Flights to Chicago</a></li>
                    <li><a href="#">Flights to Atlanta</a></li>
                    <li><a href="#">Flights to Los Angeles</a></li>
                </div>
            </div>
        </div>  -->
    </div>
    <!--About Airline Section End-->
	<jsp:include page="customer-review.jsp" />
    
	<!--Footer Starts-->
    <jsp:include page="footer.jsp" />
</body>
<script src="/resources/scripts/script.js"></script>
<script>
 $(".tab-item").click(function(){
        $(".tab-item").removeClass("active-tab")
        $(this).addClass("active-tab");
        $(".tab-content").hide();
        document.getElementsByClassName("tab-content")[$(this).index()].style.display="block";
    })
</script>
</html>