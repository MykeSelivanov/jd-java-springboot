package com.training.controller;

import com.training.entity.Student;
import com.training.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/data")
    List<Student> getStudent_data(){
        return studentService.getStudent_data();
    }

}
