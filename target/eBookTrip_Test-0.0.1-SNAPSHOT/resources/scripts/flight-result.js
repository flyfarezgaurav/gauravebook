var FlightApp = angular.module("FlightApp",['infinite-scroll']);


FlightApp.factory("flightFactory",function($http){
return{
getFlightResult:function(){
return $http({
url : "/getFlightResponse",
method : "GET",
headers : {
'Content-Type' : '*'
}
})
}
}

})

FlightApp.directive("resultLoader", function() {
	return{
		link: function($scope,element){
			$scope.$watch("resultLoader",function(val){
				if(val){
					$(element).show();
				}
				else{
					$(element).hide();
				}
			})
				
			
		}
	}
})

FlightApp.controller("FlightCntrl",function($scope,$http,$window,$timeout,flightFactory,$filter){

$scope.flightsResponse  = [];
$scope.flightsMainResponse  = [];
$scope.flightsAlterResponse  = [];
$scope.airports  = [];
$scope.airlines  = [];
$scope.numberOfResult = 10;
$scope.sortingValues = ["Low to High","High to Low"];
$scope.sortValue = "Low to High";
$scope.sliderMinFare = 0;
$scope.sliderMaxFare = 0;
$scope.minFare = 0;
$scope.maxFare = 0;
$scope.sliderMinDpt = 0000;
$scope.sliderMaxDpt = 2359;
$scope.minDpt = 0000;
$scope.maxDpt = 2359;
$scope.sliderMinRet = 0000;
$scope.sliderMaxRet = 2359;
$scope.minRet = 0000;
$scope.maxRet = 2359;
$scope.selectedAirlines=[];
$scope.resultAdd = 0;
$scope.stopsList = [];
$scope.selectedStops=[];
$scope.nonstopfare = 0.0,$scope.onestopfare = 0.0,$scope.twostopfare = 0.0;
$scope.nonstopcount = 0,$scope.onestopcount = 0,$scope.twostopcount = 0;
$scope.departAirports = [];
$scope.selectedDepartAirports = [];
$scope.returnAirports = [];
$scope.selectedReturnAirports = [];
$scope.airlinesList = [];
$scope.airlineFilterList = [];
$scope.flightsTimesdept=[];
$scope.flightsTimesret=[];
$scope.depLayAirports = [];
$scope.selDepLayAirports = [];
$scope.retLayAirports = [];
$scope.selRetLayAirports = [];
$scope.staticLoader = [1,2,3,4,5,6,7,8,9,0];
$scope.tripType = $("#tripType").val();
$scope.searchID = $("#searchID").val();
$scope.pageAirline = $("#pageAirline").val();
$scope.airlineSortList = [];
$scope.otherSortList = [];
$scope.loading = true;
$scope.resultLoader = true;
$scope.matrix = [];
$scope.stopm="all";
$scope.airlinem="all";
$scope.airlinematrix="all";
$scope.pricem = 0;
$scope.sortKey="";
$scope.shortestFlightList = [];
$scope.alternateFlightList = [];
$scope.shortestFlightFare=0.0;
$scope.alternateFlightFare=0.0;
$scope.searchList = [];
$scope.departDate = $("#departDate").val();
$scope.currencySymbol = $("#currencySymbol").val();
$scope.currencyValue = 1;
if($scope.tripType == 2){
	$scope.returnDate = $("#returnDate").val();
}
var flightResult  = flightFactory.getFlightResult();
flightResult.then(function(response){
$scope.flightsResponse  = response.data;
$scope.airports  = response.data.airport;
$scope.airlines  = response.data.airline;
console.log(response.data);
$scope.currencySymbol = $scope.flightsResponse.flightResult[0].currencyCode;
setTimeout(function(){
	var sliderPrice = $("#price-range").text();
	localStorage.setItem('sliderPrice',sliderPrice);
	var sliderDepartTime = $("#depart-time").text();
	localStorage.setItem('sliderDepartTime',sliderDepartTime);
	var sliderReturnTime = $("#return-time").text();
	localStorage.setItem('sliderReturnTime',sliderReturnTime);
	if(response.data.responsStatus.messege == 'success'){
		var orignVal = $("#origin").val();
		var destinVal = $("#destination").val();
		var departDateVal = $("#departDate").val();
		var returnDateVal = $("#returnDate").val();
		var popcabin = $("#cabin").find(":selected").val();
		var roundTripVal = $("#rkaps").prop("checked");
		var onewayTripVal = $("#oneway").prop("checked");
		var adultVal = response.data.adults+response.data.child+response.data.infants+response.data.infantsWs;
		var orignVal_1 = orignVal.split(',');
		var orignVal_2 = orignVal_1[0].split('-');
		var result_first_price = response.data.flightResult[0].mPrice.toFixed(2).toString();
		//var coach = response.data.adults;
		$("#popupOriginInput").val(orignVal);
		$("#popupuOriginTxt").text(orignVal_2[1]);
		//console.log(orignVal_2)
		var destinVal_1 = destinVal.split(',');
		var destinVal_2 = destinVal_1[0].split('-');
		$("#popupDestinatioInput").val(destinVal);
		$("#popupuDestinationTxt").text(destinVal_2[1]);
		$("#popupDepartDate").val(departDateVal);
		$("#popupReturnDate").val(returnDateVal);console.log(popcabin)
		if(adultVal == 1){console.log('one----',adultVal)
			//$(".coach-button > .coach").val(adultVal+' Traveller')
			$("#popupTravlerInput").val(adultVal);
		}else{console.log('two----',adultVal)
			//$(".coach-button > .coach").val(adultVal+' Travellers')
			$("#popupTravlerInput").val(adultVal);
		}
		if(roundTripVal == true){ 
			$("#tripTypeId").val("roundTrip");
			$("#popTriptypeText").text("Round-Trip");
			$("#R_depRet").addClass('roundTrip').removeClass('oneWay')
		}
		if(onewayTripVal == true){ 
			$("#tripTypeId").val("oneWay");
			$("#popTriptypeText").text("One Way");
			$("#R_depRet").addClass('oneWay').removeClass('roundTrip')
		}
		$("#popupCabin").val(popcabin);
		$("#popClassText").text(popcabin);
		$("#popMainPrive").text($scope.currencySymbol+(result_first_price*$scope.currencyValue).toFixed(2).toString());
		var tenPercent = (result_first_price * 5) / 100;console.log(tenPercent)
		var offerPrice = result_first_price - tenPercent;console.log(offerPrice)
		$("#popOfferPrice").text((offerPrice*$scope.currencyValue).toFixed(2).toString());

		
		$("#newPopup").addClass('active');
		//$('body').addClass('overflowHidden')
	}
}, 4000);
if($scope.flightsResponse.responsStatus.status == 0){
	$scope.flightsResponse.flightResult = [];
	 $scope.loading = false;
 $scope.resultLoader = false;
 $(".placeholder-item").removeClass("placeholder-item");
}
else{
	 $scope.loading = false;
 $scope.resultLoader = false;
$scope.sliderMinFare = ($scope.flightsResponse.flightResult[0].fare.adultFare+$scope.flightsResponse.flightResult[0].fare.adultTax+$scope.flightsResponse.flightResult[0].fare.adultMarkup);
$scope.sliderMaxFare = ($scope.flightsResponse.flightResult[$scope.flightsResponse.flightResult.length-1].fare.adultFare+$scope.flightsResponse.flightResult[$scope.flightsResponse.flightResult.length-1].fare.adultTax+$scope.flightsResponse.flightResult[$scope.flightsResponse.flightResult.length-1].fare.adultMarkup);
$scope.minFare = ($scope.flightsResponse.flightResult[0].fare.adultFare+$scope.flightsResponse.flightResult[0].fare.adultTax+$scope.flightsResponse.flightResult[0].fare.adultMarkup);
  $scope.maxFare = ($scope.flightsResponse.flightResult[$scope.flightsResponse.flightResult.length-1].fare.adultFare+$scope.flightsResponse.flightResult[$scope.flightsResponse.flightResult.length-1].fare.adultTax+$scope.flightsResponse.flightResult[$scope.flightsResponse.flightResult.length-1].fare.adultMarkup);
 $("#minFarePrice").val($scope.minFare);
 if($scope.pageAirline != ''){

	angular.forEach($scope.flightsResponse.flightResult, function(flight,index){
					if($scope.pageAirline == flight.airline)
					{
					$scope.airlineSortList.push(flight);
					}
					else
					{
					$scope.otherSortList.push(flight);
					}
	})			
				
	//console.log($scope.airlineSortList)
angular.forEach($scope.otherSortList, function(other,index){
$scope.airlineSortList.push(other);
})
$scope.flightsResponse.flightResult = $scope.airlineSortList;
//console.log($scope.flightsResponse.flightResult)

}

  angular.forEach($scope.flightsResponse.flightResult, function(flight,index){
	  flight['totalEFT'] = flight.outEFT+flight.inEFT;
	  flight['alternate'] = 2;
	  if($scope.compareDepartDates($filter('date')(flight.outBound[0].depDate, "MM/dd/yyyy"))){
		  flight['alternate'] = 1;
	  }
	  flight['mPrice']=flight.fare.adultFare+flight.fare.adultTax+flight.fare.adultMarkup
  if(flight.outBound.length == 1){
     $scope.nonstopcount++;
 if($scope.nonstopfare == 0.0){
 $scope.nonstopfare = (flight.fare.adultFare+flight.fare.adultTax+flight.fare.adultMarkup);
 }
 else if($scope.nonstopfare > (flight.fare.adultFare+flight.fare.adultTax+flight.fare.adultMarkup)){
 $scope.nonstopfare = (flight.fare.adultFare+flight.fare.adultTax+flight.fare.adultMarkup);
 }
 flight['stops'] = 0;
 }
 
 else if(flight.outBound.length == 2){
     $scope.onestopcount++;
 if($scope.onestopfare == 0.0){
 $scope.onestopfare = (flight.fare.adultFare+flight.fare.adultTax+flight.fare.adultMarkup);
 }
 else if($scope.onestopfare > (flight.fare.adultFare+flight.fare.adultTax+flight.fare.adultMarkup)){
 $scope.onestopfare = (flight.fare.adultFare+flight.fare.adultTax+flight.fare.adultMarkup);
 }
 flight['stops'] = 1;
 }
 else if(flight.outBound.length == 3){
     $scope.twostopcount++;
 if($scope.twostopfare == 0.0){
 $scope.twostopfare = (flight.fare.adultFare+flight.fare.adultTax+flight.fare.adultMarkup);
 }
 else if($scope.twostopfare > (flight.fare.adultFare+flight.fare.adultTax+flight.fare.adultMarkup)){
 $scope.twostopfare = (flight.fare.adultFare+flight.fare.adultTax+flight.fare.adultMarkup);
 }
 flight['stops'] = 2;
 }
 
 if($scope.departAirports.length == 0){
var departObj = {"airport":flight.outBound[0].fromAirport,"fare":(flight.fare.adultFare+flight.fare.adultTax+flight.fare.adultMarkup)};
$scope.departAirports.push(departObj);
}
else {
$scope.airportMatch = false;
angular.forEach($scope.departAirports,function(depart){
if(depart.airport == flight.outBound[0].fromAirport){
$scope.airportMatch = true;

}
})
if($scope.airportMatch == false){
var departObj = {"airport":flight.outBound[0].fromAirport,"fare":(flight.fare.adultFare+flight.fare.adultTax+flight.fare.adultMarkup)};
$scope.departAirports.push(departObj);
}
}

if($scope.tripType == 2){
if($scope.compareReturnDates($filter('date')(flight.inBound[0].depDate, "MM/dd/yyyy"))){
		  flight['alternate'] = 1;
	  }
if($scope.returnAirports.length == 0){
var returnObj = {"airport":flight.inBound[0].fromAirport,"fare":(flight.fare.adultFare+flight.fare.adultTax+flight.fare.adultMarkup)};
$scope.returnAirports.push(returnObj);
}
else {
$scope.airportMatch = false;
angular.forEach($scope.returnAirports,function(retr){
if(retr.airport == flight.inBound[0].fromAirport){
$scope.airportMatch = true;

}
})
if($scope.airportMatch == false){
var returnObj = {"airport":flight.inBound[0].fromAirport,"fare":(flight.fare.adultFare+flight.fare.adultTax+flight.fare.adultMarkup)};
$scope.returnAirports.push(returnObj);
}
}
var returnTime = flight.inBound[0].depDate.split('T')[1].split(':');
 flight['returns'] = returnTime[0]+returnTime[1];
 
 if(index == 0){
 $scope.sliderMinRet = parseInt(returnTime[0]+returnTime[1]);
$scope.sliderMaxRet = parseInt(returnTime[0]+returnTime[1]);
$scope.minRet = parseInt(returnTime[0]+returnTime[1]);
$scope.maxRet = parseInt(returnTime[0]+returnTime[1]);
 }
 if($scope.sliderMinRet > parseInt(returnTime[0]+returnTime[1])){
	 $scope.sliderMinRet = parseInt(returnTime[0]+returnTime[1]);
	 $scope.minRet = parseInt(returnTime[0]+returnTime[1]);
 }
 if($scope.sliderMaxRet < parseInt(returnTime[0]+returnTime[1])){
	 $scope.sliderMaxRet = parseInt(returnTime[0]+returnTime[1]);
	 $scope.maxRet = parseInt(returnTime[0]+returnTime[1]);
 }
 
}



$scope.airlineMatch = false;
 if($scope.airlineFilterList.length == 0){
$scope.airlineMatch = true;
if(flight.outBound[0].airline.length == 2){
 var airline = {"code":flight.outBound[0].airline,"fare":(flight.fare.adultFare+flight.fare.adultTax+flight.fare.adultMarkup)};
$scope.airlineFilterList.push(airline);
}
else{
var airline = {"code":"XXX","fare":(flight.fare.adultFare+flight.fare.adultTax+flight.fare.adultMarkup)};
$scope.airlineFilterList.push(airline);
}

 }
 else{
    angular.forEach($scope.airlineFilterList, function(airline){
 if(airline.code == flight.outBound[0].airline){
 $scope.airlineMatch = true;
 if(airline.fare > (flight.fare.adultFare+flight.fare.adultTax+flight.fare.adultMarkup)){
 airline.fare = (flight.fare.adultFare+flight.fare.adultTax+flight.fare.adultMarkup);
 //break;
 }
 }
 else if(flight.outBound[0].airline.length > 2 && airline.code == 'XXX'){
 $scope.airlineMatch = true;
 if(airline.fare > (flight.fare.adultFare+flight.fare.adultTax+flight.fare.adultMarkup)){
 airline.fare = (flight.fare.adultFare+flight.fare.adultTax+flight.fare.adultMarkup);
 //break;
 }
 }
 
 });
 }

if(!$scope.airlineMatch){
if(flight.outBound[0].airline.length == 2){
var airline = {"code":flight.outBound[0].airline,"fare":(flight.fare.adultFare+flight.fare.adultTax+flight.fare.adultMarkup)};
$scope.airlineFilterList.push(airline);
}
else{
var airline = {"code":"XXX","fare":(flight.fare.adultFare+flight.fare.adultTax+flight.fare.adultMarkup)};
$scope.airlineFilterList.push(airline);
}
}
var departTime = flight.outBound[0].depDate.split('T')[1].split(':');
 flight['depart'] = departTime[0]+departTime[1];
 if(index == 0){
 $scope.sliderMinDpt = parseInt(departTime[0]+departTime[1]);
$scope.sliderMaxDpt = parseInt(departTime[0]+departTime[1]);
$scope.minDpt = parseInt(departTime[0]+departTime[1]);
$scope.maxDpt = parseInt(departTime[0]+departTime[1]);
 }
 if($scope.sliderMinDpt > parseInt(departTime[0]+departTime[1])){
	 $scope.sliderMinDpt = parseInt(departTime[0]+departTime[1]);
	 $scope.minDpt = parseInt(departTime[0]+departTime[1]);
 }
 if($scope.sliderMaxDpt < parseInt(departTime[0]+departTime[1])){
	 $scope.sliderMaxDpt = parseInt(departTime[0]+departTime[1]);
	 $scope.maxDpt = parseInt(departTime[0]+departTime[1]);
 } 
 if(flight.alternate == 1){
	 $scope.flightsAlterResponse.push(flight);
 }else{
	 $scope.flightsMainResponse.push(flight);
 }

  });
  if($scope.flightsAlterResponse.length > 1){
  if($scope.flightsAlterResponse[0].mPrice<$scope.flightsMainResponse[0].mPrice){
	  $scope.flightsMainResponse.push($scope.flightsAlterResponse[0]);
  }
  }
  $scope.flightsResponse['flightResult']=($scope.flightsMainResponse);
 // console.log($scope.flightsAlterResponse);
 // console.log($scope.flightsMainResponse);
  angular.forEach($scope.airlineFilterList, function(airline,index){
	 var matrixobj = {"airline":airline.code,"stoprice":[{"fare":0,"stop":0},{"fare":0,"stop":1},{"fare":0,"stop":2}]};
	 $scope.matrix.push(matrixobj);
  })	 
  
  $timeout(function(){
			//$scope.tempmatrix = [];
			angular.forEach($scope.flightsResponse.flightResult, function(flight,index){
				
				var depLayovers = "";
				var retLayovers = "";
				angular.forEach(flight.outBound, function(outBound,index){
					depLayovers = "";
					
					depLayovers = depLayovers+","+outBound.fromAirport;
					if(flight.outBound.length > 1 && index > 0 && $scope.depLayAirports.indexOf(outBound.fromAirport) == -1){
						$scope.depLayAirports.push(outBound.fromAirport)
					}
				});
				if($scope.tripType == 2){
				angular.forEach(flight.inBound, function(inBound,index){
					retLayovers = "";
					retLayovers = retLayovers+","+inBound.fromAirport;
					if(flight.inBound.length > 1 && index > 0 && $scope.retLayAirports.indexOf(inBound.fromAirport) == -1){
						$scope.retLayAirports.push(inBound.fromAirport)
					}
					
				});
				}
				flight['depLayovers'] = depLayovers;
				flight['retLayovers'] = retLayovers;
				
							
				angular.forEach($scope.matrix, function(matrix,index){
					if(matrix.airline == flight.outBound[0].airline){
						
						angular.forEach(matrix.stoprice, function(stoprice,index){
							if(stoprice.stop == flight.stops && stoprice.fare == 0){
							stoprice.fare = (flight.fare.adultFare+flight.fare.adultTax+flight.fare.adultMarkup);
							
							}
						})
					}
				})
				//console.log($scope.matrix);
				
				});
				
			$scope.shortestFlightList = $filter('orderBy')($scope.flightsResponse.flightResult,'totalEFT');
				$scope.shortestFlightFare=$scope.shortestFlightList[0].fare.adultFare+$scope.shortestFlightList[0].fare.adultTax+$scope.shortestFlightList[0].fare.adultMarkup;	
		  // $scope.alternateFlightList = $filter('orderBy')($scope.flightsResponse.flightResult,'alternate');
		   if($scope.flightsAlterResponse.length > 1){
		   $scope.alternateFlightFare=$scope.flightsAlterResponse[0].fare.adultFare+$scope.flightsAlterResponse[0].fare.adultTax+$scope.flightsAlterResponse[0].fare.adultMarkup;	
		}
		   },500);
		   
			
   $scope.stopsList = [{"count":$scope.nonstopcount,"fare":$scope.nonstopfare,"name":"Direct","value":0},{"count":$scope.onestopcount,"fare":$scope.onestopfare,"name":"1 Stop","value":1},{"count":$scope.twostopcount,"fare":$scope.twostopfare,"name":"2 Stop","value":2}];

   $("#price-slider").slider({
               range:true,
               min: $scope.minFare,
               max: $scope.maxFare,
               values: [$scope.sliderMinFare, $scope.sliderMaxFare],
               slide: function( event, ui ) {
                 // $("#price-range").html( "Price: $" + Math.floor(ui.values[0]) + "-$" + Math.ceil(ui.values[1]));
				$("#price-range").html( "Price: "+$scope.currencySymbol + Math.floor(ui.values[0]*$scope.currencyValue) + "-"+$scope.currencySymbol + Math.ceil(ui.values[1]*$scope.currencyValue));
					$scope.$apply(function() {
                        $scope.sliderMinFare = ui.values[0];
						$scope.sliderMaxFare = ui.values[1];

                    });
               }
            });
//$("#price-range").html( "Price: $" + Math.floor($scope.sliderMinFare) + "-$" + Math.ceil($scope.sliderMaxFare));
$("#price-range").html( "Price: "+$scope.currencySymbol + Math.floor($scope.sliderMinFare*$scope.currencyValue) + "-$" + Math.ceil($scope.sliderMaxFare*$scope.currencyValue));

$("#depart-slider").slider({
               range:true,
               min: $scope.minDpt,
               max: $scope.maxDpt,
               values: [$scope.sliderMinDpt, $scope.sliderMaxDpt],
               slide: function( event, ui ) {
                  $("#depart-time").html( "Depart: " + $scope.intToTimeConvert(ui.values[0]) + "-" + $scope.intToTimeConvert(ui.values[1]));

					$scope.$apply(function() {
                        $scope.sliderMinDpt = ui.values[0];
						$scope.sliderMaxDpt = ui.values[1];

                    });
               }
            });
$("#depart-time").html( "Depart: " + $scope.intToTimeConvert($scope.sliderMinDpt) + "-" + $scope.intToTimeConvert($scope.sliderMaxDpt));

$("#return-slider").slider({
               range:true,
               min: $scope.minRet,
               max: $scope.maxRet,
               values: [$scope.sliderMinRet, $scope.sliderMaxRet],
               slide: function( event, ui ) {
                  $("#return-time").html( "Depart: " + $scope.intToTimeConvert(ui.values[0]) + "-" + $scope.intToTimeConvert(ui.values[1]));

					$scope.$apply(function() {
                        $scope.sliderMinRet = ui.values[0];
						$scope.sliderMaxRet = ui.values[1];

                    });
               }
            });
$("#return-time").html( "Depart: " + $scope.intToTimeConvert($scope.sliderMinRet) + "-" + $scope.intToTimeConvert($scope.sliderMaxRet));
 
 $scope.loading = false;
 $scope.resultLoader = false;
 $(".placeholder-item").removeClass("placeholder-item");
 $('.get-fare-alert button').click(function(){
    $('.fare-alert-signup').show();
});
 
}


})

$scope.intToTimeConvert = function(value){
	var time  = value.toString();
	if(time.length < 4){
	var hours = time.substr(0,1);
	var mins = time.substr(1,time.length);
	return hours+":"+mins+" AM"
	}
	else{
	var hours = time.substr(0,2);
	var mins = time.substr(2,time.length);
	var ampm = " AM";
		if(parseInt(hours) > 12){
		ampm = " PM";	
		}
	return hours+":"+mins+ampm
	}
}

$scope.currencySave = function(){
	
	var country = $("#_countryselect").val();
	  openCurrencyPopup('hide');
	 // alert(country);
  $.get("/getCurrencyResponse/"+country, function(data, status){
   
	var currRes = JSON.parse(data);
	$scope.$apply(function() {
	if(country.toLowerCase() == 'ca'){
				$scope.currencySymbol = "CAD";
				$scope.currencyValue = currRes.response[0].usd_cad;
			}
			if(country.toLowerCase() == 'mx'){
				$scope.currencySymbol = "MXN";
				$scope.currencyValue = currRes.response[0].usd_mxn;
			}
			if(country.toLowerCase() == 'gb'){
				$scope.currencySymbol = "£";
				$scope.currencyValue = currRes.response[0].usd_gbp;
			}
			if(country.toLowerCase() == 'usa'){
				$scope.currencySymbol = "$";
				$scope.currencyValue = 1;
			}
			$("#price-range").html( "Price: "+$scope.currencySymbol + Math.floor($scope.sliderMinFare*$scope.currencyValue) + "-$" + Math.ceil($scope.sliderMaxFare*$scope.currencyValue));
	})
  });
  
}
   
$scope.priceRange = function(flights){

return (flights.fare.adultFare+flights.fare.adultTax+flights.fare.adultMarkup) >= $scope.sliderMinFare && (flights.fare.adultFare+flights.fare.adultTax+flights.fare.adultMarkup) <= $scope.sliderMaxFare;
}

$scope.dptTimeRange = function(flights){
return parseInt(flights.depart) >= $scope.sliderMinDpt && parseInt(flights.depart) <= $scope.sliderMaxDpt;
}
$scope.retTimeRange = function(flights){
if($scope.tripType == 2)	
return parseInt(flights.returns) >= $scope.sliderMinRet && parseInt(flights.returns) <= $scope.sliderMaxRet;
else
return flights;	
}

$scope.onclickAirline = function(code){
var index = $scope.selectedAirlines.indexOf(code);
console.log($scope.selectedAirlines, code, index)
if(index == -1){
$scope.selectedAirlines.push(code);
}
else{
$scope.selectedAirlines.splice(index, 1);
}

}
$scope.stopsFilter = function(flights){
//console.log(flights.stops);
return $scope.selectedStops[flights.stops] || noFilter($scope.selectedStops);
}
$scope.airlinesFilter = function(flights){
if($scope.selectedAirlines.length > 0){
var matched = false;
angular.forEach($scope.selectedAirlines, function(airline){
if(airline.length == 2 && airline == flights.outBound[0].airline){
matched = true;
//return flights;
}
else if(flights.outBound[0].airline.length > 2 && airline == 'XXX'){
matched = true;
//return flights;
}
})
if(matched)
return flights;
}
else{
return flights;
}
}
$scope.departAirportFilter = function(flights){

return $scope.selectedDepartAirports[flights.outBound[0].fromAirport] || noFilter($scope.selectedDepartAirports);
}
$scope.returnAirportFilter = function(flights){
if(flights.inBound !== undefined){
return $scope.selectedReturnAirports[flights.inBound[0].fromAirport] || noFilter($scope.selectedReturnAirports);
}
else{
return noFilter($scope.selectedReturnAirports);
}
}
$scope.depLayFilter = function(flights){
		if($scope.selDepLayAirports.length > 0){
			var matched = false;
			angular.forEach($scope.selDepLayAirports,function(airport){
				
					if(flights.depLayovers.indexOf(airport) > 0 && flights.outBound.length > 1){
						
						matched = true;
					}
					
				
				
			});
			if(matched)
			return flights;
		}
		else{
			return flights;
		}
	}
	
	$scope.retLayFilter = function(flights){
		if($scope.selRetLayAirports.length > 0){
			var matched = false;
			angular.forEach($scope.selRetLayAirports,function(airport){
				
					if(flights.retLayovers.indexOf(airport) > 0 && flights.inBound.length > 1){
						
						matched = true;
					}
			});
			if(matched)
			return flights;
		}
		else{
			return flights;
		}
	}
	
	$scope.matrixFilter = function(flights){
		if($scope.airlinem != 'all'){
		return flights.stops == $scope.stopm && flights.outBound[0].airline == $scope.airlinem && (flights.fare.adultFare+flights.fare.adultTax+flights.fare.adultMarkup) >= $scope.pricem;
		}
		else{
			return flights;
		}
	}
	$scope.matrixAirlineFilter = function(flights){
		if($scope.airlinematrix != 'all'){
		return flights.outBound[0].airline == $scope.airlinematrix ;
		}
		else{
			return flights;
		}
	}
	
	$scope.resetFilters = function(){
		$scope.stopm="all";
		$scope.airlinem="all";
		$scope.airlinematrix="all";
		$scope.pricem = 0; console.log($scope.selectedAirlines)
		$scope.selectedAirlines=[]; console.log($scope.selectedAirlines)

$scope.selectedStops=[];
$scope.selDepLayAirports = [];
$scope.selRetLayAirports = [];
$scope.selectedDepartAirports = [];
$scope.selectedReturnAirports = []; 
//$scope.selectedAirlines = [];
$scope.sliderMinFare = $scope.minFare;
$scope.sliderMaxFare = $scope.maxFare;
$scope.sliderMinDpt = $scope.minDpt;
$scope.sliderMaxDpt = $scope.maxDpt;
$scope.sliderMinRet = $scope.minRet;
$scope.sliderMaxRet = $scope.maxRet;
$scope.clearPriceFilter();
$scope.clearAirlineFilter();
$scope.clearDepartLayoverAirport();
$scope.clearReturnLayoverAirport();

console.log("slider min fare: ", Math.floor($scope.sliderMinFare))
console.log("slider max fare: ", Math.ceil($scope.sliderMaxFare))
console.log("Min Fare: ",$scope.minFare)
console.log("Max Fare: ",$scope.maxFare)
$("#price-slider > div, #depart-slider > div, #return-slider > div").css({"width":"100%","left":"0%"});
$("#price-slider > a:nth-child(4), #depart-slider > a:nth-child(4), #return-slider > a:nth-child(4)").css({"left":"0%"});
$("#price-slider > a:nth-child(5), #depart-slider > a:nth-child(5), #return-slider > a:nth-child(5)").css({"left":"100%"});
var sliderPrice = localStorage.getItem('sliderPrice');
console.log("Price Slider value: ", sliderPrice)
// let lVal = Math.floor($scope.sliderMinFare);
// let rVal = Math.ceil($scope.sliderMaxFare);
// $( "#price-slider" ).slider( {
// 	values: [ lVal, rVal ]
// } );


// let lVal = a[0].trim().substr(1);
// let rVal = a[1].trim().substr(1);
// $( "#price-slider" ).slider( {
// 	values: [ lVal, rVal ]
// } );
// $("#price-range").text(sliderPrice);

// var sliderDepartTime = localStorage.getItem('sliderDepartTime');
// $("#depart-time").text(sliderDepartTime);

// var sliderReturnTime = localStorage.getItem('sliderReturnTime');
// $("#return-time").text(sliderReturnTime);

	}
	
	$scope.clearPriceFilter=function(){
		$("#price-range").html( "Price: $" + Math.floor($scope.sliderMinFare) + "-$" + Math.ceil($scope.sliderMaxFare));
		var $slider = $("#slider-range");
 		 $slider.slider("values", 0, 50);
  		$slider.slider("values", 1, 150);		  
		
	}
	$scope.clearAirlineFilter=function(){
		$('#airline input[type=checkbox]').each(function () {
		    this.checked = false;
		});
	}
	$scope.clearDepartLayoverAirport=function(){
		$('#departLayoverAirport input[type=checkbox]').each(function () {
		    this.checked = false;
		});
	}
	$scope.clearReturnLayoverAirport=function(){
		$('#returnLayoverAirport input[type=checkbox]').each(function () {
		    this.checked = false;
		});
	}

	$scope.onClickDepLayover = function(airport){
		var index = $scope.selDepLayAirports.indexOf(airport);
		if(index == -1){
			$scope.selDepLayAirports.push(airport);
		}
		else{
			$scope.selDepLayAirports.splice(index, 1);
		}
		
	}
	$scope.onClickRetLayover = function(airport){
		var index = $scope.selRetLayAirports.indexOf(airport);
		if(index == -1){
			$scope.selRetLayAirports.push(airport);
		}
		else{
			$scope.selRetLayAirports.splice(index, 1);
		}
		
	}
	
	$scope.filterMatrixClick = function(airline,price,stop){
		
		$scope.airlinematrix="all";
		$scope.stopm=stop;
		$scope.airlinem=airline;
		$scope.pricem = price;
	}
	
	$scope.filterMatrixAirlineClick = function(airline){
		$scope.airlinem="all";
		
       $scope.airlinematrix=airline;
	}
	 $scope.switchSort = function(key) {
		 if(key=='alternate'){
			 $scope.flightsResponse['flightResult']=($scope.flightsAlterResponse);
		 }else{
			 $scope.flightsResponse['flightResult']=($scope.flightsMainResponse);
		 }
            	    $scope.sortKey = key;   //set the sortKey to the param passed
                    $scope.reverse = !$scope.reverse; //if true make it false and vice versa
            	    
	}
	
$scope.getAirportName = function(code){
var airportName = code;
angular.forEach($scope.airports,function(airport){
if(airport.airportCode == code){
airportName =  airport.airportName;
}
})

return airportName;
}

$scope.getCityName = function(code){
var cityName = code;
angular.forEach($scope.airports,function(airport){
if(airport.airportCode == code){
cityName =  airport.cityName;
}
})

return cityName;
}

$scope.getAirlineName = function(code){

var airlineName = code;
if(code.length == 2){
angular.forEach($scope.airlines,function(airline){
if(airline.code == code){
airlineName =  airline.name;
}
})
}
else{
airlineName = "Multiple Airlines";
}
return airlineName;
}
$scope.getgdsName = function(id){
 if(id==1){
return "20YJ";
}
else if(id==2){
return "1QWH";
}
return "20YJ";
}

$scope.getCabinName = function(id){
var cabin = "Economy";
if(id==1){
cabin = "Economy";
}
else if(id==2){
cabin = "PremiumEconomy";
}
else if(id==3){
cabin = "Business";
}
else if(id==4){
cabin = "First";
}
else{
cabin = "Mixed";
}
return cabin;
}

$scope.dayDiff = function(input1,input2){
var date2 = new Date(input2);
 var date1 = new Date(input1);
 var timeDiff = Math.abs(date2.getTime() - date1.getTime());
 $scope.dayDifference = Math.ceil(timeDiff / (1000 * 3600 * 24));
 return $scope.dayDifference;
}

$scope.LoadMore = function(){
$scope.numberOfResult = $scope.numberOfResult+5;
}

$scope.showFlightDetails = function(index){
$("#flightdetailexpandcollaps_"+index+"").slideToggle();

}

$scope.checkout = function(resultId){
var searchId = $("#searchId").val();
$window.location.href = "/basket-purchase/"+searchId+"/"+resultId;
}

$scope.sortFlights = function(){
$scope.reverse = !$scope.reverse;
}
$scope.compareDepartDates = function(date){
	if($scope.departDate == date){
		return false;
	}
	else{
		return true;
	}
}
$scope.compareReturnDates = function(date){
	if($scope.returnDate == date){
		return false;
	}
	else{
		return true;
	}
}
$scope.OpenbaggageFees = function (bagairline) {

              $window.open("/baggage-info?airlines="+bagairline, "popup", "width=900,height=600,left=10,top=150");
          }
 
 $scope.paymentPage = function(resultId){
	 //window.location.href = "/flight/payment/"+$scope.searchID+"/"+resultId;
	window.location.href = "/payment/flight_info/"+$scope.searchID+"/"+resultId;

 }
function noFilter(filterObj) {
       for (var key in filterObj) {
     
           if (filterObj[key]) {
               return false;
           }
       }
       return true;
   }
   var matrixshow = 6;
   var matrixhide = 0;
   if($scope.matrix.length > 6){
	   $("#slideLeft").prop("disabled",true).css("background-color", "grey");
	   $("#slideRight").prop("disabled",true).css("background-color", "grey");
   }
   

$scope.matrixLeftClick = function(){
	$("#slideRight").prop("disabled",false).css("background-color", "#ff4500");
	var matrixLength = $scope.matrix.length;
	if(matrixshow > 6){
		matrixshow = matrixshow-1;
		matrixhide = matrixhide-1;
		$("#matrixdiv"+matrixhide).show();
		$("#matrixdiv"+matrixshow).hide();
		
	}
	else{
		$("#slideLeft").prop("disabled",true).css("background-color", "grey");
	}
}

$scope.matrixRightClick = function(){
	$("#slideLeft").prop("disabled",false).css("background-color", "#ff4500");
	var matrixLength = $scope.matrix.length;
	if(matrixLength > matrixshow){
		$("#matrixdiv"+matrixhide).hide();
		$("#matrixdiv"+matrixshow).show();
		matrixshow = matrixshow+1;
		matrixhide = matrixhide+1;
	}
	else{
		$("#slideRight").prop("disabled",true).css("background-color", "grey");
	}
}

try{
var searchString = $("#searchString").val();
if(localStorage.getItem("searchStringArrAng") != null){
		$scope.searchList = JSON.parse(localStorage.getItem("searchStringArrAng"));
		
		if($scope.searchList.length==3){
			$scope.searchList.splice(0, 1);
		}
		var searchId = JSON.parse(JSON.parse(JSON.stringify(searchString)));
		//alert(searchId.searchForm)
		//alert($scope.searchList.indexOf(searchId.searchForm))
		if($scope.searchList.indexOf(searchId.searchForm) == -1){
		$scope.searchList.push(JSON.stringify(searchString));
		localStorage.setItem("searchStringArrAng", JSON.stringify($scope.searchList));
		}
	}
	else{
		$scope.searchList.push(JSON.stringify(searchString));
	localStorage.setItem("searchStringArrAng", JSON.stringify($scope.searchList));
	}
}
catch(err) {
  
}
})

