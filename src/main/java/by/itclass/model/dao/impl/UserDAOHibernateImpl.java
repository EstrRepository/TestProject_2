package by.itclass.model.dao.impl;

import by.itclass.model.dao.interfaces.UserDAO;
import by.itclass.model.db.HQLRequest;
import by.itclass.model.db.HibernateManager;
import by.itclass.model.entities.Image;
import by.itclass.model.entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserDAOHibernateImpl implements UserDAO {
    @Override
    public boolean save(User user) {
        boolean isSave = false;
        try (Session session = HibernateManager.getSession()){
            Transaction transaction = session.beginTransaction();
            session.save(user.getImage());
            isSave = session.save(user) != null;
            transaction.commit();
        }
        return isSave;
    }

    @Override
    public User get(String loginOrEmail, String password) {
        User user = null;
        try (Session session = HibernateManager.getSession()){
            Query<User> query = session.createQuery(HQLRequest.SELECT_USER_BY_LOGIN_OR_EMAIL_AND_PASSWORD, User.class);
            query.setParameter(1, loginOrEmail);
            query.setParameter(2, loginOrEmail);
            query.setParameter(3, password);

            user = query.getSingleResult();
        }
        return user;
    }

    @Override
    public boolean update(User user) {
        boolean isUpdate = false;
        try (Session session = HibernateManager.getSession()){
            Transaction transaction = session.beginTransaction();
            User updateUser = session.get(User.class, user.getId());

            if (user.getLogin().length() > 0) updateUser.setLogin(user.getLogin());
            if (user.getEmail().length() > 0) updateUser.setEmail(user.getEmail());
            if (user.getPassword().length() > 0) updateUser.setPassword(user.getPassword());
            Image updateImage = updateUser.getImage();

            if (user.getImage().getContent().length > 0) {
                updateImage.setName(user.getImage().getName());
                updateImage.setContent(user.getImage().getContent());
            }
            session.saveOrUpdate(updateUser);
            transaction.commit();
            isUpdate = true;
        }
        return isUpdate;
    }

    @Override
    public boolean saveImage(User user) {
        boolean isSave = false;
        try (Session session = HibernateManager.getSession()){
            Transaction transaction = session.beginTransaction();
            User oldUser = session.get(User.class, user.getId());
            Image image = oldUser.getImage();

            if (image != null) {
                image.setName(user.getImage().getName());
                image.setContent(user.getImage().getContent());
                transaction.commit();
                isSave = true;
            }
        }
        return isSave;
    }
}
