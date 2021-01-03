<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Tasks</title>
</head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<%@ include file="styleHomeStudent.jspf" %>
<body>
<%@ include file="headerStudent.jspf" %>

<div class="w3-row-padding w3-padding-64 w3-container">
  <div class="container" style="float: right">
    <table class="table table-dark">
      <thead>
      <tr>
        <th scope="col">FirstName</th>
        <th scope="col">LastName</th>
        <th scope="col">Current task</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${StudentList}" var="student" >
        <tr>
          <td>${student.name}</td>
        </tr>
        <tr>
          <td>${student.surname}</td>
        </tr>
        <tr>
          <td></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</div>

<%@ include file="footerStudent.jspf" %>
</body>
</html>
