<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
	<script src="/resources/scripts/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		function GetQueryStringParameter(values){
			var urlQueryString = window.location.href.slice(window.location.href.indexOf('?')+1).split('&');
			for(var i=0; i<urlQueryString.length;i++){
				var urlValues = urlQueryString[i].split('=');
				if(urlValues[0]==values){
					return urlValues[1];
				}
			}
		}
		
		var urm_source = GetQueryStringParameter("utm_source");
		var searchID = randomString(15);
		var url = "https://www.ebooktrip.com/flight-listing/"+searchID+"?urm_source="+urm_source;
		console.log(url);
		var encodedUrl = decodeURIComponent(url);
		$(location).attr("href", encodedUrl);
	});
	
	function randomString(length){
		var charString = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
		var charStr = "";
		for(var i=0; i<length;i++){
			charStr += charString[Math.floor(Math.random() * charString.length)];
		}
		return charStr;
	}
	</script>
	
  </head>
  
</html>