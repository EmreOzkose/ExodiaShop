<%--
  Created by IntelliJ IDEA.
  User: eramas
  Date: 10.05.2019
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>${user.name} profile</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Bootstrap styles -->
    <link href="/libs/bootstrap.css" rel="stylesheet"/>
    <link href="/libs/style.css" rel="stylesheet"/>

    <!-- font awesome styles -->
    <link href="/libs/font-awesome/css/font-awesome.css" rel="stylesheet">

    <!-- Favicons -->
    <link rel="shortcut icon" href="/img/logos/favicon.ico">
</head>
<body>
<!--
	Upper Header Section
-->


<!--
Lower Header Section
-->
<div class="container">
    <div id="gototop"> </div>
    <header id="header">
        <div class="row">
            <div class="span4">
                <h1>
                    <a class="logo" href="/dashboard">
                        <img src="/img/logos/exodia-cursive.png">
                    </a>
                </h1>
            </div>
            <div class="span4">
                <div class="offerNoteWrapper">
                    <h1 class="dotmark">
                        <i class="icon-cut"></i>
                    </h1>
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
                        <li class="active"><a href="grid-view.html">Home</a></li>


                    </ul>
                    <form action="#" class="navbar-search pull-left">
                        <input type="text" placeholder="Search" class="search-query span2">
                    </form>
                    <ul class="nav pull-right">
                        <li class="dropdown">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#"> My account </a>
                            <div class="dropdown-menu">
                                <form class="form-horizontal loginFrm">

                                    <div class="control-group">
                                        <input type="text" class="span2" id="inputEmail" placeholder="Email">
                                    </div>
                                    <div class="control-group">
                                        <input type="password" class="span2" id="inputPassword" placeholder="Password">
                                    </div>
                                    <div class="control-group">
                                        <label class="checkbox">
                                            <input type="checkbox"> Remember me
                                        </label>
                                        <button type="submit" class="shopBtn btn-block">Sign in</button>
                                    </div>
                                </form>
                            </div>
                        </li>
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
            <div class="well-well-small">
                <ul class="nav nav-list">
                    <li><a href="products.html"><span class="icon-chevron-right"></span>Profile </a></li>
                    <li><a href="products.html"><span class="icon-chevron-right"></span>Orders</a></li>
                    <li><a href="products.html"><span class="icon-chevron-right"></span>Settings</a></li>


                    <li style="border:0"> &nbsp;</li>

                </ul>
            </div>





        </div>
        <div class="span9">

            <!-------------------------------------------------------------------------------------
            New Products

            Clients
            -->


        </div><!-- /container -->
        <div class="well well-small">

            <div class="row-fluid">
                <ul class="thumbnails">
                    <h1>${user.name}</h1>
                </ul>
                <div class = "profile-table">
                    <hr class="softn clr"/>


                    <ul id="productDetail" class="nav nav-tabs">
                        <li class="active"><a href="#home" data-toggle="tab">Profile Details</a></li>


                    </ul>
                    <div id="myTabContent" class="tab-content tabWrapper">
                        <div class="tab-pane fade active in" id="home">
                            <table class="table table-striped">
                                <tbody>
                                <tr class="techSpecRow"><td class="techSpecTD1">Username:</td><td class="techSpecTD2">${user.username}</td></tr>
                                <tr class="techSpecRow"><td class="techSpecTD1">Name: </td><td class="techSpecTD2">${user.name}</td></tr>
                                <tr class="techSpecRow"><td class="techSpecTD1">Surname:</td><td class="techSpecTD2">${user.surname}</td></tr>
                                <tr class="techSpecRow"><td class="techSpecTD1">Email: </td><td class="techSpecTD2">${user.email}</td></tr>
                                <tr class="techSpecRow"><td class="techSpecTD1">Password:</td><td class="techSpecTD2">**********</td></tr>
                                </tbody>
                            </table>

                            <p>  <button type="submit" class="shopBtn">> Edit Profile </button></p>
                        </div>
                    </div>



                </div>
            </div>
        </div>

        <a href="#" class="gotop"><i class="icon-double-angle-up"></i></a>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="assets/js/jquery.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.easing-1.3.min.js"></script>
        <script src="assets/js/jquery.scrollTo-1.4.3.1-min.js"></script>
        <script src="assets/js/shop.js"></script>
</body>
</html>

