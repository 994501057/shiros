package global.com.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Autowired
    public StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    // 批量删除对应的value
    public void deleteAll(String... keys) {
        for (String key : keys) {
            delete(key);
        }
    }

    // 批量删除key
    public void deletePattern(String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    // 删除指定key的value
    public void delete(String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    // 判断缓存中是否有对应的value
    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    // 读取缓存
    public Object get(String key) {
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }

    // 写入缓存
    public boolean set(String key, Object value) {
        boolean flag = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    // 写入缓存
    public boolean set(String key, Object value, Long expireTime) {
        boolean flag = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
    // 获取某个key的剩余过期时间
    public long residualExpirationTime(String key) {
        return stringRedisTemplate.getExpire(key);
    }
    // 当key不存在时，为key赋值
    public boolean setValue(String key, String value) {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        return ops.setIfAbsent(key, value);
    }

    // 为key赋值，同时设置过期时间
    public void set(String key, String value, long time) {
        BoundValueOperations<String, String> ops = stringRedisTemplate.boundValueOps(key);
        ops.set(value, time, TimeUnit.SECONDS);
    }
    // 判断某个key是否存在
    public boolean exist(String key) {
        return stringRedisTemplate.hasKey(key);
    }

    // 同redis命令的leftpush
    public void leftPush(String key, String value) {
        stringRedisTemplate.boundListOps(key).leftPush(value);
    }

    // 同redis命令的rightpop
    public String rightPop(String key) {
        return stringRedisTemplate.boundListOps(key).rightPop();
    }
}

