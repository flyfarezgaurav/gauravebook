<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html ng-app="flightPayment">
    <head>
        <title>Review Trip Details & Book</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href='https://fonts.googleapis.com/css?family=Chivo' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet'>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
        <link rel="icon" href="/resources/images/favicon.png">
		<script src="/resources/scripts/jquery-1.11.1.min.js"></script>
		<script src="/resources/scripts/jquery.validate.min.js"></script>
		<script src="/resources/scripts/angular.min.js"></script>
		<script src="/resources/scripts/jquery.creditCardValidator.js"></script>
		<script src="/resources/scripts/fpayment.js?03022023"></script>
		<script src="/resources/scripts/ancillaries.js?02052023_12"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
		<style>
		.has-error{border: 1px solid red !important;}
        .submit-details button
{
    color:#fff;
    background-color:#FF4500!important;
    height:50px; 
    width:100%;
    margin:15px 30%; 
    border:0;
    outline:0;
    font-size:18px;
    font-weight:550;
    border-radius:3px;
}

/*.bdform input.rkap { width:49%!important;}*/
.bdform input.rkap { width:100%!important;}
.bdform select.rkap2 { /*width:66%!important;*/}
.bdform input.rkap3{ /*width:29%!important;*/}
.bdform select.rkap4{ width:99%!important;}

.mobilePriceBox { display:none; }
@media(max-width: 767px){
    .mobilePriceBox { display: block; }
    .desktopPriceBox { display:none; }
}

