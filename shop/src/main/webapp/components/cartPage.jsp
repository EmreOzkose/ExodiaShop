<%@ page import="com.exodiashop.shop.Service.UserService" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    Cookie cookie = null;
    Cookie[] cookies = null;

    String loggedUsername = "";
    String lang = "";

    // Get an array of Cookies associated with the this domain
    cookies = request.getCookies();

    if( cookies != null ) {
        for (int i = 0; i < cookies.length; i++) {
            cookie = cookies[i];
            System.out.println(cookie.getName());

            if (cookie.getName().equals("lang"))
                lang = cookie.getValue( );
            else if (cookie.getName().equals("loggedUsernameCookie"))
                loggedUsername = cookie.getValue( );

        }
    }
    pageContext.setAttribute("lang", lang);
    pageContext.setAttribute("loggedUsername", loggedUsername);

    UserService userService = new UserService();
    pageContext.setAttribute("loggedUser", userService.getUserByUserName(loggedUsername));
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <!-- Bootstrap styles -->
    <!--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> -->
    <link href="/libs/bootstrap.css" rel="stylesheet"/>
    <link href="/libs/style.css" rel="stylesheet"/>
    <link href="/libs/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link rel="shortcut icon" href="/img/logos/favicon.ico">

</head>
<body>
<div class="span9">

    <div class="well well-small">
        <h3>${Products} </h3>
        <div class="row-fluid">
            <ul class="thumbnails">

                <c:if test="${product_list.size() == 0}">
                    <h1>No Product</h1>
                </c:if>
                <c:forEach items="${product_list}" var="product">
                    <li class="span4" style="width: 30%;">
                        <div class="thumbnail">
                            <a href="product.jsp" class="overlay"></a>
                            <a class="zoomTool" href="/product/${product.id}" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
                            <form action="/product/${product.id}" method="post">
                                <input type="hidden"  name="loggedUsername" value="${loggedUser.username}" placeholder="Search" class="search-query span2">

                                <button style="background-color: Transparent;border: none;outline: none;">
                                    <img src="${product.img_path}" style="height: 200px; width: 150px;" alt="">
                                </button>
                            </form>

                            <div class="caption cntr">
                                <p>${product.name}</p>
                                <p><strong> $${product.price}</strong></p>
                                <h4><div class="shopBtn">
                                    <form action="/add2cart" method="post">
                                        <input type="hidden"  name="loggedUsername" value="${loggedUser.username}" placeholder="Search" class="search-query span2">
                                        <input type="hidden"  name="productID" value="${product.id}" placeholder="Search" class="search-query span2">
                                        <button style="background-color: Transparent;border: none;">
                                            ${Add2Cart}
                                        </button>
                                    </form>

                                </div></h4>
                                <br class="clr">
                            </div>
                        </div>
                    </li>
                </c:forEach>


            </ul>
        </div>
    </div>
</div>

</body>
</html>