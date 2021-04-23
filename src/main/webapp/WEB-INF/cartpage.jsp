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

                Bottom: ${cartitem.bottom}
                Top: ${cartitem.top}
                Quantity: ${cartitem.quantity}
                Price: ${cartitem.price} <br/>
            </c:forEach>


            Pris i alt: ${sessionScope.totalprice}


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
            <form action="${pageContext.request.contextPath}/fc/makeorder" method="post">
                <input type="hidden" name="userid" value="${sessionScope.user.id}">
                <input type="submit" value="Bestil" style="background-color: #3C1461; color: white;">
            </form>
            </div>
                <div align="center">
                    <a href="${pageContext.request.contextPath}/fc/index">
                        <button style="background-color: #3C1461; color: white;">Læg mere i kurv</button>
                    </a>
                </div>
            </c:if>
            <c:if test="${sessionScope.role != 'customer'}">
                <a href="${pageContext.request.contextPath}/fc/loginpage">
                    <button style="background-color: #3C1461; color: white;">Log ind og bestil</button>
                </a>
            </c:if>

        </div>

    </jsp:body>
</t:genericpage>