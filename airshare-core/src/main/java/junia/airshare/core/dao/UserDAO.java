package junia.airshare.core.dao;

import junia.airshare.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.login = :identification OR u.email = :identification")
    User getUserByLoginOrEmail(@Param("identification") String identification);

    @Query("SELECT u FROM User u WHERE u.status = 10")
    List<User> getUserRequestingUpgrade();

    @Query("SELECT u FROM User u WHERE u.id = :id")
    User getUserById(@Param("id") long id);

    @Query("SELECT u FROM User u")
    List<User> getAllUsers();

}