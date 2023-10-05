<style type="text/css">
#backDrop { display: none; width: 100%; height: 100vh; position: fixed; opacity: 0.9; background: #222; z-index: 40000; top:0; left: 0; overflow: hidden; animation-name: fadeIn_Container; animation-duration: 1s; }
.modalPop { display:none; top: 0; min-width: 250px; width:400px; /*height: 400px;*/ margin: 0 auto; position: fixed; z-index: 40001; background: #fff; border-radius: 10px; box-shadow: 0px 0px 10px #000; margin-top: 30px; margin-left:calc(50% - 200px); animation-name: fadeIn_Modal; animation-duration: 0.8s; font-family:-apple-system,BlinkMacSystemFont,Arial,Helvetica Neue,Segoe UI,Roboto,sans-serif; }
/*.header { width: 100%; height: 70px; border-radius: 10px 10px 0px 0px; border-bottom: 2px solid #ccc; }
.header a { text-decoration: none; float: right; line-height: 70px; margin-right: 20px; color: #aaa; }*/
.contentPop { width: 100%; /*height: 250px;*/ padding:20px; text-align:center; line-height:1.7; letter-spacing:0.5px; }
/*form { margin-top: 20px; }
form label{ display: block; margin-left: 12%; margin-top: 10px; font-family: sans-serif; font-size: 1rem; }
form input{ display: block; width: 75%; margin-left: 12%; margin-top: 10px; border-radius: 3px; font-family: sans-serif; }*/
#first_label{ padding-top: 30px; }
#second_label{ padding-top: 25px; }
.footerPop{ width: 100%; padding: 15px 15px; text-align: center; border-radius: 0px 0px 10px 10px; border-top: 2px solid #ccc; }
.footerPop a { padding:10px 20px; border-radius: 5px; display: inline-block; background: #db2405; color: white; text-decoration: none !important; letter-spacing:1px; font-size:14px; text-transform:uppercase; }
.footerPop a:hover { background:#ad1900; }
.footerPop a:first-child { background:#063d99; }
.footerPop a:first-child:hover { background:#002c76; }
</style>
<div class="" id="backDrop">
  
</div>
<div class="modalPop" id="modalPopup">
  <!-- <div class="header">
    <a href="#" class="cancel">X</a>
  </div> -->
  <div class="contentPop">
    Your Session has expired.
    <p>Start a new search to view best deals.</p>  </div>
  <div class="footerPop">
    <a href="/">Go To Home</a>
    <a href="javascript:;" onclick="location.reload();">Refresh Page</a>
  </div>
</div>
<script type="text/javascript">
$(window).load(function(){
  setTimeout(function(){ 
    $("#modalPopup").css("display","block");
    $("#backDrop").css("display","block");
  }, 1800000);
})
// $("#open").click(function(){
//      $("#modalPopup").css("display","block");
//      $("#backDrop").css("display","block");
// });
// $(".cancel").click(function(){
//      $("#modalPopup").fadeOut();
//      $("#backDrop").fadeOut();
// });
</script>