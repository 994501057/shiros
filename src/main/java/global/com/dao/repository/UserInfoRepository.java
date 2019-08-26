package global.com.dao.repository;

import global.com.dao.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {
    public UserInfo findUserByUsername(String username) ;
}
