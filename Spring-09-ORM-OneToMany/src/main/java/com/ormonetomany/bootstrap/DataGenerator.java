package com.ormonetomany.bootstrap;

import com.ormonetomany.entity.Address;
import com.ormonetomany.entity.Person;
import com.ormonetomany.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class DataGenerator implements CommandLineRunner {

    PersonRepository personRepository;

    @Autowired
    public DataGenerator(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Person p1 = new Person("Mike", "Smith");
        Person p2 = new Person("Ozzy", "Kmith");
        Person p3 = new Person("Tedd", "Bibith");

        Address a1 = new Address("King St", "22042");
        Address a2 = new Address("Elm St", "45678");
        Address a3 = new Address("Java St", "220567");

    }

}
