package servlet;

import model.dao.BookDao;
import model.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(name = "servlet.Display")
public class Display extends HttpServlet {
    private BookDao bookDao = new BookDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession(false);
        if (Objects.nonNull(session)) {
            String first_name = (String) session.getAttribute("first_name");
            if (first_name != null) {
                session.setAttribute("first_name", first_name);
                request.getRequestDispatcher("NavigationBar.jsp").include(request, response);
                writer.print("<style> body {" +
                        "  background-image: none ;" +
                        "  background-color: rgba(0,2,148,0.82) ;" +
                        "}</style>");
                int id = Integer.parseInt(request.getParameter("id"));
                Book book = bookDao.findById(id);
                writer.println("<br><br><center><h1>" +
                        "<h3>BOOK DETAILS</h3>" +
                        "<br>BOOK ID : " + book.getId() +
                        "<br>BOOK NAME : " + book.getName().toUpperCase() +
                        "<br>AUTHOR : " + book.getAuthor().toUpperCase() +
                        "<br>MEMBER ID : " + book.getMember_id()
                        + "</h1>");
            } else writer.println("access is denied");
        } else writer.println("session is killed");
        writer.close();
    }
}
