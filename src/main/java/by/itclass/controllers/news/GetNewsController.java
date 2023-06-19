package by.itclass.controllers.news;

import by.itclass.constants.AppConstant;
import by.itclass.controllers.abstracs.AbstractNewsController;
import by.itclass.model.dto.NewsDTO;
import by.itclass.model.utils.ImageUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GetNewsController", urlPatterns = AppConstant.URL_GET_NEWS_CONT)
public class GetNewsController extends AbstractNewsController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idNews = request.getParameter(AppConstant.ID_LABEL);
        String nextUrl = request.getParameter(AppConstant.NEXT_URL_LABEL);
        String referer = request.getHeader("Referer");
        int id = Integer.parseInt(idNews);

        NewsDTO newsDTO = newsFacade.get(id);
        //-->
        ServletContext context = this.getServletContext();
        String path = context.getRealPath(AppConstant.IMAGE_WEB_REPOSITORY);
        ImageUtil.createImageFile(path, newsDTO.getImage());
        //<--

        request.setAttribute("referer", referer);
        request.setAttribute(AppConstant.NEWS_ATTR, newsDTO);
        forward(request, response, nextUrl);
    }
}
