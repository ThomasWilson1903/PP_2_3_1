package web.controller;

import web.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.services.SevicesUser;
import web.services.UserServices;

@Controller
@RequestMapping("/user")
public class UserController {


    private final UserServices sevicesUser;


    public UserController() {
        this.sevicesUser = new SevicesUser();
    }

    @GetMapping()
    public String index(Model model) {
        sevicesUser.saveUser(new User("2", "1", "3"));
        return "index";
    }

    @GetMapping("{id}")
    public String show(@PathVariable("id") int id, Model model) {

        return "index";
    }
}