.trvlProt .checkMark.checkMark_ { width: 60% }
.priceDrop>div .pricedropP { display: flex; align-items: center; flex-wrap:wrap; font-family: 'Roboto', sans-serif;}
.priceDrop>div .pricedropP > div { width: 40%; display: inline-flex; justify-content: flex-end; padding-right: 30px; }
.trvlProt .checkMark.checkMark_ li { width:100%; }
.priceDrop>div .pricedropP > div span {font-weight: bold; font-size: 18px; color: #063d99;}
.proAddProd { align-items:center; width:100%; display:flex; justify-content:space-between; padding:10px 25px 20px; }
.proAddProd button { background:#063D99; color:white; box-shadow:none; outline:none; padding:8px 30px 8px; border:0; border-radius:4px; font-size:14px }
.proAddProd button:hover { background:#002a70 }

.trvlProt.priceDrop .protection-price-display {display: block; text-align: right; margin-bottom: 20px;}
.pricedropP .protection-price-display .per-person-text {display: block; font-size: 12px; color: #383737; font-weight: normal;  margin-bottom: 8px;}
.priceDrop .protection-price-display .addRemButSec {display: block;}
.pricedropP .protection-price-display .addRemButSec button span {font-size: 14px; color: #fff; font-weight: normal;}
.priceDrop .protection-price-display .addRemButSec button {font-size: 14px; border-radius: 4px;}

@media(max-width: 767px){
    .trvlProt .checkMark.checkMark_ {width: 100%; margin-top: 15px; padding-right:20px;}
    .priceDrop>div .pricedropP > div { width:100%; justify-content:flex-start; padding:0 0 0 20px }
}

.trvlProt { display:flex; width: 100%; align-items: baseline; padding: 0 0px 0; }
.trvlProt>div { width: 100% }
.trvlProt>img {     position: relative; top: 15px; }
.trvlProt .cccdhead p {color: #999; font-weight:normal; font-size:14px; margin-bottom:0; }
.trvlProt .pricedropP p {padding: 0 0 0 20px; margin-top: 20px;margin-bottom: 0;}
.travel-assist-description {font-size: 14px; margin: 15px 0; padding: 0px 25px;}
.trvlProt .checkMark { list-style-type: none;  display: flex; flex-wrap: wrap; padding: 0 0 0 20px; margin: 10px 0 0; }
.trvlProt .checkMark li { /* background: url(/resources/images/icons/check-mark.png) top left no-repeat;*/ width:50%; position:relative; padding:0 0 0 25px; background-size:20px; margin:0 0 15px 0;font-size: 14px;  color:#565656;}
.trvlProt .checkMark li:before {
    font-family: FontAwesome;
    content: "\f00c";
    display: inline-block;
    vertical-align: middle;
    color: green;
    position: absolute;
    left: 0;
    font-size: 16px;
}  
.addtrvlProt { padding:0 25px 0; margin:0 0 20px 0; }
.addtrvlProt>div { display:flex; align-items:baseline; padding:12px 20px 12px; border-radius:4px; border:1px solid #d5d5d5; margin:15px 0 0; font-size:14px }
.addtrvlProt>div>input { width:18px; height:18px; position:relative; top:3px; }
.addtrvlProt>div>div { padding:0 0 0 12px; width:calc(100% - 25px); }
.addtrvlProt>div>div label, .addtrvlProt>div>div p { margin:0; }
@media(max-width: 767px){
    .trvlProt .checkMark { margin:25px 0 0; }
    .trvlProt .checkMark li { font-size: 14px; background-size:16px; padding: 0 0 0 20px; width: 100% }
}

.trvlExpSec .priceDrop img { opacity:0; display:none }
.trvlExpSec .priceDrop .cccdhead img {display: inline-block; opacity: 1;}
.trvlExpSec .proAddProd { flex-wrap:wrap; align-items:baseline; }
.trvlExpSec .proAddProd .itemss { width:32%; border:1px solid gainsboro; border-radius:6px; }
.trvlExpSec .proAddProd .itemss .itemssHead { background:#9d9d9d; color:white; padding:10px 10px 10px 20px; border-radius:6px 6px 0 0; }
.trvlExpSec .proAddProd .itemss.active .itemssHead { background:#063d99 }
.trvlExpSec .proAddProd .itemss .itemssBody { padding:15px 10px 10px 20px }
.trvlExpSec .proAddProd .itemss .blueTxt { color:#063d99; font-size:13px; }
.trvlExpSec .proAddProd .itemss .itemssBody ul { padding:0; list-style-type:none; font-size:14px; font-weight:500; letter-spacing:0.5px; }
.trvlExpSec .proAddProd .itemss .itemssBody ul li { margin-bottom:4px; }
.trvlExpSec .proAddProd .itemss .itemssBody > div { font-weight:700; display:flex; justify-content:space-between; color:#063d99; }
/* .trvlExpSec .priceDrop .cccdhead { padding-left:0; } */
@media(max-width: 767px){
    .trvlExpSec .proAddProd .itemss {width:100%; margin-bottom:15px}
}

.trvlAsistSec.trvlExpSec .proAddProd .itemss {width:200px; position:relative;}
.trvlAsistSec.trvlExpSec .proAddProd .itemsHeadng {width:calc(100% - 600px); /*padding-right:25px;*/}
.trvlAsistSec.trvlExpSec .proAddProd .itemsHeadng ul {padding:0; list-style-type:none; color:#a1a1a1; font-weight:400; }
.trvlAsistSec.trvlExpSec .proAddProd .itemss .itemssHead, .trvlAsistSec.trvlExpSec .proAddProd .itemss.active .itemssHead {background:transparent; color:#063d99; font-weight:bold; text-align:center; padding:25px 10px 10px; display:flex; align-items:center; justify-content:center; height:155px; flex-wrap:wrap; }
.trvlAsistSec.trvlExpSec .proAddProd .itemss .itemssHead span {width:100%; color:#5c5c5c; font-size:20px;}
.trvlAsistSec.trvlExpSec .proAddProd .itemss .itemssBody {padding:0; text-align:center;}
.trvlAsistSec.trvlExpSec .proAddProd .itemss .itemssHead label {margin:5px 0 0; width:100%;}
.trvlAsistSec.trvlExpSec .proAddProd .itemss .itemssHead label input { height:16px; width:16px;}
/*.trvlAsistSec.trvlExpSec .proAddProd .itemss.active .itemssHead { background:transparent; color:#063d99; }*/
.trvlAsistSec .sowOnActive { display:none; position:absolute; top:-14px; left:-10px; font-size:12px; letter-spacing:0.5px; width:calc(100% + 20px); text-align:center; padding:5px 0; border-radius:4px 4px 0 0; background:#063D99; color:white; font-weight:500; z-index:1 }
.trvlAsistSec .sowOnActive:before { content:''; position:absolute; bottom:-10px; left:0; width:10px; height:10px; background:#063D99; border-radius:0 0 0 7px; }
.trvlAsistSec .sowOnActive:after { content:''; position:absolute; bottom:-10px; right:0; width:10px; height:10px; background:#063D99; border-radius:0 0 7px 0; }
.trvlAsistSec .itemss.active .sowOnActive { display:block; }
.trvlAsistSec.trvlExpSec .proAddProd { align-items:flex-start; }
.trvlAsistSec .itemsHeadng ul > li { min-height:70px; display:flex; align-items:center; line-height:17px; font-size:12px; color:#565656; padding:7px 30px 7px 10px; flex-wrap:wrap; }
.trvlAsistSec .itemsHeadng ul > li:nth-child(even), .trvlAsistSec.trvlExpSec .proAddProd .itemss .itemssBody ul li:nth-child(odd) { background:whitesmoke;}
.trvlAsistSec .itemsHeadng > ul > li br {display:none;}
.trvlAsistSec .itemsHeadng > ul > li > b {font-size:13px; }
.trvlAsistSec .itemsHeadng ul > li:last-child {background:transparent; min-height: auto;}
.trvlAsistSec.trvlExpSec .proAddProd .itemss .itemssBody ul li { min-height:70px; display:flex; align-items:center; justify-content:center; margin-bottom:0;}
.trvlAsistSec .itemsHeadng ul > li:first-child { height:155px; color:#5c5c5c; font-size:18px;}
.trvlAsistSec.trvlExpSec .proAddProd .itemss.active { border:2px solid #063d99;}
.trvlAsistSec.trvlExpSec .proAddProd .itemss .itemssBody ul {margin-bottom:0;}
.trvlAsistSec.trvlExpSec .proAddProd .itemss .itemssBody > div {background:#063d99; border-radius:6px; height:30px; align-items:center; }
.trvlAsistSec.trvlExpSec .proAddProd .itemss .itemssBody > div a {color:white; width:100%;}
.proAddProd-learnmorebtn {background: #6c6c6c; padding: 5px 8px; color: #fff; border-radius: 3px; font-size: 13px; text-decoration: none;}
.proAddProd-learnmorebtn:hover {text-decoration: none; color: #fff;}
.addRemButSec button#addPdp {color:#fff; background:#db2405; border:1px solid #db2405; padding:8px 15px 8px;}
.addRemButSec button#addPdp i {margin-right: 2px; font-size: 14px;}
.addRemButSec button img {height:22px; margin-right:5px;}
.addRemButSec button#removePdp { color:#fff; background:#db2405; border:1px solid #db2405; padding:8px 15px 8px;}
.addRemButSec button#removePdp i {margin-right: 5px;}
.lableUpOnFocus {position:relative; /*margin:15px 0 0;*/ width:32%}
.bdform .lableUpOnFocus {width:100%;}
.bdform .expirydate .lableUpOnFocus {width:15%;}
.bdform .expirydate .lableUpOnFocus select, .bdform .expirydate .lableUpOnFocus input { width:100% !important;}
.bdform .expirydate > div:nth-child(3) {margin-left:5px; width:calc(15% - 5px);}
/* .bdform .expirydate > div:last-child { margin-left:5px; width:calc(40% - 5px); position:relative; padding-right:140px; } */
.bdform .expirydate > div:last-child > span {font-size:12px; position:absolute; right:0; top:16px; width:130px; padding:0 0 0 27px; line-height:14px;}
.bdform .expirydate > div:last-child img {width: 18px; height:18px; /* position:absolute; left:0; top:4px;*/ }
.bdform .expirydate .expirydate-inputs .lableUpOnFocus:last-child .aboutcvv-info {font-size: 11px;}
.not_focus_input, .PpayInfoForm > div label.not_focus_input { position: absolute; width:100%; pointer-events: none; /*background:#103555; color:#fff;*/ font-weight:normal; font-size:11px; top:0px; left: 0; padding: 5px 5px 5px 10px; letter-spacing:0.5px; text-align: left;overflow: hidden; transition: all .5s; -webkit-transition: all .5s; }
.not_focus_input.apart_labl, .PpayInfoForm > div label.not_focus_input.apart_labl {color: #000!important; background: 0 0; pointer-events: none; top:10px; font-size: 12px; font-weight:normal; padding: 6px 0 6px 15px; transition: all .5s; -webkit-transition: all .5s; font-family: 'Roboto', sans-serif;}
.PpayInfoForm .expirydate label.not_focus_input.apart_labl, .PpayInfoForm .expirydate label.not_focus_input{font-weight: 600; color: #000 !important;}
.PpayInfoForm .expirydate label.not_focus_input{top: 4px;}
.cccdform .cccdform-inputs {width:38%; margin-bottom: 5px;}
.cccdform-inputs label {font-size: 12px; font-weight: 600; letter-spacing: .5px; margin-bottom: 2px;}
.cccdform .lableUpOnFocus {width:100%;}
.cccdform .lableUpOnFocus .not_focus_input.apart_labl {top: 8px; font-size: 12px;}
.cccdform .lableUpOnFocus .not_focus_input {top: 1px; color: #5d5d5d !important; font-size: 11px;}
.notesDetails {position:relative; padding:0 0 0 45px; margin:10px 0 0; font-weight:normal !important; letter-spacing:0.5px; font-size:14px !important;}
.notesDetails img {height: 35px; position: absolute; left: 0; top: -4px;}
.detailImprtSec {width: 100%; float: left; padding: 0 15px 0 25px; font-size: 14px;}
.detailImprtSec .detailTrvlSec {position: relative; padding: 0 0 0 20px;}
.detailImprtSec .detailTrvlSec input {position: absolute; left: 0; top: 4px;}
.detailImprtSec .importNoteSec {line-height: 18px; margin: 10px 0 0; padding: 7px 10px; border: 1px solid gainsboro; border-radius: 4px; margin-bottom: 15px;}
.detailImprtSec .importNoteSec p {margin:0;}
.detailImprtSec .importNoteSec strong {color:#0075ff;}
.errorImg {display:none; position:absolute; right:7px; top:calc(50% - 8px); pointer-events:none;}
/* #paymentDetails_MaskCardNumber + .errorImg { right:50px; } */
.PpayInfoForm .lableUpOnFocus #paymentDetails_MaskCardNumber {background-position: 92%;}
select + .errorImg {right:20px; top: 18px;}
#paymentDetails_CvvNo + .errorImg {right:10px; top: 20px;}
#paymentDetails_CvvNo + .errorImg img {height:16px;}
.errorImg.active {display:block;}
.errorImg.active.error img:first-child, .errorImg.active.check img:last-child { display:none; }
.errorImg.active.error img:last-child, .errorImg.active.check img:first-child { display:block; }

.payment-card-expirysec {display: flex; gap: 2%;}
.payment-card-expirysec .card-numberinput {width: 40%;}
.payment-card-expirysec .expirydate {width: 60% !important;}
.PpayInfoForm .cardholderinput {width: 39% !important;}
.expirydate-inputs  span.aboutcvv-info-cvv {display: none;}
.expirydate .expirydate-inputs{display: flex; gap: 1%; width: 100% !important; flex-wrap: wrap;} 
.bdform .expirydate .expirydate-inputs .lableUpOnFocus {width: 24%;}

@media(max-width:1199px){
    .trvlAsistSec.trvlExpSec .proAddProd .itemsHeadng {width: calc(100% - 452px);}
    .trvlAsistSec.trvlExpSec .proAddProd .itemss {width: 150px;}
}


@media(max-width:900px){
    .trvlAsistSec.trvlExpSec .proAddProd .itemsHeadng {width: calc(100% - 390px);}
    .trvlAsistSec.trvlExpSec .proAddProd .itemss {width: 130px;}
    
}
@media(max-width:768px){
    .lableUpOnFocus {width:48%; /*margin:20px 0 0;*/}
    .billing-details .lableUpOnFocus {margin:10px 0 0;}
    .bdform .lableUpOnFocus {width:100%}
    .bdform .expirydate .lableUpOnFocus {width:33.33%;}
    .bdform .expirydate > div:nth-child(3), .bdform .expirydate > div:last-child {width:calc(33.33% - 5px);}
    .bdform .expirydate > div:last-child {padding-right:0;}
    .bdform .expirydate > div:last-child > span {right:calc(100% - 130px); top:-27px; line-height:11px;}
    .payment-card-expirysec .card-numberinput {width: 100%;}
    .payment-card-expirysec .expirydate{width: 100% !important;}
    .PpayInfoForm .cardholderinput label{display: block;}
    .PpayInfoForm .cardholderinput{width: 100% !important;}
    .payment-card-expirysec .expirydate label {margin-bottom: 5px;}
    
}
@media(max-width:767px){
    /*.trvlAsistSec.trvlExpSec .proAddProd .itemss { width:100px }
    .trvlAsistSec.trvlExpSec .proAddProd .itemsHeadng { width:calc(100% - 300px); padding-right:10px; }*/

    #paymentDetails_CvvNo + .errorImg {right: 10px; width: 11%; top: 16px; height: 18px;}
    .cccdform .cccdform-inputs {width: 49%;}
    .cccdform .lableUpOnFocus {width: 100%;}

    .trvlProt.priceDrop .protection-price-display { display: flex; justify-content: space-between; padding-right: 20px; margin: 10px 0;}

}
@media(max-width:600px){
    .trvlAsistSec.trvlExpSec .proAddProd .itemsHeadng { /*display:none;*/ width:200px;}
    .trvlAsistSec .itemsHeadng ul > li:last-child {display:none;}
    .trvlAsistSec .itemsHeadng ul > li {font-size:12px }
    .trvlAsistSec .itemsHeadng ul > li:first-child {font-size:14px}
    .trvlAsistSec.trvlExpSec .proAddProd { flex-wrap:unset; position:relative; width:530px; padding:10px 25px 30px;}
    .trvlAsistSec.trvlExpSec .proAddProd .itemss {width: 110px;}
    .mobTermsDiv {position:absolute; bottom:10px; left:0;}
    .trvlAsistSec.trvlExpSec .proAddProd .itemss .itemssHead img {height:44px;}
    .proAddProd_Section {width:100%; overflow:auto;}
    .trvlAsistSec.trvlExpSec .proAddProd .itemss .itemssHead span {font-size:16px;}
    .bdform .expirydate .lableUpOnFocus {width:33.33%;}
    .bdform .expirydate > div:nth-child(3) {width:calc(33.33% - 5px);}
    .bdform .expirydate > div:last-child {width:calc(33.33% - 5px);}
}

@media(max-width: 480px){
.expirydate .expirydate-inputs{flex-wrap: wrap;}
.lableUpOnFocus.aboutcvv-info-div {flex-basis: 100%;}
.bdform .expirydate .expirydate-inputs .lableUpOnFocus {width: 32.5%; text-align: right;}
}

@media(max-width: 400px){
    .bdform .expirydate .lableUpOnFocus { width:33.33% }
    .bdform .expirydate > div:nth-child(3) { width:calc(33.33% - 5px); }
    .bdform .expirydate > div:last-child { width:calc(33.33% - 5px); }
    .PpayInfoForm > div.expirydate > div:last-child label.not_focus_input.apart_labl { top:8px; }
    .bdform .expirydate > div:last-child > span { font-size:10px; padding:0 0 0 18px; right:calc(100% - 110px); width:110px; }
    .bdform .expirydate > div:last-child img {width:15px; height: 15px; }
    .cccdform .cccdform-inputs {width: 100%;}
}
	</style>

	<script>
function goBack() {
  window.history.back();
}

var width="";
$( document ).ready(function() { 
	width=$(window).width();
});

</script>
<link rel="stylesheet" href="/resources/css/payment.css?12052023" type="text/css">
    <jsp:include page="../../tag-manager-head.jsp" />

<script>
gtag('event', view_item, {
'send_to': 'GF-902',
'value': '${bookingRequest.flightResult.fare.grandTotal}',
'currency': 'USD'
});
</script>

</head>
    <body ng-controller="flightPaymentCntrl">
    <jsp:include page="../../tag-manager-body.jsp" />
        <!--Header Area Starts Here-->
        <div class="header-container">
            <div class="header">
                <div class="logo-fh">
                    <a href="/"><img src="/resources/images/logo.png"></a>
                </div>
                <div class="navbar-main">
                    <div class="expert-talk">
                        <!-- <a href="tel:+1-800-404-0025"><span>Get Customer Support: </span><span> 1-800-404-0025</span></a> -->
                        <a href="tel:+1-800-404-0025"><span class="call-icon"><img src="/resources/images/customer-care-img.png" alt="phonek" width="5" height="5" loading="lazy" decoding="async"> </span><span class="topcall-text-sec"> 
                            <span class="topcall-text">Get Customer Support:</span>
                            +1-800-404-0025</span>
                        </a>
                    </div>

                </div>
                <div class="side-navbar-button" style="display: none;">
                    <button type="button" onclick="showsidenav()"><i class="fa fa-bars"></i></button>
                </div>
            </div>
        </div>
        <div class="side-navbar" id="sidenavbar">
            <li><button type="button" onclick="hidesidenav()"><i class="fa fa-close"></i></button></li>
            <li><a href="/contactus">Contact Us</a></li>
        	<li><a href="/terms-and-conditions">Terms & Conditions</a></li>
        	<li><a href="/privacy-policy">Privacy Policy</a></li>
            <p>Copyright &copy;  2021 - 2023, Ebooktrip. All rights reserved</p>
        </div>
        <div class="screen-overlay" id="screenoverlay" onclick="hidesidenav();"></div>
        <div id="screenoverlay2" onclick="enginehide();"></div>
        <div class="backbtnrow mycontainer">
            <button type="button" onclick="goBack();" style="border-radius:3px"><i class="fa fa-long-arrow-left" aria-hidden="true"></i>&nbsp;&nbsp; Go Back</button>
        </div>
		<fmt:setLocale value="en_US" scope="session"/>
		<input type="hidden" value="${currencySymbol}" id="currencySymbol" />
		<input type="hidden" value="${currencyValue}" id="currencyValue" />
		<form:form method="POST" action="/flight/payment/confirm" id="bookingRequest" modelAttribute="bookingWrapper" novalidate="novalidate">
		
		<input type="hidden" id="sessionId" value="${bookingRequest.searchID}">
		<input type="hidden" id="totalPax" value="${bookingRequest.adults+bookingRequest.child+bookingRequest.infants+bookingRequest.infantsWs}" scope="request" />
        <input type="hidden" id="tripType" value="${searchRequest.tripType}" />
        <div class="ftpdetails mycontainer">
            <div class="ft-block">
				
				
				
				<jsp:include page="ancillaries.jsp" />
				
				<!------- Ancillaries Include ---->
				
				<c:if test="${device=='Mobile'}">
			 		<jsp:include page="price_mobile.jsp" />
				</c:if>
				
				<%-- 
                <div class="price-details mobilePriceBox" id="priceblock">
                    <div class="pdhead">
                        <!-- <i class="fa fa-money"></i> --><img src="/resources/images/icons/Pmoney.png" alt="Price">&nbsp;&nbsp;Price Details
                    </div>
                    <hr>
                    <div class="person-price" id="mobilePriceBox">
                        <div class="tpp">
                            <span><span>${bookingRequest.adults}</span> Traveler(s): <span>Adult</span></span>
                            <span>$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.adults * (bookingRequest.flightResult.fare.adultFare+bookingRequest.flightResult.fare.adultTax+bookingRequest.flightResult.fare.adultMarkup)}" /></span>
                        </div>
                        <div class="fcp">
                            <span>Flight Charges per <span>Adult</span> Incl All Taxes & Fees</span>
                            <span>$<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.flightResult.fare.adultFare+bookingRequest.flightResult.fare.adultTax+bookingRequest.flightResult.fare.adultMarkup}" /></span>
                        </div>
                        
                    </div>
                    <hr>
        			<c:if test="${bookingRequest.child > 0}">
                    <div class="person-price">
                        <div class="tpp">
                            <span><span>${bookingRequest.child}</span> Traveler(s): <span>Child</span></span>
                            <span>$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.child * (bookingRequest.flightResult.fare.childFare+bookingRequest.flightResult.fare.childTax+bookingRequest.flightResult.fare.childMarkup)}" /></span>
                        </div>
                        <div class="fcp">
                            <span>Flight Charges per <span>Child</span></span>
                            <span>$<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.flightResult.fare.childFare+bookingRequest.flightResult.fare.childTax+bookingRequest.flightResult.fare.childMarkup}" /></span>
                        </div>
                        
                    </div>
                    <hr>
                    </c:if>
                    
                    <c:if test="${bookingRequest.infants > 0}">
                    <div class="person-price">
                        <div class="tpp">
                            <span><span>${bookingRequest.infants}</span> Traveler(s): <span>Infant(lap)</span></span>
                            <span>$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.infants * (bookingRequest.flightResult.fare.infantFare+bookingRequest.flightResult.fare.infantTax+bookingRequest.flightResult.fare.infantMarkup)}" /></span>
                        </div>
                        <div class="fcp">
                            <span>Flight Charges per <span>Infant(lap)</span> Incl All Taxes & Fees</span>
                            <span>$<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.flightResult.fare.infantFare+bookingRequest.flightResult.fare.infantTax+bookingRequest.flightResult.fare.infantMarkup}" /></span>
                        </div>
                        
                    </div>
                    <hr>
                    </c:if>
                    
                    <c:if test="${bookingRequest.infantsWs > 0}">
                    <div class="person-price">
                        <div class="tpp">
                            <span><span>${bookingRequest.infantsWs}</span> Traveler(s): <span>Infant(ws)</span></span>
                            <span>$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.infantsWs * (bookingRequest.flightResult.fare.infantWsFare+bookingRequest.flightResult.fare.infantWsTax+bookingRequest.flightResult.fare.infantWsMarkup)}" /></span>
                        </div>
                        <div class="fcp">
                            <span>Flight Charges per <span>Infant(ws)</span></span>
                            <span>$<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.flightResult.fare.infantWsFare+bookingRequest.flightResult.fare.infantWsTax+bookingRequest.flightResult.fare.infantWsMarkup}" /></span>
                        </div>
                        
                    </div>
                    <hr>
                    </c:if>
                    
                    <div class="person-price">
                        <div class="tpp" id="tgfareladder_mob" style="display:none; position:relative;text-font:15px;">
                            <span> Travel Guard Fee </span>
                            <span id="tg_price_mob"></span>
                        </div>
                    </div>
                    
                    <div class="total-price">
                        <span>Total Price:</span>
                        <span id="total_price_mob">$<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.flightResult.fare.grandTotal}" /></span>
                    </div>
                    <p>NOTE: All Fares displayed are quoted in USD and inclusive of base fare, taxes and all fees. Additional baggage fees may apply as per the airline policies.</p>
                </div>
				 --%>
                <div class="payment-details bgblue">
                    <div class="paydhead"><img src="/resources/images/icons/Pcredit-card-white.png" alt="Payment mode">&nbsp;&nbsp;Payment Info</div>
                  
                    <div class="paydform">
                        <div class="payViaDebCreSec">
                            <div><input type="radio" name="" checked="true"><span>Debit/Credit Card</span></div>
                            <div><img src="/resources/images/icons/card-payment.png" alt="Credit Card"></div>
                        </div>
					   <div class="card-varients">
                            <div class="card-images">
                                <div><img src="/resources/images/card-master.png" alt="card-master" width="10" height="6" loading="lazy" decoding="async"></div>
                                <div><img src="/resources/images/card-visa.png" alt="card-visa" width="10" height="6" loading="lazy" decoding="async"></div>
                                <div><img src="/resources/images/card-diners-club.png" alt="card-diners-club" width="10" height="6" loading="lazy" decoding="async"></div>
                                <div><img src="/resources/images/card-discover.png" alt="card-discover" width="10" height="6" loading="lazy" decoding="async"></div>
                                <div><img src="/resources/images/card-american-express.png" alt="card-american-express" width="10" height="6" loading="lazy" decoding="async"></div>
                            </div>
                        </div>
<div class="bdform PpayInfoForm">
  <!--  <form:select id="paymentDetails-cardCode" path="paymentDetails.cardCode" class="form-control cardtype" onchange="getcardValue(this,event);" items="${cardtype}" />  -->
    
  
    <div class="payment-card-expirysec">
        <div class="card-numberinput">
            <label>Card Number<span class="required-star">*</span></label>
            <form:hidden path="paymentDetails.cardCode" id="paymentDetails-cardCode" value="Visa" /> 
            <div class="lableUpOnFocus">
                <label class="not_focus_input apart_labl">Credit/Debit Card No.</label>
                <form:input id="paymentDetails_MaskCardNumber" path="paymentDetails.maskCardNumber" class="rkap form-control text-box numbersOnly numbersastseveOnly card-type focus_input" placeholder="" style="background-image:none;" maxlength="16" onkeyup="checkval(`paymentDetails_MaskCardNumber`,'input','id')" onfocus="checkval(`paymentDetails_MaskCardNumber`,'input','id')" />
                <span class="errorImg">
                    <img src="/resources/images/icons/tick.png" alt="tick">
                    <img src="/resources/images/icons/warning.png" alt="warning">
                </span>
            </div>
        </div>

        <div class="expirydate">
            <label>Expiration Date<span class="required-star">*</span></label>
            <div class="expirydate-inputs">
                <div class="lableUpOnFocus">
                    <form:select path="paymentDetails.expiryMonth" id="paymentDetails_ExpiryMonth"  onchange="checkval(`paymentDetails_ExpiryMonth`,'select','id')" onclick="checkval(`paymentDetails_ExpiryMonth`,'select','id')"  class="rkap2 form-control focus_input">
                        <c:forEach items="${cardMonth}" var="curExp" varStatus="loop">
                        <option value="${loop.index}">${curExp}</option>
                        </c:forEach>
                    </form:select>
                    <span class="errorImg">
                        <img src="/resources/images/icons/tick.png" alt="tick">
                        <img src="/resources/images/icons/warning.png" alt="warning">
                    </span>
                </div>
                <div class="lableUpOnFocus">
                    <form:select id="paymentDetails_ExpiryYear" path="paymentDetails.expiryYear" items="${cardyear}" class="rkap2 form-control focus_input" onchange="checkval(`paymentDetails_ExpiryYear`,'select','id')" onclick="checkval(`paymentDetails_ExpiryYear`,'select','id')" />
                    <span class="errorImg">
                        <img src="/resources/images/icons/tick.png" alt="tick">
                        <img src="/resources/images/icons/warning.png" alt="warning">
                    </span>
                </div>
                <div class="lableUpOnFocus">
                    <label class="not_focus_input apart_labl">CVV</label>
                    <form:password id="paymentDetails_CvvNo" path="paymentDetails.cvvNo" class="form-control rkap3 numbersOnly focus_input" placeholder="" maxlength="4" onkeyup="checkval(`paymentDetails_CvvNo`,'input','id')" onfocus="checkval(`paymentDetails_CvvNo`,'input','id')" />
                    <span class="errorImg">
                        <img src="/resources/images/icons/tick.png" alt="tick">
                        <img src="/resources/images/icons/warning.png" alt="warning">
                    </span>
                    <span class="aboutcvv-info-cvv"><img src="/resources/images/icons/info.png" alt="info">3-4 Digit Number on your card</span>
                </div>
                <div class="lableUpOnFocus aboutcvv-info-div">
                    <span class="aboutcvv-info"><img src="/resources/images/icons/info.png" alt="info">3-4 Digit Number on your card</span>
                </div>

            </div>
        </div>

    </div>
  
    
    <div class="cardholderinput">
        <label>Holder's Name<span class="required-star">*</span></label>
        <form:hidden id="paymentDetails_CardNumber" path="paymentDetails.cardNumber" name="Payments.CardNumber" />
        <div class="lableUpOnFocus">
            <label class="not_focus_input apart_labl">Card Holder's Name</label>
            <form:input id="paymentDetails_cardHolderName" path="paymentDetails.cardHolderName" class="rkap form-control textOnly focus_input" placeholder="" onkeyup="checkval(`paymentDetails_cardHolderName`,'input','id')" onfocus="checkval(`paymentDetails_cardHolderName`,'input','id')" />
            <span class="errorImg">
                <img src="/resources/images/icons/tick.png" alt="tick">
                <img src="/resources/images/icons/warning.png" alt="warning">
            </span>
        </div>
    </div>
	
  
    
   
</div>
<div class="notesDetails"><img src="/resources/images/icons/secure-card.png" alt="Secure Card"><strong>Safe and Secure Billing :</strong> Your credit/debit card information is protected by a secure SSL Encrypted Transaction</div>

</div></div>
                
                <div class="ccc-details bgblue">
                    <div class="cccdhead"><!-- <i class="fa fa-credit-card"></i> --><img src="/resources/images/icons/Pcredit-card-white.png" alt="Payment mode">&nbsp;&nbsp;Credit Card Contact Information</div>
                    
                    <div class="cccdform">
                    <div class="cccdform-inputs">
                            <label>Billing Phone<span class="required-star">*</span></label>
                        <div class="lableUpOnFocus"> 
                            <label class="not_focus_input apart_labl">Billing Phone</label>
                            <form:input path="phoneNo" id="phoneNo" minlength="10"  maxlength="15" class="focus_input form-control numbersOnly" placeholder=""  onkeyup="checkval(`phoneNo`,'input','id')" onfocus="checkval(`phoneNo`,'input','id')" onblur="checkval(`phoneNo`,'input','id')" />
                            <span class="errorImg">
                                <img src="/resources/images/icons/tick.png" alt="tick">
                                <img src="/resources/images/icons/warning.png" alt="warning">
                            </span>
                        </div>
                    </div>

                    <div class="cccdform-inputs">
                        <label>Mobile Phone<span class="required-star">*</span></label>
                        <div class="lableUpOnFocus">
                            <label class="not_focus_input apart_labl">Mobile Phone</label>
                            <form:input path="mobileNo" id="mobileNo" minlength="10" maxlength="15" class="focus_input form-control numbersOnly" placeholder=""  onkeyup="checkval(`mobileNo`,'input','id')" onfocus="checkval(`mobileNo`,'input','id')" onblur="checkval(`mobileNo`,'input','id')" />
                            <span class="errorImg">
                                <img src="/resources/images/icons/tick.png" alt="tick">
                                <img src="/resources/images/icons/warning.png" alt="warning">
                            </span>
                        </div>
                    </div>

                    <div class="cccdform-inputs">
                        <label>Email<span class="required-star">*</span></label>
                        <div class="lableUpOnFocus">
                            <label class="not_focus_input apart_labl">Email</label>
                            <form:input path="emailID" id="emailID" class="form-control focus_input" placeholder="" onkeyup="checkval(`emailID`,'input','id')" onfocus="checkval(`emailID`,'input','id')" onblur="checkval(`emailID`,'input','id')" />
                            <span class="errorImg">
                                <img src="/resources/images/icons/tick.png" alt="tick">
                                <img src="/resources/images/icons/warning.png" alt="warning">
                            </span>
                        </div>
                    </div>

                        <div class="cccdform-inputs">
                            <label>Retype Email<span class="required-star">*</span></label>
                            <div class="lableUpOnFocus">
                                <label class="not_focus_input apart_labl">Retype Email</label>
                                <form:input path="emailID1" id="emailID1" class="form-control focus_input" placeholder="" onkeyup="checkval(`emailID1`,'input','id')" onfocus="checkval(`emailID1`,'input','id')" onblur="checkval(`emailID1`,'input','id')" />
                                <span class="errorImg">
                                    <img src="/resources/images/icons/tick.png" alt="tick">
                                    <img src="/resources/images/icons/warning.png" alt="warning">
                                </span>
                            </div>
                        </div>
                    </div>
                    <div class="detailImprtSec">
                        <div class="detailTrvlSec">
                            <input type="checkbox" checked="true" name="">
                            <span>Send me the latest travel deals and special offers via email and/or SMS.</span>
                        </div>
                        <div class="importNoteSec">
                            <p><strong>Important! </strong><span> Provide your valid email and phone to reveive e-tickets and important messages. This will also be used as billing email id and phone number.</span></p>
                        </div>
                    </div>
                </div>
                <div class="pr-details bgblue">
                    <div class="prdhead"><!-- <i class="fa fa-shield"></i> --><img src="/resources/images/icons/Pinsurance-white.png" alt="Policies">&nbsp;&nbsp;Policies & Review</div>
                
                    <div class="prdcontent">
                        <div class="i-button">
                            Please confirm that the <b>date(s)</b> and <b>time(s)</b> of flights and <b>name(s)</b> of travelers are accurate.
                            <br>
                            <b>Each traveler's name and date of birth must be exactly as shown on the passport or other government-issued photo ID to be used on this trip.</b>
                        </div>
                       <!-- <div class="traveler-name">
                            <div class="tn-item">Traveler 1: <b> &nbsp;N/A</b></div>
                            <div class="tn-item">Traveler 2: <b> &nbsp;N/A</b></div>
                            <div class="tn-item">Traveler 3: <b> &nbsp;N/A</b></div>
                        </div> -->
                        <div class="terms-policies">
                            Tickets are non-transferable and name changes are not permitted. Total price shown includes all applicable <a href="#">taxes & fees</a> and our service fees. 
                            Some airlines may charge additional baggage fees or other fees. Fares are not guaranteed until ticketed.
                                Tickets and our fees are non-refundable (see Fare Rules). Some taxes and government agency fees may be non-refundable. 
                                Date and routing changes will be subject to airline penalties and our fees. 
                        </div>
                        <div class="submit-details">
                            <label>
                                <input type="checkbox" name="agree" id="iagree">
                                <div class="cb">
                                    <div class="checkmark"></div>
                                    <p style="font-size: 14px;"> By clicking Book Now, I agree that I have read and accepted Ebooktrip.com <a class="tcshow">Terms and Conditions</a> and <a class="ppshow">Privacy Policy</a></p>
                                </div>
                            </label>
                            <button type="submit" onClick="confirmFlight();" id="candbb" disabled>Confirm & Book
                                <span class="confirm-btn-text"><i class="fa fa-lock"></i> Verified & Secured</span>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            
            <!---- Price Desktop File Include Strat Here --->
			<c:if test="${searchRequest.device == 'Computer'}">
			 <jsp:include page="price_desktop.jsp" />
			</c:if>
			<!----- Price Desktop File Include End Here ------>
			
            <%-- <div class="ad-block">
                <div class="sa-item">
                    You may book in the next <b>20 minutes</b> as this page will then refresh.
                </div>
                <div class="price-details desktopPriceBox" id="priceblock">
                    <div class="pdhead">
                        <!-- <i class="fa fa-money"></i> --><img src="/resources/images/icons/Pmoney.png" alt="Price">&nbsp;&nbsp;Price Details 
                    </div>
                    <hr>
                    <div class="person-price" id="desktopPriceBox">
                        <div class="tpp">
                            <span><span>${bookingRequest.adults}</span> Traveler(s): <span>Adult</span></span>
                            <span>$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.adults * (bookingRequest.flightResult.fare.adultFare+bookingRequest.flightResult.fare.adultTax+bookingRequest.flightResult.fare.adultMarkup)}" /></span>
                        </div>
                        <div class="fcp">
                            <span>Flight Charges per <span>Adult</span> Incl All Taxes & Fees</span>
                            <span>$<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.flightResult.fare.adultFare+bookingRequest.flightResult.fare.adultTax+bookingRequest.flightResult.fare.adultMarkup}" /></span>
                        </div>
                        <div class="tfp">
                            <span>Taxes & Fees per <span>adult</span></span>
                            <span>$<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.flightResult.fare.adultTax+bookingRequest.flightResult.fare.adultMarkup}" /></span>
                        </div>
                    </div>
                    <hr>
        			<c:if test="${bookingRequest.child > 0}">
                    <div class="person-price">
                        <div class="tpp">
                            <span><span>${bookingRequest.child}</span> Traveler(s): <span>Child</span></span>
                            <span>$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.child * (bookingRequest.flightResult.fare.childFare+bookingRequest.flightResult.fare.childTax+bookingRequest.flightResult.fare.childMarkup)}" /></span>
                        </div>
                        <div class="fcp">
                            <span>Flight Charges per <span>Child</span></span>
                            <span>$<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.flightResult.fare.childFare+bookingRequest.flightResult.fare.childTax+bookingRequest.flightResult.fare.childMarkup}" /></span>
                        </div>
                        <div class="tfp">
                            <span>Taxes & Fees per <span>Child</span> Incl All Taxes & Fees</span>
                            <span>$<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.flightResult.fare.childTax+bookingRequest.flightResult.fare.childMarkup}" /></span>
                        </div>
                    </div>
                    <hr>
                    </c:if>
                    
                    <c:if test="${bookingRequest.infants > 0}">
                    <div class="person-price">
                        <div class="tpp">
                            <span><span>${bookingRequest.infants}</span> Traveler(s): <span>Infant(lap)</span></span>
                            <span>$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.infants * (bookingRequest.flightResult.fare.infantFare+bookingRequest.flightResult.fare.infantTax+bookingRequest.flightResult.fare.infantMarkup)}" /></span>
                        </div>
                        <div class="fcp">
                            <span>Flight Charges per <span>Infant(lap)</span> Incl All Taxes & Fees</span>
                            <span>$<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.flightResult.fare.infantFare+bookingRequest.flightResult.fare.infantTax+bookingRequest.flightResult.fare.infantMarkup}" /></span>
                        </div>
                        
                    </div>
                    <hr>
                    </c:if>
                    
                    <c:if test="${bookingRequest.infantsWs > 0}">
                    <div class="person-price">
                        <div class="tpp">
                            <span><span>${bookingRequest.infantsWs}</span> Traveler(s): <span>Infant(ws)</span></span>
                            <span>$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.infantsWs * (bookingRequest.flightResult.fare.infantWsFare+bookingRequest.flightResult.fare.infantWsTax+bookingRequest.flightResult.fare.infantWsMarkup)}" /></span>
                        </div>
                        <div class="fcp">
                            <span>Flight Charges per <span>Infant(ws)</span></span>
                            <span>$<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.flightResult.fare.infantWsFare+bookingRequest.flightResult.fare.infantWsTax+bookingRequest.flightResult.fare.infantWsMarkup}" /></span>
                        </div>
                        
                    </div>
                    <hr>
                    </c:if>
                    
                    <div class="person-price">
                        
                        <div class="tpp" id="tgfareladder" style="display:none; position:relative;text-font:15px;">
                            <span> Travel Guard Fee </span>
                            <span id="tg_price"></span>
                        </div>
                        
                    </div>
                    
                     <div class="total-price">
                        <span>Total Price:</span>
                        <span id="total_price">$<fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.flightResult.fare.grandTotal}" /></span>
                    </div>
                    <p>NOTE: All Fares displayed are quoted in USD and inclusive of base fare, taxes and all fees. Additional baggage fees may apply as per the airline policies.</p>
                </div>
                
                <div class="sa-item">
                    <div class="sa-head">Book with <img src="/resources/images/logo.png"></div>
                    <hr>
                    <div class="sa-row"><i class="fa fa-check"></i><span> Travel Industry Award Winner</span></div>
                    <div class="sa-row"><i class="fa fa-check"></i><span> IATAN, ARC, ASTA Member</span></div>
                    <div class="sa-row"><i class="fa fa-check"></i><span> Travel Weekly Power List</span></div>
                </div>
            </div>
             --%>
        </div>
        </form:form>
        <div class="terms-screen-overlay">
            <div class="terms-and-conditions">
                <div class="t-and-c-close"><h5>TERMS AND CONDITIONS</h5><i class="fa fa-close"></i></div>
                <div class="t-and-c-of">
                    <p>
                        These Terms and Conditions, together with any other written information we brought to your attention during the process of confirming your booking, 
                        apply to your booking Trading as Ebooktrip. Please read the Terms and Conditions carefully prior to utilising Ebooktrip website and making any bookings. 
                        You consent to the Terms and Conditions when you use the Site, without qualification. 
                        If you do not agree with any portion of the Terms and Conditions, you cannot utilise the website in any method or make a booking.
                    </p>
                    <p>
                        All communications concerning customer service or your booking needs to be sent to Ebooktrip, 4208, 198th st, SW, suite 203 Lynnwood, wa, 98036 or drop an email to:
                        <a href="mailto:support@ebooktrip.com">support@ebooktrip.com</a>
                    </p>
                    <h6>CONTRACT</h6>
                    <p>
                        When making your reservation we, as a representative, would organise it for you to come into an agreement with the principal(s) or other supplier(s) such as tour operator / airline / cruise firm / lodging firm etc. as mentioned on your receipt(s). We could reserve you a holiday deal, in which instance you would hold one agreement with the principal,
                        or we could reserve the services that make up your trip with various principals or suppliers, in which instance you would have different agreements with every one of them.
                    </p>
                    <p>
                        As a representative, we take no accountability for the actions or cuts of the principal(s) or supplier(s) or for the services offered by them. 
                        The principal�s(s�) or supplier�s(s�) Terms & Conditions would relate to your reservation and we suggest that you read them cautiously as they do hold significant details about your reservations. Kindly request for copies of these if you do not possess them.
                    </p>
                    <h6>BOOKING</h6>
                    <p>
                        Passengers must make sure that all the names and timings are accurate as per their passports and that the travel itinerary is correct. Changes might not be allowed after the tickets are provided and alterations may incur additional charges.
                    </p>
                    <p>
                        During a booking, all details will be read back to you and the respective details will be confirmed with the principal(s) or the supplier(s). On receipt of all travel documents please check whether the details such as names, dates and timings are accurate and advise us immediately if any revisions to be done. 
                        Also, please be noted that all the tickets supplied are non-refundable, non-changeable and non-transferable unless otherwise stated.
                    </p>
                    <p>The booking information that you provide to us will be passed on only to the relevant suppliers of your travel arrangements or other particular persons who are a part of the provision of your travel 
                        arrangements. Further, if required by any authorities, or as required by law, the information may be provided to public authorities such as customs or immigration. 
                        This applies to any sensitive information that you provide such as details of any disabilities, or dietary and religious requirements. Certain information may also be passed on to security 
                        or credit checking companies. If you are travelling to the United States, the US Customs and Border Protection will receive this information for the purposes of preventing and combating 
                        terrorism and other transnational serious crimes. If you travel outside the European Economic Area, controls on data protection may not be as strong as the legal requirements in this country. 
                        If we cannot pass this information to the relevant suppliers, whether in the EEA or not, we will be unable to provide your booking. In making this booking, you consent to this information 
                        being passed on to the relevant persons. Full details of our data protection policy are available upon request.
                    </p>
                    <p>Airfares are promised upon ticketing only. If there would be any problem with the payment, we would inform you as soon as possible via email and/or phone. Otherwise, we would send you the ticket within 48 hours of your booking with us.</p>
                    <p>The free baggage allowance offered to the passenger differs based on the route, class/cabin seating and as per the norms of the Individual airline. Airlines might charge an extra fee for checked-in baggage, additional baggage or other voluntary services. Please contact the airlines straight for the most current updates concerning the baggage payment, weight and sizes of the bags.
                    </p>
                    <p>Passengers need to be at the airport 3 hours prior to the departure as tickets could not be refunded or changed because of a no show at the airport.</p>
                    <p>Passengers are held accountable for all their travel documentation plus visas. Visas might be needed for the whole journey both for the destination and/or transit. Visas need to be acquired prior to the ticket been issued.</p>
                    <h6>PAYMENT</h6>
                    <p>Customers are required to pay an instalment or the whole amount at the time of booking. If only a part payment is made, the balance has to be paid on or before the stipulated due date. Failing to do so may result in cancellation of the booking by the principal(s) or supplier(s). This may involve cancellation fees set out in their Terms and Conditions. Unless otherwise mentioned in the booking
                        conditions or advised all the amount paid for the bookings will be held on behalf of the principal(s) or supplier(s) concerned.
                    </p>
                </div>
            </div>
        </div>
        <div class="policy-screen-overlay">
            <div class="privacy-and-policy">
                <div class="p-and-p-close"><h5>PRIVACY AND POLICY</h5><i class="fa fa-close"></i></div>
                <div class="p-and-p-of">
                    <p>
                        This Privacy Notice sets out how Ebooktrip, 
                        registered at 4208, 198th st, SW, suite 203 Lynnwood, wa, 98036 and its associated trading names, protects the privacy of your personal information.
                    </p>
                    <p>
                        We recognise and acknowledge the importance of your personal data and are committed to respecting your privacy and protecting your personal information.
                    </p>
                    <b>
                        1. What information do we collect and why?
                    </b>
                    <p>
                        We need to collect, use and disclose personal information to perform our duties as a travel agent, namely, making and managing travel bookings on behalf of our customers. During the course of our relationship we may collect the following:
                    </p>
                    <p>
                        a. <b>Personal and contact details</b>, such as title, full name, contact details (address, telephone and email address)
                    </p>
                    <p>
                        b. <b>Passport number</b>, date of birth and nationality - if required by the respective airline
                    </p>
                    <p>c. <b>Payment information:</b> card number, security number, expiration date and cardholder name</p>
                    <p>d. <b>Frequent flyer numbers</b>, car rental programme and hotel room preferences (if applicable)</p>
                    <p>e. <b>Dietary requirements and health issues</b> (if any) relevant to your travel arrangements or required by the relevant travel service provider(s) (e.g. accommodation or tour providers).</p>
                    <p>f. <b>Information provided</b> by filling forms on our website e.g. email address, where you heard about us and your travel preferences. This information will be used to keep you up to date with all our latest offers and products</p>
                    <p>g. <b>Call recordings</b> - calls may be recorded for the purposes of quality control and staff training</p>
                    <p>h. <b>Social media</b> - by interacting with the social media features on our website (Facebook, Twitter or Instagram) you will be bound by the privacy policies of the respective social media companies</p>
                    <p>i. <b>IP address and cookies</b> - When you access our website our servers may record data regarding your device and the network you are using to connect with us, including your IP address</p>
                </div>
            </div>
        </div>
        
        
        <jsp:include page="../../footer2.jsp" />
        
    </body>
   <script>
       $(".t-and-c-close i").click(function(){
           $(".terms-screen-overlay").hide();
       });
       $(".tcshow").click(function(){
           $(".terms-screen-overlay").css("display","flex");
       });
       $(".p-and-p-close i").click(function(){
           $(".policy-screen-overlay").hide();
       });
       $(".ppshow").click(function(){
           $(".policy-screen-overlay").css("display","flex");
       });
       $('#iagree').click(function(){
    	if($(this).is(':checked')){
           $('#candbb').attr("disabled", false);
        } 
        else{
        	$('#candbb').attr("disabled", true);
        }
	});
   </script>
	<script>
		function timeConvert(n) {
			var num = n;
			var hours = (num / 60);
			var rhours = Math.floor(hours);
			var minutes = (hours - rhours) * 60;
			var rminutes = Math.round(minutes);
			return rhours + " h " + rminutes + " m";
		}
		
		function getCabin(id){
				var cabin = "Economy";
				if(id == 1){
					cabin = "Economy";
				}
				else if(id == 2){
					cabin = "Premium Economy";
				}
				else if(id == 3){
					cabin = "Business";
				}
				else if(id == 4){
					cabin = "First";
				}
				return cabin;
		}
$(document).ready(function () {
    $(".focus_input").each(function () {
        "" != $(this).val() && $(this).val().length > 3 ? $(this).parent().find(".not_focus_input").removeClass("apart_labl") : $(this).parent().find(".not_focus_input").addClass("apart_labl");
    }),
    $(".focus_input").on("focus keyup", function () {
        $(this).parent().find(".not_focus_input").removeClass("apart_labl");
    }),
    $(".focus_input").on("focusout", function () {
        if ("" != $(this).val() && $(this).val().length > 0) {
            $(this).parent().find(".not_focus_input").removeClass("apart_labl");
            var e = $(this).val();
            console.log("FocusOut: " + e.length), e.length < 1 && ($(this).val(""), $(this).parent().find(".not_focus_input").addClass("apart_labl"));
        } else $(this).parent().find(".not_focus_input").addClass("apart_labl");
    });
});
function checkval(id,type,type2){
    //console.log(id,type)
    if(type == 'select'){
        if(type2 == 'id'){
            var selectV = $("#"+id).val();
            if(selectV != 0 && selectV != 'Day' && selectV != 'Year'){console.log(selectV)
                $("#"+id+' + .errorImg').addClass('active check').removeClass('error')
            }else{
                $("#"+id+' + .errorImg').addClass('active error').removeClass('check')
            }
        }
        if(type2 == 'class'){
            var selectV_ = $("."+id).val();
            if(selectV_ != 0 && selectV_ != 'Day' && selectV_ != 'Year'){console.log(selectV_,'select class check')
                $("."+id+' + .errorImg').addClass('active check').removeClass('error')
                $("."+id).parent().find('.errorImg').addClass('active check').removeClass('error')
            }else{console.log(selectV_,'select class error')
                $("."+id+' + .errorImg').addClass('active error').removeClass('check')
                $("."+id).parent().find('.errorImg').addClass('active error').removeClass('check')
            }
        }
    }
    if(type == 'input'){
        if(type2 == 'id'){
            var inputV = $("#"+id).val(); console.log($("#"+id).hasClass('has-error'))
            if(inputV.length < 1 || $("#"+id).hasClass('has-error') ){
                $("#"+id+' + .errorImg').addClass('active error').removeClass('check')
                $("#"+id).parent().find('.errorImg').addClass('active error').removeClass('check')
            }else{
                $("#"+id+' + .errorImg').addClass('active check').removeClass('error')
                $("#"+id).parent().find('.errorImg').addClass('active check').removeClass('error')
            }
        }
        if(type2 == 'class'){
            var inputV_ = $("."+id).val();
            if(inputV_.length > 0){
                $("."+id+' + .errorImg').addClass('active check').removeClass('error')
                $("."+id).parent().find('.errorImg').addClass('active check').removeClass('error')
            }else{
                $("."+id+' + .errorImg').addClass('active error').removeClass('check')
                $("."+id).parent().find('.errorImg').addClass('active error').removeClass('check')
            }
        }
    }
}
		</script>
</html>