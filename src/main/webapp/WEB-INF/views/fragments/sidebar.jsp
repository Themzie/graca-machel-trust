<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LogIn</title>
<link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap.min.css"/>"/>
 <link rel="stylesheet" href="<spring:url value="/resources/css/sidebar.css"/>"/>
<link rel="stylesheet" href="<spring:url value="/resources/css/font-awesome.min.css"/>"/>
<script src="<spring:url value="/resources/css/bootstrap.min-icons.css"/>"></script>
</head>
<body>
<div id="wrapper">
        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav nav-pills nav-stacked" id="menu">
                <li class="active">
                    <a href='<spring:url value="/home"></spring:url>'><span class="fa-stack fa-lg pull-left"><i class="fa fa-dashboard fa-stack-1x  "></i></span>DashBoard</a>
                </li>

                <li>
                    <a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-user fa-stack-1x "></i></span>Surveys</a>
                    <ul class="nav-pills nav-stacked" style="list-style-type:none;">
                        <li><a href='#'><span class="fa-stack fa-lg pull-left"><i class="fa fa-plus fa-stack-1x "></i></span>Add Survey</a></li>
                        <li><a href='#'><span class="fa-stack fa-lg pull-left"><i class="fa fa-plus fa-stack-1x "></i></span>Add Section</a></li>
                        <li><a href='#'><span class="fa-stack fa-lg pull-left"><i class="fa fa-plus fa-stack-1x "></i></span>Add Question</a></li>
                    </ul>
                </li>
                <li>
                <li>
                    <a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-user fa-stack-1x "></i></span>Reports</a>
                    <ul class="nav-pills nav-stacked" style="list-style-type:none;">
                        <li><a href='<spring:url value="/customer/response/"></spring:url>'><span class="fa-stack fa-lg pull-left"><i class="fa fa-plus fa-stack-1x "></i></span>Customer Responses</a></li>
                    </ul>
                </li>
                <li>
                <li>
                    <a href='<spring:url value="/logout"></spring:url>'><span class="fa-stack fa-lg pull-left"><i class="fa fa-power-off fa-stack-1x "></i></span>LogOut</a>
                </li>
            </ul>
        </div><!-- /#sidebar-wrapper -->
 
<%-- <script src="<spring:url value="/resources/js/jquery.js"/>"></script>  --%>
<%-- <script src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script> --%>
<script src="<spring:url value="/resources/js/sidebar.js"/>"></script>
</body>
</html>