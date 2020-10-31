package com.cybertek.services;

import com.cybertek.interfaces.ExtraSessions;
import org.springframework.stereotype.Component;

@Component
public class OfficeHours implements ExtraSessions {
    @Override
    public int getHours() {
        return 5;
    }
}
