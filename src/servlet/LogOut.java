package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(name = "servlet.LogOut")
public class LogOut extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession(false);
        if (Objects.nonNull(session)) {
            String name = (String) session.getAttribute("first_name");
            if (name != null) {
                writer.println(name + " log out successfully.");
                ServletContext servletContext = getServletContext();
                String users = (String) servletContext.getAttribute("users");
                users = users.substring(0, users.indexOf(name))
                        + users.substring(users.indexOf(name) + name.length());
                servletContext.setAttribute("users", users);
                servletContext.setAttribute("userName", " ");
                servletContext.setAttribute("password", " ");
            } else writer.println("access is denied");
            session.invalidate();
        } else writer.println("session is killed");
        writer.close();
    }
}
