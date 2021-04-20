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


            <p style="text-align: center">Hvad har lagt i den søde mave</p><br>



            <c:forEach var="cartitem" items="${sessionScope.cart.cartItemList}">
                bottom: ${cartitem.bottom} top: ${cartitem.top} quantity: ${cartitem.quantity} <br/>
            </c:forEach>

            <c:if test="${sessionScope.role == 'employee' }">
                <p style="font-size: larger">Det her er hvad du kan gøre,
                    når du er logget ind som medarbejder.</p>
                 <p><a href="fc/employeepage">Medarbejder siden</a>
             </c:if>

             <c:if test="${sessionScope.role == 'customer' }">
                <p style="font-size: larger">Det er hvad du kan gøre,
                                når du er logget ind som kunde. </p>
                <p><a href="fc/customerpage">Kunde siden</a>
            </c:if>

        </div>

    </jsp:body>
</t:genericpage>