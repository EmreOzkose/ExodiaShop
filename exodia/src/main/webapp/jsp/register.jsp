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
.register {
  width: 400px;
  height: 500px;
  background: transparent;
  color: #ffffff;
  top: 38%;
  left: 50%;
  position: fixed;
  transform: translate(-50%, -50%);
  box-sizing: border-box;
  padding: 70px 30px;
  border-radius: 20px;
}
img{
  width: 318px;
  height: 102px;
  position: absolute;
  top: -15%;
  left: 13%;
}
h1 {
   margin: 0;
   padding: 0 0 20px;
   text-align: center;
   line-height: 1em;
   font-size: 26px;
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
   width: 100%;
 }

 .register input{
     width: 100%;
 }
 button:hover {
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
    width: 100%;
}

table{
    width: 100%;
}
    </style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
   <div class="register">
	<form:form id="regForm" modelAttribute="user" action="registerProcess" method="post">
            <img src="img/exodia-cursive.png" alt="exodia shop">
                <h1> Sign Up </h1>
		<table align="center">
                    
                    <tr>
                            <tr>
                                    <td><form:label path="Name">Name</form:label></td>
                            </tr>
				
				<td><form:input required="required" path="Name" name="Name"	id="Name" placeholder ="Name"/></td>
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
				<td><form:input required="required" path="dateofbirth" name="dateofbirth" id="dateofbirth" placeholder ="DD-MM-YYYY"/></td>
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
				<td><form:input required="required" path="address" name="address" id="address" placeholder ="Address"/></td>
                                <td><form:errors path="address" cssClass="error" /></td>
			</tr>
			 <tr>
				<tr><td><form:label path="phonenumber">Phone Number</form:label></td></tr>
				<td><form:input  required="required" path="phonenumber" name="phonenumber" id="phonenumber" placeholder ="Phone number"/></td>
                                <td><form:errors path="dateofbirth" cssClass="error" /></td>
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
   </div>
</body>
</html>