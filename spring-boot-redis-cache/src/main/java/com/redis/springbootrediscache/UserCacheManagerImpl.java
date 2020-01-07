package com.redis.springbootrediscache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserCacheManagerImpl implements UserCacheManager {
    public static final String REDIS_KEY = "USER";
    private RedisCacheHelper<User> userRedisCacheHelper;

    @Autowired
    public UserCacheManagerImpl(RedisCacheHelper<User> userRedisCacheHelper) {
        this.userRedisCacheHelper = userRedisCacheHelper;
    }

    @Override
    public void cacheUserObject(User user) {
        userRedisCacheHelper.putMap(REDIS_KEY, user.getId(), user);
    }

    @Override
    public User getCachedUserObjectById(String id) {
        Object object =  userRedisCacheHelper.getMapObject(REDIS_KEY, id);
        return (User)object;
    }
}
