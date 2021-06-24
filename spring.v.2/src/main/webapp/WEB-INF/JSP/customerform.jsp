<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer's Page</title>
</head>
<body style='margin-left: 30px'>
	
		<h2 id="heading3">Welcome To Customer Page</h2>
		
		<form:form name="form" action="/customerform" method="post">
			<table>
				<tr>
					<td>Please Select Your Option: </td>
					<td><input type="radio" name="option" id="ri" value="ri">Raise Issue</td>
					<td><input type="radio" name="option" id="vi" value="vi">View Issue Status</td>
					<td>Enter Id of Issue You Wish to See</td>
					<td><input type="text" name="issueid" id="issueid"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit" name="submit" id="sub1"></td>
				</tr>
			</table>

		</form:form>

			<!-- TYPE YOUR CODE HERE -->

		
	
</body>

</html>