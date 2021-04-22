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

            <h2 style="text-align: center"> Hvad har du lagt i den søde mave? </h2> <br>

            <c:forEach var="cartitem" items="${sessionScope.cart.cartItemList}">

                bottom: ${cartitem.bottom}
                top: ${cartitem.top}
                quantity: ${cartitem.quantity}
                price: ${cartitem.price} <br/>
            </c:forEach>

            pris i alt: ${sessionScope.totalprice}

            <c:if test="${sessionScope.role == 'employee' }">
            <p style="font-size: larger">Det her er hvad du kan gøre,
                når du er logget ind som medarbejder.</p>
            <p><a href="fc/employeepage">Medarbejder siden</a>
                </c:if>

                <c:if test="${sessionScope.role == 'customer' }">
            <p><a href="fc/customerpage">Kunde siden</a>
                </c:if>


                <c:if test="${sessionScope.role == 'customer'}">
            <div align="center">
                <a href="${pageContext.request.contextPath}/fc/paymentpage">
                    <button style="background-color: #3C1461; color: white;">Gå til betaling</button>
                </a>
            </div>
            </c:if>

            <c:if test="${sessionScope.role == 'customer'}">
                <div align="center">
                    <a href="${pageContext.request.contextPath}/fc/index">
                        <button style="background-color: #3C1461; color: white;">Læg mere i kurv</button>
                    </a>
                </div>
            </c:if>

        </div>

    </jsp:body>
</t:genericpage>