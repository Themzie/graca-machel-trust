<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap.min.css"/>"/>
 <link rel="stylesheet" href="<spring:url value="/resources/css/sidebar.css"/>"/>
<link rel="stylesheet" href="<spring:url value="/resources/css/font-awesome.min.css"/>"/>
<link rel="stylesheet" href="<spring:url value="/resources/css/jquery-ui.css"/>"/>


<link rel="<spring:url value="/resources/css/bootstrap.min-icons.css"/>">
<script src="<spring:url value="/resources/js/jquery.min.js"/>"></script> 
<script src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script>
</head>
<body>
<jsp:include page="../fragments/header.jsp"></jsp:include>
<jsp:include page="../fragments/sidebar.jsp"></jsp:include>
<!-- Page Content -->
    
<div class="container-fluid xyz">
<div class="row">
<div class="col-lg-12">
My dashboard
</div>
</div>
</div>
</div>
        <!-- /#page-content-wrapper -->
<jsp:include page="../fragments/footer.jsp"></jsp:include>
</body>
<script src="<spring:url value="/resources/js/jquery.min.js"/>"></script> 
<script src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<spring:url value="/resources/js/sidebar.js"/>"></script>
</html>