<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 7/2/20
  Time: 8:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DELETE BOOK</title>
</head>
<body>
<%@include file="NavigationBar.jsp" %>
<br><br>
<h3>
    <form action="Delete" method="GET">
        <label for="id">Enter book id:</label>
        <input type="number" name="id" id="id" required>
        <input type="submit" value="DELETE"><br>
    </form>
</h3>
</body>
</html>
