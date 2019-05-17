
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Searching .. </title>
    <!-- Bootstrap styles -->
    <link href="libs/bootstrap.css" rel="stylesheet"/>
    <link href="/libs/style.css" rel="stylesheet"/>
    <link rel="shortcut icon" href="/img/logos/favicon.ico">
</head>
<body>


<!--
Lower Header Section
-->
<div class="container">
    <div id="gototop"> </div>


    <jsp:include page="/components/header.jsp" />
    <jsp:include page="/components/navbar.jsp" />



    <div class="container">
        <div class="row">
            <div class="col-md-2">
                <jsp:include page="/components/sidebar.jsp" />
            </div>

            <c:if test="${product_list.size() == 0}">
                <h1>No related item</h1>
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


        </div>




    </div>


</body>
</html>


