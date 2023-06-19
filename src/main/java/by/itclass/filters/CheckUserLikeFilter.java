package by.itclass.filters;

import by.itclass.constants.AppConstant;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "CheckUserLikeFilter", urlPatterns = AppConstant.URL_LIKE_NEWS_CONT)
public class CheckUserLikeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        if (session.getAttribute(AppConstant.USER_ATTR) != null) {
            chain.doFilter(request, response);
        } else {
            resp.setContentType("text/html; charset=UTF-8");
            try (PrintWriter out = resp.getWriter()){
                out.println("<html>" +
                        "<body>" +
                        "<h4> Ставить лайки могут только зарегистрированные пользователи </h4>" +
                        "<a class=nav-link href=/TestProject_1/reg.jsp> Регистрация</a>" +
                        "</body>" +
                        "</html>");
            }

        }
    }
}
