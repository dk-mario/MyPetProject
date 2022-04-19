<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>

<h1>Order:</h1>

<a href="/specialist">Home page</a>
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
        </tr>

    </table>
</div>

</body>
</html>

