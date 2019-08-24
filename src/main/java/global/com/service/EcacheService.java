package global.com.service;

import global.com.dao.User;

public interface EcacheService {
    public User saveLocalCache(User user);
    public User getLocalCache(Long  id);
}
