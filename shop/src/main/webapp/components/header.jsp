<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--
  Created by IntelliJ IDEA.
  User: eramas
  Date: 11.05.2019
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            //System.out.println(cookie.getName());

            if (cookie.getName().equals("lang"))
                lang = cookie.getValue( );
            else if (cookie.getName().equals("loggedUsername"))
                loggedUsername = cookie.getValue( );

        }
    }
    pageContext.setAttribute("lang", lang);
    pageContext.setAttribute("loggedUsername", loggedUsername);
%>

<html>
<head>
    <title>Title</title>

    <!-- Bootstrap styles -->
    <link href="/libs/bootstrap.css" rel="stylesheet"/>
    <link href="/libs/style.css" rel="stylesheet"/>
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
<header id="header">
    <div class="row">

        <div class="span4">
            <h1>
                <form action="/dashboard" method="post">

                    <input type="hidden"  name="loggedUsername" value="${loggedUser.username}" placeholder="Search" class="search-query span2">
                    <button style="background-color: Transparent;border: none;">
                        <img src="/img/logos/exodia-cursive.png" alt="exodia logo">
                    </button>

                </form>

            </h1>
        </div>
        <div class="span4">
            <div class="offerNoteWrapper">

            </div>
        </div>
        <div class="span4 alignR">
            <p><br> <strong>          </strong><br><br></p>

            <form action="/setLang/en" method="post">
                <input type="hidden"  name="loggedUsername" value="${loggedUser.username}" placeholder="Search" class="search-query span2">
                <button style="background-color: Transparent;border: none;">
                    <span class="btn btn-mini">EN</span>
                </button>
            </form>

            <form action="/setLang/tr" method="post">
                <input type="hidden"  name="loggedUsername" value="${loggedUser.username}" placeholder="Search" class="search-query span2">
                <button style="background-color: Transparent;border: none;">
                    <span class="btn btn-mini">TR</span>
                </button>
            </form>


            <c:if test="${loggedUser!=null && loggedUser.role == 'customer'}">
                <form action="/shoppingCart" method="post">

                    <input type="hidden"  name="loggedUsername" value="${loggedUser.username}" placeholder="Search" class="search-query span2">
                    <button style="background-color: Transparent;border: none;">
                        <span class="btn btn-mini"><span class="icon-shopping-cart"></span></span>
                    </button>

                </form>
            </c:if>

        </div>
    </div>
</header>
</body>
</html>
