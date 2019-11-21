package com.sumutella.noninstantmessaging.dao;

import com.sumutella.noninstantmessaging.entities.Message;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sumutella
 * @time 6:16 PM
 * @since 11/21/2019, Thu
 */
public class MessageDaoImpl implements MessageDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Message getMessage(int id) {
        return sessionFactory.getCurrentSession().get(Message.class, id);
    }
}
