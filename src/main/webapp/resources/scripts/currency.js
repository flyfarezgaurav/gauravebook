 function currencySave(){
	  var country = $("#_countryselect").val();
	  var language = $("#_languageselect").val();
	  openCurrencyPopup('hide');
	  
$.get("/getCurrencyResponse/"+language, function(data, status){
	// alert("Data: " + data + "\nStatus: " + status);
   var  _languageselect = $("#_languageselect").val();
	  if(_languageselect == 'USA')
	  {
		  window.location.href="https://www.ebooktrip.com";
		  $("#_currencyselect").val("USD");
		  $("#_languageselect").val("EN");
	  }
	  else if(_languageselect == 'gb')
	  {
		  window.location.href="https://www.uk.ebooktrip.com";
		  $("#_currencyselect").val("GBP");
		  $("#_languageselect").val("GB");
	  }
	  else if(_languageselect == 'ca')
	  {
		  window.location.href="https://www.ca.ebooktrip.com";
		  $("#_currencyselect").val("CAD");
		  $("#_languageselect").val("CA");
	  }
	  else if(_languageselect == 'mx')
	  {
		  window.location.href="https://www.ebooktrip.es";
		  $("#_currencyselect").val("MXN");
		  $("#_languageselect").val("MX");
	  }
});

  $.get("/getCurrencyResponse/"+country, function(data, status){
	   // alert("Data: " + data + "\nStatus: " + status);
	  var  _countryselect = $("#_countryselect").val();
		 if(_countryselect == 'USA')
		 {
			 window.location.href="https://www.ebooktrip.com";
			 $("#_currencyselect").val("USD");
			 $("#_languageselect").val("EN");
		 }
		 else if(_countryselect == 'gb')
		 {
			 window.location.href="https://www.uk.ebooktrip.com";
			 $("#_currencyselect").val("GBP");
			 $("#_languageselect").val("GB");
		 }
		 else if(_countryselect == 'ca')
		 {
			 window.location.href="https://www.ca.ebooktrip.com";
			 $("#_currencyselect").val("CAD");
			 $("#_languageselect").val("CA");
		 }
		 else if(_countryselect == 'mx')
		 {
			 window.location.href="https://www.ebooktrip.es";
			 $("#_currencyselect").val("MXN");
			 $("#_languageselect").val("MX");
		 }
  });
  
  }
  
  function countryvaluchng(){
	var  _countryselect = $("#_countryselect").val();
	if(_countryselect == 'USA'){
		$("#_currencyselect").val("USD");
		$("#_languageselect").val("EN");
	}
	else if(_countryselect == 'gb'){
		$("#_currencyselect").val("GBP");
		$("#_languageselect").val("GB");
	}
	else if(_countryselect == 'ca'){
		$("#_currencyselect").val("CAD");
		$("#_languageselect").val("CA");
	}
	else if(_countryselect == 'mx'){
		$("#_currencyselect").val("MXN");
		$("#_languageselect").val("MX");
	}	 
	
 }