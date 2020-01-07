package com.redis.springbootrediscache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(path = "/users/{id}")
    public String getUserNameById(@PathVariable String id) {
        return userService.getCachedUserById(id);
    }

    @GetMapping(path = "/users/{id}/{name}")
    public User addUser(@PathVariable String id, @PathVariable String name) {
        User user = new User(name, id);
        userService.cacheUserObject(user);
        return user;
    }

}
