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
                <div id="sidebar" class="span3">
                    <div class="well well-small">
                        <ul class="nav nav-list">
                            <li><a href="products.html"><span class="icon-chevron-right"></span>Products</a></li>
                            <li><a href="products.html"><span class="icon-chevron-right"></span>Orders</a></li>
                            <li><a href="products.html"><span class="icon-chevron-right"></span>Customers</a></li>
                            <li><a href="products.html"><span class="icon-chevron-right"></span>Sellers</a></li>
                            <li style="border:0"> &nbsp;</li>

                        </ul>
                    </div>

                </div>
            </div>
            <div class="col-md-10">

                <ul class="thumbnails">
                    <h2>Admin view</h2>

                </ul>
            </div>
        </div>
    </div>
</div>

</body>
</html>