package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    public void createUser(User user);
    public void deleteUser(long id);
    public User getUser(long id);
    public List<User> allUsers();
    public void updateUser(long id, User user);

}
