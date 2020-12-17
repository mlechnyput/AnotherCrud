package ru.rogov.springcrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.rogov.springcrud.modelss.User;
import ru.rogov.springcrud.services.UserService;

@Controller
@RequestMapping("/people")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", userService.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", userService.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        //в модель передается пустой объект, поля которого заполнит таймлиф
        model.addAttribute("person", new User());
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") User user){
        userService.save(user);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id")int id){
        model.addAttribute("person", userService.show(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") User user, @PathVariable("id")int id){
        userService.update(id,user);
        return "redirect:/people";
    }
}
