<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Specialist worksheet</title>
</head>

<body>
<a href="/specialist">Home page</a>
<a href="/">Main page</a>

<h1>Worksheet</h1>

<div>
    <table border="2" width="70%" cellpadding="2">
        <tr>
            <th>Name</th>
            <th>BIO</th>
            <th>City</th>
            <th>Age</th>
            <th>Edit</th>
        </tr>

        <tr>
            <td>${user.name}</td>
            <td>${user.bio}</td>
            <td>${user.city}</td>
            <td>${user.age}</td>
            <td><a href="/specialist/edit/">Edit</a></td>
        </tr>

    </table>
</div>


</body>

</html>
