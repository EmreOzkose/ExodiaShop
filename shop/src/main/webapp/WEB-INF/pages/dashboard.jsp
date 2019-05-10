<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.exodiashop.shop.Model.User" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Exodia Dashboard</title>

    <!-- Bootstrap styles -->
    <link href="/libs/bootstrap.css" rel="stylesheet"/>
    <link href="/libs/style.css" rel="stylesheet"/>
    <link rel="shortcut icon" href="/img/logos/favicon.ico">


</head>
<body>


<!--
Lower Header Section
-->
<div class="container">
    <div id="gototop"> </div>
    <header id="header">
        <div class="row">
            <div class="span4">
                <h1>
                    <a class="logo" href="index.html">
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
                <span class="btn btn-mini">[ 0 ] <span class="icon-shopping-cart"></span></span>


            </div>
        </div>
    </header>

    <!--
    Navigation Bar Section
    -->
    <div class="navbar">
        <div class="navbar-inner">
            <div class="container">
                <a data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <div class="nav-collapse">
                    <ul class="nav">
                        <li class="active"><a href="grid-view.html">Home ${name}</a></li>


                    </ul>
                    <form action="#" class="navbar-search pull-left">
                        <input type="text" placeholder="Search" class="search-query span2">
                    </form>
                    <ul class="nav pull-right">

                        <button class="log" onclick ="location.href='login'">Sign in</button>

                        <button  class="log" onclick ="location.href='register'">Sign up</button>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!--
    Body Section
    -->


    <div class="row">
        <div id="sidebar" class="span3">
            <div class="well well-small">
                <ul class="nav nav-list">
                    <li><a href="products.jsp"><span class="icon-chevron-right"></span>Women</a></li>
                    <li><a href="products.jsp"><span class="icon-chevron-right"></span>Men</a></li>
                    <li><a href="products.jsp"><span class="icon-chevron-right"></span>Bags & Shoes</a></li>
                    <li><a href="products.jsp"><span class="icon-chevron-right"></span>Clothes</a></li>
                    <li><a href="products.jsp"><span class="icon-chevron-right"></span>Cosmetic</a></li>
                    <li><a href="products.jsp"><span class="icon-chevron-right"></span>Electronics</a></li>

                    <li style="border:0"> &nbsp;</li>
                </ul>
            </div>
        </div>
        <div class="span9">

            <div class="well well-small">
                <h3>Products </h3>
                <div class="row-fluid">
                    <ul class="thumbnails">

                        <c:forEach items="${product_list}" var="product">
                            <li class="span4">
                                <div class="thumbnail">
                                    <a href="product_details.jsp" class="overlay"></a>
                                    <a class="zoomTool" href="product_details.jsp" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
                                    <a href="/WEB-INF/pages/product_details"><img src="${product.img_path}" alt=""></a>
                                    <div class="caption cntr">
                                        <p>${product.name}</p>
                                        <p><strong> $${product.price}</strong></p>
                                        <h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>
                                        <br class="clr">
                                    </div>
                                </div>
                            </li>
                        </c:forEach>

                    </ul>
                </div>

            </div>
        </div>
    </div>

</div>


</body>
</html>