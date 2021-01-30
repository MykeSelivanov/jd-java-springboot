package com.training.controller;

import com.training.model.ResponseWrapper;
import com.training.model.Teacher;
import com.training.repository.TeacherRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherController {

    private TeacherRepository teacherRepository;

    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping("/teachers")
    public List<Teacher> readAllTeachers(){
        return teacherRepository.findAll();
    }

}
