package main.controller;

import main.model.User;
import main.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {


    UserServices userServices;

    @Autowired
    public UserController(UserServices userServices){
        this.userServices = userServices;
    }

    String mainPage = "users";
    @GetMapping()
    public String show(Model model) {
        model.addAttribute("user", userServices.getAllUsers());
        return mainPage;
    }

    @GetMapping("/{id}")
    public String showId(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userServices.getUser(id));
        return mainPage;
    }
    @GetMapping ("/new")
    public String newUser(Model model) {
        model.addAttribute("newUser", new User());
        return "newUser";
    }

    @GetMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userServices.saveUser(user);
        return "redirect:/user";
    }

    @GetMapping("/del")
    public String del(@RequestParam("id") int id) {
        userServices.deleteUser(id);
        return "redirect:/user";
    }

}
