package global.com.dao.repository;

import global.com.dao.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public User findUserById(Integer ById) ;


}
