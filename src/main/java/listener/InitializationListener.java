package listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ProductDAO;
import dao.UserDAO;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import service.ProductService;
import service.UserService;

import java.io.File;

@WebListener
public class InitializationListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        ObjectMapper objectMapper = new ObjectMapper();
        File usersFile = new File("C:\\YandexDisk\\IdeaProjects\\servlet-example-gradle\\src\\main\\resources\\users.json");
        File productsFile = new File("C:\\YandexDisk\\IdeaProjects\\servlet-example-gradle\\src\\main\\resources\\products.json");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        UserDAO userDAO = new UserDAO(objectMapper, usersFile);
        ProductDAO productDAO = new ProductDAO(objectMapper, productsFile);
        UserService userService = new UserService(userDAO);
        ProductService productService = new ProductService(productDAO);

        servletContext.setAttribute("userService", userService);
        servletContext.setAttribute("passwordEncoder", passwordEncoder);
        servletContext.setAttribute("productService", productService);
    }
}
