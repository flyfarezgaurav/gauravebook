<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


  <div class="star_select" id="ratingdis0"></div> 
                               
    <script type="text/javascript">         
                  var rating =5
       rating = Math.round(rating * 2) / 2;
        output = [];

  // Append all the filled whole stars
  for (var i = rating; i >= 1; i--)
    output.push('<i class="fa fa-star" style="color:#3b5998;font-size:18px;margin-right:2px;" aria-hidden="true"></i>');

  // If there is a half a star, append it
  if (i == .5) output.push('<i class="fa fa-star-half-o" style="color:#3b5998;font-size:18px;margin-right:2px;" aria-hidden="true"></i>');

  // Fill the empty stars
  for (let i = (5 - rating); i >= 1; i--)
    output.push('<i class="fa fa-star-o" style="font-size:18px;margin-right:2px;" aria-hidden="true"></i>');
console.log(output);
  //$("#ratingdis0").html(output.join(''));
    
</script>

<div class="sreviews-container">
<c:if test="${reviewResponse.size() > 0}">
   <div class="review-heading">
        <span>Reviews & Ratings</span>
   </div>
   </c:if>
   <c:forEach var="review" items="${reviewResponse}">
   <div class="sreviews">
	<div class="suser-info">
	   <!-- <img src="/resources/images/user.jpg"> -->
	   <div class="suser-name-ago">
		<div class="suname">${review.userName}</div>
		<div class="suago">${review.reviewUrl} ago</div>
	   </div>
	</div>
	<div class="sustar-rating">
	   
												<c:set var="startRating" value="${review.reviewRating/2}" />
												
													<c:set var="half" value="false" />
													<c:if test="${fn:contains(startRating,'.') && fn:split(startRating,'.')[1] > 0}">
													<c:set var="half" value="true" />
													<c:set var="startRating" value="${fn:split(startRating,'.')[0]}" />
													</c:if>
                                                   
													<c:forEach begin="1" end="${startRating}">
								<i class="fa fa-star" style="color:#ff4500;"></i>
                                                    </c:forEach>
													<c:if test="${half == 'true'}">
													<span style="position:relative;">
													<i class="fa fa-star"></i>
													<i class="fa fa-star-half" style="color:#ff4500;position:absolute;left:0;"></i>
													</span>
													<c:set var="startRating" value="${startRating+1}" />
													</c:if>		
													<c:forEach end="5" begin="${startRating+1}">
								<i class="fa fa-star"></i>
                                                    </c:forEach> 
													
	</div>
	<div class="sucomment">
	   ${review.reviewMessage}
	</div> 
   </div>
   </c:forEach>
</div>
<style>
.sreviews-container
{
   background-color:#ffffff;
   padding:30px 0;
   font-family:-apple-system,BlinkMacSystemFont,Arial,Helvetica Neue,Segoe UI,Roboto,sans-serif;
}
.review-heading
{
   max-width:1200px;
   margin:auto;
   width:94%;
}
.review-heading span
{
   margin:15px 0;
   font-size:28px;
   color:#303030;
   font-weight:550;
}
.sreviews
{
   max-width:1200px;
   margin:auto;
   width:94%;
}
.suser-info
{
   display:flex;
   align-items:center;
   margin:10px auto;
   margin-top:20px;
}
.suser-info img
{
   width:50px;
   height:50px;
   border-radius:50%;
   border:1px solid #002142;
}
.suser-name-ago
{
   display:flex;
   flex-direction:column;
   margin:0 2px;
}
.suname
{
   color:#505050;
   font-weight:500;
   font-size:17px;
}
.suago
{
   color:#808080;
   font-size:14px;
}
.sustar-rating
{
   margin:10px 2px;
   font-size:16px;
}
.sucomment
{
   width:65%;
   margin:10px 2px;
   font-size:15px;
   color:#707070;
   border-bottom:1px solid #cccccc;
   padding-bottom:20px;
}
@media only screen and (max-width:768px)
{
   .sucomment{width:96%;}
}
@media only screen and (max-width:585px)
{
   .sreviews-container{display:none;}
}
</style>
<form name="reviewForm" id="reviewForm" action="/review/submit" method="post">
<div class="customer-review-container">
  <div class="crsub-container">
   <div class="customer-review-form">
	<div class="crhead">
	   Customer Review
	</div>
	<div class="crfhead">
	   Leave a Comment
	</div>
	<fieldset class="rate">
    	  <input type="radio" id="rating10" name="rating" value="10" /><label for="rating10" title="5 stars"></label>
    	  <input type="radio" id="rating9" name="rating" value="9" /><label class="half" for="rating9" title="4 1/2 stars"></label>
    	  <input type="radio" id="rating8" name="rating" value="8" /><label for="rating8" title="4 stars"></label>
    	  <input type="radio" id="rating7" name="rating" value="7" /><label class="half" for="rating7" title="3 1/2 stars"></label>
    	  <input type="radio" id="rating6" name="rating" value="6" /><label for="rating6" title="3 stars"></label>
    	  <input type="radio" id="rating5" name="rating" value="5" /><label class="half" for="rating5" title="2 1/2 stars"></label>
    	  <input type="radio" id="rating4" name="rating" value="4" /><label for="rating4" title="2 stars"></label>
    	  <input type="radio" id="rating3" name="rating" value="3" /><label class="half" for="rating3" title="1 1/2 stars"></label>
    	  <input type="radio" id="rating2" name="rating" value="2" /><label for="rating2" title="1 star"></label>
    	  <input type="radio" id="rating1" name="rating" value="1" /><label class="half" for="rating1" title="1/2 star"></label>
	</fieldset>
	<div class="cname-email">
	  <input type="text" placeholder="Your Name" name="customerName" id="customerName" class="textOnly" />
	  <input type="email" placeholder="Your Email" name="customerEmail" id="customerEmail" />
	</div>
	<div class="ccomment-box">
	  <textarea type="text" placeholder="Comment Here" name="customerReview" id="customerReview"></textarea>
	</div>
	<div class="crsubmit">
	  <button type="submit">Submit</button>
	</div>
	<div id="reviewSuccess"></div>
   </div>
  </div>
