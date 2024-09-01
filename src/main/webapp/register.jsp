<%--
  Created by IntelliJ IDEA.
  User: t_rav
  Date: 28.08.2024
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html style="font-size: 16px;" lang="ru">
<head>
    <title>Registration</title>
    <link rel="stylesheet" media="screen" href="/css/index.css">
</head>

<body>

<div class="container">
    <div class="card">
        <h2>Registration</h2>
        <form method="post">
            <input type="text" id="username" name="username" placeholder="Username" required>
            <input type="password" id="password" name="password" placeholder="Password" required>
            <button type="submit">Register</button>
        </form>
        <p><a href="/login">Already have an account? Login here</a></p>
    </div>
</div>

</body></html>
