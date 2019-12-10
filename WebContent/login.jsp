<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/prof.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css">
	<!-- Icomoon Icon Fonts -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
	<!-- Superfish -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/superfish.css">

	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<%
	    Cookie[] cookies=request.getCookies();
	    String email = "", password = "",rememberVal="";
	    if (cookies != null) {
	         for (Cookie cookie : cookies) {
	           if(cookie.getName().equals("cookemail")) {
	             email = cookie.getValue();
	           }
	           if(cookie.getName().equals("cookpass")){
	             password = cookie.getValue();
	           }
	           if(cookie.getName().equals("cookrem")){
	             rememberVal = cookie.getValue();
	           }
	        }
	    }
	%>


	<div class="container2" style="background-image: url(images/home-image.jpg);">
	<div class="form_login">
		<fieldset>
			<legend>User Login</legend>
			
			<%=request.getAttribute("msg") != null ? request.getAttribute("msg") : ""%>
		
			<form  action="Alogin_u" method="post">
			  
			    <label >Email</label>
			    <input type="email" name="Email" id="email" placeholder="email" autocomplete="off" value="<%=email%>" />
			 
			  
			    <label >Password</label>
			    <input type="password" name="Password" id="password" placeholder="Password"  autocomplete="off" value="<%=password%>" /><br><br>
			    <div class="small_font">
			    	Remember Me<input name="RememberMe" type="checkbox" value="1"
                        <%= "1".equals(rememberVal.trim()) ? "checked=\"checked\"" : "" %> />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="new_u" >Register</a>
			    </div><br>
				
			  
			  <button type="submit" class="btn btn-success" >Login</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			  <a href="index.jsp">Cancel</a>
			  
			</form>
			
			
		</fieldset>
		
	</div>
		
	</div>

</body>
</html>