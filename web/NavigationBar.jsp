<!DOCTYPE html>
<html lang=en>
<head>
    <meta charset=UTF-8>
    <link rel="stylesheet" href="LibraryManagement.css">
</head>
<body>
<ul>
    <li><a href=Authentication?user_name=<%=request.getServletContext().getAttribute("userName")%>&password=<%=request.getServletContext().getAttribute("password")%>>Home</a></li>
    <li><a href=SaveBook.jsp>Save</a></li>
    <li><a href=DeleteBook.jsp>Delete</a></li>
    <li><a href=UpdateBook.jsp>Update</a></li>
    <li><a href=DisplayBook.jsp>Display</a></li>
    <li><a href=Logout>LogOut</a></li>
    <li style=float:right>
        <form action=Search>
            <input type="text" style="background-color:#bcb8c4" placeholder="Search..." name="search">
            <button style="color: rgba(0,15,148,0.81);background-color:rgba(149,61,103,0.6) " type="submit">Submit</button>
        </form>
    </li>
</ul>
</body>
</html>