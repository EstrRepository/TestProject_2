package by.itclass.model.services;

import by.itclass.model.dao.impl.UserDAOHibernateImpl;
import by.itclass.model.dao.interfaces.UserDAO;
import by.itclass.model.entities.Image;
import by.itclass.model.entities.User;
import by.itclass.model.utils.ImageUtil;


public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    public UserServiceImpl() {
       userDAO = new UserDAOHibernateImpl();
    }

    @Override
    public boolean registration(User user) {
        String path = "D:/Мои документы/TEST/TestProject_1/src/main/webapp/image/";
        String fileName = ImageUtil.getImage(path).getName();
        Image image = new Image(fileName, ImageUtil.getImage(path).getContent());
        user.setImage(image);
        return userDAO.save(user);
    }

    @Override
    public User authorization(String loginOrEmail, String password) {
        return userDAO.get(loginOrEmail, password);
    }

    @Override
    public boolean refactor(User user) {
        return userDAO.update(user);
    }

    @Override
    public void uploadImage(User user) {
        userDAO.saveImage(user);
    }
}
