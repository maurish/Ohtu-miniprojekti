<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Page</title>
    </head>
    <body>
        <%@include file="naviBar.jsp" %>
        <h1>Tässä lisätään lähteitä, huraa!</h1>
        <form:form commandName="reference" action="addRef" method="POST">
            <p>Kirjailija: </p>
            <form:input path="author" /><form:errors path="author" /><br/>
            <p>Teoksen nimi: </p>
            <form:input path="name" /><form:errors path="name" /><br/>
            <input type="submit">
        </form:form>
    </body>
</html>
