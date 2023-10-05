var FlightApp = angular.module("FlightApp",['infinite-scroll']);



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

FlightApp.factory("flightFactory",function($http){
return{
getFlightResult:function(searchId,resultId){
return $http({
url : "/getLiveFlightResponse/"+searchId+"/"+resultId,
method : "GET",
headers : {
'Content-Type' : '*'
}
})
}
}

})

FlightApp.factory("flightLikeFactory",function($http){
return{
	likeCustomerLink:function(searchId,resultId,startId,comment){
return $http({
url : "/flight/livelink/"+searchId+"/"+resultId+"/"+startId+"/"+comment,
method : "GET",
headers : {
'Content-Type' : '*'
}
})
}
}

})
FlightApp.controller("FlightCntrl",function($scope,$http,$window,$timeout,flightFactory,flightLikeFactory,$filter,$interval){

$scope.flightsResponse  = [];
$scope.flightsResponseold  = [];
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

$scope.pageAirline = $("#pageAirline").val();
$scope.airlineSortList = [];
$scope.otherSortList = [];
$scope.loading = true;
$scope.resultLoader = true;
$scope.matrix = [];
$scope.stopm="all";
$scope.airlinem="all";
$scope.pricem = 0;
$scope.sortKey="";
$scope.resultAdd = 0;
$scope.consId=0;
$scope.callAtTimeout = function() {
   // console.log("$scope.callAtTimeout - Timeout occurred");
  $scope.liveSearchId=  $("#liveSearchId").val();
   $scope.liveResultId= $("#liveResultId").val();
    var flightResult  = flightFactory.getFlightResult($scope.liveSearchId,$scope.liveResultId);
    flightResult.then(function(response){
    $scope.newExist=false;
    
    console.log(response.data)
    $scope.consId=0;
   //  console.log(JSON.stringify({data: response.data}));
    angular.forEach(response.data.liveflightResult, function(matrix,index){
    	//console.log("matrix.resultID:"+matrix)
    	
    	 angular.forEach($scope.flightsResponseold.liveflightResult, function(matrixs,indexs){
    	if(matrix.resultID == matrixs.resultID){
    	if(matrix.consId != matrixs.consId){
    		$scope.consId=1;
    	}
    	if(matrix.booking_token != matrixs.booking_token){
    		$scope.consId=1;
    	}
    	}
    	  })
    })
    
    if(response.data.liveflightResult.length != $scope.resultAdd){
    	$scope.resultAdd =response.data.liveflightResult.length;
    	 $scope.newExist=true;
    }
    console.log("is new data:"+$scope.newExist)
    if($scope.newExist){
    $scope.flightsResponse  = response.data;
    $scope.flightsResponseold=response.data;
    }
    console.log("is new refresh:"+$scope.refresh)
    if($scope.refresh == "1"){
    	$scope.refresh="0";
    	$scope.flightsResponse  = response.data;
    	 $scope.flightsResponseold=response.data;
    }
    if($scope.consId==1){
    	$scope.refresh="0";
    	$scope.flightsResponse  = response.data;
    	 $scope.flightsResponseold=response.data;
    }
    //console.log("$scope.callAtTimeout - Timeout occurred"+$scope.flightsResponse);
    });
}

$interval( function(){ $scope.callAtTimeout(); }, 2000);
$scope.flightsResponse = JSON.parse($("#liveflightsResult").val());
/*
angular.forEach($scope.flightsResponse.liveflightResult, function(matrix,index){
	$scope.resultAdd.push(matrix.resultID);
})*/

//console.log($scope.flightsResponse);
$scope.likeLink = function(resultId,cmt){
	 $scope.liveSearchId= document.getElementById('liveSearchId').value;
	 $scope.liveResultId= document.getElementById('liveResultId').value;
	 $scope.commt= "x";
	 if(cmt=="y"){
		 $scope.commt= document.getElementById('cmt-'+resultId).value;
	 }
	 flightLikeFactory.likeCustomerLink($scope.liveSearchId,$scope.liveResultId,resultId,$scope.commt);
	 $scope.refresh="1";
}
$scope.searchID = $scope.flightsResponse.SearchID;
$scope.refresh="0";
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
	 window.location.href = "/flight/live/payment/"+$scope.searchID+"/"+resultId;
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


