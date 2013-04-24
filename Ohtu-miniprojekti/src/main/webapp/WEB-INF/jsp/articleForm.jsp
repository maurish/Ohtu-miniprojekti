<%-- 
    Document   : articleForm
    Created on : 23-Apr-2013, 15:57:10
    Author     : annisall
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<form:form id="articleForm" commandName="article" action="addArticle" method="POST">
    <p><spring:message code="author" />: </p>
    <form:input path="author" />*<form:errors path="author" cssClass="error"/><br/>
    <p><spring:message code="title" />: </p>
    <form:input path="title" />*<form:errors path="title" cssClass="error"/><br/>
    <p><spring:message code="publisher" />:</p>
    <form:input path="publisher" /><form:errors path="publisher" cssClass="error"/><br/>
    <p><spring:message code="pubMonth" />:</p>
    <form:input path="pubMonth" /><form:errors path="pubMonth" cssClass="error"/><br/>
    <p><spring:message code="pubYear" />:</p>
    <form:input path="pubYear" />*<form:errors path="pubYear" cssClass="error"/><br/>
    <p><spring:message code="pagesFromTo" />:</p>
    <form:input path="pages" /><form:errors path="pages" cssClass="error"/><br/>
    <p><spring:message code="journal" />:</p>
    <form:input path="journal" />*<form:errors path="journal" cssClass="error"/><br/>
    <p><spring:message code="volume" />:</p>
    <form:input path="volume" /><form:errors path="volume" cssClass="error"/><br/>
    <p><spring:message code="number" />:</p>
    <form:input path="number" /><form:errors path="number" cssClass="error"/><br/>
    <p><spring:message code="pubPlace" />:</p>
    <form:input path="address" /><form:errors path="address" cssClass="error"/><br/>
    <p>ID: </p>
    <form:input path="refId" />*<form:errors path="refId" cssClass="error"/><br/>
     <form:hidden path="id"/><form:errors path="id"/>
    <input id="articleSubmit"type="submit">
</form:form>
