package ddinggeunmarket_service.controller;

import ddinggeunmarket_service.jpa.chat.ChatMessage;
import ddinggeunmarket_service.jpa.chat.ChatRoom;
//import ddinggeunmarket_service.jpa.community.Post;
import ddinggeunmarket_service.jpa.user.User;
import ddinggeunmarket_service.jpa.user.UserDTO;
import ddinggeunmarket_service.service.ChatService;
//import ddinggeunmarket_service.service.PostService;
import ddinggeunmarket_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;


    @GetMapping("/login")
    public User login(UserDTO userDTO) {
        System.out.println(userDTO.getId() +" " +userDTO.getPassword());
        return userService.login(userDTO.getId(), userDTO.getPassword());
    }


    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/user/create")
    public User createUser(@RequestBody UserDTO userDTO) {
        System.out.println("id : " + userDTO.getId());
        return userService.createUser(userDTO);
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

//    @PostMapping("/user/update")
//    public User updateUser(@RequestBody UserDTO userDTO) {
//        return userService.updateUser(userDTO);
//    }
///////mypage
@PostMapping("/update")
public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO) {
    String userId = userDTO.getId();
    if (userId == null || userId.isEmpty()) {
        return ResponseEntity.badRequest().body("User ID cannot be null or empty");
    }

    try {
        User updatedUser = userService.updateUser(userDTO);
        return ResponseEntity.ok(updatedUser);
    } catch (IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
////////

    @DeleteMapping("/user/{id}")
    public boolean deleteUserByID(@PathVariable String id) {
        return userService.deleteUserById(id);
    }


    @PostMapping("/{userId}/interests/{itemId}")
    public ResponseEntity<Void> WishList(
            @PathVariable String userId,
            @PathVariable Long itemId
    ) {
        userService.addWishList(userId, itemId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


//    // 채팅 리스트 화면
//    @GetMapping("/room")
//    public String rooms(Model model) {
//        return "/chat/room";
//    }
//
//    // 모든 채팅방 목록 반환
//    @GetMapping("/rooms")
//    @ResponseBody
//    public List<ChatRoom> room() {
//        return chatService.findAllRoom();
//    }
//
//    // 채팅방 생성
//    @PostMapping("/room")
//    @ResponseBody
//    public ChatRoom createRoom(@RequestParam String name) {
//        return chatService.createRoom(name);
//    }
//
//    // 채팅방 입장 화면
//    @GetMapping("/room/enter/{roomId}")
//    public String roomDetail(Model model, @PathVariable String roomId) {
//        model.addAttribute("roomId", roomId);
//        return "/chat/roomdetail";
//    }
//
//    // 특정 채팅방 조회
//    @GetMapping("/room/{roomId}")
//    @ResponseBody
//    public ChatRoom roomInfo(@PathVariable String roomId) {
//        return chatService.findById(roomId);
//    }
//
//
//    @MessageMapping("/chat/message")
//    public void enter(ChatMessage message) {
//        if (ChatMessage.MessageType.ENTER.equals(message.getType())) {
//            message.setMessage(message.getSender() + "님이 입장하였습니다.");
//        }
//        sendingOperations.convertAndSend("/topic/chat/room/" + message.getRoomId(), message);
//    }
//
//
//    @GetMapping("/post")
//    public List<Post> getAllPosts() {
//        return postService.getAllPosts();
//    }
//
//    @GetMapping("/{post_id}")
//    public Post getPostById(@PathVariable Long id) {
//        return postService.getPostById(id);
//    }
//
//
//    @PostMapping
//    public ResponseEntity<Post> createPost(@RequestBody Post newPost) {
//        Post createdPost = postService.createPost(newPost);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
//        postService.deletePost(id);
//        return ResponseEntity.noContent().build();
//    }
}