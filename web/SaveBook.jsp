<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 7/2/20
  Time: 7:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD BOOK</title>
</head>
<body>
<%@include file="NavigationBar.jsp" %>
<br><br>
<h3>
    <form action="Save" method="GET">
        <label for="name">Book Name</label>
        <input type="text" name="name" id="name" required>
        <label for="author">Author</label>
        <input type="text" name="author" id="author" required>
        <label for="memberId">Member Id</label>
        <input type="number" name="memberId" id="memberId" required>
        <input type="submit" value="SAVE"><br>
    </form>
</h3>
</body>
</html>
