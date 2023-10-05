function showsidenav()
{
    var a=document.getElementById('sidenavbar');
    var b=document.getElementById('screenoverlay');
    a.style.width='90%';
    b.style.display="block";
}
function hidesidenav()
{
    var a=document.getElementById('sidenavbar');
    var b=document.getElementById('screenoverlay');
    a.style.width='0';
    b.style.display="none";
}
var mq1=window.matchMedia("(max-width:1025px)");
var mq2=window.matchMedia("(max-width:768px)");
var mq3=window.matchMedia("(max-width:585px)");
function tripselector()
{
    var pageUrl = $(location).attr('href'); console.log(pageUrl)
    if(document.getElementById('oneway').checked==true)
    {
        document.getElementsByClassName('date')[1].style.display="block";
        //if(pageUrl == 'https://www.ebooktrip.com/'){
            $(".defaultcity .origra.date").addClass('disabled');
        //}else{
            $("#returnDate").addClass('disabled');
        //}
        document.getElementsByClassName('date')[0].style.width="17%";
        document.getElementsByClassName('search')[0].style.width="48%";
        document.getElementsByClassName('search')[1].style.width="48%";
        document.getElementById('swap').style.left="41%";
        //document.getElementById('swap').style.display="block";
        if(mq1.matches)
        {
            // document.getElementsByClassName('date')[0].style.width="24%";
            document.getElementsByClassName('search')[0].style.width="36.5%";
            document.getElementsByClassName('search')[1].style.width="36.5%";
            document.getElementById('swap').style.left="36.5%";
        }
        if(mq2.matches)
        {
            // document.getElementsByClassName('date')[0].style.width="29%";
            document.getElementsByClassName('search')[0].style.width="34%";
            document.getElementsByClassName('search')[1].style.width="34%";
            document.getElementById('swap').style.left="34%";  
        }
        if(mq3.matches)
        {
            // document.getElementsByClassName('date')[0].style.width="99%";
            document.getElementsByClassName('search')[0].style.width="99%";
            document.getElementsByClassName('search')[1].style.width="99%";
            document.getElementById('swap').style.left="49%"; 
        }
		$("#tripType").val(1);
    }
    else if(document.getElementById('multicity').checked==true)
    {
        document.getElementsByClassName('date')[1].style.display="none";
        document.getElementsByClassName('date')[0].style.width="27%";
        document.getElementsByClassName('search')[0].style.width="34%";
        document.getElementsByClassName('search')[1].style.width="34%";
        document.getElementById('swap').style.left="34%";
        //document.getElementById('swap').style.display="none";
        if(mq1.matches)
        {
            document.getElementsByClassName('date')[0].style.width="27%";
            document.getElementsByClassName('search')[0].style.width="34%";
            document.getElementsByClassName('search')[1].style.width="34%";
            document.getElementById('swap').style.left="34%";
        }
        if(mq2.matches)
        {
            document.getElementsByClassName('date')[0].style.width="27%";
            document.getElementsByClassName('search')[0].style.width="34%";
            document.getElementsByClassName('search')[1].style.width="34%";
            document.getElementById('swap').style.left="34%";  
        }
        if(mq3.matches)
        {
            document.getElementsByClassName('date')[0].style.width="99%";
            document.getElementsByClassName('search')[0].style.width="99%";
            document.getElementsByClassName('search')[1].style.width="99%";
            document.getElementById('swap').style.left="34%"; 
        }
		$("#tripType").val(3);
    }
    else
    {
        document.getElementsByClassName('date')[1].style.display="block";
        //if(pageUrl == 'https://www.ebooktrip.com/'){
            $(".defaultcity .origra.date").removeClass('disabled');
        //}else{
            $("#returnDate").removeClass('disabled');
        //}
        document.getElementsByClassName('date')[0].style.width="17%";
        document.getElementsByClassName('search')[0].style.width="48%";
        document.getElementsByClassName('search')[1].style.width="48%";
        document.getElementById('swap').style.left="41%";
        document.getElementById('swap').style.display="block";
        if(mq1.matches)
        {
            //document.getElementsByClassName('date')[0].style.width="17%";
            document.getElementsByClassName('search')[0].style.width="31%";
            document.getElementsByClassName('search')[1].style.width="31%";
            document.getElementById('swap').style.left="31%";
        }
        if(mq2.matches)
        {
            //document.getElementsByClassName('date')[0].style.width="49%";
            document.getElementsByClassName('search')[0].style.width="49%";
            document.getElementsByClassName('search')[1].style.width="49%";
            document.getElementById('swap').style.left="49%";  
        }
        if(mq3.matches)
        {
            //document.getElementsByClassName('date')[0].style.width="49%";
            document.getElementsByClassName('search')[0].style.width="99%";
            document.getElementsByClassName('search')[1].style.width="99%";
            document.getElementById('swap').style.left="49%";
        }
		$("#tripType").val(2);
    }
}
mq1.addListener(tripselector);
mq2.addListener(tripselector);
mq3.addListener(tripselector);
function multicity1()
{
    if(document.getElementById('oneway').checked==true)
    {
        document.getElementsByClassName('multicity')[0].style.display="none";
        document.getElementsByClassName('multicity')[1].style.display="none";
        document.getElementsByClassName('multicity')[2].style.display="none";
        document.getElementsByClassName('multicity')[3].style.display="none";
        document.getElementsByClassName('multicity')[4].style.display="none";
        document.getElementsByClassName('multibuttons')[0].style.display="none";
        document.getElementsByClassName('flightno')[0].style.display="none";
    }
    else if(document.getElementById('multicity').checked==true)
    {
        document.getElementsByClassName('multicity')[0].style.display="block";
        document.getElementsByClassName('multicity')[1].style.display="block";
        document.getElementsByClassName('multibuttons')[0].style.display="flex";
        document.getElementById('addflight').style.visibility="visible";
        document.getElementsByClassName('flightno')[0].style.display="flex";
    }
    else
    {
        document.getElementsByClassName('multicity')[0].style.display="none";
        document.getElementsByClassName('multicity')[1].style.display="none";
        document.getElementsByClassName('multicity')[2].style.display="none";
        document.getElementsByClassName('multicity')[3].style.display="none";
        document.getElementsByClassName('multicity')[4].style.display="none";
        document.getElementsByClassName('multibuttons')[0].style.display="none";
        document.getElementsByClassName('flightno')[0].style.display="none";
    }
}
function closeself()
{
    for(i=0;i<5;i++)
    {
        if(document.getElementsByClassName('multicity')[i].style.display=='block')
        {
            j=i;
        }
    }
    if(j==4)
    {
        document.getElementById('addflight').style.visibility="visible";
    }
    document.getElementsByClassName('multicity')[j].style.display="none";
}
function addflight1()
{
    for(i=0;i<5;i++)
    {
        if(document.getElementsByClassName('multicity')[i].style.display=='block')
        {
            j=i;
        }
    }
    if(j==3)
    {
        document.getElementById('addflight').style.visibility="hidden";
    }
    document.getElementsByClassName('multicity')[j+1].style.display="block";
}
function travelercoach()
{
    if(document.getElementById('tcd').style.visibility=='hidden')
    {
        document.getElementById('tcd').style.visibility='visible';
        document.getElementsByClassName('coach')[0].style.backgroundImage="url(/resources/images/rasets.png),url(/resources/images/up-arrows.png)";
    }
    else
    {
        document.getElementById('tcd').style.visibility='hidden';
        document.getElementsByClassName('coach')[0].style.backgroundImage="url(/resources/images/rasets.png),url(/resources/images/down-arrows.png)";
    }
}
function tchide()
{
    document.getElementById('tcd').style.visibility='hidden';
    document.getElementsByClassName('coach')[0].style.backgroundImage="url(/resources/images/rasets.png),url(/resources/images/down-arrowss.png)";
}


