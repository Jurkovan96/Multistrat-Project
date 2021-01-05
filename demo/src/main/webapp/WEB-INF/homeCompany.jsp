<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<title>Internships</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href='https://fonts.googleapis.com/css?family=RobotoDraft' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style>
  html, body, h1, h2, h3, h4, h5 {
    font-family: "RobotoDraft", "Roboto", sans-serif
  }

  .w3-bar-block .w3-bar-item {
    padding: 16px
  }
</style>
<body>


<!-- Side Navigation -->
<nav class="w3-sidebar w3-bar-block w3-collapse w3-white w3-animate-left w3-card" style="z-index:3;width:320px;"
     id="mySidebar">
  <a href="javascript:void(0)" onclick="w3_close()" title="Close Sidemenu"
     class="w3-bar-item w3-button w3-hide-large w3-large">Close <i class="fa fa-remove"></i></a>
  <a href="javascript:void(0)" class="w3-bar-item w3-button w3-dark-grey w3-button w3-hover-black w3-left-align"
     onclick="document.getElementById('id01').style.display='block'">New Internship <i
    class="w3-padding fa fa-pencil"></i></a>
  <a id="myBtn" onclick="myFunc('Demo1')" href="javascript:void(0)" class="w3-bar-item w3-button"><i
    class="fa fa-inbox w3-margin-right"></i>Internship (<c:out value="${listOfInternships.size()}"/>)<i
    class="fa fa-caret-down w3-margin-left"></i></a>

  <div id="Demo1" class="w3-hide w3-animate-left">
    <c:forEach items="${listOfInternships}" var="internship">
      <a href="javascript:void(0)" class="w3-bar-item w3-button w3-border-bottom test w3-hover-light-grey"
         onclick="openMail();w3_close();" id="firstTab">

        <div class="w3-container">
          <img class="w3-round w3-margin-right" src="/w3images/avatar3.png" style="width:15%;"><span
          class="w3-opacity w3-large"><c:out value="${internship.getInternshipName()}"/></span>
          <p><c:out value="${internship.getInternshipName()}"/></p>
        </div>

      </a>
    </c:forEach>
  </div>


  <%--    links to other pages--%>
  <a href="<c:url value="/homepageCompany/projects"/>" class="w3-bar-item w3-button"><i
    class="fa fa-paper-plane w3-margin-right"></i>Projects</a>
  <a href="<c:url value="/homepageCompany/task"/>" class="w3-bar-item w3-button"><i
    class="fa fa-hourglass-end w3-margin-right"></i>Tasks</a>
  <a href="#" class="w3-bar-item w3-button"><i class="fa fa-trash w3-margin-right"></i>Schedules</a>
</nav>

<!-- Modal that pops up when you click on "New Message" -->
<div id="id01" class="w3-modal" style="z-index:4">
  <div class="w3-modal-content w3-animate-zoom">
    <div class="w3-container w3-padding w3-dark-gray">
       <span onclick="document.getElementById('id01').style.display='none'"
             class="w3-button w3-dark-gray w3-right w3-xxlarge"><i class="fa fa-remove"></i></span>
      <h2>Publish internship</h2>
    </div>
    <form class="w3-panel" id="from-post" action="<c:url value="/homepageCompany"/>" method="post">
      <!-- <div class="w3-panel"> -->
      <label>Start Date</label>
      <input name="internshipStartDate" class="w3-input w3-border w3-margin-bottom" type="date">
      <label>End Date</label>
      <input name="internshipEndDate" class="w3-input w3-border w3-margin-bottom" type="date">
      <label>Title</label>
      <input name="internshipName" class="w3-input w3-border w3-margin-bottom" type="text">
      <input name="internshipDesc" class="w3-input w3-border w3-margin-bottom" style="height:150px"
             placeholder="What are the real benefits?">
      <div class="w3-section">
        <a class="w3-button w3-red" onclick="document.getElementById('id01').style.display='none'">Cancel  <i
                class="fa fa-remove"></i></a>
        <button class="btn btn-success" type="submit">Save project</button>
      </div>
      </div>
    </form>
  </div>
</div>
</div>
</div>

<!-- Overlay effect when opening the side navigation on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer"
     title="Close Sidemenu" id="myOverlay"></div>

<!-- Page content -->
<div class="w3-main" style="margin-left:320px;">
  <i class="fa fa-bars w3-button w3-white w3-hide-large w3-xlarge w3-margin-left w3-margin-top"
     onclick="w3_open()"></i>
  <a href="javascript:void(0)" class="w3-hide-large w3-red w3-button w3-right w3-margin-top w3-margin-right"
     onclick="document.getElementById('id01').style.display='block'"><i class="fa fa-pencil"></i></a>

  <c:forEach items="${listOfInternships}" var="internship">
    <div id="internshipBody" class="w3-container internship">
      <br>
      <h4><i id="internshipTitle"><c:out value="${internship.getInternshipName()}"/></i></h4>
      <h5 id="internshipStartDate" class="w3-opacity fa fa-clock-o"><c:out
        value="${internship.getInternshipStartDate()}"/></h5><br>
      <h5 id="internshipEndDate" class="w3-opacity fa fa-clock-o"><c:out
        value="${internship.getInternshipEndDate()}"/></h5>
      <hr>
      <p id="internshipDescription"><c:out value="${internship.getInternshipBenefits()}"/></p>
    </div>
  </c:forEach>

</div>

<script>
  var openInbox = document.getElementById("myBtn");
  openInbox.click();

  function w3_open() {
    document.getElementById("mySidebar").style.display = "block";
    document.getElementById("myOverlay").style.display = "block";
  }

  function w3_close() {
    document.getElementById("mySidebar").style.display = "none";
    document.getElementById("myOverlay").style.display = "none";
  }

  function myFunc(id) {
    var x = document.getElementById(id);
    if (x.className.indexOf("w3-show") == -1) {
      x.className += " w3-show";
      x.previousElementSibling.className += " w3-red";
    } else {
      x.className = x.className.replace(" w3-show", "");
      x.previousElementSibling.className =
        x.previousElementSibling.className.replace(" w3-red", "");
    }
  }

  openMail("Borge")

  function openMail(personName) {
    var i;
    var x = document.getElementsByClassName("person");
    for (i = 0; i < x.length; i++) {
      x[i].style.display = "none";
    }
    x = document.getElementsByClassName("test");
    for (i = 0; i < x.length; i++) {
      x[i].className = x[i].className.replace(" w3-light-grey", "");
    }
    document.getElementById(personName).style.display = "block";
    event.currentTarget.className += " w3-light-grey";
  }
</script>

<script>
  var openTab = document.getElementById("firstTab");
  openTab.click();
</script>

</body>
</html>

