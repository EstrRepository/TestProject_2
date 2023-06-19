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


@WebServlet(name = "UploadImageUserController", urlPatterns = AppConstant.UPLOAD_IMAGE_USER_CONT)
public class UploadImageUserController extends AbstractUserController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute(AppConstant.USER_ATTR);

        String fileName = (String) request.getAttribute(AppConstant.FILE_NAME_LABEL);
        byte[] fileContent = (byte[]) request.getAttribute(AppConstant.FILE_CONTENT_LABEL);

        userFacade.uploadImage(userDTO, fileName, fileContent);

        ServletContext context = this.getServletContext();
        String path = context.getRealPath(AppConstant.IMAGE_WEB_REPOSITORY);
        ImageUtil.createImageFile(path, userDTO.getImage());

        request.setAttribute(AppConstant.USER_ATTR, userDTO);
        forward(request, response, AppConstant.CABINET_JSP);
    }

}
