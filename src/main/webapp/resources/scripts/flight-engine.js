//////////////////////////// Datepicker Starts /////////////////////////////////////////
if($("#pageType").val() == 'engine'){
	var currentDate = new Date();
	
	$("#departDate").val(currentDate);
	$("#departDate").val($.datepicker.formatDate( "mm/dd/yy", currentDate));
	currentDate.setDate(currentDate.getDate()+7)
	
	$("#returnDate").val(currentDate);
	$("#returnDate").val($.datepicker.formatDate( "mm/dd/yy", currentDate));
}
	$("#departDate").datepicker({
		minDate : new Date(),
		maxDate : "+11M",
		onSelect : function(date,event){
			
			$("#departDate").val($.datepicker.formatDate( "mm/dd/yy", new Date(date)));
			$("#returnDate").val($.datepicker.formatDate( "mm/dd/yy", new Date(date)));
			$("#returnDate").val(date);
		},
		onClose : function(date){
			if($("#tripType").val() == "2"){
			$('#returnDate').datepicker("option","minDate", new Date(date));
			$('#returnDate').datepicker('show');
			}
		}
	});
	
	$("#returnDate").datepicker({
		minDate : new Date(),
		maxDate : "+11M",
		onSelect : function(date,event){
			
			$("#returnDate").val($.datepicker.formatDate( "mm/dd/yy", new Date(date)));
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
		if(this.id == "origin")
			setTimeout(function() {
               $("#destination").focus();
            }, 100);
		
		if(this.id == "destination")
			setTimeout(function() {
              $('#departDate').datepicker('show');
            }, 100);
		
        return false;
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
	 
//////////////////////////// Autocomplete Ends /////////////////////////////////////////