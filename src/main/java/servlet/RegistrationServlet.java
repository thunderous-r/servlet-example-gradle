package servlet;

import entity.User;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import service.UserService;

import java.io.IOException;
import java.util.UUID;

@WebServlet(urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {
    private UserService userService;
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        userService = (UserService) servletContext.getAttribute("userService");
        passwordEncoder = (BCryptPasswordEncoder) servletContext.getAttribute("passwordEncoder");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("username");
        String password = req.getParameter("password");
        String hashedPassword = passwordEncoder.encode(password);
        userService.saveUser(User.builder().
                uuid(UUID.randomUUID()).
                login(login).
                password(hashedPassword).build());

        resp.sendRedirect("/login");
    }
}
