package com.cybertek.controller;

import com.cybertek.dto.UserDTO;
import com.cybertek.exception.TicketingProjectException;
import com.cybertek.service.RoleService;
import com.cybertek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    RoleService roleService;
    UserService userService;

    @Autowired
    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createUser(Model model){
        model.addAttribute("user",new UserDTO());
        model.addAttribute("roles", roleService.listAllRoles());
        model.addAttribute("users", userService.listAllUsers());
        return "/user/create";
    }

    @PostMapping("/create")
    public String insertUser(UserDTO user, Model model){
        userService.save(user);
        return "redirect:/user/create";
    }

    @GetMapping("/update/{username}")
    public String editUser(@PathVariable("username") String username, Model model){
        model.addAttribute("user", userService.findByUserName(username));
        model.addAttribute("users", userService.listAllUsers());
        model.addAttribute("roles", roleService.listAllRoles());
        return "/user/update";
    }

    @PostMapping("/update/{username}")
    public String updateUser(@PathVariable("username") String username,UserDTO user, Model model){
        userService.update(user);
        return "redirect:/user/create";
    }

    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable("username") String username) throws TicketingProjectException {
        userService.delete(username);
        return "redirect:/user/create";
    }


}





