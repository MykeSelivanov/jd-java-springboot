package com.cybertek.service;

import com.cybertek.dto.UserDTO;
import com.cybertek.entity.User;
import com.cybertek.exception.TicketingProjectException;

import java.util.List;

public interface UserService {

    UserDTO findByUserName(String username);

    List<UserDTO> listAllUsers();
    List<UserDTO> listAllByRole(String role);

    void save(UserDTO dto);

    UserDTO update(UserDTO dto);

    void delete(String username) throws TicketingProjectException;
    void deleteByUserName(String username);

    Boolean checkIfUserCanBeDeleted(User user);

}
