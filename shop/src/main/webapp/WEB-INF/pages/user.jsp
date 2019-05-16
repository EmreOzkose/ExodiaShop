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
    <style>

        /* Style the tab */
        .tab {
            overflow: hidden;
            border: 1px solid #ccc;
            background-color: #f1f1f1;
        }

        /* Style the buttons that are used to open the tab content */
        .tab button {
            background-color: inherit;
            float: left;
            border: none;
            outline: none;
            cursor: pointer;
            padding: 14px 16px;
            transition: 0.3s;
        }

        /* Change background color of buttons on hover */
        .tab button:hover {
            background-color: #ddd;
        }

        /* Create an active/current tablink class */
        .tab button.active {
            background-color: #ccc;
        }

        /* Style the tab content */
        .tabcontent {
            display: none;
            padding: 6px 12px;
            border: 1px solid #ccc;
            border-top: none;
        }
    </style>

    <script>
        function openCity(evt, cityName) {
            // Declare all variables
            var i, tabcontent, tablinks;

            // Get all elements with class="tabcontent" and hide them
            tabcontent = document.getElementsByClassName("tabcontent");
            for (i = 0; i < tabcontent.length; i++) {
                tabcontent[i].style.display = "none";
            }

            // Get all elements with class="tablinks" and remove the class "active"
            tablinks = document.getElementsByClassName("tablinks");
            for (i = 0; i < tablinks.length; i++) {
                tablinks[i].className = tablinks[i].className.replace(" active", "");
            }

            // Show the current tab, and add an "active" class to the button that opened the tab
            document.getElementById(cityName).style.display = "block";
            evt.currentTarget.className += " active";
        }

    </script>


</head>
<body>


<div class="container">

    <jsp:include page="/components/header.jsp" />
    <jsp:include page="/components/navbar.jsp" />
    <div class="well well-small">
        <div class="row-fluid">
            <ul class="thumbnails">
                <h1>${loggedUser.name} ${loggedUser.surname}</h1>
            </ul>




            <!-- Tab links -->
            <div class="tab">
                <button class="tablinks" onclick="openCity(event, 'London') " id="defaultOpen">Profile Details</button>
                <c:if test="${loggedUser.role.equals('seller')}">
                    <button class="tablinks" onclick="openCity(event, 'Paris') " >Products</button>
                </c:if>
                <c:if test="${loggedUser.role.equals('seller')}">
                    <button class="tablinks" onclick="openCity(event, 'Rome') " >Orders</button>
                </c:if>
                <c:if test="${loggedUser.role.equals('seller')}">
                    <button class="tablinks" onclick="openCity(event, 'UserTab') " >Users</button>
                </c:if>

            </div>

        <div id="London" class="tabcontent">
            <div class = "profile-table">
                <img src="${loggedUser.profilePhoto}">
                <hr class="softn clr"/>
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
        <div id="UserTab" class="tabcontent">
            <table style="width:100%; text-align:left">
                <tr>
                    <th>Name</th>

                    <th></th>
                    <th></th>
                </tr>

                <c:forEach items="${user_list}" var="user">
                    <tr>
                        <td>${user.username}</td>

                        <td>
                            <form action="/DeleteProduct/${user.getUsername()}" method="post">
                                <button>X</button>
                            </form>
                        </td>
                        
                    </tr>
                </c:forEach>

            </table>

        </div>
        <div id="Paris" class="tabcontent">
            <table style="width:100%; text-align:left">
                <tr>
                    <th>Name</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th></th>
                    <th></th>
                </tr>

                <c:forEach items="${product_list}" var="product">
                    <tr>
                        <td>${product.name}</td>
                        <td>${product.category}</td>
                        <td>${product.price}</td>
                        <td>
                            <form action="/deleteProduct/${product.id}" method="post">
                                <button>X</button>
                                <input type="hidden"  name="loggedUsername" value="${loggedUser.username}" placeholder="Search" class="search-query span2">
                            </form>
                        </td>
                        <td>
                            <form action="/editProduct/${product.id}" method="post">
                                <button>edit</button>
                                <input type="hidden"  name="loggedUsername" value="${loggedUser.username}" placeholder="Search" class="search-query span2">
                            </form>
                        </td>
                    </tr>
                </c:forEach>

            </table>

        </div>
        <div id="Rome" class="tabcontent">
            <p>List of orders</p>
        </div>
    </div>

    <script>
        // Get the element with id="defaultOpen" and click on it
        document.getElementById("defaultOpen").click();
    </script>






</body>
</html>

