//package ddinggeunmarket_service.jpa.product;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Getter@Setter
//public class Category {
//
//    @Id@GeneratedValue
//    @Column(name = "category_id")
//    private Long id;
//
//    private String name;
//
//    @ManyToMany
//    @JoinTable(name = "category_product",
//            joinColumns = @JoinColumn(name = "category_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id"))
//    private List<Product> products = new ArrayList<>();
//}
