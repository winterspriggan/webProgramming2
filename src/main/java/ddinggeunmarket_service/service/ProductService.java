package ddinggeunmarket_service.service;

import ddinggeunmarket_service.jpa.product.Product;
import ddinggeunmarket_service.jpa.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    /**상품등록*/
    @Transactional
    public Long makeProduct(
            String name, int price ,  String status,
            String trade, LocalDateTime date
    ){
        //Product 생성
        Product product =  Product.createProduct(name,price,date,status,trade);
        productRepository.save(product);
        return product.getId();
    }
    public List<Product> findProducts(){
        return productRepository.findAll();
    }
    public Product findOne(Long productId){
        return productRepository.findOne(productId);
    }
}
