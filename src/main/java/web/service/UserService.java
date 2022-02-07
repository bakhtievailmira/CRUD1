package web.service;


import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    User show(int id);

    List<User> index();

    void delete(int id);

    void update(int id, User updatedUser);
}
