package com.sumutella.noninstantmessaging.services;

import com.sumutella.noninstantmessaging.dao.MessageDao;
import com.sumutella.noninstantmessaging.dao.UserDao;
import com.sumutella.noninstantmessaging.entities.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sumutella
 * @time 6:19 PM
 * @since 11/21/2019, Thu
 */
public class UserService implements UserServiceI {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }
}
