package com.ticket_mvc.controller;


import com.ticket_mvc.dto.ProjectDTO;
import com.ticket_mvc.service.ProjectService;
import com.ticket_mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;

    @RequestMapping("/create")
    public String createProject(Model model) {

        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("projects",projectService.findAll());
        model.addAttribute("managers",userService.findAll());
        return "/project/create";
    }


}
