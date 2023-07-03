<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<title>Student Confirmation</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="student">
		First name: <form:input path="firstName" />

		<br>
		<br>

		Last name: <form:input path="lastName" />

		<br>
		<br>

		<input type="submit" value="Submit" />
	</form:form>

</body>

</html>