function wtravelercoach()
{
    if(document.getElementById('tcd').style.visibility=='hidden')
    {
        document.getElementById('tcd').style.visibility='visible';
        document.getElementsByClassName('coach')[0].style.backgroundImage="url(/resources/images/wseat.png),url(/resources/images/wup-arrow.png)";
    }
    else
    {
        document.getElementById('tcd').style.visibility='hidden';
        document.getElementsByClassName('coach')[0].style.backgroundImage="url(/resources/images/wseat.png),url(/resources/images/wdown-arrow.png)";
    }
}
function wtchide()
{
    document.getElementById('tcd').style.visibility='hidden';
    document.getElementsByClassName('coach')[0].style.backgroundImage="url(/resources/images/wseat.png),url(/resources/images/wdown-arrow.png)";
}
function travelercount()
{
    var ara=document.getElementsByClassName('pnumber');
    var count=0;
    for(i=0;i<ara.length;i++)
    {
        count=count+parseInt(ara[i].value);
    }
    var clas=document.getElementById('cabin').value;
    if(count==1)
    {
    document.getElementsByClassName('coach')[0].value=count+" Traveller ";
    }
    else
    {
        document.getElementsByClassName('coach')[0].value=count+" Traveller ";
    }
}
function tripairshow()
{
    document.getElementsByClassName('trip-selector')[0].style.display="flex";
    document.getElementsByClassName('airline-search')[0].style.display="flex";
}
function tripairhide()
{
    document.getElementsByClassName('trip-selector')[0].style.display="none";
    document.getElementsByClassName('airline-search')[0].style.display="none";
}
function engineshow()
{
    document.getElementsByClassName('fehead')[0].style.display="none";
    document.getElementsByClassName('flight-engine')[0].style.display="block";
    document.getElementById('screenoverlay2').style.display="block";
}
function enginehide()
{
    document.getElementsByClassName('fehead')[0].style.display="flex";
    document.getElementsByClassName('flight-engine')[0].style.display="none";
    document.getElementById('screenoverlay2').style.display="none";
}
function filterhide()
{
    var filter=document.getElementsByClassName('filter')[0];
    var fabtn=document.getElementsByClassName('fapply')[0];
    filter.style.height='0';
    fabtn.style.height='0';
}
function filtershow()
{
    var filter=document.getElementsByClassName('filter')[0];
    var fabtn=document.getElementsByClassName('fapply')[0];
    filter.style.height='100vh';
    fabtn.style.height='45px';
}
function ftype(t,n)
{
    var container=document.getElementsByClassName('filter-item');
    var type=document.getElementsByClassName('ftype');
    for(i=0;i<container.length;i++)
    {
        container[i].style.visibility='hidden';
    }
    for(j=0;j<type.length;j++)
    {
        type[j].setAttribute('class','ftype');
    }
    t.style.visibility='visible';
    type[parseInt(n)].setAttribute('class','ftype filtertypeactive')
}

