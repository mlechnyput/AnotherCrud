package ru.rogov.springcrud.dao;

import ru.rogov.springcrud.modelss.User;

import java.util.List;

public interface UserDaoInterface {

    public List<User> index();

    public User show(int id);

    public void save(User user);

    public void update(int id, User updatedUser);

    public void delete(int id);

}
