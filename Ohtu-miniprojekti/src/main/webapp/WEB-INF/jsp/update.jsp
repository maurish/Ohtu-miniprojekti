<%-- 
    Document   : update
    Created on : 23-Apr-2013, 15:52:22
    Author     : annisall
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="title.update" /></title>
        <%@include file="libraries.jsp" %>
    </head>
    <body id="updatePage">
        <h1>Hello World!</h1>
        <c:if test="${not empty book}"><%@include file="bookForm.jsp" %></c:if>
        <c:if test="${not empty article}"><%@include file="articleForm.jsp" %></c:if>
        <c:if test="${not empty inproceedings}"><%@include file="inprocForm.jsp" %></c:if>
        
        
    </body>
</html>
