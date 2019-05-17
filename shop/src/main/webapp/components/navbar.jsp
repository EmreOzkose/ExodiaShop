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

                <table style="width:100%">
                    <tr>
                        <th style="padding: 0px; margin: 0px;">
                            <form action="/dashboard" method="post" >
                                <ul class="nav" style="padding: 0px; margin: 0px;">
                                    <input type="hidden"  name="loggedUsername" value="${loggedUser.username}" placeholder="Search" class="search-query span2">

                                    <li class="active"><a href="/dashboard"><button style="padding:0px;margin: 0%;background-color: Transparent;border:none;">Home ${loggedUser.username}</button> </a></li>
                                </ul>
                            </form>
                        </th>
                        <th>
                            <form action="/search" class="navbar-search pull-left" method="post">
                                <input type="text"  name="criteria" placeholder="Search" class="search-query span2">
                                <input type="hidden"  name="loggedUsername" value="${loggedUser.username}" placeholder="Search" class="search-query span2">

                            </form>
                        </th>
                        <th>
                            <ul class="nav pull-right">

                                <c:if test="${loggedUser==null}">
                                    <button style="display:inline-block;" class="log" onclick ="location.href='/login'">Sign in</button>
                                    <button style="display:inline-block;" class="log" onclick ="location.href='/register'">Sign up</button>
                                </c:if>

                                <c:if test="${loggedUser!=null}">

                                    <button class="log" style="float: right; " onclick ="location.href='/users/${loggedUser.username}'">Account</button>
                                    <button class="log" style="float: right;" onclick ="location.href='/'">Logout</button>
                                </c:if>

                            </ul>
                        </th>
                    </tr>
                </table>






            </div>
        </div>
    </div>
</div>

</body>
</html>
