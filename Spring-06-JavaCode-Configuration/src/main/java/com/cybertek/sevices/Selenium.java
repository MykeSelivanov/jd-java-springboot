package com.cybertek.sevices;

import com.cybertek.interfaces.Course;

public class Selenium implements Course {
    @Override
    public void getTeachingHours() {
        System.out.println("Selenium teaching hours: 20");
    }
}
