package web.dao;



import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
@Repository
public class UserDaoImpl implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }


    @Override
    public User show(int id) {
        User user =  entityManager.find(User.class, id);
        return user;

    }

    @Override
    public void delete(int id) {
           Query hql= entityManager.createQuery("delete from User where id=:id");
           hql.setParameter("id",id);
           hql.executeUpdate();
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<User> index() {

        return  entityManager.createQuery("from User").getResultList();
    }


    @Override
    public void update(int id, User updatedUser) {
        User userToUpdate = show(id);
        userToUpdate.setAge(updatedUser.getAge());
        userToUpdate.setName(updatedUser.getName());
        userToUpdate.setSurname(updatedUser.getSurname());
        entityManager.merge(userToUpdate);
    }

}