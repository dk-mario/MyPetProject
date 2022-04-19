<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>

<h1>Customer offers:</h1>

<a href="/specialist">Home page</a>
<a href="/">Main Page</a>
<br><br><br>

<div>
    <table border="2" with="70%" cellpadding="2">

        <tr>
            <th>Theme</th>
            <th>Specialist</th>
            <th>Accept</th>
        </tr>

        <c:forEach var="order" items="${orders}">
            <tr>
                <td><a href="/specialist/order/${order.id}">${order.theme}</a></td>
                <td><a href="/specialist/customer/${order.customer.id}">${order.customer.user.name}</a></td>
                <td><a href="/specialist/accept/${order.id}">Accept</a></td>
            </tr>
        </c:forEach>

    </table>
</div>

</body>
</html>
