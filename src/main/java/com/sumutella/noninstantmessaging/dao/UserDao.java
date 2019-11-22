package com.sumutella.noninstantmessaging.dao;

import com.sumutella.noninstantmessaging.entities.Message;
import com.sumutella.noninstantmessaging.entities.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author sumutella
 * @time 6:11 PM
 * @since 11/21/2019, Thu
 */
public interface UserDao {
    User getUser(String username);
    List<Message> getMessages(User user);
}
