<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Edit project</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link href='https://fonts.googleapis.com/css?family=RobotoDraft' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<div class="text-center py-5">
  <h1>Edit project</h1>
</div>
<body>
<c:set value="${singleProject}" var="proj"/>
<div class="container border">
  <form class="w3-panel" id="from-post" action="<c:url value="/project/${singleProject.projectId}/update"/>"
        method="post">
    <label>Project name</label>
    <input name="projectName" class="w3-input w3-border w3-margin-bottom" type="text"
           value="${singleProject.projectName}">
    <label>Project estimated time</label>
    <input name="projectEstimatedTime" class="w3-input w3-border w3-margin-bottom" type="number"
           value="${singleProject.projectEstimatedTime}">
    <label>Project team name</label>
    <select name="projectTeam" class="w3-select">
      <c:forEach var="projectTeam1" items="${listOfTeams}">
        <option value="${projectTeam1.teamName}">${projectTeam1.teamName}</option>
      </c:forEach>
    </select>
    <div class="w3-section">
      <a class="w3-button w3-red" onclick="document.getElementById('id01').style.display='none'">Cancel<i
        class="fa fa-remove"></i></a>
      <button class="btn btn-success" type="submit">Save project</button>
    </div>
  </form>
</div>
</body>
</html>
