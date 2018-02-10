<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script src="<spring:url value="/resources/js/jquery.min.js"/>"></script>
    <%-- <link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap.min.css"/>"/> --%>
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
    <link rel="stylesheet" href="<spring:url value="/resources/css/dss.css"/>"/>
    <link rel="stylesheet" href="<spring:url value="/resources/css/sidebar.css"/>"/>
    <link rel="stylesheet" href="<spring:url value="/resources/css/font-awesome.min.css"/>"/>
    <link rel="shortcut icon" href="<spring:url value="/resources/img/favicon.ico"/>"/>
    <link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap.min-icons.css"/>">
    <script>
        $(document).ready(function () {
            var date_input = $('#date'); //our date input has the name "date"
            var container = $('.container-fluid').length > 0 ? $('.container-fluid').parent() : "body";
            var options = {
                format: 'yyyy-mm-dd',
                container: container,
                todayHighlight: true,
                autoclose: true,
            };
            date_input.datepicker(options);
        })
    </script>
    <script>
        jQuery(document).ready(function($) {
            $('#surveys').on('change',function()
            {
                var selectedSurveyId=$(this).val();
                $.ajax({
                    type: "GET",
                    url: "/graca/section/survey/"+selectedSurveyId,
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    success: function(surveySections) {
                        var options;
                        $.each(surveySections , function(index , surveySection){
                            options+= "<option value='" + surveySection.id + "'>"+surveySection.section.name+"</option>";
                        });
                        populateQuestions(surveySections[0]);
                        $('#sections').html(options);
                    },
                });
            });

            $('#sections').on('change',function()
            {
                var selectedSurveySectionId=$(this).val();
                $.ajax({
                    type: "GET",
                    url: "/graca/surveysection/question/"+selectedSurveySectionId,
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    success: function(surveySectionQuestions) {
                        var options;
                        $.each(surveySectionQuestions , function(index , surveySectionQuestion){
                            options+= "<option value='" + surveySectionQuestion.id + "'>"+surveySectionQuestion.question.title+"</option>";
                        });
                        $('#questions').html(options);
                    },
                });
            });

        });
    </script>
    <script type="text/javascript">
        function populateQuestions(firstOptionElement) {
                var selectedSurveySectionId= firstOptionElement.id;
                $.ajax({
                    type: "GET",
                    url: "/graca/surveysection/question/" + selectedSurveySectionId,
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    success: function (surveySectionQuestions) {
                        var options;
                        $.each(surveySectionQuestions, function (index, surveySectionQuestion) {
                            options += "<option value='" + surveySectionQuestion.id + "'>" + surveySectionQuestion.question.title + "</option>";
                        });
                        $('#questions').html(options);
                    },
            });
        }
    </script>

    <script>
        function pleaseWait() {
            $('#myPleaseWait').modal('show');
        }
    </script>

</head>
<body>
<jsp:include page="../fragments/header.jsp"></jsp:include>
<jsp:include page="../fragments/sidebar.jsp"></jsp:include>
<!-- Page Content -->

<div class="container-fluid xyz">
    <div class="row">
        <div class="col-lg-8">


            <div class="modal fade bs-example-modal-sm" id="myPleaseWait" tabindex="-1"
                 role="dialog" aria-hidden="true" data-backdrop="static">
                <div class="modal-dialog modal-sm">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">
                    <span class="glyphicon glyphicon-time">
                    </span>Please Wait
                            </h4>
                        </div>
                        <div class="modal-body">
                            <div class="progress">
                                <div class="progress-bar progress-bar-info
                    progress-bar-striped active"
                                     style="width: 100%">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <h2>Survey Response Analysis</h2>
            <c:if test="${!empty error }">
                <div class="alert alert-danger">
                    <strong>Failure!</strong> ${error}.
                </div>
            </c:if>
            <c:if test="${!empty info}">
                <div class="alert alert-info">
                    <strong>NOTICE!</strong> ${info}.
                </div>
            </c:if>
            <spring:url var="generateGraph" value="/customer/response/"></spring:url>
            <form id="registration" role="form" class="col-sm-8" action="${generateGraph}" method="post">
                <div class="form-group">
                    <label><b id="required">*</b>Survey:</label>
                    <select class="form-control" id="surveys" name="surveys">
                        <c:if test="${!empty survey}">
                            <option value="${survey.id}">${survey.name}</option>
                        </c:if>
                        <option value="0">Please select</option>
                        <c:forEach items="${surveys}" var="survey">
                            <option value="${survey.id}">${survey.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label><b id="required">*</b>Section:</label>
                    <select class="form-control" id="sections" name="sections">
                        <c:if test="${!empty surveySection}">
                            <option value="${surveySection.id}">${surveySection.section.name}</option>
                        </c:if>
                        <option value="0">Please select</option>
                    </select>
                </div>
                <div class="form-group">
                    <label><b id="required">*</b>Question:</label>
                    <select class="form-control" id="questions" name="questions">
                        <c:if test="${!empty surveySectionQuestion}">
                            <option value="${surveySectionQuestion.id}">${surveySectionQuestion.question.title}</option>
                        </c:if>
                        <option value="0">Please select</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>Up to (Date):</label>
                    <input name="date" type="text" class="form-control" id="date" placeholder="Enter From Date"
                           required/>
                </div>

                <button type="submit" class="btn btn-primary" onclick="pleaseWait()">Submit</button>
            </form>
        </div>
        <br/>

    </div>
    <div class="row">
        <div class="col-lg-12">
            <c:if test="${!empty barChartUrl}">
                <img alt="Bar Chart" src=${barChartUrl} />
            </c:if>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <c:if test="${!empty pieUrl}">
                <img alt="Pie Chart" src=${pieUrl} />
            </c:if>
        </div>
    </div>
</div>
</div>
<!-- /#page-content-wrapper -->
<jsp:include page="../fragments/footer.jsp"></jsp:include>
</body>
<%-- <script src="<spring:url value="/resources/js/jquery.min.js"/>"></script>  --%>
<%--<script src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script>--%>
<%--<script src="<spring:url value="/resources/js/sidebar.js"/>"></script>--%>
</html>