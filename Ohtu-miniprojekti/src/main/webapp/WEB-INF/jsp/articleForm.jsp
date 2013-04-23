<%-- 
    Document   : articleForm
    Created on : 23-Apr-2013, 15:57:10
    Author     : annisall
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<form:form id="articleForm" commandName="article" action="addArticle" method="POST">
    <p>Artikkelin kirjoittaja: </p>
    <form:input path="author" />*<form:errors path="author" cssClass="error"/><br/>
    <p>Teoksen nimi: </p>
    <form:input path="title" />*<form:errors path="title" cssClass="error"/><br/>
    <p>Julkaisija:</p>
    <form:input path="publisher" /><form:errors path="publisher" cssClass="error"/><br/>
    <p>Julkaisukuukausi:</p>
    <form:input path="pubMonth" /><form:errors path="pubMonth" cssClass="error"/><br/>
    <p>Julkaisuvuosi:</p>
    <form:input path="pubYear" />*<form:errors path="pubYear" cssClass="error"/><br/>
    <p>Sivut (muodossa: alku -- loppu):</p>
    <form:input path="pages" /><form:errors path="pages" cssClass="error"/><br/>
    <p>Julkaisu (journal):</p>
    <form:input path="journal" />*<form:errors path="journal" cssClass="error"/><br/>
    <p>Volume:</p>
    <form:input path="volume" /><form:errors path="volume" cssClass="error"/><br/>
    <p>Numero:</p>
    <form:input path="number" /><form:errors path="number" cssClass="error"/><br/>
    <p>Julkaisupaikka:</p>
    <form:input path="address" /><form:errors path="address" cssClass="error"/><br/>
    <p>ID: </p>
    <form:input path="refId" />*<form:errors path="refId" cssClass="error"/><br/>
     <form:hidden path="id"/><form:errors path="id"/>
    <input id="articleSubmit"type="submit">
</form:form>
