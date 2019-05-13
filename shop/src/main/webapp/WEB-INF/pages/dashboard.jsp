<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Exodia Dashboard</title>

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
                <jsp:include page="/components/sidebar.jsp" />
            </div>
            <div class="col-md-10">
                <h3>Products </h3>
                <ul class="thumbnails">

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
                                    <form id="loginForm" action="/add2cart?username=${loggedUser.username}&productID=${product.id}" method="POST">
                                        <table align="center">
                                            <td align="center"><button id="login" name="add2cartbtn">Add to cart</button></td>
                                        </table>
                                    </form>

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


</body>
</html>