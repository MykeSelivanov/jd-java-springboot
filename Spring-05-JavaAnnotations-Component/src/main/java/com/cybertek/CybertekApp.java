package com.cybertek;

import com.cybertek.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CybertekApp {
    public static void main(String[] args) {


        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

        Course course = container.getBean("api", Course.class);
        course.getTeachingHours();


    }
}
