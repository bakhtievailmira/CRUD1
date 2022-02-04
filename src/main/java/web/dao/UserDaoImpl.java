package web.dao;


import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    private List <User> users;
    {
        users = new ArrayList<>();
        users.add(new User("Петя","Петров",11));
        users.add(new User("Вася","Васин",22));
        users.add(new User("Михаил","Мишин",55));
    }


    @Override
    public List<User> index(){
        return users;
    }

    @Override
    public User show(int id){
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    @Override
    public void save(User user) {
        users.add(user);

    }

    @Override
    public void update(int id, User updatedUser){
    User userToUpdate = show(id);
    userToUpdate.setAge(updatedUser.getAge());
    userToUpdate.setName(updatedUser.getName());
    userToUpdate.setSurname(updatedUser.getSurname());
    }

    @Override
    public void delete(int id) {
        users.removeIf(p -> p.getId() == id);
    }
}
