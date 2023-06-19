package by.itclass.controllers.news;

import by.itclass.constants.AppConstant;
import by.itclass.controllers.abstracs.AbstractNewsController;
import by.itclass.model.comparator.SortedNewsByLikesComparator;
import by.itclass.model.dto.NewsDTO;
import by.itclass.model.utils.ImageUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "NewsListController", urlPatterns = AppConstant.URL_NEWS_CONT)
public class NewsListController extends AbstractNewsController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NewsDTO> newsList = newsFacade.get();

        List<NewsDTO> topNewsList = new ArrayList<>(newsList);
        topNewsList.sort(new SortedNewsByLikesComparator());

        for (NewsDTO news : newsList) {
            //-->
            ServletContext context = this.getServletContext();
            String path = context.getRealPath(AppConstant.IMAGE_WEB_REPOSITORY);
            if (news.getImage().getContent() != null) {
                ImageUtil.createImageFile(path, news.getImage());
            }
            //<--
        }
        request.setAttribute(AppConstant.NEWS_LIST_ATTR, newsList);
        request.setAttribute(AppConstant.TOP_NEWS_LIST_ATTR, topNewsList);
        forward(request, response, AppConstant.INDEX_JSP);

    }

}