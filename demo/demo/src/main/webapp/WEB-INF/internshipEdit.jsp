<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Internship edit</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link href='https://fonts.googleapis.com/css?family=RobotoDraft' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<div class="text-center py-5">
  <h1>Internship edit</h1>
</div>
<body>
<div class="container border">
  <form class="w3-panel" id="from-post" action="/internship/${internship.internshipId}/update"
        method="post">
    <label>Internship name</label>
    <input name="internshipName" class="w3-input w3-border w3-margin-bottom" type="text"
           value="${internship.internshipName}">
    <label>Start date</label>
    <input name="internshipStartDate" class="w3-input w3-border w3-margin-bottom" type="date"
           value="${internship.internshipStartDate}">
    <label>End date</label>
    <input name="internshipEndDate" class="w3-input w3-border w3-margin-bottom" type="date"
           value="${internship.internshipEndDate}">
    <label>Type </label>
    <input name="internshipType" class="w3-input w3-border w3-margin-bottom" type="text"
           value="${internship.internshipType}"><
    <label>Benefits</label>
    <input name="internshipBenefits" class="w3-input w3-border w3-margin-bottom" type="text"
           value="${internship.internshipBenefits}">
    <label>Spaces</label>
    <input name="internshipAvailableSpaces" class="w3-input w3-border w3-margin-bottom" type="number"
           value="${internship.internshipAvailableSpaces}">
    <div class="w3-section">
      <a class="w3-button w3-red" onclick="document.getElementById('id01').style.display='none'">Cancel<i
        class="fa fa-remove"></i></a>
      <button class="btn btn-success" type="submit">Edit internship</button>
    </div>
  </form>
</div>
</body>
</html>
