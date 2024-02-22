package junia.airshare.core.service;

import com.sun.xml.bind.v2.model.core.ID;
import junia.airshare.core.dao.UserDAO;
import junia.airshare.core.entity.User;
import org.springframework.stereotype.Service;

import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

@Named
@Service
@Transactional
public class UserService {

    private UserDAO userDAO;

    public UserService(UserDAO userDAO) { this.userDAO = userDAO; }

    public void saveUser(User user) { userDAO.save(user); }

    public void deleteAll() { userDAO.deleteAll(); }

    public void deleteUser(User user) { userDAO.delete(user); }

    public long countAll() { return userDAO.count(); }

    public User findUserByLoginOrEmail(String identification) { return userDAO.getUserByLoginOrEmail(identification); }

    public List<User> getUserRequestingUpgrade() { return userDAO.getUserRequestingUpgrade(); }

    public List<User> findAll() { return userDAO.findAll(); }

    public User getUserById(long id) { return userDAO.getUserById(id); }

    public List<User> getAllUsers() { return userDAO.getAllUsers(); }

}