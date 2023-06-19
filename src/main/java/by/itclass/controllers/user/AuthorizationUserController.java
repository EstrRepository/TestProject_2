package by.itclass.controllers.user;

import by.itclass.constants.AppConstant;
import by.itclass.controllers.abstracs.AbstractUserController;
import by.itclass.model.dto.UserDTO;
import by.itclass.model.utils.ImageUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "AuthorizationUserController", urlPatterns = AppConstant.URL_AUTH_CONT)
public class AuthorizationUserController extends AbstractUserController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginOrEmail = request.getParameter(AppConstant.LOGIN_OR_EMAIL_LABEL);
        String password = request.getParameter(AppConstant.PASSWORD_LABEL);

        UserDTO user = userFacade.authorization(loginOrEmail, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute(AppConstant.USER_ATTR, user);

            //-->
            ServletContext context = this.getServletContext();
            String path = context.getRealPath(AppConstant.IMAGE_WEB_REPOSITORY);
            ImageUtil.createImageFile(path, user.getImage());
            //<--
            redirect(response, AppConstant.CABINET_JSP);
        }else {
            forward(request, response, AppConstant.AUTH_JSP);
        }
    }

}
