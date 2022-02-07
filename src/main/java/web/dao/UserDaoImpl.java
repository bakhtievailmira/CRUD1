package web.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Repository
public class UserDaoImpl implements UserDao {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }


    @Override
    public User show(int id) {
        User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
        return user;

    }

    @Override
    public void delete(int id) {
        User user = show(id);
        if (user != null)
            sessionFactory.getCurrentSession().delete(user);
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<User> index() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }


    @Override
    public void update(int id, User updatedUser) {
        User userToUpdate = show(id);
        userToUpdate.setAge(updatedUser.getAge());
        userToUpdate.setName(updatedUser.getName());
        userToUpdate.setSurname(updatedUser.getSurname());
        sessionFactory.getCurrentSession().update(userToUpdate);
    }

}