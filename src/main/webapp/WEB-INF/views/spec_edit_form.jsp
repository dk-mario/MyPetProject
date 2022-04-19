<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
<h1>Edit user</h1>

<form:form method="POST" modelAttribute="user" action="/specialist/edit">
    <table>
        <tr>
            <td></td>
            <td><form:hidden path="id"/></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>City:</td>
            <td><form:input path="city"/></td>
        </tr>
        <tr>
            <td>Bio:</td>
            <td><form:input path="bio"/></td>
        </tr>

        <tr>
            <td>Login:</td>
            <td><form:input path="login"/></td>
        </tr>

        <tr>
            <td></td>
            <td><input type="submit" value="Edit Save"/></td>
        </tr>

    </table>

</form:form>

</body>

</html>

