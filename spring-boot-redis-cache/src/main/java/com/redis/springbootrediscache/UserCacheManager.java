package com.redis.springbootrediscache;

public interface UserCacheManager {
    void cacheUserObject(User user);
    User getCachedUserObjectById(String id);
}
