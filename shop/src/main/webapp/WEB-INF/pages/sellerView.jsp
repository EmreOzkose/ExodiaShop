<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Exodia Admin Page</title>

    <!-- Bootstrap styles -->
    <!--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> -->
    <link href="/libs/bootstrap.css" rel="stylesheet"/>
    <link href="/libs/style.css" rel="stylesheet"/>
    <link rel="shortcut icon" href="/img/logos/favicon.ico">

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

<!--
Lower Header Section
-->
<div class="container">
    <div id="gototop"> </div>


    <jsp:include page="/components/header.jsp" />
    <jsp:include page="/components/navbar.jsp" />

    <!-- Tab links -->
    <div class="tab">
        <button class="tablinks" onclick="openCity(event, 'London') " id="defaultOpen">Products</button>
        <button class="tablinks" onclick="openCity(event, 'Paris')">Orders</button>
        <button class="tablinks" onclick="openCity(event, 'Galler')">Add Product</button>
    </div>

    <!-- Tab content -->
    <div id="London" class="tabcontent">
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

    <div id="Paris" class="tabcontent">
        <p>List of orders</p>
    </div>


    <div id="Galler" class="tabcontent">
        <form id="loginForm" action="/addProduct/${loggedUser.username}" method="POST">
        <table>
            <tr>
                <td>Name</td>
                <td><input required="required" path="name" name="name" id="name" placeholder ="Product Name"/></td>
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

            <p>  <button type="submit" class="shopBtn"> Edit Product </button></p>
        </form>



    </div>

    <script>
        // Get the element with id="defaultOpen" and click on it
        document.getElementById("defaultOpen").click();
    </script>

    <div class="container">
        <div class="row">
            <div class="col-md-2">
                <div id="sidebar" class="span3">
                    <div class="well well-small">
                        <ul class="nav nav-list">
                            <li><a href="products.html"><span class="icon-chevron-right"></span>Products</a></li>
                            <li><a href="products.html"><span class="icon-chevron-right"></span>Orders</a></li>
                            <li style="border:0"> &nbsp;</li>

                        </ul>
                    </div>

                </div>
            </div>

            <div class="col-md-10">

                <ul class="thumbnails">
                    <h2>Seller view</h2>

                </ul>
            </div>
        </div>
    </div>
</div>

</body>
</html>