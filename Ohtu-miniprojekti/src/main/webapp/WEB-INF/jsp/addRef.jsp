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
            <select id="dropDown" class="formDrop">
                <option>Kirja</option>
                <option>Artikkeli</option>
                <option>Inproceedings</option>
            </select>
        </nav>
        <div class="forms">
            <div>
                <form:form id="bookForm" commandName="book" action="addBook" method="POST">
                    <p>Kirjailija: </p>
                    <form:input path="author" />*<form:errors path="author" /><br/>
                    <p>Teoksen nimi: </p>
                    <form:input path="title" />*<form:errors path="title" /><br/>
                    <p>Julkaisuvuosi:</p>
                    <form:input path="pubYear" />*<form:errors path="pubYear" /><br/>
                    <p>Julkaisija:</p>
                    <form:input path="publisher" />*<form:errors path="publisher" /><br/>
                    <p>Editoija:</p>
                    <form:input path="editor" /><form:errors path="editor" /><br/>
                    <input id="bookSubmit"type="submit">
                </form:form>
            </div>
            <div>
                <form:form id="articleForm" commandName="article" action="addArticle" method="POST">
                    <p>Artikkelin kirjoittaja: </p>
                    <form:input path="author" />*<form:errors path="author" /><br/>
                    <p>Teoksen nimi: </p>
                    <form:input path="title" />*<form:errors path="title" /><br/>
                    <p>Julkaisija:</p>
                    <form:input path="publisher" /><form:errors path="publisher" /><br/>
                    <p>Julkaisukuukausi:</p>
                    <form:input path="pubMonth" /><form:errors path="pubMonth" /><br/>
                    <p>Julkaisuvuosi:</p>
                    <form:input path="pubYear" />*<form:errors path="pubYear" /><br/>
                    <p>Sivut (muodossa: alku -- loppu):</p>
                    <form:input path="pages" /><form:errors path="pages" /><br/>
                    <p>Julkaisu (journal):</p>
                    <form:input path="journal" />*<form:errors path="journal" /><br/>
                    <p>Volume:</p>
                    <form:input path="volume" /><form:errors path="volume" /><br/>
                    <p>Numero:</p>
                    <form:input path="number" /><form:errors path="number" /><br/>
                    <p>Julkaisupaikka:</p>
                    <form:input path="address" /><form:errors path="address" /><br/>
                    <input id="articleSubmit"type="submit">
                </form:form>
            </div>
            <div>
                <form:form id="inprocForm" commandName="inproc" action="addInproc" method="POST">
                    <p>Kirjailija: </p>
                    <form:input path="author" />*<form:errors path="author" /><br/>
                    <p>Teoksen nimi: </p>
                    <form:input path="title" />*<form:errors path="title" /><br/>
                    <p>Julkaisukuukausi: </p>
                    <form:input path="pubMonth" /><form:errors path="pubMonth" /><br/>
                    <p>Julkaisuvuosi: </p>
                    <form:input path="pubYear" />*<form:errors path="pubYear" /><br/>
                    <p>Kirjan nimi nimi: </p>
                    <form:input path="bookTitle" />*<form:errors path="bookTitle" /><br/>
                    <p>Organisaatio: </p>
                    <form:input path="organisation" /><form:errors path="organisation" /><br/>
                    <input id="inprocSubmit"type="submit">

                </form:form>   
            </div> 
        </div>

    </body>
</html>
