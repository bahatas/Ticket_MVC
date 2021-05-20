package com.ticket_mvc.controller;


import com.ticket_mvc.dto.ProjectDTO;
import com.ticket_mvc.service.ProjectService;
import com.ticket_mvc.service.UserService;
import com.ticket_mvc.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping("/create")
    public String insertProject(ProjectDTO project){
        projectService.save(project);
        project.setProjectStatus(Status.OPEN);

        return "redirect:/project/create";

    }

    @GetMapping("/delete/{projectCode}")
    public String deletebyId(@PathVariable("projectCode")ProjectDTO projectDTO){

        projectService.deleteById( projectDTO.getProjectCode());

        return "redirect:/project/create";

    }

    @GetMapping("/complete/{projectCode}")
    public String completeProject(@PathVariable("projectCode") ProjectDTO projectDTO){
        projectService.complete(projectDTO);

        return "redirect:/project/create";
    }
    @GetMapping("/update/{projectCode}")
    public String editProject(@PathVariable("projectCode") String prjectCode, Model model){

        model.addAttribute("project",projectService.findById(prjectCode));
        model.addAttribute("projects",projectService.findAll());
        model.addAttribute("managers",userService.findAll());


        return "redirect:/project/create";
    }
    @PostMapping("/update/{projectCode}")
    public String updatebyId(@PathVariable("projectCode") ProjectDTO projectDTO){
        projectService.update(projectDTO);

        return "redirect:/project/create";
    }
}
