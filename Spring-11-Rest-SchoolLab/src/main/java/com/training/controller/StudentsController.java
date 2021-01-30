package com.training.controller;

import com.training.model.ResponseWrapper;
import com.training.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentsController {

    StudentRepository studentRepository;

    public StudentsController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> readAllStudents(){
        return ResponseEntity
               .ok(new ResponseWrapper("Students are successfully retrieved", studentRepository.findAll()));
    }

}
