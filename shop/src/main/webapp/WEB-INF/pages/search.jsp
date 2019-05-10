<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: eramas
  Date: 10.05.2019
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Searching .. </title>
    <!-- Bootstrap styles -->
    <link href="libs/bootstrap.css" rel="stylesheet"/>
    <link href="/libs/style.css" rel="stylesheet"/>
    <link rel="shortcut icon" href="/img/logos/favicon.ico">
</head>
<body>
<c:if test="${product_list.size() == 0}">
    <h1>No Product</h1>
</c:if>

<c:forEach items="${product_list}" var="product">
    <li class="span4">
        <div class="thumbnail">
            <a href="product.jsp" class="overlay"></a>
            <a class="zoomTool" href="/product/${product.id}" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
            <a href="/product/${product.id}"><img src="${product.img_path}" alt=""></a>
            <div class="caption cntr">
                <p>${product.name}</p>
                <p><strong> $${product.price}</strong></p>
                <h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>
                <br class="clr">
            </div>
        </div>
    </li>
</c:forEach>
</body>
</html>
