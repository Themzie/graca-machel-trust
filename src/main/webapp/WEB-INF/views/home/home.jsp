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
<link rel="stylesheet" href="<spring:url value="/resources/css/dss.css"/>"/>
<link rel="shortcut icon" href="<spring:url value="/resources/img/favicon.ico"/>" />
<link rel="<spring:url value="/resources/css/bootstrap.min-icons.css"/>">
<script src="<spring:url value="/resources/js/jquery.min.js"/>"></script> 
<script src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script>
<script type="text/javascript">
$( document ).ready(function() {
 	$('a.disabled').click(function() { 
 		alert("You are not allowed to access this function");
 		return false; }); 
});
 	
</script>
</head>
<body>
<jsp:include page="../fragments/header.jsp"></jsp:include>
<jsp:include page="../fragments/sidebar.jsp"></jsp:include>
<!-- Page Content -->
    
<div class="container-fluid xyz">
<div class="row">
<div class="col-lg-6">
<h2>Operations DashBoard</h2>
  <table class="table">
    <tbody>
      <tr>
      <td class="dashboardTitle"><b>Survey Operations</b></td>
        <td>
        
        <a href='<spring:url value="/customer/response/"></spring:url>'>
	        <div class="panel">
	    		<img src="<spring:url value="/resources/img/icons/response/response-1.png"/>" class="front card">
	    		<img src="<spring:url value="/resources/img/icons/response/response-2.png"/>" class="back card">
			</div>
			<b class="icon_name">Customer Responses</b>
			</a>
		 
		</td>
        <td>
        <a href='#'>
        	<div class="panel">
	    		<img src="<spring:url value="/resources/img/icons/survey/survey-1.png"/>" class="front card">
	    		<img src="<spring:url value="/resources/img/icons/survey/survey-2.png"/>" class="back card">
			</div>
			<b class="icon_name">Add Survey</b>
		</a>
        </td>
        <td>
        <a href='#'>
        	<div class="panel">
	    		<img src="<spring:url value="/resources/img/icons/section/section-1.png"/>" class="front card">
	    		<img src="<spring:url value="/resources/img/icons/section/section-2.png"/>" class="back card">
			</div>
			<b class="icon_name">Add Sections</b>
        </a>
        </td>
        <td>
        <a href='#'>
        	<div class="panel">
	    		<img src="<spring:url value="/resources/img/icons/question/question-1.png"/>" class="front card">
	    		<img src="<spring:url value="/resources/img/icons/question/question-2.png"/>" class="back card">
			</div>
			<b class="icon_name">Add Question</b>
        </a>
        </td>
       </tr>
      <%--<tr>
      <td class="dashboardTitle"><b>ECC Operations</b></td>
        <td>
        <a href='<spring:url value="/vehicleUse/list"></spring:url>'>
	        <div class="panel">
	    		<img src="<spring:url value="/resources/img/icons/app/add.png"/>" class="front card">
	    		<img src="<spring:url value="/resources/img/icons/app/add1.png"/>" class="back card">
			</div>
			<b class="icon_name">Vehicle Uses</b>
		</a>
		</td>
        <td>
        <a href='<spring:url value="/vehiclePackage/list"></spring:url>'>
        	<div class="panel">
	    		<img src="<spring:url value="/resources/img/icons/app/edit.png"/>" class="front card">
	    		<img src="<spring:url value="/resources/img/icons/app/edit1.png"/>" class="back card">
			</div>
			<b class="icon_name">Packages</b>
		</a> 
        </td>
        <td>
        <a href='<spring:url value="/vehicleMake/list/1"></spring:url>'>
        	<div class="panel">
	    		<img src="<spring:url value="/resources/img/icons/app/search.png"/>" class="front card">
	    		<img src="<spring:url value="/resources/img/icons/app/search1.png"/>" class="back card">
			</div>
			<b class="icon_name">Vehicle Makes</b>
		</a>
        </td>
        <td>
        <a href='<spring:url value="/vehicle/operations"></spring:url>'>
        	<div class="panel">
	    		<img src="<spring:url value="/resources/img/icons/user/details.png"/>" class="front card">
	    		<img src="<spring:url value="/resources/img/icons/user/details1.png"/>" class="back card">
			</div>
			<b class="icon_name">Vehicle Operations</b>
		</a>
        </td>
      </tr>--%>
      <%--<tr>
     <td class="dashboardTitle"><b>ECH Operations</b></td>
        <td>
        <a href='<spring:url value="/homePackage/list"></spring:url>'>
	        <div class="panel">
	    		<img src="<spring:url value="/resources/img/icons/group/add.png"/>" class="front card">
	    		<img src="<spring:url value="/resources/img/icons/group/add1.png"/>" class="back card">
			</div>
			<b class="icon_name">Packages</b>
		</a>
		</td>
        <td>
        <a href='<spring:url value="/country/list"></spring:url>' >
        	<div class="panel">
	    		<img src="<spring:url value="/resources/img/icons/group/search.png"/>" class="front card">
	    		<img src="<spring:url value="/resources/img/icons/group/search1.png"/>" class="back card">
			</div>
			<b class="icon_name">Countries</b>
		</a> 
        </td>
        <td>
        <a href='<spring:url value="/home/add"></spring:url>'>
        	<div class="panel">
	    		<img src="<spring:url value="/resources/img/icons/group/edit.png"/>" class="front card">
	    		<img src="<spring:url value="/resources/img/icons/group/edit1.png"/>" class="back card">
			</div>
			<b class="icon_name">Add Home</b>
        </td>
        </a>
        <td>
        <a href='<spring:url value="/home/operations"></spring:url>'>
        	<div class="panel">
	    		<img src="<spring:url value="/resources/img/icons/group/role.png"/>" class="front card">
	    		<img src="<spring:url value="/resources/img/icons/group/role1.png"/>" class="back card">
			</div>
			<b class="icon_name">Home Operations</b>
		</a>
        </td>
      </tr>--%>
    </tbody>
  </table>
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