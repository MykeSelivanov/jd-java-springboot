package com.training.controller;

import com.training.model.ResponseWrapper;
import com.training.repository.ParentRepository;
import com.training.service.ParentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParentController {

    ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }



}
