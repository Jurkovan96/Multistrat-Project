<html>
<head>
    <title>Homepage</title>
    <link rel="stylesheet" type="text/css" href="css/homepage.css">

</head>
<body>
<div id="main">
    <div id="loggedUser">
        <div id="textBox">
            <h4 id="userText"><span id="hello">Hello,</span> <c:out value="${loggedUser.getName()}"/> !</h4>

            <a href="#">

                <div id="imgDiv">
                    <img id="imgSettings" src="images/settingscolor.png" alt="Not found!" width="25px">
                    <ul id="userSettings">
                        <li><a href="/mainpage/${user.id}/settings" style="text-decoration: none">Edit user data</a>
                        </li>
                        <li><a href="/mainpage/${user.id}/settings/edit-adress" style="text-decoration: none">Edit
                            adress</a></li>
                    </ul>

                </div>
            </a>
            <div id="logoutUser">
                <h3><a href="/mainpage/logout" class="logOut">Logout</a></h3>

            </div>

        </div>


    </div>
    <div id="header">
        <div id="logo">
            <div id="logo_text">
                <h1><a href="index.html">V<span class="logo_colour">Art</span></a></h1>
                <h2>Simple. Auction. Website.</h2>
            </div>
        </div>
        <div id="menubar">
            <ul id="menu">

                <li><a href="/mainpage/${user.id}">Home Page</a></li>
                <li><a href="/mainpage/${user.id}/products">Art</a></li>
                <li><a href="/mainpage/${user.id}/about">Auctions</a></li>
                <li><a href="/mainpage/${user.id}/contact">Your auctions</a></li>
                <li><a href="/mainpage/${user.id}/orders">Orders</a></li>

            </ul>
        </div>
    </div>
    <div id="site_content">
        <div class="sidebar">


            <h4 id="textH4"> Leave us a message!</h4>
            <h5>Any suggestions you have please enter the comment below and hit enter</h5>
            <form method="post" id="usrform">
                <textarea style="width: 100%;" rows="4" cols="50" name="comment" form="usrform">
           </textarea>
                <button type="submit" style="width: 100%">Sent message</button>
            </form>
            <br>

        </div>
    </div>
    <div id="content_footer"></div>

    <div id="footer"> Some content <br>
    </div>
</div>
</div>
</body>
</html>