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
<link href="<c:url value='resources/css/main.css'/>" rel="stylesheet" type="text/css" />
<title>Registration</title>
</head>
<body>
	<form:form name="registrationform" commandName="registeruser" action="registeruserform">
		<table  cellpadding="5">
		    <thead>
		        <tr>
		            <th colspan="2">Enter Information Here</th>
		        </tr>
		    </thead>
		    <tbody>
		        <tr>
		            <td>First Name:</td>
		            <td><form:input name="firstname" value="" path="firstName" /></td>
		            <td><form:errors cssClass="error" path="firstName" /></td>
		        </tr>
		        <tr>
		            <td>Last Name:</td>
		            <td><form:input name="lastname" value="" path="lastName" /></td>
		            <td><form:errors class="error" path="lastName" /></td>
		        </tr>
		        <tr>
		            <td>Date of Birth:</td>
		            <td><form:input name="dob" value="" path="dob" /></td>
		            <td><form:errors cssStyle="color: red;" path="dob" />
		            
		        </tr>
		        <tr>
		            <td>User Name:</td>
		            <td><form:input name="username" value="" path="username" /></td>
		            <td><form:errors class="error" path="username" /></td>
		        </tr>
		        <tr>
		            <td>Password:</td>
		            <td><form:password name="password" value="" path="password" /></td>
		            <td><form:errors class="error" path="password" /></td>
		        </tr>
		         <tr>
		            <td>Gender:</td>
		            <td><form:select path="gender" name="gender" value="" >
		            	<form:option value="None">--Select--</form:option>
			            <form:option value="Male">Male</form:option>
			            <form:option value="Female">Female</form:option></form:select>
		            </td>
		            <td><form:errors class="error" path="gender" /></td>
		        </tr>
		         <tr>
		            <td>AddressLine1:</td>
		            <td><form:input path="addressLine1" name="addressline1" value="" /></td>
		        </tr>
		         <tr>
		            <td>AddressLine2:</td>
		            <td><form:input path="addressLine2" name="addressline2" value="" /></td>
		        </tr>
		         <tr>
		            <td>City:</td>
		            <td><form:input path="city" name="city" value="" /></td>
		        </tr>
		         <tr>
		            <td>State:</td>
		            <td><form:input path="state" name="state" value="" /></td>
		        </tr>
		           <tr>
		            <td>Zipcode:</td>
		            <td><form:input path="zipcode" name="zipcode" value="" /></td>
		        </tr>
		       
		        <tr>
		            <td><input type="submit" value="Submit" class="button" /></td><td><input type="reset" value="Reset" /></td>
		        </tr>
        
		    </tbody>
		</table>
	</form:form>
</body>
</html>