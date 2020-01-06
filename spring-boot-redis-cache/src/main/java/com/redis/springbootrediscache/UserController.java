package com.redis.springbootrediscache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepoImpl userRepo;

    @GetMapping(path = "/users/{id}")
    public User getUserById(@PathVariable String id) {
        return userRepo.getUserById(id);
    }

    @GetMapping(path = "/users/{id}/{name}")
    public boolean addUser(@PathVariable String id, @PathVariable String name) {
        User user = new User(name, id);
        return userRepo.save(user);
    }

}
