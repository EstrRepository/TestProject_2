package by.itclass.controllers.user;

import by.itclass.constants.AppConstant;
import by.itclass.controllers.abstracs.AbstractUserController;
import by.itclass.model.dto.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistrationUserController", urlPatterns = AppConstant.URL_REGIST_CONT)
public class RegistrationUserController extends AbstractUserController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter(AppConstant.LOGIN_LABEL);
        String password = request.getParameter(AppConstant.PASSWORD_LABEL);
        String email = request.getParameter(AppConstant.EMAIL_LABEL);

        UserDTO user = new UserDTO(login, email);

        if (userFacade.registration(user, password)) {
            forward(request, response, AppConstant.AUTH_JSP);
        } else {
            forward(request, response, AppConstant.REGIST_JSP);
        }
    }
}
