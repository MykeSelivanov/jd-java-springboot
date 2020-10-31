package com.cybertek.configs;

import com.cybertek.interfaces.ExtraSessions;
import com.cybertek.sevices.Java;
import com.cybertek.sevices.OfficeHours;
import com.cybertek.sevices.Selenium;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.cybertek")
@PropertySource("classpath:application.properties")
public class CybertekAppConfig {

    @Bean
    public Java java() {
        return new Java(extraSessions());
    }

    @Bean
    public Selenium selenium() {
        return new Selenium();
    }

    /*
    @Bean
    public OfficeHours officeHours(){
        return new OfficeHours();
    }
     */

    @Bean
    public ExtraSessions extraSessions(){   //Extrasessions ex = new OfficeHours();
        return new OfficeHours();
    }
}
