<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link href="<c:url value='resources/css/main.css'/>" rel="stylesheet" type="text/css" />
</head>
<body>
	<div><img src="<c:url value='resources/images/Title.jpg'/>" height="75px" width="100%"></div>
	<div style="width: 100%; height:100%">
		<div style="width: 80%; height:100%;float:left"><img src="<c:url value='resources/images/Login.jpg'/>" alt="Image Not Found" height="100%" width="100%"></div>
		<div style="float: right;width: 20%; height:100%">
			<form:form name="loginform"  method="post" action="submitlogin"  >
				<table id="logintable" cellspacing="10px" cellpadding="5px">
				<tr><td colspan="2" align="center"><div class="error">${message}</div></td></tr>
					<tr><td>UserName: </td>
						<td><input type="text" name="username" /></td></tr>
					<%-- 	<td><form:input name="username" path="userName" /></td></tr> --%>
					
					<tr><td>Password: </td>
						<td><input type="password" name="password" /></td></tr>
						<%-- <td><form:password name="password" path="password" /></td></tr> --%>
					
					<tr><td colspan="2" align="center"><input type="submit" name="login" value="Login" class="button"></td></tr>
					<tr><td colspan="2" align="center"><div class="error">${error_message}</div></td></tr>
					<tr ><td colspan="2" align="center">Don't have an Account. Please <a href="<c:url value='registeruserform' />" style="text-align: center;"> Sign Up</a> here.</td></tr>
				</table>
				<div style="float: none;"></div>
				<br/>
			</form:form>
		</div>
	</div>
</body>
</html>