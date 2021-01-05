<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Team</title>
  <script src="https://code.jquery.com/jquery-3.3.1.min.js"
          integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
          crossorigin="anonymous"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"
          integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU="
          crossorigin="anonymous"></script>
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
  <div id="userContainer" class="container py-5">
    <table class="table table-dark table-hover table-bordered">
      <thead>
      <tr style="text-align: center">
        <th scope="col">FirstName</th>
        <th scope="col">LastName</th>
        <th scope="col">Current task</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${StudentList}" var="student">
        <tr style="text-align: center" id="draggableRow">
          <td onclick="clickItem()">${student.name}</td>
          <td><a href="/profile/user/${student.id}" style="color: white">${student.surname}</a></td>
          <td id="taskS">${student.currentTask}</td>
        </tr>
        <input style="display: none" class="dropItem" value="${student.name}"/>
      </c:forEach>

      </tbody>
    </table>
  </div>
</div>

<%--<div id="dropZone">This is a drop zone</div>--%>

<%@ include file="footerStudent.jspf" %>

<script>
  $(document).ready(function () {

    $('#draggableRow td').css({
      'z-index': 100
    }).draggable({
      'opacity': '0.5',
      'revert': true,
      'cursor': 'pointer'
    });
  });

  $('#dropZone').droppable({
    drop: function (event, ui) {
      var itemId = document.getElementsByClassName('dropItem').value;
      console.log(itemId);
      $.ajax({
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        url: '${pageContext.request.contextPath}/team/show/' + itemId,
        success: function x() {
          alert("It works!");
          //displayStudent(data);
        }
      });
    }
  });

  function clickItem() {
    var i = document.getElementById('taskS').value;
    alert(i);
  }

  //
  // function displayStudent(data) {
  //  var s = '';
  //   for(var i=0; i<data.length; i++){
  //    s+= '<br>Id ' + data[i].student.id;
  //
  //  }
  // }

</script>
</body>
</html>
