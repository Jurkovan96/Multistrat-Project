<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Add Review</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link href='https://fonts.googleapis.com/css?family=RobotoDraft' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<div class="text-center py-5">
  <h1>Add review</h1>
</div>
<body>
<div class="container border">
  <form class="w3-panel" id="from-post" action="<c:url value="/tasks/${singleTask.taskId}/review"/>"
        method="post">
    <label>Task name</label>
    <input name="taskName" class="w3-input w3-border w3-margin-bottom" type="text"
           value="${singleTask.taskName}">
    <label>Task difficulty</label>
    <input name="taskDifficulty" class="w3-input w3-border w3-margin-bottom" type="text"
           value="${singleTask.taskDifficulty}">
    <label>Task review</label>
    <input name="taskReview" class="w3-input w3-border w3-margin-bottom" type="text"
           value="${singleTask.taskReview}">
    </select>
    <div class="w3-section">
      <a class="w3-button w3-red" onclick="document.getElementById('id01').style.display='none'">Cancel<i
        class="fa fa-remove"></i></a>
      <button class="btn btn-success" type="submit">Add review</button>
    </div>
  </form>
</div>
</body>
</html>
