<%-- 
    Document   : purebibtex
    Created on : 15-Apr-2013, 16:24:02
    Author     : pperala
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="title.pureBibtex" /></title>
        <%@include file="libraries.jsp" %>
    </head>
    <body id="pureBibtexPage">
        <pre><c:forEach var="bibtex" items="${bibtexs}">${bibtex}
</c:forEach></pre>
    </body>
</html>
