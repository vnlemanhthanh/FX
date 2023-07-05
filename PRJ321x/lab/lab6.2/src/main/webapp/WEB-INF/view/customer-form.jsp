<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>

<title>Customer Registration Form</title>

<style type="text/css">
.error {
	color: red
}
</style>

</head>

<body>

	<i>Fill out the form. Asterisk (*) means required.</i>

	<br>
	<br>

	<form:form action="processForm" modelAttribute="customer">
	
		First name: <form:input path="firstName" />

		<br>
		<br>
		
		Last name (*): <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error" />

		<br>
		<br>

		<input type="submit" Value="Submit" />

		<br>
		<br>
		
	</form:form>

</body>

</html>