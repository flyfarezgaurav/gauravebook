<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Auth Form : Ebooktrip</title>
        <link rel="icon" href="/resources/images/favicon.png">
<script src="https://www.ebooktrip.com/resources/scripts/jquery-1.11.1.min.js"></script>
    <!-- Bootstrap -->
    <!-- <link href="css/bootstrap.min.css" rel="stylesheet"> -->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
<style type="text/css">
.logoColor { color:white; letter-spacing:2px; font-weight:bold; font-size:24px; height:auto; padding-top:0; padding-bottom:0; }
.p-tb-5 { padding:5px 0 }
.banner { display:flex; width:100%; margin:61px 0 0; padding:30px 0 50px }
.banner img { opacity:0.6 }
.banner .banDFlex { display:flex; flex-wrap:wrap; align-items:center; padding:0; }
.banner .banDFlex p { font-size:17px; letter-spacing:1px; line-height:1.6; }
.navSection { background:white; border-bottom:1px solid ghostwhite }
</style>
<jsp:include page="tag-manager-head.jsp" />
  </head>
  <body style="background:whitesmoke">
    <!-- Fixed navbar -->
    <nav class="navbar navSection navbar-fixed-top p-tb-5">
      <div class="container">
        <div class="navbar-header">
          
          <a class="navbar-brand logoColor" href="#"><img src="../resources/image/logo.png" class="img-responsive" alt="Logo"><!-- Travel Protection --></a>
        </div>
        
      </div>
    </nav>
    

    <!-- Credit card form -->
