package by.itclass.controllers.abstracs;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Задавёт начальную реализацию и начальное поведение др.контроллерам ч/наследования
@WebServlet(name = "AbstractController")
public abstract class AbstractController extends javax.servlet.http.HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void forward(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
        request.getRequestDispatcher(url)
                .forward(request, response);
    }

    protected void redirect(HttpServletResponse response, String url) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        response.sendRedirect(context.getContextPath() + url);
    }
}
