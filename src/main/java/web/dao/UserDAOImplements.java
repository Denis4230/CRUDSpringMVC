package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Service
@Repository
@Transactional
public class UserDAOImplements implements UserDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public void createUser(User user) {
        entityManager.merge(user);

    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        entityManager
                .createQuery("DELETE FROM User WHERE id=:id")
                .setFirstResult((int)id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public List<User> allUsers() {
        return entityManager
                .createQuery("SELECT us FROM User us", User.class)
                .getResultList();
    }

    @Transactional
    @Override
    public void updateUser(long id, User user) {
        user.setId(id);
        entityManager.merge(user);

    }
}
