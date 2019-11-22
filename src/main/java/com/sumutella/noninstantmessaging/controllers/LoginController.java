package com.sumutella.noninstantmessaging.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author sumutella
 * @time 6:26 PM
 * @since 11/21/2019, Thu
 */

@Controller()
public class LoginController {

    @GetMapping("/my-login")
    public String showLogin(){
        return "my-login";
    }


}
