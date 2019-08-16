package global.com.dao;

import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {
    public UserInfo findUserByUsername(String username) ;
}
