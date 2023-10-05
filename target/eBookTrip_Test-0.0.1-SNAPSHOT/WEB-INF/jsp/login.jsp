<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <title>Login/Register</title>
    <link rel="stylesheet" href="/resources/css/default.css?v=5.1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Mukta:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="/resources/scripts/jquery-1.11.1.min.js"></script>
    <script src="/resources/scripts/jquery-ui.js"></script>
    <script src="/resources/scripts/jquery.validate.min.js"></script>
	
    <link rel="icon" href="/resources/images/favicon.png">
<jsp:include page="tag-manager-head.jsp" /></head>
<body style="background-image:url('/resources/images/blog-body.jpg');background-repeat:no-repeat;background-attachment: fixed;background-size:100% 100%;">
   <jsp:include page="tag-manager-body.jsp" /> <!--Header Area Starts Here-->
    <jsp:include page="header.jsp" />
    <div class="screen-overlay" id="screenoverlay" onclick="hidesidenav()"></div>
    <!--Header Ends Here-->
    <div class="blog-head">
        <span>Sign In/Sign Up</span>
    </div>
    <div style="background-color:#ffffff;">
    <div class="lrcontainer">
      <div class="lrforms">
	<div class="lform">
		<form:form modelAttribute="loginForm" action="/login" method="post">
	   <div class="form-head">Login</div>
	   <div class="form-input">
              <label>Username/Email</label>
	      <form:input path="userName" placeholder="Enter Email Address" style="background-image:url(/resources/images/username.png);" />
	   </div>
	   <div class="form-input">
              <label>Password</label>
	      <form:password path="password" placeholder="Enter Password" style="background-image:url(/resources/images/password.png);" />
	   </div>
	   <div class="lrbutton"><button type="submit">Login</button></div>
           <div class="flrlinks">
           <!-- <div><a class="forgot-pass">Forgot Password?</a></div>  -->
            <div><a class="new-user">New User? Register Here</a></div>
	   </div>
	   <span style="color:red;margin-left: 15px;">${msgE}</span>
	   <span style="color:green;margin-left: 15px;">${msgS}</span>
	   </form:form>
    </div>
	<div class="rform" style="display:none;">
	<form:form modelAttribute="registerForm" action="/register" method="post">
	   <div class="form-head">Register</div>
	   <div class="form-input">
              <label>First Name</label>
	      <form:input path="firstName" placeholder="Enter Your First Name" style="background-image:url(/resources/images/name.png);" />
	   </div>
	   
	   <div class="form-input">
              <label>Last Name</label>
	      <form:input path="lastName" placeholder="Enter Your Last Name" style="background-image:url(/resources/images/name.png);" />
	   </div>
	   <div class="form-input">
              <label>Email</label>
	      <form:input path="email" placeholder="Enter Email Address" style="background-image:url(/resources/images/email.png);" />
	   </div>
	   <div class="form-input">
              <label>Password</label>
	      <form:password path="regPassword" placeholder="Enter Password" style="background-image:url(/resources/images/password.png);" />
	   </div>
	   <div class="form-input">
              <label>Re-enter Password</label>
	      <input type="password" id="repass" name="repass" placeholder="Re-enter Password" style="background-image:url(/resources/images/password.png);" />
	   </div>
	   <div class="agree-line">By signing up, I agree to Ebooktrip's <a href="/terms-and-conditions">terms and conditions</a> and <a href="/privacy-policy">privacy policy</a>.</div>
	   <div class="lrbutton"><button type="submit">Register</button></div>
           <div class="flrlinks">
            <div><a class="login">Login Here</a></div>
	   </div>
	</form:form>   
     </div>
	<div class="fpform" style="display:none;">
	   <div class="form-head">Reset Password</div>
	   <div class="form-input">
              <label>Email</label>
	      <input type="text" placeholder="Enter Email Address" style="background-image:url(/resources/images/email.png);">
	   </div>
	   <div class="lrbutton"><button type="button">Submit</button></div>
           <div class="flrlinks">
            <div><a class="login">Login Here</a></div>
	   </div>
        </div>
      </div>  
    </div>	
    </div>
<style>
.error{border: 1px solid red !important;}
.lrcontainer
{
max-width:480px;
width:94%;
margin:auto;
padding:30px 0;
font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
}
.lrforms
{
width:100%;
border:2px solid #002162;
padding:20px 0;
box-shadow:1px 1px 4px #eee,1px -1px 4px #eee,-1px 1px 4px #eee,-1px -1px 4px #eee;
}
.form-head
{
color:#002192;
font-weight:550;
font-size:24px;
width:94%;
margin:auto;
}
.form-input
{
width:94%;
margin:10px auto;
display:flex;
flex-direction:column;
}
.form-input input
{
height:45px;
width:100%;
border:1px solid #404040;
border-radius:5px;
font-size:15px;
color:#303030;
text-indent:5px;
outline:0;
background-repeat:no-repeat;
background-size:22px 22px;
background-position:9px 11px;
text-indent:35px;
}
.form-input label
{
margin:5px 0;
color:#505050;
font-size:15px;
}
.lrbutton
{
width:94%;
margin:15px auto;
}
.lrbutton button
{
background-color:#ff4500;
height:45px;
width:30%;
font-size:16px;
border:0;
outline:0;
color:#ffffff;
cursor:pointer;
float:right;
border-radius:5px;
}
.lrbutton button:hover
{
background-color:red;
}
.flrlinks
{
display:flex;
flex-direction:row-reverse;
width:94%;
margin:auto;
justify-content:space-between;
}
.flrlinks a
{
color:#002192;
text-decoration:none;
font-size:14px;
cursor:pointer;
font-weight:500;
}
.agree-line
{
width:94%;
margin:auto;
font-size:15px;
color:#505050;
}
.agree-line a
{
text-decoration:none;
color:#002192;
}
.lform,.rform,.fpform
{
transition: all 0.2s ease-in-out;
}
</style>  
    <!--Footer Starts-->
   <jsp:include page="footer.jsp" />
  <input type="hidden" id="page" value="${page}" /> 
  <script src="/resources/scripts/script.js?8-dec-2021"></script>
</body>
<script>
$(".forgot-pass").click(function(){
$(".lform").hide();
$(".rform").hide();
$(".fpform").show();
console.log(1);
});
$(".new-user").click(function(){
$(".lform").hide();
$(".rform").show();
$(".fpform").hide();
});
$(".login").click(function(){
$(".lform").show();
$(".rform").hide();
$(".fpform").hide();
});
if($("#page").val() == 'signup'){
	$(".lform").hide();
$(".rform").show();
$(".fpform").hide();
}
</script>
<script>
$('.numbersOnly').keyup(function () {
        	    if (this.value != this.value.replace(/[^0-9\.]/g, '')) {
        	       this.value = this.value.replace(/[^0-9\.]/g, '');
        	    }
        	});
$('.textOnly').keyup(function () {
        		  if (this.value != this.value.replace(/[^a-zA-Z ]+/g, '')) {
        		       this.value = this.value.replace(/[^a-zA-Z ]+/g, '');
        		    }
        	});			
$("#registerForm").validate({
		 rules:{
			 firstName : {
				 required : true
			 },
			 lastName :{
				 required : true
			 },
			 email :{
				 required : true,
				 email : true
			 },
			 regPassword :{
				 required : true
			 },
			 repass:{
				 equalTo: "#regPassword"
				 
			 }
		 },
		  errorPlacement: function(error, element) {   },
		   submitHandler: function(form) {
			form.submit();	
		  }
	 })

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