package by.itclass.model.facades;

import by.itclass.model.dto.UserDTO;

public interface UserFacade {
    boolean registration (UserDTO userDTO, String password);
    UserDTO authorization (String loginOrEmail, String password);
    boolean refactor (UserDTO userDTO, String password);
    void uploadImage (UserDTO userDTO, String fileName, byte[] fileContent);
}
