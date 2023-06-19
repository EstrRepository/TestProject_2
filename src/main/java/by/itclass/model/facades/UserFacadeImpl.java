package by.itclass.model.facades;


import by.itclass.model.dto.UserDTO;
import by.itclass.model.entities.Image;
import by.itclass.model.entities.User;
import by.itclass.model.mapper.UserMapper;
import by.itclass.model.services.UserServiceImpl;


public class UserFacadeImpl implements UserFacade {
    private UserServiceImpl userService;

    public UserFacadeImpl() {
        userService = new UserServiceImpl();
    }

    @Override
    public boolean registration(UserDTO userDTO, String password) {
        User user = UserMapper.map(userDTO);
        user.setPassword(password);
        return userService.registration(user);
    }

    @Override
    public UserDTO authorization(String loginOrEmail, String password) {
        User user = userService.authorization(loginOrEmail, password);
        return UserMapper.map(user);
    }

    @Override
    public boolean refactor(UserDTO userDTO, String password) {
        User user = UserMapper.map(userDTO);
        user.setPassword(password);
        return userService.refactor(user);
    }

    @Override
    public void uploadImage(UserDTO userDTO, String fileName, byte[] fileContent) {
        userDTO.setImage(new Image(fileName, fileContent));
        User user = UserMapper.map(userDTO);
        userService.uploadImage(user);
    }
}
