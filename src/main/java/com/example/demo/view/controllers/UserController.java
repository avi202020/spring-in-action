package com.example.demo.view.controllers;

import com.example.demo.data.JpaUserRepository;
import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final JpaUserRepository jpaUserRepository;

    @Autowired
    public UserController(UserRepository userRepository, JpaUserRepository jpaUserRepository){
        this.userRepository = userRepository;
        this.jpaUserRepository = jpaUserRepository;
    }

    @GetMapping
    public @ResponseBody List<User> getUsers() {
        List<User> result = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(result::add);
        return result;
    }

    @GetMapping("/{userName}")
    public @ResponseBody User getUser(@PathVariable String userName){
        return userRepository.findOne(userName);

    }


    @PostMapping
    public @ResponseBody User saveUser(@RequestBody User user){
        userRepository.save(user);
        return  userRepository.findOne(user.getName());
    }

    @GetMapping("/jpa/{userId}")
    public @ResponseBody Optional<User> getUserJPA(@PathVariable UUID userId){
        return jpaUserRepository.findById(userId);

    }

    @GetMapping("/jpa/name/{username}")
    public @ResponseBody Optional<User> getUserByNameJPA(@PathVariable String username){
        return jpaUserRepository.findByName(username);

    }

    @PostMapping("/jpa")
    public @ResponseBody Optional<User> saveUserJpa(@RequestBody User user){
        jpaUserRepository.save(user);
        return jpaUserRepository.findById(user.getId());
    }
}
