
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Find Flighst Tickets, Discounted Flight Deals | ebooktrip.com</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="agd-partner-manual-verification" />
    <meta name="DESCRIPTION" content="" />
    <link href="/resources/css/gfont.css" rel="stylesheet">
    <link rel="preload" as="style" href="/resources/font-awesome/css/font-awesome.min.css"/>
    <link rel="preload" as="image" href="/resources/images/enginebg.webp"/>
    <link rel="preload" as="image" href="/resources/images/logolb.webp"/>
    <link rel="preload" as="image" href="/resources/images/phone-call.png"/>
    <link rel="stylesheet" href="/resources/font-awesome/css/font-awesome.min.css">
    <link rel="icon" href="/resources/images/favicon.png">
    <link rel="stylesheet" href="/resources/css/jquery-ui.css">
    <link rel="stylesheet" href="/resources/css/default.css?28-dec-2021">
    <style>
        body {padding-top: 5px;}
    </style>    
<jsp:include page="tag-manager-head.jsp" /></head>
<body><jsp:include page="tag-manager-body.jsp" />
    <!--Header Area Starts Here-->
    <div class="header">
        <div class="upper-logo">
            <a href="/"><img src="/resources/images/logo.png" alt="logo"></a>
        </div>
        
        <div class="upper-menu" >
            <ul class="up-nav_group">
                <li class=""><a href="/" title="Home"> <span data-hover="Home">Home</span> </a> </li>
                <li class="active__nav"><a href="/flights" title="Flights"> <span data-hover="Flights">Flights</span> </a> </li>
                <li> <a style="cursor:pointer;" id="mysea"><i class="fa fa-search"></i> <span data-hover="My Searches">My Searches</span><span class="tok" id="searchCount"></span></a>
                <div class="searches"></div></li> 
                <c:if test="${userLogin == null}">
                    <!-- <li><a href="/login"><span data-hover="My Bookings">My Bookings</span></a></li>
                    <li><a href="/signup"><span data-hover="Sign Up">Sign Up</span></a></li> -->
                    </c:if>
                    <c:if test="${userLogin != null}">
                    <li><a href="/mybookings"><span data-hover="My Bookings">My Bookings</span></a></li>
                    <li><a href="#" style="text-transform:capitalize;"><i class="fa fa-user-circle"></i> Welcome ${userLogin.userName}</a></li>
                    <li><a href="/logout"><i class="fa fa-sign-out"></i>  <span data-hover="Logout">Logout</span></a></li>
                    </c:if>

                <!-- <li><a href="/admin"><i class="fa fa-user-circle"></i>   <span data-hover="Sign In">Sign In </span></a></li> -->
 
            </ul>
        </div>
        
        
        <div class="expertisetalk">
            <span class="callicon desktopMobView"><img src="/resources/images/customer-care-img.png"
                    alt="phonek" width="5" height="5" loading="lazy" decoding="async"></span>
            <span class="desktopMobView">Call Us 24/7 for Lowest Airfares</span>
            <a href="tel:+1(800)404-0025" class="desktopMobView"
                title="Call Us 24/7 for Lowest Airfares">+1-800-404-0025</a>

            <a href="tel:+1(800)404-0025" class="mobileMobView"><img
                    src="/resources/images/icons/telephone.png" class="telephone-img" alt="telephone" width="5" height="5" loading="lazy" decoding="async"></a>
        </div>
        <div style="clear: both;"></div>


        <div class="side-navbar-button">
            <button type="button" onclick="showsidenav()" aria-label="showsidenav"><i class="fa fa-bars"></i></button>
        </div>
    </div>
    <div class="side-navbar" id="sidenavbar">
        <ul>
            <li><span>MENU</span><button type="button" onclick="hidesidenav()" aria-label="hidesidenav"><i class="fa fa-close"></i></button></li>
            <li><a href="/">Home</a></li>
            <li><a href="/flights">Flights</a></li>
            <li><a href="/blogs">Blog</a></li>
            <li><a href="/contactus">Contact Us</a></li>
            <li><a href="/terms-and-conditions">Terms & Conditions</a></li>
            <li><a href="/privacy-policy">Privacy Policy</a></li>
         </ul>
        <p>Copyright &copy;  2021 - 2023, ebooktrip.com All rights reserved.</p>
    </div>
    <div class="screen-overlay" id="screenoverlay" onclick="hidesidenav()"></div>
    <!--Header Ends Here-->
    <!--Engine Area Starts Here-->
    <div class="engine-bg">
        <div class="bg-overlay">
            <!-- <div class="engine-embedded-navbar">
                <div class="ee-navbar-items">
                    <li><a href="#"><span>FLIGHTS</span></a></li>
                   
                </div>
            </div> -->
            <!-- <h1>Compare and Book Cheap Flights on Over 600 Airlines</h1>
            <br> -->
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
    <!-- <div class="ad-banner">
       <a href="#"><img src="/resources/images/banner.jpg"></a>
    </div> -->
    <!--Deals Section Starts-->

    <style>
        .flightpage-content.static-content {padding-bottom: 10px;}
        .flightpage-content.static-content h1.subheadings {font-size: 18px;}
        @media only screen and (max-width:767px) {
            .best-deals.best-flightpage-content {margin-top: 0px;}
            .flightpage-content.static-content h1 {margin-top: 0;}
        }

    </style>

    <div class="aboutus">
        <div class="flightpage-content static-content">
            <h1 class="subheadings">Best Flight Deals from  <span>Top Airlines</span></h1>
            <p>What more is required when booking a family or business trip at a very low ticket and being able to afford the best airline service? When searching for Top Flights to book a trip, whether it be for business or with family, one can find them all at <strong>ebooktrip.com</strong>. Here, a person can look for flights that guarantee an enjoyable trip and a better travel experience at a reasonable price. Additionally, using ebooktrip.com credit cards to make bookings will earn you points. With these points, you can get a significant discount on any flight, possibly an upgrade to business class, and many other benefits.</p>
            <p>You can easily get these Top Airlines' discounts here, making it impossible for anyone to misunderstand them. They can do all of their pricing, offer, and discount comparisons in one location. A person can search through thousands of hotels, Cheap Flights, rental vehicles, and other options all in one location. One can therefore be sure to get the greatest and most accurate deals at <strong>ebooktrip.com</strong>. Just sign in to your ebooktrip.com account to get the lowest prices on your preferred Top Airlines and hotels and to enjoy your travels.</p>
        </div>
        <hr>
    </div>
    <!--Deal Section End-->

    <!--Footer Starts-->
    <jsp:include page="footer.jsp" />
</body>
<script src="https://code.jquery.com/jquery-2.0.0.min.js" integrity="sha256-1IKHGl6UjLSIT6CXLqmKgavKBXtr0/jJlaGMEkh+dhw=" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/ui/1.10.4/jquery-ui.min.js" integrity="sha256-oTyWrNiP6Qftu4vs2g0RPCKr3g1a6QTlITNgoebxRc4=" crossorigin="anonymous"></script>
 <script src="/resources/scripts/jquery.validate.min.js"></script>
<script src="/resources/scripts/script.js?26_Aug-2023"></script>
</html>