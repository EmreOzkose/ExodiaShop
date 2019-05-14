<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: eramas
  Date: 11.05.2019
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <!-- Bootstrap styles -->
    <link href="/libs/bootstrap.css" rel="stylesheet"/>
    <link href="/libs/style.css" rel="stylesheet"/>
    <link rel="shortcut icon" href="/img/logos/favicon.ico">
</head>
<body>
<header id="header">
    <div class="row">
        <div class="span4">
            <h1>
                <a class="logo" href="/dashboard">
                    <img src="/img/logos/exodia-cursive.png" alt="exodia logo">
                </a>
            </h1>
        </div>
        <div class="span4">
            <div class="offerNoteWrapper">

            </div>
        </div>
        <div class="span4 alignR">
            <p><br> <strong>          </strong><br><br></p>
            <a href="/checkout/${loggedUser.username}">
                <c:if test="${loggedUser!=null && loggedUser.role == 'customer'}">
                <span class="btn btn-mini">[ ${loggedUser.shoppingCart.size()} ] <span class="icon-shopping-cart"></span></span>
                </c:if>

        </div>
    </div>
</header>
</body>
</html>
