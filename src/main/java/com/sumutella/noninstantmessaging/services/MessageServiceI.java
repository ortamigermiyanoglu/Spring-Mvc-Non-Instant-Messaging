package com.sumutella.noninstantmessaging.services;

import com.sumutella.noninstantmessaging.entities.Message;

/**
 * @author sumutella
 * @time 6:17 PM
 * @since 11/21/2019, Thu
 */
public interface MessageServiceI {
    Message getMessage(int id);
}
