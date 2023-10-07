<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<c:forEach items="${bookingRequest.ancillaryServices}" var="anclleries" varStatus="indexed">
	<div class="billing-details">
		<c:if test="${anclleries.supplierCode=='PDP'}">
	        <div class="trvlProt priceDrop">
	            <img src="/resources/images/icons/shield.png" alt="Protection">
	            <div>
	                <div class="cccdhead">${anclleries.fullName}
						<p>${anclleries.description}</p>
					</div>
	                <div class="pricedropP">
	                    <ul class="checkMark checkMark_">
	                    	<c:forEach items="${anclleries.services}" var="services" varStatus="indexNo">
	                    		<li>${services.name}</li>
	                    	</c:forEach>
	                    </ul>
	                    <div>
	                    	<span>$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${anclleries.owServiceText[0].price}" />/ person</span>
	                    	<input type="hidden" id="priceDropCost" value="${anclleries.owServiceText[0].price}" />
	                    </div>
	                </div>
	            </div>
	        </div>
	        <div class="proAddProd">
	            <a href="/price-drop-protection" target="_blank">Learn More</a>
	            <input type="button" id="addPdp" onClick="setAncillaries('PDP','Y','Y')" value="Add Product" />
	            <input type="button" id="removePdp" onClick="setAncillaries('PDP','N','N')" value="Remove Product" style="display:none;" />
	        </div>
	 	</c:if>
	</div>
</c:forEach>