</div>
</form>
<style>

.error{border: 1px solid #f00 !important;}
 .error:focus{outline: none;}
 
.customer-review-container
{
   background-color:#ffffff;
   padding:30px 0;
   font-family:-apple-system,BlinkMacSystemFont,Arial,Helvetica Neue,Segoe UI,Roboto,sans-serif;
}
.crsub-container
{
   max-width:1200px;
   margin:auto;
   width:94%;
}
.customer-review-form
{
   margin:0;
   width:100%;
   border:1px solid #b0b0b0;
   padding:10px;
}
.crhead
{
   font-size:22px;
   color:#000;
   font-weight:550;
   padding:10px 0;
   border-bottom:1px solid #b0b0b0;
}
.crfhead
{
   margin-top:30px;
   color:#000;
   font-weight:550;
   font-size:16px;
   padding:0 5px;
}
/* Ratings widget */
.rate {
    display: inline-block;
    border: 0;
    margin-left:-10px;
}
/* Hide radio */
.rate > input {
    display: none;
}
/* Order correctly by floating highest to the right */
.rate > label {
    float: right;
}
/* The star of the show */
.rate > label:before {
    display: inline-block;
    font-size:22px;
    padding: .3rem .2rem;
    margin-right:0;
    cursor: pointer;
    font-family: 'FontAwesome';
    font-weight: 900;
    content: "\f005"; /* full star */
}

/* Half star trick */
.rate .half:before {
    content: "\f005"; /* half star no outline */
    position: absolute;
    padding-right: 0;
    width: 12px;
    overflow: hidden;
    margin-right: 0.4rem;
}

/* Click + hover color */
input:checked ~ label, /* color current and previous stars on checked */
.rate label:hover,.rate label:hover ~ label { color: #db2405;  } /* color previous stars on hover */

/* Hover highlights */
input:checked + label:hover, input:checked ~ label:hover, /* highlight current and previous stars */
input:checked ~ label:hover ~ label, /* highlight previous selected stars for new rating */
label:hover ~ input:checked ~ label /* highlight previous selected stars */ { color: #db2405;  } 

.cname-email
{
   display:flex;
   justify-content:space-between;
   flex-wrap:wrap;
}
.cname-email input
{
   width:49%;
   height:40px;
   border:1px solid #b0b0b0;
   text-indent:5px;
   outline:0;
   font-size:15px;
   margin:10px 0;
}
.ccomment-box textarea
{
   height:120px;
   width:100%;
   border:1px solid #b0b0b0;
   text-indent:5px;
   outline:0;
   font-size:15px;
   margin:10px 0;
   font-family:-apple-system,BlinkMacSystemFont,Arial,Helvetica Neue,Segoe UI,Roboto,sans-serif;
} 
.crsubmit button
{
   height:40px;
   color:#ffffff;
   background-color:#db2405;
   padding:0 15px;
   border:0;
   outline:0;
   cursor:pointer;
   margin:5px 0;
   border-radius:3px;
   font-size:15px;
}
.crsubmit button:hover
{
   background-color:red;
}
@media only screen and (max-width:768px)
{
   .customer-review-form{width:96%;margin:auto;}
   .cname-email input{width:100%;}
}
@media only screen and (max-width:585px)
{
   .customer-review-container{/*display:none;*/}
}
</style> 
<script>
$('.textOnly').keyup(function () {
        		  if (this.value != this.value.replace(/[^a-zA-Z ]+/g, '')) {
        		       this.value = this.value.replace(/[^a-zA-Z ]+/g, '');
        		    }
        	});	
$("#reviewForm").validate({
		 rules:{
			 rating : {
				 required : true
			 },
			 customerName :{
				 required : true
			 },
			 customerEmail :{
				 required : true,
				 email : true
			 },
			 customerReview :{
				 required : true
			 }
		 },
		  errorPlacement: function(error, element) {   },
		   submitHandler: function(form) {
			var rating =    $("input[name='rating']:checked").val();
			if(rating == undefined){
				alert("Please Select Star Rating")
				return false;
			}
			
					var data = {
							userName: $("#customerName").val(),
					userEmail: $("#customerEmail").val(),
					reviewMessage : $("#customerReview").val(),
					reviewRating : rating,
					reviewUrl : $("#pageUrl").val()
								}
							$.ajax({
								url: '/review/submit',
								type: 'post',
								contentType: 'application/json; charset=utf-8',
								data: JSON.stringify(data),
								dataType: "text",
								success: function(response) {
									var reviewRes = JSON.parse(response);
									if(reviewRes.baseResponse.status == 1)
									$("#reviewSuccess").text("Review Added Successfully!").css("color", "green");
									else
									$("#reviewSuccess").text("Some Technical Issue Please try later!").css("color", "red");	
								}
							});
							
				
		  }
	 })
	 
</script> 