<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Godarbejdslyst til vores medarbejder
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        Du er nu logget på som medarbejder

        <p><a href="${pageContext.request.contextPath}/fc/adminorderpage">Gå til alle cupcake ordre </a></p>

    </jsp:body>
</t:genericpage>
