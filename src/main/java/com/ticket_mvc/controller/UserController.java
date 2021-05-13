package com.ticket_mvc.controller;


import com.ticket_mvc.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/create")
    public String userCreate(Model model){

        model.addAttribute("user", new UserDTO());



        return "/user/create";





    }
}
