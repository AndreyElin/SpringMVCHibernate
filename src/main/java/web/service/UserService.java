package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void save(User user);

    void delete(int id);

    User edit(int id);

    void update(User user);
}
