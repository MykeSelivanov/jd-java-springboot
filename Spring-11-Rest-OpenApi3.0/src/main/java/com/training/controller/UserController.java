package com.training.controller;

import com.training.entity.User;
import com.training.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Tag(name = "User", description = "User API")
public class UserController {

    UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all-users")
    @Operation(summary = "Read all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Successfully retrieved",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "400",description = "Something went wrong",content = @Content),
            @ApiResponse(responseCode = "404",description = "User not found",content = @Content)
    })
    public List<User> readAllUsers(){
        return userRepository.findAll();
    }

}
