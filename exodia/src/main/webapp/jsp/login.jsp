<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="${pageContext.request.contextPath}/img/script.js"></script>
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
 label{
    color: #fff;
 }
     
</style>
<title>Login</title>


</head>
<body>
    <img src="img/exodia-cursive.png" alt="exodia logo"/>
	<form:form id="loginForm" modelAttribute="login" action="loginProcess" method="post">
            <table align="center">
                <tr>
                         <tr>
                             <td><form:label path="username">Username: </form:label></td></tr>
                        <td><form:input required="required" path="username" type="text" name="username"  placeholder ="Enter your username" id="username" /></td>
                    
                </tr>
                <tr>
                         <tr>
                             <td><form:label path="password">Password:</form:label></td></tr>
                        <td><form:password required="required" path="password"  name="password" placeholder ="Enter your password" id="password"/></td>
                </tr>
                <tr>
                        <tr></tr>
                        <td align="left"><form:button id="login" onclick="myFunction()" name="login">Login</form:button></td>
                </tr>

                <tr></tr>
                <tr>
                        <tr></tr>
                        <td><a href="home.jsp">Home</a></td>
                </tr>
            </table>
	</form:form>
	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${message}</td>
		</tr>
	</table>

</body>

</html>