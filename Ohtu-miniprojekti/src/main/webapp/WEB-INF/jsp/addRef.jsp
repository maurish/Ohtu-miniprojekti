<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Page</title>
        <%@include file="libraries.jsp" %>

        <script src="resources/script.js"></script>
        
    </head>
    <body>
        <%@include file="naviBar.jsp" %>
        <h1>Tässä lisätään lähteitä, huraa!</h1>
        <nav>
            <select class="formDrop">
                <option>Kirja</option>
                <option>Artikkeli</option>
                <option>Inproceedings</option>
            </select>
        </nav>
        <div>
            <form:form id="bookForm" commandName="book" action="addBook" method="POST">
                <p>Kirjailija: </p>
                <form:input path="author" /><form:errors path="author" /><br/>
                <p>Teoksen nimi: </p>
                <form:input path="title" /><form:errors path="title" /><br/>
                <input type="submit">
            </form:form>
        </div>
        <div>
            <form:form id="articleForm" commandName="article" action="addArticle" method="POST">
                <p>article: </p>
                <form:input path="author" />*<form:errors path="author" /><br/>
                <p>Teoksen nimi: </p>
                <form:input path="title" /><form:errors path="title" /><br/>
                <input type="submit">
            </form:form>
        </div>
        <div>
            <form:form id="inprocForm" commandName="inproc" action="addInproc" method="POST">
                <p>inproc: </p>
                <form:input path="author" /><form:errors path="author" /><br/>
                <p>Teoksen nimi: </p>
                <form:input path="title" /><form:errors path="title" /><br/>
                <input type="submit">
            </form:form>   
        </div> 

    </body>
</html>
