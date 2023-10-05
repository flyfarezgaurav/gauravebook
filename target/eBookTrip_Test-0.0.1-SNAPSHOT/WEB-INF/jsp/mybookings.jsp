<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
    <title>My Bookings</title>
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
    <link rel="stylesheet" href="/resources/css/default.css?v=3.1">
    <style>
        .ee-navbar-items li:nth-child(1) a::after{transform:scaleX(1);}
    </style>    
<jsp:include page="tag-manager-head.jsp" /></head>
<body style="background-image:url('/resources/images/blog-body.jpg');background-repeat:no-repeat;background-attachment: fixed;background-size:100% 100%;">
    <jsp:include page="tag-manager-body.jsp" /><!--Header Area Starts Here-->
    <jsp:include page="header.jsp" />
    <div class="screen-overlay" id="screenoverlay" onclick="hidesidenav()"></div>
    <!--Header Ends Here-->
    <div class="blog-head">
        <span>Check My Booking</span>
    </div>
    <div class="bookings-form-container">
	<div class="bookings-form">
	   <div class="bform-head">
		Booking History
	   </div>
	   <div class="bform-head" style="font-size:16px; color:#f4f5f6;margin-top:10px;">
		We are one of the leading OTPs in America, offering travellers a comprehensive selection of air deals with over hundreds airlines.	   
	   </div>
	   <form:form class="bform" modelAttribute="myBookings" action="/mybookings">
		<form:input path="emailId" placeholder="Your Email" class="bemail" />
 		<form:input path="bookingId" placeholder="Booking ID" class="blname" />
		<form:input path="pnr" placeholder="PNR" class="bzcode" />
		<form:input path="mobile" placeholder="Phone" class="bzcode" />
		<button type="button" onclick="viewBookings()">View History</button>
	   </form:form>
	</div>
    </div>
    <!--Footer Starts-->
    <jsp:include page="footer.jsp" />
</body>
<script>
function viewBookings(){
	var emailId = $("#emailId").val();
	var bookingId = $("#bookingId").val();
	var pnr = $("#pnr").val();
	var mobile = $("#mobile").val();
	if(emailId == '' && bookingId == '' && pnr == '' && mobile == ''){
		alert("Please input alteast on value to view bookings");
		return false;
	}
	$("#myBookings").submit();
}
	 
</script> 
</html>