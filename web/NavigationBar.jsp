<!DOCTYPE html>
<html lang=en>
<head>
    <meta charset=UTF-8>
    <link rel="stylesheet" href="LibraryManagement.css">
</head>
<body>
<ul>
    <li>
        <a href=Authentication?user_name=<%=request.getServletContext().getAttribute("userName")%>&password=<%=request.getServletContext().getAttribute("password")%>>Home</a>
    </li>
    <li><a href="SaveBook.jsp">Save</a></li>
    <li><a href="DeleteBook.jsp">Delete</a></li>
    <li><a href="UpdateBook.jsp">Update</a></li>
    <li><a href="DisplayBook.jsp">Display</a></li>
    <li><a href="Logout">LogOut</a></li>
    <li style="margin-right: 40px;float:right;">
        <form action="Search" style="margin: 0;"></form>
        <input type="text"
               style="background-color: #f9ead7;height: 35px;width: 184px;"
               placeholder="Search..." name="search">
        <button style="color: rgb(97 58 52);background-color: #d69f78;height: 35px;font-size: 15px;width: 78px;"
                type="submit">Submit
        </button>
    </li>
</ul>
</body>
</html>