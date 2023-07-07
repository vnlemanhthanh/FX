<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <title>List Customers</title>
  </head>

  <body>
    <div id="wrapper">
      <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
      </div>
    </div>

    <!-- add our html table here  -->
    <table>
      <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
      </tr>
    </table>

    <!-- loop over and print our customers -->
    <c:forEach var="tempCustomer" items="${customers}">
      <tr>
        <td>${tempCustomer.firstName}</td>
        <td>${tempCustomer.lastName}</td>
        <td>${tempCustomer.email}</td>
      </tr>
    </c:forEach>
  </body>
</html>