<style type="text/css">
.creditForm { width:100%; display:flex; padding:120px 0 50px 0; }
.creditForm > div { width:100%; display:flex; justify-content:center; }
.creditForm > div > .col-md-6 { box-shadow:0 2px 15px -3px rgba(0,0,0,0.07), 0 10px 20px -2px rgba(0,0,0,0.04); border-radius:10px; background:white; padding:0; }
.creditForm .card-header { padding:20px; border-bottom:2px solid #f5f5f5; }
.creditForm .card-header h5 { font-size:20px; font-weight:bold; margin:0; display:flex; align-items:center; justify-content:space-between; }
.creditForm .card-body { padding:20px }
.creditForm .billAddHead { font-size:20px; font-weight:bold; margin:0; padding:30px 0 30px; }
.creditForm .card-body .form-outline label { font-weight:normal; margin:0 0 2px 0; letter-spacing:0.5px; }
.creditForm .card-body input, .creditForm .card-body select { box-shadow:none; height:44px; border-radius:3px; }
.mb-4 { margin-bottom:10px }
.creditForm button[type=submit] { margin-top:30px; background:#063d99; border-color:#063d99; box-shadow:none; }
.popError { border-color:red; }
@media(max-width: 550px){
  .creditForm .card-header h5 { flex-wrap:wrap; justify-content:center; }
  .creditForm .card-header h5 img { height:20px; margin-top:5px; }
  .creditForm { padding:100px 15px 20px 15px }
}
</style>
<section class="creditForm">
  <div class="">
    <div class="col-md-6 mb-4">
      <div class="card mb-4">
        <div class="card-header py-3">
          <h5 class="mb-0">Card Information
            <img src="../resources/image/certified.png" alt="cards">
          </h5>
        </div>
        <div class="card-body">
          <form:form  id="authForm" method="post" action="/capture_cc_info" modelAttribute="authForm">

<input type="hidden" name="bookingId" id="bookingIds" value="<%= request.getParameter("bookingId")%>">
            <div class=" mb-4">
              
              <div class="col">
                <div class="form-outline">
                  <label class="form-label" for="formCardNumber">Credit number</label>
                  <input placeholder="Please enter credit card number" maxlength="16" type="text" name="cardNum" path="cardNum" id="cardNum" class="form-control" onkeyup="phoneValidate('cardNum')" />
                  
                </div>
              </div>
            </div>

          <div class="row">
            <div class="form-outline mb-4 col-sm-4 col-xs-12">
              <label class="form-label" for="formExpiration" path="expMonth" name="expMonth" >Exp Month</label>
              <select class="form-control" id="expMonth">
                <option value="00">Select Month</option>
                <option value="01">Jan</option>
                <option value="02">Feb</option>
                <option value="03">Mar</option>
                <option value="04">Apr</option>
                <option value="05">May</option>
                <option value="06">Jun</option>
                <option value="07">Jul</option>
                <option value="08">Aug</option>
                <option value="09">Sep</option>
                <option value="10">Oct</option>
                <option value="11">Nov</option>
                <option value="12">Dec</option>
              </select>
              
            </div>


            <div class="form-outline mb-4 col-sm-4 col-xs-12">
              <label class="form-label" for="formExpiration" path="expYear" name="expYear" >Year</label>
              <select class="form-control" id="expYear">
                <option value="00">Select Year</option>
                <option value="2023">2023</option>
                <option value="2024">2024</option>
                <option value="2025">2025</option>
                <option value="2026">2026</option>
                <option value="2027">2027</option>
                <option value="2028">2028</option>
                <option value="2029">2029</option>
                <option value="2030">2030</option>
                <option value="2031">2031</option>
                <option value="2032">2032</option>
                <option value="2033">2033</option>
                <option value="2034">2034</option>
                <option value="2035">2035</option>
                <option value="2036">2036</option>

              </select>
              
            </div>



      <!--       <div class=" mb-4">
              <div class="col-3">
                <div class="form-outline">
                  <label class="form-label" for="formExpiration">Expiration Date</label>
                  <input type="text" placeholder="MM/YYYY"  name="expMonth" path="expMonth"  id="expMonth" class="form-control" />
                  
                </div>
              </div>
            </div> -->
            <div class=" mb-4 col-sm-4 col-xs-12">
              <div class="col-3">
                <div class="form-outline">
                  <label class="form-label" for="formCVV">Card Code</label>
                  <input type="text" onkeyup="phoneValidate('ccvNo')" placeholder="Enter card code" maxlength="4" name="ccvNo" path="ccvNo"  id="ccvNo" class="form-control" />
                </div>
              </div>
            </div>
          </div>
            <!-- 2 column grid layout with text inputs for the first and last names -->
            <hr class="my-4" />
            <h5 class="mb-4 billAddHead">Billing Address</h5>
            <div class=" mb-4">
              <div class="col">
                <div class="form-outline">
                  <label class="form-label" for="form6Example1">First name</label>
                  <input type="text" placeholder="Enter first name"  name="paxFNname" path="paxFNname"  id="paxFNname" class="form-control" />
                  
                </div>
              </div>
            </div>
            <div class=" mb-4">
              <div class="col">
                <div class="form-outline">
                  <label class="form-label" for="form6Example2">Last name</label>
                  <input type="text" placeholder="Enter last name"  name="paxLName" path="paxLName" id="paxLName" class="form-control" />
                  
                </div>
              </div>
            </div>

            <div class="form-outline mb-4">
              <label class="form-label" for="country" path="country" name="country" >Country</label>
              <select class="form-control" id="country">
                <option value="US">USA</option>
                <option value="CA">Canada</option>
                <option value="UK">United Kingdom</option>

              </select>
              
            </div>
         
            <!-- Text input -->
            <div class="form-outline mb-4">
              <label class="form-label" for="form6Example4">Street Address</label>
              <input type="text" placeholder="Enter Street Address"  name="strAddres" path="strAddres"  id="strAddres" class="form-control" />
              
            </div>

            <!-- Email input -->
            <div class="form-outline mb-4">
              <label class="form-label" for="form6Example5">City</label>
              <input type="text" placeholder="Enter City"  name="city" path="city"  id="city" class="form-control" />
              
            </div>

             <div class="form-outline mb-4">
              <label class="form-label" for="form6Example5">State</label>
              <input type="text" placeholder="Enter 2 letter State code"  name="state" path="state"  id="state" class="form-control" />
              
            </div>

               <!-- Text input -->
            <div class="form-outline mb-4">
              <label class="form-label" for="form6Example3">Zip Code</label>
              <input type="text" placeholder="Enter Zip Code"  name="zip" path="zip"  id="zip" class="form-control" />
              
            </div>

            <!-- <div class="form-outline mb-4">
              <label class="form-label" for="form6Example5">State</label>
              <select class="form-control">
                <option val="luc">Lucknow</option>
                <option val="kan">Kanpur</option>
              </select>
              
            </div> -->

            <!-- Number input -->
            <div class="form-outline mb-4">
              <label class="form-label" for="form6Example6">Phone Number</label>
              <input type="number" placeholder="Enter phone number"  name="phoneNo" onkeyup="phoneValidate('phoneNo')" path="phoneNo" id="phoneNo" class="form-control" />
              
            </div>

           <!--  <hr class="my-4" />

           
            <hr class="my-4" />
 -->
            

            <button type="submit" name="" id="ccAuth" class="btn btn-primary btn-lg"  >
              Submit
            </button>
         </form:form>
        </div>
      </div>
    </div>

    
  </div>
</section>
<!-- Credit card form -->

<style type="text/css">
#popupSuccess { display:none; position: fixed; top: 0; left: 0; width: 100%; height: 100vh; justify-content: center; align-items: center; z-index: 100000; background:#00000080; font-family:-apple-system,BlinkMacSystemFont,Arial,Helvetica Neue,Segoe UI,Roboto,sans-serif }
#popupSuccess.active { display:flex; }
#popupSuccess > div { background:white; border-radius:10px; display: inline-flex; justify-content: center; flex-wrap: wrap; text-align: center; width:320px; padding:25px 15px 25px }
#popupSuccess > div div, #popupSuccess > div p { width:100%; margin:0; }
#popupSuccess .success { font-weight: bold; font-size: 25px; margin-bottom:15px; margin-top:10px; }
</style>
 


    <style type="text/css">
      footer { background:#242424; padding:20px 0; text-align:center; color:grey; }
    </style>
    <footer>
      <div class="container">
        <div class="row">
          <div class="col-xs-12 pd-0">
            &copy; Copyright by Ebooktrip 2023
          </div>
        </div>
      </div>
    </footer>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <!-- <script src="js/bootstrap.min.js"></script> -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script>
      function hideNewPopup(id){
          $("#"+id).removeClass('active')
          $("body").removeClass('overflowHidden')
      }
    </script>


<script type="text/javascript">

function phoneValidate(phones) {//alert(phone.value)
    var phone = document.getElementById(phones).value;
    var singleVal = phone.value;
    var pattern = /^\d+\.?\d*$/;
    if(pattern.test(phone.slice(-1)) == false){//alert(phone.value)
      var output = phone.slice(0, -1);
      document.getElementById(phones).value = output;
    }
}
    $("#ccAuth").click(function() { 
        
        //alert("popup work");

     var cardNum = $('#cardNum').val();
     var expMonth = $('#expMonth').val();
     console.log(expMonth);
     
     var expYear = $('#expYear').val();
    
     var ccvNo = $('#ccvNo').val();
     var paxFNname = $('#paxFNname').val();
     //alert(froCity);
     var paxLNname = $('#paxLName').val();
     var country = $('#country option:selected').text();
     var strAddres = $('#strAddres').val();
     var city = $('#city').val();
     var state = $('#state').val();
     var zip = $('#zip').val();
     var phoneNo = $('#phoneNo').val();
     var bookingIds = $('#bookingIds').val();
    //alert(country);
     

    if(cardNum.length == 0){
     
        $('#cardNum').addClass('popError').focus();
    return false;
    }else{
        $('#cardNum').removeClass('popError');
    }

     if(expMonth == '00'){
      
        $('#expMonth').addClass('popError').focus();
    return false;
    }else{
        $('#expMonth').removeClass('popError');
    }
    if(expYear == '00'){
      
        $('#expYear').addClass('popError').focus();
    return false;
    }else{
        $('#expYear').removeClass('popError');
    }
console.log(expYear)
     if(ccvNo.length == 0){
       
        $('#ccvNo').addClass('popError').focus();
    return false;
    }else{
        $('#ccvNo').removeClass('popError');
    }

    
    if(paxFNname.length == 0){
       
        $('#paxFNname').addClass('popError').focus();
    return false;
    }else{
        $('#paxFNname').removeClass('popError');
    }

     if(paxLNname.length == 0){
      
        $('#paxLNname').addClass('popError').focus();
    return false;
    }else{
        $('#paxLNname').removeClass('popError');
    }
     

   if(strAddres.length == 0){
    
        $('#strAddres').addClass('popError').focus();
    return false;
    }else{
        $('#strAddres').removeClass('popError');
    }

    if(city.length == 0){
         
        $('#city').addClass('popError').focus();
    return false;
    }else{
        $('#city').removeClass('popError');
    }

    if(state.length == 0){
      
        $('#state').addClass('popError').focus();
    return false;
    }else{
        $('#state').removeClass('popError');
    }
  if(zip.length == 0){
      
        $('#zip').addClass('popError').focus();
    return false;
    }else{
        $('#zip').removeClass('popError');
    }

  if(phoneNo.length == 0){
    
        $('#phoneNo').addClass('popError').focus();
    return false;
    }else{
        $('#phoneNo').removeClass('popError');
    }
    
   $.ajax({
       type: "POST",
       url: "/captureCCInfo?cardNum="+cardNum+"&expMonth="+expMonth+"&expYear="+expYear+"&ccvNo="+ccvNo+"&paxFNname="+paxFNname+"&paxLNname="+paxLNname+"&country="+country+"&strAddres="+strAddres+"&city="+city+"&state="+state+"&zip="+zip+"&phoneNo="+phoneNo+"&bookingIds="+bookingIds,      
       success: function(result) { console.log(result)
       if(result === "success") { 
       
        
        
       /* $("#newPopup").removeClass("active").hide();  
        $("#popupSuccess").addClass("active").hide(); */
        
        $("#ccAuth").attr("disabled", true);
        
        var vurl=document.location.origin+'/thankyou'; 
        window.location.href = vurl;
            
       }else{
        console.log("this is error subscribe message==",result)
       }
       },
       error: function(result) {        
         console.log("this is error subscribe message==",result)
       }
   });
});

function IsEmail(email) {
      var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
      if(!regex.test(email)) {
        return false;
      }else{
        return true;
      }
    }
    
    
     

</script>


  </body>
</html>