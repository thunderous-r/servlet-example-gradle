package listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
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
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@WebListener
public class InitializationListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        Properties dbProperties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("C:\\YandexDisk\\IdeaProjects\\servlet-example-gradle\\src\\main\\resources\\db.properties");
            dbProperties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HikariConfig config = new HikariConfig(dbProperties);
        HikariDataSource ds = new HikariDataSource(config);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        UserDAO userDAO = new UserDAO(ds);

        ProductDAO productDAO = new ProductDAO(ds);
        UserService userService = new UserService(userDAO);
        ProductService productService = new ProductService(productDAO);

        servletContext.setAttribute("userService", userService);
        servletContext.setAttribute("passwordEncoder", passwordEncoder);
        servletContext.setAttribute("productService", productService);
    }
}
