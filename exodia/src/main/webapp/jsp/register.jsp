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
 a{
  left: 50%;
  text-decoration: none;
  font-size: 12px;
  line-height: 20px;
  color: #037d6f;
}

a:hover {
  color: #3d0066;
}
     
label{
    color: #fff;
}
    </style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
   
	<form:form id="regForm" modelAttribute="user" action="registerProcess" method="post">
            <img src="img/exodia-cursive.png" alt="exodia shop">
            
		<table align="center">
                    
                    <tr>
                            <tr>
                                    <td><form:label path="Name">Name</form:label></td>
                            </tr>
				
				<td><form:input path="Name" name="Name"	id="Name" placeholder ="Name"/></td>
			</tr>
                        
                        <tr>
                            <tr><td><form:label path="surname">Surname</form:label></td></tr>
				<td><form:input path="surname" name="surname" id="surname" placeholder ="Surname"/></td>
			</tr>
			<tr>
                        <tr><td><form:label path="username">Username</form:label></td></tr>
				<td><form:input path="username" name="username" id="username" placeholder ="Username"/></td>
			</tr>
			<tr>
				<tr><td><form:label path="password">Password</form:label></td></tr>
				<td><form:password path="password" name="password"
						id="password" placeholder ="Password"/></td>
			</tr>
			
			<tr>
                        <tr><td><form:label path="dateofbirth">Date Of Birth</form:label></td></tr>
				<td><form:input path="dateofbirth" name="dateofbirth" id="dateofbirth" placeholder ="DD-MM-YYYY"/></td>
			</tr>
			<tr>
                        <tr><td><form:label path="gender">Gender</form:label></td></tr>
				<td><form:input path="gender" name="gender" id="gender" placeholder ="Gender"/></td>
			</tr>
                        
			<tr>
				<tr><td><form:label path="email">Email</form:label></td></tr>
				<td><form:input path="email" name="email" id="email" placeholder = "E-Mail"/></td>
			</tr>
                        <tr>
				<tr><td><form:label path="address">Address</form:label></td></tr>
				<td><form:password path="address" name="address"
						id="address" placeholder ="address"/></td>
			</tr>
			 <tr>
				<tr><td><form:label path="phonenumber">Phone Number</form:label></td></tr>
				<td><form:password path="phonenumber" name="phonenumber"
						id="phonenumber" placeholder ="phonenumber"/></td>
			</tr>
			<tr>
                       
			
			
			<tr>
				<tr><td><form:button id="register" name="register">Register</form:button></td></tr>
				
			</tr>
			<tr></tr>
                        
                        
			<tr>
                        <tr></tr>
				<tr><td><a href="home.jsp">Home</a></td></tr>
			</tr>
		</table>
	</form:form>

</body>
</html>