<%-- 
    Document   : bibtex
    Created on : 08-Apr-2013, 13:45:59
    Author     : annisall
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="title.bibtex" /></title>
        <%@include file="libraries.jsp" %>
        <script>
            $(function(){
                $('.code').easyCopy()
                $('.ui').fontResize($('.code'))
            })
        </script>
    </head>
    <body id="bibtexPage">
        <%@include file="naviBar.jsp" %>
        <div class="wrapper">
            <a href="bibtex"><spring:message code="label.pureBibtex" /></a>
            <a href="downloadBibtex"><spring:message code="label.downloadBibtex" /></a>
            <div class="fontcontrol">
                <span class="plus ui">+</span><span class="minus ui">-</span>
            </div>
            <textarea class="code" autofocus readonly><c:forEach var="bibtex" items="${bibtexs}">${bibtex}
</c:forEach></textarea>
            
        </div>
    </body>
</html>
