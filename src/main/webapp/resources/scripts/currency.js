 function currencySave(){
	  var country = $("#_countryselect").val();
	  openCurrencyPopup('hide');
	 // alert(country);
  $.get("/getCurrencyResponse/"+country, function(data, status){
   // alert("Data: " + data + "\nStatus: " + status);
  });
  
  }
  
  function countryvaluchng(){
	 var  _countryselect = $("#_countryselect").val();
	 if(_countryselect == 'USA')
		 $("#_currencyselect").val("USD");
	 else if(_countryselect == 'gb')
		 $("#_currencyselect").val("GBP");
	 else if(_countryselect == 'ca')
		 $("#_currencyselect").val("CAD");
	 else if(_countryselect == 'mx')
		 $("#_currencyselect").val("MEX");
  }