package com.sumutella.noninstantmessaging.dao;

import com.sumutella.noninstantmessaging.entities.User;
import org.springframework.stereotype.Component;

/**
 * @author sumutella
 * @time 6:11 PM
 * @since 11/21/2019, Thu
 */
@Component
public interface UserDao {
    User getUser(int id);
}
