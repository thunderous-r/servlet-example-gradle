<%--
  Created by IntelliJ IDEA.
  User: t_rav
  Date: 28.08.2024
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Products</title>
    <link rel="stylesheet" media="screen" href="../css/index.css">
</head>
<body>
<div class="container">
    <div class="card">
        <h2>Add product</h2>
        <form method="post">
            <input type="text" id="name" name="name" placeholder="Specify a product name" required>
            <input type="text" id="imgSrc" name="imgSrc" placeholder="Product image link" required>
            <button type="submit">Add</button>
        </form>
    </div>
    <c:forEach var="product" items="${requestScope.products}">
        <p>${product.name}</p>
        <img src="${product.imgSrc}" height="150px" alt="${product.name}">
        <form action="/secure/products">
            <input type="hidden" name="_method" value="DELETE"/>
            <input type="hidden" name="productId" value="${product.id}"/>
            <button type="submit">Delete</button>
        </form>
    </c:forEach>
</div>
</body>
</html>
