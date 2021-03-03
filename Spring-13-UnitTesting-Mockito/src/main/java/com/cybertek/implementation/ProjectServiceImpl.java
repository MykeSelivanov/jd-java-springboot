package com.cybertek.implementation;

import com.cybertek.dto.ProjectDTO;
import com.cybertek.dto.UserDTO;
import com.cybertek.entity.Project;
import com.cybertek.entity.User;
import com.cybertek.enums.Status;
import com.cybertek.mapper.ProjectMapper;
import com.cybertek.mapper.UserMapper;
import com.cybertek.repository.ProjectRepository;
import com.cybertek.service.ProjectService;
import com.cybertek.service.TaskService;
import com.cybertek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectMapper projectMapper;
    private ProjectRepository projectRepository;
    private UserMapper userMapper;
    private UserService userService;
    private TaskService taskService;

    public ProjectServiceImpl(ProjectMapper projectMapper, ProjectRepository projectRepository, UserMapper userMapper, UserService userService, TaskService taskService) {
        this.projectMapper = projectMapper;
        this.projectRepository = projectRepository;
        this.userMapper = userMapper;
        this.userService = userService;
        this.taskService = taskService;
    }

    @Override
    public ProjectDTO getByProjectCode(String code) {
        Project projectEntity = projectRepository.findByProjectCode(code);
        return projectMapper.convertToDto(projectEntity);
    }

    @Override
    public List<ProjectDTO> listAllProjects() {
        List<Project> projectEntityList = projectRepository.findAll(Sort.by("projectCode"));
        return projectEntityList.stream().map(projectEntity -> projectMapper.convertToDto(projectEntity)).collect(Collectors.toList());
    }

    @Override
    public void save(ProjectDTO dto) {
        dto.setProjectStatus(Status.OPEN);
        Project projectEntity = projectMapper.convertToEntity(dto);
//        projectEntity.setAssignedManager(userMapper.convertToEntity(dto.getAssignedManager()));
        projectRepository.save(projectEntity);
    }

    @Override
    public void update(ProjectDTO dto) {
        Project projectEntity = projectRepository.findByProjectCode(dto.getProjectCode());
        Project convertedProject = projectMapper.convertToEntity(dto);
        convertedProject.setId(projectEntity.getId());
        convertedProject.setProjectStatus(projectEntity.getProjectStatus());
        projectRepository.save(convertedProject);
    }

    @Override
    public void complete(String projectCode) {
        Project projectEntity = projectRepository.findByProjectCode(projectCode);
        projectEntity.setProjectStatus(Status.COMPLETE);
        projectRepository.save(projectEntity);
    }

    @Override
    public List<ProjectDTO> listAllProjectDetails() {
        UserDTO currentUserDTO = userService.findByUserName("mikesmith@gmail.com");
        User userEntity = userMapper.convertToEntity(currentUserDTO);
        List<Project> projectEntitiesList = projectRepository.findAllByAssignedManager(userEntity);

        return projectEntitiesList.stream().map(projectEntity -> {
            ProjectDTO projectDTO = projectMapper.convertToDto(projectEntity);
            projectDTO.setUnfinishedTaskCount(taskService.totalNonCompletedTasks(projectEntity.getProjectCode()));
            projectDTO.setCompleteTaskCount(taskService.totalCompletedTasks(projectEntity.getProjectCode()));
            return projectDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(String code) {
        Project projectEntity = projectRepository.findByProjectCode(code);
        projectEntity.setIsDeleted(true);
        projectEntity.setProjectCode(projectEntity.getProjectCode() + "-" + projectEntity.getId());
        projectRepository.save(projectEntity);
        taskService.deleteByProject(projectMapper.convertToDto(projectEntity));
    }

    @Override
    public List<ProjectDTO> readAllByAssignedManager(User user) {
        List<Project> projectEntities = projectRepository.findAllByAssignedManager(user);
        return projectEntities.stream().map(projectMapper::convertToDto).collect(Collectors.toList());
    }

}
