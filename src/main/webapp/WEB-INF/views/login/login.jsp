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
<link rel="stylesheet" href="<spring:url value="/resources/css/dss.css"/>">
<script src="<spring:url value="/resources/js/jquery.min.js"/>"></script> 
<script src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script>
<link rel="shortcut icon" href="<spring:url value="/resources/img/favicon.ico"/>" />
</head>
<body>
<jsp:include page="../fragments/loginheader.jsp"></jsp:include>
<%-- <jsp:include page="../fragments/sidebar.jsp"></jsp:include>  --%>
<!-- Page Content -->
    
 <div class="login">
<div class="row">
   <div class="col-lg-12">
   <h2>LogIn</h2>
   <div class="col-lg-9">
   <c:if test="${error != null}">
        <div class="alert alert-danger">
            <p>${error}</p>
        </div>
   </c:if>
   <c:if test="${info != null}">
        <div class="alert alert-success">
          <p>${info}</p>
        </div>
   </c:if>
   </div>
   <c:url var="loginUrl" value="/login" ></c:url>
  	<form roleId="form" class="col-sm-9" action ="${loginUrl}" id="registration" method="post" >
    	<div class="form-group">
      	<label for="email">Username:</label>
      	<input type="text" class="form-control" name="username" id="email" placeholder="Enter Active Directory Username">
    	</div>
    	<div class="form-group">
      	<label for="pwd">Password:</label>
      	<input type="password" name="password" class="form-control" id="pwd" placeholder="Enter password">
    	</div>
    	<div class="checkbox">
      	<label><input type="checkbox"> Remember me</label>
    	</div>
<%--        <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />  --%>
    	<button type="submit" class="btn btn-primary">Submit</button>
  	</form>
     </div>
     </div>
 </div> 
        </div>
        <!-- /#page-content-wrapper -->
<%-- <jsp:include page="../fragments/footer.jsp"></jsp:include> --%>
</body>
<script src="<spring:url value="/resources/js/jquery.min.js"/>"></script> 
<script src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<spring:url value="/resources/js/sidebar.js"/>"></script>
</html>