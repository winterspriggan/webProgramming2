package ddinggeunmarket_service.controller;

import ddinggeunmarket_service.jpa.product.Product;
import ddinggeunmarket_service.jpa.product.productForm;
import ddinggeunmarket_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping(value = "/products/new")
    public String createForm(Model model){
        model.addAttribute("form",new productForm());
        return "products/createProductForm";
    }
    @PostMapping(value = "/products/new")
    public String create(productForm form){
        Product product = new Product();
//        name price status date delivery
        LocalDateTime date = LocalDateTime.now();
        int price = form.getPrice();
        String status = form.getStatus();
        String trade = form.getTrade();
        String name = form.getName();

        productService.makeProduct(name,price,status,trade,date);
        return "redirect:/products";
    }

    @GetMapping(value = "/products")
    public String list(Model model){
        List<Product> products = productService.findProducts();
        model.addAttribute("products",products);
        return "products/productsList";
    }
}
