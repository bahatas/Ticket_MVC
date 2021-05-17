package com.ticket_mvc.controller;

import com.ticket_mvc.dto.UserDTO;
import com.ticket_mvc.entity.Role;
import com.ticket_mvc.service.RoleService;
import com.ticket_mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @GetMapping("/create")
    public String createUser(Model model){

        model.addAttribute("user",new UserDTO());
        model.addAttribute("roles",roleService.findAll());
        model.addAttribute("users",userService.findAll());



        return "user/create";
    }

    @PostMapping("/create")
    public String insertUser(UserDTO user,Model model){

        userService.save(user);
        return "redirect:/user/create";
    }


    @GetMapping("/update/{username}")
    public String editUsername(@PathVariable("username") String username, Model model ){

        model.addAttribute("user",userService.findById(username));
        model.addAttribute("users",userService.findAll());
        model.addAttribute("roles",roleService.findAll());

        return "/user/update";
    }

    @PostMapping("/delete/{username}")
    public String updateUser(@PathVariable("username") String username, UserDTO user,Model model){
        userService.update(user);
        return "redirect:/user/create";

    }
   // @GetMapping("/delete/{username}")
}
