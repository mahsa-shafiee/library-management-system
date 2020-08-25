package servlet;

import model.dao.BookDao;
import model.entity.Book;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "servlet.LibraryManagement")
public class LibraryManagement extends HttpServlet {
    private BookDao bookDao = new BookDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession(false);
        if (Objects.nonNull(session)) {

            String first_name = (String) session.getAttribute("first_name");
            session.setAttribute("first_name", first_name);
            List<Book> allBooks = bookDao.findAll();
            ServletContext servletContext = getServletContext();
            String users = (String) servletContext.getAttribute("users");
            if (users == null)
                users = first_name;
            else {
                if (!users.contains(first_name))
                    users = users + " " + first_name;
            }
            servletContext.setAttribute("users", users);
            writer.println("<center><B><h3><br><br>Welcome " + first_name + " !<br>Online users : " + users + "</h3>");
            writer.println("<table style=\"width:30%\">");
            writer.println("<tr><th>id</th>");
            writer.println("<th>name</th></tr>");

            allBooks.forEach(book -> {
                writer.println("<tr><td>" + book.getId() + "</td>");
                writer.println("<td>" + book.getName() + "</td></tr>");
            });
            request.getRequestDispatcher("NavigationBar.jsp").include(request, response);
        } else
            writer.println("session is killed");
        writer.close();
    }
}