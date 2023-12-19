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
        if(id.contains("KAKAO_USER")) return null;
        String userPw = userRepository.getUserById(id).getPassword();
        if (userPw == null || !userPw.equals(password)) return null;
        return userRepository.getUserById(id);
    }


    //KAKAO_USER_+nickname
    @Override
    public User accessByKakao(String email, String nickname) {
        String kakaoId = "KAKAO_USER_"+email;
            User user = new User(new UserDTO(kakaoId , "kakaoUser" , "kakaoUser" , "kakaoUser" , email , "kakaoUser" , "kakao"+nickname));
           return userRepository.save(user);
    }

    public void kakaoLogout() {

    }



    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(UserDTO userDTO) {
        if(userDTO.getId().equals(userRepository.getUserById(userDTO.getId())) // id or email이 같으면 가입 불가
                || userDTO.getEmail().equals(userRepository.getUserByEMail(userDTO.getEmail()))) return null;
        if(userDTO.getId().contains("KAKAO_USER")) return null; //카카오 유저 형식의 아이디도 가입 불가
        User user = new User(userDTO);
        if(userRepository.save(user) != null) return user;
        else return null;
    }


    @Override
    public User getUserById(String id) {
        return userRepository.getUserById(id);
    }


    //mypage
    @Override
    public User updateUser(UserDTO userDTO) {
        String userId = userDTO.getId();
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }

        User existingUser = userRepository.getUserById(userId);
        if (existingUser == null) {
            throw new IllegalArgumentException("User not found with ID: " + userId);
        }

        existingUser.setPassword(userDTO.getPassword());
        existingUser.setPhoneNumb(userDTO.getPhoneNumb());
        existingUser.setDob(userDTO.getDob());
        existingUser.setAddress(userDTO.getAddress());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setName(userDTO.getName());

        return userRepository.save(existingUser);
    }

////
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
        User user = getUserById(userId);
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("Item not found with id: " + itemId));

        WishList wishList = new WishList();
        wishList.setUser(user);
        wishList.setItem(item);

        wishListRepository.save(wishList);
    }


}
