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

@WebServlet(name = "servlet.Update")
public class Update extends HttpServlet {
    BookDao bookDao = new BookDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession(false);
        if (Objects.nonNull(session)) {
            String first_name = (String) session.getAttribute("first_name");
            session.setAttribute("first_name", first_name);
            if (first_name != null) {
                request.getRequestDispatcher("NavigationBar.jsp").include(request, response);
                writer.print("<style> body {" +
                        "  background-image: none ;" +
                        "  background-color: rgba(0,2,148,0.82) ;" +
                        "}</style>");
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                String author = request.getParameter("author");
                String memberId = request.getParameter("memberId");
                Book book = new Book(name, author, memberId);
                book.setId(id);
                bookDao.update(book);
                writer.println("<body><center><br><br><h1>successfully updated.</h1>");
            } else writer.println("access is denied");
        } else writer.println("session is killed");
        writer.close();
    }
}
