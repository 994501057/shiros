package global.com.service.Impl;

import com.fasterxml.jackson.databind.util.JSONPObject;
import global.com.dao.User;
import global.com.dao.UserInfo;
import global.com.dao.UserInfoRepository;
import global.com.dao.UserRepository;
import global.com.service.EcacheService;
import global.com.service.UserService;
import global.com.util.JsonXMLUtils;
import net.sf.ehcache.util.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserInfoRepository userInfoRepository;
    @Resource
    private UserRepository userRepository;
    @Autowired
    private EcacheService ecacheService;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Override
    public UserInfo findUserByUsername(String username) {
        return userInfoRepository.findUserByUsername(username);
    }

    @Override
    public User findUserById(String ById) throws Exception {
       //String userinfo= redisTemplate.opsForValue().get("user:"+ById);
        /*if (!StringUtils.isEmpty(userinfo)) {
            User user=    JsonXMLUtils.json2obj(userinfo,User.class);
            System.out.println("从redis中查询到");
            User cacheInfo = ecacheService.getLocalCache(ById);
            System.out.println(cacheInfo.toString());
            return user;
        }*/
        //如果redis里面不存在，则去查一下ehcache
        User cacheInfo = ecacheService.getLocalCache(ById);
        //System.out.println(cacheInfo.toString());
        if(cacheInfo != null){
            System.out.println("我是从ehcache中查出来的: ======= >>>" + ById);
            return cacheInfo;
        }else{//ehcache 也不存在，则就需要查询数据库了
            User dbInfo = userRepository.findUserById(ById);
            if(dbInfo != null){
               // redisTemplate.opsForValue().set("user:"+ById, JsonXMLUtils.obj2json(dbInfo));
                System.out.println("我是从mysql中查出来的: ======= >>>" + ById);
                ecacheService.saveLocalCache(dbInfo);
                return dbInfo;
            }else{
                return null;
            }
        }
    }

    @Override
    public void save(User user) {
        redisTemplate.opsForValue().set("user:"+user.getId(), String.valueOf(user));
        ecacheService.saveLocalCache(user);
        userRepository.saves(user);
    }
}
