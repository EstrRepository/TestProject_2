package by.itclass.model.dao.interfaces;

import by.itclass.model.entities.User;

public interface UserDAO {
    boolean save(User user);
    User get(String loginOrEmail, String password);
    boolean update(User user);
    boolean saveImage(User user);
}
