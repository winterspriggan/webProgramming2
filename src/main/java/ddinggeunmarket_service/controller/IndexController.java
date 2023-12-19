package ddinggeunmarket_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/myPage")
    public String myPage() {
        return "myPage";
    }

    @GetMapping("/myInfo")
    public String myInfo() {
        return "myInfo";
    }

    @GetMapping("/postlist")
    public String postlist() {
        return "postlist";
    }

    @GetMapping("/wishlist")
    public String wishlist() {
        return "wishlist";
    }
}
