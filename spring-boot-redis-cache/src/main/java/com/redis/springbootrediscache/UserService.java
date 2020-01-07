package com.redis.springbootrediscache;

public interface UserService {
    void cacheUserObject(User user);

    User getCachedUserById(String id);
}
