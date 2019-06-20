<%@ page import="com.exodiashop.shop.Service.CookieService" %>
<%--
  Created by IntelliJ IDEA.
  User: eramas
  Date: 11.05.2019
  Time: 00:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    CookieService cookieService = new CookieService();
    String loggedUsername = cookieService.getCookie(request, response, "loggedUsernameCookie");
    // pageContext.setAttribute("loggedUsername", loggedUsername);

%>


<html>
<head>
    <title></title>
    <meta http-equiv="Refresh" content="0; url=/users/${loggedUsername}">
</head>
<body>

</body>
</html>
