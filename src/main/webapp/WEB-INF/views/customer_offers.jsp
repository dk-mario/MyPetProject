<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>

<h1>Customer offers:</h1>

<a href="/customer">Home page</a>
<a href="/">Main Page</a>
<br><br><br>

<div>
    <table border="2" with="70%" cellpadding="2">

        <tr>
            <th>Theme</th>
            <th>Customer</th>
        </tr>

        <c:forEach var="order" items="${user.customer.orders}">
            <c:forEach var="spec" items="${order.offeredSpecialist}">
                <tr>
                    <td><a href="/customer/order/${order.id}">${order.theme}</a></td>
                    <td><a href="/customer/spec/${spec.id}">${spec.user.name}</a></td>
                </tr>
            </c:forEach>
        </c:forEach>

    </table>
</div>

</body>
</html>
