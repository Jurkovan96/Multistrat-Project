<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
<div>
  <table class="table">
    <thead>
    <tr>
      <td>Project Name</td>
      <td>Estimated time</td>
      <td>Start date</td>
      <td>Actions</td>
    </tr>
    </thead>
    <c:forEach items="${projectList}" var="project">
    <tbody>
    <tr>
      <td>${project.projectName}</td>
      <td>${project.projectEstimatedTime}</td>
      <td>${project.projectStartDate}</td>
      <td><a href="/project/${project.projectId}/delete">Delete project</a></td>
    </tr>
    </c:forEach>
    </tbody>
  </table>

</div>
</body>
</html>
