<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
                <button class="tablinks" onclick="openCity(event, 'London') " id="defaultOpen0">Profile Details</button>
                <c:if test="${loggedUser.role.equals('seller')}">
                    <button class="tablinks" onclick="openCity(event, 'ProductTab') " id="defaultOpen1">Products</button>
                    <button class="tablinks" onclick="openCity(event, 'Galler')">Add Product</button>
                    <button class="tablinks" onclick="openCity(event, 'Rome') " >Orders</button>
                </c:if>
                <c:if test="${loggedUser.role.equals('admin')}">
                    <button class="tablinks" onclick="openCity(event, 'ProductTab') " id="defaultOpen1">Products</button>
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
                                            <tr class="techSpecRow"><td class="techSpecTD1">Password:</td><td class="techSpecTD2"><input required="required" type="password" name="newPassword" value="${loggedUser.password}" placeholder ="Enter new password" id="password" /></td></tr>
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
                                <form action="/DeleteUser/${user.getUsername()}" method="post">
                                    <button>X</button>
                                </form>
                            </td>

                        </tr>
                    </c:forEach>

                </table>

            </div>
            <div id="ProductTab" class="tabcontent">
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
            <div id="Galler" class="tabcontent">
                <form id="loorm" action="/addProduct/${loggedUser.username}" method="POST">
                    <table>
                        <tr>
                            <td>Name</td>
                            <td><input required="required" path="name" name="name" id="me" placeholder ="Product Name"/></td>
                            <td><errors path="name" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td>Gender</td>
                            <td><input required="required" path="gender" name="gender" id="gender" placeholder ="Gender"/></td>
                            <td><errors path="gender" cssClass="error" /></td>
                        </tr>

                        <tr>
                            <td>Brand</td>
                            <td><input required="required" path="brand" name="brand" id="brand" placeholder ="Brand"/></td>
                            <td><errors path="brand" cssClass="error" /></td>
                        </tr>

                        <tr>
                            <td>Color</td>
                            <td><input required="required" path="color" name="color" id="color" placeholder ="Color"/></td>
                            <td><errors path="color" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td>Type</td>
                            <td><input required="required" path="type" name="type" id="type" placeholder ="Type"/></td>
                            <td><errors path="type" cssClass="error" /></td>
                        </tr>

                        <tr>
                            <td>Category</td>
                            <td><input required="required" path="category" name="category" id="category" placeholder ="Category"/></td>
                            <td><errors path="brand" cssClass="error" /></td>
                        </tr>

                        <tr>
                            <td>Size</td>
                            <td><input required="required" path="size" name="size" id="size" placeholder ="Size"/></td>
                            <td><errors path="size" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td>Image</td>
                            <td><input required="required" path="img_path" name="img_path" id="img_path" placeholder ="Image"/></td>
                            <td><errors path="img_path" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td>Price</td>
                            <td><input required="required" path="price" name="price" id="price" placeholder ="Price"/></td>
                            <td><errors path="price" cssClass="error" /></td>
                        </tr>

                        <tr>
                            <td>Number of Stock</td>
                            <td><input required="required" path="total" name="total" id="total" placeholder ="Stock"/></td>
                            <td><errors path="total" cssClass="error" /></td>
                        </tr>
                    </table>

                    <p>  <button type="submit" class="shopBtn"> Add </button></p>
                </form>

            </div>

        <script>
            // Get the element with id="defaultOpen" and click on it
            var url = window.location.href;
            var arr = url.split('#');

            if (arr.length == 1) {
                document.getElementById("defaultOpen0").click();
            } else{
                if (arr[1] == "ProductTab"){
                    document.getElementById("defaultOpen1").click();
                }
            }
        </script>

        </div>
    </div>


</body>
</html>

