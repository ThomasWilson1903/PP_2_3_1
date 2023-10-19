package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import services.SevicesUser;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    SevicesUser sevicesUser = new SevicesUser();

    @GetMapping()
    public String index(Model model){

        return "index";
    }

    @GetMapping("{id}")
    public String show(@PathVariable("id") int id, Model model ){

        return "index";
    }

   /* @GetMapping(value = "/user")
    public String getUser(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            Model model) {
        model.addAttribute("message", name + " " + surname);
        return "index";
    }*/

    /*@PostMapping(value = "/user")
    public void setUser(ModelMap model) {

    }*/
}
