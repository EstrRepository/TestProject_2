package by.itclass.controllers.news;

import by.itclass.constants.AppConstant;
import by.itclass.controllers.abstracs.AbstractNewsController;
import by.itclass.model.dto.NewsDTO;
import by.itclass.model.dto.UserDTO;
import by.itclass.model.utils.ImageUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserNewsListController", urlPatterns = AppConstant.URL_MY_NEWS_CONT)
public class UserNewsListController extends AbstractNewsController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        UserDTO user = (UserDTO) session.getAttribute(AppConstant.USER_ATTR);

        List<NewsDTO> newsList = newsFacade.get(user);
        request.setAttribute(AppConstant.NEWS_LIST_ATTR, newsList);

        for (NewsDTO news : newsList) {
            //-->
            ServletContext context = this.getServletContext();
            String path = context.getRealPath(AppConstant.IMAGE_WEB_REPOSITORY);
            if (news.getImage().getContent() != null) {
                ImageUtil.createImageFile(path, news.getImage());
            }
            //<--
        }
        forward(request, response, AppConstant.MY_NEWS_JSP);

    }

}