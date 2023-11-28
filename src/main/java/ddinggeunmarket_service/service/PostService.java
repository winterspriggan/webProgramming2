package ddinggeunmarket_service.service;

import ddinggeunmarket_service.jpa.community.Post;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private List<Post> posts = new ArrayList<>();
    private Long nextId = 1L;

    public List<Post> getAllPosts() {
        return posts;
    }

    public Post getPostById(Long id) {
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                return post;
            }
        }
        return null;
    }

    public Post createPost(Post newPost) {
        newPost.setId(nextId);
        posts.add(newPost);
        nextId++;
        return newPost;
    }


    public void deletePost(Long id) {
        posts.removeIf(post -> post.getId().equals(id));
    }

}