function ValidateEmail(mail) 
{
 if (/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(mail))
  {
    return true;
  }
    return false;
}

function newsalertsubmit(){
	var newsEmail = $("#newsEmail").val();
	var test = ValidateEmail(newsEmail);
	if(test){  console.log('request sign up')
		var data = {emailId: newsEmail}
		$.ajax({
			url: '/newsletter/submit',
			type: 'post',
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify(data),
			dataType: "text",
			beforeSend: function() {
     			$(".loader").show().addClass('activeLoader');
     			//$("#sign_id").hide();
 			},
			success: function(response) { console.log('success sign up')
				
				//var newsRes = JSON.parse(response);
				//if(newsRes.baseResponse.status == 1)
				
				$(".loader").hide().removeClass('activeLoader');
				//$("#sign_id").show();
				
				if(response == 'true')
				$("#newsMsg").text("You Have Registered Susccessfully!").css("color", "green");
				else
				$("#newsMsg").text("Some Technical Issue Please try later!").css("color", "red");	
			}
		});
	}
	else{
		$("#newsMsg").text("Please Enter Valid Email").css("color","red");
	}
}
$('.fixed-call-bottom i').click(function(){
    $('.fixed-call-bottom').hide();
});

function dealclick(from,to,depart,retur){
	$("#departDate").val(depart);
	$("#returnDate").val(retur);
	$("#origin").val(from);
	$("#destination").val(to);
	$("#flightSearch").submit();
}
//////////////////////////// Datepicker Starts /////////////////////////////////////////
if($("#pageType").val() == 'engine'){
	var currentDate = new Date();
	
	$("#departDate").val(currentDate);
	$("#departDate").val($.datepicker.formatDate( "mm/dd/yy", currentDate));
	currentDate.setDate(currentDate.getDate()+7)
	
	$("#returnDate").val(currentDate);
	$("#returnDate").val($.datepicker.formatDate( "mm/dd/yy", currentDate));
}
var numberOfMonthValue = 2;
$(window).resize(function() {
    $(window).width() < 768 ? numberOfMonthValue = 12 : numberOfMonthValue = 2;
});
	$("#departDate").datepicker({
		minDate : new Date(),
		maxDate : "+11M",
		//numberOfMonths:2,
        numberOfMonths: numberOfMonthValue,
        beforeShow: function(){
            var xPos = $("#departDate").offset();
            setTimeout(function () {
                $('.ui-datepicker').css({'left': xPos.left, 'top': xPos.top + 67});
            }, 0);
        },
		onSelect : function(date,event){
			//console.log(date);
            $("#departDate").val($.datepicker.formatDate( "mm/dd/yy", new Date(date)));
            //console.log('Testing OneWay: ', $('#oneway').is(':checked'))
            //if(!$('#oneway').is(':checked')) {
            //if($("#tripType").val() == "2"){
                //console.log('OneWay: ', $('#oneway').is(':checked'))
                $("#returnDate").val($.datepicker.formatDate( "mm/dd/yy", new Date(date)));
                $("#returnDate").val(date);
            //}
		},
		onClose : function(date){
			if($("#tripType").val() == "2"){
			$('#returnDate').datepicker("option","minDate", new Date(date));
			$('#returnDate').datepicker('show');
			}
			if($("#tripType").val() == "3"){
			$('#departDate2').datepicker("option","minDate", new Date(date));
			//$('#returnDate').datepicker('show');
			}
		}
	});
	
	$("#returnDate").datepicker({
		minDate : new Date(),
		maxDate : "+11M",
		numberOfMonths:2,
        beforeShow: function(){
            var xPos = $("#departDate").offset();
            //if( $(window).width() > 767 ){
                setTimeout(function () {
                    $('.ui-datepicker').css({'left': xPos.left, 'top': xPos.top + 67});
                }, 0);
            //}
        },
		onSelect : function(date,event){
			
			$("#returnDate").val($.datepicker.formatDate( "mm/dd/yy", new Date(date)));
		}
	});
	
	$("#departDate2").datepicker({
        numberOfMonths: 2,
		minDate : new Date(),
		maxDate : "+11M",
		onSelect : function(date,event){
			
			$("#departDate2").val($.datepicker.formatDate( "mm/dd/yy", new Date(date)));
			$('#departDate3').datepicker("option","minDate", new Date(date));
		}
	});
	
	$("#departDate3").datepicker({
        numberOfMonths: 2,
		minDate : new Date(),
		maxDate : "+11M",
		onSelect : function(date,event){
			
			$("#departDate3").val($.datepicker.formatDate( "mm/dd/yy", new Date(date)));
			$('#departDate4').datepicker("option","minDate", new Date(date));
		}
	});
	
	$("#departDate4").datepicker({
        numberOfMonths: 2,
		minDate : new Date(),
		maxDate : "+11M",
		onSelect : function(date,event){
			
			$("#departDate4").val($.datepicker.formatDate( "mm/dd/yy", new Date(date)));
			$('#departDate5').datepicker("option","minDate", new Date(date));
		}
	});
	
	$("#departDate5").datepicker({
        numberOfMonths: 2,
		minDate : new Date(),
		maxDate : "+11M",
		onSelect : function(date,event){
			
			$("#departDate5").val($.datepicker.formatDate( "mm/dd/yy", new Date(date)));
			$('#departDate6').datepicker("option","minDate", new Date(date));
		}
	});
	
	$("#departDate6").datepicker({
        numberOfMonths: 2,
		minDate : new Date(),
		maxDate : "+11M",
		onSelect : function(date,event){
			
			$("#departDate6").val($.datepicker.formatDate( "mm/dd/yy", new Date(date)));
			
		}
	});
	
