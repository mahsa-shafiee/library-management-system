package servlet;

import model.dao.UserDao;
import model.entity.User;

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

@WebServlet(name = "servlet.Registration")
public class Registration extends HttpServlet {
    private UserDao userDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String user_name = request.getParameter("user_name");
        String email_address = request.getParameter("email_address");
        String password = request.getParameter("password");
        String confirm_password = request.getParameter("confirm_password");

        if (!password.equals(confirm_password)) {
            writer.println("<center><h3>PASSWORDS ARE NOT EQUAL!</h3></center>");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Register.jsp");
            requestDispatcher.include(request, response);
        } else {
            User user = new User(first_name, last_name, user_name, email_address, password);
            userDao.insert(user);
            HttpSession session = request.getSession();
            session.setAttribute("first_name", first_name);
            ServletContext servletContext = getServletContext();
            servletContext.setAttribute("userName", user_name);
            servletContext.setAttribute("password", password);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("LibraryManagement");
            requestDispatcher.forward(request, response);
        }
    }
}
