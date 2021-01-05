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
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

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
  </style>
</head>
<body>
<div class="container">
  <div class="text-center card-box">
    <div class="member-card pt-2 pb-2">
      <div class="thumb-lg member-thumb mx-auto"><img src="https://bootdey.com/img/Content/avatar/avatar1.png"
                                                      class="rounded-circle img-thumbnail" alt="profile-image"></div>
      <div class="">
        <h4>Mathias L. Lassen</h4>
        <p class="text-muted">@Webdesigner <span>| </span><span><a href="#" class="text-pink">websitename.com</a></span>
        </p>
      </div>
      <ul class="social-links list-inline">
        <li class="list-inline-item"><a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href=""
                                        data-original-title="Facebook"><i class="fa fa-facebook"></i></a></li>
        <li class="list-inline-item"><a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href=""
                                        data-original-title="Twitter"><i class="fa fa-twitter"></i></a></li>
        <li class="list-inline-item"><a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href=""
                                        data-original-title="Skype"><i class="fa fa-skype"></i></a></li>
      </ul>
      <button type="button" class="btn btn-primary mt-3 btn-rounded waves-effect w-md waves-light">Message Now</button>
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
</script>
</body>

</html>
