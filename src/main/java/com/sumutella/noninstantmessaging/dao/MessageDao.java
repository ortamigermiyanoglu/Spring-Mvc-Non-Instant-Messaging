package com.sumutella.noninstantmessaging.dao;

import com.sumutella.noninstantmessaging.entities.Message;
import org.springframework.stereotype.Component;

/**
 * @author sumutella
 * @time 6:13 PM
 * @since 11/21/2019, Thu
 */
@Component
public interface MessageDao {
    Message getMessage(int id);
}
