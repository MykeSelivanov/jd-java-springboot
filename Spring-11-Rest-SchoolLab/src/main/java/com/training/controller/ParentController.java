package com.training.controller;

import com.training.model.ResponseWrapper;
import com.training.repository.ParentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParentController {

    ParentRepository parentRepository;

    public ParentController(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

//    @GetMapping("/parents")
//    public ResponseEntity<ResponseWrapper> readAllParents(){
//        ResponseWrapper responseWrapper =
//    }

}
