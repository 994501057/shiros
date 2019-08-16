package global.com.service.Impl;

import global.com.dao.UserInfo;
import global.com.dao.UserInfoRepository;
import global.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Override
    public UserInfo findUserByUsername(String username) {
        return userInfoRepository.findUserByUsername(username);
    }
}
