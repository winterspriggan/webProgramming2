package ddinggeunmarket_service.jpa.MyPage;

import ddinggeunmarket_service.jpa.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Entity
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}
