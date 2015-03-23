<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="request" />
<%@ attribute name="pageTitle" required="false" type="java.lang.String" %>
<head>
	<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
	<script src="${contextPath}/resources/js/jquery/jquery-1.11.2.min.js" /></script>
	<script src="${contextPath}/resources/js/jquery-ui-1.11.2/jquery-ui.min.js" /></script>
	<link href="${contextPath}/resources/css/jquery-ui-1.11.2/jquery-ui.min.css" rel="stylesheet" type="text/css" />
	<link href="${contextPath}/resources/css/jquery-ui-1.11.2/jquery-ui.structure.min.css" rel="stylesheet" type="text/css" />
	<link href="${contextPath}/resources/css/jquery-ui-1.11.2/jquery-ui.theme.min.css" rel="stylesheet" type="text/css" />
	<c:if test="${not empty pageTitle}">
		<title>${pageTitle}</title>
	</c:if>
</head>