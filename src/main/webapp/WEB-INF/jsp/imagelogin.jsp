<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <title>Imgae Upload Login</title>
    <link rel="stylesheet" href="/resources/css/default.css?v=2.7">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Mukta:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="icon" href="/resources/images/favicon.png">
	
	<script src="/resources/scripts/jquery-1.11.1.min.js"></script>
    <script src="/resources/scripts/jquery.validate.min.js"></script>
	
    <style>
        .ee-navbar-items li:nth-child(1) a::after{transform:scaleX(1);}
		.error{border: 1px solid red !important;}
		</style>
		
    <script data-ad-client="ca-pub-8417978305493541" async src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<jsp:include page="tag-manager-head.jsp" /></head>
<body style="background-image:url('/resources/images/blog-body.jpg');background-repeat:no-repeat;background-attachment: fixed;background-size:100% 100%;">
   <jsp:include page="tag-manager-body.jsp" /> <!--Header Area Starts Here-->
   <jsp:include page="header.jsp" />
    <div class="screen-overlay" id="screenoverlay" onclick="hidesidenav()"></div>
    <!--Header Ends Here-->
    <div class="blog-head">
        <span>Image Upload Login</span>
    </div>
    <div style="background-color:#ffffff;">
    <div class="contactus">
        
        <div class="contact-form">
            <h3>Image Login</h3>
			
            <form:form modelAttribute="loginForm" action="/image/login" method="post" >
                <div class="flname">
                    <div><label>Username</label><br>
					<form:input  path="userName" />
					
					</div>
                    
                </div>
                <div class="phonemail">
                    <div><label>Password</label><br><form:password path="password"  /></div>
                    
                </div>
                
                <div class="submit-form">
                    <button type="submit">Submit</button>
                </div>
				
            </form:form>
			<div id="reviewSuccess">${loginError}</div>
        </div>
    </div>
    </div>
    <!--Footer Starts-->
    <jsp:include page="footer.jsp" />
</body>

<script>
		
$("#loginForm").validate({
		 rules:{
			 userName : {
				 required : true
				 
			 },
			 password :{
				 required : true
			 }
		 },
		  errorPlacement: function(error, element) {   },
		   submitHandler: function(form) {
					form.submit();
							
				
		  }
	 })
	 
</script> 
</html>