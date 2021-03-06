<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Login page
    </jsp:attribute>

    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <div align="center" class="align-content-center">
            <h2 style="text-align: center"> Login </h2>
            </br>
            <form name="login" action="${pageContext.request.contextPath}/fc/logincommand" method="POST">
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="email">Email</label>
                    <div class="col-sm-4">
                        <input class="form-control" type="text" id="email" name="email" placeholder="someone@nowhere.com">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="password">Password</label>
                    <div class="col-sm-4">
                        <input class="form-control" type="password" id="password" name="password" placeholder="sesam">
                    </div>
                </div>
                <c:if test="${requestScope.error != null }">
                    <p style="color:red">
                            ${requestScope.error}
                    </p>
                </c:if>

                <c:if test="${not empty param.msg}">
                    <p style="font-size: large">${param.msg}</p>
                </c:if>
                <button class="btn mt-3" style="background-color: #3C1461; color: white" value="Login" >Login</button>

                <a type="button" class="btn mt-3" style="background-color: #3C1461; color: white" type="submit"
                   href="${pageContext.request.contextPath}/fc/registerpage">Sign up</a>

                </nav>
            </form>
        </div>
    </jsp:body>
</t:genericpage>
