//package ddinggeunmarket_service.controller;
//
//import service.PostService;
//import jpa.Post;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/posts")
//public class PostController {
//    @Autowired
//    private PostService postService;
//
//    @GetMapping
//    public List<Post> getAllPosts() {
//        return postService.getAllPosts();
//    }
//
//    @GetMapping("/{id}")
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
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
//        postService.deletePost(id);
//        return ResponseEntity.noContent().build();
//    }
//
//
//
//
//
//
//}
