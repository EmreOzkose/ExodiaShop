<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: eramas
  Date: 11.05.2019
  Time: 00:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>
    <!-- Bootstrap styles -->
    <link href="/libs/bootstrap.css" rel="stylesheet"/>
    <link href="/libs/style.css" rel="stylesheet"/>

    <link href="/css/register.css" rel="stylesheet" type="text/css"/>


</head>
<body>
<div class="register">
    <form:form id="regForm" action="registerProcess" method="post">
        <img src="/img/logos/exodia-cursive.png" alt="exodia shop">
        <h1> Sign Up </h1>
        <table align="center">

            <tr>
            <tr>
                <td><label path="Name">Name</label></td>
            </tr>

            <td><input required="required" path="Name" name="name"	id="Name" placeholder ="Name"/></td>
            <td><errors path="Name" cssClass="error" /></td>
            </tr>

            <tr>
            <tr><td><label path="surname">Surname</label></td></tr>
            <td><input required="required" path="surname" name="surname" id="surname" placeholder ="Surname"/></td>
            <td><errors path="surname" cssClass="error" /></td>
            </tr>
            <tr>
            <tr><td><label path="username">Username</label></td></tr>
            <td><input required="required"   path="username" name="username" id="username" placeholder ="Username"/></td>
            <td><errors path="username" cssClass="error" /></td>
            </tr>
            <tr>
            <tr><td><label path="password">Password</label></td></tr>
            <td><input required="required" path="password" name="password"	id="password" placeholder ="Password"/></td>
            <td><errors path="password" cssClass="error" /></td>
            </tr>

            <tr>
            <tr><td><label path="dateofbirth">Date Of Birth</label></td></tr>
            <td><input path="dateofbirth" name="dateofbirth" id="dateofbirth" placeholder ="DD-MM-YYYY"/></td>
            <td><errors path="dateofbirth" cssClass="error" /></td>
            </tr>
            <tr>
            <tr><td><label path="gender">Gender</label></td></tr>
            <td><input required="required" path="gender" name="gender" id="gender" placeholder ="Gender"/></td>
            <td><errors path="gender" cssClass="error" /></td>
            </tr>

            <tr>
            <tr><td><label path="email">Email</label></td></tr>
            <td><input required="required" path="email" name="email" id="email" placeholder = "Email"/></td>
            <td><errors path="email" cssClass="error" /></td>
            </tr>
            <tr>
            <tr><td><label path="address">Address</label></td></tr>
            <td><input path="address" name="address" id="address" placeholder ="Address"/></td>
            <td><errors path="address" cssClass="error" /></td>
            </tr>
            <tr>
            <tr><td><label path="phonenumber">Phone Number</label></td></tr>
            <td><input  path="phonenumber" name="phonenumber" id="phonenumber" placeholder ="Phone number"/></td>
            <td><errors path="phonenumber" cssClass="error" /></td>
            </tr>
            <tr>

            <tr>
            <tr><td><button id="register" name="register">Register</button></td></tr>

            </tr>
            <tr></tr>

            <tr>
            <tr></tr>
            <tr><td><a href="/dashboard">Home</a></td></tr>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
