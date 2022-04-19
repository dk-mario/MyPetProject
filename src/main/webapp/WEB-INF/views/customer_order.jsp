<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>

<h1>Order:</h1>

<a href="/customer">Home page</a>
<a href="/">Main Page</a>
<br><br><br>

<div>
    <table border="2" with="70%" cellpadding="2">

        <tr>
            <th>Theme</th>
            <th>Subject</th>
            <th>Price</th>
        </tr>

        <tr>
            <td>${order.theme}</td>
            <td>${order.subject}</td>
            <td>${order.price}</td>
            </td>
        </tr>

    </table>
</div>
<br><br><br>

<div>
    <div>
        <form:form action="/customer/order/${order.id}" method="POST" modelAttribute="subject">
            Enter the subject to find specialist:
            <div>
                <form:input type="text" path="sub" placeholder="Subject" autofocus="true"></form:input>
            </div>
            <button type="submit">Find specialist</button>
        </form:form>
    </div>
</div>
<br><br><br>

<c:choose>
    <c:when test="${specialists.size()>0}">
        <div>
            <table border="2" with="70%" cellpadding="2">

                <tr>
                    <th>Name</th>
                    <th>BIO</th>
                    <th>City</th>
                    <th>Age</th>
                    <th>Offer to specialist</th>
                </tr>

                <c:forEach var="specialist" items="${specialists}">
                    <tr>
                        <td>${specialist.user.name}</td>
                        <td>${specialist.user.bio}</td>
                        <td>${specialist.user.city}</td>
                        <td>${specialist.user.age}</td>
                        <td><a href="/customer/offer/${order.id}/${specialist.id}">offer</a></td>
                    </tr>
                </c:forEach>

            </table>
        </div>
        <br><br><br>
    </c:when>
    <%--    <c:otherwise>
        </c:otherwise>--%>
</c:choose>

</body>

</html>

