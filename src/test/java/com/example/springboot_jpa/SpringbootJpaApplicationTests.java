package com.example.springboot_jpa;

import com.example.springboot_jpa.entity.Users;
import com.example.springboot_jpa.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;


@DataJpaTest
@Slf4j
class SpringbootJpaApplicationTests {

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void insertTestData() {
        Users user = new Users();
        user.setUsername("kim ori");
        userRepository.save(user);

        user = new Users();
        user.setUsername("lee ori");
        userRepository.save(user);

        user = new Users();
        user.setUsername("kim ental");
        userRepository.save(user);

        user = new Users();
        user.setUsername("lee ental");
        userRepository.save(user);

        user = new Users();
        user.setUsername("kim samuel");
        userRepository.save(user);
    }

    @Test
    void findAllTest() {
        List<Users> userList = userRepository.findAll();
        for (Users u : userList) log.info("[FindAll]: " + u.getID() + " | " + u.getUsername());
    }

    @Test
    void find2ByNameTest() {
        List<Users> userList = userRepository.findFirst2ByUsernameLikeOrderByIDDesc("kim%");
        for (Users u : userList) log.info("[FindSome]: " + u.getID() + " | " + u.getUsername());
    }
}
