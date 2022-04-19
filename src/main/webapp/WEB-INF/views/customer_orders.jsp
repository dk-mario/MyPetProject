<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>

<h1>Orders:</h1>

<a href="/customer">Home page</a>
<a href="/">Main Page</a>
<br><br><br>

<div>
    <table border="2" with="70%" cellpadding="2">

        <tr>
            <th>Theme</th>
            <th>Subject</th>
            <th>Price</th>
            <th>Order info</th>
        </tr>

        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.theme}</td>
                <td>${order.subject}</td>
                <td>${order.price}</td>
                <td><a href="/customer/order/${order.id}">See order</a></td>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>

</body>
</html>

