package web.service;

import web.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void save(User user) {
      userDao.save(user);
   }


   @Transactional
   @Override
   public User show(int id) {
      return userDao.show(id);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> index() {
      return userDao.index();
   }

   @Transactional
   @Override
   public void delete(int id) {
      userDao.delete(id);
   }

   @Transactional
   @Override
   public void update(User updatedUser) {
      userDao.update(updatedUser);
   }
}
