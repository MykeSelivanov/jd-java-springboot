package com.training.bootstrap;

import com.training.entity.User;
import com.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;
import java.util.List;

public class DataGenerator implements CommandLineRunner {

    private UserRepository userRepository;

    @Autowired
    public DataGenerator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //Delete All
        this.userRepository.deleteAll();

        //Create users
        User employee = new User("mike","mike123","USER","");
        User admin = new User("admin","admin123","ADMIN","ACCESS_TEST1,ACCESS_TEST2");
        User manager = new User("manager","manager123","MANGER","ACCESS_TEST1");

        List<User> users = Arrays.asList(employee,admin,manager);
        userRepository.saveAll(users);

    }

}
