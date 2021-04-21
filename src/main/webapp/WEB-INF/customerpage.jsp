<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Hej ${sessionScope.email} </h1>
        <p>Hop ind og bestil cupcakes på <a href="${pageContext.request.contextPath}">forsiden</a></p>
    </jsp:body>

</t:genericpage>

