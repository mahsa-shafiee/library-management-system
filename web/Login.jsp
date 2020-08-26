<%--
  Created by IntelliJ IDEA.
  User: Mahsa
  Date: 6/27/2020
  Time: 12:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Login</title>
    <link rel="stylesheet" href="LoginForm.css">
</head>
<body>
<div class="login-box">
    <h1>Login</h1>
    <form action="Authentication" method="GET">
        <div class="textbox">
            <i class="fas fa-user"></i>
            <input autocomplete="off" type="text" name="user_name" placeholder="User Name" required="">
        </div>
        <div class="textbox">
            <i class="fas fa-lock"></i>
            <input autocomplete="off" type="password" name="password" placeholder="Password" required="">
        </div>
        <br><br>
        <center><input type="submit" class="btn" value="LOGIN"><br>
            <h3>
                <span>You are not a member ?</span>
                <a href="Register.jsp">REGISTER NOW</a><br>
            </h3>
        </center>
    </form>
</div>

</body>
</html>
