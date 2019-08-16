package global.com.service.Impl;

import global.com.dao.UserInfo;
import global.com.dao.UserInfoRepository;
import global.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserInfoRepository userInfoRepository;
    @Override
    public UserInfo findUserByUsername(String username) {
        return userInfoRepository.findUserByUsername(username);
    }
}
