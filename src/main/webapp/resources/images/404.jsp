<!DOCTYPE html>
<html>
<head>
    <title>404 Page </title>
    <link rel="stylesheet" href="/resources/css/default.css?v=5.1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Mukta:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="/resources/scripts/jquery-1.11.1.min.js"></script>
    <script src="/resources/scripts/jquery-ui.js"></script>
    <script src="/resources/scripts/jquery.validate.min.js"></script>
    <link rel="icon" href="/resources/images/favicon.png">
</head>
<body>
    <!--Header Area Starts Here-->
    <jsp:include page="header.jsp" />
    <div class="screen-overlay" id="screenoverlay" onclick="hidesidenav()"></div>
    <!--Header Ends Here-->
    <div class="error-pagebg">
        <div class="error-pagegrad">
            <div class="error-pagetxt">
                <div class="error-no">404</div>
                <div class="error-reason">WE ARE SORRY,BUT THE PAGE YOU REQUESTED WAS NOT FOUND</div>
                <div class="error-fwd">
                    <a href="/" class="impbutton">GO HOME</a>
                    <a href="/contact-us" class="unimpbutton">CONTACT US</a>
                </div>
            </div>
        </div>
    </div>
    <style>
        .error-pagebg
        {
            background-image:url(/resources/images/404.jpg);
            background-repeat:no-repeat;
            background-size:cover;
            width:100%;
            height:600px;
        }
        .error-pagegrad
        {
            background:linear-gradient(#063d99,#db2405);
            opacity:0.9;
            width:100%;
            height:100%;
        }
        .error-pagetxt
        {
            display:flex;
            height:100%;
            width:100%;
            flex-direction:column;
            justify-content:center;
            align-items:center;
            text-align:center;
            color:#ffffff;
            font-family:'Mukta',sans-serif;
            padding:0 12px;
        }
        .error-no
        {
            font-weight:500;
            font-size:120px;
            margin:10px 0;
            font-family:Verdana, Geneva, Tahoma, sans-serif;
        }
        .error-reason
        {
            font-size:22px;
        }
        .error-fwd
        {
            margin:10px 0;
            display:flex;
        }
        .error-fwd a
        {
            text-decoration:none;
            padding:5px 10px;
            border-radius:17px;
            font-weight:500;
            margin:0 5px;
            border:2px solid #063d99;
        }
        .impbutton
        {
            color:#ffffff;
            background-color:#063d99;
        }
        .unimpbutton
        {
            background-color:transparent;
            color:#fff; border-color:white !important;
        }
        .impbutton:hover
        {
            background-color:red;
            border-color:red;
        }
        .unimpbutton:hover
        {
            background:red;
            color:white; border-color:red !important;
        }
    </style>
    <!--Footer Starts-->
   <jsp:include page="footer.jsp" />
</body>
</html>