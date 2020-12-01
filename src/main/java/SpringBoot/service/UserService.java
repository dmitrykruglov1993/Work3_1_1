package SpringBoot.service;



import SpringBoot.model.User;

import java.util.List;

public interface UserService {
     void save(User user);
     List<User> getUsers();
     void FirstSave();
     void deleteUser(Long id);
     User findById(Long id);
}
