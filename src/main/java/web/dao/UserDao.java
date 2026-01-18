package web.dao;

import web.entity.User;

import java.util.List;

public interface UserDao {
    User findById(Long id);

    List<User> findAll();

    void save(User user);

    void deleteById(Long id);

    void update(User user);
}
