<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>
        <jsp:invoke fragment="header"/>
    </title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/styles.css">
    <meta name="theme-color" content="#7952b3">
    <script src="https://kit.fontawesome.com/c5d38df5c3.js" crossorigin="anonymous"></script>
</head>
<body>
<!--
    This header is inspired by this bootstrap
    example: https://getbootstrap.com/docs/5.0/examples/pricing/
-->

<header class="d-flex flex-column flex-md-row align-items-center p-3 pb-0 px-md-4 mb-4 bg-white border-bottom shadow-sm">
    <div class="h5 my-0 me-md-auto fw-normal">
    </div>
    <nav class="my-2 my-md-0 me-md-3">
        <c:if test="${addHomeLink == null }">
            <a class="p-2 text-dark" href="${pageContext.request.contextPath}/fc/index">Hjem</a>
        </c:if>
        <c:if test="${sessionScope.user.role.equals('employee')}">
        <a class="p-2 text-dark" href="${pageContext.request.contextPath}/fc/orderspage">Orders</a>
        </c:if>
        <a class="p-2 text-dark" href="${pageContext.request.contextPath}/fc/cartpage">
            <i class="fas fa-shopping-cart" style="color: #3C1461"></i>
        </a>

    </nav>

    <div>

        <c:if test="${sessionScope.user != null }">
            ${sessionScope.user.email}
        </c:if>

        <c:set var="thisPage" value="${pageContext.request.servletPath}"/>
        <c:set var="isNotLoginPage" value="${!fn:endsWith(thisPage,'loginpage.jsp')}"/>
        <c:set var="isNotRegisterPage" value="${!fn:endsWith(thisPage,'registerpage.jsp')}"/>

        <c:if test="${isNotLoginPage && isNotRegisterPage}">
        <c:if test="${sessionScope.user != null }">
            <a type="button" class="btn btn-sm  btn-outline-secondary"
               href="${pageContext.request.contextPath}/fc/logoutcommand">Logout</a>
        </c:if>
        <c:if test="${sessionScope.user == null }">
            <a type="button" class="btn btn-sm  btn-outline-secondary"
               href="${pageContext.request.contextPath}/fc/loginpage">Login</a>
            <a type="button" class="btn btn-sm  btn-outline-secondary"
               href="${pageContext.request.contextPath}/fc/registerpage">Sign up</a>
        </c:if>
    </div>
    </c:if>
</header>

<div id="." class="container" style="min-height: 20vh;">
    <img src="${pageContext.request.contextPath}/images/logo3.PNG" class="img-fluid mb-4"/>
    <div/>

    <div id="body" class="container" style="min-height: 20vh;">
        <jsp:doBody/>
    </div>

    <!-- Footer -->
    <footer>

        <br>
        <hr>
        <br>
        <h4>Kontakt</h4>
        <p>
            Email - cupcake@email.com <br>
            Tlf. - 10111213 <br>
            Adr. - Olsker cupcakes 1 <br>
        </p>

        <jsp:invoke fragment="footer"/>
    </footer>
</div>
</body>
</html>