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

    @Autowired
    UserServices userServices;

    String mainPage = "index";
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

    @PostMapping("/save")
    public String saveUser(
            @RequestParam(name = "name", required = true) String name,
            @RequestParam(name = "surname", required = true) String surName,
            @RequestParam(name = "email", required = true) String email
    ) {
        User user = new User();
        user.setEmail(email);
        user.setFirstName(name);
        user.setLastName(surName);
        userServices.saveUser(user);
        return mainPage;
    }

    @PostMapping("/del/{id}")
    public String del(@PathVariable("id") int id, Model model) {
        userServices.deleteUser(id);
        return mainPage;
    }

}
