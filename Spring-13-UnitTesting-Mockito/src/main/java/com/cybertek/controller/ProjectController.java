package com.cybertek.controller;

import com.cybertek.dto.ProjectDTO;
import com.cybertek.dto.TaskDTO;
import com.cybertek.dto.UserDTO;
import com.cybertek.enums.Status;
import com.cybertek.service.ProjectService;
import com.cybertek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/project")
public class ProjectController {

    ProjectService projectService;
    UserService userService;

    @Autowired
    public ProjectController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createProject(Model model){
        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("projects", projectService.listAllProjects());
        model.addAttribute("managers", userService.listAllByRole("Manager"));
        return "/project/create";
    }

    @PostMapping("/create")
    public String insertProject(ProjectDTO project){
        projectService.save(project);
        project.setProjectStatus(Status.OPEN);
        return "redirect:/project/create";
    }

    @GetMapping("/delete/{projectcode}")
    public String deleteProject(@PathVariable("projectcode") String projectCode){
        projectService.delete(projectCode);
        return "redirect:/project/create";
    }

    @GetMapping("/complete/{projectcode}")
    public String completeProject(@PathVariable("projectcode") String projectCode){
        projectService.complete(projectCode);
        return "redirect:/project/create";
    }

    @GetMapping("/update/{projectcode}")
    public String editProject(@PathVariable("projectcode") String projectCode, Model model){
        model.addAttribute("project", projectService.getByProjectCode(projectCode));
        model.addAttribute("projects", projectService.listAllProjects());
        model.addAttribute("managers", userService.listAllByRole("Manager"));
        return "/project/update";
    }

    @PostMapping("/update/{projectcode}")
    public String updateProject(@PathVariable("projectcode") String projectCode, ProjectDTO project){
        projectService.update(project);
        return "redirect:/project/create";
    }

    @GetMapping("/manager/complete")
    public String getProjectByManager(Model model){
        List<ProjectDTO> projects = projectService.listAllProjectDetails();
        model.addAttribute("projects", projects);
        return "/manager/project-status";
    }

    @GetMapping("/manager/complete/{projectcode}")
    public String completeProjectAsManager(@PathVariable("projectcode") String projectCode){
        projectService.complete(projectCode);
        return "redirect:/project/manager/complete";
    }
//
    /** Employee archive part moved to TaskController
     * keeping related methods
     * might be reused somewhere
     */
//
//    @GetMapping("/employee/archive")
//    public String getArchivedProjects(Model model){
//        checkTheProjectsStatus();
//        List<TaskDTO> archivedTasks = getArchivedProjectsWithTasks();
//
//        model.addAttribute("archivedTasks", archivedTasks);
//
//        return "employee/archive";
//    }
//
//    List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager){
//        List<ProjectDTO> list = projectService
//                .findAll()
//                .stream()
//                .filter(project -> project.getAssignedManager().equals(manager))
//                .map(project -> {
//                    List<TaskDTO> taskList = taskService.findTaskByManager(manager);
//                    int completeCount = (int) taskList.stream()
//                            .filter(eachTask -> eachTask.getProject().equals(project) && eachTask.getTaskStatus() == Status.COMPLETE).count();
//                    int incompleteCount = (int) taskList.stream()
//                            .filter(eachTask -> eachTask.getProject().equals(project) && eachTask.getTaskStatus() != Status.COMPLETE).count();
//
//                    project.setCompleteTaskCount(completeCount);
//                    project.setUnfinishedTaskCount(incompleteCount);
//                    return project;
//
//                }).collect(Collectors.toList());
//        return list;
//    }
//
//    List<TaskDTO> getArchivedProjectsWithTasks(){
//        List<TaskDTO> taskList = taskService
//                .findAll()
//                .stream()
//                .filter(task -> task.getProject().getProjectStatus() == Status.COMPLETE && task.getTaskStatus() == Status.COMPLETE)
//                .collect(Collectors.toList());
//
//        return taskList;
//    }
//
//    void checkTheProjectsStatus(){
//        taskService.findAll().stream()
//                .forEach(task -> {
//                    if(task.getTaskStatus() != Status.COMPLETE){
//                        task.getProject().setProjectStatus(Status.IN_PROGRESS);
//                    }
//                });
//    }

}
