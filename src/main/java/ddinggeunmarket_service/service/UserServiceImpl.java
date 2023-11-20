package ddinggeunmarket_service.service;


import ddinggeunmarket_service.jpa.User;
import ddinggeunmarket_service.jpa.UserDTO;
import ddinggeunmarket_service.jpa.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User login(String id, String password) {
        System.out.println(id + " " + password);
        String userPw = userRepository.getUserById(id).getPassword();
        if (userPw == null || !userPw.equals(password)) {
            return null;
        }
        return userRepository.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(UserDTO userDTO) {
        User user = new User(userDTO);
        return userRepository.save(user);
    }

    @Override
    public User getUserById(String id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User updateUser(UserDTO userDTO) {
        User user = new User(userDTO);
        return userRepository.save(user);
    }

    @Override
    public boolean deleteUserById(String id) {
        try {
            User user = getUserById(id);
            userRepository.delete(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
