<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DISPLAY BOOK</title>
</head>
<body>
<%@include file="NavigationBar.jsp" %>
<br><br>
<h3>
    <form action="Display" method="GET">
        <label for="id">Enter book id:</label>
        <input type="number" name="id" id="id" required>
        <input type="submit" value="DISPLAY"><br>
    </form>
</h3>
</body>
</html>
