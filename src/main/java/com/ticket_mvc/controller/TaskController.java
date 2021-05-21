package com.ticket_mvc.controller;

import com.ticket_mvc.dto.TaskDTO;
import com.ticket_mvc.service.ProjectService;
import com.ticket_mvc.service.TaskService;
import com.ticket_mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;

    @Autowired
    TaskService taskService;

    @GetMapping("/create")
    public String taskCreate(Model model, TaskDTO taskDTO) {

        model.addAttribute("task", taskDTO);
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("employees  ", userService.findEmployees());
        model.addAttribute("tasks",taskService.findAll() );


        return "/task/create";
    }


}
