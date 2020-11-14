package com.cybertek.controller;

import com.cybertek.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/welcome")
    public String homePage(Model model){

        model.addAttribute("name", "Mike");
        model.addAttribute("course", "Thymeleaf");

        String subject = "Collections";
        model.addAttribute("subject", subject);

        //create some random studentId (0-1000)
        int studentId = new Random().nextInt(1000);
        model.addAttribute("studentId", studentId);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        model.addAttribute("numbers", numbers);

        //print your birthday
        LocalDate birthday = LocalDate.now().minusYears(29);
        model.addAttribute("birthday", birthday);

        //create model Student
        Student student = new Student(1,"James", "Bond");
        model.addAttribute("student", student);

        return "student/welcome";
    }

    @GetMapping("/register")
    public String homePage2(){
        return "student/register";
    }

}
