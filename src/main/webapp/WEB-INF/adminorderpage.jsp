<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Se ordrehistorikken for vores cupcakes:
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Ordrehistorikken ${sessionScope.email} </h1>
       Her er listen:

<table class="table">
    <thead>
    <tr>
    <th>User id</th>
    <th>Order id</th>
    <th>Status</th>
    <th>Tidspunkt</th>
    </thead>
    </tr>
    <tbody>
    <c:forEach var="order" items="${sessionScope.orderList}">

    <tr>
        <td>${order.user.id}</td>
        <td>${order.orderId}</td>
        <td>${order.status}</td>
        <td>${order.timestamp}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>

    </jsp:body>
</t:genericpage>