//////////////////////////// Datepicker Ends /////////////////////////////////////////


//////////////////////////// Autocomplete Starts /////////////////////////////////////////
$.ui.autocomplete.prototype._renderItem = function( ul, item){
          var term = this.term.split(' ').join('|');
          var re = new RegExp("(" + term + ")", "gi") ;
          var t = item.label.replace(re,"<strong>$1</strong>");
          return $( "<li></li>" )
             .data( "item.autocomplete", item )
             .append( "<a>" + t + "</a>" )
             .appendTo( ul );
        };
		
    var getData = function (request, response) {
        $.getJSON(
            "/getAirprotList/" + request.term,
            function (data) {
				response(data);
            });
    };
 
    var selectItem = function (event, ui) {
        $(this).val(ui.item.value);
		if(this.id == "origin"){
            var vv = ui.item.value.split("-"); 
            //console.log(vv);
            $("#txtFltOrigin").text(vv[0]);
            var cCode = vv[2];
            var n = vv[1]; console.log(n);
            var city = n.split(","); 
            //console.log(city);
            $("#FcityName").text(city[0]+', '+cCode);
            $("#txtFltOrigin, #OremEmpIcon").show();
			setTimeout(function() {
               $("#destination").focus();
            }, 100);
		
		}else if(this.id == "destination"){
            var vv = ui.item.value.split("-"); console.log(vv);
            $("#txtFltDestin").text(vv[0]);
            var cCode = vv[2];
            var n = vv[1]; console.log(n);
            var city = n.split(","); console.log(city);
            $("#RcityName").text(city[0]+', '+cCode);
            $("#txtFltDestin, #DremEmpIcon").show();
			setTimeout(function() {
              $('#departDate').datepicker('show');
            }, 100);
		}else{
			setTimeout(function() {
              $(this).next().focus();
            }, 100);
            return false;
        }
    }
	
    $("#origin").autocomplete({
		source: getData,
        select: selectItem,
        minLength: 3,
		autoFocus: true
		
    });
	
	$("#destination").autocomplete({
		source: getData,
        select: selectItem,
        minLength: 3,
		autoFocus: true
		
    });
	
	$(".msearch").autocomplete({
		source: getData,
        select: selectItem,
        minLength: 3,
		autoFocus: true
		
    });
	 
	$("#swap").click(function(){
	var origin = 	$("#origin").val();
	var destination = 	$("#destination").val();
    var OcityCode = $("#txtFltOrigin").text();
    var OcityCountry = $("#FcityName").text();
    var DcityCode = $("#txtFltDestin").text();
    var DcityCountry = $("#RcityName").text();
    $("#txtFltOrigin").text(DcityCode);
    $("#FcityName").text(DcityCountry);
    $("#txtFltDestin").text(OcityCode);
    $("#RcityName").text(OcityCountry);
	$("#origin").val(destination);
	$("#destination").val(origin);
	}) 
