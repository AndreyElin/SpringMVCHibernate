package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();

    void save(User user);

    void delete(int id);

    User edit(int id);

    void update(User user);
}
