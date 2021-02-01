package com.training.controller;

import com.training.model.ResponseWrapper;
import com.training.repository.ParentRepository;
import com.training.service.ParentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParentController {

    ParentService parentService;
    ParentRepository parentRepository;

    public ParentController(ParentService parentService, ParentRepository parentRepository) {
        this.parentService = parentService;
        this.parentRepository = parentRepository;
    }

    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> readAllParents(){
        ResponseWrapper responseWrapper = new ResponseWrapper(true,"Parents are successfully retrieved",
                HttpStatus.ACCEPTED.value(),
                parentService.getParents());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseWrapper);
    }



}