//////////////////////////// Autocomplete Ends /////////////////////////////////////////


//////////////////////////// Traveler Starts /////////////////////////////////////////
	
	 	
	$(".paxPlus").click(function(){
		var pax = $(this).data("pax");
		var adult = $("#adult").val();
	  var child = $("#child").val();
	  var infant = $("#infant").val();
	  var infantWs = $("#infantWs").val();
	  var traveller = Number(adult)+Number(child)+Number(infant)+Number(infantWs);
		
		if(pax == 'adult'){
			  if(traveller < 9){
			  adult = Number(adult)+1;
			  $("#adult").val(adult);
			  
			  }
		  }
		  else if(pax == 'child'){
			  if(traveller < 9){
			  child = Number(child)+1;
			  $("#child").val(child);
			 
			  }
		  }
		  else if(pax == 'infant'){
			  if(traveller < 9 && adult > infant){
			  infant = Number(infant)+1;
			  $("#infant").val(infant);
			 
			  }
		  }
		  else if(pax == 'infantws'){
			  if(traveller < 9 && adult > infantWs){
			  infantWs = Number(infantWs)+1;
			  $("#infantWs").val(infantWs);
			  
			  }
		  }
		   traveller = Number(adult)+Number(child)+Number(infant)+Number(infantWs);
		var cabinClass = $("#cabin").val();
	  if(traveller > 1){$(".coach").val(traveller+" Travellers, "+cabinClass);}
	  else{$(".coach").val(traveller+" Adult, "+cabinClass);}  
	  
	})
	
	$(".paxMinus").click(function(){
		var pax = $(this).data("pax");
		var adult = $("#adult").val();
	  var child = $("#child").val();
	  var infant = $("#infant").val();
	  var infantWs = $("#infantWs").val();
	  var traveller = Number(adult)+Number(child)+Number(infant)+Number(infantWs);
		
		if(pax == 'adult'){
			  if(adult > 1){
			  adult = Number(adult)-1;
			  $("#adult").val(adult);
			 
			  if(infant > adult){
				  infant = adult;
				  $("#infant").val(infant);
				  
			  }
			  if(infantWs > adult){
				  infantWs = adult;
				  $("#infantWs").val(infantWs);
				 
			  }
			  }
		  }
		  else if(pax == 'child'){
			  if(child > 0){
			  child = Number(child)-1;
			  $("#child").val(child);
			
			  }
		  }
		  else if(pax == 'infant'){
			  if(infant > 0){
			  infant = Number(infant)-1;
			  $("#infant").val(infant);
			  
			  }
		  }
		  else if(pax == 'infantws'){
			  if(infantWs > 0){
			  infantWs = Number(infantWs)-1;
			  $("#infantWs").val(infantWs);
			  
			  }
		  }
		  
		 traveller = Number(adult)+Number(child)+Number(infant)+Number(infantWs);
		var cabinClass = $("#cabin").val();
	  if(traveller > 1){$(".coach").val(traveller+" Travellers, "+cabinClass);}
	  else{$(".coach").val(traveller+" Adult, "+cabinClass);}  
	  
	})
	
	

