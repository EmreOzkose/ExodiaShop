<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="UTF-8">
</head>
<body>
<div class="navbar">
    <div class="navbar-inner">
        <div class="container">
            <a data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <div class="nav-collapse">
                <ul class="nav">
                    <li class="active"><a href="/dashboard">Home ${loggedUser.username} </a></li>
                </ul>

                <form action="/search" class="navbar-search pull-left" method="post">
                    <input type="text"  name="criteria" placeholder="Search" class="search-query span2">
                    <input type="hidden"  name="loggedUsername" value="${loggedUser.username}" placeholder="Search" class="search-query span2">

                </form>

                <ul class="nav pull-right">

                    <c:if test="${loggedUser==null}">
                        <button class="log" onclick ="location.href='/login'">Sign in</button>
                        <button  class="log" onclick ="location.href='/register'">Sign up</button>
                    </c:if>

                    <c:if test="${loggedUser!=null}">
                        <button class="log" onclick ="location.href='/users/${loggedUser.username}'">Account</button>
                    </c:if>

                </ul>
            </div>
        </div>
    </div>
</div>

</body>
</html>