FlightApp.filter('decimalValue', ['$filter',
  function($filter) {
    return function(input) {
      var fare = input.toFixed(2).toString();
 return fare.split(".")[1];
    }
  }
]);

FlightApp.filter('minToHour', ['$filter',
  function($filter) {
    return function(input) {

      var inp = new Date(0, 0, 0, 0, input, 0); // assumes minutes as an input
      var m = inp.getMinutes();
      var h = inp.getHours();
      var d = inp.getDay();
h = h+(d*24);
      return h + 'h ' + m + 'm ';
    }
  }
]);
$(document).ready(function(){
	travelercount();
var departDate = $("#departDate").val();
var returnDate = $("#returnDate").val();
//$("#btnDepartDate").html($.datepicker.formatDate( "dd M, yy", new Date(departDate)));
//$("#btnReturnDate").html($.datepicker.formatDate( "dd M, yy", new Date(returnDate)));

 var adult = $("#adult").val();
var child = $("#child").val();
var infant = $("#infant").val();
var totPax = Number(adult)+Number(child)+Number(infant);
$("#spnTraveler").html(totPax+" Traveler");
if($("#tripType").val() == 1){
	$("#returnDate").hide();
	$("#departDate").width("30%");
	$("#oneway").prop( "checked", true );
	tripselector();multicity1();
}
})


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
  
