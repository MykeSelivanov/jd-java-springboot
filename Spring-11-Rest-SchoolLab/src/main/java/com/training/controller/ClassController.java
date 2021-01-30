package com.training.controller;

import com.training.model.Class;
import com.training.service.ClassService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassController {

    ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Class>> getClasses(){
        HttpHeaders responseHttpHeaders = new HttpHeaders();
        responseHttpHeaders.set("Version", "EducationApp.v1");
        responseHttpHeaders.set("Operation", "Get Classes");

        return ResponseEntity
                .ok()
                .headers(responseHttpHeaders)
                .body(classService.getClasses());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Class> getClass(@PathVariable("id") Long id){
        HttpHeaders responseHttpHeaders = new HttpHeaders();
        responseHttpHeaders.set("Version", "EducationApp.v1");
        responseHttpHeaders.set("Operation", "Get Class");

        return ResponseEntity
                .ok()
                .headers(responseHttpHeaders)
                .body(classService.getClass(id));
    }

    @PostMapping("/new")
    public ResponseEntity<List<Class>> createClass(@RequestBody Class studentClass){
        List <Class> set = classService.createClass(studentClass);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Version", "EducationApp.v1")
                .header("Operation", "Create Class")
                .body(set);
    }

}
