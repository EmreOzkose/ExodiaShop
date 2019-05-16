<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>${loggedUser.username} profile</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Bootstrap styles -->
    <link href="/libs/bootstrap.css" rel="stylesheet"/>
    <link href="/libs/style.css" rel="stylesheet"/>
    <link href="/libs/font-awesome/css/font-awesome.css" rel="stylesheet">

    <link rel="shortcut icon" href="/img/logos/favicon.ico">

    <style>
        .viewButton {
            display: inline-block;
            border-radius: 4px;
            border: none;
            text-align: left;
            padding: 0px 20px;
            transition: all 0.5s;
            cursor: pointer;
            margin: 0px 0px;
            background-color: rgba(255, 255, 255, .0);
        }

    </style>

</head>
<body>

<div class="container">
    <div id="gototop"> </div>

    <jsp:include page="/components/header.jsp" />
    <jsp:include page="/components/navbar.jsp" />


    <!--
    Body Section
    -->
            <div class="row">
                <div id="sidebar" class="span3">
                    <div class="well-well-small">
                        <ul class="nav nav-list">

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
                    <h1>${loggedUser.name} ${loggedUser.surname}</h1>
                </ul>
                <div class = "profile-table">
                    <hr class="softn clr"/>

                    <ul id="productDetl" class="nav nav-tabs">
                        <li class="active">
                            <form action="/users/${loggedUser.username}" method="post">
                                <button class="viewButton">Profile Details</button>
                                <input type="hidden"  name="loggedUsername" value="${loggedUser.username}" placeholder="Search" class="search-query span2">
                            </form>
                        </li>

                        <li>
                            <c:if test="${loggedUser.role.equals('admin')}">
                                <form action="/adminView" method="post">
                                    <button class="viewButton">Admin View</button>
                                    <input type="hidden"  name="loggedUsername" value="${loggedUser.username}" placeholder="Search" class="search-query span2">

                                </form>
                            </c:if>
                        </li>

                        <li>
                            <c:if test="${loggedUser.role.equals('seller')}">
                                <form action="/sellerView" method="post">
                                    <button class="viewButton">Seller View</button>
                                    <input type="hidden"  name="loggedUsername" value="${loggedUser.username}" placeholder="Search" class="search-query span2">
                                </form>
                            </c:if>
                        </li>
                    </ul>

                    <img src="${loggedUser.profilePhoto}">
                    <div id="myTabContent" class="tab-content tabWrapper">
                        <div class="tab-pane fade active in" id="home">

                            <c:choose>
                                <c:when test="${isEdit == 1}">
                                    <form id="loginForm" action="/users/${loggedUser.username}/editProfileProcess" method="POST">

                                        <table class="table table-striped">
                                            <tbody>
                                            <tr class="techSpecRow"><td class="techSpecTD1">Username:</td><td class="techSpecTD2"><input required="required" type="text" name="newUsername"  value="${loggedUser.username}" placeholder ="Enter new username" id="username" /></td></tr>
                                            <tr class="techSpecRow"><td class="techSpecTD1">Name: </td><td class="techSpecTD2"><input required="required" type="text" name="newName" value="${loggedUser.name}" placeholder ="Enter new name" id="name" /></td></tr>
                                            <tr class="techSpecRow"><td class="techSpecTD1">Surname:</td><td class="techSpecTD2"><input required="required" type="text" name="newSurname" value="${loggedUser.surname}" placeholder ="Enter new surname" id="surname" /></td></tr>
                                            <tr class="techSpecRow"><td class="techSpecTD1">Email: </td><td class="techSpecTD2"><input required="required" type="text" name="newEmail" value="${loggedUser.email}" placeholder ="Enter new email" id="email" /></td></tr>
                                            <tr class="techSpecRow"><td class="techSpecTD1">Password:</td><td class="techSpecTD2"><input required="required" type="text" name="newPassword"  placeholder ="Enter new password" id="password" /></td></tr>
                                            <tr class="techSpecRow"><td class="techSpecTD1"></td><td class="techSpecTD2"><button id="login" name="login">Apply</button></td></tr>

                                            </tbody>
                                        </table>

                                    </form>
                                </c:when>
                                <c:otherwise>
                                    <table class="table table-striped">
                                        <tbody>
                                        <tr class="techSpecRow"><td class="techSpecTD1">Username:</td><td class="techSpecTD2">${loggedUser.username}</td></tr>
                                        <tr class="techSpecRow"><td class="techSpecTD1">Name: </td><td class="techSpecTD2">${loggedUser.name}</td></tr>
                                        <tr class="techSpecRow"><td class="techSpecTD1">Surname:</td><td class="techSpecTD2">${loggedUser.surname}</td></tr>
                                        <tr class="techSpecRow"><td class="techSpecTD1">Email: </td><td class="techSpecTD2">${loggedUser.email}</td></tr>
                                        <tr class="techSpecRow"><td class="techSpecTD1">Password:</td><td class="techSpecTD2">**********</td></tr>
                                        </tbody>
                                    </table>
                                    <form id="loginForm" action="/users/${loggedUser.username}/editProfile#home" method="POST">
                                        <p>  <button type="submit" class="shopBtn">> Edit Profile </button></p>
                                    </form>
                                </c:otherwise>
                            </c:choose>
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

