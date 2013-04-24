<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="title.add" /></title>
        <%@include file="libraries.jsp" %>


    </head>
    <body>
        <%@include file="naviBar.jsp" %>
        <h1>Tässä lisätään lähteitä, huraa!</h1>
        <nav>
            <select id="dropDown" class="formDrop">
                <option><spring:message code="Book" /></option>
                <option><spring:message code="Article" /></option>
                <option><spring:message code="Inproceedings" /></option>
            </select>
        </nav>
        <div class="forms">
            <div>
                <%@include file="bookForm.jsp" %>
            </div>
            <div>
                <%@include file="articleForm.jsp" %>
            </div>
            <div>
                 <%@include file="inprocForm.jsp" %>
            </div> 
        </div>
        <div id="luke" class="easter"></div>
    </body>
</html>
