package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.List;

public interface UserDao {
    public List<User> index();

    public User show(int id);

    public void save(User user);

    void delete(int id);

    void update(User updatedUser);
}
