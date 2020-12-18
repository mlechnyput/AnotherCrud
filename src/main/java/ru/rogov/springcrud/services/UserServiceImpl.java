package ru.rogov.springcrud.services;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rogov.springcrud.dao.UserDao;
import ru.rogov.springcrud.modelss.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao ud;

    @Autowired
    public UserServiceImpl(UserDao ud) {
        this.ud = ud;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> index() {
        return ud.index();
    }

    @Transactional(readOnly = true)
    @Override
    public User show(int id) {
        return ud.show(id);
    }

    @Transactional
    @Override
    public void save(User user) {
        ud.save(user);
    }

    @Transactional
    @Override
    public void update(int id, User updatedUser) {
        ud.update(id, updatedUser);
    }

    @Transactional
    @Override
    public void delete(int id) {
        ud.delete(id);
    }
}
