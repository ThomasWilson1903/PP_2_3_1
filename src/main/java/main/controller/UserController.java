package main.controller;

import main.dao.UserDao;
import main.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    UserDao userDao;
    @Autowired
    public UserController(UserDao userDao){
        this.userDao = userDao;
        System.out.println("create UserContainer<>");
    }

    @GetMapping()
    public String show(Model model){
        model.addAttribute("user",userDao.getAllUsers());
        return "index";
    }

    @PostMapping()
    public void saveUser(
            @RequestParam(name = "name") String Name,
            @RequestParam(name = "surname") String SurName,
            @RequestParam(name = "doblename") String DobleName
    ){
        userDao.saveUser(new User(Name, SurName, DobleName));
    }


}
