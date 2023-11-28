package ddinggeunmarket_service.jpa.MyPage;

import ddinggeunmarket_service.jpa.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;

    @ManyToMany(mappedBy = "interestList")
    private List<User> interestedUsers;
}
