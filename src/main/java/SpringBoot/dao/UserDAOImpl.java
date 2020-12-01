package SpringBoot.dao;


import SpringBoot.model.User;
import SpringBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import java.util.List;


@Component
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    private UserRepository userRepository;

    User user = new User("User1","User1@mail.ru",(byte)98);

    public void FirstSave() {
        userRepository.save(user);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> getUsers(){
       return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(Long id) {
        return userRepository.getOne(id);
    }

}
