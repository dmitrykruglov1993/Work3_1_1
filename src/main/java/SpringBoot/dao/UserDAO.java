package SpringBoot.dao;

import SpringBoot.model.User;

import java.util.List;

public interface UserDAO {
   void save(User user);
   List<User> getUsers();
   void FirstSave();
   void deleteUser(Long id);
   User findById(Long id);
}
