<%@ page import="com.travel.utility.SiteMap"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



<div class="ebook-footer" style="background-color:#ffffff;width:100%;">
<%
   com.travel.utility.SiteMap tc = new com.travel.utility.SiteMap();
   tc.getSitemap(request);
  %>

    <div class="mymain">
        <div class="mymaininner">
            <div class="mymaininner1">
                <p class="top-routes-heading">Top Flight <span class="bluecolor">Routes</span></p>
                <div class="fLink_sctn">
                    <div class="block1">
                        <ul>
                            <li><a href="/routes/cheap-flights-from-albuquerque-abq-to-anchorage-anc">Albuquerque to
                                    Anchorage</a></li>
                            <li><a href="/routes/cheap-flights-from-albuquerque-abq-to-kahului-ogg">Albuquerque to
                                    Kahului</a></li>
                            <li><a href="/routes/cheap-flights-from-atlanta-atl-to-albuquerque-abq">Atlanta to
                                    Albuquerque</a></li>
                            <li><a href="/routes/cheap-flights-from-atlanta-atl-to-austin-aus">Atlanta to Austin </a></li>
                            <li><a href="/routes/cheap-flights-from-chicago-chi-atlanta-atl">Chicago to Atlanta</a></li>
                           </ul>
                    </div>
                    <div class="block1">
                        <ul>
                            <li><a href="/routes/cheap-flights-from-atlanta-atl-to-baltimore-bwi">Atlanta to Baltimore</a>
                            </li>
                            <li><a href="/routes/cheap-flights-from-atlanta-atl-to-boston-bos">Atlanta to Boston</a></li>
                            <li><a href="/routes/cheap-flights-from-atlanta-atl-to-bradley-bdl">Atlanta to Bradley</a></li>
                            <li><a href="/routes/cheap-flights-from-atlanta-atl-to-chicago-ord">Atlanta to Chicago</a></li>
                            <li><a href="/routes/cheap-flights-from-honolulu-hnl-atlanta-alt">Honolulu to Atlanta</a></li>
                        </ul>
                    </div>
                    <div class="block1">
                        <ul>
                            <li><a href="/routes/cheap-flights-from-atlanta-atl-to-columbus-cmh">Atlanta to Columbus</a>
                            </li>
                            <li><a href="/routes/cheap-flights-from-atlanta-atl-to-fort-myers-rsw">Atlanta to Fort Myers</a>
                            </li>
                            <li><a href="/routes/cheap-flights-from-atlanta-atl-to-honolulu-hnl">Atlanta to Honolulu</a>
                            </li>
                            <li><a href="/routes/cheap-flights-from-atlanta-atl-to-houston-iah">Atlanta to Houston</a></li>
                            <li><a href="/routes/cheap-flights-from-losangels-lax-atlanta-atl">Los angels to Atlanta</a>
                            </li>
                            
                        </ul>
                    </div>
                    <div class="block1">
                        <ul>
                            <li><a href="/routes/cheap-flights-from-atlanta-atl-to-lasvegas-las">Atlanta to Las Vegas</a>
                            </li>
                            <li><a href="/routes/cheap-flights-from-baltimore-bwi-atlanta-atl">Baltimore to Atlanta</a></li>
                            <li><a href="/routes/cheap-flights-from-boston-bos-atlanta-atl">Boston to Atlanta</a></li>
                            <li><a href="/routes/cheap-flights-from-charlott-clt-to-cincinnati-cvg">Charlott to
                                    Cincinnati</a></li>
                            <li><a href="/routes/cheap-flights-from-philadelphia-phl-atlanta-atl">Philadelphia to
                                    Atlanta</a></li>
                        </ul>
                    </div>

                    <div class="block1">
                        <ul>
                            <li><a href="/routes/cheap-flights-from-dallas-dfw-atlanta-atl">Dallas to Atlanta</a></li>
                            <li><a href="/routes/cheap-flights-from-denver-den-atlanta-atl">Denver to Atlanta</a></li>
                            <li><a href="/routes/cheap-flights-from-lasvegas-las-to-atlanta-atl">Las Vegas to Atlanta</a>
                            </li>
                            <li><a href="/routes/cheap-flights-from-newyork-jfk-atlanta-atl">New York to Atlanta</a></li>
                            <li><a href="/routes/cheap-flights-from-sanfrancisco-sfo-atlanta-atl">San Francisco to
                                Atlanta</a></li>
                        </ul>
                        
                    </div>


                    <div class="block1">
                        <ul>
                            <li><a href="/routes/cheap-flights-from-seattle-sea-atlanta-atl">Seattle to Atlanta</a></li>
                            <li><a href="/routes/cheap-flights-from-tampa-tpa-atlanta-atl">Tampa to Atlanta</a></li>
                            <li><a href="/routes/cheap-flights-from-houston-iah-atlanta-atl">Houston to Atlanta</a>
                            </li>
                            <li><a href="/routes/cheap-flights-from-miami-mia-atlanta-atl">Miami to Atlanta</a></li>
                            
                        </ul>
                        
                    </div>

                    
                </div>
                <p class="redmore"><a href="/sitemap">Read More</a></p>
            </div>

        </div>
    </div>

    <div class="footer-container">
        <div class="footer1" style="padding-top:20px;">
            <div class="fhead">Quick Links</div>
            <div class="quick-links">

                <div class="links-row qlrows">
                    <div class="lrhead">BOOK</div>
                    <ul>
                        <li><a href="/cheap-flight">Cheap Flights</a></li>
                    </ul>

                </div>
                <div class="links-row qlrows">
                    <div class="lrhead">TRAVELER TOOLS</div>
                    <ul>
                        <li><a href="javascript:void(window.open('/baggage-fees', 'Taxes and Fees', 'width=600,height=750,scrollbars=yes'));">Airline
                                Baggage Fees</a></li>
                        <li><a href="/blogs">Travel Blog</a></li>
                    </ul>
                </div>
                <div class="links-row qlrows">
                    <div class="lrhead">ABOUT</div>
                    <ul>
                        <li><a href="/aboutus">About Us</a></li>
                        <li><a href="/newsletter">Newsletter</a></li>
                        <li><a href="/sitemap">Sitemap</a></li>
                    </ul>
                </div>
                <div class="links-row qlrows">
                    <div class="lrhead">LEGAL</div>
                    <ul>
                        <li><a href="/contactus">Contact Us</a></li>
                        <li><a href="/terms-and-conditions">Terms & Conditions</a></li>
                        <li><a href="/privacy-policy">Privacy Policy</a></li>
                        <li><a href="javascript:void(window.open('/taxes-fees', '_blank', 'width=600,height=750,scrollbars=yes'));">Taxes
                                & Fees</a></li>
                        <li><a href="javascript:void(window.open('/our-service-fees', 'Taxes and Fees', 'width=600,height=750,scrollbars=yes'));">Our
                                Service Fees</a></li>
                        <li><a href="/post-ticketing-fees">Post Ticketing Fees</a></li>
                    </ul>
                </div>
            </div>

        </div>
    </div>
    
    <div style="clear: left;"></div>
    <div style="clear:left;"></div>

    <div class="mainconnect">
        <div class="connect">

            <div class="two-half">
                <span>Scan the QR code and follow us!</span>
                <img src="/resources/images/scan-white.png" class="foot-scan-img" alt="scan" width="20" height="10" loading="lazy" decoding="async">
            </div>

            <div class="one-half">
                <span>Connect With Us:</span>
                <ul class="mfs_connect-icons">
                    <li><a href="https://www.pinterest.com/EBookTripLLC/" class="pinterest" target="_blank"
                            title="pinterest"><i class="fa fa-pinterest"></i></a></li>
                    <li><a href="https://twitter.com/EbookTrip" class="twitter" target="_blank" title="twitter"><i
                                class="fa fa-twitter"></i></a></li>
                    <li><a href="https://www.facebook.com/EBookTripLLC/" class="facebook_ mfsIcon-fb" target="_blank"
                            title="facebook"><i class="fa fa-facebook"></i></a></li>
                    <li><a href="https://www.youtube.com/channel/UCu1jAkrbnKPCEFZ_mAiLVjg" class="youtube" target="_blank"
                            title="youtube"><i class="fa fa-youtube"></i></a></li>
                    <li><a href="https://www.instagram.com/ebooktripllc/" class="youtube" target="_blank" title="youtube"><i
                                class="fa fa-instagram"></i></a></li>

                </ul>
            </div>

            <div class="three-half">
                <span>Sign up for Exclusive Email-Only deals!</span>
                <div class="sign-up-box">
                    <input type="text" name="subscribe_email" class="form-control inputfieldset" id="subscribe_email"
                        placeholder="Your Email" />
                    <button class="submit EmailSignup" onclick="return subscribeEmail();">
                        <label class="loader"><span>Loading...</span><i></i></label>
                        <span>subscribe <i class="fa fa-envelope"></i></span>
                    </button>
                    <label class="errorMsg">Email is required</label>
                    <label class="emailMsg">Please Enter Correct ID</label>
                </div>

                <label class="subcribe-msg" id="subcribe-msg-success"></label>
            </div>
            <div style="clear:both;"></div>
        </div>
        <div style="clear:left;"></div>
    </div>



    <div class="foot-disclaimer">
        <p>
            <strong>Disclaimer</strong>: ebooktrip.com is a US-based online travel agency. It serves as a liaison between
            clients and the providers of travel services; nevertheless, it makes no guarantees regarding the availability,
            cost, or grade of the services provided by the providers. The primary goal of ebooktrip.com is to link travelers
            and airlines. The price of the ticket is changeable here until ticketing. Please contact us using the
            information on the contact us page <a href="https://www.ebooktrip.com/contactus">
                (https://www.ebooktrip.com/contactus)</a> if you have any questions or issues.
        </p>
    </div>

    <div class="certified-icon">
        <picture>
            <source srcset="/resources/images/certified-white.webp" type="image/webp">
            <img src="/resources/images/certified-white.png" alt="certified" width="10" height="3" loading="lazy" decoding="async">
        </picture>
    </div>

    <div class="copyright">
        <p>Copyright &copy; 2021 - 2023, Ebooktrip. All rights reserved.</p>
    </div>
</div>

<div class="fixed-call-bottom">
    <c:choose>
        <c:when test="${pageResponse != null && pageResponse.tfnNo != null && pageResponse.tfnNo != ''}">
            <a href="tel:${pageResponse.tfnNo}"><img src="/resources/images/phone-call.png" alt="phone-call" width="5"
                    height="5">
                <div>
                    <div>Call & Get Unpublished Flight Deals!</div>
                    <div>${pageResponse.tfnNo}</div>
                </div>
            </a>
        </c:when>
        <c:otherwise>
            <a href="tel:+1-800-404-0025"><img src="/resources/images/phone-call.png" alt="phone-call" width="5"
                    height="5">
                <div>
                    <div>Call & Get Unpublished Flight Deals!</div>
                    <div>+1-800-404-0025</div>
                </div>
            </a>
        </c:otherwise>
    </c:choose>
    <i class="fa fa-close"></i>
</div>


<!-- <div class="tnfsticky-container">
    <div class="sticky-tnf">
        <ul class="sticky">
            <li>
                <span class="tnf-call-icon"><i class="fa fa-phone"></i></span>
                <p>
                    <a href="tel:+1-800-404-0025" title="Call Us 24/7 for EbookTrip">+1-800-404-0025
                        <span>Relative to EbookTrip</span>
                    </a>

                </p>
                <span class="sticky-close"><i class="fa fa-close"></i></span>
            </li>
        </ul>
    </div>
</div> -->

<script>


jQuery(document).ready(function(){
    jQuery(".sticky-tnf .sticky li").click(function(){
        jQuery(this).toggleClass("tnf-show");
    });
});

function emailCheck(email){
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if(email.match(mailformat)){
		return true;
	}else{
		return false;
	}
}

function subscribeEmail(){
	
	var emailID = $("#subscribe_email").val();
	var flag= false;
	
	if(emailID==""){
		flag= true;
		$(".errorMsg").show();
	}
	else{
		$(".errorMsg").hide();
		
		if(!emailCheck(emailID)){
			flag= true;
			$(".emailMsg").show();
		}
		else{
			$(".emailMsg").hide();
		} 
	}
	
	if(flag){
		return ;
	}
	else{
		$.ajax({
			url: '/subscribesubmit/'+$("#subscribe_email").val(),
			type: 'post',
			contentType: 'application/json; charset=utf-8',
			//data: JSON.stringify(data),
			dataType: "text",
			beforeSend: function() {
     			$(".loader").show().addClass('activeLoader');
 			},
			success: function(response) {
				$(".loader").hide().removeClass('activeLoader');
				if(response == 'true'){
					$("#subcribe-msg-success").text("You have successfully subscribed!").css("color", "green");
				}
				else{
					$("#subcribe-msg-success").text("Some Technical Issue Please try later!").css("color", "red");	
				}
			}
		});
	}
}
</script>