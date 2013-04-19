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
        <title>JSP Page</title>
         <%@include file="libraries.jsp" %>
    </head>
    <body>
        <%@include file="naviBar.jsp" %>
        <h1><spring:message code="label.welcome"/></h1>
        <h1>Listing of all References</h1>
        <div>
            <c:forEach var="reference" items="${references}">
                <ul>
                    <c:forEach var="attribute" items="${reference.attributes}">
                        <c:if test="${not empty attribute.value}">
                            <li>${attribute.key} : ${attribute.value}</li>
                        </c:if>

                    </c:forEach>
                </ul>
            </c:forEach>

        </div>
    </body>
</html>
