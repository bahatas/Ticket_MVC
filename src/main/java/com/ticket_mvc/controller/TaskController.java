package com.ticket_mvc.controller;

import com.ticket_mvc.dto.TaskDTO;
import com.ticket_mvc.service.ProjectService;
import com.ticket_mvc.service.TaskService;
import com.ticket_mvc.service.UserService;
import com.ticket_mvc.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.UUID;


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
        model.addAttribute("employees", userService.findEmployees());
        model.addAttribute("tasks", taskService.findAll());


        return "/task/create";
    }

    @PostMapping("/create")
    public String task(Model model, TaskDTO taskDTO) {

        taskDTO.setTaskStatus(Status.OPEN);
        taskDTO.setAssignedDate(LocalDate.now());
        taskDTO.setId(UUID.randomUUID().getMostSignificantBits());
        taskService.save(taskDTO);


        return "redirect:/task/create";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {

        taskService.deleteById(id);

        return "redirect:/task/create";
    }

    @GetMapping("/update/{id}")
    public String edit(@PathVariable("id") Long id , Model model) {

        model.addAttribute("task",taskService.findById(id));
        model.addAttribute("projects",projectService.findAll());
        model.addAttribute("employees",userService.findEmployees());
        model.addAttribute("tasks",taskService.findAll());
        return "task/update";
    }

    @PostMapping("/update/{id}")
    public String update(TaskDTO taskDTO) {

        taskService.update(taskDTO);

        return "redirect:/task/create";
    }



}