package com.sumutella.noninstantmessaging.dao;

import com.sumutella.noninstantmessaging.entities.Message;
import com.sumutella.noninstantmessaging.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sumutella
 * @time 6:14 PM
 * @since 11/21/2019, Thu
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUser(String usernamee) {
        String hql ="select u from User u  WHERE u.username='"+usernamee+"'" ;
        return sessionFactory.getCurrentSession().createQuery(hql, User.class).getSingleResult();
    }

    @Override
    public List<Message> getMessages(User user) {
        Query<Message> messageQuery = sessionFactory.getCurrentSession().createQuery("" +
                "select m from Message m where m.receiver=:user", Message.class);
        messageQuery.setParameter("user", user);

        return messageQuery.getResultList();
    }
}
