<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="for" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Tasks</title>
</head>



<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


<%@ include file="styleHomeStudent.jspf" %>
<body>
<%@ include file="headerStudent.jspf" %>



<div class="w3-row-padding w3-padding-64 w3-container">
  <div class="container  py-5">
    <table class="table table-dark table-hover table-bordered">
      <thead>
      <tr style="text-align: center">
        <td scope="col">Task Name</td>
        <td scope="col">Task Review</td>
        <td scope="col">Task Status</td>
        <td scope="col">Assigned Student</td>
        <td scope="col">Solve</td>
        <td scope="col">Review</td>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${taskList}" var="task">
        <tr style="text-align: center">
          <td>${task.taskName}</td>
          <td>${task.taskReview}</td>
          <td>${task.taskStatus}</td>
          <td>${task.studentName}</td>
          <td>
            <button class="btn btn-light"><a style="color:black" href="/tasks/${task.taskId}">Mark as solved</a></button>
          </td>
          <td>
            <button class="btn btn-light"><a style="color:black" href="/tasks/${task.taskId}" onclick="document.getElementById('id01').style.display='block'">Add
              review</a></button>
          </td>

        </tr>

        <div id="id01" class="w3-modal" style="z-index:4">
          <div class="w3-modal-content w3-animate-zoom">
            <div class="w3-container w3-padding w3-dark-gray">
       <span onclick="document.getElementById('id01').style.display='none'"
             class="w3-button w3-dark-gray w3-right w3-xxlarge"><i class="fa fa-remove"></i></span>
              <h2>Publish review</h2>
            </div>
            <form method="post" action="/tasks/${task.taskId}" class="w3-panel" id="from-post">
              <!-- <div class="w3-panel"> -->
              <label>Task Review</label>
              <input name="taskReview" class="w3-input w3-border w3-margin-bottom" type="text">
              <div class="w3-section">
                <a class="w3-button w3-red" onclick="document.getElementById('id01').style.display='none'">Cancel  <i
                        class="fa fa-remove"></i></a>
                <button class="btn btn-success" type="submit">Save review</button>
              </div>
            </form>
          </div>
        </div>
      </c:forEach>
      </tbody>
    </table>


    <a href="javascript:void(0)" class="w3-bar-item w3-button w3-dark-grey w3-button w3-hover-black w3-left-align"
       onclick="document.getElementById('id01').style.display='block'">Add review<i
      class="w3-padding fa fa-pencil"></i></a>


  </div>
</div>


<%@ include file="footerStudent.jspf" %>
<script>
  function showHideReview() {
    var x = document.getElementById("showReview");
    if (x.style.display === "none") {
      x.style.display = "block";
    } else {
      x.style.display = "none";
    }
  }
</script>
</body>
</html>
