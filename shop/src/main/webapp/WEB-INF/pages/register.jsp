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
    <link href="/WEB-INF/css/register.css" rel="stylesheet"/>

</head>
<body>
<div class="register">
    <form:form id="regForm" action="registerProcess" method="post">
        <img src="/img/logos/exodia-cursive.png" alt="exodia shop">
        <h1> Sign Up </h1>
        <table align="center">

            <tr>
            <tr>
                <td><form:label path="Name">Name</form:label></td>
            </tr>

            <td><form:input required="required" path="Name" name="name"	id="Name" placeholder ="Name"/></td>
            <td><form:errors path="Name" cssClass="error" /></td>
            </tr>

            <tr>
            <tr><td><form:label path="surname">Surname</form:label></td></tr>
            <td><form:input required="required" path="surname" name="surname" id="surname" placeholder ="Surname"/></td>
            <td><form:errors path="surname" cssClass="error" /></td>
            </tr>
            <tr>
            <tr><td><form:label path="username">Username</form:label></td></tr>
            <td><form:input required="required"   path="username" name="username" id="username" placeholder ="Username"/></td>
            <td><form:errors path="username" cssClass="error" /></td>
            </tr>
            <tr>
            <tr><td><form:label path="password">Password</form:label></td></tr>
            <td><form:password required="required" path="password" name="password"	id="password" placeholder ="Password"/></td>
            <td><form:errors path="password" cssClass="error" /></td>
            </tr>

            <tr>
            <tr><td><form:label path="dateofbirth">Date Of Birth</form:label></td></tr>
            <td><form:input path="dateofbirth" name="dateofbirth" id="dateofbirth" placeholder ="DD-MM-YYYY"/></td>
            <td><form:errors path="dateofbirth" cssClass="error" /></td>
            </tr>
            <tr>
            <tr><td><form:label path="gender">Gender</form:label></td></tr>
            <td><form:input required="required" path="gender" name="gender" id="gender" placeholder ="Gender"/></td>
            <td><form:errors path="gender" cssClass="error" /></td>
            </tr>

            <tr>
            <tr><td><form:label path="email">Email</form:label></td></tr>
            <td><form:input required="required" path="email" name="email" id="email" placeholder = "Email"/></td>
            <td><form:errors path="email" cssClass="error" /></td>
            </tr>
            <tr>
            <tr><td><form:label path="address">Address</form:label></td></tr>
            <td><form:input path="address" name="address" id="address" placeholder ="Address"/></td>
            <td><form:errors path="address" cssClass="error" /></td>
            </tr>
            <tr>
            <tr><td><form:label path="phonenumber">Phone Number</form:label></td></tr>
            <td><form:input  path="phonenumber" name="phonenumber" id="phonenumber" placeholder ="Phone number"/></td>
            <td><form:errors path="phonenumber" cssClass="error" /></td>
            </tr>
            <tr>

            <tr>
            <tr><td><form:button id="register" name="register">Register</form:button></td></tr>

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
