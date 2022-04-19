<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Customer</title>
</head>

<body>

<h1>Add order</h1>
<a href="customer/orders">My orders</a>
<a href="/customer">Home Page</a>
<br><br><br>

<div>
    <form:form method="POST" modelAttribute="order">

        Theme:
        <div>
            <form:input type="text" path="theme" placeholder="Theme" autofocus="true"></form:input>
        </div>

        Subject:
        <div>
            <form:input type="text" path="subject" placeholder="Subject" autofocus="true"></form:input>
        </div>

        Price:
        <div>
            <form:input path="price" placeholder="Price"></form:input>
        </div>

        <button type="submit">Add order</button>
    </form:form>

</div>

</body>
</html>


