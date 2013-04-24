<%-- 
    Document   : bookForm
    Created on : 23-Apr-2013, 15:53:54
    Author     : annisall
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<form:form id="bookForm" commandName="book" action="addBook" method="POST">
    <p><spring:message code="author" />: </p>
    <form:input path="author" />*<form:errors path="author" cssClass="error"/><br/>
    <p><spring:message code="booktitle" />: </p>
    <form:input path="title" />*<form:errors path="title" cssClass="error"/><br/>
    <p><spring:message code="pubYear" />:</p>
    <form:input path="pubYear" />*<form:errors path="pubYear" cssClass="error"/><br/>
    <p><spring:message code="publisher" />:</p>
    <form:input path="publisher" />*<form:errors path="publisher" cssClass="error"/><br/>
    <p><spring:message code="editor" />:</p>
    <form:input path="editor" /><form:errors path="editor" cssClass="error"/><br/>
    <p>ID: </p>
    <form:input path="refId" />*<form:errors path="refId" cssClass="error"/><br/>
    <form:hidden path="id"/><form:errors path="id"/>
    <input id="bookSubmit"type="submit">
</form:form>
