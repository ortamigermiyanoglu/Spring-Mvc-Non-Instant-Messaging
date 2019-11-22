package com.sumutella.noninstantmessaging.services;

import com.sumutella.noninstantmessaging.entities.Message;
import com.sumutella.noninstantmessaging.entities.User;

import java.util.List;

/**
 * @author sumutella
 * @time 6:17 PM
 * @since 11/21/2019, Thu
 */
public interface UserServiceI {
    User getUser(String username);
    List<Message> getMessages(User user);
}
