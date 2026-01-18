package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.entity.User;
import web.service.UserService;


@Controller
public class UserController {


    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/addUser")
    public String showAddForm(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }


    @PostMapping("/addUser")
    public String addUser(
            @RequestParam("name") String name,
            @RequestParam("email") String email) {

        User user = new User(name, email);
        userService.save(user);
        return "redirect:/users";
    }


    @GetMapping("/editUser")
    public String showEditForm(@RequestParam("id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "editUser";
    }


    @PostMapping("/editUser")
    public String editUser(
            @RequestParam("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("email") String email) {

        User user = new User(name, email);
        user.setId(id);
        return "redirect:/users";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam("id") Long id,
                           @RequestParam("name") String name,
                           @RequestParam("email") String email) {
        User user = userService.getUser(id);
        user.setUsername(name);
        user.setEmail(email);
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") Long id) {

        userService.deleteById(id);
        return "redirect:/users";
    }
}