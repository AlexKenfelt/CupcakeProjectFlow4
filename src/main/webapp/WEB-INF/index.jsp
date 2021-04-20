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

        <div id="body" class="container" style="min-height: 20vh;">
        <img src="${pageContext.request.contextPath}/images/logo2.PNG" class ="img-fluid mb-4"/>

        <div>
            <h2>Velkommen til smil og søde sager</h2>

            <p>Vælg lige din perfekte cupcake sammensætning:</p>

            <div class="row" >
                <div class="col">
                    <label for="bottom">Vælg bund</label> <br>
                        <select name="cupcake" id="bottom">
                            <c:forEach var="bottom" items="${applicationScope.bottomList}">
                                <option value="${bottom.id}">${bottom.name} DKK ${bottom.price},-</option>
                            </c:forEach>
                        </select>
                </div>
                <div class="col">
                    <label for="topping">Vælg topping</label> <br>
                    <select name="cupcake" id="topping">
                        <c:forEach var="topping" items="${applicationScope.toppingList}">
                            <option value="${topping.id}">${topping.name} DKK ${topping.price},-</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col">
                    <label>Vælg antal</label> <br>
                    <select>
                        <option>1</option>
                        <option>2</option>
                        <option>4</option>
                        <option>5</option>
                        <option>10</option>
                        <option>15</option>
                    </select>
                </div>

            </div>

            <c:if test="${sessionScope.role == 'employee' }">
                <p style="font-size: larger">This is what you can do,
                    since your are logged in as an employee</p>
                 <p><a href="fc/employeepage">Employee Page</a>
             </c:if>

             <c:if test="${sessionScope.role == 'customer' }">
                <p style="font-size: larger">This is what you can do, since your
                    are logged in as a customer</p>
                <p><a href="fc/customerpage">Customer Page</a>
            </c:if>

        </div>

    </jsp:body>
</t:genericpage>