//////////////////////////// Traveler Ends /////////////////////////////////////////


//////////////////////////// Form Validation Starts /////////////////////////////////////////
	 
	 var formData = $("#flightSearch").serialize();
	function randomString() {
		for (var t = "", e = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789", n = 0; n < 15; n++) t += e.charAt(Math.floor(Math.random() * e.length));
		return t
	}
var randomStr = randomString();

$.validator.messages.required = '';

	 $("#flightSearch").validate({
		 rules:{
			 origin : {
				 required : true
			 },
			 destination : {
				 required : true
			 },
			 departDate: {
			  required: true,
			 },
			 returnDate: {
			  required: true,
			 }
		 },
		  errorPlacement: function(error, element) {   },
		   submitHandler: function(form) {
			   
			   
			 if($("#origin").val() == $("#destination").val()){
				 alert("From airport & To airport must be different.");
				 return false;
				 
			 }
			
			 
			 if(formData == $("#flightSearch").serialize()){
				 $(".sameSearch").show();
			 }
			else{	 
				form.action='/flight-listing/'+randomStr;
				form.submit();
			 }
		  }
	 })
	 
	 $("#flightSearch").on('submit',function(event){
		 $('.msearch').each(function() {
				$(this).rules("add", 
				{
                required: true
                });
				
			});
			$("#flightSearch").validate();
	 
	 })
		 
//////////////////////////// Form Validation Ends /////////////////////////////////////////
$("#mysea").click(function(){
          $(".searches").show();
          $("#mysea").addClass("sactive");
	});
	var mouse_is_inside = false;

	$(document).ready(function()
	{
    	   $('.searches').hover(function(){ 
               mouse_is_inside=true; 
    	     }, function(){ 
               mouse_is_inside=false; 
    	       });

    	   $("body").mouseup(function(){ 
              if(! mouse_is_inside) $('.searches').hide();
	      if(! mouse_is_inside) $('#mysea').removeClass("sactive");
    	    });
	});


$(document).ready(function(){
	
	if(localStorage.getItem("searchStringArrAng") != null){
		$("#searchPad").show();
		var searchList = JSON.parse(localStorage.getItem("searchStringArrAng"));
		$("#searchCount").html(searchList.length);
		//console.log('search list-------',searchList);
        //console.log('search list length-----',searchList);
        var JSONText_ = JSON.stringify(searchList[2]);
        var JSONObject_ = JSON.parse(JSONText_);
        var searchObj_ = JSON.parse(JSON.parse(JSONObject_));
        var adult = searchObj_["adult"];
        var child = searchObj_["child"];
        var infant = searchObj_["infantWs"];
        var infantlap = searchObj_["infant"];
        var traveller = adult+child+infant+infantlap;
        setTimeout(()=>{
        traveller == 1 ? $(".coach-button > .coach").val(traveller+' Traveller') : $(".coach-button > .coach").val(traveller+' Travellers');
    },100)
        console.log('newwwwww-----',traveller)
		var searchPadHtml = "";
		for (i = 0; i < searchList.length; i++) {
			
			var JSONText = JSON.stringify(searchList[i]);
			 var JSONObject = JSON.parse(JSONText);
			console.log(JSON.parse(JSON.parse(JSONObject)))
			 var searchObj = JSON.parse(JSON.parse(JSONObject));
    		 var froCity = searchObj["origin"];
			 var toCity = searchObj["destination"];
			 var journeyType = searchObj["tripType"];
			 var cabinClass = searchObj["cabin"];
			 var adult = searchObj["adult"];
			 var child = searchObj["child"];
			 var infant = searchObj["infantWs"];
			 var infantlap = searchObj["infant"];
			 var froDate = searchObj["departDate"];
			 var toDate = searchObj["returnDate"];
			 var traveller = adult+child+infant+infantlap;
			 var tripType = "OneWay";
			 var dates = froDate;
             //console.log('travellers-------',traveller);
			 if(journeyType == '2'){ tripType = 'RoundTrip';dates=froDate+" - "+toDate;}
			 
			 var froCityCode = froCity.split("-")[0];
			 var toCityCode = toCity.split("-")[0];
			  searchPadHtml = searchPadHtml+"<div class='search-item' onclick='searchPadSubmit("+i+")'><div class='flight-img'><i class='fa fa-plane'></i></div><div class='sftd'><div class='sfrom-to'><span>"+froCityCode+"&nbsp;To&nbsp;"+toCityCode+"</span><span class='strip-type'>("+tripType+")</span></div><div class='sdates'>"+dates+"</div></div><div class='sright-angle'><i class='fa fa-angle-right'></i></div></div>";
			
		}
		$(".searches").html(searchPadHtml);
	}
});

function searchPadSubmit(id){
	console.log(id);
	var searchList = JSON.parse(localStorage.getItem("searchStringArrAng"));
	for (i = 0; i < searchList.length; i++) {
			if(i==id){
			var JSONText = JSON.stringify(searchList[i]);
			 var JSONObject = JSON.parse(JSONText);
			 console.log(JSON.parse(JSON.parse(JSONObject)))
			 var searchObj = JSON.parse(JSON.parse(JSONObject));
			 $("#origin").val(searchObj.origin);
			 $("#destination").val(searchObj.destination);
			 $("#departDate").val(searchObj.departDate);
			 $("#returnDate").val(searchObj.returnDate);
			 $("#cabin").val(searchObj.cabin);
			 $("#adult").val(searchObj.adult);
			 $("#child").val(searchObj.child);
			 $("#infantWs").val(searchObj.infantWs);
			 $("#infant").val(searchObj.infant);
			 $("#tripType").val(searchObj.tripType);
			 //submitForm();
			 $("#flightSearch").submit();
			}
	}
	
}
$(".access-links li a").click(function(){
       $(".access-links li a").removeClass('qlhead');
       $(".access-links li a i.fa-caret-right").hide();
       $(this).addClass("qlhead");
       $(".access-links li a.qlhead i.fa-caret-right").css("display","inline");
     });
     $("#qli").click(function(){
       $(".links-row").hide();
       $(".access-links").show();
       $(".qlrows").css("display","flex");
     });
     $("#pai").click(function(){
       $(".links-row").hide();
       $(".access-links").show();
       $(".parows").css("display","flex");
     });
     $("#pfi").click(function(){
       $(".links-row").hide();
       $(".access-links").show();
       $(".pfrows").css("display","flex");
     });
     $("#tudi").click(function(){
       $(".links-row").hide();
       $(".access-links").show();
       $(".tudrows").css("display","flex");
     });
     $("#tidi").click(function(){
       $(".links-row").hide();
       $(".access-links").show();
       $(".tidrows").css("display","flex");
     });
     $("#sdi").click(function(){
       $(".links-row").hide();
       $(".access-links").show();
       $(".sdrows").css("display","flex");
     });


function delEmpVal(id1,id2,id3,id4){ //console.log(this);
    $("#"+id1).val('').focus();
    $("#"+id2).html('&nbsp;');
    $("#"+id3).hide();
    $("#"+id4).text('').hide();
}
function onlyAlphabatic(id,s) {//alert(s[s.length - 1])
  let vl = $("#"+id).val();
  if(/^[a-zA-Z]+$/.test(s[s.length - 1]) == false){
    let data = vl.slice(0, -1);
    $("#"+id).val(data)
    //alert(data)
  }
  if(/^[a-zA-Z]+$/.test(vl) == false){//alert('past value')
    let ans = "";
    for (let i = 0; i < vl.length; i++) {
      // if the current character is an alphabet
      if (/^[a-zA-Z]+$/.test(vl[i])) {
        ans += vl[i];
      }
    }
    //alert(ans)
    $("#"+id).val(ans)
    //alert(/^[a-zA-Z]+$/.test(vl))
  }
  //alert(/^[a-zA-Z]+$/.test(s))
}
$(document).ready(function(){
  $("#origin").focus(function(e){
    e.preventDefault();
    $(this).val('');
    $("#txtFltOrigin").text('').hide();
    $("#FcityName").html('&nbsp;');
    $("#OremEmpIcon").hide()
  });
  $("#destination").focus(function(e){
    e.preventDefault();
    $(this).val('');
    $("#txtFltDestin").text('').hide();
    $("#RcityName").html('&nbsp;');
    $("#DremEmpIcon").hide()
  });
});