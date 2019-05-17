<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap styles -->
    <link href="/libs/bootstrap.css" rel="stylesheet"/>
    <link href="/libs/style.css" rel="stylesheet"/>
    <link rel="shortcut icon" href="/img/logos/favicon.ico">

</head>
<body>
<div class="container">
    <jsp:include page="/components/header.jsp" />
    <jsp:include page="/components/navbar.jsp" />
    <div class="row">
        <jsp:include page="/components/sidebar.jsp" />
        <div class="span9" style="background-color:rgba(0, 0, 0, 0.0);">
            <div style="background-color:rgba(0, 0, 0, 0.0);" class="well well-small">
                <div style="background-color:rgba(0, 0, 0, 0.0);" class="row-fluid">
                    <div class="span5">
                        <div id="myCarousel" class="carousel slide cntr">
                            <div class="carousel-inner">
                                <div class="item active">
                                    <a href="#"> <img src="${product.img_path}" alt="" style="width:100%"></a>
                                </div>
                            </div>
                            <a class="left carousel-control" href="#myCarousel" data-slide="prev">‹</a>
                            <a class="right carousel-control" href="#myCarousel" data-slide="next">›</a>
                        </div>
                    </div>
                    <div class="span7" style="background-color:rgba(0, 0, 0, 0.0);">
                        <h3>${product.name} [$${product.price}]</h3>
                        <hr class="soft"/>
                        <br><br>
                        <br><br>
                        <br><br><br><br>
                        <br><br>
                        <h4>${product.total} items in stock</h4>
                        <p>
                            <br><br>

                        </p>
                        <button type="submit" class="shopBtn"><span class=" icon-shopping-cart"></span> Add to cart</button>

                    </div>
                </div>
                <hr class="softn clr"/>
            </div>
        </div>
    </div>
</div>
</body>
</html>
