package by.itclass.filters;

import by.itclass.constants.AppConstant;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "CharacterEncodingFilter", urlPatterns = {AppConstant.URL_ADD_NEWS_CONT, AppConstant.URL_MY_NEWS_CONT, AppConstant.URL_REFACTOR_NEWS_CONT, AppConstant.UPLOAD_IMAGE_USER_CONT, AppConstant.URL_GET_NEWS_CONT, AppConstant.URL_MY_NEWS_CONT, AppConstant.URL_NEWS_CONT, AppConstant.NEWS_JSP, AppConstant.ADDNEWS_JSP, AppConstant.CABINET_JSP, AppConstant.MY_NEWS_JSP, AppConstant.INDEX_JSP, AppConstant.EDIT_NEWS_JSP})
public class CharacterEncodingFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }
}
