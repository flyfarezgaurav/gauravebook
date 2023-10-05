<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<style type="text/css">
#RVM_currencycountry_popup, .RVM_curpop_darkbg {position: fixed; display: none; z-index: 100000000; top: 0;
    right: 0; width: 100%; height: 100%; background: rgb(4, 4, 4, 0.5); border-radius:0; box-shadow:0 10px 5px 1px #44444470;
}
#RVM_currencycountry_popup.d-flex { display: flex; justify-content:center; align-items: center; }
#RVM_currencycountry_popup.d-flex > div { width:480px; text-align:left; height: max-content;background:white; border-radius:8px; }
#RVM_currencycountry_popup .RVM_curcoun_headr { display:flex; align-items:center; padding:0 10px 0 20px; width: 100%; color:#505050; letter-spacing:0.5px; border-bottom:1px solid #505050; }
#RVM_currencycountry_popup .RVM_curcoun_headr i.fa-remove { width: 30px; color: #0060ad; height: 30px;  border-radius: 40px;text-align: center; padding: 6px 0 0; margin: 0 15px 0 0; cursor: pointer; }
#RVM_currencycountry_popup .RVM_curcoun_headr i.fa-remove:hover { background: whitesmoke; }
#RVM_currencycountry_popup .RVM_curcoun_body { width:100%; padding:20px 30px; display:flex; flex-wrap:wrap; justify-content:center; gap:0 10px; }
#RVM_currencycountry_popup .RVM_curcoun_body > div > label { display:flex; align-items: center; margin-bottom:5px; font-size:14px; letter-spacing:0.5px; padding: 0 0 0 15px; position: absolute; top: 7px; left: 0; }
#RVM_currencycountry_popup .RVM_curcoun_body > div > label img { margin-right:8px; }
#RVM_currencycountry_popup .RVM_curcoun_body > div select { width:100%; height:40px; padding-left:15px; letter-spacing:0.5px; -webkit-appearance:none;border: 0; border-radius: 8px; }
#RVM_currencycountry_popup .RVM_curcoun_body > div select:focus-visible { border:0; outline: none }
#RVM_currencycountry_popup .RVM_curcoun_body .RVM_region_country, #RVM_currencycountry_popup .RVM_curcoun_body .region_country, #RVM_currencycountry_popup .RVM_curcoun_body .RVM_region_currency { margin-bottom:18px; width: 100%; border: 1px solid gainsboro; position: relative; padding-top: 20px; border-radius:8px; }
#RVM_currencycountry_popup .RVM_curcoun_body > div.disableCl > label { color:#ababab; }
#RVM_currencycountry_popup .RVM_curcoun_body .RVM_region_country .fa-angle-down, #RVM_currencycountry_popup .RVM_curcoun_body .region_country .fa-angle-down, #RVM_currencycountry_popup .RVM_curcoun_body .RVM_region_currency .fa-angle-down { position: absolute; right: 10px;top: 22px; font-weight: bold; }
#RVM_currencycountry_popup .RVM_curcoun_body .RVM_region_saveornot {display:flex; justify-content:center; width:100%}
#RVM_currencycountry_popup .RVM_curcoun_body .RVM_region_saveornot a {padding: 8px;}
#RVM_currencycountry_popup .RVM_curcoun_body .RVM_region_saveornot .RVM_siteBTN { background:linear-gradient(to right,#e8361a 0%,#f3870b 100%); border-radius:2px; width:100%; display:flex; align-items:center; justify-content:center; color:#fff; letter-spacing:0.5px; background: #2dc44d; border-bottom:0 !important; background: #db2405; text-decoration:none !important;height: 44px; border-radius: 8px; font-weight: bold; }
#RVM_currencycountry_popup .RVM_curcoun_body .RVM_region_saveornot .RVM_siteBTN:hover { background:linear-gradient(to right,#f3870b 0%,#e8361a 100%);background: #1ba538;}
#RVM_currencycountry_popup .RVM_curcoun_body .RVM_region_saveornot .RVM_siteBTN.RVM_siteBTN_G { background:gainsboro; color:black; margin-left:5px }
.RVM_curncy_drp_li a:hover span, .RVM_curncy_drp_li a:focus span { transform:translateY(-0%) !important; }
.RVM_curncy_drp_li .RVM_currencycountry_pack label {font-size: 14px; position: relative; top: 2px;}
@media only screen and (max-width:600px){
    #RVM_currencycountry_popup {/*width:250px;*/}
    #RVM_currencycountry_popup.d-flex > div { width:80%; }
    #RVM_currencycountry_popup .RVM_curcoun_body .RVM_region_country, #RVM_currencycountry_popup .RVM_curcoun_body .region_country, #RVM_currencycountry_popup .RVM_curcoun_body .RVM_region_currency { flex:unset; width:100% }
    #RVM_currencycountry_popup.d-flex { align-items: baseline; padding: 30px 0 0; }
}
@media only screen and (max-width:585px){
    .RVM_curncy_drp_li #countrysymbol_ {height:20px; width:20px;}
    .RVM_curncy_drp_li #countrysymbol_ img {height:20px}
    .RVM_curncy_drp_li #currencysymbol_ {font-size: 16px;}
    .RVM_curncy_drp_li #currencyname_ {font-size:14px; margin:2px 0 0 2px;}
}
</style>
<div class="RVM_currencycountry_popup animated" id="RVM_currencycountry_popup">
  <div>
    <div class="RVM_curcoun_headr">
      <i class="fa fa-remove" onclick="openCurrencyPopup('hide');"></i><h3>Display settings</h3>
    </div>
    <div class="RVM_curcoun_body">
      <div class="col-xs-12 RVM_region_country">
        <label><!-- <img alt="Country" src="/resources/images/icons/c_flag.png" width="24" height="24" loading="lazy" decoding="async"> --> <span class="languageEnglish">Region</span></label>
        <div class="col-xs-12" style="padding:0;">
          <select class="form-control countryselect" id="_countryselect" onchange="countryvaluchng();">
            <option selected="selected" value="USA">United States</option>
            <option value="gb">Greate Britain</option>
            <option value="ca">Canada</option>
            <option value="mx">Mexico</option>
          </select>
          <i class="fa fa-angle-down"></i>
        </div>
      </div>
      <div class="col-xs-12 region_country">
        <label><!-- <i class="fa fa-language" style="font-size:24px" aria-hidden="true"></i>&nbsp;&nbsp; --><span class="languageEnglish">Language</span></label>
        <div class="col-xs-12" style="padding:0;">
          <select class="form-control countryselect"  disabled id="_languageselect">
              <option value="EN" id="eng" selected="">English</option>
              <option value="GB" id="gbp">Greate Britain</option>
              <option value="CA" id="cana">Canadian</option>
              <option value="MX" id="cana">Mexican</option>
          </select>
          <i class="fa fa-angle-down"></i>
        </div>
      </div>
      <div class="col-xs-12 RVM_region_currency disableCl">
        <label><!-- <img alt="Country" src="/resources/images/icons/language.png" width="24" height="24" loading="lazy" decoding="async"> --><span class="languageEnglish">Currency</span></label>
        <div class="col-xs-12" style="padding:0;">
          <select class="form-control countryselect" disabled id="_currencyselect" onchange="currencyvaluchng();">
              <option value="USD" selected="">$ - USD</option>
              <option value="GBP">&#163; - GBP</option>
               <option value="CAD">$ - CAD</option>
               <option value="MEX">$ - MEX</option>
          </select>
          <i class="fa fa-angle-down"></i>
        </div>
      </div>
      
      <div class="col-xs-12 RVM_region_saveornot" ng-click="currencySave()">
        <a href="javascript:;" id="RVM_saveButton" class="RVM_siteBTN as_r_btn"><span class="languageEnglish">SAVE</span></a>
        <!-- <a href="javascript:;" class="RVM_siteBTN RVM_siteBTN_G as_r_btn" onclick="removeclas('RVM_currencycountry_popup','bounceInUp',' d-flex','RVM_curpop_darkbg');"><span class="languageEnglish">CANCEL</span></a> -->
      </div>
    </div>
  </div>
</div>
<li class="">
                                  <a href="javascript:;" onclick="openCurrencyPopup('open')"> 
                                    <i class="fa fa-globe"></i>&nbsp;&nbsp;<span data-hover="English">English</span> </a> </li> 


<script>
  function openCurrencyPopup(txt){//alert(txt)
    $("#RVM_currencycountry_popup").toggleClass('d-flex')
  }
  
 
</script>