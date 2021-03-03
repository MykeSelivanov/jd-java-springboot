package com.cybertek.implementation;

import com.cybertek.dto.ProjectDTO;
import com.cybertek.dto.TaskDTO;
import com.cybertek.dto.UserDTO;
import com.cybertek.entity.User;
import com.cybertek.exception.TicketingProjectException;
import com.cybertek.mapper.MapperUtil;
import com.cybertek.repository.UserRepository;
import com.cybertek.service.ProjectService;
import com.cybertek.service.TaskService;
import com.cybertek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ProjectService projectService;
    private TaskService taskService;
    private MapperUtil mapperUtil;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, @Lazy ProjectService projectService, TaskService taskService, MapperUtil mapperUtil) {
        this.userRepository = userRepository;
        this.projectService = projectService;
        this.taskService = taskService;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<UserDTO> listAllUsers() {
        List<User> userEntityList = userRepository.findAll(Sort.by("firstName"));
        return userEntityList.stream().map(userEntity -> {return mapperUtil.convert(userEntity, new UserDTO());}).collect(Collectors.toList());
    }

    @Override
    public UserDTO findByUserName(String username) {
        User userEntity = userRepository.findByUserName(username);
        return mapperUtil.convert(userEntity, new UserDTO());
    }

    @Override
    public void save(UserDTO dto) {
        User user = mapperUtil.convert(dto, new User());
        userRepository.save(user);
    }

    @Override
    public UserDTO update(UserDTO dto) {
        // Find current user from database
        User userEntity = userRepository.findByUserName(dto.getUserName());
        // Map update user dto to entity object
        User convertedUser = mapperUtil.convert(dto, new User());
        // Set id to the converted object
        convertedUser.setId(userEntity.getId());
        // Save updated user
        userRepository.save(convertedUser);

        return findByUserName(dto.getUserName());
    }

    @Override
    public void delete(String username) throws TicketingProjectException {
        User userEntity = userRepository.findByUserName(username);
        if (userEntity == null) {
            throw new TicketingProjectException("User Does Not Exist");
        }
        if (!checkIfUserCanBeDeleted(userEntity)){
            throw new TicketingProjectException("User cannot be deleted. It is linked by a project or task");
        }
        userEntity.setUserName(userEntity.getUserName() + "-" + userEntity.getId());
        userEntity.setIsDeleted(true);
        userRepository.save(userEntity);
    }

    // hard delete (not a good practice, no one deletes data from the database)
    @Override
    public void deleteByUserName(String username) {

        userRepository.deleteByUserName(username);
    }

    @Override
    public List<UserDTO> listAllByRole(String role) {
        List<User> users = userRepository.findAllByRoleDescriptionIgnoreCase(role);
        return users.stream().map(userEntity -> mapperUtil.convert(userEntity, new UserDTO())).collect(Collectors.toList());
    }

    @Override
    public Boolean checkIfUserCanBeDeleted(User user) {
        switch (user.getRole().getDescription()) {
            case "Manager":
                List<ProjectDTO> projects = projectService.readAllByAssignedManager(user);
                return projects.size() == 0;
            case "Employee":
                List<TaskDTO> tasks = taskService.readAllByAssignedEmployee(user);
                return tasks.size() == 0;
            default:
                return true;
        }
    }

}
