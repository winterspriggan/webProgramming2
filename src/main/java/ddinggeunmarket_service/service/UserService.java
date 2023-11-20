package ddinggeunmarket_service.service;

import ddinggeunmarket_service.jpa.User;
import ddinggeunmarket_service.jpa.UserDTO;

import java.util.List;

public interface UserService {

    User login(String id, String password);
    List<User> getAllUsers();

    User createUser(UserDTO userDTO);

    User getUserById(String id);

    User updateUser(UserDTO userDTO);

    boolean deleteUserById(String id);
}
