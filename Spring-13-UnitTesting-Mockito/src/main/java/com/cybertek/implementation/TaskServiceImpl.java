package com.cybertek.implementation;

import com.cybertek.dto.ProjectDTO;
import com.cybertek.dto.TaskDTO;
import com.cybertek.entity.Project;
import com.cybertek.entity.Task;
import com.cybertek.entity.User;
import com.cybertek.enums.Status;
import com.cybertek.mapper.ProjectMapper;
import com.cybertek.mapper.TaskMapper;
import com.cybertek.repository.TaskRepository;
import com.cybertek.repository.UserRepository;
import com.cybertek.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    TaskRepository taskRepository;
    TaskMapper taskMapper;
    ProjectMapper projectMapper;
    UserRepository userRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper, ProjectMapper projectMapper, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.projectMapper = projectMapper;
        this.userRepository = userRepository;
    }

    @Override
    public TaskDTO findById(Long id) {
        Optional<Task> taskEntity = taskRepository.findById(id);
        if (taskEntity.isPresent()) {
            return taskMapper.convertToDTO(taskEntity.get());
        }
        return null;
    }

    @Override
    public List<TaskDTO> listAllTasks() {
        List<Task> taskEntitiesList = taskRepository.findAll();
//      return taskEntitiesList.stream().map(taskEntity -> { return taskMapper.convertToDTO(taskEntity);}).collect(Collectors.toList());
        return taskEntitiesList.stream().map(taskMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Task save(TaskDTO dto) {
        dto.setTaskStatus(Status.OPEN);
        dto.setAssignedDate(LocalDate.now());
        Task taskEntity = taskMapper.convertToEntity(dto);
        return taskRepository.save(taskEntity);
    }

    @Override
    public void update(TaskDTO dto) {
        Optional<Task> taskEntity = taskRepository.findById(dto.getId());
        Task convertedTask = taskMapper.convertToEntity(dto);
        if (taskEntity.isPresent()){
            convertedTask.setId(taskEntity.get().getId());
            convertedTask.setTaskStatus(taskEntity.get().getTaskStatus());
            convertedTask.setAssignedDate(taskEntity.get().getAssignedDate());
            taskRepository.save(convertedTask);
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Task> taskEntity = taskRepository.findById(id);
        if(taskEntity.isPresent()){
            taskEntity.get().setIsDeleted(true);
            taskRepository.save(taskEntity.get());
        }
    }

    @Override
    public void updateStatus(TaskDTO taskDTO) {
        Optional<Task> taskEntity = taskRepository.findById(taskDTO.getId());

        if (taskEntity.isPresent()) {
            taskEntity.get().setTaskStatus(taskDTO.getTaskStatus());
            taskRepository.save(taskEntity.get());
        }
    }

    @Override
    public int totalNonCompletedTasks(String projectCode) {
        return taskRepository.totalNonCompletedTasks(projectCode);
    }

    @Override
    public int totalCompletedTasks(String projectCode) {
        return taskRepository.totalCompletedTasks(projectCode);
    }

    @Override
    public void deleteByProject(ProjectDTO projectDTO) {
        List<TaskDTO> taskDTOS = listAllByProject(projectDTO);
        taskDTOS.forEach(taskDTO -> delete(taskDTO.getId()));
    }

    @Override
    public List<TaskDTO> listAllByProject(ProjectDTO projectDTO){
        List<Task> taskEntitiesList = taskRepository.findAllByProject(projectMapper.convertToEntity(projectDTO));
        return taskEntitiesList.stream().map(taskMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> listAllTasksByStatusIsNot(Status status) {
        User userEntity = userRepository.findByUserName("Nils.Kemmer19");
        List<Task> taskEntitiesList = taskRepository.findAllByTaskStatusIsNotAndAssignedEmployee(status, userEntity);
        return taskEntitiesList.stream().map(taskMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> listAllTasksByProjectManager() {
        User user = userRepository.findByUserName("mikesmith@gmail.com");
        List<Task> tasks = taskRepository.findAllByProjectAssignedManager(user);
        return tasks.stream().map(taskMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> listAllTasksByStatus(Status status) {
        User userEntity = userRepository.findByUserName("Nils.Kemmer19");
        List<Task> taskEntitiesList = taskRepository.findAllByTaskStatusAndAssignedEmployee(status, userEntity);
        return taskEntitiesList.stream().map(taskMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> readAllByAssignedEmployee(User user) {
        List<Task> taskEntities = taskRepository.findAllByAssignedEmployee(user);
        return taskEntities.stream().map(taskMapper::convertToDTO).collect(Collectors.toList());
    }
}
