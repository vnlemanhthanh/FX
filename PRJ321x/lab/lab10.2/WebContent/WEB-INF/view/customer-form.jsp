<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <!-- reference our style sheet -->
    <!-- href="${pageContext.request.contextPath}/resources/css/style.css" -->
    <link
      type="text/css"
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/style.css"
    />
    <title>Customers Form ${pageContext.request.contextPath}</title>
  </head>

  <body>
    <div id="wrapper">
      <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
      </div>
    </div>

    <input
      type="button"
      value="Add Customer"
      onclick="window.location.href='showFormForAdd'; return false"
      class="add-button"
    />

    <!-- add our html table here  -->
    <table>
      <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
      </tr>

      <!-- loop over and print our customers -->
      <c:forEach var="tempCustomer" items="${customers}">
        <tr>
          <td>${tempCustomer.firstName}</td>
          <td>${tempCustomer.lastName}</td>
          <td>${tempCustomer.email}</td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
