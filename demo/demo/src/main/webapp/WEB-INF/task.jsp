<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Task list</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link href='https://fonts.googleapis.com/css?family=RobotoDraft' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<div class="text-center py-5">
  <h1>Task list</h1>
</div>
<div>
</div>
<body>
<div class="container py-5">
  <table class="table table-dark table-hover table-bordered">
    <thead>
    <tr style="text-align: center">
      <td>Task name</td>
      <td>Task difficulty</td>
      <td>Project</td>
      <td>Assigned user</td>
      <td>Actions</td>
    </tr>
    </thead>
    <c:forEach items="${taskList}" var="task">
    <tbody>
    <tr style="text-align: center">
      <td>${task.taskName}</td>
      <td>${task.taskDifficulty}</td>
      <td>${task.project.projectName}</td>
      <td>${task.userId}</td>
      <td>
        <button class="btn btn-danger"><a style="color: white" href="/task/${task.taskId}/delete">Delete
          task</a></button>
        <button class="btn btn-info"><a style="color: white" href="/task/${task.taskId}/update">Edit
          task</a></button>
      </td>
    </tr>
    </c:forEach>
    </tbody>
  </table>
</div>

<div class="container py-5"><a href="javascript:void(0)"
                               class="w3-bar-item w3-button w3-dark-grey w3-button w3-hover-black w3-left-align"
                               onclick="document.getElementById('id01').style.display='block'">Add new task<i
  class="w3-padding fa fa-pencil"></i></a>
</div>

<div id="id01" class="w3-modal" style="z-index:4">
  <div class="w3-modal-content w3-animate-zoom">
    <div class="w3-container w3-padding w3-dark-gray">
       <span onclick="document.getElementById('id01').style.display='none'"
             class="w3-button w3-dark-gray w3-right w3-xxlarge"><i class="fa fa-remove"></i></span>
      <h2>Publish task</h2>
    </div>
    <form class="w3-panel" id="from-post" action="<c:url value="/task/add"/>" method="post">
      <label>Task name</label>
      <input name="taskName" class="w3-input w3-border w3-margin-bottom" type="text">
      <label>Task difficulty</label>
      <input name="taskDifficulty" class="w3-input w3-border w3-margin-bottom" type="text">
      <label>Task project</label>
      <select name="project" class="w3-select">
        <c:forEach var="project1" items="${projectList}">
          <option value="${project1.projectName}">${project1.projectName}</option>
        </c:forEach>
      </select>
      <label>Assigned user</label>
      <select name="userId" class="w3-select">
        <c:forEach var="student" items="${studentList}">
          <option value="${student.userId}">${student.name} ${student.surname}</option>
        </c:forEach>
      </select>
      <div class="w3-section">
        <a class="w3-button w3-red" onclick="document.getElementById('id01').style.display='none'">Cancel  <i
          class="fa fa-remove"></i></a>
        <button class="btn btn-success" type="submit">Save task</button>
      </div>
    </form>
  </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
