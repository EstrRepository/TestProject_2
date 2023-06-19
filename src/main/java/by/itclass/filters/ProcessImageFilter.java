package by.itclass.filters;

import by.itclass.constants.AppConstant;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

//проверяет является ли полученный объект картинкой
@WebFilter(filterName = "ProcessImageFilter", urlPatterns = {AppConstant.URL_ADD_NEWS_CONT, AppConstant.URL_REFACTOR_NEWS_CONT, AppConstant.UPLOAD_IMAGE_USER_CONT})
public class ProcessImageFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setRepository(new File(AppConstant.TEMP_FILE_REPOSITORY));

        try {
            ServletFileUpload uploader = new ServletFileUpload(factory);
            List<FileItem> itemList = uploader.parseRequest(req);
            for (FileItem item : itemList) {
                if (item.isFormField()) {
                    req.setAttribute(item.getFieldName(), item.getString());
                } else {
                    req.setAttribute(AppConstant.FILE_NAME_LABEL, item.getName());
                    req.setAttribute(AppConstant.FILE_CONTENT_LABEL, item.get());
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        chain.doFilter(request, response);
    }
}
