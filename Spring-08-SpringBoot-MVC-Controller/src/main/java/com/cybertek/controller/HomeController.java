package com.cybertek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getRequestMapping(){
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/myke")
    public String getRequestMapping2(){
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST, value = "test")
    public String getRequestMapping3(){
        return "home";
    }

    @GetMapping("/spring")
    public String getMappingEx(){
        return "home";
    }

    @PostMapping("/spring")
    public String getMappingEx2(){
        return "home";
    }

    @GetMapping("/home/{name}")
    public String pathVariableEx(@PathVariable("name") String name){
        System.out.println("name is: " + name);
        return "home";
    }

    @GetMapping("/home/{name}/{email}")
    public String pathVariableEx2(@PathVariable("name") String name, @PathVariable("email") String email){
        System.out.println("name is: " + name);
        System.out.println("email is: " + email);
        return "home";
    }

    @GetMapping("/home/course") ///home/course?course=spring
    public String requestParamEx(@RequestParam("course") String course){
        System.out.println("course is: " + course);
        return "home";
    }

    @GetMapping(value="/course")
    public String requestParam2(@RequestParam(value = "name", required = false, defaultValue = "Spring") String course){
        System.out.println("course is: " + course);
        return "home";
    }



}
