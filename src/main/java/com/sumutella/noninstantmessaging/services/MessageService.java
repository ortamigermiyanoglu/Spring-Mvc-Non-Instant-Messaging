package com.sumutella.noninstantmessaging.services;

import com.sumutella.noninstantmessaging.dao.MessageDao;
import com.sumutella.noninstantmessaging.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sumutella
 * @time 6:18 PM
 * @since 11/21/2019, Thu
 */
@Service
public class MessageService implements MessageServiceI {

    @Autowired
    private MessageDao messageDaoImpl;

    @Transactional
    @Override
    public Message getMessage(int id) {
        return messageDaoImpl.getMessage(id);
    }
}
