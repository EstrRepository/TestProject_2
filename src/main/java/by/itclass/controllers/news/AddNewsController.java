package by.itclass.controllers.news;

import by.itclass.constants.AppConstant;
import by.itclass.controllers.abstracs.AbstractNewsController;
import by.itclass.model.dto.NewsDTO;
import by.itclass.model.dto.UserDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddNewsController", urlPatterns = AppConstant.URL_ADD_NEWS_CONT)
public class AddNewsController extends AbstractNewsController {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String title = (String) request.getAttribute(AppConstant.TITLE_LABEL);
        String text = (String) request.getAttribute(AppConstant.TEXT_LABEL);
        String fileName = (String) request.getAttribute(AppConstant.FILE_NAME_LABEL);
        byte[] fileContent = (byte[]) request.getAttribute(AppConstant.FILE_CONTENT_LABEL);

        UserDTO user = (UserDTO) session.getAttribute(AppConstant.USER_ATTR);

        NewsDTO newsDTO = new NewsDTO(title, text, user.getLogin());
        newsFacade.add(newsDTO, user.getId(), fileName, fileContent);
        redirect(response, AppConstant.URL_MY_NEWS_CONT);

    }
}
