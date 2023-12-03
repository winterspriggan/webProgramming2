//package ddinggeunmarket_service.jpa.product;
//
//import jakarta.persistence.Entity;
//import lombok.Getter;
//import lombok.Setter;
//
////import javax.persistence.*;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Getter@Setter
//public class Product {
//    @Id
//    @GeneratedValue
//    @Column(name = "product_id")
//    private Long id;
//
//    private String name;
//    private int price;
//    private LocalDateTime date;
//    @Enumerated(EnumType.STRING)
//    private ProductStatus status;
//    @Enumerated(EnumType.STRING)
//    private ProductIsSelled isSelled;
//    @Enumerated(EnumType.STRING)
//    private Trade trade;
//
//    @ManyToMany(mappedBy = "products")
//    private List<Category> categories = new ArrayList<>();
//
//    //생성 메서드//
//    public  static Product createProduct(
//            String name, int price, LocalDateTime date,
//            String trade , String status){
//        Product product = new Product();
//        product.setName(name);
//        product.setPrice(price);
//        product.setDate(date);
//        product.setIsSelled(ProductIsSelled.UNSELLED);
//        if(status.equals("GOOD"))
//            product.setStatus(ProductStatus.GOOD);
//        else if(status.equals("BAD"))
//            product.setStatus(ProductStatus.BAD);
//        else
//            product.setStatus(ProductStatus.SOSO);
//
//        if(trade.equals("MEET"))
//            product.setTrade(Trade.MEET);
//        else
//            product.setTrade(Trade.DELIVERY);
//        return product;
//    }
//}
