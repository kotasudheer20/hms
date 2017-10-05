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
<title>Home</title>
<style>
#header {
    background-color:white;
    color:blue;
    text-align:center;
    padding:3px;
   font-size: 30px;
   border-color: blue;
   border-style: groove;
   padding-bottom: 10px;
}

.MainContent {
    background-color:white;
    text-align:center;
}
.pageHeading{
	text-align: center;
	color: #ff8c1a;
	font-size: 30px;
	width: 100%;
}
</style>
</head>
<body>
<div><img src="<c:url value='resources/images/Title.jpg' />" height="60px" width="100%"></div>
<div id="NavigationPane" style="float:left;width:20%;height:80%;border-style:solid;border-color: orange; ">

	<div class="MainContent"><a href="" ><img src="<c:url value='resources/images/PatientInformation.jpg"' /> width="100%" height="50px"/></a></div>
	<div class="MainContent"><a href=""><img src="<c:url value='resources/images/ProviderInformation.jpg' />" width="100%" height="50px"/></a></div>
	<div class="MainContent"><a href=""><img src="<c:url value='resources/images/UserMaintenance.jpg' />" width="100%" height="50px"/></a></div>
	<div class="MainContent"><a href=""><img src="<c:url value='resources/images/Miscellaneous.jpg' />" width="100%" height="50px"/></a></div>
</div>
<div id="DetailsPane" style="float:left;width:75%;border-style:solid;border-color: orange;min-height: 100%">
	<div align="right"><form:form name="addpatientbuttonform" action="addpatient"><input type="submit" name="addPatient" src="<c:url value='resources/images/AddPatient.jpg' />" value="Add Patient"></form:form></div>
	<div style="width:75%">
		<span class="pageHeading">Patient Search</span>
		<form:form id="searchPatient" method="post" action="patientsearch">
		
			<table>
				<tr><td> Patient ID: </td>
					<td><input type="text" class="inputbox" size="10" name="patientID"></td>
				</tr>
				<tr><td>First Name:</td>
					<td><input type="text" class="inputbox" size="20" name="firstName"></td>
				</tr>
				
				<tr><td>Last Name:</td>
					<td><input type="text" class="inputbox" size="20" name="lastName"></td>
				</tr>
				<tr><td rowspan="2"><input type="submit" value="Search" name = "searchPatient" class="button"></td></tr>
				<tr><td colspan="2"><span name="error_Message" style="color: red"></span></td>
				</tr>
			</table>
		</form:form>
	</div>


	<div name="patientlist">
		<div name="messages">${information_message}</div>
		<div name="patienttablediv">
			<c:if test="${patients != null}">
				<table bordercolor="orange" border="solid" cellspacing="2px" width=75%>
					<tr>
			            <th>PatientID</th>
			            <th>FirstName</th>  
			            <th>LastName</th>
			            <th>Gender</th>
			            <th>DOB</th>
			        </tr>
					<c:forEach items="${patients}" var="patinet">
			        <tr>
			            <td><c:out value="${patinet.patientID}"/></td>
			            <td><c:out value="${patinet.firstName}"/></td>  
			            <td><c:out value="${patinet.lastName}"/></td>
			             <td><c:out value="${patinet.gender}"/></td>
			            <td><c:out value="${patinet.dob}"/></td>
			        </tr>
			    	</c:forEach>
		    	</table>
			</c:if>
		</div>
	</div>
</div>

</body>
</html>