<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Exodia Dashboard</title>

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

</head>
<body>





<div class="container">
    <jsp:include page="/components/header.jsp" />
    <jsp:include page="/components/navbar.jsp" />

    <div class="row">

        <jsp:include page="/components/sidebar.jsp" />

        <div class="span9">

            <div class="well well-small">
                <h3>${Payment} </h3>
                <div class="row-fluid">
                    <form:form id="regForm" action="paymentProcess" method="post">

                        <div class="col-50">
                            <div class="icon-container">
                                <i class="fa fa-cc-visa" style="color:navy;"></i>
                                <i class="fa fa-cc-amex" style="color:blue;"></i>
                                <i class="fa fa-cc-mastercard" style="color:red;"></i>
                                <i class="fa fa-cc-discover" style="color:orange;"></i>
                            </div>
                            <div class="cardCol">
                                <label for="cname">Name on Card</label>
                                <input type="text" id="cname" name="cardname" placeholder="John More Doe">
                                <label for="ccnum">Credit card number</label>
                                <input type="text" id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444">
                            </div>
                            <div class="cardCol">
                                <label for="expmonth">Expiration Month</label>
                                <input type="text" id="expmonth" name="expmonth" placeholder="September">


                                <label for="expyear">Expiration Year</label>
                                <input type="text" id="expyear" name="expyear" placeholder="2018">
                            </div>
                            <div class="cardCol">
                                <label for="cvv">CVV</label>
                                <input type="text" id="cvv" name="cvv" placeholder="352">
                            </div>

                            <form action="/deleteFromShoppingCart" method="post">
                                <input type="hidden"  name="loggedUsername" value="${loggedUser.username}" placeholder="Search" class="search-query span2">
                                <input type="hidden"  name="productID" value="${product.id}" placeholder="Search" class="search-query span2">
                                <button style="background-color: Transparent;">
                                    Pay
                                </button>
                            </form>

                        </div>
                    </form:form>

                </div>
            </div>
        </div>

    </div>

</body>
</html>