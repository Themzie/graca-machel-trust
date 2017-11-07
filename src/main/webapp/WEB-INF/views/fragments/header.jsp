<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Graca Machel Trust</title>
<link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap.min.css"/>"/>
<link rel="stylesheet" href="<spring:url value="/resources/css/sidebar.css"/>"/> 
<link rel="stylesheet" href="<spring:url value="/resources/css/dss.css"/>"/> 
<%-- <link rel="stylesheet" href="<spring:url value="/resources/css/font-awesome.min.css"/>"/>  --%>
<%-- <link rel="<spring:url value="/resources/css/bootstrap.min-icons.css"/>"> --%>
</head>
<body>
<nav class="navbar navbar-default no-margin">
    <!-- Brand and toggle get grouped for better mobile display -->
<nav class="navbar navbar-inverse">
  <div class="container-fluid" id="myHeader">
    <div class="navbar-header">
    <img id="logo" src="<spring:url value="/resources/img/logo.png"/>">
      <a class="navbar-brand" href="#">Web-Portal</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
    <sec:authentication property="principal.username" var="loggedInUser"/>
    <c:if test="${!empty loggedInUser}">
    	<li><a href="#"><span class="fa fa-user fa-lg"></span> Welcome , ${loggedInUser}</a></li>
      	<li><a href="<spring:url value='/logout'/>"><span class="fa fa-sign-out fa-lg"></span> LogOut</a></li>
      </c:if>
    </ul>
  </div>
</nav>
</nav>
</body>
<%-- <script src="<spring:url value="/resources/js/jquery.js"/>"></script>  --%>
<%-- <script src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script> --%>
<%-- <script src="<spring:url value="/resources/js/sidebar.js"/>"></script> --%>
</html>