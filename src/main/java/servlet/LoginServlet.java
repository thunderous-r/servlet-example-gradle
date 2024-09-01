package servlet;

import entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

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
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        List<User> users = userService.getAllUsers();
        Optional<User> existingUser = users.stream().filter(user -> passwordEncoder.matches(password, user.getPassword())).findFirst();
        if (existingUser.isPresent()) {
            session.setAttribute("userId", existingUser.get().getUuid());
            resp.sendRedirect("/secure/products");
        } else {
            req.setAttribute("wrongUser", 1);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }

    }
}
