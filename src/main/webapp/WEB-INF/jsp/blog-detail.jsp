<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>${blogResponse.title}</title>
    <meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="${blogResponse.description}">
    <meta name="keyword" content="${blogResponse.keywords}">
    <link rel="icon" href="/resources/images/favicon.png">
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700&display=swap" rel="preload" as="font" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="preload" fetchpriority="high" as="image" href="/resources/images/blog-body.webp" type="image/webp">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css">
    <link rel="stylesheet" href="/resources/css/default.css?v=4.2">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.min.js" crossorigin="anonymous"></script>
   
<jsp:include page="tag-manager-head.jsp" /></head>
<body>
    <jsp:include page="tag-manager-body.jsp" />
    <!--Header Area Starts Here-->
    <jsp:include page="header.jsp" />
    <div class="screen-overlay" id="screenoverlay" onclick="hidesidenav()"></div>
    <div class="blog-head">
        <span>Ebooktrip Blog</span>
    </div>
	<input type="hidden" id="pageUrl" value="${blogResponse.titleUrl}" />
    <div style="width:100%;background-color:#ffffff;">
    <div class="blog-detail-container">
        <div class="blog-detail static-content">
            <!-- <div class="bdmtxt">
                ${blogResponse.title}
            </div> -->
            <!-- <div class="bdimg">
                <img src="${blogResponse.imgUrl}">
            </div> -->
            <div class="bdtxt">
                ${blogResponse.content}
            </div>
            
        </div>
    </div>
    </div>
    <jsp:include page="customer-review.jsp" />
     <jsp:include page="footer.jsp" />
</body>
<script src="/resources/scripts/script.js"></script>
</html>