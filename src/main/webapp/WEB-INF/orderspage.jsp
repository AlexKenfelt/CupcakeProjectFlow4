<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div>
            <c:if test="${sessionScope.role == 'employee' }">
            <p style="font-size: larger">Det her er hvad du kan gøre,
                når du er logget ind som medarbejder.</p>
            <p><a href="fc/employeepage">Medarbejder siden</a>
                </c:if>

                <c:if test="${sessionScope.role == 'customer' }">
            <p><a href="fc/customerpage">Kunde siden</a>
                </c:if>

                    ${sessionScope.totalprice}

            <div class="col"></div>
            <div class="btn mt-3">
                <button style="background-color: #3C1461; color: white;">Se dine ordre</button>
            </div>
                <button class="btn mt-3" style="background-color: #3C1461; color: white" value="Login" >Login</button>

        </div>

    </jsp:body>
</t:genericpage>