package servlet;

import model.dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "servlet.Authentication")
public class Authentication extends HttpServlet {
    private UserDao userDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String user_name = request.getParameter("user_name");
        String password = request.getParameter("password");
        String first_name = userDao.findUser(user_name, password);
        if (first_name != null) {
            HttpSession session = request.getSession();
            session.setAttribute("first_name", first_name);
            ServletContext servletContext = getServletContext();
            servletContext.setAttribute("userName", user_name);
            servletContext.setAttribute("password", password);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("LibraryManagement");
            requestDispatcher.forward(request, response);
        } else {
            writer.println("<center><h1 style=\"color:red\"><B><br>" +
                    "ACCESS IS DENIED!TRY AGAIN..." +
                    "</B></h1></center>");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
            requestDispatcher.include(request, response);
        }
        writer.close();
    }
}