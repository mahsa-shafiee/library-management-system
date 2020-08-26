<%--
  Created by IntelliJ IDEA.
  User: Mahsa
  Date: 6/27/2020
  Time: 12:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body style="background-color: antiquewhite">
<center>
    <form><br><br>
        <input type="text" name="first_name" placeholder="First Name" required><br><br>
        <input type="text" name="last_name" placeholder="Last Name" required><br><br>
        <input type="text" name="user_name" placeholder="User Name" required><br><br>
        <input type="text" name="email_address" placeholder="Email Address" required><br><br>
        <input type="text" name="password" placeholder="Password" required><br><br>
        <input type="text" name="confirm_password" placeholder="Confirm Password" required><br><br>
        <input type="submit" formaction="Registration" formmethod="GET" value="REGISTER">
        <input type="submit" formaction="/Library" formmethod="POST" value="CANCEL" formnovalidate>
    </form>
</center>
</body>
</html>
