package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;

public class Java implements Course {

    ExtraSessions extraSessions;

    public Java(ExtraSessions extaSessions){
        this.extraSessions = extaSessions;
    }

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching hours: " + (20 + extraSessions.getHours()));
    }
}
