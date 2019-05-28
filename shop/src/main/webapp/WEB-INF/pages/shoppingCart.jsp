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
            else if (cookie.getName().equals("loggedUsername"))
                loggedUsername = cookie.getValue( );

        }
    }
    pageContext.setAttribute("lang", lang);
    pageContext.setAttribute("loggedUsername", loggedUsername);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <!-- Bootstrap styles -->
    <!--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> -->
    <link href="/libs/bootstrap.css" rel="stylesheet"/>
    <link href="/libs/style.css" rel="stylesheet"/>
    <link href="/libs/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link rel="shortcut icon" href="/img/logos/favicon.ico">

    <!-- Add language option-->
    <c:if test="${lang.equals('tr')}">
        <jsp:include page="/languages/tr.jsp" />
    </c:if>
    <c:if test="${lang.equals('en')}">
        <jsp:include page="/languages/en.jsp" />
    </c:if>
    <title>${dashboard_text}</title>

</head>
<body>

<div class="container">
    <jsp:include page="/components/header.jsp" />
    <jsp:include page="/components/navbar.jsp" />

    <div class="row">

        <jsp:include page="/components/sidebar.jsp" />

        <div class="span9">

            <div class="well well-small">
                <h3>Shopping Cart</h3>
                <div class="row-fluid">

                    <table class="table table-bordered table-condensed">
                        <thead>
                        <c:choose>
                            <c:when test="${product_list.size() == 0}">
                                <h1><c:out value = "${noProductInCart}"/></h1>
                                <tr>
                                    <td colspan="6" class="alignR">Total of products:	</td>
                                    <td class="label label-primary"> $${total}</td>
                                </tr>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <th>Product</th>
                                    <th>Description</th>
                                    <th>Total</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${product_list}" var="product">
                                    <tr>
                                        <td><img width="100" src="${product.img_path}" alt=""></td>
                                        <td>${product.name}<br><br></td>
                                        <td>${product.price}</td>
                                        <td>
                                            <form action="/deleteFromShoppingCart" method="post">
                                                <input type="hidden"  name="loggedUsername" value="${loggedUser.username}" placeholder="Search" class="search-query span2">
                                                <input type="hidden"  name="productID" value="${product.id}" placeholder="Search" class="search-query span2">
                                                <button style="background-color: Transparent;">
                                                    X
                                                </button>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <tr>
                                    <td colspan="6" class="alignR">Total of products:	</td>
                                    <td class="label label-primary"> $${total}</td>
                                </tr>
                                <tr>
                                    <td colspan="6" class="alignR"></td>
                                    <td class="label label-primary">
                                        <form action="/payment" method="post">
                                            <input type="hidden"  name="loggedUsername" value="${loggedUser.username}" >
                                            <button style="background-color: Transparent;border:none;">
                                                Pay
                                            </button>
                                        </form>
                                    </td>
                                </tr>
                                </tbody>
                            </c:otherwise>
                        </c:choose>
                    </table>
                </div>
                </ul>
            </div>
        </div>
    </div>


</body>
</html>