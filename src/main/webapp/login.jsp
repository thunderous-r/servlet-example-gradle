<%--
  Created by IntelliJ IDEA.
  User: t_rav
  Date: 28.08.2024
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html style="font-size: 16px;" lang="ru">

<head>
    <title>Login</title>
    <link rel="stylesheet" media="screen" href="/css/index.css">
</head>

<body>
<div class="container">
    <div class="card">
        <h2>Login</h2>
        <form method="post">
            <input type="text" id="username" name="username" placeholder="Username" required>
            <input type="password" id="password" name="password" placeholder="Password" required>
            <button type="submit">Login</button>
            <c:if test="${requestScope.wrongUser == 1}">
                <p>Wrong username or password</p>
            </c:if>
        </form>
        <p><a href="/register">Don't have an account?</a></p>
    </div>
</div>
</body></html>
