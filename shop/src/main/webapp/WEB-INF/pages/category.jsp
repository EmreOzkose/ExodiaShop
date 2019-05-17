<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: eramas
  Date: 10.05.2019
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${category_name}</title>

    <!-- Bootstrap styles -->
    <!--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> -->
    <link href="/libs/bootstrap.css" rel="stylesheet"/>
    <link href="/libs/style.css" rel="stylesheet"/>
    <link href="/libs/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link rel="shortcut icon" href="/img/logos/favicon.ico">

</head>
<body>
<div class="container">
    <jsp:include page="/components/header.jsp" />
    <jsp:include page="/components/navbar.jsp" />





    <div class="row">

        <jsp:include page="/components/sidebar.jsp" />
        <jsp:include page="/components/cartPage.jsp" />

    </div>


</body>
</html>
