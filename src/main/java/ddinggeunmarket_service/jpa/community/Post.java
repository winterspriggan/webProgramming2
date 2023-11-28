package ddinggeunmarket_service.jpa.community;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Post")
@NoArgsConstructor
@AllArgsConstructor
public class Post {



    public Post(PostDTO postDTO) {
        this.setId(postDTO.getId());
        this.setTitle(postDTO.getTitle());
        this.setContent(postDTO.getContent());

}


    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "CONTENT")
    private String content;
}
