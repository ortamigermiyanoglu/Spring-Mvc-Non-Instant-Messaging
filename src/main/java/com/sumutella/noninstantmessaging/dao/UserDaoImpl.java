package com.sumutella.noninstantmessaging.dao;

import com.sumutella.noninstantmessaging.entities.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public User getUser(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }
}
