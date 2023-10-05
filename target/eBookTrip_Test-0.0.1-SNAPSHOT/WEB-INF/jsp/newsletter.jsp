<!DOCTYPE html>
<html lang="en">
<head>
    <title>Suscribe to Newsletter</title>
    <meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Suscribe to Newsletter Description">
    <link rel="canonical" href="https://www.ebooktrip.com/newsletter"/>
    <link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Mukta:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/resources/css/default.css?v=5.1">
    <link rel="stylesheet" href="/resources/css/animate.min.css">
    <link rel="icon" href="/resources/images/favicon.png">
	<script src="/resources/scripts/jquery-1.11.1.min.js"></script>
<jsp:include page="tag-manager-head.jsp" /></head>
<body>
   <jsp:include page="tag-manager-body.jsp" /> <!--Header Area Starts Here-->
    <jsp:include page="header.jsp" />
    <div class="screen-overlay" id="screenoverlay" onclick="hidesidenav()"></div>
    <!--Header Ends Here-->
     <div class="blog-head">
        <h1>Subscribe to Newsletter</h1>
    </div>
<style type="text/css">
    /*newsletter.jpg*/
    .imgSecn { background:url('/resources/images/newsletter.jpg') top left no-repeat; width:500px; height:500px; border-radius:8px 0 0 8px }
    .formSectn { height:500px; display:flex; flex-wrap:wrap; align-content:center; width:450px; text-align:center; justify-content:center; background:whitesmoke; padding:0 70px }
</style>
    <div class="betheFirstNew" style="background-color:#ffffff;padding:40px 0">
        <div class="auto-fare-alert">
            <div class="imgSecn wow fadeInLeft"></div>
            <div class="formSectn wow fadeInRight">
                <div class="speak-expert-section">
                    <h2 class="auto-alert-topic">Be the first to know!</h2>
                    <h3 class="auto-alert-line">Sign up now to receive our latest flight deals and discounts!</h3>
                    <div class="auto-alert-call-us">You will even get to save up to $20 our fees on your next flight.</div>
                </div>
                <div class="alert-section-form">
                    <input type="text" id="newsEmail" placeholder="Enter Email Address">
                    <span id="newsMsg"></span>
                    <button type="button" onclick="newsalertsubmit()">Sign Up Now</button>
    			</div>
                <div class="auto-alert-terms"><a href="/terms-and-conditions" target="blank">Terms & Conditions</a></div>
            </div>
        </div>
   </div>
<style>
.auto-fare-alert
{border: 1px solid #f4f5f6;
    /*background-color:#f4f5f6;*/
    border-radius:5px;
    /*padding:10px 20px;
    box-shadow:1px 1px 1px #909090,-1px -1px 1px #909090,1px -1px 1px #909090,-1px 1px 1px #909090;*/
    font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
    max-width:950px;
    margin:auto; display:flex; align-items:center;
}
.speak-expert-section
{
    display:flex;
    flex-direction:column;
    text-align:left;
}
.auto-alert-topic
{
    font-family:'Mukta';
    font-weight:550;
    color:#101010;
    font-size:25px;
    padding:5px 0;
    margin: 0;
}
.auto-alert-line
{
    color:#646464;
    font-size:15px;
    padding:5px 0; letter-spacing:0.5px;
    margin: 0;
    font-weight: normal;
}
.auto-alert-call-us
{
    color:#646464;
    font-size:15px;
    padding:5px 0; letter-spacing:0.5px
}
.alert-section-form
{
    padding:15px 0; width:100%;
    display:flex;
    justify-content:space-between;
    flex-direction:column;
    align-items:center;
    justifiy-content:center;
}
.alert-section-form input
{
    width:100%;
    height:40px;
    border:1px solid #efefef;
    border-radius:5px;
    padding:0 5px;
    color:#202020;
    font-size:15px;
    outline:0;
    margin:5px;
}
.alert-section-form button
{
    width:200px;
    height:40px;
    border:0;
    border-radius:20px;
    color:#ffffff;
    font-size:17px;
    background-color:#063d99;
    outline:0;
    cursor: pointer;
    margin:5px 0; 
}
.alert-section-form button:hover
{
    background-color:#db2405;
}
.auto-alert-terms
{
    margin:5px 0;
    display:flex;
    justify-content:center;
}
.auto-alert-terms a
{
    color:#002192;
    font-size:15px; text-decoration:none
}
.auto-alert-terms a:hover { color:#4b95fe; }
#newsMsg { height:19px; font-size:14px; letter-spacing:1px; text-align:left; width:100%; position:relative; top:-5px; }
#newsEmail::placeholder { color:#bfbdbd; }
#newsEmail:-ms-input-placeholder { color:#bfbdbd; }
#newsEmail::-ms-input-placeholder { color: #bfbdbd; }
@media(max-width: 991px){
    .auto-fare-alert { max-width:767px; }
    .imgSecn { width:375px; height:375px; background-size:contain; }
    .formSectn { width:350px; height:375px; padding:0 40px }
}
@media(max-width:767px){
    .auto-fare-alert { flex-wrap:wrap; max-width:400px; }
    .imgSecn { width:100% }
    .formSectn { width:100%; height:auto; padding:10px 30px 20px }
}
</style>
<jsp:include page="footer.jsp" />
</body>
<script src="/resources/scripts/script.js?01112024"></script>
<script src="/resources/scripts/wow.min.js?06082022"></script>
<script type="text/javascript">
  new WOW().init();
</script>
</html>