function pexpand()
{
    var expanditem=document.getElementsByClassName('indicators')[0];
    if (expanditem.style.transform=='scaleY(0)')
    {
        expanditem.style.transform='scaleY(1)';
    }
    else
    {
        expanditem.style.transform='scaleY(0)';
    }
    
}
function passengercount(){
	var adult = $("#adult").val();
	  var child = $("#child").val();
	  var infant = $("#infant").val();
	  var infantWs = $("#infantWs").val();
	  var traveller = Number(adult)+Number(child)+Number(infant)+Number(infantWs);
	  if(traveller == 1)
		$("#pcount").val(traveller+" Adult");
	  else
		 $("#pcount").val(traveller+" Traveller"); 
	  
}


$( document ).ready(function() {
    passengercount();
	$(".filter-head").click(function(){
		$(this).next().slideToggle();
	})
	
	if($("#currencySymbol").val() == 'GBP' || $("#currencySymbol").val() == '£'){
		$("#_countryselect").val("gb");
		$("#_currencyselect").val("GBP");
	}
	else if($("#currencySymbol").val() == 'MXN'){
		$("#_countryselect").val("mx");
		$("#_currencyselect").val("MEX");
	}
	else if($("#currencySymbol").val() == 'CAD'){
		$("#_countryselect").val("ca");
		$("#_currencyselect").val("CAD");
	}
});

