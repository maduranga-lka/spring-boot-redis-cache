package com.redis.springbootrediscache;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepoImpl implements UserRepo {

    private RedisTemplate<String, User> redisTemplate;
    private HashOperations hashOperations;

    public UserRepoImpl(RedisTemplate<String, User> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public boolean save(User user) {
        hashOperations.put("USER", user.getId(), user);
        return true;
    }

    @Override
    public User getUserById(String id) {
       return (User)hashOperations.get("USER", id);
    }
}
