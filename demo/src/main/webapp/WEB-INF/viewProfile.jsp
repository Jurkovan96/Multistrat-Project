<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>User Profile</title>
  <script src="https://code.jquery.com/jquery-3.3.1.min.js"
          integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
          crossorigin="anonymous"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"
          integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU="
          crossorigin="anonymous"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="http://netdna.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
  <style type="text/css">
    body {
      background: #DCDCDC;
      margin-top: 20px;
    }

    .card-box {
      padding: 20px;
      border-radius: 3px;
      margin-bottom: 30px;
      background-color: #fff;
    }

    .social-links li a {
      border-radius: 50%;
      color: rgba(121, 121, 121, .8);
      display: inline-block;
      height: 30px;
      line-height: 27px;
      border: 2px solid rgba(121, 121, 121, .5);
      text-align: center;
      width: 30px
    }

    .social-links li a:hover {
      color: #797979;
      border: 2px solid #797979
    }

    .thumb-lg {
      height: 88px;
      width: 88px;
    }

    .img-thumbnail {
      padding: .25rem;
      background-color: #fff;
      border: 1px solid #dee2e6;
      border-radius: .25rem;
      max-width: 100%;
      height: auto;
    }

    .text-pink {
      color: #ff679b !important;
    }

    .btn-rounded {
      border-radius: 2em;
    }

    .text-muted {
      color: #98a6ad !important;
    }

    h4 {
      line-height: 22px;
      font-size: 18px;
    }

    body {
      margin-top: 20px;
      background: #f5f5f5;
    }

    /**
     * Panels
     */
    /*** General styles ***/
    .panel {
      box-shadow: none;
    }

    .panel-heading {
      border-bottom: 0;
    }

    .panel-title {
      font-size: 17px;
    }

    .panel-title > small {
      font-size: .75em;
      color: #999999;
    }

    .panel-body *:first-child {
      margin-top: 0;
    }

    .panel-footer {
      border-top: 0;
    }

    .panel-default > .panel-heading {
      color: #333333;
      background-color: transparent;
      border-color: rgba(0, 0, 0, 0.07);
    }

    form label {
      color: #999999;
      font-weight: 400;
    }

    .form-horizontal .form-group {
      margin-left: -15px;
      margin-right: -15px;
    }

    @media (min-width: 768px) {
      .form-horizontal .control-label {
        text-align: right;
        margin-bottom: 0;
        padding-top: 7px;
      }
    }

    .profile__contact-info-icon {
      float: left;
      font-size: 18px;
      color: #999999;
    }

    .profile__contact-info-body {
      overflow: hidden;
      padding-left: 20px;
      color: #999999;
    }

    .profile-avatar {
      width: 200px;
      position: relative;
      margin: 0px auto;
      margin-top: 196px;
      border: 4px solid #f3f3f3;
    }

  </style>
