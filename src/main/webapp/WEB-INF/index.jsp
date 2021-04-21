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
            <h2 style="text-align: center"> Velkommen til smil og søde sager :) </h2> <br>


            <p style="text-align: center">Sammensæt her den cupcake der passer til dig:</p><br>

            <form action="${pageContext.request.contextPath}/fc/addtocart" method="post">

                <div class="row">
                    <div class="col">
                        <label for="bottom">Vælg bund</label> <br>
                        <select name="bottom" id="bottom">
                            <c:forEach var="bottom" items="${applicationScope.bottomList}">
                                <option value="${bottom.id}">${bottom.name} DKK ${bottom.price},-</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col">
                        <label for="topping">Vælg topping</label> <br>
                        <select name="topping" id="topping">
                            <c:forEach var="topping" items="${applicationScope.toppingList}">
                                <option value="${topping.id}">${topping.name} DKK ${topping.price},-</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col">
                        <label for="quantity">Vælg antal</label> <br>
                        <select id="quantity" name="quantity">
                            <option>1</option>
                            <option>2</option>
                            <option>4</option>
                            <option>5</option>
                            <option>10</option>
                            <option>15</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col"></div>
                        <div class="btn mt-3">
                            <button style="background-color: #3C1461; color: white;">Læg i kurv</button>
                        </div>
                        <div class="col"></div>
                    </div>
            </form>

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