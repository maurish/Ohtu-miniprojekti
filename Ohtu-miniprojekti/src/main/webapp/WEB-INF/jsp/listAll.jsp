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
            <c:forEach var="reference" items="${references}">
                <ul>
                    <li>${book.author}</li>
                    <li>${book.title}</li>
                    <li>${book.publisher}</li>
                    <li>${book.pubYear}</li>
                    <li>${book.editor}</li>
                <%--  <li>${reference.volume}</li>
                    <li>${book.pubMonth}</li>
                    <li>${reference.number}</li>
                    <li>${reference.pages}</li>
                    <li>${reference.address}</li>
                    <li>${reference.organisation}</li> --%>
                </ul>
            </c:forEach>
        <%--    <c:forEach var="article" items="${articles}">
                <ul>
                    <li>${article.author}</li>
                    <li>${article.title}</li>
                    <li>${reference.journal}</li>
                    <li>${reference.pubYear}</li>
                    <li>${reference.pubMonth}</li>
                    <li>${reference.volume}</li>
                    <li>${reference.number}</li>
                    <li>${reference.pages}</li>
                    <li>${reference.publisher}</li>
                    <li>${reference.address}</li>
                    
                </ul>
            </c:forEach> 
            <c:forEach var="inproc" items="${inprocs}">
                <ul>
                    <li>${reference.author}</li>
                    <li>${reference.title}</li>
                    <li>${reference.pubYear}</li>
                    <li>${reference.pubMonth}</li>
                    <li>${reference.organisation}</li>   
                </ul>
            </c:forEach> --%>
        </div>
    </body>
</html>
