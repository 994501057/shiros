package global.com.service;

import global.com.dao.UserInfo;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserInfo findUserByUsername(String username);
}
