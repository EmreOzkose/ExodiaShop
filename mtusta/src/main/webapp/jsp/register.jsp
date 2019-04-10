<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
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