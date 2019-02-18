<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
  <head>
    <title>ProductMarket</title>
  </head>
  <body>
  <h1>${message}</h1>
  <h2>Products</h2>
  <table>
    <thead>
    <tr>
      <th>ID</th>
      <th>Title</th>
      <th>Coast</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${productsList}">
      <tr><td>${item.id}</td>
      <td>${item.title}</td>
      <td>${item.cost}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

  <form:form action="addProduct" modelAttribute="product">
    Title: <form:input path="title" />
    <br>
    Cost: <form:input path="cost" />
    <br>
    <input type="submit" value="Submit" />
  </form:form>

  </body>
</html>
