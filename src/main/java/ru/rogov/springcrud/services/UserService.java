package ru.rogov.springcrud.services;

import org.springframework.stereotype.Component;
import ru.rogov.springcrud.modelss.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {
    private static int PEOPLE_COUNT;
    private List<User> people;

    {
        people = new ArrayList<>();
        people.add(new User(++PEOPLE_COUNT, "Vasya", "Pupkin"));
        people.add(new User(++PEOPLE_COUNT, "Sasha", "Katc"));
        people.add(new User(++PEOPLE_COUNT, "Ira", "Lee"));
        people.add(new User(++PEOPLE_COUNT, "Leo", "Bush"));
    }

    public List<User> index() {
        return people;
    }

    public User show(int id) {
        return people.stream().filter(u -> u.getId() == id).findAny().orElse(null);
    }

    public void save(User user) {
        user.setId(++PEOPLE_COUNT);
        people.add(user);
    }

    public void update(int id, User updatedUser) {
        User userToBeUpdated=show(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setLastName(updatedUser.getLastName());
    }

    public void delete(int id) {
        people.removeIf(u->u.getId()==id);
    }
}
