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
        <h2 style="text-align: center"> Din kvittering</h2>
        <c:forEach var="cartitem" items="${sessionScope.cart.cartItemList}">

            Bottom: ${cartitem.bottom}
            Top: ${cartitem.top}
            Quantity: ${cartitem.quantity}
            Price: ${cartitem.price} <br/>
        </c:forEach>



    </jsp:body>
</t:genericpage>