package by.itclass.model.services;

import by.itclass.model.entities.User;

public interface UserService {
    boolean registration(User user);

    User authorization(String loginOrEmail, String password);

    boolean refactor(User user);

    void uploadImage(User user);
}
