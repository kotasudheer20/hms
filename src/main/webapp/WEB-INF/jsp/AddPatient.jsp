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
<title>Patient Details</title>
</head>
<body>
	<div><img src="<c:url value='resources/images/Title.jpg'/>" height="75px" width="100%"></div>
	<div class="error" name="infodiv" style="width:100%">${message}</div>
	<form:form name="patientform" commandName="addpatient" action="addpatient">
		<table  cellpadding="5">
		    <thead>
		        <tr>
		         	<th colspan="1" style="text-align: left;">Patient Details:</th> 
		        </tr>
		    </thead>
		    <tbody>
			    <tr>
			        <td>Patient ID: <form:input name="patientID" value="" path="patientID" disabled="true"/></td>
			    </tr>
		        <tr>
		            <td>First Name: <form:input name="firstname" value="" path="firstName" /><form:errors cssClass="error" path="firstName" /></td>
		        
		            <td>Last Name: <form:input name="lastname" value="" path="lastName" /><form:errors class="error" path="lastName" /></td>
		        </tr>
		        <tr>
		            <td>Date of Birth: <form:input name="dob" value="" path="dob" /></td>
		               
		            <td>Gender: <form:select path="gender" name="gender" value="" >
		            	<form:option value="None">--Select--</form:option>
			            <form:option value="Male">Male</form:option>
			            <form:option value="Female">Female</form:option></form:select>
		           <form:errors class="error" path="gender" /></td>
		        </tr>
		         <tr>
		            <td>Address: <form:input path="address" name="address" value="" /></td>
		        </tr>
		        
		       
		        <tr>
		            <td><input type="submit" value="Save" /></td></td>
		        </tr>
        
		    </tbody>
		</table>
	</form:form>
</body>
</html>