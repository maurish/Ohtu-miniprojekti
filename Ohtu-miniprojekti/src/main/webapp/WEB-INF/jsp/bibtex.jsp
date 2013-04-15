<%-- 
    Document   : bibtex
    Created on : 08-Apr-2013, 13:45:59
    Author     : annisall
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="libraries.jsp" %>
        <script>
            $(function(){
                $('.code').easyCopy()
            })
        </script>
    </head>
    <body>
        <%@include file="naviBar.jsp" %>
        <h1>Hello Bibtex</h1>
        <a href="bibtex"></a>
        <textarea class="code" autofocus readonly><c:forEach var="bibtex" items="${bibtexs}">${bibtex}</c:forEach></textarea>
    </body>
</html>
