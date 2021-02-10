package com.training.controller;

import com.training.entity.ResponseWrapper;
import com.training.entity.User;
import com.training.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/read")
    public ResponseEntity<ResponseWrapper> readAll(){
        List<User> users = userService.getAll();
        return ResponseEntity.ok(new ResponseWrapper("Done",users));

    }

}
