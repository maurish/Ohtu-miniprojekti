
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<header>
    <div class="links">
        <a href="${pageContext.request.contextPath}/app/addRef"><spring:message code="navibar.addRef" /></a>
        <a href="${pageContext.request.contextPath}/app/list"><spring:message code="navibar.list" /></a>
        <a href="${pageContext.request.contextPath}/app/listBibtex"><spring:message code="navibar.listBib" /></a>
    </div>
    <div class="locale">
        <a href="?locale=en">en</a>
        <a href="?locale=fi">fi</a>
        <a href="?locale=sv">sv</a>
        <a href="?locale=ar">lol</a>
    </div>

</header>
