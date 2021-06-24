<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
.loginform {
	align-content: center;
}
.error{
	color: red;
}
table{
	margin: 0 auto;
}
</style>
<title>Welcome To Login Page</title>
</head>
<body>
	<h2>Welcome to Home Page</h2>
	<div
		style="text-align: right; padding: 5px; margin: 5px 0px; background: #ccc;">
		
	</div>
<form:form name="form" action="/login" method="POST" modelAttribute="customer">
	<table>
		<tr>
			<td><form:label path="custId">Customer Id</form:label></td>
			<td><form:input path="custId" id="custId" name="custId"/></td>
			<td><form:errors path="custId" cssClass="error"/></td>
		</tr>
		
		<tr>
			<td><form:label path="custName">Customer Name</form:label></td>
			<td><form:input path="custName" id="custName" name="custName"/></td>
			<td><form:errors path="custName" cssClass="error"/></td>
		</tr>
		
		<tr>
			<td><form:label path="custAddress">Customer Address</form:label></td>
			<td><form:input path="custAddress" id="custAddress" name="custAddress"/></td>
			<td><form:errors path="custAddress" cssClass="error"/></td>
		</tr>
		
		<tr>
			<td><form:label path="custPhone">Customer Phone Number</form:label></td>
			<td><form:input path="custPhone" id="custPhone" name="custPhone"/></td>
			<td><form:errors path="custPhone" cssClass="error"/></td>
		</tr>
		
		<tr>
			<td><form:label path="loginId">Login Id</form:label></td>
			<td><form:input path="loginId" id="loginId" name="loginId"/></td>
			<td><form:errors path="loginId" cssClass="error"/></td>
		</tr>
		
		<tr>
			<td><form:label path="password">Password</form:label></td>
			<td><form:password path="password" id="password" name="password"/></td>
			<td><form:errors path="password" cssClass="error"/></td>
		</tr>

		<tr>
			<td><input type="submit" value="submit" id="submit" name="submit"></td>
			<td><input type="reset" value="Clear" id="Clear" name="Clear"></td>
		</tr>

	</table>

</form:form>
	
</body>
</html>