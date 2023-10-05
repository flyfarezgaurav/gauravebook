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
     background-image:  url('/resources/images/enginebg.jpg');
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
            <h1>Flights To <span style="text-transform:capitalize;">${fn:replace(page,'-',' ')}</span> </h1>
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
    <br>
	
	<div class="about-airlines">
			
			${pageResponse.contentData}

			</div>
			
			<jsp:include page="customer-review.jsp" />
			
	<!--Footer Starts-->
    <jsp:include page="footer.jsp" />
</body>
<script src="/resources/scripts/script.js"></script>
</html>