$('.flight-detail-show').click(function(){
    $(this).parent().next().toggle();
    $(this).children().toggleClass('rotate');
    $(this).children().toggleClass('rotate-reset');
});
$('.get-fare-alert button').click(function(){
    $('.fare-alert-signup').show();
});
$('.alert-close i').click(function(){
    $('.fare-alert-signup').hide();
});
$('.auto-alert-close i').click(function(){
    $('.alert-screen-overlay').hide();
});
setTimeout(function(){
    $('.alert-screen-overlay').css("display","flex");
},25000);

function farealertpost(email){
	var data = {
									depCity: $("#origin").val(),
									arrCity: $("#destination").val(),
									depDate: $("#departDate").val(),
									retDate: $("#returnDate").val(),
									currencyType: 'USD',
									totalAmount: $("#minFarePrice").val(),
									quoteAmount: $("#minFarePrice").val(),
									emailId: email,
									phoneNum:''
								}
							$.ajax({
								url: '/farealert/submit',
								type: 'post',
								contentType: 'application/json; charset=utf-8',
								data: JSON.stringify(data),
								dataType: "html",
								success: function(response) {
									
								}
							});
}
	
function farealertsubmit(){
	var fareAlertEmail = $("#fareAlertEmail").val();
	var test = ValidateEmail(fareAlertEmail);
	if(test){
		farealertpost(fareAlertEmail);
		$("#emailMsg").text("You Have Registered Susccessfully!").css("color","green");
		setTimeout(function(){
		$('.fare-alert-signup').hide();
		},5000);
	}
	else{
		$("#emailMsg").text("Please Enter Valid Email").css("color","red");
	}
}
function popalertsubmit(){
	var popupEmail = $("#popupEmail").val();
	var test = ValidateEmail(popupEmail);
	if(test){
		farealertpost(popupEmail);
		$("#emailPopMsg").text("You Have Registered Susccessfully!").css("color","green");
		setTimeout(function(){
		$('.alert-screen-overlay').hide();
		},5000);
	}
	else{
		$("#emailPopMsg").text("Please Enter Valid Email").css("color","red");
	}
}

