package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);

    List<User> findAll();

    User findById(Long id);

    void updateUser(User user);

    User getUser(Long id);

    void deleteById(Long id);


}
