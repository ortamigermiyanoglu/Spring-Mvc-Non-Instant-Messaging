package com.sumutella.noninstantmessaging.services;

import com.sumutella.noninstantmessaging.dao.MessageDao;
import com.sumutella.noninstantmessaging.dao.UserDao;
import com.sumutella.noninstantmessaging.entities.Message;
import com.sumutella.noninstantmessaging.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sumutella
 * @time 6:19 PM
 * @since 11/21/2019, Thu
 */
@Service
public class UserService implements UserServiceI {
    @Autowired
    private UserDao userDaoImpl;

    @Transactional
    @Override
    public User getUser(String username) {
        return userDaoImpl.getUser(username);
    }

    @Transactional
    @Override
    public List<Message> getMessages(User user){
        return userDaoImpl.getMessages(user);
    }
}
