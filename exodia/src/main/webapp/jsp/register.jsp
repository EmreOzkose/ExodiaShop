<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
    <style>
       html {
  height:100%;
}

body {
  margin: 0;
  padding: 0;
  font-family: Arial, sans-serif;
  background: rgb(121,255,240);
  background: -moz-linear-gradient(128deg, rgba(121,255,240,1) 0%, rgba(143,203,246,1) 50%, rgba(172,130,255,1) 100%);
  background: -webkit-linear-gradient(128deg, rgba(121,255,240,1) 0%, rgba(143,203,246,1) 50%, rgba(172,130,255,1) 100%);
  background: linear-gradient(128deg, rgba(121,255,240,1) 0%, rgba(143,203,246,1) 50%, rgba(172,130,255,1) 100%);
  filter: progid:DXImageTransform.Microsoft.gradient(startColorstr="#79fff0",endColorstr="#ac82ff",GradientType=1);
}
input[type="text"], input[type="password"]{
   border: none;
   border-bottom: 1px solid #000;
   background: transparent;
   outline: none;
   height: 40px;
   color: #000;
   font-size: 16px;
 }
  button{
   border: none;
   outline: none;
   height: 40px;
   background: #ac82ff;
   color: #fff;
   font-size: 18px;
   border-radius: 20px;
 }

 input[type="submit"]:hover {
    cursor: pointer;
    background: #79fff0;
    color: #fff;
 }
     
    </style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<form:form id="regForm" modelAttribute="customer" action="registerProcess" method="post">
		<table align="center">
			<tr>
				<td><form:label path="username">Username</form:label></td>
				<td><form:input path="username" name="username" id="username" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password path="password" name="password"
						id="password" /></td>
			</tr>
			<tr>
				<td><form:label path="Name">Name</form:label></td>
				<td><form:input path="Name" name="Name"	id="Name" /></td>
			</tr>
			<tr>
				<td><form:label path="surname">Surname</form:label></td>
				<td><form:input path="surname" name="surname" id="surname" /></td>
			</tr>
			<tr>
				<td><form:label path="dateofbirth">Date Of Birth</form:label></td>
				<td><form:input path="dateofbirth" name="dateofbirth" id="dateofbirth" /></td>
			</tr>
			<tr>
				<td><form:label path="gender">Gender</form:label></td>
				<td><form:input path="gender" name="gender" id="gender" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" name="email" id="email" /></td>
			</tr>
			<tr>
				<td><form:label path="address">Address</form:label></td>
				<td><form:input path="address" name="address" id="address" /></td>
			</tr>
			<tr>
				<td><form:label path="phonenumber">Phone</form:label></td>
				<td><form:input path="phonenumber" name="phonenumber" id="phonenumber" /></td>
			</tr>
			<tr>
				<td></td>
				<td><form:button id="register" name="register">Register</form:button></td>
			</tr>
			<tr></tr>
			<tr>
				<td></td>
				<td><a href="home.jsp">Home</a></td>
			</tr>
		</table>
	</form:form>

</body>
</html>