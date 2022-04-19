<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>

<h1>Specialist:</h1>

<a href="/customer">Home page</a>
<a href="/">Main Page</a>
<br><br><br>

<div>
    <table border="2" with="70%" cellpadding="2">

        <tr>
            <th>Name</th>
            <th>BIO</th>
            <th>City</th>
            <th>Age</th>
        </tr>

        <tr>
            <td>${user.name}</td>
            <td>${user.bio}</td>
            <td>${user.city}</td>
            <td>${user.age}</td>
        </tr>

    </table>

</div>

</body>

</html>

