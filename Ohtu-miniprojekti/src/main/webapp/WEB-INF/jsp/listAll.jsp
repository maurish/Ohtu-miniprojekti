<%-- 
    Document   : listAll
    Created on : 27-Mar-2013, 12:03:14
    Author     : pperala
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="title.list" /></title>
        <%@include file="libraries.jsp" %>
    </head>
    <body id="listPage">
        <%@include file="naviBar.jsp" %>
        <h1><spring:message code="label.welcome"/></h1>
        <h1><spring:message code="label.list"/></h1>
        <div class="search">
            <input type="text" placeholder="<spring:message code="search.text" />">
            <input type="checkbox" checked> <spring:message code="search.ignorecase"/>
        </div>
        <div class="list">
            <c:forEach var="reference" items="${references}">
                <div data-id="${reference.id}" class="ref">
                    <span class="bold">${reference.refId}</span><br/>
                    <c:forEach var="attribute" items="${reference.attributes}">
                        <c:if test="${not empty attribute.value}">
                            <spring:message code="${attribute.key}"/>: ${attribute.value}<br/>
                        </c:if>

                    </c:forEach>
                    <a href="${pageContext.request.contextPath}/app/updateRef/${reference.id}"> <button><spring:message code="update"/></button></a>
                </div>
            </c:forEach>

        </div>
        <a class="generate human"href="${pageContext.request.contextPath}/app/listIds/"> <button disabled><spring:message code="select"/></button></a>
        <a class="generate bibtex"href="${pageContext.request.contextPath}/app/downloadIds/"> <button disabled><spring:message code="download"/></button></a>
        <a class="generate delete"href="${pageContext.request.contextPath}/app/deleteRef/"> <button disabled><spring:message code="delete"/></button></a>
        <button id="deselect"><spring:message code="deselect"/></button>
        <div id="luke" class="easter"></div>
    </body>
</html>
