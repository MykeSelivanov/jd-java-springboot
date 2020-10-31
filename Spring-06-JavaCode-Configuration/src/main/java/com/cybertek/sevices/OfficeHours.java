package com.cybertek.sevices;

import com.cybertek.interfaces.ExtraSessions;

public class OfficeHours implements ExtraSessions {
    @Override
    public int getHours() {
        return 5;
    }
}
