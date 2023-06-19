package by.itclass.controllers.news;

import by.itclass.constants.AppConstant;
import by.itclass.controllers.abstracs.AbstractNewsController;
import by.itclass.model.dto.NewsDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteNewsController", urlPatterns = AppConstant.URL_REMOVE_NEWS_CONT)
public class RemoveNewsController extends AbstractNewsController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idNews = request.getParameter(AppConstant.ID_LABEL);
        int id = Integer.parseInt(idNews);
        NewsDTO newsDTO = new NewsDTO(id);
        newsFacade.remove(newsDTO);
        redirect(response, AppConstant.URL_MY_NEWS_CONT);
    }


}
