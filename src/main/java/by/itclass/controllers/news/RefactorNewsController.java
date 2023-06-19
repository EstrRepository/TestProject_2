package by.itclass.controllers.news;

import by.itclass.constants.AppConstant;
import by.itclass.controllers.abstracs.AbstractNewsController;
import by.itclass.model.dto.NewsDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RefactorNewsController", urlPatterns = AppConstant.URL_REFACTOR_NEWS_CONT)
public class RefactorNewsController extends AbstractNewsController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idNews = (String) request.getAttribute(AppConstant.ID_LABEL);
        String title = (String) request.getAttribute(AppConstant.TITLE_LABEL);
        String text = (String) request.getAttribute(AppConstant.TEXT_LABEL);
        String fileName = (String) request.getAttribute(AppConstant.FILE_NAME_LABEL);
        byte[] fileContent = (byte[]) request.getAttribute(AppConstant.FILE_CONTENT_LABEL);
        int id = Integer.parseInt(idNews);

        NewsDTO newsDTO = new NewsDTO(id, title, text);

        newsFacade.refactor(newsDTO, fileName, fileContent);

        redirect(response, AppConstant.URL_MY_NEWS_CONT);
    }
}
