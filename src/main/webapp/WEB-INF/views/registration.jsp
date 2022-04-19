<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Registration</title>
</head>

<body>

<h1>Registration</h1>
<a href="/">Main</a>
<br><br><br>

<div>
    <form:form method="POST" modelAttribute="userForm">

        Name:
        <div>
            <form:input type="text" path="name" placeholder="Name" autofocus="true"></form:input>
            <form:errors path="username"></form:errors>
                ${usernameError}
        </div>

        Login:
        <div>
            <form:input type="text" path="login" placeholder="Login" autofocus="true"></form:input>
            <form:errors path="username"></form:errors>
                ${usernameError}
        </div>

        Age:
        <div>
            <form:input path="age" placeholder="Age"></form:input>
        </div>

        City:
        <div>
            <form:input path="city" placeholder="City"></form:input>
        </div>

        Bio:
        <div>
            <form:input path="bio" placeholder="Bio"></form:input>
        </div>

        Password:
        <div>
            <form:input type="password" path="password" placeholder="Password"></form:input>
        </div>

        Role:
        <div>
            Specialist<form:radiobutton path="role" value="SPECIALIST"/>
            Client<form:radiobutton path="role" value="CUSTOMER"/>
        </div>

        <button type="submit">Register</button>
    </form:form>

</div>
</body>
</html>