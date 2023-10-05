<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<style type="text/css">
.trvlExpSec .priceDrop img { opacity:0; display:none }
.trvlExpSec .proAddProd { flex-wrap:wrap; align-items:baseline; }
.trvlExpSec .proAddProd .itemss { width:32%; border:1px solid gainsboro; border-radius:6px; }
.trvlExpSec .proAddProd .itemss .itemssHead { background:#9d9d9d; color:white; padding:10px 10px 10px 20px; border-radius:6px 6px 0 0; }
.trvlExpSec .proAddProd .itemss.active .itemssHead { background:#063d99 }
.trvlExpSec .proAddProd .itemss .itemssBody { padding:15px 10px 10px 20px }
.trvlExpSec .proAddProd .itemss .blueTxt { color:#063d99; font-size:13px; }
.trvlExpSec .proAddProd .itemss .itemssBody ul { padding:0; list-style-type:none; font-size:14px; font-weight:500; letter-spacing:0.5px; }
.trvlExpSec .proAddProd .itemss .itemssBody ul li { margin-bottom:4px; }
.trvlExpSec .proAddProd .itemss .itemssBody > div { font-weight:700; display:flex; justify-content:space-between; color:#063d99; }
.trvlExpSec .priceDrop .cccdhead { padding-left:0; }
@media(max-width: 767px){
    .trvlExpSec .proAddProd .itemss { width:100%; margin-bottom:15px }
}
</style>

<c:if test="${not empty bookingRequest.fareFamily}">
			
			<div class="billing-details trvlExpSec">
                    <div class="trvlProt priceDrop">
                        <img src="/resources/images/icons/shield.png" alt="Protection">
                        <div>
                            <div class="cccdhead">Customize Your Travel Experience
                                <p>Select the class that matches your needs</p>
                            </div>
                        </div>
                    </div>
                    <div class="proAddProd">
						
						<c:forEach items="${bookingRequest.fareFamily}" var="fareFamilyList" varStatus="outer" >	<!-- begin="0" end="2" -->
						
                        <div class="itemss ${outer.index==0 ? 'active' : ''}" id="fareID${outer.index}">
                            <div class="itemssHead">${fareFamilyList.fareFamilyDescription[0].description}</div>
                            <div class="itemssBody">
                                <p class="blueTxt">Included in the fare</p>
                                <ul>
                                    <c:forEach items="${fareFamilyList.fareFamilyDescription[0].serviceInformation}" var="serviceList" varStatus="indexed">
                                    	<c:if test="${serviceList.serviceType=='INC'}">
                                    		<li>${serviceList.serviceName}</li>
                                    	</c:if>
                                    </c:forEach>
                                </ul>
                         	<div>
                         		
                         		<c:choose>
                         			<c:when test="${outer.index==0}">
                         				<input type="button" onClick="upgradeProduct('Current', '${fareFamilyList.fareFamilyDescription[0].description}', '${fareFamilyList.priceDiffrence}', '${outer.index}');" value="Current Included" />
                         			</c:when>
                         			<c:otherwise>
                         				<span>
                         				<input type="button" onClick="upgradeProduct('Add', '${fareFamilyList.fareFamilyDescription[0].description}', '${fareFamilyList.priceDiffrence}', '${outer.index}');" value="Upgrade" />
                         				</span>
                                		<span><span>+ ${currencySymbol}</span><fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${fareFamilyList.priceDiffrence*currencyValue}" /></span>
                         			</c:otherwise>
                         		</c:choose>
                         		
                            </div>
                                
                            </div>
                        </div>
						
                        </c:forEach>
						
                    </div>
                </div>

</c:if>