</head>
<body>
<div class="col-lg-4">
  <c:set var="student" value="${studentModel}"/>
  <div class="text-center card-box">
    <div class="member-card pt-2 pb-2">
      <div class="thumb-lg member-thumb mx-auto"><img src="https://bootdey.com/img/Content/avatar/avatar1.png"
                                                      class="rounded-circle img-thumbnail" alt="profile-image"></div>
      <div class="">
        <h4>${student.name} ${student.surname}</h4>
        <p class="text-muted">${student.name} <span>| </span><span><a href="#"
                                                                      class="text-pink">websitename.com</a></span>
        </p>
      </div>
      <ul class="social-links list-inline">
        <c:forEach var="link" items="${student.listOfContacts}">

          <li class="list-inline-item"><a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href=""
                                          data-original-title="Facebook">${link}<i class="fa fa-facebook"></i></a></li>
        </c:forEach>
      </ul>
      <c:set var="currentUser" value="${currentUser}"/>
      <c:if test="${not empty currentUser}">
        <button type="button" onclick="showOptions()"
                class="btn btn-primary mt-3 btn-rounded waves-effect w-md waves-light">Message Now
        </button>
      </c:if>

      <div id="userForm"></div>


      <div id="edit"> This is a div!!!!!!</div>
      <div class="mt-4">
        <div class="row">
          <div class="col-4">
            <div class="mt-3">
              <h4>7851</h4>
              <p class="mb-0 text-muted">Wallets Balance</p>
            </div>
          </div>
          <div class="col-4">
            <div class="mt-3">
              <h4>10020</h4>
              <p class="mb-0 text-muted">Income amounts</p>
            </div>
          </div>
          <div class="col-4">
            <div class="mt-3">
              <h4>1036</h4>
              <p class="mb-0 text-muted">Total Transactions</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<div class="container bootstrap snippets bootdeys">
  <div class="row">
    <div class="col-xs-12 col-sm-9">
      <form class="form-horizontal">
        <div class="panel panel-default">
          <div class="panel-body text-center">
            <img src="https://bootdey.com/img/Content/avatar/avatar6.png" class="img-circle profile-avatar"
                 alt="User avatar">
          </div>
        </div>
        <div class="panel panel-default">
          <div class="panel-heading">
            <h4 class="panel-title">User info</h4>
          </div>
          <div class="panel-body">
            <div class="form-group">
              <label class="col-sm-2 control-label">Location</label>
              <div class="col-sm-10">
                <select class="form-control">
                  <option selected="">Select country</option>
                  <option>Belgium</option>
                  <option>Canada</option>
                  <option>Denmark</option>
                  <option>Estonia</option>
                  <option>France</option>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">Company name</label>
              <div class="col-sm-10">
                <input type="text" class="form-control">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">Position</label>
              <div class="col-sm-10">
                <input type="text" class="form-control">
              </div>
            </div>
          </div>
        </div>

        <div class="panel panel-default">
          <div class="panel-heading">
            <h4 class="panel-title">Contact info</h4>
          </div>
          <div class="panel-body">
            <div class="form-group">
              <label class="col-sm-2 control-label">Work number</label>
              <div class="col-sm-10">
                <input type="tel" class="form-control">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">Mobile number</label>
              <div class="col-sm-10">
                <input type="tel" class="form-control">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">E-mail address</label>
              <div class="col-sm-10">
                <input type="email" class="form-control">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">Work address</label>
              <div class="col-sm-10">
                <textarea rows="3" class="form-control"></textarea>
              </div>
            </div>
          </div>
        </div>

        <div class="panel panel-default">
          <div class="panel-heading">
            <h4 class="panel-title">Security</h4>
          </div>
          <div class="panel-body">
            <div class="form-group">
              <label class="col-sm-2 control-label">Current password</label>
              <div class="col-sm-10">
                <input type="password" class="form-control">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">New password</label>
              <div class="col-sm-10">
                <input type="password" class="form-control">
              </div>
            </div>
            <div class="form-group">
              <div class="col-sm-10 col-sm-offset-2">
                <div class="checkbox">
                  <input type="checkbox" id="checkbox_1">
                  <label for="checkbox_1">Make this account public</label>
                </div>
              </div>
            </div>
            <div class="form-group">
              <div class="col-sm-10 col-sm-offset-2">
                <button type="submit" class="btn btn-primary">Submit</button>
                <button type="reset" class="btn btn-default">Cancel</button>
              </div>
            </div>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
<script>
  $('buttonId').on('click', function () {

    var data = 'dmc=' + encodeURIComponent(dmc.value);
    $.ajax({
      url: "homepageStudent/tasks",
      data: data,
      type: "GET",

      success: function (response) {
        alert(response);
        $message._show('success', response);
      },
      error: function (xhr, status, error) {
        alert(xhr.responseText);
      },
      complete: function () {
        window.location = 'profile.jsp';
      }
    });
  });

  function showOptions() {
    var i = document.getElementById('edit');
    if (i.style.visibility === 'hidden') {
      i.style.visibility = 'visible';
    }
    if (i.style.visibility === 'visible') {
      i.style.visibility = 'hidden';
    }
  }
</script>
</body>

</html>
