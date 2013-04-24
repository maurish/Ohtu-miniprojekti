<%-- 
    Document   : inprocForm
    Created on : 23-Apr-2013, 15:57:57
    Author     : annisall
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<form:form id="inprocForm" commandName="inproc" action="addInproc" method="POST">
    <p><spring:message code="author" />: </p>
    <form:input path="author" />*<form:errors path="author" cssClass="error"/><br/>
    <p><spring:message code="title" />: </p>
    <form:input path="title" />*<form:errors path="title" cssClass="error"/><br/>
    <p><spring:message code="pubMonth" />: </p>
    <form:input path="pubMonth" /><form:errors path="pubMonth" cssClass="error"/><br/>
    <p><spring:message code="pubYear" />: </p>
    <form:input path="pubYear" />*<form:errors path="pubYear" cssClass="error"/><br/>
    <p><spring:message code="booktitle" />: </p>
    <form:input path="bookTitle" />*<form:errors path="bookTitle" cssClass="error"/><br/>
    <p><spring:message code="organisation" />: </p>
    <form:input path="organisation" /><form:errors path="organisation" cssClass="error"/><br/>
    <p>ID: </p>
    <form:input path="refId" />*<form:errors path="refId" cssClass="error"/><br/>
    <form:hidden path="id"/><form:errors path="id"/>
    <input id="inprocSubmit"type="submit">

</form:form>  
