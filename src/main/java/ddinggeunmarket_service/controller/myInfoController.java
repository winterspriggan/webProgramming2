package ddinggeunmarket_service.controller;

import ddinggeunmarket_service.jpa.user.User;
import ddinggeunmarket_service.jpa.user.UserDTO;
import ddinggeunmarket_service.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/myInfo/user")
public class myInfoController {

    private final UserService userService;

    public myInfoController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/edit/{id}")
    public String showUserForm(@PathVariable String id, Model model) {
        User fetchedUser = userService.getUserById(id);
        model.addAttribute("user", fetchedUser);

        return "myInfo";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") UserDTO userDTO) {
        userService.updateUser(userDTO);
        return "redirect:/myInfo/user/edit/" + userDTO.getId();
    }


}