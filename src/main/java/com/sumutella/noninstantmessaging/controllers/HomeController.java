package com.sumutella.noninstantmessaging.controllers;

import com.sumutella.noninstantmessaging.entities.Message;
import com.sumutella.noninstantmessaging.entities.User;
import com.sumutella.noninstantmessaging.services.UserService;
import com.sumutella.noninstantmessaging.services.UserServiceI;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author sumutella
 * @time 7:01 PM
 * @since 11/21/2019, Thu
 */
@Controller
public class HomeController {

    @Autowired
    private UserServiceI userService;

    @GetMapping("/home")
    public String showHomePage(Authentication authentication, Model model){
        model.addAttribute("user", userService.getUser(authentication.getName()));
        return "home";
    }

    @GetMapping("/messages")
    public String showMessages(Authentication authentication, Model model){
        User user= userService.getUser(authentication.getName());
        List<Message> messages = userService.getMessages(user);

        Map<User, List<Message>> messagesGrouped=
                messages.stream().collect(Collectors.groupingBy(message -> message.getSender()));

        for(User sender : messagesGrouped.keySet()){
            Collections.sort(messagesGrouped.get(sender), (Message message1, Message message2) ->{
                return message1.getSent().compareTo(message2.getSent());
            });

        }

        model.addAttribute("messagesGroupedAndSorted", messagesGrouped);

        return "messages";
    }
}
