package global.com.service.Impl;

import global.com.dao.User;
import global.com.service.EcacheService;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EcacheServiceImpl implements EcacheService {
    private static final String CACHE_KEY = "'key_'";
    private static final String CACHE_NAME  = "local";

    /**
     * 将商品信息放入本地堆缓存
     */
    @CachePut(value=CACHE_NAME,key=CACHE_KEY+"+#user.getId()")
    public User saveLocalCache(User user) {
        return user;
    }

    /**
     * 从本地缓存获取商品信息
     */
    @Cacheable(value=CACHE_NAME,key=CACHE_KEY+"+#id")
    public User getLocalCache(Integer  id) {
        return null;
    }

}
