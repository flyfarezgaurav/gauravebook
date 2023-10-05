<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
    <link href='https://fonts.googleapis.com/css?family=Chivo' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet'>
     <style>
        .ee-navbar-items li:nth-child(1) a::after{transform:scaleX(1);}
	.booking-tabs{margin:5px auto;max-width:1200px;display:flex;border-bottom:1px solid #ddd;}
	.booking-tabs span{padding:5px 15px;color:#002142;font-size:18px;font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;cursor:pointer;font-weight:500;}
	.active-btab{background-color:#002142;color:#ffffff !important;border-radius:8px 8px 0 0;}
	@media only screen and (max-width: 1220px)
	{.booking-tabs{margin:5px 20px;}}
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
	<c:if test="${mybookingResponse.size() > 0}">
    <div class="history-table-container">
	<div class="booking-tabs">
	   <span id="allBookingTab" class="btab active-btab">All Bookings</span>
	   <span id="upcomingTab" class="btab">Upcoming</span>
	   <span id="completedTab" class="btab">Completed</span>
	   <span id="cancelledTab" class="btab">Cancelled</span>
	</div>
	<div class="history-table" id="allBookings">
	
	   <table style="width:100%;">
		<thead>
		    <tr>
		       <th colspan="10" class="table-head">Booking History</th>
	  	    </tr>
	            <tr>
		       	<th>S. No.</th>
			<th>Reference No.</th>
			<th>Status</th>
			<th>Product</th>
			<th>EmailId</th>
			<th>Route</th>
			<th>Travel Date</th>
			<th>Pax Name</th>
			<th>Total Price</th>
			<th>Booking Date</th>
		    </tr>
	 	</thead>
	        <tbody>
			<c:forEach var="mybooking" items="${mybookingResponse}" varStatus="loop">
		   <tr>
	  	      	<td>${loop.index+1}</td>
			<td><a href="#" onclick="getBookingDetails('${mybooking.orderNum}');" class="refno" style="color:#002192">${mybooking.referenceNum}</a></td>
			<td>${mybooking.bookingStatus}</td>
			<td>${mybooking.productType}</td>
			<td>${mybooking.emailId}</td>
			<td>${mybooking.froCity} - ${mybooking.toCity}</td>
			<fmt:parseDate value="${mybooking.travelDate}" var="travelDate" pattern="yyyy-MM-dd HH:mm:ss" />
			<td><fmt:formatDate value="${travelDate}" pattern="EEE, MMM dd" /></td>
			<td>${mybooking.passFrstName} ${mybooking.passLastName}</td>
			<td>$${mybooking.totalAmount}</td>
			<fmt:parseDate value="${mybooking.bookingDate}" var="bookingDate" pattern="yyyy-MM-dd HH:mm:ss" />
			<td><fmt:formatDate value="${bookingDate}" pattern="EEE, MMM dd" /></td>
		   </tr>
		   </c:forEach>

	        </tbody>
	   </table>
	</div>
	<div class="history-table" id="upcomingBookings" style="display:none;">
	
	   <table style="width:100%;">
		<thead>
		    <tr>
		       <th colspan="10" class="table-head">Booking History</th>
	  	    </tr>
	            <tr>
		       	<th>S. No.</th>
			<th>Reference No.</th>
			<th>Status</th>
			<th>Product</th>
			<th>EmailId</th>
			<th>Route</th>
			<th>Travel Date</th>
			<th>Pax Name</th>
			<th>Total Price</th>
			<th>Booking Date</th>
		    </tr>
	 	</thead>
	        <tbody>
			<c:forEach var="mybooking" items="${mybookingResponse}" varStatus="loop">
			<c:if test="${mybooking.daydiff >= 0}">
		   <tr>
	  	      	<td>${loop.index+1}</td>
			<td><a href="#" onclick="getBookingDetails('${mybooking.orderNum}');" class="refno" style="color:#002192">${mybooking.referenceNum}</a></td>
			<td>${mybooking.bookingStatus}</td>
			<td>${mybooking.productType}</td>
			<td>${mybooking.emailId}</td>
			<td>${mybooking.froCity} - ${mybooking.toCity}</td>
			<fmt:parseDate value="${mybooking.travelDate}" var="travelDate" pattern="yyyy-MM-dd HH:mm:ss" />
			<td><fmt:formatDate value="${travelDate}" pattern="EEE, MMM dd" /></td>
			<td>${mybooking.passFrstName} ${mybooking.passLastName}</td>
			<td>$${mybooking.totalAmount}</td>
			<fmt:parseDate value="${mybooking.bookingDate}" var="bookingDate" pattern="yyyy-MM-dd HH:mm:ss" />
			<td><fmt:formatDate value="${bookingDate}" pattern="EEE, MMM dd" /></td>
		   </tr>
		   </c:if>
		   </c:forEach>

	        </tbody>
	   </table>
	</div>
	
	<div class="history-table" id="completedBookings" style="display:none;">
	
	   <table style="width:100%;">
		<thead>
		    <tr>
		       <th colspan="10" class="table-head">Booking History</th>
	  	    </tr>
	            <tr>
		       	<th>S. No.</th>
			<th>Reference No.</th>
			<th>Status</th>
			<th>Product</th>
			<th>EmailId</th>
			<th>Route</th>
			<th>Travel Date</th>
			<th>Pax Name</th>
			<th>Total Price</th>
			<th>Booking Date</th>
		    </tr>
	 	</thead>
	        <tbody>
			<c:forEach var="mybooking" items="${mybookingResponse}" varStatus="loop">
			<c:if test="${mybooking.daydiff < 0}">
		   <tr>
	  	      	<td>${loop.index+1}</td>
			<td><a href="#" onclick="getBookingDetails('${mybooking.orderNum}');" class="refno" style="color:#002192">${mybooking.referenceNum}</a></td>
			<td>${mybooking.bookingStatus}</td>
			<td>${mybooking.productType}</td>
			<td>${mybooking.emailId}</td>
			<td>${mybooking.froCity} - ${mybooking.toCity}</td>
			<fmt:parseDate value="${mybooking.travelDate}" var="travelDate" pattern="yyyy-MM-dd HH:mm:ss" />
			<td><fmt:formatDate value="${travelDate}" pattern="EEE, MMM dd" /></td>
			<td>${mybooking.passFrstName} ${mybooking.passLastName}</td>
			<td>$${mybooking.totalAmount}</td>
			<fmt:parseDate value="${mybooking.bookingDate}" var="bookingDate" pattern="yyyy-MM-dd HH:mm:ss" />
			<td><fmt:formatDate value="${bookingDate}" pattern="EEE, MMM dd" /></td>
		   </tr>
		   </c:if>
		   </c:forEach>

	        </tbody>
	   </table>
	</div>
	
	<div class="history-table" id="cancelledBookings" style="display:none;">
	
	   <table style="width:100%;">
		<thead>
		    <tr>
		       <th colspan="10" class="table-head">Booking History</th>
	  	    </tr>
	            <tr>
		       	<th>S. No.</th>
			<th>Reference No.</th>
			<th>Status</th>
			<th>Product</th>
			<th>EmailId</th>
			<th>Route</th>
			<th>Travel Date</th>
			<th>Pax Name</th>
			<th>Total Price</th>
			<th>Booking Date</th>
		    </tr>
	 	</thead>
	        <tbody>
			<c:forEach var="mybooking" items="${mybookingResponse}" varStatus="loop">
			<c:if test="${mybooking.bookingStatus == 'Cancelled'}">
		   <tr>
	  	      	<td>${loop.index+1}</td>
			<td><a href="#" onclick="getBookingDetails('${mybooking.orderNum}');" class="refno" style="color:#002192">${mybooking.referenceNum}</a></td>
			<td>${mybooking.bookingStatus}</td>
			<td>${mybooking.productType}</td>
			<td>${mybooking.emailId}</td>
			<td>${mybooking.froCity} - ${mybooking.toCity}</td>
			<fmt:parseDate value="${mybooking.travelDate}" var="travelDate" pattern="yyyy-MM-dd HH:mm:ss" />
			<td><fmt:formatDate value="${travelDate}" pattern="EEE, MMM dd" /></td>
			<td>${mybooking.passFrstName} ${mybooking.passLastName}</td>
			<td>$${mybooking.totalAmount}</td>
			<fmt:parseDate value="${mybooking.bookingDate}" var="bookingDate" pattern="yyyy-MM-dd HH:mm:ss" />
			<td><fmt:formatDate value="${bookingDate}" pattern="EEE, MMM dd" /></td>
		   </tr>
		   </c:if>
		   </c:forEach>

	        </tbody>
	   </table>
	</div>
	
    </div>
	</c:if>
	
	<c:if test="${mybookingResponse.size() == 0}">
    <div class="history-table-container">
	<div class="history-table">
	<span align="center"><strong>No Bookings Found</strong></span>
	</div>
	</div>
	</c:if>
    <div id="bookingDetails"></div>
    <style>
	.history-table-container
	{
	   background-color:#ffffff;
	   padding:30px 0;
        }
	.history-table
	{
	   max-width:1200px;
	   margin:auto;
	   border:1px solid #ccc;
	   padding:10px;
	   overflow:auto;
	   font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
	}
	th,td,table
	{
	   border:1px solid #ccc;
	   border-collapse:collapse
	}
	th
	{
	   padding:8px;
	   font-size:15px;
	   color:#202020;
	   font-weight:500;
	   text-align:left;
	}
	td
	{
	   padding:8px;
	   color:#505050;
	}
	.table-head
	{
	   color:#ffffff;
	   text-align:left;
	   padding:10px 5px;
	   color:#ffffff;
	   background-color:#002142;
	   border-color:#002142;
	   font-size:16px;
	}
	@media only screen and (max-width:1220px)
	{
	   .history-table{margin:0 20px;}
	}
	.booking-screen-overlay
	{
    	   position:fixed;
    	   top:0;
    	   width:100%;
    	   height:100%;
    	   background-color:rgba(0,0,0,0.6);
    	   display:flex;
    	   justify-content:center;
    	   align-items:center;
    	   z-index:1001;
    	   display:none;
	}
	.booking
	{
	   background-color:#ffffff;
   	   border-radius:5px;
   	   padding:20px;
    	   box-shadow:1px 1px 1px #909090,-1px -1px 1px #909090,1px -1px 1px #909090,-1px 1px 1px #909090;
   	   font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
    	   width:90%;
	   height:90%;
	   overflow:auto;
	}
.mycontainer
{
    max-width:1366px;
    margin:auto;
    overflow:auto;
}
.booking-confirm
{
    width:76%;
    margin:10px 12%;
    display:flex;
    flex-direction:column;
    justify-content:center;
    text-align:center;
}
.booking-confirm img
{
    width:100px;
    height:100px;
    margin:auto;
}
.booking-confirm a
{
    color:#17252A;
}
.booking-confirm a:hover
{
    text-decoration:none;
}
.booking-confirm div:nth-child(2)
{
    font-family:'Raleway';
    font-size:22px;
    color:#17252A;
    font-weight:600;
}
.booking-confirm div:nth-child(3)
{
    font-family:Arial, Helvetica, sans-serif;
    font-size:16px;
    color:#666;
}
.booking-confirm div:nth-child(4)
{
    font-family:Arial, Helvetica, sans-serif;
    font-size:16px;
    color:#666;
}
.booking-confirm div:nth-child(5)
{
    font-family:Arial, Helvetica, sans-serif;
    font-size:30px;
    color:#17252A;
    font-weight:600;
}
.flight-summary
{
    width:76%;
    margin:10px 12%;
    display:flex;
    flex-direction:column;
    justify-content:center;
    border:1px solid #ddd;
}
.fshead
{
    font-size:18px;
    font-family:'Raleway';
    font-weight:600;
    color:#fff;
    background-color:#FF4500;
    padding:5px 15px;
}
.drfhead
{
    width:98%;
    margin:5px 1%;
    font-family:'Raleway';
    font-weight:600;
    color:#17252A;
    font-size:17px;
}
.drfhead span
{
    color:#666;
    font-size:16px;
    font-family:Arial, Helvetica, sans-serif;
    font-weight:400;
}
.fdetails
{
    width:98%;
    margin:10px 1%;
    display:flex;
    justify-content:space-between;
}
.fdetails .col1
{
    display:flex;
    flex-direction:column;
    justify-content:left;
    text-align:left;
}
.fdetails .col1 div:nth-child(1) img
{
    width:50px;
    height:30px;
}
.fdetails .col1 div:nth-child(1)
{
    color:#17252A;
    font-weight:600;
    font-family:'Raleway';
}
.fdetails .col2
{
    display:flex;
    flex-direction:column;
    justify-content:center;
    text-align:center;
}
.fdetails .col2 div:nth-child(1)
{
    font-family:Arial, Helvetica, sans-serif;
    color:#17252A;
    font-size:15px;
    font-weight:500;
    height:30px;
}
.fdetails .col2 div:nth-child(1) span
{
    font-family:Arial, Helvetica, sans-serif;
    color:#666;
    font-size:14px;
    font-weight:400;
}
.fdetails .col3
{
    display:flex;
    flex-direction:column;
    justify-content:right;
    text-align:right;
}
.fdetails .col3 div:nth-child(1)
{
    font-family:Arial, Helvetica, sans-serif;
    color:#17252A;
    font-size:15px;
    font-weight:500;
    height:30px;
}
.fdetails .col3 div:nth-child(1) span
{
    font-family:Arial, Helvetica, sans-serif;
    color:#666;
    font-size:14px;
    font-weight:400;
}
.fdetails .col1 div:nth-child(2),.fdetails .col2 div:nth-child(2),.fdetails .col3 div:nth-child(2)
{
    font-family:Arial, Helvetica, sans-serif;
    color:#17252A;
    font-size:15px;
    margin:5px 0;
}
.fdetails .col1 div:nth-child(4),.fdetails .col2 div:nth-child(4),.fdetails .col3 div:nth-child(4)
{
    font-family:Arial, Helvetica, sans-serif;
    color:#17252A;
    font-size:15px;
}
.fdetails .col1 div:nth-child(3),.fdetails .col3 div:nth-child(3)
{
    font-family:Arial, Helvetica, sans-serif;
    color:#17252A;
    font-weight:700;
}
.fdetails .col1 div:nth-child(3) span,.fdetails .col3 div:nth-child(3) span
{
    font-family:Arial, Helvetica, sans-serif;
    color:#666;
    font-size:16px;
    font-weight:400;
}
.fdetails .col2 div:nth-child(2)
{
    font-family:Arial, Helvetica, sans-serif;
    color:#17252A;
    font-size:22px;
    font-weight:700;
    margin:-5px 0;
}
.stop-divider
{
    width:100%;
    text-align:center;
    font-size:13px;
    color:#777;
    border-bottom:1px dashed #777;
    margin:0;
}
.stop-divider span
{
    background:#fff;
    padding:0 10px;
    position:relative;
    top:7px;
}
hr
{
    border:1px solid #ccc;
    width:100%;
}
.traveler-details
{
    width:76%;
    margin:10px 12%;
    display:flex;
    flex-direction:column;
    justify-content:center;
    border:1px solid #ddd;
}
.tdhead
{
    font-size:18px;
    font-family:'Raleway';
    font-weight:600;
    color:#fff;
    background-color:#FF4500;
    padding:5px 15px;
}
.tdtable
{
    width:98%;
    margin:5px 1%;
    text-align:center;
}
.tdtable tr:nth-child(odd)
{
    background-color:#eee;
}
.tdtable tr:nth-child(1)
{
    background-color:#ddd;
    color:#17252A;
    font-family:'Raleway';
}
.tdtable td,.tdtable th
{
    padding:5px;
    text-align:center;
}
.contact-details
{
    width:76%;
    margin:10px 12%;
    display:flex;
    flex-direction:column;
    justify-content:center;
    border:1px solid #ddd;
}
.cdhead
{
    font-size:18px;
    font-family:'Raleway';
    font-weight:600;
    color:#fff;
    background-color:#FF4500;
    padding:5px 15px;
}
.cdtable
{
    width:98%;
    margin:5px 1%;
    text-align:center;
    display:flex;
}
.cdtable div
{
    width:30%;
}
.cdtable div:nth-child(3)
{
    width:40%;
}
.cdtable div span:nth-child(1)
{
    display:flex;
    background-color:#ddd;
    width:100%;
    padding:5px 0;
    justify-content:center;
    font-family:'Raleway';
    font-weight:600;
    color:#17252A;
}
.cdtable div span:nth-child(2)
{
    display:flex;
    width:100%;
    padding:5px 0;
    justify-content:center;
    color:#17252A;
}
.price-details
{
    width:76%;
    margin:10px 12%;
    border:1px solid #ddd;
}
.pdhead
{
    font-size:18px;
    font-family:'Raleway';
    font-weight:600;
    color:#fff;
    background-color:#FF4500;
    padding:5px 15px;
}
.person-price
{
    width:100%;   
}
.tpp
{
    width:96%;
    margin:5px 2%;
    font-family:Arial, Helvetica, sans-serif;
    font-weight:550;
    display:flex;
    justify-content:space-between;
    font-size:15px;
}
.fcp,.tfp
{
    width:96%;
    margin:5px 2%;
    font-family:Arial, Helvetica, sans-serif;
    font-size:13px;
    display:flex;
    justify-content:space-between;
}
.total-price
{
    width:100%;
    padding:5px 2%;
    font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
    display:flex;
    justify-content:space-between;
    background-color:#002142;
    color:#ffffff;
    font-size:19px;
    font-weight:520;
}
.price-details p
{
    width:100%;
    padding:5px 2%;
    margin:0;
    font-size:11px;
    color:#333;
    font-family:Arial, Helvetica, sans-serif;
    text-align:center;
    background-color:#fff;
}
.tcs
{
    width:76%;
    margin:10px 12%;
    padding:10px;
    color:#333;
    font-family: Arial, Helvetica, sans-serif;
}
.tcs p
{
    font-size:14px;
}
.tcs p span
{
    font-weight:550;
    color:222;
}

@media screen and (max-width:992px)
{
    .header{position:static;}
    #call1{display:none;}
    #call2{display:block;}
    .booking-confirm,.flight-summary,.traveler-details,
    .contact-details,.tcs,.price-details{width:96%;margin:10px 2%;}
}
@media screen and (max-width:768px)
{
.cdtable,.tdtable{font-size:15px;}
.cdtable{flex-direction:column;}
.cdtable div{width:100%;}
.cdtable div:nth-child(3){width:100%;}
.drfhead{font-size:15px;}
.drfhead span{font-size:14px;}
.fdetails{font-size:13px;}
.fdetails .col2 div:nth-child(1),.fdetails .col3 div:nth-child(1){font-size:13px;}
.fdetails .col2 div:nth-child(1) span,.fdetails .col3 div:nth-child(1) span{font-size:12px;}
.fdetails .col1 div:nth-child(2),.fdetails .col2 div:nth-child(2),
.fdetails .col3 div:nth-child(2),.fdetails .col1 div:nth-child(4),
.fdetails .col2 div:nth-child(4),.fdetails .col3 div:nth-child(4){font-size:13px;}
.fdetails .col1 div:nth-child(3) span,.fdetails .col3 div:nth-child(3) span{font-size:14px;} 
.stop-divider{font-size:11px;}
}
@media screen and (max-width:480px)
{
    .drfhead{font-size:14px;}
    .drfhead span{font-size:13px;}
    .fdetails{font-size:12px;}
    .fdetails .col2 div:nth-child(1),.fdetails .col3 div:nth-child(1){font-size:12px;}
    .fdetails .col2 div:nth-child(1) span,.fdetails .col3 div:nth-child(1) span{font-size:11px;}
    .fdetails .col1 div:nth-child(2),.fdetails .col2 div:nth-child(2),
    .fdetails .col3 div:nth-child(2),.fdetails .col1 div:nth-child(4),
    .fdetails .col2 div:nth-child(4),.fdetails .col3 div:nth-child(4){font-size:12px;}
    .fdetails .col1 div:nth-child(3) span,.fdetails .col3 div:nth-child(3) span{font-size:13px;} 
    .stop-divider{font-size:11px;}
}
.t-and-c-close,.p-and-p-close
{
    display:flex;
    justify-content:space-between;
}
.t-and-c-close i,.p-and-p-close i
{
    cursor: pointer;
    color:#707070;
}

    </style>
    <!--Footer Starts-->
   <jsp:include page="footer.jsp" />
</body>
<script src="/resources/scripts/script.js?01112024"></script>
<script>
$(".refno").click(function(){
	$(".booking-screen-overlay").css("display","flex");
});
$(".p-and-p-close").click(function(){
	$(".booking-screen-overlay").css("display","none");
});

function getBookingDetails(bookingId){
	alert(bookingId);
  /*$.get("/getbookingdetails/"+bookingId, function(data, status){
    alert("Data: " + data + "\nStatus: " + status);
  });*/
  
  $.ajax({
                       type: "GET",
                       url: "/getbookingdetails/"+bookingId,
                        dataType: "html",
                          success: function(data) 
                          { 
                          $("#bookingDetails").html(data);
						    $(".booking-screen-overlay").css("display","flex");
                            $(".p-and-p-close").click(function(){
								$(".booking-screen-overlay").css("display","none");
							});
                          }

                         });
						 
}

	$("#allBookingTab").click(function(){
		$("#allBookings").show();
		$("#completedBookings,#upcomingBookings,#cancelledBookings").hide();
		$(".btab").removeClass("active-btab");
		$(this).addClass("active-btab");
	})
	$("#upcomingTab").click(function(){
		$("#upcomingBookings").show();
		$("#completedBookings,#allBookings,#cancelledBookings").hide();
		$(".btab").removeClass("active-btab");
		$(this).addClass("active-btab");
	})
	$("#completedTab").click(function(){
		$("#completedBookings").show();
		$("#allBookings,#upcomingBookings,#cancelledBookings").hide();
		$(".btab").removeClass("active-btab");
		$(this).addClass("active-btab");
	})
	$("#cancelledTab").click(function(){
		$("#cancelledBookings").show();
		$("#completedBookings,#upcomingBookings,#allBookings").hide();
		$(".btab").removeClass("active-btab");
		$(this).addClass("active-btab");
	})
</script>

</html>