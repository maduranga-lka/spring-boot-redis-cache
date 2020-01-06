package com.redis.springbootrediscache;

public interface UserRepo {
    boolean save(User user);
    User getUserById(String id);
}
