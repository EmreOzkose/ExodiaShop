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
 
 img{
  width: 318px;
  height: 102px;
  position: absolute;
  top: -15%;
  left: 13%;
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
 label{
    color: #fff;
    width: 100%;
 }
 
 .login {
  width: 400px;
  height: 500px;
  background: transparent;
  color: #fff;
  top: 55%;
  left: 50%;
  position: fixed;
  transform: translate(-50%, -50%);
  box-sizing: border-box;
  padding: 70px 30px;
  border-radius: 20px;
}


 h1 {
   margin: 0;
   padding: 0 0 20px;
   text-align: center;
   line-height: 1em;
   font-size: 26px;
 }

 .login p{
   margin: 0;
   padding: 0;
   font-weight: bold;
   font-size: 14px;
 }

 .login input{
   width: 100%;
   margin-bottom: 20px;
 }

 .login input[type="text"], input[type="password"]{
   border: none;
   border-bottom: 1px solid #000;
   background: transparent;
   outline: none;
   height: 40px;
   color: #000;
   font-size: 16px;
 }

 

 .login input[type="submit"]:hover {
    cursor: pointer;
    background: #79fff0;
    color: #fff;
 }

.login a{
  left: 50%;
  text-decoration: none;
  font-size: 12px;
  line-height: 20px;
  color: #037d6f;
}

button:hover {
  cursor: pointer;
    background: #79fff0;
    color: #fff;
}

table{
    width: 100%;
}
     
</style>
<title>Login</title>


</head>
<body>
    <div class="login">
    <img src="img/logos/exodia-cursive.png" alt="exodia logo"/>
    <h1> Sign in </h1>
	<form id="loginForm" action="loginProcess" method="POST">
            <table align="center">
                <tr>
                         <tr>
                             <td><label>Username: </label></td></tr>
                        <td><input required="required" type="text" name="username"  placeholder ="Enter your username" id="username" /></td>
                    
                </tr>
                <tr>
                         <tr>
                             <td><label >Password:</label></td></tr>
                <td><input required="required" type="text" name="password"  placeholder ="Enter your password" id="password" /></td>


                </tr>
                <tr>
                        <tr></tr>
                        <td align="center"><button id="login" name="login">Login</button></td>
                </tr>

                <tr></tr>
                <tr>
                        <tr></tr>
                        <td><a href="/dashboard">Home</a></td>
                </tr>
                <tr>
                    <td><a href="/login">Don't have an account? Sign up!</a></td>
                </tr>
            </table>
	</form>
	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${message}</td>
		</tr>
	</table>
    </div>
</body>

</html>