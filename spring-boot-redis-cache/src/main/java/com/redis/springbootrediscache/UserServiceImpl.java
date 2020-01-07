package com.redis.springbootrediscache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    private UserCacheManager userCacheManager;

    @Autowired
    public UserServiceImpl(UserCacheManager userCacheManager) {
        this.userCacheManager = userCacheManager;
    }


    public void cacheUserObject(User user) {
        userCacheManager.cacheUserObject(user);
    }


    public String getCachedUserById(String id) {
        return ((User)userCacheManager.getCachedUserObjectById(id)).getName();
    }
}
