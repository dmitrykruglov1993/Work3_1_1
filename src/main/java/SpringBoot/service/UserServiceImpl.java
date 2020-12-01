package SpringBoot.service;

import SpringBoot.dao.UserDAO;
import SpringBoot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Component
@Transactional
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    public void FirstSave() {
        userDAO.FirstSave();
    }

    @Override
    public void deleteUser(Long id) {
    userDAO.deleteUser(id);
    }

    @Override
    public User findById(Long id) {
        return userDAO.findById(id);
    }

}
