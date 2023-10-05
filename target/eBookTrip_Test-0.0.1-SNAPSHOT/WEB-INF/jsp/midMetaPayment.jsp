<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <title>
            Please Wait
        </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet'>
	<link rel="icon" href="/resources/images/favicon.png">
		<link rel="stylesheet" href="/resources/css/loader.css?124" type="text/css">
		<script src="/resources/scripts/jquery-1.11.1.min.js"></script>
		<script>
		function randomString(length) {
    var chars = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz'.split('');

    if (! length) {
        length = Math.floor(Math.random() * chars.length);
    }

    var str = '';
    for (var i = 0; i < length; i++) {
        str += chars[Math.floor(Math.random() * chars.length)];
    }
    return str;
} 
		setTimeout(function(){
			$("#secondMsg").show();
			$("#firstMsg").hide();
		},1000);
		
		setTimeout(function(){
			var rndId = randomString(12);
			$('form#bookingRequest').attr({action: '/deep/link/'+rndId}); 
			$('form#bookingRequest').submit();
		},1000);
		
		
		</script>
    <jsp:include page="tag-manager-head.jsp" /></head>
<body><jsp:include page="tag-manager-body.jsp" />
<form:form method="POST" action="/deep/link" modelAttribute="bookingRequest" novalidate="novalidate">
</form:form>
	<div class="loader"></div>
    <div class="pwait">Please Wait...</div>
	<div id="firstMsg" class="wline">While we confirm selected flight</div>
    <div id="secondMsg" style="display:none;" class="wline">While we Confirm your selected flight</div>
    <p>Please do not close this page or press your browser's back button.</p>
</body>
</html>

