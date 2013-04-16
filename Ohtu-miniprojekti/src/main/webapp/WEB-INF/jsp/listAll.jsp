<%-- 
    Document   : listAll
    Created on : 27-Mar-2013, 12:03:14
    Author     : pperala
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="naviBar.jsp" %>
        <h1>Listing of all References</h1>
        <div>
            <c:forEach var="book" items="${books}">
                <ul>
                    <li>${book.author}</li>
                    <li>${book.title}</li>
                    <li>${book.publisher}</li>
                    <li>${book.pubYear}</li>
                    <li>${book.editor}</li>
                    
                </ul>
            </c:forEach>
            <c:forEach var="article" items="${articles}">
                <ul>
                    <li>${article.author}</li>
                    <li>${article.title}</li>
                    <li>${article.journal}</li>
                    <li>${article.pubYear}</li>
                    <li>${article.pubMonth}</li>
                    <li>${article.volume}</li>
                    <li>${article.number}</li>
                    <li>${article.pages}</li>
                    <li>${article.publisher}</li>
                    <li>${article.address}</li>
                    
                </ul>
            </c:forEach>
            <c:forEach var="inproc" items="${inprocs}">
                <ul>
                    <li>${book.author}</li>
                    <li>${book.title}</li>
                    <li>${book.pubYear}</li>
                    <li>${book.pubMonth}</li>
                    <li>${book.organisation}</li>
                    
                </ul>
            </c:forEach>
        </div>
    </body>
</html>
