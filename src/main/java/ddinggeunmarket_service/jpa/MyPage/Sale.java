package ddinggeunmarket_service.jpa.MyPage;

import ddinggeunmarket_service.jpa.MyPage.Item;
import ddinggeunmarket_service.jpa.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private int quantity;
    private double totalPrice;
    private LocalDateTime saleDateTime;
}
