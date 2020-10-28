package com.freelearningapp.uber.controllers;

import com.freelearningapp.uber.models.Account;
import com.freelearningapp.uber.models.Gender;
import com.freelearningapp.uber.models.Passenger;
import com.freelearningapp.uber.models.Role;
import com.freelearningapp.uber.repositories.AccountRepository;
import com.freelearningapp.uber.repositories.PassengerRepository;
import com.freelearningapp.uber.repositories.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @Component - tag this on any class that Spring should manage
// @Entity - Spring JPA
// @Repository - @Component + exception handling
// @Controller - @Component + dealing with HTTP requests and Responses + exception handling
// @Service - @Component + some HTTP stuff - deals with the service layer, should not directly interact with DB
// @RestController - @Controller + Automatic Serialization

// threadlocal will be created
// singleton

@RestController
public class DBInitController {
    // spring automatically creates an implementation for me
    // and also sets that as the default implementation
    // Inversion of Control
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    RoleRepository roleRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    @GetMapping("/db-init")
    public Passenger hello() {
        accountRepository.deleteAll();

        Role adminRole = Role.builder()
                .name("ADMIN")
                .description("All access")
                .build();
        Role passengerRole = Role.builder()
                .name("PASSENGER")
                .description("All access")
                .build();
        Role driverRole = Role.builder()
                .name("DRIVER")
                .description("All access")
                .build();
        roleRepository.save(adminRole);
        roleRepository.save(passengerRole);
        roleRepository.save(driverRole);

        Account account = Account.builder()
                .phoneNumber("000")
                .password(bCryptPasswordEncoder.encode("meat"))
                .role(passengerRole)
                .build();
        accountRepository.save(account);
        Passenger luffy = Passenger.builder()
                .gender(Gender.MALE)
                .name("Luffy")
                .account(account)
                .build();
        passengerRepository.save(luffy);
        return luffy;
    }
}

// Roles - Driver, Passenger, Admin
// Colors

// Dependency Injection and IoC
// hashing
// hash + salt


// MD5 - crack this on your laptop / phone - extremely weak
// SHA256 - still not recommended
// BCrypt - current standard
// Scrypt
// .... - will be the standard in the next 10 years