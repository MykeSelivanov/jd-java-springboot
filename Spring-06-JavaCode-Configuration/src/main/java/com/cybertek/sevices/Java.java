package com.cybertek.sevices;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;

public class Java implements Course {

    ExtraSessions extraSessions;

    public Java(ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours: " + ( 30 + extraSessions.getHours()));
    }

    @Value("JD1")
    private String batch;
    @Value("${instructor}")
    private String instructor;
    @Value("${days}")
    private String[] days;

    @Override
    public String toString() {
        return "Java{" +
                "extraSessions=" + extraSessions +
                ", batch='" + batch + '\'' +
                ", instructor='" + instructor + '\'' +
                ", days=" + Arrays.toString(days) +
                '}';
    }
}
