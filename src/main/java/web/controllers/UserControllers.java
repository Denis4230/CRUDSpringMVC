package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDAOImplements;
import web.model.User;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserControllers {

    private final UserDAOImplements userDAOImplements;

    @Autowired
    public UserControllers(UserDAOImplements userDAOImplements) {
        this.userDAOImplements = userDAOImplements;
    }
    @PostMapping()
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "user/new";

        userDAOImplements.createUser(user);
        return "redirect:/user";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "user/new";
    }

    @GetMapping("/{id}/edit")
    public String show (@PathVariable("id") long id, Model model){
        model.addAttribute("user", userDAOImplements.getUser(id));
        return "user/show";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult,
                             @PathVariable("id") long id){

        if(bindingResult.hasErrors())
            return "user/edit";

        userDAOImplements.updateUser(id, user);
        return "redirect:/user";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userDAOImplements.deleteUser(id);
        return "redirect:/user";
    }

    @GetMapping
    public String allUser (Model model){
        model.addAttribute("user", userDAOImplements.allUsers());
        return "user/index";
    }
}
