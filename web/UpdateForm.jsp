<%--
  Created by IntelliJ IDEA.
  User: Mahsa
  Date: 7/3/2020
  Time: 11:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UPDATE BOOK</title>
</head>
<body>
<%@include file="NavigationBar.jsp" %>
<br><br>
<h3>
    <form action="Update" method="GET">
        <input type="hidden" name="id" value="<%=request.getParameter("id")%>">
        <label for="name">Book Name</label>
        <input type="text" name="name" id="name">
        <label for="author">Author</label>
        <input type="text" name="author" id="author">
        <label for="memberId">Member Id</label>
        <input type="number" name="memberId" id="memberId">
        <input type="submit" value="SAVE"><br>
    </form>
</h3>
</body>
</html>
