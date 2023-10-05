<!DOCTYPE html>
<html lang="en">
<head>
    <title>Thank You</title>
    <meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Thank You Description">
    <link rel="icon" href="/resources/images/favicon.png">
    <link rel="canonical" href="https://www.ebooktrip.com/thankyou"/>
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700&display=swap" rel="preload" as="font" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/resources/css/default.css?v=5.1">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <jsp:include page="tag-manager-head.jsp" /></head>
<body>
   <jsp:include page="tag-manager-body.jsp" />
    <!--Header Area Starts Here-->
    <jsp:include page="header.jsp" />
    <div class="screen-overlay" id="screenoverlay" onclick="hidesidenav()"></div>
    <!--Header Ends Here-->
   
    <style>
        .thankpage-sec {text-align: center; letter-spacing: .4px; margin: 30px 0;}
        .thank-checkicon .check-ani {width: 100px; display: block; margin: auto;}
        .thank-checkicon .check-ani .path {stroke-dasharray: 1000; stroke-dashoffset: 0;}
        .thank-checkicon .check-ani .path.check {stroke-dashoffset: -100; -webkit-animation: dash-check 0.9s 0.35s ease-in-out forwards;  animation: dash-check 0.9s 0.35s ease-in-out forwards;}

        @-webkit-keyframes dash-check{
            0% {stroke-dashoffset: -100;}
            100% {stroke-dashoffset: 900;}
        }
        @keyframes dash-check{
            0% {stroke-dashoffset: -100;}
            100% {stroke-dashoffset: 900;}
        }

        .thankpage-sec h1 {font-size: 26px; margin-bottom: 0;}
        .thankpage-sec p {margin-top: 4px;}
        .thankpage-sec .backtohome {text-decoration: none; background: #043e98; color: #fff; padding: 10px 15px; border-radius: 3px; font-size: 14px;  display: inline-block; margin-top: 5px}
        .thankpage-sec .backtohome:hover {background: #dd2309;}

        @media (max-width: 480px) {
            .thankpage-sec{ margin: 20px 0;}
            .thankpage-sec h1 {font-size: 20px;}
        }

    </style>

    <div style="background-color:#ffffff;">
        <div class="aboutus static-content">
                <div class="thankpage-sec">
                        <div class="thank-checkicon">
                            <svg class="check-ani" version="1.1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 130.2 130.2">
                                <circle class="path circle" fill="#1d8955" stroke="#1d8955" stroke-width="7" stroke-miterlimit="10" cx="65.1" cy="65.1" r="58.1"/>
                                <polyline class="path check" fill="none" stroke="#ffffff" stroke-width="6" stroke-linecap="round" stroke-miterlimit="10" points="100.2,40.2 51.5,88.8 29.8,67.5 "/>
                              </svg>
                        </div>
                        <h1>Thank You for choosing ebooktrip.com</h1>
                        <p>We have received your credit card information, We will connect with you shortly.</p>
                        <a href="/" class="backtohome">Back To Home</a>
                </div>
        </div>
    </div>
    <!--Footer Starts-->
   <jsp:include page="footer.jsp" />
   <script src="/resources/scripts/script.js?8-dec-2021"></script>
</body>

</html>