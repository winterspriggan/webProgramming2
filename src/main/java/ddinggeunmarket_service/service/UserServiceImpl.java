package ddinggeunmarket_service.service;


import ddinggeunmarket_service.jpa.MyPage.Item;
import ddinggeunmarket_service.jpa.MyPage.ItemRepository;
import ddinggeunmarket_service.jpa.MyPage.WishList;
import ddinggeunmarket_service.jpa.MyPage.WishListRepository;
import ddinggeunmarket_service.jpa.user.User;
import ddinggeunmarket_service.jpa.user.UserDTO;
import ddinggeunmarket_service.jpa.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private WishListRepository wishListRepository;

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


    public void addWishList(String userId, Long itemId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));

        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("Item not found with id: " + itemId));


        WishList wishList = new WishList();
        wishList.setUser(user);
        wishList.setItem(item);

        wishListRepository.save(wishList);
    }
}
