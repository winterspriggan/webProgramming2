package ddinggeunmarket_service.service;

import ddinggeunmarket_service.jpa.user.User;
import ddinggeunmarket_service.jpa.user.UserDTO;

import java.util.List;

public interface UserService {

    User login(String id, String password);
    User accessByKakao(String email, String nickname);
    List<User> getAllUsers();

    User createUser(UserDTO userDTO);

    User getUserById(String id);

    User updateUser(UserDTO userDTO);

    boolean deleteUserById(String id);

    void addWishList(String userId, Long itemId);


}
